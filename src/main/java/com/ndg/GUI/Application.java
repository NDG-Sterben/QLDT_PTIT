package com.ndg.GUI;

import com.ndg.ConnectionMySQL.ConnectionSQL;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

public class Application extends JFrame implements IApplication {
    private final JMenuItem reload;
    private final JMenuItem logout;
    private final JMenuItem exit;
    private final JMenuItem info;
    private final JMenuItem update;
    private final JMenuItem feedback;
    private  final LoginUI loginUI;

    public Application() {
        loginUI = new LoginUI(-1);

        this.setTitle(appName);
        this.setSize(width, height);
        try {
            this.setIconImage(new ImageIcon(ImageIO.read(new File(path_file_icon))).getImage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu menu = new JMenu("Menu");

        reload = new JMenuItem("Reload");
        logout = new JMenuItem("Đăng xuất");
        exit = new JMenuItem("Thoát");

        JMenu help = new JMenu("Help");
        feedback = new JMenuItem("Phản hồi");
        info = new JMenuItem("Thông tin");
        update = new JMenuItem("Cập nhật");

        menu.add(reload);
        menu.add(logout);
        menu.add(exit);

        help.add(info);
        help.add(feedback);
        help.add(update);

        menuBar.add(menu);
        menuBar.add(help);

        getContentPane().add(loginUI);

        addEvents();
    }

    private void addEvents() {
        reload.addActionListener(e -> System.out.println("Reloading ..."));



        logout.addActionListener(e -> {
            System.out.println();
            int choose = JOptionPane.showConfirmDialog(
                    new JPanel(),
                    "Bạn có muốn đăng xuất không?",
                    "Information",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE
            );

            if (choose == JOptionPane.YES_OPTION) {
                getContentPane().removeAll();
                getContentPane().add(new LoginUI(-1));
                getContentPane().revalidate();
                getContentPane().repaint();
                ConnectionSQL.checkStatus(loginUI.getIdLogin(), false);
            }
        });




        exit.addActionListener(e -> {
            int choose = JOptionPane.showConfirmDialog(
                    new JPanel(),
                    "Bạn có muốn thoát chương trình không?",
                    "Warning",
                    JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE
            );

            if (choose == JOptionPane.YES_OPTION) {
                ConnectionSQL.checkStatus(loginUI.getIdLogin(), false);
                System.exit(1);
            }
        });




        info.addActionListener(e -> JOptionPane.showMessageDialog(
                new JPanel(),
                """
                        Chào mừng bạn đến với phần mềm PTIT demo.
                        Vui lòng liên hệ admin để biết thêm thông tin chi tiết.
                        Github: https://github.com/NDG-Sterben
                        Beta Version: 1.0.0
                        """,
                "Information",
                JOptionPane.INFORMATION_MESSAGE
        ));



        feedback.addActionListener( e -> {
            if (loginUI.getIdLogin() == -1) {
                JOptionPane.showMessageDialog(
                        new JOptionPane(),
                        "Bạn cần đăng nhập trước khi để lại phản hồi",
                        "Information",
                        JOptionPane.INFORMATION_MESSAGE
                );
            } else {
                new FeedBack(this).init();
            }
        });



        update.addActionListener(e -> JOptionPane.showMessageDialog(
                new JOptionPane(),
                "Chức năng đang được cập nhật",
                "Information",
                JOptionPane.INFORMATION_MESSAGE
        ));


        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int choice = JOptionPane.showConfirmDialog(
                        new JPanel(),
                        "Bạn có muốn thoát không?",
                        "Warning",
                        JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE
                );
                if (choice == JOptionPane.YES_OPTION) {
                    System.out.println("Exit Program Successful");
                    if (ConnectionSQL.connection != null) {
                        ConnectionSQL.checkStatus(loginUI.getIdLogin(), false);
                    }
                    System.exit(0);
                }
            }
        });
    }


    @Override
    public void setDefaultCloseOperation(int operation) {
        if (ConnectionSQL.connection != null) {
            ConnectionSQL.checkStatus(loginUI.getIdLogin(), false);
        }
        System.out.println("Exit Program Successful");
        super.setDefaultCloseOperation(operation);
    }
}

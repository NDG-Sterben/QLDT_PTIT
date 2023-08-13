package com.ndg.GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Application extends JFrame implements IApplication {
    private final JMenuItem reload;
    private final JMenuItem logout;
    private final JMenuItem exit;
    private final JMenuItem info;
    private final JMenuItem update;

    public Application() {
        LoginUI loginUI = new LoginUI(-1);

        this.setTitle(appName);
        this.setSize(width, height);
        try {
            this.setIconImage(new ImageIcon(ImageIO.read(new File(path_file_icon))).getImage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu menu = new JMenu("Menu");

        reload = new JMenuItem("Reload");
        logout = new JMenuItem("Đăng xuất");
        exit = new JMenuItem("Thoát");

        JMenu help = new JMenu("Help");
        info = new JMenuItem("Thông tin");
        update = new JMenuItem("Cập nhật");

        menu.add(reload);
        menu.add(logout);
        menu.add(exit);

        help.add(info);
        help.add(update);

        menuBar.add(menu);
        menuBar.add(help);

        getContentPane().add(loginUI);

        addEvents();
    }

    private void addEvents() {
        reload.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Reloading ...");
            }
        });


        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int choose = JOptionPane.showConfirmDialog(
                        new JPanel(),
                        "Bạn có muốn đăng xuất không?",
                        "Thông báo",
                        JOptionPane.OK_CANCEL_OPTION
                );

                if (choose == JOptionPane.YES_OPTION) {
                    getContentPane().removeAll();
                    getContentPane().add(new LoginUI(-1));
                    getContentPane().revalidate();
                    getContentPane().repaint();
                }
            }
        });


        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int choose = JOptionPane.showConfirmDialog(
                        new JPanel(),
                        "Bạn có muốn thoát chương trình không?",
                        "Cảnh báo",
                        JOptionPane.YES_NO_OPTION
                );

                if (choose == JOptionPane.YES_OPTION) {
                    System.exit(1);
                }
            }
        });

        info.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(
                        new JPanel(),
                        """
                                Chào mừng bạn đến với phần mềm PTIT demo.
                                Vui lòng liên hệ admin để biết thêm thông tin chi tiết.
                                Github: https://github.com/NDG-Sterben
                                Beta Version: 1.0.0
                                """,
                        "Thông tin",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        });


        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(
                        new JOptionPane(),
                        "Chức năng đang được cập nhật",
                        "Thông tin",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        });
    }
}

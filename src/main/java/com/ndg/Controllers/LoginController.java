package com.ndg.Controllers;

import com.ndg.ConnectionMySQL.ConnectionSQL;
import com.ndg.GUI.LoginUI;
import com.ndg.GUI.MainProgram;
import org.jetbrains.annotations.NotNull;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class LoginController {
    public LoginController(@NotNull LoginUI loginUI) {
        loginUI.getButtonLogin().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (ConnectionSQL.connection == null) {
                    JOptionPane.showMessageDialog(
                            new JPanel(),
                            "Không thể kết nối với server!!!\nVui lòng kiểm tra lại mạng",
                            "Lỗi",
                            JOptionPane.ERROR_MESSAGE
                    );
                    return;
                }

                if (loginUI.getInputUsername().equals("") || loginUI.getInputPassword().equals("")) {
                    JOptionPane.showMessageDialog(
                            new JPanel(),
                            "Username or password could not blank",
                            "Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                    return;
                }

                loginUI.setIdLogin(ConnectionSQL.login(loginUI.getInputUsername(), loginUI.getInputPassword()));
                if (loginUI.getIdLogin() != -1) {
                    JOptionPane.showMessageDialog(
                            new JPanel(),
                            "Login Successful",
                            "Information",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                    ConnectionSQL.checkStatus(loginUI.getIdLogin(), true);
                    loginUI.removeAll();
                    loginUI.setBackground(new Color(255, 255, 255));
                    MainProgram mainProgram = new MainProgram(loginUI.getIdLogin());
                    mainProgram.show(loginUI);
                    System.out.println("Login control: " + mainProgram.getIdLogin());
                    loginUI.revalidate();
                    loginUI.repaint();
                }
                else {
                    JOptionPane.showMessageDialog(
                            new JPanel(),
                            "Username or password invalid",
                            "Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        });



        loginUI.getButtonSignup().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    Desktop.getDesktop().browse(new URI(loginUI.getLinkPageRegister()));
                } catch (IOException | URISyntaxException ex) {
                    JOptionPane.showMessageDialog(
                            new JPanel(),
                            "Cannot reach page",
                            "Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        });
    }
}

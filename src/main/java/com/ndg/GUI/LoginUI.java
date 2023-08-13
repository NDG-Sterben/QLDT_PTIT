package com.ndg.GUI;

import com.ndg.Controllers.LoginController;
import com.ndg.SubFunction.ImageProcessing;
import org.jetbrains.annotations.NotNull;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Font;
import java.awt.Cursor;

public class LoginUI extends ParentPanel {
    private final JButton buttonLogin, buttonSignup;
    private final JLabel logo, labelUsername, labelPassword;
    private final JTextField txtUsername;
    private final JPasswordField txtPassword;

    public LoginUI(int idLogin) {
        super(width, height, idLogin);
        int getWidthImage = ImageProcessing.getWidthImage(path_file_logo);
        int getHeightImage = ImageProcessing.getHeightImage(path_file_logo);
        float scale = 1.5f;

        this.setLayout(null);
        this.setBackground(new Color(200, 60, 40));

        logo = new JLabel(ImageProcessing.scaleImage(
                path_file_logo,
                (int) (getWidthImage * scale),
                (int) (getHeightImage * scale)
        ));
        logo.setBounds(
                (int) ((width - getWidthImage * scale) / 2),
                (int) (height * 0.2),
                (int) (getWidthImage * scale),
                (int) (getHeightImage * scale)
        );

        labelUsername = new JLabel("Tài khoản");
        labelUsername.setBounds(
                logo.getX() + 80,
                logo.getY() + logo.getHeight() - 10,
                default_width_component - 50,
                default_height_component
        );
        labelUsername.setForeground(Color.white);
        labelUsername.setFont(new Font(fontName, Font.BOLD, fontSize));

        labelPassword = new JLabel("Mật khẩu");
        labelPassword.setBounds(
                labelUsername.getX(),
                labelUsername.getY() + 50,
                default_width_component - 50,
                default_height_component
        );
        labelPassword.setForeground(Color.white);
        labelPassword.setFont(new Font(fontName, Font.BOLD, fontSize));

        txtUsername = new JTextField(30);
        txtUsername.setBounds(
                labelUsername.getX() + 100,
                labelUsername.getY(),
                default_width_component,
                default_height_component
        );
        txtUsername.setFont(new Font(fontName, Font.BOLD, fontSize));

        txtPassword = new JPasswordField(30);
        txtPassword.setBounds(
                txtUsername.getX(),
                labelPassword.getY(),
                default_width_component,
                default_height_component
        );
        txtPassword.setEchoChar('*');
        txtPassword.setFont(new Font(fontName, Font.BOLD, fontSize));

        buttonLogin = new JButton("Đăng nhập");
        buttonLogin.setBounds(
                labelPassword.getX(),
                labelPassword.getY() + 70,
                default_width_component - 35,
                default_height_component
        );
        buttonLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
        buttonLogin.setFont(new Font(fontName, Font.BOLD, fontSize));

        buttonSignup = new JButton("Đăng kí");
        buttonSignup.setBounds(
                buttonLogin.getX() + 137,
                buttonLogin.getY(),
                buttonLogin.getWidth(),
                buttonLogin.getHeight()
        );
        buttonSignup.setCursor(new Cursor(Cursor.HAND_CURSOR));
        buttonSignup.setFont(new Font(fontName, Font.BOLD, fontSize));

        add(logo);
        add(labelUsername);
        add(labelPassword);
        add(txtUsername);
        add(txtPassword);
        add(buttonLogin);
        add(buttonSignup);

        txtUsername.setText("b20dctm105");
        txtPassword.setText("@Sterben2810");
        new LoginController(this);
    }


    @Override
    public void show(@NotNull JPanel panel) {
        panel.add(logo);
        panel.add(labelUsername);
        panel.add(labelPassword);
        panel.add(txtUsername);
        panel.add(txtPassword);
        panel.add(buttonLogin);
        panel.add(buttonSignup);
    }

    public JButton getButtonLogin() {
        return buttonLogin;
    }

    public JButton getButtonSignup() {
        return buttonSignup;
    }

    public String getInputUsername() {
        return txtUsername.getText().trim();
    }

    public String getInputPassword() {
        return String.valueOf(txtPassword.getPassword());
    }

    public String getLinkPageRegister() {
        return link_page_register;
    }
}

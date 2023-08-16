package com.ndg.GUI;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public abstract class ParentPanel extends JPanel implements IApplication {
    private int idLogin = -1;
    private final JPanel footer;

    public ParentPanel(int widthPanel, int heightPanel, int idLogin) {
        this.idLogin = idLogin;

        JLabel lbFooter = new JLabel("CopyRight @NDG by Nguyen Thanh Trung | Học viện Công nghệ Bưu chính viễn thông");
        lbFooter.setSize(new Dimension(500, default_height_component));
        lbFooter.setForeground(Color.white);

        footer = new JPanel(new FlowLayout());
        footer.setBounds(
                0,
                heightPanel - default_height_component - 60,
                widthPanel,
                lbFooter.getHeight()
        );
        footer.add(lbFooter);
        footer.setBackground(Color.red);


    }
    public void show(@NotNull JPanel panel) {
        panel.add(footer);
    }

    public int getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(int idLogin) {
        this.idLogin = idLogin;
    }

    public JPanel getFooter() {return footer;}
}

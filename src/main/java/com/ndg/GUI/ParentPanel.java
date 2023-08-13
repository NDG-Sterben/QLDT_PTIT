package com.ndg.GUI;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public abstract class ParentPanel extends JPanel implements IApplication {
    private final JLabel lbFooter;
    private int idLogin = -1;

    public ParentPanel(int widthPanel, int heightPanel, int idLogin) {
        this.idLogin = idLogin;
        lbFooter = new JLabel("CopyRight @NDG by Nguyen Thanh Trung | Học viện Công nghệ Bưu chính viễn thông");
        lbFooter.setBounds(
                0, (int) (heightPanel * 0.90 - 10),
                widthPanel,
                default_height_component
        );
        lbFooter.setHorizontalAlignment(SwingConstants.CENTER);

    }
    public void show(@NotNull JPanel panel) {
        panel.add(lbFooter);
    }

    public int getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(int idLogin) {
        this.idLogin = idLogin;
    }
}

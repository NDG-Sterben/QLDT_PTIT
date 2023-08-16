package com.ndg.entities;

import com.ndg.SubFunction.ImageProcessing;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class OtherNotification extends JPanel {
    private final JLabel headerNotify;
    private final JLabel timeNotify;

    public OtherNotification(@NotNull JPanel panel, int x, int y, int number) {
        super();
        this.setLayout(null);
        this.setBounds(x, y, panel.getWidth(), panel.getHeight() / number);
        String pathIcon = "./assets/next.png";
        int widthIcon = ImageProcessing.getWidthImage(pathIcon);
        int height = ImageProcessing.getHeightImage(pathIcon);
        float scale = 0.1F;

        JLabel icon = new JLabel(ImageProcessing.scaleImage(pathIcon, (int) (widthIcon * scale), (int) (height * scale)));
        icon.setBounds(0, 0, (int) (this.getWidth() * 0.05), this.getHeight());


        headerNotify = new JLabel("Unknown");
        headerNotify.setBounds(
                icon.getWidth(),
                2,
                (int) (this.getWidth() * 0.8),
                this.getHeight() - 2 * 2);


        timeNotify = new JLabel("16/08/2023");
        timeNotify.setBounds((int) (this.getWidth() * 0.9), 0,
                (int) (this.getWidth() * 0.1),
                this.getHeight()
        );
        timeNotify.setHorizontalAlignment(SwingConstants.RIGHT);


        this.add(icon);
        this.add(headerNotify);
        this.add(timeNotify);
        panel.add(this);
    }

    public void setTextHeader(String header) {
        this.headerNotify.setText(header);
    }

    public void setTimeNotify(String time) {
        this.timeNotify.setText(time);
    }
}

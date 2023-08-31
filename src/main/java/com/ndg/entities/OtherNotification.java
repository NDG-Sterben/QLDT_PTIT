package com.ndg.entities;

import com.ndg.SubFunction.ImageProcessing;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OtherNotification extends JPanel {
    private final JLabel headerNotify;
    private final JLabel timeNotify;
    private final int idNotification;

    public OtherNotification(@NotNull JPanel panel, int idNotification, int x, int y, int number) {
        super();
        this.setLayout(null);
        this.setBounds(x, y, panel.getWidth(), panel.getHeight() / number);
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        String pathIcon = "./assets/next.png";
        this.idNotification = idNotification;
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

        addEvents();
    }

    public void setTextHeader(String header) {
        this.headerNotify.setText(header);
    }

    public void setTimeNotify(String time) {
        this.timeNotify.setText(time);
    }

    private void addEvents() {
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println(idNotification);
            }
        });
    }
}

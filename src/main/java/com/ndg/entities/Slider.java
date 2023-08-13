package com.ndg.entities;

import com.ndg.GUI.IApplication;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class Slider extends Thread implements IApplication {
    private final JLabel lbPTIT, lbPTIT1;
    private final int maxWidth, maxHeight;

    public Slider(@NotNull JPanel panel) {
        maxWidth = panel.getWidth();
        maxHeight = panel.getHeight();

        lbPTIT = new JLabel("PTIT - Posts and Telecommunications Institute of Technology");
        lbPTIT.setFont(new Font(fontName, Font.BOLD, fontSize + 12));
        lbPTIT.setBounds(panel.getX(), panel.getY(), panel.getWidth(), panel.getHeight());
        lbPTIT.setForeground(Color.white);
        lbPTIT.setHorizontalAlignment(SwingConstants.CENTER);

        lbPTIT1 = new JLabel("PTIT - Posts and Telecommunications Institute of Technology");
        lbPTIT1.setFont(new Font(fontName, Font.BOLD, fontSize + 12));
        lbPTIT1.setBounds(maxWidth, panel.getY(), panel.getWidth(), panel.getHeight());
        lbPTIT1.setForeground(Color.white);
        lbPTIT1.setHorizontalAlignment(SwingConstants.CENTER);

        panel.add(lbPTIT);
        panel.add(lbPTIT1);
    }

    @Override
    public void run() {
        while (true) {
            lbPTIT.setBounds(lbPTIT.getX() - 1, lbPTIT.getY(), maxWidth, maxHeight);
            lbPTIT1.setBounds(lbPTIT1.getX() - 1, lbPTIT1.getY(), maxWidth, maxHeight);

            try {
                TimeUnit.MILLISECONDS.sleep(20);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if (lbPTIT.getX() <= -maxWidth) lbPTIT.setBounds(maxWidth, lbPTIT.getY(), maxWidth, maxHeight);
            if (lbPTIT1.getX() <= -maxWidth) lbPTIT1.setBounds(maxWidth, lbPTIT.getY(), maxWidth, maxHeight);
        }
    }
}

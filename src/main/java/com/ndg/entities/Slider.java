package com.ndg.entities;

import com.ndg.GUI.IApplication;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class Slider extends Thread implements IApplication {
    private final JLabel lbPLetter, lbTLetter, lbILetter, lbT1Letter;
    private final int maxWidth = 20;

    public Slider(@NotNull JPanel panel) {
        lbPLetter = new JLabel("P");
        lbPLetter.setFont(new Font(fontName, Font.BOLD, fontSize + 12));
        lbPLetter.setForeground(Color.white);
        lbPLetter.setBounds(panel.getWidth() / 2 - 2 * maxWidth, 0, maxWidth, panel.getHeight());
        lbPLetter.setHorizontalAlignment(SwingConstants.CENTER);

        lbTLetter = new JLabel("T");
        lbTLetter.setFont(new Font(fontName, Font.BOLD, fontSize + 12));
        lbTLetter.setForeground(Color.white);
        lbTLetter.setBounds(lbPLetter.getX() + maxWidth, 0, maxWidth, panel.getHeight());
        lbTLetter.setHorizontalAlignment(SwingConstants.CENTER);

        lbILetter = new JLabel("I");
        lbILetter.setFont(new Font(fontName, Font.BOLD, fontSize + 12));
        lbILetter.setForeground(Color.white);
        lbILetter.setBounds(lbTLetter.getX() + maxWidth, 0, maxWidth, panel.getHeight());
        lbILetter.setHorizontalAlignment(SwingConstants.CENTER);

        lbT1Letter = new JLabel("T");
        lbT1Letter.setFont(new Font(fontName, Font.BOLD, fontSize + 12));
        lbT1Letter.setForeground(Color.white);
        lbT1Letter.setBounds(lbILetter.getX() + maxWidth, 0, maxWidth, panel.getHeight());
        lbT1Letter.setHorizontalAlignment(SwingConstants.CENTER);

        panel.add(lbPLetter);
        panel.add(lbTLetter);
        panel.add(lbILetter);
        panel.add(lbT1Letter);
    }

    @Override
    public void run() {
        while (true) {
            lbPLetter.setBounds(lbPLetter.getX() - 1, 0, maxWidth, 50);
            lbTLetter.setBounds(lbTLetter.getX() - 1, 0, maxWidth, 50);
            lbILetter.setBounds(lbILetter.getX() - 1, 0, maxWidth, 50);
            lbT1Letter.setBounds(lbT1Letter.getX() - 1, 0, maxWidth, 50);

            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if (lbPLetter.getX() < -(maxWidth)) lbPLetter.setBounds(width, 0, maxWidth, 50);
            if (lbTLetter.getX() < -(maxWidth)) lbTLetter.setBounds(width, 0, maxWidth, 50);
            if (lbILetter.getX() < -(maxWidth)) lbILetter.setBounds(width, 0, maxWidth, 50);
            if (lbT1Letter.getX() < -(maxWidth)) lbT1Letter.setBounds(width, 0, maxWidth, 50);
        }
    }
}

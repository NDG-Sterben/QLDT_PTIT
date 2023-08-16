package com.ndg.entities;

import javax.swing.*;

public class Navigation extends JPanel implements Runnable {
    private final int x, y, height, minWidth, maxWidth;
    public Navigation(int x, int y, int height, int minWidth, int maxWidth) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.minWidth = minWidth;
        this.maxWidth = maxWidth;
        this.setBounds(x, y, minWidth, height);
    }


    @Override
    public void run() {
        if (this.getWidth() == maxWidth) {
            while (this.getWidth() > minWidth) this.setBounds(x, y, getWidth() - 10, height);
        } else {
            while (this.getWidth() < maxWidth) this.setBounds(x, y, getWidth() + 10, height);
        }
    }
}

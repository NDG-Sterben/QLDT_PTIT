package com.ndg.SubFunction;

import org.jetbrains.annotations.NotNull;

import javax.swing.ImageIcon;
import java.awt.Image;

public class ImageProcessing {
    public static @NotNull ImageIcon scaleImage(String pathFile, int width, int height) {
        ImageIcon icon = new ImageIcon(pathFile);
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        icon = new ImageIcon(newImg);
        return icon;
    }

    public static int getWidthImage(String pathFile) {
        ImageIcon icon = new ImageIcon(pathFile);
        return icon.getIconWidth();
    }

    public static int getHeightImage(String pathFile) {
        ImageIcon icon = new ImageIcon(pathFile);
        return icon.getIconHeight();
    }
}

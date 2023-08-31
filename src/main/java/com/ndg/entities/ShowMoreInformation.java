package com.ndg.entities;

import org.jetbrains.annotations.NotNull;
import javax.swing.JTextArea;
import javax.swing.JLayeredPane;
import java.awt.Color;
import java.awt.Point;

public class ShowMoreInformation extends JLayeredPane {
    private final JTextArea textArea;

    public ShowMoreInformation (int x, int y) {
        super();
        this.setBounds(x, y, 150, 200);

        textArea = new JTextArea();
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        textArea.setBounds(0, 0, 150, 200);
        textArea.setBackground(Color.black);
        textArea.setForeground(Color.white);

        this.add(textArea, JLayeredPane.POPUP_LAYER);
        this.setVisible(false);
    }



    public void setText(@NotNull Object @NotNull [] objects) {
        textArea.setText("""
                Môn học: %s
                Giảng viên: %s
                Phòng: 201A2""".formatted(objects[0], objects[1]));
    }



    public void showInfo(@NotNull JLabelCustom label) {
        this.setLocation(new Point(
                label.getX() + label.getWidth(),
                label.getY()
        ));
    }
}

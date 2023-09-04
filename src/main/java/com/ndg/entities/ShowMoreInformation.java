package com.ndg.entities;

import org.jetbrains.annotations.NotNull;
import javax.swing.JTextArea;
import javax.swing.JLayeredPane;
import java.awt.*;

public class ShowMoreInformation extends JLayeredPane {
    private final JTextArea textArea;

    public ShowMoreInformation (int x, int y) {
        super();
        this.setBounds(x, y, 150, 200);

        textArea = new JTextArea();
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        textArea.setBounds(0, 0, 150, 200);
        textArea.setBackground(Color.green);
        textArea.setForeground(Color.black);
        textArea.setFont(new Font("Arial", Font.BOLD, 12));

        this.add(textArea, JLayeredPane.POPUP_LAYER);
        this.setVisible(false);
    }



    public void setText(@NotNull Object @NotNull [] objects) {
        textArea.setText("""
                Mã môn học: %s
                Môn học: %s
                Nhóm: %s
                Phòng: %s
                Giảng viên: %s
                Lớp: %s""".formatted(objects[0], objects[1], objects[2], objects[3], objects[4], objects[5]));
    }



    public void showInfo(@NotNull JLabelCustom label) {
        this.setLocation(new Point(
                label.getX() + label.getWidth(),
                label.getY()
        ));
    }
}

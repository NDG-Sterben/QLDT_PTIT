package com.ndg.entities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JLabelCustom extends JLabel {
    private Object[] objects;
    private final ShowMoreInformation showMoreInformation;

    public JLabelCustom(int x, int y, int width, int height, ShowMoreInformation showMoreInformation) {
        super();
        this.setBounds(x, y, width, height);
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setVerticalAlignment(SwingConstants.CENTER);
        this.setBorder(BorderFactory.createLineBorder(Color.red));
        this.showMoreInformation = showMoreInformation;
        addEvents();
    }

    private void addEvents() {
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (!JLabelCustom.this.getText().isEmpty()) {
                    showMoreInformation.setText(objects);
                    if (showMoreInformation.isVisible()) {
                        showMoreInformation.setVisible(false);
                    } else {
                        showMoreInformation.showInfo(JLabelCustom.this);
                        showMoreInformation.setVisible(true);
                    }
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                showMoreInformation.setVisible(false);
            }
        });
    }


    public void setData(Object[] objects) {
        this.objects = objects;
    }

    public Object[] getData() {
        return objects;
    }

}

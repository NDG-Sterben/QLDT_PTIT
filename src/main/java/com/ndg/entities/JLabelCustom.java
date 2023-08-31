package com.ndg.entities;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

public class JLabelCustom extends JLabel {
    private Object[] objects;
    private final ShowMoreInformation showMoreInformation;

    public JLabelCustom(ShowMoreInformation showMoreInformation) {
        super();
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

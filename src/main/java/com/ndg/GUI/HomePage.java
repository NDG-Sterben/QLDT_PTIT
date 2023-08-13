package com.ndg.GUI;

import com.ndg.entities.Slider;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class HomePage extends ParentPanel implements IApplication {
    private final JLabel label;
    private final JPanel slider;

    public HomePage(@NotNull JPanel panel, int idLogin) {
        super(panel.getWidth(), panel.getHeight(), idLogin);

        slider = new JPanel(null);
        slider.setBounds(0, 0, panel.getWidth(), 50);
        slider.setBackground(Color.red);

        Slider slider1 = new Slider(slider);
        slider1.start();

        label = new JLabel("Không có thông báo");
        label.setFont(new Font(fontName, Font.BOLD, fontSize - 2));
        label.setBounds(
                (panel.getWidth() - default_width_component) / 2,
                (panel.getHeight() - default_height_component) / 2,
                default_width_component + 50,
                default_height_component
        );
    }

    @Override
    public void show(@NotNull JPanel panel) {
        super.show(panel);
        panel.add(label);
        panel.add(slider);
    }
}

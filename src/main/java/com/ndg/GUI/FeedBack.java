package com.ndg.GUI;

import com.ndg.Controllers.FeedBackController;

import javax.swing.*;
import java.awt.*;

public class FeedBack extends JDialog implements IApplication {
    private final JTextField subject;
    private final JTextArea content;
    private final JButton buttonOK, buttonCancel;
    private final int width = 500;
    private final int height = 600;

    public FeedBack(JFrame frame) {
        super(frame, "Phản hồi", true);
        this.setLayout(null);

        JLabel lbSubject = new JLabel("Chủ đề");
        lbSubject.setBounds(50, 20, default_width_component, default_height_component);

        subject = new JTextField();
        subject.setBounds(lbSubject.getX(), lbSubject.getY() + lbSubject.getHeight(), width - 50 * 2, default_height_component);

        JLabel lbContent = new JLabel("Nội dung");
        lbContent.setBounds(
                subject.getX(),
                subject.getY() + subject.getHeight() + 20,
                default_width_component,
                default_height_component
        );

        content = new JTextArea();
        content.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        content.setWrapStyleWord(true);
        content.setLineWrap(true);
        content.setBounds(
                lbContent.getX(),
                lbContent.getY() + lbContent.getHeight(),
                subject.getWidth(),
                (int) (height * 0.5));

        buttonOK = new JButton("Gửi");
        buttonOK.setBounds(
                (content.getWidth() / 2 - default_width_component) / 2 + content.getX(),
                content.getY() + content.getHeight() + 20,
                default_width_component,
                default_height_component
        );

        buttonCancel = new JButton("Hủy");
        buttonCancel.setBounds(
                width - buttonOK.getX() - default_width_component,
                buttonOK.getY(),
                default_width_component,
                default_height_component
        );

        this.add(lbSubject);
        this.add(subject);
        this.add(lbContent);
        this.add(content);
        this.add(buttonOK);
        this.add(buttonCancel);

        new FeedBackController(this);
    }


    public JTextField getSubject() {
        return subject;
    }

    public JTextArea getContent() {
        return content;
    }

    public JButton getButtonOK() {
        return buttonOK;
    }

    public JButton getButtonCancel() {
        return buttonCancel;
    }

    public void init() {
        this.setSize(width, height);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}

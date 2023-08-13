package com.ndg.GUI;

import com.ndg.Controllers.MainProgramController;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class MainProgram extends ParentPanel implements IApplication {
    private final JPanel navigation;
    private final JPanel mainPanel;
    private final JLabel lbHomePage, lbRegisterSubject, lbShowSchedule, lbShowScheduleTest;
    private final JLabel lbShowScheduleReTest, lbShowPoint, lbTuition, lbShowProgramEdu;

    public MainProgram(int idLogin) {
        super(width, height, idLogin);
        this.setLayout(null);

        navigation = new JPanel(null);
        navigation.setBounds(0, 0, width, default_height_component + 10);

        lbHomePage = new JLabel("Trang chủ");
        lbHomePage.setFont(new Font(fontName, Font.BOLD, fontSize - 2));
        lbHomePage.setHorizontalAlignment(SwingConstants.CENTER);
        lbHomePage.setCursor(new Cursor(Cursor.HAND_CURSOR));
        int maxFunction = 8;
        lbHomePage.setBounds(0, 0, width / maxFunction, navigation.getHeight());
        lbHomePage.setOpaque(true);
        lbHomePage.setBackground(Color.cyan);

        lbRegisterSubject = new JLabel("Đăng kí môn học");
        lbRegisterSubject.setFont(new Font(fontName, Font.BOLD, lbHomePage.getFont().getSize()));
        lbRegisterSubject.setHorizontalAlignment(SwingConstants.CENTER);
        lbRegisterSubject.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lbRegisterSubject.setBounds(
                lbHomePage.getX() + lbHomePage.getWidth(),
                lbHomePage.getY(),
                width / maxFunction,
                navigation.getHeight()
        );
        lbRegisterSubject.setOpaque(true);
        lbRegisterSubject.setBackground(Color.cyan);

        lbShowSchedule = new JLabel("Xem lịch học");
        lbShowSchedule.setFont(new Font(fontName, Font.BOLD, lbHomePage.getFont().getSize()));
        lbShowSchedule.setPreferredSize(new Dimension(width / maxFunction, navigation.getHeight()));
        lbShowSchedule.setHorizontalAlignment(SwingConstants.CENTER);
        lbShowSchedule.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lbShowSchedule.setBounds(
                lbRegisterSubject.getX() + lbRegisterSubject.getWidth(),
                lbRegisterSubject.getY(),
                width / maxFunction,
                navigation.getHeight()
        );
        lbShowSchedule.setOpaque(true);
        lbShowSchedule.setBackground(Color.cyan);

        lbShowScheduleTest = new JLabel("Xem lịch thi");
        lbShowScheduleTest.setFont(new Font(fontName, Font.BOLD, lbHomePage.getFont().getSize()));
        lbShowScheduleTest.setPreferredSize(new Dimension(width / maxFunction, navigation.getHeight()));
        lbShowScheduleTest.setHorizontalAlignment(SwingConstants.CENTER);
        lbShowScheduleTest.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lbShowScheduleTest.setBounds(
                lbShowSchedule.getX() + lbShowSchedule.getWidth(),
                lbShowSchedule.getY(),
                width / maxFunction,
                navigation.getHeight()
        );
        lbShowScheduleTest.setOpaque(true);
        lbShowScheduleTest.setBackground(Color.cyan);

        lbShowScheduleReTest = new JLabel("Xem lịch thi lại");
        lbShowScheduleReTest.setFont(new Font(fontName, Font.BOLD, lbHomePage.getFont().getSize()));
        lbShowScheduleReTest.setPreferredSize(new Dimension(width / maxFunction, navigation.getHeight()));
        lbShowScheduleReTest.setHorizontalAlignment(SwingConstants.CENTER);
        lbShowScheduleReTest.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lbShowScheduleReTest.setBounds(
                lbShowScheduleTest.getX() + lbShowScheduleTest.getWidth() - 2,
                lbShowScheduleTest.getY(),
                width / maxFunction,
                navigation.getHeight()
        );
        lbShowScheduleReTest.setOpaque(true);
        lbShowScheduleReTest.setBackground(Color.cyan);


        lbShowPoint = new JLabel("Xem điểm");
        lbShowPoint.setFont(new Font(fontName, Font.BOLD, lbHomePage.getFont().getSize()));
        lbShowPoint.setPreferredSize(new Dimension(width / maxFunction, navigation.getHeight()));
        lbShowPoint.setHorizontalAlignment(SwingConstants.CENTER);
        lbShowPoint.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lbShowPoint.setBounds(
                lbShowScheduleReTest.getX() + lbShowScheduleReTest.getWidth(),
                lbShowScheduleReTest.getY(),
                width / maxFunction,
                navigation.getHeight()
        );
        lbShowPoint.setOpaque(true);
        lbShowPoint.setBackground(Color.cyan);


        lbTuition = new JLabel("Xem học phí");
        lbTuition.setFont(new Font(fontName, Font.BOLD, lbHomePage.getFont().getSize()));
        lbTuition.setPreferredSize(new Dimension(width / maxFunction, navigation.getHeight()));
        lbTuition.setHorizontalAlignment(SwingConstants.CENTER);
        lbTuition.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lbTuition.setBounds(
                lbShowPoint.getX() + lbShowPoint.getWidth(),
                lbShowPoint.getY(),
                width / maxFunction,
                navigation.getHeight()
        );
        lbTuition.setOpaque(true);
        lbTuition.setBackground(Color.cyan);


        lbShowProgramEdu = new JLabel("Xem CTĐT");
        lbShowProgramEdu.setFont(new Font(fontName, Font.BOLD, lbHomePage.getFont().getSize()));
        lbShowProgramEdu.setPreferredSize(new Dimension(width / maxFunction, navigation.getHeight()));
        lbShowProgramEdu.setHorizontalAlignment(SwingConstants.CENTER);
        lbShowProgramEdu.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lbShowProgramEdu.setBounds(
                lbTuition.getX() + lbTuition.getWidth(),
                lbTuition.getY(),
                width / maxFunction,
                navigation.getHeight()
        );
        lbShowProgramEdu.setOpaque(true);
        lbShowProgramEdu.setBackground(Color.cyan);

        navigation.add(lbHomePage);
        navigation.add(lbRegisterSubject);
        navigation.add(lbShowSchedule);
        navigation.add(lbShowScheduleTest);
        navigation.add(lbShowScheduleReTest);
        navigation.add(lbShowPoint);
        navigation.add(lbTuition);
        navigation.add(lbShowProgramEdu);

        mainPanel = new JPanel(null);
        mainPanel.setBounds(0, navigation.getHeight(), width, height - navigation.getHeight());

        new HomePage(mainPanel, this.getIdLogin()).show(mainPanel);

        add(navigation);
        add(mainPanel);

        new MainProgramController(this);
    }

    @Override
    public void show(@NotNull JPanel panel) {
        panel.add(navigation);
        panel.add(mainPanel);
    }

    public JLabel getLbHomePage() {
        return lbHomePage;
    }

    public JLabel getLbRegisterSubject() {
        return lbRegisterSubject;
    }

    public JLabel getLbShowPoint() {
        return lbShowPoint;
    }

    public JLabel getLbShowProgramEdu() {
        return lbShowProgramEdu;
    }

    public JLabel getLbShowSchedule() {
        return lbShowSchedule;
    }

    public JLabel getLbShowScheduleReTest() {
        return lbShowScheduleReTest;
    }

    public JLabel getLbShowScheduleTest() {
        return lbShowScheduleTest;
    }

    public JLabel getLbTuition() {
        return lbTuition;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}

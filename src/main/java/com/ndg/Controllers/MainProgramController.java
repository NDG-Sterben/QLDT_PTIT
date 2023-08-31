package com.ndg.Controllers;

import com.ndg.GUI.*;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

public class MainProgramController {
    public MainProgramController(@NotNull MainProgram mainProgram) {
        mainProgram.getLbHomePage().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                mainProgram.getMainPanel().removeAll();
                new HomePage(mainProgram.getMainPanel(), mainProgram.getIdLogin()).show(mainProgram.getMainPanel());
                System.out.println("Home Page Frame: " + mainProgram.getIdLogin());
                mainProgram.getMainPanel().revalidate();
                mainProgram.getMainPanel().repaint();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                mainProgram.getLbHomePage().setOpaque(true);
                mainProgram.getLbHomePage().setBackground(Color.red);
                mainProgram.getLbHomePage().setForeground(Color.white);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                mainProgram.getLbHomePage().setOpaque(true);
                mainProgram.getLbHomePage().setBackground(Color.cyan);
                mainProgram.getLbHomePage().setForeground(Color.black);
            }
        });


        mainProgram.getLbRegisterSubject().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                mainProgram.getMainPanel().removeAll();
                new RegisterSubject(mainProgram.getMainPanel(), mainProgram.getIdLogin()).show(mainProgram.getMainPanel());
                System.out.println("Register Subject Frame: " + mainProgram.getIdLogin());
                mainProgram.getMainPanel().revalidate();
                mainProgram.getMainPanel().repaint();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                mainProgram.getLbRegisterSubject().setBackground(Color.red);
                mainProgram.getLbRegisterSubject().setForeground(Color.white);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                mainProgram.getLbRegisterSubject().setBackground(Color.cyan);
                mainProgram.getLbRegisterSubject().setForeground(Color.black);
            }
        });


        mainProgram.getLbShowSchedule().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                mainProgram.getMainPanel().removeAll();
                new ShowSchedule(mainProgram.getMainPanel(), mainProgram.getIdLogin()).show(mainProgram.getMainPanel());
                mainProgram.getMainPanel().revalidate();
                mainProgram.getMainPanel().repaint();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                mainProgram.getLbShowSchedule().setBackground(Color.red);
                mainProgram.getLbShowSchedule().setForeground(Color.white);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                mainProgram.getLbShowSchedule().setBackground(Color.cyan);
                mainProgram.getLbShowSchedule().setForeground(Color.black);
            }
        });


        mainProgram.getLbShowScheduleTest().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                mainProgram.getMainPanel().removeAll();
                new ShowScheduleTest(mainProgram.getMainPanel(), mainProgram.getIdLogin()).show(mainProgram.getMainPanel());
                System.out.println("Schedule Test Frame: " + mainProgram.getIdLogin());
                mainProgram.getMainPanel().revalidate();
                mainProgram.getMainPanel().repaint();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                mainProgram.getLbShowScheduleTest().setBackground(Color.red);
                mainProgram.getLbShowScheduleTest().setForeground(Color.white);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                mainProgram.getLbShowScheduleTest().setBackground(Color.cyan);
                mainProgram.getLbShowScheduleTest().setForeground(Color.black);
            }
        });

        mainProgram.getLbShowScheduleReTest().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                mainProgram.getMainPanel().removeAll();
                new ShowScheduleReTest(mainProgram.getMainPanel(), mainProgram.getIdLogin()).show(mainProgram.getMainPanel());
                System.out.println("Schedule ReTest Frame: " + mainProgram.getIdLogin());
                mainProgram.getMainPanel().revalidate();
                mainProgram.getMainPanel().repaint();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                mainProgram.getLbShowScheduleReTest().setBackground(Color.red);
                mainProgram.getLbShowScheduleReTest().setForeground(Color.white);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                mainProgram.getLbShowScheduleReTest().setBackground(Color.cyan);
                mainProgram.getLbShowScheduleReTest().setForeground(Color.black);
            }
        });


        mainProgram.getLbShowPoint().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                mainProgram.getMainPanel().removeAll();
                new ShowPoint(mainProgram.getMainPanel(), mainProgram.getIdLogin()).show(mainProgram.getMainPanel());
                System.out.println("Show Point Frame: " + mainProgram.getIdLogin());
                mainProgram.getMainPanel().revalidate();
                mainProgram.getMainPanel().repaint();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                mainProgram.getLbShowPoint().setBackground(Color.red);
                mainProgram.getLbShowPoint().setForeground(Color.white);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                mainProgram.getLbShowPoint().setBackground(Color.cyan);
                mainProgram.getLbShowPoint().setForeground(Color.black);
            }
        });


        mainProgram.getLbTuition().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                mainProgram.getMainPanel().removeAll();
                new ShowTuition(mainProgram.getMainPanel(), mainProgram.getIdLogin()).show(mainProgram.getMainPanel());
                System.out.println("Show Tuition Frame: " + mainProgram.getIdLogin());
                mainProgram.getMainPanel().revalidate();
                mainProgram.getMainPanel().repaint();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                mainProgram.getLbTuition().setBackground(Color.red);
                mainProgram.getLbTuition().setForeground(Color.white);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                mainProgram.getLbTuition().setBackground(Color.cyan);
                mainProgram.getLbTuition().setForeground(Color.black);
            }
        });


        mainProgram.getLbShowProgramEdu().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                mainProgram.getMainPanel().removeAll();
                new ShowProgramEdu(mainProgram.getMainPanel(), mainProgram.getIdLogin()).show(mainProgram.getMainPanel());
                System.out.println("Education Programming Frame: " + mainProgram.getIdLogin());
                mainProgram.getMainPanel().revalidate();
                mainProgram.getMainPanel().repaint();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                mainProgram.getLbShowProgramEdu().setBackground(Color.red);
                mainProgram.getLbShowProgramEdu().setForeground(Color.white);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                mainProgram.getLbShowProgramEdu().setBackground(Color.cyan);
                mainProgram.getLbShowProgramEdu().setForeground(Color.black);
            }
        });
    }
}

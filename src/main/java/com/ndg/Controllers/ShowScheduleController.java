package com.ndg.Controllers;

import com.ndg.ConnectionMySQL.ConnectionSQL;
import com.ndg.GUI.ShowSchedule;
import com.ndg.SubFunction.DivideSubjectName;
import org.jetbrains.annotations.NotNull;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Vector;

public class ShowScheduleController {
    public ShowScheduleController(@NotNull ShowSchedule showSchedule) {

        /*
        *
        * */
        Vector<String> dataSchedule = ConnectionSQL.getYearNH(showSchedule.getIdLogin());
        for (String str : dataSchedule) {
            showSchedule.getComboBoxSchoolYear().addItem(str);
        }

        showSchedule.getComboBoxSchoolYear().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(showSchedule.getComboBoxSchoolYear().getSelectedItem());
            }
        });

        ArrayList<Object[]> scheduleClasses = ConnectionSQL.scheduleClasses(showSchedule.getIdLogin());

        for (Object[] e : scheduleClasses) {
            String format = "lbT%cK%c";
            String thu = e[6].toString();
            String tietBD = e[7].toString();

            String subName = DivideSubjectName.divideSub(e[1].toString());
            if (thu.startsWith("0")) {
                showSchedule.getAllComponents().get(format.formatted(thu.charAt(2), tietBD.charAt(2))).setText(subName);
                showSchedule.getAllComponents().get(format.formatted(thu.charAt(2), tietBD.charAt(2))).setData(e);
            } else if (thu.endsWith("0")) {
                showSchedule.getAllComponents().get(format.formatted(thu.charAt(0), tietBD.charAt(0))).setText(subName);
                showSchedule.getAllComponents().get(format.formatted(thu.charAt(0), tietBD.charAt(0))).setData(e);
            } else {
                showSchedule.getAllComponents().get(format.formatted(thu.charAt(0), tietBD.charAt(0))).setText(subName);
                showSchedule.getAllComponents().get(format.formatted(thu.charAt(2), tietBD.charAt(2))).setText(subName);
                showSchedule.getAllComponents().get(format.formatted(thu.charAt(0), tietBD.charAt(0))).setData(e);
                showSchedule.getAllComponents().get(format.formatted(thu.charAt(2), tietBD.charAt(2))).setData(e);
            }
        }
    }
}

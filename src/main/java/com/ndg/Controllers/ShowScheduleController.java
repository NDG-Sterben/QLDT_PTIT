package com.ndg.Controllers;

import com.ndg.ConnectionMySQL.ConnectionSQL;
import com.ndg.GUI.ShowSchedule;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;

public class ShowScheduleController {
    public ShowScheduleController(@NotNull ShowSchedule showSchedule) {
        ArrayList<Object[]> scheduleClasses = ConnectionSQL.scheduleClasses(showSchedule.getIdLogin());

        for (Object[] e : scheduleClasses) {
            String format = "lbT%cK%c";
            String thu = e[2].toString();
            String tietBD = e[3].toString();

            if (thu.startsWith("0")) {
                showSchedule.getAllComponents().get(format.formatted(thu.charAt(2), tietBD.charAt(2))).setText(e[0].toString());
                showSchedule.getAllComponents().get(format.formatted(thu.charAt(2), tietBD.charAt(2))).setData(e);
            } else if (thu.endsWith("0")) {
                showSchedule.getAllComponents().get(format.formatted(thu.charAt(0), tietBD.charAt(0))).setText(e[0].toString());
                showSchedule.getAllComponents().get(format.formatted(thu.charAt(0), tietBD.charAt(0))).setData(e);
            } else {
                showSchedule.getAllComponents().get(format.formatted(thu.charAt(0), tietBD.charAt(0))).setText(e[0].toString());
                showSchedule.getAllComponents().get(format.formatted(thu.charAt(2), tietBD.charAt(2))).setText(e[0].toString());
                showSchedule.getAllComponents().get(format.formatted(thu.charAt(0), tietBD.charAt(0))).setData(e);
                showSchedule.getAllComponents().get(format.formatted(thu.charAt(2), tietBD.charAt(2))).setData(e);
            }
        }
    }
}

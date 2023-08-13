package com.ndg.Controllers;

import com.ndg.ConnectionMySQL.ConnectionSQL;
import com.ndg.GUI.ShowProgramEdu;
import org.jetbrains.annotations.NotNull;

import java.util.Vector;

public class ProgramEduController {
    public ProgramEduController(@NotNull ShowProgramEdu showProgramEdu) {
        showProgramEdu.getComboBoxMajor().addItem(
                ConnectionSQL.getNganh(showProgramEdu.getIdLogin())
        );

        Vector<Object[]> getAllSubject = ConnectionSQL.getAllSubjectInMajor(showProgramEdu.getIdLogin());
        for (Object[] objects : getAllSubject) {
            showProgramEdu.getTableModel().addRow(objects);
        }
    }
}

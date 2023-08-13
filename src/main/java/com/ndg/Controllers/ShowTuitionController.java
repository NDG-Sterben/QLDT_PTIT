package com.ndg.Controllers;

import com.ndg.ConnectionMySQL.ConnectionSQL;
import com.ndg.GUI.ShowTuition;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class ShowTuitionController {
    public ShowTuitionController(@NotNull ShowTuition showTuition) {
        HashMap<String, String> info = ConnectionSQL.getInformationLogin(showTuition.getIdLogin());
        showTuition.getLbShowStuCode().setText(info.get("studentCode"));
        showTuition.getLbShowFullName().setText(info.get("studentName"));
        showTuition.getLbShowSex().setText(info.get("sex"));
        showTuition.getLbShowDOB().setText(info.get("dob"));
        showTuition.getLbShowAddress().setText(info.get("address"));
        showTuition.getLbShowCLass().setText(info.get("classCode"));
        showTuition.getLbShowMajor().setText(info.get("TenNganh"));
        showTuition.getLbShowKhoa().setText(info.get("TenKhoa"));
    }
}

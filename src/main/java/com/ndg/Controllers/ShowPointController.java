package com.ndg.Controllers;

import com.ndg.ConnectionMySQL.ConnectionSQL;
import com.ndg.GUI.ShowPoint;
import org.jetbrains.annotations.NotNull;
import java.util.HashMap;
import java.util.Vector;

public class ShowPointController {
    public ShowPointController(@NotNull ShowPoint showPoint) {
        HashMap<String, String> info = ConnectionSQL.getInformationLogin(showPoint.getIdLogin());
        showPoint.getLbShowStuCode().setText(info.get("studentCode"));
        showPoint.getLbShowFullName().setText(info.get("studentName"));
        showPoint.getLbShowSex().setText(info.get("sex"));
        showPoint.getLbShowDOB().setText(info.get("dob"));
        showPoint.getLbShowAddress().setText(info.get("address"));
        showPoint.getLbShowCLass().setText(info.get("classCode"));
        showPoint.getLbShowMajor().setText(info.get("TenNganh"));
        showPoint.getLbShowKhoa().setText(info.get("TenKhoa"));

        Vector<String> dataHK = ConnectionSQL.getDataHK(showPoint.getIdLogin());
        for (String string : dataHK) {
            showPoint.getListHK().addItem(string);
        }
    }
}

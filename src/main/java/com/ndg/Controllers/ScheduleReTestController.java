package com.ndg.Controllers;

import com.ndg.ConnectionMySQL.ConnectionSQL;
import com.ndg.GUI.ShowScheduleReTest;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class ScheduleReTestController {
    public ScheduleReTestController(@NotNull ShowScheduleReTest showScheduleReTest) {
        HashMap<String, String> info = ConnectionSQL.getInformationLogin(showScheduleReTest.getIdLogin());
        showScheduleReTest.getLbShowStuCode().setText(info.get("studentCode"));
        showScheduleReTest.getLbShowFullName().setText(info.get("studentName"));
        showScheduleReTest.getLbShowSex().setText(info.get("sex"));
        showScheduleReTest.getLbShowDOB().setText(info.get("dob"));
        showScheduleReTest.getLbShowAddress().setText(info.get("address"));
        showScheduleReTest.getLbShowCLass().setText(info.get("classCode"));
        showScheduleReTest.getLbShowMajor().setText(info.get("TenNganh"));
        showScheduleReTest.getLbShowKhoa().setText(info.get("TenKhoa"));
    }
}

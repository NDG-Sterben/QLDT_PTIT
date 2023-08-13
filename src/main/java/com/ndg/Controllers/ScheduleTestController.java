package com.ndg.Controllers;

import com.ndg.ConnectionMySQL.ConnectionSQL;
import com.ndg.GUI.ShowScheduleTest;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class ScheduleTestController {
    public ScheduleTestController(@NotNull ShowScheduleTest showScheduleTest) {
        HashMap<String, String> info = ConnectionSQL.getInformationLogin(showScheduleTest.getIdLogin());
        showScheduleTest.getLbShowStuCode().setText(info.get("studentCode"));
        showScheduleTest.getLbShowFullName().setText(info.get("studentName"));
        showScheduleTest.getLbShowSex().setText(info.get("sex"));
        showScheduleTest.getLbShowDOB().setText(info.get("dob"));
        showScheduleTest.getLbShowAddress().setText(info.get("address"));
        showScheduleTest.getLbShowCLass().setText(info.get("classCode"));
        showScheduleTest.getLbShowMajor().setText(info.get("TenNganh"));
        showScheduleTest.getLbShowKhoa().setText(info.get("TenKhoa"));
    }
}

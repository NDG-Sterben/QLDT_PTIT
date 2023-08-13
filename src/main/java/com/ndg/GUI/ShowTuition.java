package com.ndg.GUI;

import com.ndg.Controllers.ShowTuitionController;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ShowTuition extends ParentPanel {
    private final JPanel panelShowInfo;
    private final JLabel lbStuCode, lbFullName, lbSex, lbDOB, lbAddress, lbClass, lbMajor, lbKhoa;
    private final JLabel lbShowStuCode, lbShowFullName, lbShowDOB, lbShowSex, lbShowAddress, lbShowCLass;
    private final JLabel lbShowMajor, lbShowKhoa;
    private final JScrollPane scrollPane;
    private final JLabel lbTotalTC, lbTotalTCHP, lbTotalTuition, lbMinTotalTuition, lbTotalTuitionDD,
                            lbTotalTuitionCN;
    private final JLabel lbTotalTCInfo, lbTotalTCHPInfo, lbTotalTuitionInfo, lbMinTotalTuitionInfo,
            lbTotalTuitionDDInfo, lbTotalTuitionCNInfo;

    public ShowTuition(@NotNull JPanel panel, int idLogin) {
        super(panel.getWidth(), panel.getHeight(), idLogin);

        panelShowInfo = new JPanel(null);
        panelShowInfo.setBounds(
                200,
                panel.getHeight() / 20,
                400,
                280
        );
        panelShowInfo.setBorder(BorderFactory.createLineBorder(Color.green, 20));

        lbStuCode = new JLabel("Mã sinh viên");
        lbStuCode.setBounds(
                panelShowInfo.getX() + panelShowInfo.getWidth() / 4,
                panelShowInfo.getY() + 20,
                default_width_component - 50,
                default_height_component
        );

        lbFullName = new JLabel("Tên sinh viên");
        lbFullName.setBounds(
                lbStuCode.getX(),
                lbStuCode.getY() + 30,
                default_width_component - 50,
                default_height_component
        );

        lbSex = new JLabel("Giới tính");
        lbSex.setBounds(
                lbFullName.getX(),
                lbFullName.getY() + 30,
                default_width_component - 50,
                default_height_component
        );

        lbDOB = new JLabel("Ngày sinh");
        lbDOB.setBounds(
                lbSex.getX(),
                lbSex.getY() + 30,
                default_width_component - 50,
                default_height_component
        );

        lbAddress = new JLabel("Địa chỉ");
        lbAddress.setBounds(
                lbDOB.getX(),
                lbDOB.getY() + 30,
                default_width_component - 50,
                default_height_component
        );

        lbClass = new JLabel("Lớp");
        lbClass.setBounds(
                lbAddress.getX(),
                lbAddress.getY() + 30,
                default_width_component - 50,
                default_height_component
        );

        lbMajor = new JLabel("Ngành");
        lbMajor.setBounds(
                lbClass.getX(),
                lbClass.getY() + 30,
                default_width_component - 50,
                default_height_component
        );

        lbKhoa = new JLabel("Khoa");
        lbKhoa.setBounds(
                lbMajor.getX(),
                lbMajor.getY() + 30,
                default_width_component - 50,
                default_height_component
        );

        lbShowStuCode = new JLabel("Unknown");
        lbShowStuCode.setBounds(
                lbStuCode.getX() + lbStuCode.getWidth() + 10,
                lbStuCode.getY(),
                default_width_component,
                default_height_component
        );

        lbShowFullName = new JLabel("Unknown");
        lbShowFullName.setBounds(
                lbShowStuCode.getX(),
                lbShowStuCode.getY() + 30,
                default_width_component,
                default_height_component
        );

        lbShowSex = new JLabel("Unknown");
        lbShowSex.setBounds(
                lbShowFullName.getX(),
                lbShowFullName.getY() + 30,
                default_width_component,
                default_height_component
        );

        lbShowDOB = new JLabel("Unknown");
        lbShowDOB.setBounds(
                lbShowSex.getX(),
                lbShowSex.getY() + 30,
                default_width_component,
                default_height_component
        );

        lbShowAddress = new JLabel("Unknown");
        lbShowAddress.setBounds(
                lbShowDOB.getX(),
                lbShowDOB.getY() + 30,
                default_width_component,
                default_height_component
        );

        lbShowCLass = new JLabel("Unknown");
        lbShowCLass.setBounds(
                lbShowAddress.getX(),
                lbShowAddress.getY() + 30,
                default_width_component,
                default_height_component
        );

        lbShowMajor = new JLabel("Unknown");
        lbShowMajor.setBounds(
                lbShowCLass.getX(),
                lbShowCLass.getY() + 30,
                default_width_component,
                default_height_component
        );

        lbShowKhoa = new JLabel("Unknown");
        lbShowKhoa.setBounds(
                lbShowMajor.getX(),
                lbShowMajor.getY() + 30,
                default_width_component,
                default_height_component
        );


        lbTotalTC = new JLabel("Tổng số tín chỉ");
        lbTotalTC.setBounds(
                panelShowInfo.getX() + panelShowInfo.getWidth() + 70,
                panelShowInfo.getY() + 50,
                default_width_component,
                default_height_component
        );

        lbTotalTCHP = new JLabel("Tổng số TC học phí");
        lbTotalTCHP.setBounds(
                lbTotalTC.getX(),
                lbTotalTC.getY() + 30,
                default_width_component,
                default_height_component
        );

        lbTotalTuition = new JLabel("Tổng học phí");
        lbTotalTuition.setBounds(
                lbTotalTCHP.getX(),
                lbTotalTCHP.getY() + 30,
                default_width_component,
                default_height_component
        );

        lbMinTotalTuition = new JLabel("Tổng HP đóng tối thiểu");
        lbMinTotalTuition.setBounds(
                lbTotalTuition.getX(),
                lbTotalTuition.getY() + 30,
                default_width_component + 50,
                default_height_component
        );

        lbTotalTuitionDD = new JLabel("Tổng HP đã đóng");
        lbTotalTuitionDD.setBounds(
                lbMinTotalTuition.getX(),
                lbMinTotalTuition.getY() + 30,
                default_width_component,
                default_height_component
        );

        lbTotalTuitionCN = new JLabel("Tổng HP còn nợ");
        lbTotalTuitionCN.setBounds(
                lbTotalTuitionDD.getX(),
                lbTotalTuitionDD.getY() + 30,
                default_width_component,
                default_height_component
        );


        lbTotalTCInfo = new JLabel("0 VNĐ");
        lbTotalTCInfo.setBounds(
                lbTotalTC.getX() + lbTotalTC.getWidth() - 50,
                lbTotalTC.getY(),
                default_width_component,
                default_height_component
        );
        lbTotalTCInfo.setHorizontalAlignment(SwingConstants.RIGHT);


        lbTotalTCHPInfo = new JLabel("0 VNĐ");
        lbTotalTCHPInfo.setBounds(
                lbTotalTCInfo.getX(),
                lbTotalTCInfo.getY() + 30,
                default_width_component,
                default_height_component
        );
        lbTotalTCHPInfo.setHorizontalAlignment(SwingConstants.RIGHT);


        lbTotalTuitionInfo = new JLabel("0 VNĐ");
        lbTotalTuitionInfo.setBounds(
                lbTotalTCHPInfo.getX(),
                lbTotalTCHPInfo.getY() + 30,
                default_width_component,
                default_height_component
        );
        lbTotalTuitionInfo.setHorizontalAlignment(SwingConstants.RIGHT);


        lbMinTotalTuitionInfo = new JLabel("0 VNĐ");
        lbMinTotalTuitionInfo.setBounds(
                lbTotalTuitionInfo.getX(),
                lbTotalTuitionInfo.getY() + 30,
                default_width_component,
                default_height_component
        );
        lbMinTotalTuitionInfo.setHorizontalAlignment(SwingConstants.RIGHT);


        lbTotalTuitionDDInfo = new JLabel("0 VNĐ");
        lbTotalTuitionDDInfo.setBounds(
                lbMinTotalTuitionInfo.getX(),
                lbMinTotalTuitionInfo.getY() + 30,
                default_width_component,
                default_height_component
        );
        lbTotalTuitionDDInfo.setHorizontalAlignment(SwingConstants.RIGHT);

        lbTotalTuitionCNInfo = new JLabel("0 VNĐ");
        lbTotalTuitionCNInfo.setBounds(
                lbTotalTuitionDDInfo.getX(),
                lbTotalTuitionDDInfo.getY() + 30,
                default_width_component,
                default_height_component
        );
        lbTotalTuitionCNInfo.setHorizontalAlignment(SwingConstants.RIGHT);


        String[] columns = {"STT", "Tên môn hoc", "Số TC", "TCHP", "HP/1TC", "Tổng HP"};

        DefaultTableModel tableModel = new DefaultTableModel(null, columns);
        JTable tableShowSub = new JTable(tableModel);
        tableShowSub.setEnabled(false);

        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < tableShowSub.getColumnCount(); i++) {
            tableShowSub.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
        }
        tableShowSub.getColumnModel().getColumn(1).setPreferredWidth(150);

        scrollPane = new JScrollPane(
                tableShowSub,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
        );
        scrollPane.setBounds(
                100,
                panelShowInfo.getY() + panelShowInfo.getHeight() + 50,
                panel.getWidth() - 100 * 2,
                300
        );

        new ShowTuitionController(this);
    }

    @Override
    public void show(@NotNull JPanel panel) {
        super.show(panel);
        panel.add(lbStuCode);
        panel.add(lbShowStuCode);
        panel.add(lbFullName);
        panel.add(lbShowFullName);
        panel.add(lbSex);
        panel.add(lbShowSex);
        panel.add(lbDOB);
        panel.add(lbShowDOB);
        panel.add(lbAddress);
        panel.add(lbShowAddress);
        panel.add(lbClass);
        panel.add(lbShowCLass);
        panel.add(lbMajor);
        panel.add(lbShowMajor);
        panel.add(lbKhoa);
        panel.add(lbShowKhoa);
        panel.add(panelShowInfo);
        panel.add(scrollPane);
        panel.add(lbTotalTC);
        panel.add(lbTotalTCInfo);
        panel.add(lbTotalTCHP);
        panel.add(lbTotalTCHPInfo);
        panel.add(lbTotalTuition);
        panel.add(lbTotalTuitionInfo);
        panel.add(lbMinTotalTuition);
        panel.add(lbMinTotalTuitionInfo);
        panel.add(lbTotalTuitionDD);
        panel.add(lbTotalTuitionDDInfo);
        panel.add(lbTotalTuitionCN);
        panel.add(lbTotalTuitionCNInfo);
    }

    public JLabel getLbShowStuCode() {
        return lbShowStuCode;
    }

    public JLabel getLbShowFullName() {
        return lbShowFullName;
    }

    public JLabel getLbShowDOB() {
        return lbShowDOB;
    }

    public JLabel getLbShowSex() {
        return lbShowSex;
    }

    public JLabel getLbShowAddress() {
        return lbShowAddress;
    }

    public JLabel getLbShowCLass() {
        return lbShowCLass;
    }

    public JLabel getLbShowMajor() {
        return lbShowMajor;
    }

    public JLabel getLbShowKhoa() {
        return lbShowKhoa;
    }
}

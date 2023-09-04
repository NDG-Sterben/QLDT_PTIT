package com.ndg.GUI;

import com.ndg.Controllers.ShowPointController;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ShowPoint extends ParentPanel {
    private final JPanel panelShowInfo;
    private final JLabel lbStuCode, lbFullName, lbSex, lbDOB, lbAddress, lbClass, lbMajor, lbKhoa;
    private final JLabel lbShowStuCode, lbShowFullName, lbShowDOB, lbShowSex, lbShowAddress, lbShowCLass;
    private final JLabel lbShowMajor, lbShowKhoa;
    private final JScrollPane scrollPane;
    private final JComboBox<String> listHK;

    public ShowPoint(@NotNull JPanel panel, int idLogin) {
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

        listHK = new JComboBox<>();
        listHK.setBounds(
                panelShowInfo.getX() + panelShowInfo.getWidth() + 200,
                panelShowInfo.getY(),
                default_width_component,
                default_height_component
        );

        String[] columns = {"STT", "Tên môn học", "Điểm CC", "Điểm BTL", "Điểm nhóm",
                            "Điểm GK", "Điểm thi", "Điểm hệ 10", "Điểm hệ 4", "Điểm chữ"
        };

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
        new ShowPointController(this);
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
        panel.add(listHK);
        panel.add(scrollPane);
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

    public JComboBox<String> getListHK() {
        return listHK;
    }
}

package com.ndg.GUI;

import com.ndg.Controllers.ProgramEduController;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ShowProgramEdu extends ParentPanel {
    private final JScrollPane scrollPane;
    private final JComboBox<String> comboBoxMajor;
    private final DefaultTableModel tableModel;

    public ShowProgramEdu(@NotNull JPanel panel, int idLogin) {
        super(panel.getWidth(), panel.getHeight(), idLogin);

        comboBoxMajor = new JComboBox<>();
        comboBoxMajor.setBounds(
                (panel.getWidth() - default_width_component) / 2,
                panel.getHeight() / 20,
                default_width_component + 20,
                default_height_component
        );


        String[] columns = {"STT", "Mã môn học", "Tên môn học", "Sô TC", "Học kỳ", "Đã học"};

        tableModel = new DefaultTableModel(null, columns);
        JTable tableShowSub = new JTable(tableModel);
        tableShowSub.setEnabled(false);

        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < tableShowSub.getColumnCount(); i++) {
            tableShowSub.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
        }
        tableShowSub.getColumnModel().getColumn(2).setPreferredWidth(200);

        scrollPane = new JScrollPane(
                tableShowSub,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
        );
        scrollPane.setBounds(
                100,
                comboBoxMajor.getY() + comboBoxMajor.getHeight() + 50,
                panel.getWidth() - 100 * 2,
                600
        );

        new ProgramEduController(this);
    }

    @Override
    public void show(@NotNull JPanel panel) {
        super.show(panel);
        panel.add(comboBoxMajor);
        panel.add(scrollPane);
    }

    public JComboBox<String> getComboBoxMajor() {
        return comboBoxMajor;
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }
}

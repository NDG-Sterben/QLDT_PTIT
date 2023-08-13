package com.ndg.GUI;

import com.ndg.Controllers.RegisterSubjectController;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.Color;
import java.awt.Font;
import java.util.List;
import java.util.Vector;

public class RegisterSubject extends ParentPanel implements IApplication {
    private final JLabel lbSearchSubject;
    private final JTextField txtSubjectCode;
    private final JButton buttonSearch;
    private final JList<String> txtShowSubjectRegister;
    private final DefaultTableModel tableColumnClass, tableColumnSub;
    private final JTable tblShowClass, tableShowSub;
    private final JScrollPane scrollRegisSub, scrollPaneClass, scrollTableShowSub;

    public RegisterSubject(@NotNull JPanel panel, int idLogin) {
        super(panel.getWidth(), panel.getHeight(), idLogin);

        lbSearchSubject = new JLabel("Lọc theo môn học");
        lbSearchSubject.setBounds(100,
                panel.getHeight() / 20,
                default_width_component,
                default_height_component);
        lbSearchSubject.setFont(new Font(fontName, Font.BOLD, fontSize - 2));


        txtSubjectCode = new JTextField();
        txtSubjectCode.setFont(new Font(fontName, Font.BOLD, fontSize - 2));
        txtSubjectCode.setBounds(
                lbSearchSubject.getX() + lbSearchSubject.getWidth() - 10,
                lbSearchSubject.getY(),
                default_width_component,
                default_height_component
        );

        buttonSearch = new JButton("Tìm kiếm");
        buttonSearch.setFont(new Font(fontName, Font.BOLD, fontSize - 2));
        buttonSearch.setBounds(
                txtSubjectCode.getX() + txtSubjectCode.getWidth() + 20,
                txtSubjectCode.getY(),
                default_width_component - 50,
                default_height_component
        );



        /////////////////////////////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////         SHOW SUBJECT REGISTER       ///////////////////////////////
        /////////////////////////////////////////////////////////////////////////////////////////////////////

        String []list = {};

        Vector<String> subject = new Vector<>(List.of(list));

        txtShowSubjectRegister = new JList<>(subject);
        txtShowSubjectRegister.setFont(new Font("Times New Roman", Font.BOLD, fontSize - 2));
        txtShowSubjectRegister.setSelectionBackground(Color.red);
        txtShowSubjectRegister.setSelectionForeground(Color.white);


        scrollRegisSub = new JScrollPane(
                txtShowSubjectRegister,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
        );
        scrollRegisSub.setBounds(
                lbSearchSubject.getX(),
                lbSearchSubject.getY() + lbSearchSubject.getHeight() + 30,
                buttonSearch.getX() + buttonSearch.getWidth() - lbSearchSubject.getX(),
                200
        );



        ///////////////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////////////////////



        // set display center for data in the table

        DefaultTableCellRenderer centerCellRender = new DefaultTableCellRenderer();
        centerCellRender.setHorizontalAlignment(SwingConstants.CENTER);




        ////////////////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////      TABLE SUBJECT      /////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////////////



        Object [][] data1 = {};
        String[] column1 = {"STT", "Tên môn học", "Số TC", "Trạng thái"};

        tableColumnSub = new DefaultTableModel(data1, column1);
        tableShowSub = new JTable(tableColumnSub);
        tableShowSub.setEnabled(false);
        for (int i = 0; i < tableShowSub.getColumnCount(); i++) {
            tableShowSub.getColumnModel().getColumn(i).setCellRenderer(centerCellRender);
        }
        tableShowSub.getColumnModel().getColumn(1).setPreferredWidth(250);

        scrollTableShowSub = new JScrollPane(
                tableShowSub,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
        );
        scrollTableShowSub.setBounds(
                buttonSearch.getX() + buttonSearch.getWidth() + 100,
                buttonSearch.getY(),
                width - scrollRegisSub.getX() * 2 - scrollRegisSub.getWidth() - 100,
                scrollRegisSub.getY() + scrollRegisSub.getHeight() - lbSearchSubject.getY()
        );



        ////////////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////////////



        ////////////////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////         TABLE CLASS         ////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////////////

        Object[][] data = {};

        String[] columns = {"",
                            "Mã MH",
                            "Tên môn học",
                            "NMH",
                            "TTH",
                            "STC",
                            "Mã lớp",
                            "Sĩ số",
                            "Tiết BD",
                            "Thứ",
                            "Giảng viên"};

        tableColumnClass = new DefaultTableModel(data, columns) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 0) {
                    return Boolean.class;
                } else {
                    return super.getColumnClass(columnIndex);
                }
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                // only allow to change the first column
                return column == 0;
            }
        };


        tblShowClass = new JTable(tableColumnClass);
        TableColumn checkboxColumn = tblShowClass.getColumnModel().getColumn(0);
        checkboxColumn.setCellEditor(tblShowClass.getDefaultEditor(Boolean.class));
        checkboxColumn.setCellRenderer(tblShowClass.getDefaultRenderer(Boolean.class));


        tblShowClass.getColumnModel().getColumn(0).setPreferredWidth(5);
        tblShowClass.getColumnModel().getColumn(1).setPreferredWidth(30);
        tblShowClass.getColumnModel().getColumn(2).setPreferredWidth(150);
        tblShowClass.getColumnModel().getColumn(3).setPreferredWidth(20);
        tblShowClass.getColumnModel().getColumn(4).setPreferredWidth(20);
        tblShowClass.getColumnModel().getColumn(5).setPreferredWidth(20);
        tblShowClass.getColumnModel().getColumn(6).setPreferredWidth(50);
        tblShowClass.getColumnModel().getColumn(7).setPreferredWidth(20);
        tblShowClass.getColumnModel().getColumn(8).setPreferredWidth(20);
        tblShowClass.getColumnModel().getColumn(9).setPreferredWidth(20);
        tblShowClass.getColumnModel().getColumn(10).setPreferredWidth(150);

        for (int i = 1; i < tblShowClass.getColumnCount(); i++) {
            tblShowClass.getColumnModel().getColumn(i).setCellRenderer(centerCellRender);
        }
        scrollPaneClass = new JScrollPane(tblShowClass,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPaneClass.setBounds(
                scrollRegisSub.getX(),
                scrollRegisSub.getY() + scrollRegisSub.getHeight() + 50,
                panel.getWidth() - scrollRegisSub.getX() * 2,
                400
        );



        ///////////////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////////////////////

        new RegisterSubjectController(this);
    }

    public JButton getButtonSearch() {
        return buttonSearch;
    }

    public String getInputSearch() {
        return txtSubjectCode.getText().trim();
    }

    public JList<String> getTxtShowSubjectRegister() {
        return txtShowSubjectRegister;
    }

    public DefaultTableModel getTableColumnClass() {
        return tableColumnClass;
    }

    public DefaultTableModel getTableColumnSub() {
        return tableColumnSub;
    }

    public JTable getTblShowClass() {
        return tblShowClass;
    }

    public JTable getTableShowSub() {
        return tableShowSub;
    }


    @Override
    public void show(@NotNull JPanel panel) {
        super.show(panel);
        panel.add(lbSearchSubject);
        panel.add(txtSubjectCode);
        panel.add(buttonSearch);
        panel.add(scrollRegisSub);
        panel.add(scrollTableShowSub);
        panel.add(scrollPaneClass);
    }
}

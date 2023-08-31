package com.ndg.Controllers;

import com.ndg.ConnectionMySQL.ConnectionSQL;
import com.ndg.GUI.RegisterSubject;
import org.jetbrains.annotations.NotNull;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;


public class RegisterSubjectController implements ActionListener {

    public RegisterSubjectController(@NotNull RegisterSubject registerSubject) {
        ArrayList<String> schedule = new ArrayList<>();

        // list data in JList
        Vector<String> listSubjectRegister = ConnectionSQL.showTextSubjectRegister(registerSubject.getIdLogin());
        registerSubject.getTxtShowSubjectRegister().setListData(listSubjectRegister);


        // list class in table show class
        Vector<Object[]> getDataTableClass = ConnectionSQL.getDataTableClass(registerSubject.getIdLogin());
        for (int i = 0; i < getDataTableClass.size(); i++) {
            registerSubject.getTableColumnClass().addRow(getDataTableClass.elementAt(i));
            if (String.valueOf(getDataTableClass.elementAt(i)[0]).equals("true")) {
                String thu = String.valueOf(getDataTableClass.elementAt(i)[9]);
                String tietBD = String.valueOf(getDataTableClass.elementAt(i)[8]);

                String schedule1 = "%s%s".formatted(thu.charAt(0), tietBD.charAt(0));
                String schedule2 = "%s%s".formatted(thu.charAt(2), tietBD.charAt(2));

                if (!schedule1.startsWith("00")) schedule.add(schedule1);
                if (!schedule2.startsWith("00")) schedule.add(schedule2);

            }
        }

        System.out.println("===========================================");
        for (String s : schedule) {
            System.out.print(s + " ");
        }
        System.out.println();
        System.out.println("===========================================");


        // list class register
        Vector<Vector<String>> listSubject = ConnectionSQL.showSubjectRegister(registerSubject.getIdLogin());
        for (int i = 0; i < listSubject.size(); i++) {
            registerSubject.getTableColumnSub().addRow(new Object[]{
                    i + 1,
                    listSubject.get(i).get(0),
                    listSubject.get(i).get(1),
                    "Đã lưu"
            });
        }


        registerSubject.getButtonSearch().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (registerSubject.getInputSearch().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(
                            new JPanel(),
                            "Không được để trống",
                            "Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                    registerSubject.getTxtShowSubjectRegister().setListData(listSubjectRegister);
                    return;
                }

                for (int i = 0; i < listSubjectRegister.size(); i++) {
                    System.out.println(listSubjectRegister.elementAt(i));
                    System.out.println("'" + registerSubject.getInputSearch() + "'");
                    if (listSubjectRegister.elementAt(i).startsWith(
                            registerSubject.getInputSearch().toUpperCase()))
                    {
                            registerSubject.getTxtShowSubjectRegister().setListData(
                                new String[] {listSubjectRegister.elementAt(i)}
                        );
                            break;
                    } else {
                        if (i == listSubjectRegister.size() - 1) {
                            JOptionPane.showMessageDialog(
                                    new JPanel(),
                                    "Không tìm thấy môn học",
                                    "Error",
                                    JOptionPane.ERROR_MESSAGE
                            );
                            registerSubject.getTxtShowSubjectRegister().setListData(listSubjectRegister);
                        }
                    }
                }
            }
        });




        registerSubject.getTblShowClass().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (registerSubject.getTblShowClass().getSelectedColumn() == 0) {
                    // get index row when clicking in class table
                    int rowSelected = registerSubject.getTblShowClass().getSelectedRow();

                    // check exist subject in subject table saved
                    boolean checkSubjectRegister = false;

                    // get exist subject in subject table saved
                    int rowSubRegister = -1;
                    for (int i = 0; i < registerSubject.getTableShowSub().getRowCount(); i++) {
                        if (String.valueOf(registerSubject.getTblShowClass().getValueAt(rowSelected, 2)).equals(
                                String.valueOf(registerSubject.getTableShowSub().getValueAt(i, 1)))) {
                            checkSubjectRegister = true;
                            rowSubRegister = i;
                        }
                    }

                    if (checkSubjectRegister) {
                        if (String.valueOf(registerSubject.getTblShowClass().getValueAt(rowSelected, 0)).equals("true")) {
                            JOptionPane.showMessageDialog(
                                    new JPanel(),
                                    "Môn học đã được đăng kí",
                                    "Error",
                                    JOptionPane.WARNING_MESSAGE
                            );
                            registerSubject.getTblShowClass().setValueAt(false, rowSelected, 0);

                        } else {
                            String thu = String.valueOf(registerSubject.getTblShowClass().getValueAt(rowSelected, 9));
                            String tietBD = String.valueOf(registerSubject.getTblShowClass().getValueAt(rowSelected, 8));

                            String schedule1 = "%s%s".formatted(thu.charAt(0), tietBD.charAt(0));
                            String schedule2 = "%s%s".formatted(thu.charAt(2), tietBD.charAt(2));


                            schedule.remove(schedule1);
                            schedule.remove(schedule2);


                            System.out.println("===========================================");
                            for (String s : schedule) {
                                System.out.print(s + " ");
                            }
                            System.out.println();
                            System.out.println("===========================================");


                            System.out.println("Remove Subject Successful");
                            registerSubject.getTableColumnSub().removeRow(rowSubRegister);
                            int getTotalRow = registerSubject.getTableShowSub().getRowCount();
                            if (getTotalRow != 0) {
                                for (int i = 0; i < getTotalRow; i++) {
                                    if (i >= rowSubRegister) {
                                        registerSubject.getTableShowSub().setValueAt(
                                                Integer.parseInt(String.valueOf(registerSubject.getTableShowSub().getValueAt(i, 0))) - 1,
                                                i, 0
                                        );
                                    }
                                }
                            }
                            ConnectionSQL.removeSubRegis(
                                    registerSubject.getIdLogin(),
                                    (String) registerSubject.getTblShowClass().getValueAt(rowSelected, 6)
                            );
                            ConnectionSQL.updateNumberOfStuInClass(
                                    String.valueOf(registerSubject.getTblShowClass().getValueAt(rowSelected, 6)).toLowerCase(),
                                    true
                            );
                        }
                    } else {
                        if (String.valueOf(registerSubject.getTblShowClass().getValueAt(rowSelected, 0)).equals("true")) {
                            // check duplicate subject register
                            String thu = String.valueOf(registerSubject.getTblShowClass().getValueAt(rowSelected, 9));
                            String tietBD = String.valueOf(registerSubject.getTblShowClass().getValueAt(rowSelected, 8));

                            String schedule1 = "%s%s".formatted(thu.charAt(0), tietBD.charAt(0));
                            String schedule2 = "%s%s".formatted(thu.charAt(2), tietBD.charAt(2));

                            if (schedule.contains(schedule1) || schedule.contains(schedule2)) {
                                JOptionPane.showMessageDialog(
                                        new JPanel(),
                                        "Môn học đăng kí đã bị trùng lịch với một môn khác",
                                        "Error",
                                        JOptionPane.ERROR_MESSAGE
                                );
                                registerSubject.getTblShowClass().setValueAt(false, rowSelected, 0);

                                System.out.println("===========================================");
                                for (String s : schedule) {
                                    System.out.print(s + " ");
                                }
                                System.out.println();
                                System.out.println("===========================================");

                                return;
                            }

                            registerSubject.getTableColumnSub().addRow(new Object[]{
                                    registerSubject.getTableColumnSub().getRowCount() + 1,
                                    registerSubject.getTblShowClass().getValueAt(rowSelected, 2),
                                    registerSubject.getTblShowClass().getValueAt(rowSelected, 5),
                                    "Đã lưu"
                            });
                            ConnectionSQL.insertSubRegis(
                                    registerSubject.getIdLogin(),
                                    registerSubject.getTblShowClass().getValueAt(rowSelected, 6).toString().toLowerCase()
                            );
                            System.out.println("Register subject successful");

                            if (!schedule1.equals("00")) schedule.add(schedule1);
                            if (!schedule2.equals("00")) schedule.add(schedule2);

                            System.out.println("===========================================");
                            for (String s : schedule) {
                                System.out.print(s + " ");
                            }
                            System.out.println();
                            System.out.println("===========================================");

                            ConnectionSQL.updateNumberOfStuInClass(
                                    String.valueOf(registerSubject.getTblShowClass().getValueAt(rowSelected, 6)).toLowerCase(),
                                    false
                            );
                        }
                    }
                }
            }
        });
    }



    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

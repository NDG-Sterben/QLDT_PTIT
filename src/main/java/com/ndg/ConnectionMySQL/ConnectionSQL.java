package com.ndg.ConnectionMySQL;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

public class ConnectionSQL {
    private static final String url = "jdbc:mysql://localhost:3306/Student_Manager";
    private static final String user = "root";
    private static final String pass = "@Sterben2810";
    public static Connection connection;
    private static Statement statement;


    public static void getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println();
            connection = DriverManager.getConnection(url, user, pass);
            if (connection != null) {
                System.out.println("Connection MySQL Successful");
            } else {
                System.out.println("Connection MySQL Failed");
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }



    public synchronized static int login(String username, String password) {
        int idLogin = -1;
        String query = "SELECT * FROM accounts " +
                        "WHERE username = '" + username + "'" + " AND " + "password = '" + password + "'";
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                if (username.equals(resultSet.getString("username")) &&
                    password.equals(resultSet.getString("password"))) {
                    idLogin = Integer.parseInt(resultSet.getString("idAcc"));
                    System.out.println("Login Successful");
                    System.out.println("Get idLogin MySQL (check login): " + idLogin);
                }
            }
            if (idLogin == -1) {
                System.out.println("Login Failed");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return idLogin;
    }


    public synchronized static String countStuLogin() {
        String result = "";
        String query = """
                select count(isLogin) as totalStuLogin
                from accounts
                where isLogin = 1""";

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                result = resultSet.getString("totalStuLogin");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }


    public synchronized static void checkStatus(int idLogin, boolean status) {
        String checkLogin = """
                update accounts
                set isLogin = 1
                where idAcc =""" + idLogin;

        String checkLogout = """
                update accounts
                set isLogin = 0
                where idAcc =""" + idLogin;

        try {
            statement = connection.createStatement();
            if (status) statement.executeUpdate(checkLogin);
            else statement.executeUpdate(checkLogout);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public synchronized static @NotNull HashMap<String, String> getInformationLogin(int idLogin) {
        HashMap<String, String> getInfo = new HashMap<>();
        String query = """
                SELECT studentCode, studentName, sex, date_format(dob, "%d/%m/%Y") as dob, address, classCode, TenNganh, TenKhoa
                FROM students
                INNER JOIN nganh ON students.MaNganh = nganh.MaNganh
                INNER JOIN khoa ON khoa.MaKhoa = nganh.MaKhoa
                WHERE idAcc = '""" + idLogin + "'";

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                getInfo.put("studentCode", resultSet.getString("studentCode").toUpperCase());
                getInfo.put("studentName", resultSet.getString("studentName"));
                getInfo.put("sex", Boolean.parseBoolean(resultSet.getString("sex")) ? "Nữ" : "Nam");
                getInfo.put("dob", resultSet.getString("dob"));
                getInfo.put("address", resultSet.getString("address"));
                getInfo.put("classCode", resultSet.getString("classCode").toUpperCase());
                getInfo.put("TenNganh", resultSet.getString("TenNganh"));
                getInfo.put("TenKhoa", resultSet.getString("TenKhoa"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return getInfo;
    }



    public synchronized static String getNganh(int idLogin) {
        String query = """
                SELECT TenNganh FROM nganh
                INNER JOIN students on students.MaNganh = nganh.MaNganh
                WHERE idAcc = '""" + idLogin + "'";
        String result = "";
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                result = resultSet.getString("TenNganh");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }



    public synchronized static @NotNull Vector<Object[]> getDataTableClass(int idLogin) {
        Vector<Object[]> subjectRegister = new Vector<>();
        String query = """
                SELECT subjects.subjectCode, subjects.subjectName, subjects.STC, lophp.NMH, lophp.TTH,
                                lophp.classCode, lophp.soluong, lophp.TietBD, lophp.Thu, teachers.teacherName
                FROM lophp
                INNER JOIN subjects ON lophp.subjectCode = subjects.subjectCode
                INNER JOIN teachers ON teachers.teacherCode = lophp.teacherCode
                WHERE subjects.MaNganh LIKE (SELECT MaNganh FROM students WHERE idAcc = %d)
                        OR (subjects.MaNganh is null and subjects.MaKhoa is null)
                ORDER BY subjectName ASC;""".formatted(idLogin);

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            HashMap<String, Boolean> checkSubjectRegis = ConnectionSQL.getSub(idLogin);
            while (resultSet.next()) {
                boolean subRegis = checkSubjectRegis.get(resultSet.getString("classCode")) != null;

                Object[] e = {
                        subRegis,
                        resultSet.getString("subjectCode").toUpperCase(),
                        resultSet.getString("subjectName"),
                        resultSet.getString("NMH"),
                        resultSet.getString("TTH"),
                        resultSet.getString("STC"),
                        resultSet.getString("classCode").toUpperCase(),
                        resultSet.getString("soluong"),
                        resultSet.getString("TietBD"),
                        resultSet.getString("Thu"),
                        resultSet.getString("teacherName"),
                };
                subjectRegister.add(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return subjectRegister;
    }




    public synchronized static void updateNumberOfStuInClass(String classCode, boolean staticCode) {

        /*
        *
        * @Author Nguyen Thanh Trung
        * Describe: when register subject, number of student of lophp will be increase or decrease
        *
        * @pragma staticCode
        *       true: describe number of student increase
        *       false: describe number of student decrease
        *
        */

        String query_decr = """
                update lophp
                set soluong = soluong - 1
                where classCode = '""" + classCode + "'";

        String query_incr = """
                update lophp
                set soluong = soluong + 1
                where classCode = '""" + classCode + "'";

        PreparedStatement preparedStatement;

        if (staticCode) {
            try {
                preparedStatement = connection.prepareStatement(query_incr);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            try {
                preparedStatement = connection.prepareStatement(query_decr);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }




    public synchronized static @NotNull Vector<String> showTextSubjectRegister(int idLogin) {
        Vector<String> result = new Vector<>();
        String query = """
                SELECT subjects.subjectCode, subjects.subjectName, subjects.STC
                FROM lophp
                INNER JOIN subjects ON subjects.subjectCode = lophp.subjectCode
                WHERE subjects.MaNganh LIKE (SELECT MaNganh FROM students WHERE idAcc = '""" + idLogin + "')";

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String input = resultSet.getString("subjectCode").toUpperCase() + " - " +
                                resultSet.getString("subjectName") + " (" +
                                resultSet.getString("STC") + "TC)";

                if (result.isEmpty()) {
                    result.add(input);
                } else {
                    boolean check = false;
                    for (String s : result) {
                        if (s.equals(input)) {
                            check = true;
                            break;
                        }
                    }
                    if (!check) {
                        result.add(input);
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }


    public synchronized static @NotNull Vector<Vector<String>> showSubjectRegister(int idLogin) {
        Vector<Vector<String>> result = new Vector<>();
        String query = """
                select subjects.subjectName, subjects.STC
                from lophp_regis
                inner join lophp on lophp.classCode = lophp_regis.classCode
                inner join subjects on subjects.subjectCode = lophp.subjectCode
                where idAcc = '""" + idLogin + "'";

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Vector<String> vector = new Vector<>(2);
                vector.add(resultSet.getString("subjectName"));
                vector.add(resultSet.getString("STC"));
                result.add(vector);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }


    public synchronized static @NotNull HashMap<String, Boolean> getSub(int idLogin) {
        HashMap<String, Boolean> result = new HashMap<>();
        String query = """
                select classCode
                from lophp_regis
                where idAcc = '""" + idLogin + "'";

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                result.put(resultSet.getString("classCode"), true);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }



    public synchronized static void removeSubRegis(int idLogin, String classCode) {
        String query = "DELETE FROM lophp_regis WHERE idAcc = '" + idLogin + "'" + " AND classCode = '" + classCode + "'";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }




    public synchronized static void insertSubRegis(int idLogin, String classCode) {
        String query = "INSERT INTO lophp_regis (classCode,  idAcc) VALUES ('" + classCode + "', " + idLogin + ")";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }




    public synchronized static @NotNull Vector<Object[]> getAllSubjectInMajor(int idLogin) {
        Vector<Object[]> getSubject = new Vector<>();
        String query = """
                select subjectCode, subjectName, STC, KH
                from subjects
                where subjects.MaNganh in (
                		select MaNganh from students where idAcc =""" +
                idLogin + """
                ) or (subjects.MaNganh is null and (subjects.MaKhoa is null or subjects.MaKhoa in (
                	select MaKhoa from khoa where MaNganh in (
                		select MaNganh from students where idAcc =""" +
                idLogin + """
                    )
                )))
                order by KH asc , subjectName asc""";


        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            int i = 0;
            while (resultSet.next()) {
                i += 1;
                Object[] objects = {
                        i,
                        resultSet.getString("subjectCode").toUpperCase(),
                        resultSet.getString("subjectName"),
                        resultSet.getString("STC"),
                        resultSet.getString("KH"),
                        "Đã học"
                };
                getSubject.add(objects);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return getSubject;
    }



    public static @NotNull HashMap<String, String> getSchedule(int idLogin) {
        HashMap<String, String> getCalender = new HashMap<>();
        String query = """
                select subjectName, thu, tietBD from lophp
                inner join lophp_regis on lophp_regis.classCode = lophp.classCode
                inner join subjects on subjects.subjectCode = lophp.subjectCode
                where lophp_regis.idAcc = %d""".formatted(idLogin);

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                char[] thu = resultSet.getString("thu").toCharArray();
                char[] tietBD = resultSet.getString("tietBD").toCharArray();
                System.out.println(thu.length + " " + tietBD.length);
                String calender = "%s%s_%s%s".formatted(thu[0], tietBD[0], thu[2], tietBD[2]);
            }
         } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return getCalender;
    }


    @Contract(pure = true)
    public static @NotNull ArrayList<Object[]> scheduleClasses(int idLogin) {
        ArrayList<Object[]> getSchedule = new ArrayList<>();
        String query = """
                select subjects.subjectName, teachers.teacherName, lophp.thu, lophp.tietBD
                from lophp_regis
                inner join lophp on lophp.classCode = lophp_regis.classCode
                inner join subjects on subjects.subjectCode = lophp.subjectCode
                inner join teachers on teachers.teacherCode = lophp.teacherCode
                where idAcc = %d""".formatted(idLogin);

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Object[] e = {
                        resultSet.getString("subjectName"),
                        resultSet.getString("teacherName"),
                        resultSet.getString("thu"),
                        resultSet.getString("tietBD")
                };
                getSchedule.add(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  getSchedule;
    }
}

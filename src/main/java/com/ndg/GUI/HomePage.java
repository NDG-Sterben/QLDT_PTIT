package com.ndg.GUI;

import com.ndg.Controllers.HomePageController;
import com.ndg.SubFunction.ImageProcessing;
import com.ndg.entities.OtherNotification;
import com.ndg.entities.Slider;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class HomePage extends ParentPanel implements IApplication {
    private final JPanel slider;
    private final JPanel banner;
    private final JPanel content;
    private final JPanel showInfoLogin;

    public HomePage(@NotNull JPanel panel, int idLogin) {
        super(panel.getWidth(), panel.getHeight(), idLogin);
        this.setBackground(new Color(255, 153, 153));

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////            SLIDER               ////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


        slider = new JPanel(null);
        slider.setBounds(0, 0, panel.getWidth(), 50);
        slider.setBackground(Color.red);

        Slider slider1 = new Slider(slider);
        slider1.start();


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////                  BANNER                 /////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


        float scale = 0.7F;
        String pathBanner = "./assets/banner.png";

        JLabel imgBanner = new JLabel(ImageProcessing.scaleImage(
                pathBanner,
                (int) (ImageProcessing.getWidthImage(pathBanner) * scale),
                (int) (ImageProcessing.getHeightImage(pathBanner) * scale)));

        imgBanner.setBounds(
                0, 0,
                (int) (ImageProcessing.getWidthImage(pathBanner) * scale),
                (int) (ImageProcessing.getHeightImage(pathBanner) * scale)
        );


        banner = new JPanel(null);
        banner.setBounds(0, slider.getHeight(), panel.getWidth(), imgBanner.getHeight());
        banner.setBackground(Color.GREEN);


        JPanel jPanel = new JPanel();
        jPanel.setBounds(
                imgBanner.getWidth(),
                imgBanner.getY(),
                banner.getWidth() - imgBanner.getWidth(),
                banner.getHeight() / 2
        );
        jPanel.setBackground(new Color(255, 153, 153));

        banner.add(imgBanner);
        banner.add(jPanel);


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////            CONTENT OF NOTIFICATION               ////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


        content = new JPanel(null);
        content.setBounds(
                0,
                slider.getHeight() + banner.getHeight(),
                panel.getWidth(),
                (int) (panel.getHeight() * 0.6)

        );
        content.setBackground(Color.BLUE);

        JPanel headerNotify = new JPanel(null);
        headerNotify.setBounds(
                0, 0,
                panel.getWidth(),
                default_height_component + 20
        );
        headerNotify.setBackground(Color.red);

        JLabel notify = new JLabel("THÔNG BÁO");
        notify.setBounds(20, 0, default_width_component, headerNotify.getHeight());
        notify.setFont(new Font("Arial", Font.BOLD, fontSize + 1));
        notify.setOpaque(true);
        notify.setForeground(Color.white);
        notify.setBackground(Color.red);



        JPanel displayNotify = new JPanel(null);
        displayNotify.setBounds(
                0, headerNotify.getHeight(),
                content.getWidth(),
                (int) (content.getHeight() * 0.6)
        );
        displayNotify.setBackground(Color.GREEN);



        JPanel displayMainNotify = new JPanel(null);
        displayMainNotify.setBounds(
                0, 0, (int) (displayNotify.getWidth() * 0.4),
                displayNotify.getHeight()
        );

        String avatar = "./assets/avatar.png";
        JLabel avatarMain = new JLabel(ImageProcessing.scaleImage(
                avatar,
                displayMainNotify.getWidth() - 5,
                (int) (displayMainNotify.getHeight() * 0.7)
        ));
        avatarMain.setBounds(5, 5,
                displayMainNotify.getWidth() - 5 * 2,
                (int) (displayMainNotify.getHeight() * 0.7));


        JLabel dateOfMainNotify = new JLabel("03/08/2023");
        dateOfMainNotify.setBounds(
                avatarMain.getX(), avatarMain.getY() + avatarMain.getHeight(),
                avatarMain.getWidth(),
                default_height_component
        );
        dateOfMainNotify.setHorizontalAlignment(SwingConstants.RIGHT);
        dateOfMainNotify.setForeground(new Color(96, 96, 96));
        dateOfMainNotify.setOpaque(true);
        dateOfMainNotify.setBackground(Color.WHITE);

        JTextArea titleNotify = new JTextArea("Thông báo: Về việc đăng kí học ghép học kỳ 1 năm học 2023 - 2024");
        titleNotify.setBounds(
                dateOfMainNotify.getX(),
                dateOfMainNotify.getY() + dateOfMainNotify.getHeight(),
                dateOfMainNotify.getWidth(),
                default_height_component + 20
        );
        titleNotify.setEditable(false);
        titleNotify.setFont(new Font(fontName, Font.BOLD, fontSize));
        titleNotify.setForeground(new Color(96, 96, 96));
        titleNotify.setLineWrap(true);



        /*
        *
        *   Display other notification
        *
        * */

        JPanel displayOtherNotify = new JPanel(null);
        displayOtherNotify.setBounds(
                displayMainNotify.getWidth(),
                displayMainNotify.getY(),
                displayNotify.getWidth() - displayMainNotify.getWidth(),
                displayNotify.getHeight()
        );
        displayOtherNotify.setBackground(Color.WHITE);

        JPanel container = new JPanel(null);
        container.setBounds(
                5, 5,
                (int) (displayOtherNotify.getWidth() * 0.97 - 3),
                displayOtherNotify.getHeight() - 5 * 2
        );

        OtherNotification notify1 = new OtherNotification(container, 0, 0, 8);
        notify1.setTextHeader("Thông báo: kết quả giải quyết đơn hỗ trợ đăng ký học kỳ 1 năm học 2023-2024");
        notify1.setTimeNotify("24/07/2023");
        OtherNotification notify2 = new OtherNotification(container, 0, 37, 8);
        notify2.setTextHeader("Thông báo: Lịch đăng ký học kỳ 1 năm học 2023-2024 tuần từ 17/7 đến 23/7/2023");
        notify2.setTimeNotify("14/07/2023");
        OtherNotification notify3 = new OtherNotification(container, 0, 74, 8);
        notify3.setTextHeader("Thông báo: Lịch đăng ký học kỳ 1 năm học 2023-2024 tuần từ 10/7 đến 16/7/2023");
        notify3.setTimeNotify("06/07/2023");
        OtherNotification notify4 = new OtherNotification(container, 0, 111, 8);
        notify4.setTextHeader("Thông báo: Lịch đăng ký học kỳ 1 năm học 2023-2024 tuần 03-09/07/2023");
        notify4.setTimeNotify("29/06/2023");
        OtherNotification notify5 = new OtherNotification(container, 0, 147, 8);
        notify5.setTextHeader("Điều chỉnh lịch đăng ký thời khóa biểu Học kỳ 1 năm học 2023-2024");
        notify5.setTimeNotify("19/06/2023");
        OtherNotification notify6 = new OtherNotification(container, 0, 186, 8);
        notify6.setTextHeader("Thông báo về việc đăng ký học phần tốt nghiệp cho sinh viên ngành kỹ thuật 2019");
        notify6.setTimeNotify("30/05/2023");
        OtherNotification notify7 = new OtherNotification(container, 0, 222, 8);
        notify7.setTextHeader("Thông báo đăng ký lịch học kỳ hè năm học 2022-2023");
        notify7.setTimeNotify("23/05/2023");
        OtherNotification notify8 = new OtherNotification(container, 0, 259, 8);
        notify8.setTextHeader("Thông báo: V/v Đăng ký học phần tốt nghiệp cho sinh viên ngành truyền thông ĐPT và các ngành khối kinh tế khoá 2019");
        notify8.setTimeNotify("30/03/2023");


        /*
        *   Panel Introduction
        * */

        JPanel headerIntro = new JPanel(null);
        headerIntro.setBounds(
                0,
                headerNotify.getHeight() + displayNotify.getHeight(),
                content.getWidth(),
                default_height_component + 20
        );
        headerIntro.setBackground(Color.red);

        JLabel intro = new JLabel("HƯỚNG DẪN");
        intro.setBounds(20, 0, default_width_component, headerNotify.getHeight());
        intro.setFont(new Font("Arial", Font.BOLD, fontSize + 1));
        intro.setOpaque(true);
        intro.setForeground(Color.white);
        intro.setBackground(Color.red);


        /*
        *   Content of panel introduction
        * */

        JPanel contentIntro = new JPanel(null);
        contentIntro.setBounds(
                0,
                headerNotify.getHeight() + displayNotify.getHeight() + headerIntro.getHeight(),
                content.getWidth(),
                content.getHeight() - (headerNotify.getHeight() + displayNotify.getHeight() + headerIntro.getHeight())
        );

        JPanel introContent = new JPanel(null);
        introContent.setBounds(
                5,
                5,
                (int) (contentIntro.getWidth() * 0.98),
                contentIntro.getHeight() - 5 * 2);


        OtherNotification intro1 = new OtherNotification(introContent, 0, 0, 3);
        intro1.setTextHeader("Hướng dẫn sử dụng cổng thông tin điện tử quản lý đào tạo");
        intro1.setTimeNotify("21/06/2023");
        OtherNotification intro2 = new OtherNotification(introContent, 0, 35, 3);
        intro2.setTextHeader("Hướng dẫn sử dụng cổng thông tin điện tử quản lý đào tạo cho giảng viên và cố vấn học tập");
        intro2.setTimeNotify("01/08/2023");
        OtherNotification intro3 = new OtherNotification(introContent, 0, 70, 3);
        intro3.setTextHeader("Hướng dẫn sử dụng cổng thông tin điện tử quản lý đào tạo cho sinh viên");
        intro3.setTimeNotify("01/07/2023");


        headerNotify.add(notify);

        displayMainNotify.add(avatarMain);
        displayMainNotify.add(dateOfMainNotify);
        displayMainNotify.add(titleNotify);
        displayOtherNotify.add(container);
        displayNotify.add(displayMainNotify);
        displayNotify.add(displayOtherNotify);

        headerIntro.add(intro);
        contentIntro.add(introContent);

        content.add(headerNotify);
        content.add(displayNotify);
        content.add(headerIntro);
        content.add(contentIntro);


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////              SHOW INFORMATION LOGIN                  /////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        showInfoLogin = new JPanel(null);
        showInfoLogin.setBounds(
                content.getX(),
                content.getY() + content.getHeight(),
                content.getWidth(),
                panel.getHeight()-slider.getHeight()-banner.getHeight()-content.getHeight()-this.getFooter().getHeight()
        );
        showInfoLogin.setBackground(new Color(255, 153, 153));


        JPanel infoLogin = new JPanel(null);
        infoLogin.setBounds(
                (int) (showInfoLogin.getWidth() * 0.7),
                0,
                (int) (showInfoLogin.getWidth() * 0.3),
                showInfoLogin.getHeight()
        );
        infoLogin.setBackground(new Color(255, 153, 153));


        JLabel headerInfoLogin = new JLabel("Thống kê truy cập");
        headerInfoLogin.setBounds(0, 0, infoLogin.getWidth(), infoLogin.getHeight() / 4);
        headerInfoLogin.setFont(new Font(fontName, Font.BOLD, fontSize - 2));
        headerInfoLogin.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel showStuLogin = new JPanel(new FlowLayout());
        showStuLogin.setBounds(
                0,
                infoLogin.getHeight() / 4,
                infoLogin.getWidth(),
                infoLogin.getHeight() / 4 - 20
        );
        showStuLogin.setBackground(new Color(255, 153, 153));

        JLabel iconStu = new JLabel(ImageProcessing.scaleImage("./assets/student.png", 20, 20));
        JLabel textStuLogin = new JLabel("SV truy cập");
        textStuLogin.setSize(new Dimension(default_width_component - 50, default_height_component));
        JLabel numberStuLogin = new JLabel("1");


        JPanel showTeacherLogin = new JPanel(new FlowLayout());
        showTeacherLogin.setBounds(
                0,
                showStuLogin.getY() + showStuLogin.getHeight(),
                showStuLogin.getWidth(),
                showStuLogin.getHeight()
        );
        showTeacherLogin.setBackground(new Color(255, 153, 153));


        JLabel iconTeacher = new JLabel(ImageProcessing.scaleImage("./assets/teacher.png", 20, 20));
        JLabel textTeacherLogin = new JLabel("GV truy cập");
        textStuLogin.setSize(new Dimension(default_width_component - 50, default_height_component));
        JLabel numberTeacherLogin = new JLabel("0");


        // add components for panel's show info login
        showStuLogin.add(iconStu);
        showStuLogin.add(textStuLogin);
        showStuLogin.add(numberStuLogin);
        showTeacherLogin.add(iconTeacher);
        showTeacherLogin.add(textTeacherLogin);
        showTeacherLogin.add(numberTeacherLogin);
        infoLogin.add(showStuLogin);
        infoLogin.add(showTeacherLogin);
        infoLogin.add(headerInfoLogin);
        showInfoLogin.add(infoLogin);



////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


        new HomePageController(this);
    }

    @Override
    public void show(@NotNull JPanel panel) {
        super.show(panel);
        panel.add(slider);
        panel.add(banner);
        panel.add(content);
        panel.add(showInfoLogin);
    }
}

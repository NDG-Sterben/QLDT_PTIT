package com.ndg.GUI;

import com.ndg.Controllers.ShowScheduleController;
import com.ndg.entities.JLabelCustom;
import com.ndg.entities.ShowMoreInformation;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class ShowSchedule extends ParentPanel {
    private ShowMoreInformation showMoreInformation;
    private final JLabel lbSchedule;
    private final JComboBox comboBoxSchoolYear;
    private final JPanel panelShowSchedule;
    private final JLabelCustom lbT2K1, lbT2K2, lbT2K3, lbT2K4, lbT2K5, lbT2K6;
    private final JLabelCustom lbT3K1, lbT3K2, lbT3K3, lbT3K4, lbT3K5, lbT3K6;
    private final JLabelCustom lbT4K1, lbT4K2, lbT4K3, lbT4K4, lbT4K5, lbT4K6;
    private final JLabelCustom lbT5K1, lbT5K2, lbT5K3, lbT5K4, lbT5K5, lbT5K6;
    private final JLabelCustom lbT6K1, lbT6K2, lbT6K3, lbT6K4, lbT6K5, lbT6K6;
    private final JLabelCustom lbT7K1, lbT7K2, lbT7K3, lbT7K4, lbT7K5, lbT7K6;

    public ShowSchedule(@NotNull JPanel panel, int idLogin) {
        super(panel.getWidth(), panel.getHeight(), idLogin);
        showMoreInformation = new ShowMoreInformation(0, 0);

        final int maxColumn = 9;
        final int maxRow = 8;

        lbSchedule = new JLabel("Thời khóa biểu");
        lbSchedule.setBounds(
                100,
                height / 20,
                default_width_component,
                default_height_component
        );

        comboBoxSchoolYear = new JComboBox<>();
        comboBoxSchoolYear.setBounds(
                lbSchedule.getX() + lbSchedule.getWidth() - 20,
                lbSchedule.getY(),
                default_width_component + 150,
                default_height_component
        );

        panelShowSchedule = new JPanel(null);
        panelShowSchedule.setBounds(
                lbSchedule.getX(),
                lbSchedule.getY() + lbSchedule.getHeight() + 100,
                panel.getWidth() - lbSchedule.getX() * 2,
                500
        );
        panelShowSchedule.setBackground(new Color(229, 255, 204));

        final int maxWidthLabel = panelShowSchedule.getWidth() / maxColumn;
        final int maxHeightLabel = panelShowSchedule.getHeight() / maxRow;

        JLabel lbSpace1 = new JLabel();
        lbSpace1.setBounds(
                0, 0,
                maxWidthLabel,
                maxHeightLabel
        );
        lbSpace1.setOpaque(true);
        lbSpace1.setBackground(Color.red);
        lbSpace1.setBorder(BorderFactory.createLineBorder(Color.red));

        JLabel lbMo = new JLabel("THỨ 2");
        lbMo.setBounds(
                lbSpace1.getX() + lbSpace1.getWidth(),
                lbSpace1.getY(),
                lbSpace1.getWidth(),
                lbSpace1.getHeight()

        );
        lbMo.setFont(new Font(fontName, Font.BOLD, fontSize));
        lbMo.setHorizontalAlignment(SwingConstants.CENTER);
        lbMo.setVerticalAlignment(SwingConstants.CENTER);
        lbMo.setBorder(BorderFactory.createLineBorder(Color.red));

        JLabel lbTu = new JLabel("THỨ 3");
        lbTu.setBounds(
                lbMo.getX() + lbMo.getWidth(),
                lbMo.getY(),
                lbMo.getWidth(),
                lbMo.getHeight()

        );
        lbTu.setFont(new Font(fontName, Font.BOLD, fontSize));
        lbTu.setHorizontalAlignment(SwingConstants.CENTER);
        lbTu.setVerticalAlignment(SwingConstants.CENTER);
        lbTu.setBorder(BorderFactory.createLineBorder(Color.red));

        JLabel lbWe = new JLabel("THỨ 4");
        lbWe.setBounds(
                lbTu.getX() + lbTu.getWidth(),
                lbTu.getY(),
                lbTu.getWidth(),
                lbTu.getHeight()

        );
        lbWe.setFont(new Font(fontName, Font.BOLD, fontSize));
        lbWe.setHorizontalAlignment(SwingConstants.CENTER);
        lbWe.setVerticalAlignment(SwingConstants.CENTER);
        lbWe.setBorder(BorderFactory.createLineBorder(Color.red));

        JLabel lbTh = new JLabel("THỨ 5");
        lbTh.setBounds(
                lbWe.getX() + lbWe.getWidth(),
                lbWe.getY(),
                lbWe.getWidth(),
                lbWe.getHeight()

        );
        lbTh.setFont(new Font(fontName, Font.BOLD, fontSize));
        lbTh.setHorizontalAlignment(SwingConstants.CENTER);
        lbTh.setVerticalAlignment(SwingConstants.CENTER);
        lbTh.setBorder(BorderFactory.createLineBorder(Color.red));

        JLabel lbFr = new JLabel("THỨ 6");
        lbFr.setBounds(
                lbTh.getX() + lbTh.getWidth() - 2,
                lbTh.getY(),
                lbTh.getWidth(),
                lbTh.getHeight()

        );
        lbFr.setFont(new Font(fontName, Font.BOLD, fontSize));
        lbFr.setHorizontalAlignment(SwingConstants.CENTER);
        lbFr.setVerticalAlignment(SwingConstants.CENTER);
        lbFr.setBorder(BorderFactory.createLineBorder(Color.red));

        JLabel lbSt = new JLabel("THỨ 7");
        lbSt.setBounds(
                lbFr.getX() + lbFr.getWidth() - 2,
                lbFr.getY(),
                lbFr.getWidth(),
                lbFr.getHeight()

        );
        lbSt.setFont(new Font(fontName, Font.BOLD, fontSize));
        lbSt.setHorizontalAlignment(SwingConstants.CENTER);
        lbSt.setVerticalAlignment(SwingConstants.CENTER);
        lbSt.setBorder(BorderFactory.createLineBorder(Color.red));

        JLabel lbSu = new JLabel("CHỦ NHẬT");
        lbSu.setBounds(
                lbSt.getX() + lbSt.getWidth(),
                lbSt.getY(),
                lbSt.getWidth() + 1,
                lbSt.getHeight()

        );
        lbSu.setFont(new Font(fontName, Font.BOLD, fontSize));
        lbSu.setHorizontalAlignment(SwingConstants.CENTER);
        lbSu.setVerticalAlignment(SwingConstants.CENTER);
        lbSu.setBorder(BorderFactory.createLineBorder(Color.red));

        JLabel lbSpace2 = new JLabel();
        lbSpace2.setBounds(
                lbSu.getX() + lbSu.getWidth(),
                lbSu.getY(),
                lbSu.getWidth() + 2,
                lbSu.getHeight()

        );
        lbSpace2.setOpaque(true);
        lbSpace2.setBackground(Color.red);
        lbSpace2.setBorder(BorderFactory.createLineBorder(Color.red));

        JLabel lbKip1L = new JLabel("Kíp 1");
        lbKip1L.setBounds(
                lbSpace1.getX(),
                lbSpace1.getY() + lbSpace1.getHeight(),
                lbSpace1.getWidth(),
                lbSpace1.getHeight()

        );
        lbKip1L.setFont(new Font(fontName, Font.BOLD, fontSize));
        lbKip1L.setHorizontalAlignment(SwingConstants.CENTER);
        lbKip1L.setVerticalAlignment(SwingConstants.CENTER);
        lbKip1L.setBorder(BorderFactory.createLineBorder(Color.red));

        JLabel lbKip2L = new JLabel("Kíp 2");
        lbKip2L.setBounds(
                lbKip1L.getX(),
                lbKip1L.getY() + lbKip1L.getHeight(),
                lbKip1L.getWidth(),
                lbKip1L.getHeight()

        );
        lbKip2L.setFont(new Font(fontName, Font.BOLD, fontSize));
        lbKip2L.setHorizontalAlignment(SwingConstants.CENTER);
        lbKip2L.setVerticalAlignment(SwingConstants.CENTER);
        lbKip2L.setBorder(BorderFactory.createLineBorder(Color.red));

        JLabel lbKip3L = new JLabel("Kíp 3");
        lbKip3L.setBounds(
                lbKip2L.getX(),
                lbKip2L.getY() + lbKip2L.getHeight(),
                lbKip2L.getWidth(),
                lbKip2L.getHeight()

        );
        lbKip3L.setFont(new Font(fontName, Font.BOLD, fontSize));
        lbKip3L.setHorizontalAlignment(SwingConstants.CENTER);
        lbKip3L.setVerticalAlignment(SwingConstants.CENTER);
        lbKip3L.setBorder(BorderFactory.createLineBorder(Color.red));

        JLabel lbKip4L = new JLabel("Kíp 4");
        lbKip4L.setBounds(
                lbKip3L.getX(),
                lbKip3L.getY() + lbKip3L.getHeight(),
                lbKip3L.getWidth(),
                lbKip3L.getHeight()

        );
        lbKip4L.setFont(new Font(fontName, Font.BOLD, fontSize));
        lbKip4L.setHorizontalAlignment(SwingConstants.CENTER);
        lbKip4L.setVerticalAlignment(SwingConstants.CENTER);
        lbKip4L.setBorder(BorderFactory.createLineBorder(Color.red));

        JLabel lbKip5L = new JLabel("Kíp 5");
        lbKip5L.setBounds(
                lbKip4L.getX(),
                lbKip4L.getY() + lbKip4L.getHeight(),
                lbKip4L.getWidth(),
                lbKip4L.getHeight()

        );
        lbKip5L.setFont(new Font(fontName, Font.BOLD, fontSize));
        lbKip5L.setHorizontalAlignment(SwingConstants.CENTER);
        lbKip5L.setVerticalAlignment(SwingConstants.CENTER);
        lbKip5L.setBorder(BorderFactory.createLineBorder(Color.red));

        JLabel lbKip6L = new JLabel("Kíp 6");
        lbKip6L.setBounds(
                lbKip5L.getX(),
                lbKip5L.getY() + lbKip5L.getHeight(),
                lbKip5L.getWidth(),
                lbKip5L.getHeight()

        );
        lbKip6L.setFont(new Font(fontName, Font.BOLD, fontSize));
        lbKip6L.setHorizontalAlignment(SwingConstants.CENTER);
        lbKip6L.setVerticalAlignment(SwingConstants.CENTER);
        lbKip6L.setBorder(BorderFactory.createLineBorder(Color.red));

        JLabel lbSpace3 = new JLabel();
        lbSpace3.setBounds(
                lbKip6L.getX(),
                lbKip6L.getY() + lbKip6L.getHeight(),
                lbKip6L.getWidth() + 2,
                lbKip6L.getHeight()

        );
        lbSpace3.setOpaque(true);
        lbSpace3.setBackground(Color.red);
        lbSpace3.setBorder(BorderFactory.createLineBorder(Color.red));


        JLabel lbSpaceLast = new JLabel();
        lbSpaceLast.setBounds(
                lbSpace3.getX() + maxWidthLabel,
                lbSpace3.getY(),
                panelShowSchedule.getWidth() - maxWidthLabel * 2,
                maxHeightLabel

        );
        lbSpaceLast.setBorder(BorderFactory.createLineBorder(Color.red));

        JLabel lbSpaceRight = new JLabel();
        lbSpaceRight.setBounds(
                lbSpace2.getX(),
                lbKip1L.getY(),
                maxWidthLabel,
                panelShowSchedule.getHeight() - maxHeightLabel * 2

        );
        lbSpaceRight.setBorder(BorderFactory.createLineBorder(Color.red));

        JLabel lbSpace4 = new JLabel();
        lbSpace4.setBounds(
                lbSpaceLast.getWidth() + maxWidthLabel - 3,
                lbSpaceLast.getY(),
                maxWidthLabel,
                maxHeightLabel

        );
        lbSpace4.setOpaque(true);
        lbSpace4.setBackground(Color.red);
        lbSpace4.setBorder(BorderFactory.createLineBorder(Color.red));

        lbT2K1 = new JLabelCustom(showMoreInformation);
        lbT2K1.setBounds(
                lbMo.getX(),
                lbKip1L.getY(),
                maxWidthLabel,
                maxHeightLabel
        );
        lbT2K1.setBorder(BorderFactory.createLineBorder(Color.red));
        lbT2K1.setHorizontalAlignment(SwingConstants.CENTER);
        lbT2K1.setVerticalAlignment(SwingConstants.CENTER);

        lbT2K2 = new JLabelCustom(showMoreInformation);
        lbT2K2.setBounds(
                lbMo.getX(),
                lbKip2L.getY(),
                maxWidthLabel,
                maxHeightLabel
        );
        lbT2K2.setBorder(BorderFactory.createLineBorder(Color.red));
        lbT2K2.setHorizontalAlignment(SwingConstants.CENTER);
        lbT2K2.setVerticalAlignment(SwingConstants.CENTER);

        lbT2K3 = new JLabelCustom(showMoreInformation);
        lbT2K3.setBounds(
                lbMo.getX(),
                lbKip3L.getY(),
                maxWidthLabel,
                maxHeightLabel
        );
        lbT2K3.setBorder(BorderFactory.createLineBorder(Color.red));
        lbT2K3.setHorizontalAlignment(SwingConstants.CENTER);
        lbT2K3.setVerticalAlignment(SwingConstants.CENTER);

        lbT2K4 = new JLabelCustom(showMoreInformation);
        lbT2K4.setBounds(
                lbMo.getX(),
                lbKip4L.getY(),
                maxWidthLabel,
                maxHeightLabel
        );
        lbT2K4.setBorder(BorderFactory.createLineBorder(Color.red));
        lbT2K4.setHorizontalAlignment(SwingConstants.CENTER);
        lbT2K4.setVerticalAlignment(SwingConstants.CENTER);

        lbT2K5 = new JLabelCustom(showMoreInformation);
        lbT2K5.setBounds(
                lbMo.getX(),
                lbKip5L.getY(),
                maxWidthLabel,
                maxHeightLabel
        );
        lbT2K5.setBorder(BorderFactory.createLineBorder(Color.red));
        lbT2K5.setHorizontalAlignment(SwingConstants.CENTER);
        lbT2K5.setVerticalAlignment(SwingConstants.CENTER);

        lbT2K6 = new JLabelCustom(showMoreInformation);
        lbT2K6.setBounds(
                lbMo.getX(),
                lbKip6L.getY(),
                maxWidthLabel,
                maxHeightLabel
        );
        lbT2K6.setBorder(BorderFactory.createLineBorder(Color.red));
        lbT2K6.setHorizontalAlignment(SwingConstants.CENTER);
        lbT2K6.setVerticalAlignment(SwingConstants.CENTER);

        lbT3K1 = new JLabelCustom(showMoreInformation);
        lbT3K1.setBounds(
                lbTu.getX(),
                lbKip1L.getY(),
                maxWidthLabel,
                maxHeightLabel
        );
        lbT3K1.setBorder(BorderFactory.createLineBorder(Color.red));
        lbT3K1.setHorizontalAlignment(SwingConstants.CENTER);
        lbT3K1.setVerticalAlignment(SwingConstants.CENTER);

        lbT3K2 = new JLabelCustom(showMoreInformation);
        lbT3K2.setBounds(
                lbTu.getX(),
                lbKip2L.getY(),
                maxWidthLabel,
                maxHeightLabel
        );
        lbT3K2.setBorder(BorderFactory.createLineBorder(Color.red));
        lbT3K2.setHorizontalAlignment(SwingConstants.CENTER);
        lbT3K2.setVerticalAlignment(SwingConstants.CENTER);

        lbT3K3 = new JLabelCustom(showMoreInformation);
        lbT3K3.setBounds(
                lbTu.getX(),
                lbKip3L.getY(),
                maxWidthLabel,
                maxHeightLabel
        );
        lbT3K3.setBorder(BorderFactory.createLineBorder(Color.red));
        lbT3K3.setHorizontalAlignment(SwingConstants.CENTER);
        lbT3K3.setVerticalAlignment(SwingConstants.CENTER);

        lbT3K4 = new JLabelCustom(showMoreInformation);
        lbT3K4.setBounds(
                lbTu.getX(),
                lbKip4L.getY(),
                maxWidthLabel,
                maxHeightLabel
        );
        lbT3K4.setBorder(BorderFactory.createLineBorder(Color.red));
        lbT3K4.setHorizontalAlignment(SwingConstants.CENTER);
        lbT3K4.setVerticalAlignment(SwingConstants.CENTER);

        lbT3K5 = new JLabelCustom(showMoreInformation);
        lbT3K5.setBounds(
                lbTu.getX(),
                lbKip5L.getY(),
                maxWidthLabel,
                maxHeightLabel
        );
        lbT3K5.setBorder(BorderFactory.createLineBorder(Color.red));
        lbT3K5.setHorizontalAlignment(SwingConstants.CENTER);
        lbT3K5.setVerticalAlignment(SwingConstants.CENTER);

        lbT3K6 = new JLabelCustom(showMoreInformation);
        lbT3K6.setBounds(
                lbTu.getX(),
                lbKip6L.getY(),
                maxWidthLabel,
                maxHeightLabel
        );
        lbT3K6.setBorder(BorderFactory.createLineBorder(Color.red));
        lbT3K6.setHorizontalAlignment(SwingConstants.CENTER);
        lbT3K6.setVerticalAlignment(SwingConstants.CENTER);

        lbT4K1 = new JLabelCustom(showMoreInformation);
        lbT4K1.setBounds(
                lbWe.getX(),
                lbKip1L.getY(),
                maxWidthLabel,
                maxHeightLabel
        );
        lbT4K1.setBorder(BorderFactory.createLineBorder(Color.red));
        lbT4K1.setHorizontalAlignment(SwingConstants.CENTER);
        lbT4K1.setVerticalAlignment(SwingConstants.CENTER);

        lbT4K2 = new JLabelCustom(showMoreInformation);
        lbT4K2.setBounds(
                lbWe.getX(),
                lbKip2L.getY(),
                maxWidthLabel,
                maxHeightLabel
        );
        lbT4K2.setBorder(BorderFactory.createLineBorder(Color.red));
        lbT4K2.setHorizontalAlignment(SwingConstants.CENTER);
        lbT4K2.setVerticalAlignment(SwingConstants.CENTER);

        lbT4K3 = new JLabelCustom(showMoreInformation);
        lbT4K3.setBounds(
                lbWe.getX(),
                lbKip3L.getY(),
                maxWidthLabel,
                maxHeightLabel
        );
        lbT4K3.setBorder(BorderFactory.createLineBorder(Color.red));
        lbT4K3.setHorizontalAlignment(SwingConstants.CENTER);
        lbT4K3.setVerticalAlignment(SwingConstants.CENTER);

        lbT4K4 = new JLabelCustom(showMoreInformation);
        lbT4K4.setBounds(
                lbWe.getX(),
                lbKip4L.getY(),
                maxWidthLabel,
                maxHeightLabel
        );
        lbT4K4.setBorder(BorderFactory.createLineBorder(Color.red));
        lbT4K4.setHorizontalAlignment(SwingConstants.CENTER);
        lbT4K4.setVerticalAlignment(SwingConstants.CENTER);

        lbT4K5 = new JLabelCustom(showMoreInformation);
        lbT4K5.setBounds(
                lbWe.getX(),
                lbKip5L.getY(),
                maxWidthLabel,
                maxHeightLabel
        );
        lbT4K5.setBorder(BorderFactory.createLineBorder(Color.red));
        lbT4K5.setHorizontalAlignment(SwingConstants.CENTER);
        lbT4K5.setVerticalAlignment(SwingConstants.CENTER);

        lbT4K6 = new JLabelCustom(showMoreInformation);
        lbT4K6.setBounds(
                lbWe.getX(),
                lbKip6L.getY(),
                maxWidthLabel,
                maxHeightLabel
        );
        lbT4K6.setBorder(BorderFactory.createLineBorder(Color.red));
        lbT4K6.setHorizontalAlignment(SwingConstants.CENTER);
        lbT4K6.setVerticalAlignment(SwingConstants.CENTER);

        lbT5K1 = new JLabelCustom(showMoreInformation);
        lbT5K1.setBounds(
                lbTh.getX(),
                lbKip1L.getY(),
                maxWidthLabel,
                maxHeightLabel
        );
        lbT5K1.setBorder(BorderFactory.createLineBorder(Color.red));
        lbT5K1.setHorizontalAlignment(SwingConstants.CENTER);
        lbT5K1.setVerticalAlignment(SwingConstants.CENTER);

        lbT5K2 = new JLabelCustom(showMoreInformation);
        lbT5K2.setBounds(
                lbTh.getX(),
                lbKip2L.getY(),
                maxWidthLabel,
                maxHeightLabel
        );
        lbT5K2.setBorder(BorderFactory.createLineBorder(Color.red));
        lbT5K2.setHorizontalAlignment(SwingConstants.CENTER);
        lbT5K2.setVerticalAlignment(SwingConstants.CENTER);

        lbT5K3 = new JLabelCustom(showMoreInformation);
        lbT5K3.setBounds(
                lbTh.getX(),
                lbKip3L.getY(),
                maxWidthLabel,
                maxHeightLabel
        );
        lbT5K3.setBorder(BorderFactory.createLineBorder(Color.red));
        lbT5K3.setHorizontalAlignment(SwingConstants.CENTER);
        lbT5K3.setVerticalAlignment(SwingConstants.CENTER);

        lbT5K4 = new JLabelCustom(showMoreInformation);
        lbT5K4.setBounds(
                lbTh.getX(),
                lbKip4L.getY(),
                maxWidthLabel,
                maxHeightLabel
        );
        lbT5K4.setBorder(BorderFactory.createLineBorder(Color.red));
        lbT5K4.setHorizontalAlignment(SwingConstants.CENTER);
        lbT5K4.setVerticalAlignment(SwingConstants.CENTER);

        lbT5K5 = new JLabelCustom(showMoreInformation);
        lbT5K5.setBounds(
                lbTh.getX(),
                lbKip5L.getY(),
                maxWidthLabel,
                maxHeightLabel
        );
        lbT5K5.setBorder(BorderFactory.createLineBorder(Color.red));
        lbT5K5.setHorizontalAlignment(SwingConstants.CENTER);
        lbT5K5.setVerticalAlignment(SwingConstants.CENTER);

        lbT5K6 = new JLabelCustom(showMoreInformation);
        lbT5K6.setBounds(
                lbTh.getX(),
                lbKip6L.getY(),
                maxWidthLabel,
                maxHeightLabel
        );
        lbT5K6.setBorder(BorderFactory.createLineBorder(Color.red));
        lbT5K6.setHorizontalAlignment(SwingConstants.CENTER);
        lbT5K6.setVerticalAlignment(SwingConstants.CENTER);

        lbT6K1 = new JLabelCustom(showMoreInformation);
        lbT6K1.setBounds(
                lbFr.getX(),
                lbKip1L.getY(),
                maxWidthLabel,
                maxHeightLabel
        );
        lbT6K1.setBorder(BorderFactory.createLineBorder(Color.red));
        lbT6K1.setHorizontalAlignment(SwingConstants.CENTER);
        lbT6K1.setVerticalAlignment(SwingConstants.CENTER);

        lbT6K2 = new JLabelCustom(showMoreInformation);
        lbT6K2.setBounds(
                lbFr.getX(),
                lbKip2L.getY(),
                maxWidthLabel,
                maxHeightLabel
        );
        lbT6K2.setBorder(BorderFactory.createLineBorder(Color.red));
        lbT6K2.setHorizontalAlignment(SwingConstants.CENTER);
        lbT6K2.setVerticalAlignment(SwingConstants.CENTER);

        lbT6K3 = new JLabelCustom(showMoreInformation);
        lbT6K3.setBounds(
                lbFr.getX(),
                lbKip3L.getY(),
                maxWidthLabel,
                maxHeightLabel
        );
        lbT6K3.setBorder(BorderFactory.createLineBorder(Color.red));
        lbT6K3.setHorizontalAlignment(SwingConstants.CENTER);
        lbT6K3.setVerticalAlignment(SwingConstants.CENTER);

        lbT6K4 = new JLabelCustom(showMoreInformation);
        lbT6K4.setBounds(
                lbFr.getX(),
                lbKip4L.getY(),
                maxWidthLabel,
                maxHeightLabel
        );
        lbT6K4.setBorder(BorderFactory.createLineBorder(Color.red));
        lbT6K4.setHorizontalAlignment(SwingConstants.CENTER);
        lbT6K4.setVerticalAlignment(SwingConstants.CENTER);

        lbT6K5 = new JLabelCustom(showMoreInformation);
        lbT6K5.setBounds(
                lbFr.getX(),
                lbKip5L.getY(),
                maxWidthLabel,
                maxHeightLabel
        );
        lbT6K5.setBorder(BorderFactory.createLineBorder(Color.red));
        lbT6K5.setHorizontalAlignment(SwingConstants.CENTER);
        lbT6K5.setVerticalAlignment(SwingConstants.CENTER);

        lbT6K6 = new JLabelCustom(showMoreInformation);
        lbT6K6.setBounds(
                lbFr.getX(),
                lbKip6L.getY(),
                maxWidthLabel,
                maxHeightLabel
        );
        lbT6K6.setBorder(BorderFactory.createLineBorder(Color.red));
        lbT6K6.setHorizontalAlignment(SwingConstants.CENTER);
        lbT6K6.setVerticalAlignment(SwingConstants.CENTER);

        lbT7K1 = new JLabelCustom(showMoreInformation);
        lbT7K1.setBounds(
                lbSt.getX(),
                lbKip1L.getY(),
                maxWidthLabel,
                maxHeightLabel
        );
        lbT7K1.setBorder(BorderFactory.createLineBorder(Color.red));
        lbT7K1.setHorizontalAlignment(SwingConstants.CENTER);
        lbT7K1.setVerticalAlignment(SwingConstants.CENTER);

        lbT7K2 = new JLabelCustom(showMoreInformation);
        lbT7K2.setBounds(
                lbSt.getX(),
                lbKip2L.getY(),
                maxWidthLabel,
                maxHeightLabel
        );
        lbT7K2.setBorder(BorderFactory.createLineBorder(Color.red));
        lbT7K2.setHorizontalAlignment(SwingConstants.CENTER);
        lbT7K2.setVerticalAlignment(SwingConstants.CENTER);

        lbT7K3 = new JLabelCustom(showMoreInformation);
        lbT7K3.setBounds(
                lbSt.getX(),
                lbKip3L.getY(),
                maxWidthLabel,
                maxHeightLabel
        );
        lbT7K3.setBorder(BorderFactory.createLineBorder(Color.red));
        lbT7K3.setHorizontalAlignment(SwingConstants.CENTER);
        lbT7K3.setVerticalAlignment(SwingConstants.CENTER);

        lbT7K4 = new JLabelCustom(showMoreInformation);
        lbT7K4.setBounds(
                lbSt.getX(),
                lbKip4L.getY(),
                maxWidthLabel,
                maxHeightLabel
        );
        lbT7K4.setBorder(BorderFactory.createLineBorder(Color.red));
        lbT7K4.setHorizontalAlignment(SwingConstants.CENTER);
        lbT7K4.setVerticalAlignment(SwingConstants.CENTER);

        lbT7K5 = new JLabelCustom(showMoreInformation);
        lbT7K5.setBounds(
                lbSt.getX(),
                lbKip5L.getY(),
                maxWidthLabel,
                maxHeightLabel
        );
        lbT7K5.setBorder(BorderFactory.createLineBorder(Color.red));
        lbT7K5.setHorizontalAlignment(SwingConstants.CENTER);
        lbT7K5.setVerticalAlignment(SwingConstants.CENTER);

        lbT7K6 = new JLabelCustom(showMoreInformation);
        lbT7K6.setBounds(
                lbSt.getX(),
                lbKip6L.getY(),
                maxWidthLabel,
                maxHeightLabel
        );
        lbT7K6.setBorder(BorderFactory.createLineBorder(Color.red));
        lbT7K6.setHorizontalAlignment(SwingConstants.CENTER);
        lbT7K6.setVerticalAlignment(SwingConstants.CENTER);

        JLabel lbCNK1 = new JLabel();
        lbCNK1.setBounds(
                lbSu.getX(),
                lbKip1L.getY(),
                maxWidthLabel + 1,
                maxHeightLabel
        );
        lbCNK1.setBorder(BorderFactory.createLineBorder(Color.red));
        lbCNK1.setHorizontalAlignment(SwingConstants.CENTER);
        lbCNK1.setVerticalAlignment(SwingConstants.CENTER);

        JLabel lbCNK2 = new JLabel();
        lbCNK2.setBounds(
                lbSu.getX(),
                lbKip2L.getY(),
                maxWidthLabel + 1,
                maxHeightLabel
        );
        lbCNK2.setBorder(BorderFactory.createLineBorder(Color.red));
        lbCNK2.setHorizontalAlignment(SwingConstants.CENTER);
        lbCNK2.setVerticalAlignment(SwingConstants.CENTER);

        JLabel lbCNK3 = new JLabel();
        lbCNK3.setBounds(
                lbSu.getX(),
                lbKip3L.getY(),
                maxWidthLabel + 1,
                maxHeightLabel
        );
        lbCNK3.setBorder(BorderFactory.createLineBorder(Color.red));
        lbCNK3.setHorizontalAlignment(SwingConstants.CENTER);
        lbCNK3.setVerticalAlignment(SwingConstants.CENTER);

        JLabel lbCNK4 = new JLabel();
        lbCNK4.setBounds(
                lbSu.getX(),
                lbKip4L.getY(),
                maxWidthLabel + 1,
                maxHeightLabel
        );
        lbCNK4.setBorder(BorderFactory.createLineBorder(Color.red));
        lbCNK4.setHorizontalAlignment(SwingConstants.CENTER);
        lbCNK4.setVerticalAlignment(SwingConstants.CENTER);

        JLabel lbCNK5 = new JLabel();
        lbCNK5.setBounds(
                lbSu.getX(),
                lbKip5L.getY(),
                maxWidthLabel + 1,
                maxHeightLabel
        );
        lbCNK5.setBorder(BorderFactory.createLineBorder(Color.red));
        lbCNK5.setHorizontalAlignment(SwingConstants.CENTER);
        lbCNK5.setVerticalAlignment(SwingConstants.CENTER);

        JLabel lbCNK6 = new JLabel();
        lbCNK6.setBounds(
                lbSu.getX(),
                lbKip6L.getY(),
                maxWidthLabel + 1,
                maxHeightLabel
        );
        lbCNK6.setBorder(BorderFactory.createLineBorder(Color.red));
        lbCNK6.setHorizontalAlignment(SwingConstants.CENTER);
        lbCNK6.setVerticalAlignment(SwingConstants.CENTER);
        lbCNK6.setName("cn");

        panelShowSchedule.add(showMoreInformation);
        panelShowSchedule.add(lbSpace1);
        panelShowSchedule.add(lbMo);
        panelShowSchedule.add(lbTu);
        panelShowSchedule.add(lbWe);
        panelShowSchedule.add(lbTh);
        panelShowSchedule.add(lbFr);
        panelShowSchedule.add(lbSt);
        panelShowSchedule.add(lbSu);
        panelShowSchedule.add(lbSpace2);
        panelShowSchedule.add(lbKip1L);
        panelShowSchedule.add(lbKip2L);
        panelShowSchedule.add(lbKip3L);
        panelShowSchedule.add(lbKip4L);
        panelShowSchedule.add(lbKip5L);
        panelShowSchedule.add(lbKip6L);
        panelShowSchedule.add(lbSpace3);
        panelShowSchedule.add(lbSpaceRight);
        panelShowSchedule.add(lbT2K1);
        lbT2K1.setName("lbT2K1");
        panelShowSchedule.add(lbT2K2);
        lbT2K2.setName("lbT2K2");
        panelShowSchedule.add(lbT2K3);
        lbT2K3.setName("lbT2K3");
        panelShowSchedule.add(lbT2K4);
        lbT2K4.setName("lbT2K4");
        panelShowSchedule.add(lbT2K5);
        lbT2K5.setName("lbT2K5");
        panelShowSchedule.add(lbT2K6);
        lbT2K6.setName("lbT2K6");
        panelShowSchedule.add(lbT3K1);
        lbT3K1.setName("lbT3K1");
        panelShowSchedule.add(lbT3K2);
        lbT3K2.setName("lbT3K2");
        panelShowSchedule.add(lbT3K3);
        lbT3K3.setName("lbT3K3");
        panelShowSchedule.add(lbT3K4);
        lbT3K4.setName("lbT3K4");
        panelShowSchedule.add(lbT3K5);
        lbT3K5.setName("lbT3K5");
        panelShowSchedule.add(lbT3K6);
        lbT3K6.setName("lbT3K6");
        panelShowSchedule.add(lbT4K1);
        lbT4K1.setName("lbT4K1");
        panelShowSchedule.add(lbT4K2);
        lbT4K2.setName("lbT4K2");
        panelShowSchedule.add(lbT4K3);
        lbT4K3.setName("lbT4K3");
        panelShowSchedule.add(lbT4K4);
        lbT4K4.setName("lbT4K4");
        panelShowSchedule.add(lbT4K5);
        lbT4K5.setName("lbT4K5");
        panelShowSchedule.add(lbT4K6);
        lbT4K6.setName("lbT4K6");
        panelShowSchedule.add(lbT5K1);
        lbT5K1.setName("lbT5K1");
        panelShowSchedule.add(lbT5K2);
        lbT5K2.setName("lbT5K2");
        panelShowSchedule.add(lbT5K3);
        lbT5K3.setName("lbT5K3");
        panelShowSchedule.add(lbT5K4);
        lbT5K4.setName("lbT5K4");
        panelShowSchedule.add(lbT5K5);
        lbT5K5.setName("lbT5K5");
        panelShowSchedule.add(lbT5K6);
        lbT5K6.setName("lbT5K6");
        panelShowSchedule.add(lbT6K1);
        lbT6K1.setName("lbT6K1");
        panelShowSchedule.add(lbT6K2);
        lbT6K2.setName("lbT6K2");
        panelShowSchedule.add(lbT6K3);
        lbT6K3.setName("lbT6K3");
        panelShowSchedule.add(lbT6K4);
        lbT6K4.setName("lbT6K4");
        panelShowSchedule.add(lbT6K5);
        lbT6K5.setName("lbT6K5");
        panelShowSchedule.add(lbT6K6);
        lbT6K6.setName("lbT6K6");
        panelShowSchedule.add(lbT7K1);
        lbT7K1.setName("lbT7K1");
        panelShowSchedule.add(lbT7K2);
        lbT7K2.setName("lbT7K2");
        panelShowSchedule.add(lbT7K3);
        lbT7K3.setName("lbT7K3");
        panelShowSchedule.add(lbT7K4);
        lbT7K4.setName("lbT7K4");
        panelShowSchedule.add(lbT7K5);
        lbT7K5.setName("lbT7K5");
        panelShowSchedule.add(lbT7K6);
        lbT7K6.setName("lbT7K6");
        panelShowSchedule.add(lbCNK1);
        panelShowSchedule.add(lbCNK2);
        panelShowSchedule.add(lbCNK3);
        panelShowSchedule.add(lbCNK4);
        panelShowSchedule.add(lbCNK5);
        panelShowSchedule.add(lbCNK6);
        panelShowSchedule.add(lbSpaceLast);
        panelShowSchedule.add(lbSpace4);

        new ShowScheduleController(this);
    }

    @Override
    public void show(@NotNull JPanel panel) {
        super.show(panel);
        panel.add(lbSchedule);
        panel.add(comboBoxSchoolYear);
        panel.add(panelShowSchedule);
    }

    public HashMap<String, JLabelCustom> getAllComponents() {
        HashMap<String, JLabelCustom> getAllCom = new HashMap<>();
        getAllCom.put(lbT2K1.getName(), lbT2K1);
        getAllCom.put(lbT2K2.getName(), lbT2K2);
        getAllCom.put(lbT2K3.getName(), lbT2K3);
        getAllCom.put(lbT2K4.getName(), lbT2K4);
        getAllCom.put(lbT2K5.getName(), lbT2K5);
        getAllCom.put(lbT2K6.getName(), lbT2K6);
        getAllCom.put(lbT3K1.getName(), lbT3K1);
        getAllCom.put(lbT3K2.getName(), lbT3K2);
        getAllCom.put(lbT3K3.getName(), lbT3K3);
        getAllCom.put(lbT3K4.getName(), lbT3K4);
        getAllCom.put(lbT3K5.getName(), lbT3K5);
        getAllCom.put(lbT3K6.getName(), lbT3K6);
        getAllCom.put(lbT4K1.getName(), lbT4K1);
        getAllCom.put(lbT4K2.getName(), lbT4K2);
        getAllCom.put(lbT4K3.getName(), lbT4K3);
        getAllCom.put(lbT4K4.getName(), lbT4K4);
        getAllCom.put(lbT4K5.getName(), lbT4K5);
        getAllCom.put(lbT4K6.getName(), lbT4K6);
        getAllCom.put(lbT5K1.getName(), lbT5K1);
        getAllCom.put(lbT5K2.getName(), lbT5K2);
        getAllCom.put(lbT5K3.getName(), lbT5K3);
        getAllCom.put(lbT5K4.getName(), lbT5K4);
        getAllCom.put(lbT5K5.getName(), lbT5K5);
        getAllCom.put(lbT5K6.getName(), lbT5K6);
        getAllCom.put(lbT6K1.getName(), lbT6K1);
        getAllCom.put(lbT6K2.getName(), lbT6K2);
        getAllCom.put(lbT6K3.getName(), lbT6K3);
        getAllCom.put(lbT6K4.getName(), lbT6K4);
        getAllCom.put(lbT6K5.getName(), lbT6K5);
        getAllCom.put(lbT6K6.getName(), lbT6K6);
        getAllCom.put(lbT7K1.getName(), lbT7K1);
        getAllCom.put(lbT7K2.getName(), lbT7K2);
        getAllCom.put(lbT7K3.getName(), lbT7K3);
        getAllCom.put(lbT7K4.getName(), lbT7K4);
        getAllCom.put(lbT7K5.getName(), lbT7K5);
        getAllCom.put(lbT7K6.getName(), lbT7K6);
        return getAllCom;
    }

    public JPanel getPanelShowSchedule() {
        return panelShowSchedule;
    }
}

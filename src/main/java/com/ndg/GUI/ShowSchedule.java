package com.ndg.GUI;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class ShowSchedule extends ParentPanel {
    private final JLabel lbSchedule;
    private final JComboBox comboBoxSchoolYear;
    private final JPanel panelShowSchedule;
    private final JLabel lbT2K1, lbT2K2, lbT2K3, lbT2K4, lbT2K5, lbT2K6;
    private final JLabel lbT3K1, lbT3K2, lbT3K3, lbT3K4, lbT3K5, lbT3K6;
    private final JLabel lbT4K1, lbT4K2, lbT4K3, lbT4K4, lbT4K5, lbT4K6;
    private final JLabel lbT5K1, lbT5K2, lbT5K3, lbT5K4, lbT5K5, lbT5K6;
    private final JLabel lbT6K1, lbT6K2, lbT6K3, lbT6K4, lbT6K5, lbT6K6;
    private final JLabel lbT7K1, lbT7K2, lbT7K3, lbT7K4, lbT7K5, lbT7K6;
    private final JLabel lbCNK1, lbCNK2, lbCNK3, lbCNK4, lbCNK5, lbCNK6;

    public ShowSchedule(@NotNull JPanel panel) {
        super(panel.getWidth(), panel.getHeight(), -1);

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

        lbT2K1 = new JLabel("lbT2K1");
        lbT2K1.setBounds(
                lbMo.getX(),
                lbKip1L.getY(),
                maxWidthLabel,
                maxHeightLabel
        );
        lbT2K1.setBorder(BorderFactory.createLineBorder(Color.red));
        lbT2K1.setHorizontalAlignment(SwingConstants.CENTER);
        lbT2K1.setVerticalAlignment(SwingConstants.CENTER);

        lbT2K2 = new JLabel("lbT2K2");
        lbT2K2.setBounds(
                lbMo.getX(),
                lbKip2L.getY(),
                maxWidthLabel,
                maxHeightLabel
        );
        lbT2K2.setBorder(BorderFactory.createLineBorder(Color.red));
        lbT2K2.setHorizontalAlignment(SwingConstants.CENTER);
        lbT2K2.setVerticalAlignment(SwingConstants.CENTER);

        lbT2K3 = new JLabel("lbT2K3");
        lbT2K3.setBounds(
                lbMo.getX(),
                lbKip3L.getY(),
                maxWidthLabel,
                maxHeightLabel
        );
        lbT2K3.setBorder(BorderFactory.createLineBorder(Color.red));
        lbT2K3.setHorizontalAlignment(SwingConstants.CENTER);
        lbT2K3.setVerticalAlignment(SwingConstants.CENTER);

        lbT2K4 = new JLabel("lbT2K4");
        lbT2K4.setBounds(
                lbMo.getX(),
                lbKip4L.getY(),
                maxWidthLabel,
                maxHeightLabel
        );
        lbT2K4.setBorder(BorderFactory.createLineBorder(Color.red));
        lbT2K4.setHorizontalAlignment(SwingConstants.CENTER);
        lbT2K4.setVerticalAlignment(SwingConstants.CENTER);

        lbT2K5 = new JLabel("lbT2K5");
        lbT2K5.setBounds(
                lbMo.getX(),
                lbKip5L.getY(),
                maxWidthLabel,
                maxHeightLabel
        );
        lbT2K5.setBorder(BorderFactory.createLineBorder(Color.red));
        lbT2K5.setHorizontalAlignment(SwingConstants.CENTER);
        lbT2K5.setVerticalAlignment(SwingConstants.CENTER);

        lbT2K6 = new JLabel("lbT2K6");
        lbT2K6.setBounds(
                lbMo.getX(),
                lbKip6L.getY(),
                maxWidthLabel,
                maxHeightLabel
        );
        lbT2K6.setBorder(BorderFactory.createLineBorder(Color.red));
        lbT2K6.setHorizontalAlignment(SwingConstants.CENTER);
        lbT2K6.setVerticalAlignment(SwingConstants.CENTER);

        lbT3K1 = new JLabel("lbT3K1");
        lbT3K1.setBounds(
                lbTu.getX(),
                lbKip1L.getY(),
                maxWidthLabel,
                maxHeightLabel
        );
        lbT3K1.setBorder(BorderFactory.createLineBorder(Color.red));
        lbT3K1.setHorizontalAlignment(SwingConstants.CENTER);
        lbT3K1.setVerticalAlignment(SwingConstants.CENTER);

        lbT3K2 = new JLabel("lbT3K2");
        lbT3K2.setBounds(
                lbTu.getX(),
                lbKip2L.getY(),
                maxWidthLabel,
                maxHeightLabel
        );
        lbT3K2.setBorder(BorderFactory.createLineBorder(Color.red));
        lbT3K2.setHorizontalAlignment(SwingConstants.CENTER);
        lbT3K2.setVerticalAlignment(SwingConstants.CENTER);

        lbT3K3 = new JLabel("lbT3K3");
        lbT3K3.setBounds(
                lbTu.getX(),
                lbKip3L.getY(),
                maxWidthLabel,
                maxHeightLabel
        );
        lbT3K3.setBorder(BorderFactory.createLineBorder(Color.red));
        lbT3K3.setHorizontalAlignment(SwingConstants.CENTER);
        lbT3K3.setVerticalAlignment(SwingConstants.CENTER);

        lbT3K4 = new JLabel("lbT3K4");
        lbT3K4.setBounds(
                lbTu.getX(),
                lbKip4L.getY(),
                maxWidthLabel,
                maxHeightLabel
        );
        lbT3K4.setBorder(BorderFactory.createLineBorder(Color.red));
        lbT3K4.setHorizontalAlignment(SwingConstants.CENTER);
        lbT3K4.setVerticalAlignment(SwingConstants.CENTER);

        lbT3K5 = new JLabel("lbT3K5");
        lbT3K5.setBounds(
                lbTu.getX(),
                lbKip5L.getY(),
                maxWidthLabel,
                maxHeightLabel
        );
        lbT3K5.setBorder(BorderFactory.createLineBorder(Color.red));
        lbT3K5.setHorizontalAlignment(SwingConstants.CENTER);
        lbT3K5.setVerticalAlignment(SwingConstants.CENTER);

        lbT3K6 = new JLabel("lbT3K6");
        lbT3K6.setBounds(
                lbTu.getX(),
                lbKip6L.getY(),
                maxWidthLabel,
                maxHeightLabel
        );
        lbT3K6.setBorder(BorderFactory.createLineBorder(Color.red));
        lbT3K6.setHorizontalAlignment(SwingConstants.CENTER);
        lbT3K6.setVerticalAlignment(SwingConstants.CENTER);

        lbT4K1 = new JLabel("lbT4K1");
        lbT4K1.setBounds(
                lbWe.getX(),
                lbKip1L.getY(),
                maxWidthLabel,
                maxHeightLabel
        );
        lbT4K1.setBorder(BorderFactory.createLineBorder(Color.red));
        lbT4K1.setHorizontalAlignment(SwingConstants.CENTER);
        lbT4K1.setVerticalAlignment(SwingConstants.CENTER);

        lbT4K2 = new JLabel("lbT4K2");
        lbT4K2.setBounds(
                lbWe.getX(),
                lbKip2L.getY(),
                maxWidthLabel,
                maxHeightLabel
        );
        lbT4K2.setBorder(BorderFactory.createLineBorder(Color.red));
        lbT4K2.setHorizontalAlignment(SwingConstants.CENTER);
        lbT4K2.setVerticalAlignment(SwingConstants.CENTER);

        lbT4K3 = new JLabel("lbT4K3");
        lbT4K3.setBounds(
                lbWe.getX(),
                lbKip3L.getY(),
                maxWidthLabel,
                maxHeightLabel
        );
        lbT4K3.setBorder(BorderFactory.createLineBorder(Color.red));
        lbT4K3.setHorizontalAlignment(SwingConstants.CENTER);
        lbT4K3.setVerticalAlignment(SwingConstants.CENTER);

        lbT4K4 = new JLabel("lbT4K4");
        lbT4K4.setBounds(
                lbWe.getX(),
                lbKip4L.getY(),
                maxWidthLabel,
                maxHeightLabel
        );
        lbT4K4.setBorder(BorderFactory.createLineBorder(Color.red));
        lbT4K4.setHorizontalAlignment(SwingConstants.CENTER);
        lbT4K4.setVerticalAlignment(SwingConstants.CENTER);

        lbT4K5 = new JLabel("lbT4K5");
        lbT4K5.setBounds(
                lbWe.getX(),
                lbKip5L.getY(),
                maxWidthLabel,
                maxHeightLabel
        );
        lbT4K5.setBorder(BorderFactory.createLineBorder(Color.red));
        lbT4K5.setHorizontalAlignment(SwingConstants.CENTER);
        lbT4K5.setVerticalAlignment(SwingConstants.CENTER);

        lbT4K6 = new JLabel("lbT4K6");
        lbT4K6.setBounds(
                lbWe.getX(),
                lbKip6L.getY(),
                maxWidthLabel,
                maxHeightLabel
        );
        lbT4K6.setBorder(BorderFactory.createLineBorder(Color.red));
        lbT4K6.setHorizontalAlignment(SwingConstants.CENTER);
        lbT4K6.setVerticalAlignment(SwingConstants.CENTER);

        lbT5K1 = new JLabel("lbT5K1");
        lbT5K1.setBounds(
                lbTh.getX(),
                lbKip1L.getY(),
                maxWidthLabel,
                maxHeightLabel
        );
        lbT5K1.setBorder(BorderFactory.createLineBorder(Color.red));
        lbT5K1.setHorizontalAlignment(SwingConstants.CENTER);
        lbT5K1.setVerticalAlignment(SwingConstants.CENTER);

        lbT5K2 = new JLabel("lbT5K2");
        lbT5K2.setBounds(
                lbTh.getX(),
                lbKip2L.getY(),
                maxWidthLabel,
                maxHeightLabel
        );
        lbT5K2.setBorder(BorderFactory.createLineBorder(Color.red));
        lbT5K2.setHorizontalAlignment(SwingConstants.CENTER);
        lbT5K2.setVerticalAlignment(SwingConstants.CENTER);

        lbT5K3 = new JLabel("lbT5K3");
        lbT5K3.setBounds(
                lbTh.getX(),
                lbKip3L.getY(),
                maxWidthLabel,
                maxHeightLabel
        );
        lbT5K3.setBorder(BorderFactory.createLineBorder(Color.red));
        lbT5K3.setHorizontalAlignment(SwingConstants.CENTER);
        lbT5K3.setVerticalAlignment(SwingConstants.CENTER);

        lbT5K4 = new JLabel("lbT5K4");
        lbT5K4.setBounds(
                lbTh.getX(),
                lbKip4L.getY(),
                maxWidthLabel,
                maxHeightLabel
        );
        lbT5K4.setBorder(BorderFactory.createLineBorder(Color.red));
        lbT5K4.setHorizontalAlignment(SwingConstants.CENTER);
        lbT5K4.setVerticalAlignment(SwingConstants.CENTER);

        lbT5K5 = new JLabel("lbT5K5");
        lbT5K5.setBounds(
                lbTh.getX(),
                lbKip5L.getY(),
                maxWidthLabel,
                maxHeightLabel
        );
        lbT5K5.setBorder(BorderFactory.createLineBorder(Color.red));
        lbT5K5.setHorizontalAlignment(SwingConstants.CENTER);
        lbT5K5.setVerticalAlignment(SwingConstants.CENTER);

        lbT5K6 = new JLabel("lbT5K6");
        lbT5K6.setBounds(
                lbTh.getX(),
                lbKip6L.getY(),
                maxWidthLabel,
                maxHeightLabel
        );
        lbT5K6.setBorder(BorderFactory.createLineBorder(Color.red));
        lbT5K6.setHorizontalAlignment(SwingConstants.CENTER);
        lbT5K6.setVerticalAlignment(SwingConstants.CENTER);

        lbT6K1 = new JLabel("lbT6K1");
        lbT6K1.setBounds(
                lbFr.getX(),
                lbKip1L.getY(),
                maxWidthLabel,
                maxHeightLabel
        );
        lbT6K1.setBorder(BorderFactory.createLineBorder(Color.red));
        lbT6K1.setHorizontalAlignment(SwingConstants.CENTER);
        lbT6K1.setVerticalAlignment(SwingConstants.CENTER);

        lbT6K2 = new JLabel("lbT6K2");
        lbT6K2.setBounds(
                lbFr.getX(),
                lbKip2L.getY(),
                maxWidthLabel,
                maxHeightLabel
        );
        lbT6K2.setBorder(BorderFactory.createLineBorder(Color.red));
        lbT6K2.setHorizontalAlignment(SwingConstants.CENTER);
        lbT6K2.setVerticalAlignment(SwingConstants.CENTER);

        lbT6K3 = new JLabel("lbT6K3");
        lbT6K3.setBounds(
                lbFr.getX(),
                lbKip3L.getY(),
                maxWidthLabel,
                maxHeightLabel
        );
        lbT6K3.setBorder(BorderFactory.createLineBorder(Color.red));
        lbT6K3.setHorizontalAlignment(SwingConstants.CENTER);
        lbT6K3.setVerticalAlignment(SwingConstants.CENTER);

        lbT6K4 = new JLabel("lbT6K4");
        lbT6K4.setBounds(
                lbFr.getX(),
                lbKip4L.getY(),
                maxWidthLabel,
                maxHeightLabel
        );
        lbT6K4.setBorder(BorderFactory.createLineBorder(Color.red));
        lbT6K4.setHorizontalAlignment(SwingConstants.CENTER);
        lbT6K4.setVerticalAlignment(SwingConstants.CENTER);

        lbT6K5 = new JLabel("lbT6K5");
        lbT6K5.setBounds(
                lbFr.getX(),
                lbKip5L.getY(),
                maxWidthLabel,
                maxHeightLabel
        );
        lbT6K5.setBorder(BorderFactory.createLineBorder(Color.red));
        lbT6K5.setHorizontalAlignment(SwingConstants.CENTER);
        lbT6K5.setVerticalAlignment(SwingConstants.CENTER);

        lbT6K6 = new JLabel("lbT6K6");
        lbT6K6.setBounds(
                lbFr.getX(),
                lbKip6L.getY(),
                maxWidthLabel,
                maxHeightLabel
        );
        lbT6K6.setBorder(BorderFactory.createLineBorder(Color.red));
        lbT6K6.setHorizontalAlignment(SwingConstants.CENTER);
        lbT6K6.setVerticalAlignment(SwingConstants.CENTER);

        lbT7K1 = new JLabel("lbT7K1");
        lbT7K1.setBounds(
                lbSt.getX(),
                lbKip1L.getY(),
                maxWidthLabel,
                maxHeightLabel
        );
        lbT7K1.setBorder(BorderFactory.createLineBorder(Color.red));
        lbT7K1.setHorizontalAlignment(SwingConstants.CENTER);
        lbT7K1.setVerticalAlignment(SwingConstants.CENTER);

        lbT7K2 = new JLabel("lbT7K2");
        lbT7K2.setBounds(
                lbSt.getX(),
                lbKip2L.getY(),
                maxWidthLabel,
                maxHeightLabel
        );
        lbT7K2.setBorder(BorderFactory.createLineBorder(Color.red));
        lbT7K2.setHorizontalAlignment(SwingConstants.CENTER);
        lbT7K2.setVerticalAlignment(SwingConstants.CENTER);

        lbT7K3 = new JLabel("lbT7K3");
        lbT7K3.setBounds(
                lbSt.getX(),
                lbKip3L.getY(),
                maxWidthLabel,
                maxHeightLabel
        );
        lbT7K3.setBorder(BorderFactory.createLineBorder(Color.red));
        lbT7K3.setHorizontalAlignment(SwingConstants.CENTER);
        lbT7K3.setVerticalAlignment(SwingConstants.CENTER);

        lbT7K4 = new JLabel("lbT7K4");
        lbT7K4.setBounds(
                lbSt.getX(),
                lbKip4L.getY(),
                maxWidthLabel,
                maxHeightLabel
        );
        lbT7K4.setBorder(BorderFactory.createLineBorder(Color.red));
        lbT7K4.setHorizontalAlignment(SwingConstants.CENTER);
        lbT7K4.setVerticalAlignment(SwingConstants.CENTER);

        lbT7K5 = new JLabel("lbT7K5");
        lbT7K5.setBounds(
                lbSt.getX(),
                lbKip5L.getY(),
                maxWidthLabel,
                maxHeightLabel
        );
        lbT7K5.setBorder(BorderFactory.createLineBorder(Color.red));
        lbT7K5.setHorizontalAlignment(SwingConstants.CENTER);
        lbT7K5.setVerticalAlignment(SwingConstants.CENTER);

        lbT7K6 = new JLabel("lbT7K6");
        lbT7K6.setBounds(
                lbSt.getX(),
                lbKip6L.getY(),
                maxWidthLabel,
                maxHeightLabel
        );
        lbT7K6.setBorder(BorderFactory.createLineBorder(Color.red));
        lbT7K6.setHorizontalAlignment(SwingConstants.CENTER);
        lbT7K6.setVerticalAlignment(SwingConstants.CENTER);

        lbCNK1 = new JLabel("lbCNK1");
        lbCNK1.setBounds(
                lbSu.getX(),
                lbKip1L.getY(),
                maxWidthLabel + 1,
                maxHeightLabel
        );
        lbCNK1.setBorder(BorderFactory.createLineBorder(Color.red));
        lbCNK1.setHorizontalAlignment(SwingConstants.CENTER);
        lbCNK1.setVerticalAlignment(SwingConstants.CENTER);

        lbCNK2 = new JLabel("lbCNK2");
        lbCNK2.setBounds(
                lbSu.getX(),
                lbKip2L.getY(),
                maxWidthLabel + 1,
                maxHeightLabel
        );
        lbCNK2.setBorder(BorderFactory.createLineBorder(Color.red));
        lbCNK2.setHorizontalAlignment(SwingConstants.CENTER);
        lbCNK2.setVerticalAlignment(SwingConstants.CENTER);

        lbCNK3 = new JLabel("lbCNK3");
        lbCNK3.setBounds(
                lbSu.getX(),
                lbKip3L.getY(),
                maxWidthLabel + 1,
                maxHeightLabel
        );
        lbCNK3.setBorder(BorderFactory.createLineBorder(Color.red));
        lbCNK3.setHorizontalAlignment(SwingConstants.CENTER);
        lbCNK3.setVerticalAlignment(SwingConstants.CENTER);

        lbCNK4 = new JLabel("lbCNK4");
        lbCNK4.setBounds(
                lbSu.getX(),
                lbKip4L.getY(),
                maxWidthLabel + 1,
                maxHeightLabel
        );
        lbCNK4.setBorder(BorderFactory.createLineBorder(Color.red));
        lbCNK4.setHorizontalAlignment(SwingConstants.CENTER);
        lbCNK4.setVerticalAlignment(SwingConstants.CENTER);

        lbCNK5 = new JLabel("lbCNK5");
        lbCNK5.setBounds(
                lbSu.getX(),
                lbKip5L.getY(),
                maxWidthLabel + 1,
                maxHeightLabel
        );
        lbCNK5.setBorder(BorderFactory.createLineBorder(Color.red));
        lbCNK5.setHorizontalAlignment(SwingConstants.CENTER);
        lbCNK5.setVerticalAlignment(SwingConstants.CENTER);

        lbCNK6 = new JLabel("lbCNK6");
        lbCNK6.setBounds(
                lbSu.getX(),
                lbKip6L.getY(),
                maxWidthLabel + 1,
                maxHeightLabel
        );
        lbCNK6.setBorder(BorderFactory.createLineBorder(Color.red));
        lbCNK6.setHorizontalAlignment(SwingConstants.CENTER);
        lbCNK6.setVerticalAlignment(SwingConstants.CENTER);

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
        panelShowSchedule.add(lbT2K2);
        panelShowSchedule.add(lbT2K3);
        panelShowSchedule.add(lbT2K4);
        panelShowSchedule.add(lbT2K5);
        panelShowSchedule.add(lbT2K6);
        panelShowSchedule.add(lbT3K1);
        panelShowSchedule.add(lbT3K2);
        panelShowSchedule.add(lbT3K3);
        panelShowSchedule.add(lbT3K4);
        panelShowSchedule.add(lbT3K5);
        panelShowSchedule.add(lbT3K6);
        panelShowSchedule.add(lbT4K1);
        panelShowSchedule.add(lbT4K2);
        panelShowSchedule.add(lbT4K3);
        panelShowSchedule.add(lbT4K4);
        panelShowSchedule.add(lbT4K5);
        panelShowSchedule.add(lbT4K6);
        panelShowSchedule.add(lbT5K1);
        panelShowSchedule.add(lbT5K2);
        panelShowSchedule.add(lbT5K3);
        panelShowSchedule.add(lbT5K4);
        panelShowSchedule.add(lbT5K5);
        panelShowSchedule.add(lbT5K6);
        panelShowSchedule.add(lbT6K1);
        panelShowSchedule.add(lbT6K2);
        panelShowSchedule.add(lbT6K3);
        panelShowSchedule.add(lbT6K4);
        panelShowSchedule.add(lbT6K5);
        panelShowSchedule.add(lbT6K6);
        panelShowSchedule.add(lbT7K1);
        panelShowSchedule.add(lbT7K2);
        panelShowSchedule.add(lbT7K3);
        panelShowSchedule.add(lbT7K4);
        panelShowSchedule.add(lbT7K5);
        panelShowSchedule.add(lbT7K6);
        panelShowSchedule.add(lbCNK1);
        panelShowSchedule.add(lbCNK2);
        panelShowSchedule.add(lbCNK3);
        panelShowSchedule.add(lbCNK4);
        panelShowSchedule.add(lbCNK5);
        panelShowSchedule.add(lbCNK6);
        panelShowSchedule.add(lbSpaceLast);
        panelShowSchedule.add(lbSpace4);
    }

    @Override
    public void show(@NotNull JPanel panel) {
        super.show(panel);
        panel.add(lbSchedule);
        panel.add(comboBoxSchoolYear);
        panel.add(panelShowSchedule);
    }
}

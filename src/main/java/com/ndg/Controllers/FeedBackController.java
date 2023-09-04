package com.ndg.Controllers;

import com.ndg.GUI.FeedBack;
import org.jetbrains.annotations.NotNull;
import javax.swing.JOptionPane;


public class FeedBackController {
    public FeedBackController(@NotNull FeedBack feedBack) {
        feedBack.getButtonOK().addActionListener(e -> {
            if (feedBack.getSubject().getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(
                        new JOptionPane(),
                        "Bạn không được để trống chủ đề",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            if (feedBack.getContent().getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(
                        new JOptionPane(),
                        "Bạn không được để trống nội dung",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            int choose = JOptionPane.showConfirmDialog(
                    new JOptionPane(),
                    "Bạn có muốn gửi cho admin không?",
                    "Thông tin",
                    JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE
            );

            if (choose == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(
                        new JOptionPane(),
                        "Cảm ơn bạn đã phản hồi về với chúng tôi\nChúng tôi sẽ trả lời bạn sớm nhất",
                        "Thông tin",
                        JOptionPane.INFORMATION_MESSAGE
                );
                feedBack.setVisible(false);
            }
        });




        feedBack.getButtonCancel().addActionListener(e -> {
            if (!feedBack.getSubject().getText().trim().isEmpty() || !feedBack.getContent().getText().trim().isEmpty()) {
                int choose = JOptionPane.showConfirmDialog(
                        new JOptionPane(),
                        "Bạn có muốn hủy bản feedback này không?",
                        "Warning",
                        JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE
                );
                if (choose == JOptionPane.YES_OPTION) {
                    feedBack.setVisible(false);
                }
            } else {
                feedBack.setVisible(false);
            }
        });
    }
}

package dao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cha {
    public static void cha(){
        JDialog cheatDialog = new JDialog();
        cheatDialog.setLayout(new BorderLayout());

        // 创建一个文字标签
        JLabel cheatLabel = new JLabel("金手指只有这么多选项，开发者研发中！o.O");
        cheatLabel.setHorizontalAlignment(SwingConstants.CENTER);
        cheatLabel.setVerticalAlignment(SwingConstants.CENTER);
        cheatLabel.setFont(new Font("微软雅黑", Font.BOLD, 20));
        cheatDialog.add(cheatLabel, BorderLayout.CENTER);

        // 创建一个退出按钮
        JButton exitButton = new JButton("退出");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cheatDialog.dispose();
            }
        });
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(exitButton);
        cheatDialog.add(buttonPanel, BorderLayout.SOUTH);
        // 设置对话框
        cheatDialog.setTitle("作弊提示");
        cheatDialog.setSize(420, 200);
        cheatDialog.setLocationRelativeTo(null);
        cheatDialog.setModal(true);
        cheatDialog.setVisible(true);
    }
}

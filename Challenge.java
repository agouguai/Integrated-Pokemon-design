package UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Challenge  {
    public Challenge(){
        JDialog j = new JDialog();

                j.setTitle("挑战");
                j.setSize(300, 150);
                j.setLocationRelativeTo(null); //居中显示
                j.setModal(true); // 设置为 MODAL，以模拟对话框行为

                //设置对话框内容
                JPanel contentPane = new JPanel();
                contentPane.setLayout(null);

                JLabel label = new JLabel("少年你的实力还不够强，下次再来挑战吧! O.o", SwingConstants.CENTER);
                label.setBounds(20, 20, 260, 50);
                contentPane.add(label);

                JButton btn = new JButton("退出");
                btn.setBounds(105, 80, 90, 25);
                btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JDialog j = new JDialog();
                        j.setTitle("温馨提示");
                        j.setSize(300, 150);
                        j.setLocationRelativeTo(null); //居中显示
                        j.setModal(true); // 设置为 MODAL，以模拟对话框行为
                        JPanel contentPane = new JPanel();
                        contentPane.setLayout(null);

                        JLabel label = new JLabel("去旁边的店铺买一些武器，防具强化自己吧！", SwingConstants.CENTER);
                        label.setBounds(20, 20, 260, 50);
                        contentPane.add(label);
                        j.setContentPane(contentPane);
                        j.setVisible(true);
                    }
                });
                contentPane.add(btn);
        j.setContentPane(contentPane);
                j.setVisible(true);}
}
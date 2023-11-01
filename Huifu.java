package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Huifu {
    public static void huifu() throws ClassNotFoundException, SQLException {
        JFrame f = new JFrame("精灵中心");
        f.setSize(400, 300);
        f.setLocation(1000,400);
        // 创建一个带有背景图片的JPanel
        JPanel p1 = new JPanel() {
            public void paintComponent(Graphics g) {
                Image b1 = new ImageIcon("src/images/回血.png").getImage();
                g.drawImage(b1, 0, 0, getWidth(), getHeight(), null);
            }
        };
// 将ContentPane设置为带有背景图片的JPanel
        p1.setLayout(new BorderLayout());
        f.setContentPane(p1);
        Class.forName("com.mysql.cj.jdbc.Driver");//加载驱动
        String url = "jdbc:mysql://localhost:3306/final?serverTimezone=GMT%2B8&useSSL=false";
        String user = "root";
        String password = "123456";
        Connection connection = DriverManager.getConnection(url, user, password);
        JButton exit = new JButton("恢复宝可梦的健康");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 执行更新操作
                try {
                    // 1. 连接数据库
                    // 2. 执行更新操作
                    String sql = "UPDATE pikaqiu SET hp = 50";
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.executeUpdate();
                    // 3. 关闭连接和查询
                    statement.close();
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

                // 处理 exit 按钮的逻辑
                hhh();
            }
        });
        f.add(exit,BorderLayout.PAGE_END);
        f.setVisible(true);
    }































    public static void hhh(){
        JDialog d = new JDialog();
        d.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        d.setSize(new Dimension(350, 250));
        d.setLocation(1700,150);
        d.setModal(true);

// 创建一个带有背景图片的JPanel
        JPanel contentPane = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                Image b = new ImageIcon("src/images/护士.png").getImage();
                g.drawImage(b, 0, 0, getWidth(), getHeight(), null);
            }
        };
        contentPane.setLayout(new BorderLayout());
        JPanel biaoqian = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 2));
        biaoqian.setOpaque(false);

        JLabel wenzi = new JLabel("你的宝可梦已经恢复健康了，下次不要再让他受伤了");
        biaoqian.add(wenzi);

        JButton closeButton = new JButton("谢谢你的帮助！");
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                d.dispose();
            }});
        biaoqian.add(closeButton,BorderLayout.SOUTH);
        biaoqian.setPreferredSize(new Dimension(350,100));
        contentPane.add(biaoqian, BorderLayout.PAGE_START);
        d.setContentPane(contentPane);
        d.setVisible(true);
    }
}
package UI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.*;

public class Shenti extends JFrame{
    String url = "jdbc:mysql://localhost:3306/final?serverTimezone=GMT%2B8&useSSL=false";
    String user = "root";
    String password = "123456";
    private ImageIcon bgImage;
    private JLabel imageLabel1, imageLabel2, imageLabel3;
    private JButton button1, button2, button3;
    public Shenti() throws ClassNotFoundException, IOException, SQLException {

        JFrame f = new JFrame("这是一场试炼！");
        Image b1 = ImageIO.read(new File("src/images/古拉顿.png")).getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        JLabel b = new JLabel(new ImageIcon(b1));
        Image b2 = ImageIO.read(new File("src/images/盖欧卡.png")).getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        JLabel bb = new JLabel(new ImageIcon(b2));
        Image b3 = ImageIO.read(new File("src/images/裂空座.png")).getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        JLabel bbb = new JLabel(new ImageIcon(b3));
        Image b4 = ImageIO.read(new File("src/images/喵喵.png")).getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        JLabel bbbb = new JLabel(new ImageIcon(b4));

        JPanel jPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 10));
        // 为 JPanel 添加空边框，让图片下移
        jPanel.setBorder(BorderFactory.createEmptyBorder(50, 0, 0, 0));
// 设置图片垂直居中对齐
        b.setVerticalAlignment(SwingConstants.CENTER);
        bb.setVerticalAlignment(SwingConstants.CENTER);
        bbb.setVerticalAlignment(SwingConstants.CENTER);
        bbbb.setVerticalAlignment(SwingConstants.CENTER);
        Class.forName("com.mysql.cj.jdbc.Driver");//加载驱动
        String url = "jdbc:mysql://localhost:3306/final?serverTimezone=GMT%2B8&useSSL=false";
        String user = "root";
        String password = "123456";
        Connection connection = DriverManager.getConnection(url, user, password);
// 添加图片 JLabel 到 JPanel 容器中
        jPanel.add(b);
        jPanel.add(bb);
        jPanel.add(bbb);
        jPanel.add(bbbb);
        JButton btn1 = new JButton("挑战");
        btn1.setBounds(b.getX(), b.getY() + b.getHeight(), b.getWidth(), 30);
        btn1.setSize(b.getWidth(), 30);
        jPanel.add(btn1);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // 1. 连接数据库
                    // 2. 执行更新操作
                    String sql = "UPDATE pikaqiu SET hp = 0";
                    PreparedStatement statement = connection.prepareStatement(sql);
                    int rowsAffected = statement.executeUpdate();
                    // 3. 判断是否更新成功
                    String message = "";
                    if (rowsAffected > 0) {
                        message = "你的皮卡丘太弱了打不过！请回到宝可梦中心恢复血量！";
                    } else {
                        message = "没有找到相关数据。";
                    }
                    // 4. 关闭连接和查询
                    statement.close();
                    connection.close();
                    // 5. 弹出提示框
                    JOptionPane.showMessageDialog(null, message);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton btn2 = new JButton("挑战");
        btn2.setBounds(bb.getX()+10, bb.getY() + bb.getHeight(), bb.getWidth(), 30);
        jPanel.add(btn2);
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // 1. 连接数据库
                    // 2. 执行更新操作
                    String sql = "UPDATE pikaqiu SET hp = 0";
                    PreparedStatement statement = connection.prepareStatement(sql);
                    int rowsAffected = statement.executeUpdate();
                    // 3. 判断是否更新成功
                    String message = "";
                    if (rowsAffected > 0) {
                        message = "你的皮卡丘太弱了打不过！请回到宝可梦中心恢复血量！";
                    } else {
                        message = "没有找到相关数据。";
                    }
                    // 4. 关闭连接和查询
                    statement.close();
                    connection.close();
                    // 5. 弹出提示框
                    JOptionPane.showMessageDialog(null, message);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton btn3 = new JButton("挑战");
        btn3.setBounds(bbb.getX(), bbb.getY() + bbb.getHeight(), bbb.getWidth(), 30);
        jPanel.add(btn3);
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // 1. 连接数据库
                    // 2. 执行更新操作
                    String sql = "UPDATE pikaqiu SET hp = 0";
                    PreparedStatement statement = connection.prepareStatement(sql);
                    int rowsAffected = statement.executeUpdate();
                    // 3. 判断是否更新成功
                    String message = "";
                    if (rowsAffected > 0) {
                        message = "你的皮卡丘太弱了打不过！请回到宝可梦中心恢复血量！";
                    } else {
                        message = "没有找到相关数据。";
                    }
                    // 4. 关闭连接和查询
                    statement.close();
                    connection.close();
                    // 5. 弹出提示框
                    JOptionPane.showMessageDialog(null, message);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        JButton btn4 = new JButton("欺负一下");
        btn4.setBounds(bbbb.getX(), bbbb.getY() + bbbb.getHeight(), bbbb.getWidth(), 30);
        jPanel.add(btn4);
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "喵喵太弱了，都不需要掉血");
            }
        });
// 将 JPanel 添加到 JFrame 中
        f.add(jPanel);
        f.setSize(550,380);
        f.setLocationRelativeTo(null); // 屏幕居中显示
        f.setVisible(true);
    }


    public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
        new Shenti();
    }}





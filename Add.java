package dao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Add {// 获取数据库连接

    private static String url = "jdbc:mysql://localhost:3306/final?serverTimezone=GMT%2B8&useSSL=false";
    private static String user = "root";
    private static String password = "123456";

    public static void add() throws ClassNotFoundException, SQLException {
        Frame f = new JFrame();
        f.setTitle("金手指");
        f.setSize(450, 200);
        f.setLocationRelativeTo(null);
        f.setLayout(new GridLayout(3, 5));
        // 初始化五个按钮
        JButton b0 = new JButton("序号");
        JButton b1 = new JButton("武器数量");
        JButton b2 = new JButton("防具数量");
        JButton b3 = new JButton("道具数量");
        JButton b4 = new JButton("金币数量");
        JButton b5 = new JButton("确认");
        // 初始化五个文本框
        JTextField t0 = new JTextField(10);
        JTextField t1 = new JTextField(10);
        JTextField t2 = new JTextField(10);
        JTextField t3 = new JTextField(10);
        JTextField t4 = new JTextField(10);
        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // 获取数据库连接
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection conn = DriverManager.getConnection(url, user, password);

                    // 构造更新 SQL 语句
                    String sql = "INSERT INTO beibao (xuhao,ws,fs,ds,qian) VALUES (?,?,?,?,?)";
                    // 创建 PreparedStatement 对象
                    PreparedStatement ps = conn.prepareStatement(sql);
                    // 获取文本框中的值并设置参数
                    int value1 = Integer.parseInt(t0.getText().trim());
                    int value = Integer.parseInt(t1.getText().trim());
                    int value2 = Integer.parseInt(t2.getText().trim());
                    int value3 = Integer.parseInt(t3.getText().trim());
                    int valueQian = Integer.parseInt(t4.getText().trim());
                    ps.setInt(1, value1);
                    ps.setInt(2, value);
                    ps.setInt(3, value2);
                    ps.setInt(4, value3);
                    ps.setInt(5, valueQian);
// 执行更新操作
                    ps.executeUpdate();

                    // 关闭连接和 PreparedStatement 对象
                    ps.close();
                    conn.close();
                } catch (ClassNotFoundException | SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(f, "更新失败：" + ex.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
                }
                f.dispose();}});
        JButton b6 = new JButton("确认");
        b6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // 获取数据库连接
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection conn = DriverManager.getConnection(url, user, password);

                    // 构造更新 SQL 语句
                    String sql = "INSERT INTO beibao (xuhao,ws,fs,ds,qian) VALUES (?,?,?,?,?)";

                    // 创建 PreparedStatement 对象
                    PreparedStatement ps = conn.prepareStatement(sql);
                    // 获取文本框中的值并设置参数
                    int value1 = Integer.parseInt(t0.getText().trim());
                    int value = Integer.parseInt(t1.getText().trim());
                    int value2 = Integer.parseInt(t2.getText().trim());
                    int value3 = Integer.parseInt(t3.getText().trim());
                    int valueQian = Integer.parseInt(t4.getText().trim());
                    ps.setInt(1, value1);
                    ps.setInt(2, value);
                    ps.setInt(3, value2);
                    ps.setInt(4, value3);
                    ps.setInt(5, valueQian);
// 执行更新操作
                    ps.executeUpdate();

                    // 关闭连接和 PreparedStatement 对象
                    ps.close();
                    conn.close();
                } catch (ClassNotFoundException | SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(f, "更新失败：" + ex.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
                }
                f.dispose();}});
        JButton b7 = new JButton("确认");
        b7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // 获取数据库连接
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection conn = DriverManager.getConnection(url, user, password);

                    // 构造更新 SQL 语句
                    String sql = "INSERT INTO beibao (xuhao,ws,fs,ds,qian) VALUES (?,?,?,?,?)";

                    // 创建 PreparedStatement 对象
                    PreparedStatement ps = conn.prepareStatement(sql);
                    // 获取文本框中的值并设置参数
                    int value1 = Integer.parseInt(t0.getText().trim());
                    int value = Integer.parseInt(t1.getText().trim());
                    int value2 = Integer.parseInt(t2.getText().trim());
                    int value3 = Integer.parseInt(t3.getText().trim());
                    int valueQian = Integer.parseInt(t4.getText().trim());
                    ps.setInt(1, value1);
                    ps.setInt(2, value);
                    ps.setInt(3, value2);
                    ps.setInt(4, value3);
                    ps.setInt(5, valueQian);
// 执行更新操作
                    ps.executeUpdate();

                    // 关闭连接和 PreparedStatement 对象
                    ps.close();
                    conn.close();
                } catch (ClassNotFoundException | SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(f, "更新失败：" + ex.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
                }
                f.dispose();}});
        JButton b8 = new JButton("确认");
        b8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // 获取数据库连接
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection conn = DriverManager.getConnection(url, user, password);

                    // 构造更新 SQL 语句
                    String sql = "INSERT INTO beibao (xuhao,ws,fs,ds,qian) VALUES (?,?,?,?,?)";

                    // 创建 PreparedStatement 对象
                    PreparedStatement ps = conn.prepareStatement(sql);
                    // 获取文本框中的值并设置参数
                    int value1 = Integer.parseInt(t0.getText().trim());
                    int value = Integer.parseInt(t1.getText().trim());
                    int value2 = Integer.parseInt(t2.getText().trim());
                    int value3 = Integer.parseInt(t3.getText().trim());
                    int valueQian = Integer.parseInt(t4.getText().trim());
                    ps.setInt(1, value1);
                    ps.setInt(2, value);
                    ps.setInt(3, value2);
                    ps.setInt(4, value3);
                    ps.setInt(5, valueQian);
// 执行更新操作
                    ps.executeUpdate();

                    // 关闭连接和 PreparedStatement 对象
                    ps.close();
                    conn.close();
                } catch (ClassNotFoundException | SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(f, "更新失败：" + ex.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
                }
                f.dispose();}});
        JButton b9 = new JButton("确认");
        b9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // 获取数据库连接
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    String url = "jdbc:mysql://localhost:3306/final?serverTimezone=GMT%2B8&useSSL=false";
                    String user = "root";
                    String password = "123456";
                    Connection conn = DriverManager.getConnection(url, user, password);

                    // 构造更新 SQL 语句
                    String sql = "INSERT INTO beibao (xuhao,ws,fs,ds,qian) VALUES (?,?,?,?,?)";

                    // 创建 PreparedStatement 对象
                    PreparedStatement ps = conn.prepareStatement(sql);
                    // 获取文本框中的值并设置参数
                    int value1 = Integer.parseInt(t0.getText().trim());
                    int value = Integer.parseInt(t1.getText().trim());
                    int value2 = Integer.parseInt(t2.getText().trim());
                    int value3 = Integer.parseInt(t3.getText().trim());
                    int valueQian = Integer.parseInt(t4.getText().trim());
                    ps.setInt(1, value1);
                    ps.setInt(2, value);
                    ps.setInt(3, value2);
                    ps.setInt(4, value3);
                    ps.setInt(5, valueQian);
                    // 执行更新操作
                    ps.executeUpdate();

                    // 关闭连接和 PreparedStatement 对象
                    ps.close();
                    conn.close();
                } catch (ClassNotFoundException | SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(f, "更新失败：" + ex.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
                }
                f.dispose();}});
        // 将组件添加到窗口中
        f.add(b0);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(b4);
        f.add(t0);
        f.add(t1);
        f.add(t2);
        f.add(t3);
        f.add(t4);
        f.add(b5);
        f.add(b6);
        f.add(b7);
        f.add(b8);
        f.add(b9);
        f.setVisible(true);
    }
    }

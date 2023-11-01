package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Daoju {
    public static void jj(){
        JFrame f2 = new JFrame("道具店");
        f2.setSize(new Dimension(1000, 200));
        f2.setLocation(800,500);
        JPanel p1 = new JPanel();
        ImageIcon icon = new ImageIcon("src/images/复活草.png");
        Image i = icon.getImage(); // 获取原始图片对象
        Image s = i.getScaledInstance(100, 100, Image.SCALE_SMOOTH); // 缩放图片
        ImageIcon I = new ImageIcon(s); // 创建经过缩放的图片对象
        JLabel l1 = new JLabel(I); // 创建JLabel，并传入经过缩放的图片对象
        JButton bt1 = new JButton("复活草:有一次复活机会");
        ImageIcon icon1 = new ImageIcon("src/images/元气碎片.png");
        Image i1 = icon1.getImage();
        Image s1 = i1.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon I1 = new ImageIcon(s1);
        JLabel l2 = new JLabel(I1);
        JButton bt2 = new JButton("元气碎片:复活，但是只有一半的生命值");
        ImageIcon icon2 = new ImageIcon("src/images/伤药.png");
        Image i2 = icon2.getImage();
        Image s2 = i2.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon I2 = new ImageIcon(s2);
        JLabel l3 = new JLabel(I2);
        JButton bt3 = new JButton("伤药:生命值加30");
        p1.add(bt1);p1.add(l1);
        bt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jjj1();}});
        p1.add(bt2);p1.add(l2);
        bt2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jjj2();}});
        p1.add(bt3);p1.add(l3);
        bt3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jjj3();}});
        f2.add(p1);
        f2.setVisible(true);
        // 创建退出按钮，并添加到面板中
        JButton exit = new JButton("退出");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 处理退出按钮的逻辑
                f2.dispose(); // 关闭JFrame窗口
            }
        });
        f2.add(exit,BorderLayout.PAGE_END);


















    }
    public static void jjj1(){
        JDialog j1 = new JDialog();
        j1.setTitle("价格");
        j1.setLayout(new BorderLayout()); // 修改布局方式为边框布局
        j1.setLocation(1100,400);
        j1.setSize(new Dimension(200, 100));
        j1.setModal(true);
        JLabel ll1 = new JLabel("2000");
        ll1.setPreferredSize(new Dimension(180, 30)); // 设置首选尺寸
        JPanel buttonPanel = new JPanel(new GridLayout(1,2)); // 创建一个放置按钮的面板
        JButton buy = new JButton("购买");
        JButton exit = new JButton("退出");
        buy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int price = Integer.parseInt(ll1.getText()); // 获取ll1中的数量
                if (price > 0) {
                    try {// 连接数据库
                        Class.forName("com.mysql.cj.jdbc.Driver");//加载驱动
                        String url = "jdbc:mysql://localhost:3306/final?serverTimezone=GMT%2B8&useSSL=false";
                        String user = "root";
                        String password = "123456";
                        Connection conn = DriverManager.getConnection(url, user, password);
                        Statement stmt = conn.createStatement();
                        // 查询钱包的钱
                        ResultSet rs = stmt.executeQuery("SELECT monkey FROM monkey");
                        if (rs.next()) {
                            int stock = rs.getInt("monkey");
                            if (price < stock) {
                                // 更新数据库中的库存
                                stock -= price;
                                stmt.executeUpdate("UPDATE monkey SET monkey = " + stock);
                                JOptionPane.showMessageDialog(null, "购买成功！");
                                j1.dispose();
                            } else {
                                JOptionPane.showMessageDialog(null, "没钱了，购买失败！");}}
                        rs.close();
                        stmt.close();
                        conn.close();// 关闭JDialog窗口
                    } catch (ClassNotFoundException ex) {
                        throw new RuntimeException(ex);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }}});
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                j1.dispose(); // 关闭JDialog窗口
            }
        });
        buttonPanel.add(buy);
        buttonPanel.add(exit);
        j1.add(ll1, BorderLayout.CENTER); // 将标签添加到JDialog的中心区域
        j1.add(buttonPanel, BorderLayout.SOUTH); // 将按钮添加到JDialog的底部
        j1.setVisible(true);
    }
    public static void jjj2(){
        JDialog j1 = new JDialog();
        j1.setTitle("价格");
        j1.setLayout(new BorderLayout()); // 修改布局方式为边框布局
        j1.setLocation(1200,400);
        j1.setSize(new Dimension(200, 100));
        j1.setModal(true);
        JLabel ll1 = new JLabel("1000");
        ll1.setPreferredSize(new Dimension(180, 30)); // 设置首选尺寸
        JPanel buttonPanel = new JPanel(new GridLayout(1,2)); // 创建一个放置按钮的面板
        JButton buy = new JButton("购买");
        JButton exit = new JButton("退出");
        buy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int price = Integer.parseInt(ll1.getText()); // 获取ll1中的数量
                if (price > 0) {
                    try {// 连接数据库
                        Class.forName("com.mysql.cj.jdbc.Driver");//加载驱动
                        String url = "jdbc:mysql://localhost:3306/final?serverTimezone=GMT%2B8&useSSL=false";
                        String user = "root";
                        String password = "123456";
                        Connection conn = DriverManager.getConnection(url, user, password);
                        Statement stmt = conn.createStatement();
                        // 查询钱包的钱
                        ResultSet rs = stmt.executeQuery("SELECT monkey FROM monkey");
                        if (rs.next()) {
                            int stock = rs.getInt("monkey");
                            if (price < stock) {
                                // 更新数据库中的库存
                                stock -= price;
                                stmt.executeUpdate("UPDATE monkey SET monkey = " + stock);
                                JOptionPane.showMessageDialog(null, "购买成功！");
                                j1.dispose();
                            } else {
                                JOptionPane.showMessageDialog(null, "没钱了，购买失败！");}}
                        rs.close();
                        stmt.close();
                        conn.close();// 关闭JDialog窗口
                    } catch (ClassNotFoundException ex) {
                        throw new RuntimeException(ex);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }}});
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                j1.dispose(); // 关闭JDialog窗口
            }
        });
        buttonPanel.add(buy);
        buttonPanel.add(exit);
        j1.add(ll1, BorderLayout.CENTER); // 将标签添加到JDialog的中心区域
        j1.add(buttonPanel, BorderLayout.SOUTH); // 将按钮添加到JDialog的底部
        j1.setVisible(true);
    }
    public static void jjj3(){
        JDialog j1 = new JDialog();
        j1.setTitle("价格");
        j1.setLayout(new BorderLayout()); // 修改布局方式为边框布局
        j1.setLocation(1300,400);
        j1.setSize(new Dimension(200, 100));
        j1.setModal(true);
        JLabel ll1 = new JLabel("100");
        ll1.setPreferredSize(new Dimension(180, 30)); // 设置首选尺寸
        JPanel buttonPanel = new JPanel(new GridLayout(1,2)); // 创建一个放置按钮的面板
        JButton buy = new JButton("购买");
        JButton exit = new JButton("退出");
        buy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int price = Integer.parseInt(ll1.getText()); // 获取ll1中的数量
                if (price > 0) {
                    try {// 连接数据库
                        Class.forName("com.mysql.cj.jdbc.Driver");//加载驱动
                        String url = "jdbc:mysql://localhost:3306/final?serverTimezone=GMT%2B8&useSSL=false";
                        String user = "root";
                        String password = "123456";
                        Connection conn = DriverManager.getConnection(url, user, password);
                        Statement stmt = conn.createStatement();
                        // 查询钱包的钱
                        ResultSet rs = stmt.executeQuery("SELECT monkey FROM monkey");
                        if (rs.next()) {
                            int stock = rs.getInt("monkey");
                            if (price < stock) {
                                // 更新数据库中的库存
                                stock -= price;
                                stmt.executeUpdate("UPDATE monkey SET monkey = " + stock);
                                JOptionPane.showMessageDialog(null, "购买成功！");
                                j1.dispose();
                            } else {
                                JOptionPane.showMessageDialog(null, "没钱了，购买失败！");}}
                        rs.close();
                        stmt.close();
                        conn.close();// 关闭JDialog窗口
                    } catch (ClassNotFoundException ex) {
                        throw new RuntimeException(ex);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }}});
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                j1.dispose(); // 关闭JDialog窗口
            }
        });
        buttonPanel.add(buy);
        buttonPanel.add(exit);
        j1.add(ll1, BorderLayout.CENTER); // 将标签添加到JDialog的中心区域
        j1.add(buttonPanel, BorderLayout.SOUTH); // 将按钮添加到JDialog的底部
        j1.setVisible(true);
    }
    }

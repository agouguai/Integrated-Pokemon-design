package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Wuqidian {
    public static void wuqi(){
        JFrame f2 = new JFrame("武器店");
        f2.setSize(new Dimension(700, 200));
        f2.setLocation(500,500);
        JPanel p1 = new JPanel();
        JLabel l1 = new JLabel(new ImageIcon("src/images/天顶剑.png"));
        JButton bt1 = new JButton("天顶剑 atk+200");
        JLabel l2 = new JLabel(new ImageIcon("src/images/泰拉剑.png"));
        JButton bt2 = new JButton("泰拉剑 atk+150");
        JLabel l3 = new JLabel(new ImageIcon("src/images/波涌之刃.png"));
        JButton bt3 = new JButton("波涌之刃 atk+100");
        p1.add(bt1);p1.add(l1);
        bt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                www1();}});
        p1.add(bt2);p1.add(l2);
        bt2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                www2();}});
        p1.add(bt3);p1.add(l3);
        bt3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                www3();}});
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
    public static void www1(){
        JDialog j1 = new JDialog();
        j1.setTitle("价格");
        j1.setLayout(new BorderLayout()); // 修改布局方式为边框布局
        j1.setLocation(230,400);
        j1.setSize(new Dimension(200, 100));
        j1.setModal(true);
        JLabel ll1 = new JLabel("200");
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
                        // 读取 pikaqiu 表的 atk 列的当前值
                        ResultSet rss = stmt.executeQuery("SELECT atk FROM pikaqiu");
                        int atk = 0;
                        if (rss.next()) {
                            atk = rss.getInt("atk");
                        }
                        atk += price;
                        stmt = conn.createStatement();
                        PreparedStatement pstmt = conn.prepareStatement("UPDATE pikaqiu SET atk = ?");
                        pstmt.setInt(1, atk);
                        pstmt.executeUpdate();
                        rss.close();
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
    public static void www2(){
        JDialog j1 = new JDialog();
        j1.setTitle("价格");
        j1.setLayout(new BorderLayout()); // 修改布局方式为边框布局
        j1.setLocation(230,400);
        j1.setSize(new Dimension(200, 100));
        j1.setModal(true);
        JLabel ll1 = new JLabel("150");
        ll1.setPreferredSize(new Dimension(180, 30)); // 设置首选尺寸
        JPanel buttonPanel = new JPanel(new GridLayout(1,2)); // 创建一个放置按钮的面板
        JButton buy = new JButton("购买");
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
                        ResultSet rss = stmt.executeQuery("SELECT atk FROM pikaqiu");
                        int atk = 0;
                        if (rss.next()) {
                            atk = rss.getInt("atk");
                        }
                        atk += price;
                        stmt = conn.createStatement();
                        PreparedStatement pstmt = conn.prepareStatement("UPDATE pikaqiu SET atk = ?");
                        pstmt.setInt(1, atk);
                        pstmt.executeUpdate();
                        rss.close();
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
    public static void www3(){
        JDialog j1 = new JDialog();
        j1.setTitle("价格");
        j1.setLayout(new BorderLayout()); // 修改布局方式为边框布局
        j1.setLocation(230,400);
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
                        // 读取 pikaqiu 表的 atk 列的当前值
                        ResultSet rss = stmt.executeQuery("SELECT atk FROM pikaqiu");
                        int atk = 0;
                        if (rss.next()) {
                            atk = rss.getInt("atk");
                        }
                        atk += price;
                        stmt = conn.createStatement();
                        PreparedStatement pstmt = conn.prepareStatement("UPDATE pikaqiu SET atk = ?");
                        pstmt.setInt(1, atk);
                        pstmt.executeUpdate();
                        rss.close();
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
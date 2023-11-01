package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Scanner;

public class Ui {
    public static Connection conn;
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        new Ui();
    }
    JFrame f1 = new JFrame("初始界面");
    public Ui(){
        f1.setSize(350, 400);
        f1.setLocationRelativeTo(null);//居中显示
        f1.setResizable(false);//禁止调整窗口大小
        // 设置背景图片
        JLabel b1 = new JLabel(new ImageIcon("src/images/apex.jpg"));
        f1.getContentPane().add(b1,BorderLayout.NORTH);
        ImageIcon ic = new ImageIcon("src/images/图标.png");
        f1.setIconImage(ic.getImage());
        b1.setLayout(new BorderLayout());
        //登录的选项
        JPanel p1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        p1.setOpaque(false);//可以在背景上面显示
        JLabel l1 = new JLabel("账号：");
        l1.setFont(new Font("宋体", Font.PLAIN, 20));
        Dimension d1 = new Dimension(200,30);
        JTextField t1 = new JTextField(20);
        t1.setPreferredSize(d1);
        JLabel l2 = new JLabel("密码：");
        l2.setFont(new Font("宋体", Font.PLAIN, 20));
        JPasswordField t2 = new JPasswordField(20);
        t2.setPreferredSize(d1);
        p1.add(l1);
        p1.add(t1);
        p1.add(l2);
        p1.add(t2);
        f1.add(p1, BorderLayout.CENTER);
        JPanel p2 = new JPanel(new FlowLayout());
        JButton bt1 = new JButton("登录");
        JButton bt2 = new JButton("注册");
        p2.add(bt1);
        bt1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                String username = t1.getText(); // 获取用户名
                char[] passwordChar = t2.getPassword(); // 获取密码
                String password = new String(passwordChar); // 将密码字符数组转换为字符串
                try {
                    // 判断用户名和密码是否匹配
                    if (isMatch(username, password)) {
                        // 登录成功，跳转到 Pokemon 类
                        Pokemon pokemon = new Pokemon();
                        pokemon.setVisible(true);
                        f1.dispose(); // 关闭当前窗口
                    } else {
                        // 弹出错误提示框
                        JOptionPane.showMessageDialog(f1, "用户名或密码错误！", "错误提示", JOptionPane.ERROR_MESSAGE);
                        // 清空密码框中的内容
                        t2.setText("");}
                } catch (Exception e) {
                    // 连接数据库出错
                    JOptionPane.showMessageDialog(f1, "用户名或密码出错，请重新输入！", "错误提示", JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace();}}
        });
        p2.add(bt2);
        f1.add(p2,BorderLayout.SOUTH);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setVisible(true);
        try {
            connectionDatabse();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }//连接数据库
    public static void connectionDatabse() throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/final?serverTimezone=GMT%2B8&useSSL=false";
        String user = "root";
        String password = "123456";
        conn = DriverManager.getConnection(url,user,password);
    }
    public static boolean isMatch(String username, String password) throws Exception {
        String sql = "SELECT * FROM denglu WHERE username = ? AND password = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, username);
        pstmt.setString(2, password);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            return true;
        }
        return false;
    }
}
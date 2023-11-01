package UI;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class Packpage {
    private static JTextField monkeyTextField;
    public static void packpage() throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");//加载驱动
        String url = "jdbc:mysql://localhost:3306/final?serverTimezone=GMT%2B8&useSSL=false";
        String user = "root";
        String password = "123456";
        JFrame f = new JFrame("钱包");
        f.setSize(400, 200);
        f.setLocationRelativeTo(null);
        // 创建一个文本框用于显示 monkey 值
        monkeyTextField = new JTextField(12);
        monkeyTextField.setEditable(false);
        monkeyTextField.setHorizontalAlignment(JTextField.CENTER);
        // 将文本框添加到 JFrame 窗口中
        f.add(monkeyTextField, BorderLayout.CENTER);
        // 从数据库中获取 monkey 值，并将其显示在文本框中
        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM monkey")) {
            while (rs.next()) {
                String monkey = rs.getString("monkey");
                monkeyTextField.setText(monkey);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        f.setVisible(true);
    }
}

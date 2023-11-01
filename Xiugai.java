package dao;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Xiugai extends JFrame{
    private static String url = "jdbc:mysql://localhost:3306/final?serverTimezone=GMT%2B8&useSSL=false";
    private static String user = "root";
    private static String password = "123456";
    private JTextField textField;
    private JPanel contentPanel;
    private JButton connectButton;
    private JButton saveButton;
    private Connection connection;
    public Xiugai() throws ClassNotFoundException, SQLException {
        super();
        setSize(400, 200);
        textField = new JTextField("");
        textField.setHorizontalAlignment(JTextField.CENTER);
        connectButton = new JButton("连接");
        connectButton.setHorizontalAlignment(JButton.CENTER);
        saveButton = new JButton("保存");
        saveButton.setHorizontalAlignment(JButton.CENTER);

        // 创建内容面板，并将文本框和按钮添加到面板中
        contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());
        contentPanel.add(textField, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.add(connectButton);
        buttonPanel.add(saveButton);
        contentPanel.add(buttonPanel, BorderLayout.SOUTH);

        // 将内容面板添加到 JFrame 中
        setContentPane(contentPanel);

        // 设置 JFrame 的其他属性
        setLocationRelativeTo(null); // 窗口居中显示
        setVisible(true); // 显示窗口

        // 添加连接按钮的监听器
        connectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // 加载 MySQL 驱动
                    Class.forName("com.mysql.cj.jdbc.Driver");

                    // 连接到 MySQL 数据库
                    String url = "jdbc:mysql://localhost:3306/final?serverTimezone=GMT%2B8&useSSL=false";
                    String user = "root";
                    String password = "123456";
                    connection = DriverManager.getConnection(url, user, password);

                    // 从特定的数据表中获取 monkey 的值，并将其显示在文本框中
                    Statement stmt = connection.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT * FROM monkey");
                    if (rs.next()) {
                        String monkey = rs.getString("monkey");
                        textField.setText(monkey);
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });

        // 添加保存按钮的监听器
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // 更新数据库
                    Statement stmt = connection.createStatement();
                    String monkey = textField.getText();
                    String sql = "UPDATE monkey SET monkey=" + monkey;
                    stmt.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "保存成功！");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
    });
}
}


package UI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Pikaqiu extends JFrame {
    public static void pikaqiu() throws ClassNotFoundException {
        JFrame f = new JFrame("皮卡丘的状态");
        f.setSize(800, 600);
        f.setLocationRelativeTo(null);
        Class.forName("com.mysql.cj.jdbc.Driver");//加载驱动
        String url = "jdbc:mysql://localhost:3306/final?serverTimezone=GMT%2B8&useSSL=false";
        String user = "root";
        String password = "123456";
        // 创建左侧面板，包含一个图片标签
        JPanel leftPanel = new JPanel(new BorderLayout());
        ImageIcon imageIcon = new ImageIcon("src/images/正面.png");
        Image image = imageIcon.getImage().getScaledInstance(imageIcon.getIconWidth() * 8 / 10, -1, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(image);
        JLabel imageLabel = new JLabel(imageIcon);
        leftPanel.add(imageLabel, BorderLayout.CENTER);


        // 创建右侧面板，包含一个表格
        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.setBackground(Color.WHITE);
        String[] columnNames = {"状态", "数据"};
        String[][] data = {
                {"体力", "100"},
                {"攻击", "25"},
                {"防御", "20"}
        };
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM pikaqiu")) {
            while (rs.next()) {
                int hp = rs.getInt("hp");
                int atk = rs.getInt("atk");
                int def = rs.getInt("def");
                model.setValueAt(hp, 0, 1); // 更新体力的值
                model.setValueAt(atk, 1, 1); // 更新攻击的值
                model.setValueAt(def, 2, 1); // 更新防御的值
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JTable table = new JTable(model);
        table.setRowHeight(30); // 设置行高
        JScrollPane scrollPane = new JScrollPane(table);
        rightPanel.add(scrollPane, BorderLayout.CENTER);

        // 将左侧和右侧面板添加到窗口中
        f.add(leftPanel, BorderLayout.WEST);
        f.add(rightPanel, BorderLayout.CENTER);
        // 创建一个退出按钮并实现退出动作
        JButton exit = new JButton("退出");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
            }
        });
        f.add(exit, BorderLayout.PAGE_END);
        // 显示窗口
        f.setVisible(true);
    }
}

package UI;

import dao.Xiugai;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.*;

public class Bao {

    public static void bao() throws ClassNotFoundException, SQLException {
        JFrame f = new JFrame("背包");
        f.setSize(800, 600);
        f.setLocationRelativeTo(null); // 屏幕居中显示
        try {
            Image backgroundImage = ImageIO.read(new File("src/images/背包.png"));
            JLabel backgroundLabel = new JLabel(new ImageIcon(backgroundImage));
            // 创建按钮面板
            JPanel bt = new JPanel(new GridLayout(2, 2, 10, 10));
            JButton b1 = new JButton("增加(金手指)");
            b1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        dao.Add.add();
                    } catch (ClassNotFoundException ex) {
                        throw new RuntimeException(ex);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }});
            JButton b2 = new JButton("删除(金手指)");
            JButton b3 = new JButton("修改(金手指)");
            JButton b4 = new JButton("查询(金手指)");
            bt.setOpaque(false); // 让面板透明
            bt.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // 为面板添加空白边框
            bt.add(b1);
            bt.add(b2);
            bt.add(b3);
            bt.add(b4);
            // 创建一个面板
            JPanel panel = new JPanel(new BorderLayout());
            panel.add(bt, BorderLayout.CENTER);
            panel.add(backgroundLabel, BorderLayout.WEST);
            // 添加表格和退出按钮
            Class.forName("com.mysql.cj.jdbc.Driver");//加载驱动
            String url = "jdbc:mysql://localhost:3306/final?serverTimezone=GMT%2B8&useSSL=false";
            String user = "root";
            String password = "123456";
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();//创建了一个用于执行 SQL 语句的 Statement 对象。
// 执行查询语句并获取结果集
            ResultSet rs = stmt.executeQuery("SELECT * FROM beibao");
            ResultSetMetaData metaData = rs.getMetaData();//创建了一个用于执行 SQL 语句的 Statement 对象。
            int columnCount = metaData.getColumnCount();
// 构造表格模型，并从结果集中加载数据
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(new String[]{"序号","武器数量", "防具数量", "道具数量", "金币数量"});
// 遍历结果集，并将数据添加到表格模型中
            while (rs.next()) {// 循环遍历结果集的所有记录
                Object[] rowData = new Object[columnCount];
                for (int i = 1; i <= columnCount; ++i) {
                    rowData[i - 1] = rs.getObject(i);
                }
                model.addRow(rowData);
            }
// 创建 JTable，并将其设置为表格模型
            JTable table = new JTable(model);
            JScrollPane scrollPane = new JScrollPane(table);
// 将表格添加到界面中
            f.add(scrollPane, BorderLayout.CENTER);
// 关闭连接和语句
            rs.close();
            stmt.close();
            conn.close();
            //删除
            b2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) {
                        // 获取选中行的 ID
                        int ws = (int) table.getValueAt(selectedRow, 0); // 假设第一列是 ID 列

                        // 构造 DELETE SQL 语句，用选中行的 ID 作为条件
                        String sql = "DELETE FROM beibao WHERE xuhao = ?";
                        try (Connection conn = DriverManager.getConnection(url, user, password);
                             PreparedStatement ps = conn.prepareStatement(sql)) {
                            // 设置参数
                            ps.setInt(1, ws);
                            // 执行删除操作
                            ps.executeUpdate();
                            // 从表格模型中删除选中行的数据
                            ((DefaultTableModel) table.getModel()).removeRow(selectedRow);
                            JOptionPane.showMessageDialog(null, "删除成功！");
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                            JOptionPane.showMessageDialog(null, "删除失败！");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "请先选择一行记录！");
                    }
                }
            });
            //修改
            b3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // 创建一个JDialog
                    try {
                        new Xiugai();
                    } catch (ClassNotFoundException | SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }});
            //查询
            b4.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dao.Cha.cha();
                }
            });
            JButton exit = new JButton("退出背包");
            exit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    f.dispose();}});
            f.add(exit, BorderLayout.PAGE_END);
            // 将面板添加到窗口中
            f.add(panel, BorderLayout.NORTH);
        } catch (IOException e) {
            e.printStackTrace();
        }

        f.setVisible(true);

    }
    }


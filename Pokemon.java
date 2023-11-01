package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.sql.SQLException;

public class Pokemon extends JFrame implements ActionListener, KeyListener {
    private JPanel panel;
    private JButton btnQuit;
    private GraphicsContext g;
    public static void main(String[] args) {
        new Pokemon();
    }
    // 角色类，用于定义角色的属性和动作
    static class Character {
        public int x, y;
        public Image image;

        public Character(int x, int y, Image image) {
            this.x = x;
            this.y = y;
            this.image = image;
        }

        public void move(int dx, int dy) {
            x += dx;
            y += dy;
        }

        public void paint(Graphics g) {
            g.drawImage(image, x, y, null);
        }
    }

    private Character hero;
    private Image wall;

    public Pokemon() {
        super("橙华市地图");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setResizable(false);

        // 初始化角色和场景
        hero = new Character(0, 160, new ImageIcon("src/images/1.png").getImage());
        wall = new ImageIcon("src/images/map.png").getImage();
        panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(wall, 0, 0, null);
                hero.paint(g);
            }
        };
        panel.setFocusable(true);
        panel.requestFocus();
        panel.setPreferredSize(new Dimension(800, 600));
        panel.setFocusable(true);
        panel.requestFocus();
        panel.addKeyListener(this);
        btnQuit = new JButton("Quit");
        btnQuit.addActionListener(this);
        // 创建“查看背包”按钮
        JButton beibao = new JButton("查看背包");
        beibao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Bao.bao();
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);}}});
        beibao.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                panel.requestFocus();
            }
        });
        // 创建“查看宝可梦状态”按钮
        JButton poke = new JButton("查看宝可梦状态");
        poke.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Pikaqiu.pikaqiu();
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);}}});
        poke.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                panel.requestFocus();
            }
        });
        //创建"钱包"按钮
        JButton packpage = new JButton("钱包");
        packpage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Packpage.packpage();
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);}}});
        packpage.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                panel.requestFocus();
            }
        });
        // 在面板 p2 中添加按钮
        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(10, 1, 0, 10)); // 2 行 1 列的网格布局，组件之间间距为 10 像素
        p2.add(beibao);
        p2.add(poke);
        p2.add(packpage);
        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);
        add(btnQuit, BorderLayout.SOUTH);
        add(p2, BorderLayout.EAST);
        pack();//最佳大小
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnQuit) {
            System.exit(0);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            hero.move(0, -10);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            hero.move(0, 10);
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            hero.move(-10, 0);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            hero.move(10, 0);
        }
        // 判断角色是否到达特定位置
        // 弹出一个新窗口第一家店
        if (hero.x == 80 && hero.y == 70) {
            fuzhuan();
        }
        //第二家店武器店
        if(hero.x == 130 && hero.y == 270){
            Wuqidian.wuqi();
        }
        //第三家店防具店
        if(hero.x == 280 && hero.y == 340){
            Fangjudian.fangju();
        }
        //第四家店精灵恢复中心
        if(hero.x == 280 && hero.y == 220){
            try {
                Huifu.huifu();
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
        //第五家店购买道具
        if(hero.x == 360 && hero.y == 160){
            Daoju.jj();
        }
        //道馆挑战
        if(hero.x == 200 && hero.y == 110){
            new Challenge();
        }
        //试炼
        if(hero.x == 400 && hero.y == 230){
            try {
                new Shenti();
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
        panel.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }




























    public void fuzhuan(){
        JFrame f1 = new JFrame("服装店");
        f1.setSize(new Dimension(650, 300));
        f1.setLocation(230,500);
        JPanel p1 = new JPanel();
        JLabel l1 = new JLabel(new ImageIcon("src/images/2.png"));
        JButton bt1 = new JButton("小火龙");
        JLabel l2 = new JLabel(new ImageIcon("src/images/3.png"));
        JButton bt2 = new JButton("妙蛙种子");
        JLabel l3 = new JLabel(new ImageIcon("src/images/4.png"));
        JButton bt3 = new JButton("杰尼龟");
        JLabel l4 = new JLabel(new ImageIcon("src/images/5.png"));
        JButton bt4 = new JButton("波克比");
        JLabel l5 = new JLabel(new ImageIcon("src/images/6.png"));
        JButton bt5 = new JButton("可达鸭");
        JLabel l6 = new JLabel(new ImageIcon("src/images/7.png"));
        JButton bt6 = new JButton("胖丁");
        JLabel l7 = new JLabel(new ImageIcon("src/images/8.png"));
        JButton bt7 = new JButton("拉帝欧斯");
        JLabel l8 = new JLabel(new ImageIcon("src/images/9.png"));
        JButton bt8 = new JButton("吉利蛋");
        JLabel l9 = new JLabel(new ImageIcon("src/images/10.png"));
        JButton bt9 = new JButton("拉帝亚斯");
        p1.add(bt1);p1.add(l1);
        bt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hero = new Character(80, 70, new ImageIcon("src/images/2.png").getImage());}});
        p1.add(bt2);p1.add(l2);
        bt2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hero = new Character(80, 70, new ImageIcon("src/images/3.png").getImage());}});
        p1.add(bt3);p1.add(l3);
        bt3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hero = new Character(80, 70, new ImageIcon("src/images/4.png").getImage());}});
        p1.add(bt4);p1.add(l4);
        bt4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hero = new Character(80, 70, new ImageIcon("src/images/5.png").getImage());}});
        p1.add(bt5);p1.add(l5);
        bt5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hero = new Character(80, 70, new ImageIcon("src/images/6.png").getImage());}});
        p1.add(bt6);p1.add(l6);
        bt6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hero = new Character(80, 70, new ImageIcon("src/images/7.png").getImage());}});
        p1.add(bt7);p1.add(l7);
        bt7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hero = new Character(80, 70, new ImageIcon("src/images/8.png").getImage());}});
        p1.add(bt8);p1.add(l8);
        bt8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hero = new Character(80, 70, new ImageIcon("src/images/9.png").getImage());}});
        p1.add(bt9);p1.add(l9);
        bt9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hero = new Character(80, 70, new ImageIcon("src/images/10.png").getImage());}});
        JButton bb = new JButton("退出");
        bb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f1.dispose();
            }
        });
        f1.add(bb,BorderLayout.PAGE_END);
        f1.add(p1);
        f1.setVisible(true);
    }



}
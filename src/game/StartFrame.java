package game;

import java.awt.*;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.GraphicAttribute;
import javax.print.DocFlavor.URL;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToolBar;

public class StartFrame extends MyFrame{
	
	//定义变量
	private static Image title = GameUtil.getImage("images/title.png");
	private static Image tutorial = GameUtil.getImage("images/tutorial.png");
	private static ImageIcon play = new ImageIcon(GameUtil.getImage("images/button_play.png"));
	private static ImageIcon register = new ImageIcon(GameUtil.getImage("images/button_rate.png"));
	
	
	//画出游戏开始界面
	public static void drawStartFrame() {
		StartFrame f = new StartFrame();
		f.launchFrame();
		//添加游戏开始的功能按钮
		f.setLayout(null);
		JButton b1 = new JButton();
		b1.setIcon(play);
        b1.setBounds(300, 300, 100, 55);
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	f.dispose();
				GameFrame.drawGameFrame();}
        });
        f.add(b1);   
        //添加用户登录的功能按钮
        JButton b2 = new JButton();
        b2.setIcon(register);
        b2.setBounds(315, 400, 60, 38);
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				new UserLoadFrame();}
        });
        f.add(b2);
        //添加选择小鸟皮肤的多选一按钮
        JRadioButton jradio1 = new JRadioButton(new ImageIcon(GameUtil.getImage("images/bird0_0.png")));
        JRadioButton jradio2 = new JRadioButton(new ImageIcon(GameUtil.getImage("images/bird1_0.png")));
        JRadioButton jradio3 = new JRadioButton(new ImageIcon(GameUtil.getImage("images/bird2_0.png")));
        jradio1.setBounds(500, 150, 45, 30);
        jradio2.setBounds(500, 200, 45, 30);
        jradio3.setBounds(500, 250, 45, 30);
        ButtonGroup bg = new ButtonGroup();
        bg.add(jradio1);
        bg.add(jradio2);
        bg.add(jradio3);
        jradio1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	birdType = 0;
            }});
        jradio2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	birdType = 1;
            }});
        jradio3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	birdType = 2;
            }});
        f.add(jradio1);
        f.add(jradio2);
        f.add(jradio3);
        
	}
	
	public void paint(Graphics g) {
		bg.paint_bg(g, bg_day, x_bg);
		ld.paint_land(g, land, x_land);
		paint(g, title, 261, 100);
		paint(g, tutorial, 293, 200);
	}  
	
}
 
package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.GraphicAttribute;
import javax.swing.JFrame;
import java.awt.event.KeyAdapter;  
import java.awt.event.KeyEvent; 
import java.io.InputStream;
import java.util.Random;



/**
 * 这是游戏窗口
 * @author Lenovo
 * 
 */
public class GameFrame extends MyFrame{
	//变量的定义
	private int index = 0;
	private static int x_bird = 300;
	private static boolean crash = false;
	private static boolean crashb = false;
	
	private Column cl = new Column();
	private int x_Column[] = {500,700,900,1100};
	private int y_Column[] = {0-(int)(Math.random()*200),0-(int)(Math.random()*150),
			0-(int)(Math.random()*170),0-(int)(Math.random()*150)};
	
	private Boss bs = new Boss();
	private int y_boss = 285;
	private boolean up_boss = false;
	private int hp = 40;
	
	private Coin cn = new Coin();
	private boolean [] eaten = {false,false,false,false};
	private int [] x_Coin = {800+(int)(Math.random()*50),1000+(int)(Math.random()*50),
			1200+(int)(Math.random()*50),1400+(int)(Math.random()*50)};
	private int [] y_Coin = {100+(int)(Math.random()*350),120+(int)(Math.random()*350),
			100+(int)(Math.random()*350),120+(int)(Math.random()*350)};
	
	private Bullet bt = new Bullet();
	private int x_bullet[] = {500,500+(int)(Math.random()*50),500+(int)(Math.random()*50),500+(int)(Math.random()*50)};
	private int inity_bullet = (int)(Math.random()*30+30);
	private int [] y_bullet = {(int)(Math.random()*100+50),(int)(Math.random()*150+100),
			(int)(Math.random()*250+200),(int)(Math.random()*300+200)};
	
	//画出游戏界面
	public static void drawGameFrame() {
		x_bird = 300;
		score = 0;
		GameFrame f = new GameFrame();
		f.launchFrame();
		//添加重画窗口线程
		f.new PaintThread(f).start();
		//键盘监听实现小鸟的向上运动
		f.addKeyListener(new KeyAdapter(){  
            public void keyPressed(KeyEvent e){  
                if(e.getKeyCode() == 32 ) 
                	x_bird = bd.up(x_bird);}  
        });
		//键盘监听实现返回主界面
		f.addKeyListener(new KeyAdapter(){  
            public void keyPressed(KeyEvent e){  
                if(e.getKeyCode() == 82) {
                	f.dispose();
                	StartFrame.drawStartFrame(); }
                }  
        });
		//鼠标监听实现小鸟的向上运动
		f.addMouseListener(new MouseAdapter() {	
				public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);
				if(e.getButton() ==1) {
					x_bird = bd.up(x_bird);	}}		
		});
	}
	
	public void paint(Graphics g) {
		//夜晚
		if(score %30 ==  10) {
			bg.paint_bg(g, bg_night, x_bg);
			bs.paint_Boss(g, boss,y_boss);
			bt.paint_Bullet(g, bullet, x_bullet,y_bullet);
			x_bullet = bt.move_Bullet(x_bullet,y_bullet);
			for(int i = 0;i < 4;i++)
				if(x_bullet[i] ==500) 
					hp--;
			if(y_boss <= 200)
				up_boss = false;
			if(y_boss >= 299)
				up_boss = true;
			y_boss = bs.move_Boss(y_boss,up_boss);
			if(hp <= 0) {
				for(int i=0;i<4;i++)
					x_Column[i] = 500+i*200;
				score +=10;
				hp = 40;}}
		//白天
		else if(score %30 != 10) {
			//背景
			bg.paint_bg(g, bg_day, x_bg);
			x_bg = BackGround.move_bg(x_bg);
			//判断是否得分
			for(int i = 0; i < 4; i ++) {
				boolean cs = false;
				if(eaten[i] == false) {
					eaten[i] = bd.getScore( x_bird, y_Coin[i], x_Coin[i]);
					if(eaten[i]==true)
						score ++;
					cn.x=x_Coin[i];cn.y=y_Coin[i];cn.width=44;cn.height=44;
					for(int j = 0;j<4;j++) {
						cl.x=x_Column[j];cl.y=y_Column[j];cl.width=52;cl.height=320;
						if(cn.getRect().intersects(cl.getRect()))
							cs = true;
						cl.x=x_Column[j];cl.y=y_Column[j]+400;cl.width=52;cl.height=320;
						if(cn.getRect().intersects(cl.getRect()))
							cs = true;
					}
					y_Coin[i] = cn.move_Coin1(x_Coin[i],y_Coin[i]);
					if(cs==false) 
			 		cn.paint_Coin(g,coin, x_Coin[i] , y_Coin[i], eaten[i]);
				}
				if(x_Coin[i] <= -52)
					eaten[i] = false;
				x_Coin[i] = cn.move_Coin0(x_Coin[i],score);
				y_Coin[i] = cn.move_Coin1(x_Coin[i],y_Coin[i]);
			}
		//柱子
		cl.paint_Column(g,Column_up1 , Column_down1, x_Column,y_Column);
		x_Column = cl.move_Column(x_Column,y_Column,score);
		for(int i=0;i<4;i++) {
			if(x_Column[i] <= 106&&x_Column[i]>100) {
				score ++;}}
		}
		//地面
		ld.paint_land(g, land, x_land);
		x_land = Land.move_land(x_land);
		//小鸟
		Image bird = bd.flapWings(index,birdType);
		paint(g, bird, 100, x_bird);
		if(crash == false) {
			x_bird = bd.down(x_bird);
			index ++;
		}
		//分数
		g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,40));
		g.drawString(score.toString(), 30,100);
		g.setColor(Color.YELLOW);
		g.drawString(score.toString(), 27,97);
		//检测小鸟是否死亡
		crash = bd.hitIf(x_bird,x_Column,y_Column);
		bd.x=100;bd.y=x_bird;bd.width=48;bd.height=48;
	}
	
	//重画窗口线程PaintThread类
	class PaintThread extends Thread {
		GameFrame f;
		public PaintThread(GameFrame f) {
			this.f = f;}
		
		public void run() {
			boolean crashif = true;
			while(crashif) {
				x_bird = bd.down(x_bird);
				Bird bd = new Bird (100,x_bird);
				if(score % 30 != 10)
				crash = bd.hitIf(x_bird,x_Column,y_Column);
				else
				crash = bd.hitBullet(x_bird,bd, bt, x_bird, x_bullet, y_bullet);
				if(crash == false)
					repaint();
				else if(crash == true) {
					crashif = false;
					f.dispose();
					GameEndFrame.drawGameEndFrame();
				}	
				try {
					Thread.sleep(30);
				} catch (InterruptedException e) {
					e.printStackTrace();}}
				
			}}


	//双缓冲解决闪烁问题
	private Image offScreenImage = null;
	public void update(Graphics g) {
	    if(offScreenImage == null)
	        offScreenImage = this.createImage(700,600);   
	    Graphics gOff = offScreenImage.getGraphics();
	    paint(gOff);
	    g.drawImage(offScreenImage, 0, 0, null);
	}  
	
}
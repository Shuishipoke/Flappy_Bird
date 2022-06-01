package game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Bird extends Entity{
	
	private Image bird0_0 = GameUtil.getImage("images/bird0_0.png");
	private Image bird0_1 = GameUtil.getImage("images/bird0_1.png");
	private Image bird0_2 = GameUtil.getImage("images/bird0_2.png");
	private Image bird1_0 = GameUtil.getImage("images/bird1_0.png");
	private Image bird1_1 = GameUtil.getImage("images/bird1_1.png");
	private Image bird1_2 = GameUtil.getImage("images/bird1_2.png");
	private Image bird2_0 = GameUtil.getImage("images/bird2_0.png");
	private Image bird2_1 = GameUtil.getImage("images/bird2_1.png");
	private Image bird2_2 = GameUtil.getImage("images/bird2_2.png");
	
	public Bird(int x, int y) {
		super(x, y);
	}
	
	public Bird() {}
	
	//画出小鸟
	public void paint_Bird(Graphics g, Image image, int x){
		paint(g, image, 100, 300);
	}

	//煽动翅膀
	public Image flapWings(int index,int Type) {
		if(Type == 0 ) {
			if(index % 9 == 0 || index % 9 == 1 || index % 9 == 2)
				return bird0_0;
			else if(index % 9 == 3 || index % 9 == 4 || index % 9 == 5)
				return bird0_1;
			else 
				return bird0_2;
		}
		else if(Type == 1) {
			if(index % 9 == 0 || index % 9 == 1 || index % 9 == 2)
				return bird1_0;
			else if(index % 9 == 3 || index % 9 == 4 || index % 9 == 5)
				return bird1_1;
			else 
				return bird1_2;
		}
		else {
			if(index % 9 == 0 || index % 9 == 1 || index % 9 == 2)
				return bird2_0;
			else if(index % 9 == 3 || index % 9 == 4 || index % 9 == 5)
				return bird2_1;
			else 
				return bird2_2;
		}
	}
	
	//小鸟自由下落
	public int down(int x){
		x += 2;
		return x;
	}
	
	//小鸟向上飞翔
	public int up(int x) {
		x -= 30 ;
		return x;
	}

	//检测是否碰撞到柱子
	public boolean hitIf(int y,int[] x_Column,int[] y_Column
			) {
		boolean crash = false;
		for(int i=0;i<x_Column.length;i++) {
			if((x_Column[i] <= 135)&&(x_Column[i] >=55)&&
					((y >= y_Column[i]+375 )||(y <= y_Column[i]+295)))
				crash = true;
		}
		if(y >= 480 || y <= 0)
			crash = true;
		return crash;
	}
	//检测是否碰撞到弹幕
	public boolean hitBullet(int y,Bird bd,Bullet bt,int x_bird,int[] x_bullet,int []y_bullet) {
		boolean crash = false;
		bd.x=100;bd.y=x_bird;bd.width=20;bd.height=20;
		for(int i=0;i<4;i++) {
			bt.x=x_bullet[i];bt.y=y_bullet[i];bt.width=20;bt.height=20 ;
			if(bd.getRect().intersects(bt.getRect())) {
				crash = true;
				break;}
		}
		if(y >= 480 || y <= 0)
			crash = true;
		return crash;
	}
	
	//检测是否获得分数
	public boolean getScore(int y_Bird,int y_Coin,int x) {
		boolean eaten = false;
		if((y_Bird <= (y_Coin+30))&&(y_Bird >= (y_Coin-30)) && (x>=80 && x<= 120))
			eaten = true;
		return eaten;
	}  

}

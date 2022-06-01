package game;

import java.awt.Graphics;
import java.awt.Image;

public class Bullet extends Entity{

	public Bullet(int x, int y) {
		super(x, y);
	}
	
	public Bullet() {}
	
	//以四个为一组画出子弹
	public void paint_Bullet(Graphics g, Image image,int[] x,int[] y) {
		for(int i=0;i<4;i++)
			g.drawImage(image,x[i],y[i],null);
	}
	
	//子弹的移动
	public int[] move_Bullet(int[] x,int []y) {
		int inity= (int)(Math.random()*30+30);
		for(int i=0;i<y.length;i++) {
			x[i]-=20;
			if(x[i]<= -10) {
				x[i]=500;
				y[i]= inity + (int)(Math.random()*150+50);
				inity = y[i];}}
		return x;
	}
}

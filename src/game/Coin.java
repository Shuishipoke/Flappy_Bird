package game;

import java.awt.Graphics;
import java.awt.Image;

public class Coin extends Entity{
	
	Boolean eaten = false;

	public Coin(int x, int y) {
		super(x, y);
	}
	
	public Coin() {}
	
	//Ëæ»ú»­³öÓ²±Ò
	public void paint_Coin(Graphics g, Image image, int x, int y,boolean eaten) {
		paint(g, image, x, y);
	}
	
	public int move_Coin0(int x,int score) {
		x-=6+((score-5)/30)*2  ;
		if(x <= -60)
			x = 700+(int)(Math.random()*100);
		return x;
	}
	
	public int move_Coin1(int x,int y) {
		if(x <= -52)
			y = 20+(int)(Math.random()*450);
		return y;
	}
}


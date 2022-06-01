package game;

import java.awt.Graphics;
import java.awt.Image;

public class Boss extends Entity{
	
	
	public Boss(int x, int y) {
		super(x, y);
	}
	
	public Boss() {}
	
	//画出BOSS
	public void paint_Boss(Graphics g, Image image,int y) {
		paint(g,image,500,y);
	}
	
	//BOSS的上下移动
	public int move_Boss(int y,boolean up) {
		if(y<300 && up == false)
			y++;
		else if(y < 300 && up == true)
			y--;
		return y;
	}
	
	
}

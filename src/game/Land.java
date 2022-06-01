package game;

import java.awt.Graphics;
import java.awt.Image;

public class Land extends Entity{
	
	public Land(int x, int y) {
		super(x, y);
	}
	public Land() {
	}
	
	//画出地面
	public void paint_land(Graphics g, Image image, int x) {
		paint(g, image, 0+x, 512);
		paint(g, image, 336+x, 512);
		paint(g, image, 672+x, 512);
	}
	
	//地面的移动
	public static int move_land(int x) {
		if(x == -336)
			x = 0;
		x-=4;
		return x;
	}
}

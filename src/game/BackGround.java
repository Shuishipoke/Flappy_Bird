package game;

import java.awt.Graphics;
import java.awt.Image;

public class BackGround extends Entity{
	
	public BackGround(int x, int y) {
		super(x, y);
	}
	public BackGround() {
	}
	
	//»­³ö±³¾°
	public void paint_bg(Graphics g, Image image, int x) {
		paint(g, image, 0+x, 0);
		paint(g, image, 288+x, 0);
		paint(g, image, 576+x, 0);
		paint(g, image, 864+x, 0);
	}
	
	//±³¾°µÄÒÆ¶¯
	public static int move_bg(int x) {
		if(x== -288)
			x = 0;
		x--;
		return x;
	}
}

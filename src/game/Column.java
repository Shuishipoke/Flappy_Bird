package game;

import java.awt.Graphics;
import java.util.Arrays;
import java.util.Random;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.awt.Image;
import java.io.IOException;

public class Column extends Entity{

	public Column(int x, int y)  {
		super(x, y);
	}
	
	public Column() {
	}
	
	//以两个为一组画出柱子
	public void paint_Column(Graphics g, Image image1,Image image2,int[] x,int []y) {
		for(int i = 0; i < x.length;i++) {
			paint(g,image1,x[i],y[i]);
			paint(g,image2,x[i],y[i]+400);
		}	
	}
	
	//柱子的移动
	public int[] move_Column(int[] x,int []y,int score) {
		for(int i = 0;i < x.length;i++) {
			x[i] -=6+((score-5)/30)*2;
			if(x[i] <= -52) {
				x[i] = Arrays.stream(x).max().getAsInt() + 200;
				y[i] = 0-(int)(Math.random()*150);
			}
		}
		return x;
	}
	

}
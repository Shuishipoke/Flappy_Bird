package game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Entity {
	int x;
	int y;
	int width;
	int height;
	
	public Entity(int x ,int y,int width,int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public Entity(int x ,int y) {
		this.x = x;
		this.y = y;
	}
	
	public Entity() {
	}
	
	//获取矩形进行碰撞检测
	public Rectangle getRect(){
	      return  new Rectangle((int)x,(int) y, width, height);
	}
	
	//画出图像
	public static void paint(Graphics g, Image picturename, int x_picture, int y_picture) {
		g.drawImage(picturename, x_picture, y_picture,null);
	}
}

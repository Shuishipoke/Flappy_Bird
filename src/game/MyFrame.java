package game;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MyFrame extends Frame{
	
	//全局变量的定义
	static Image bg_day = GameUtil.getImage("images/bg_day.png");
	static Image bg_night = GameUtil.getImage("images/bg_night.png");
	static Image land = GameUtil.getImage("images/land.png");
	static Image bird0_0 = GameUtil.getImage("images/bird0_0.png");
	static Image bird0_1 = GameUtil.getImage("images/bird0_1.png");
	static Image bird0_2 = GameUtil.getImage("images/bird0_2.png");
	static Image bird1_0 = GameUtil.getImage("images/bird1_0.png");
	static Image bird1_1 = GameUtil.getImage("images/bird1_1.png");
	static Image bird1_2 = GameUtil.getImage("images/bird1_2.png");
	static Image bird2_0 = GameUtil.getImage("images/bird2_0.png");
	static Image bird2_1 = GameUtil.getImage("images/bird2_1.png");
	static Image bird2_2 = GameUtil.getImage("images/bird2_2.png");
	static Image Column_up1 = GameUtil.getImage("images/pipe_down.png");
	static Image Column_down1 = GameUtil.getImage("images/pipe_up.png");
	static Image coin = GameUtil.getImage("images/medals_1.png");
	static Image boss = GameUtil.getImage("images/boss.png");
	static Image bullet = GameUtil.getImage("images/bullet.png");
	static Bird bd = new Bird();
	static BackGround bg = new BackGround();
	static Land ld = new Land();
	static Column cl = new Column();
	static Integer score = 0;
	static int birdType = 0;
	static String userName = "";
	static String [] score_List = new String[100];
	static String [] name_List = new String[100];
	static String [] password_List = new String[100];
	static Integer j = 0;
	int x_bg = 0;
	int x_land = 0;
	
	//形成窗口
	public void launchFrame () {
		this.setTitle("Flappy Bird");
		this.setVisible(true);
		this.setLocation(300,100);
		this.setSize(700,625);
		this.addWindowListener(new WindowAdapter(){
		    public void windowClosing(WindowEvent e){
		    	System.exit(0);
		    }
		    });
		this.setResizable(false);
	}
	
	//画出图像
	public static void paint(Graphics g, Image picturename, int x_picture, int y_picture) {
		g.drawImage(picturename, x_picture, y_picture,null);
	}
	
	//从文件获取数据
	public static void getData(String []score_List,String []name_List,String []password_List) throws IOException{
		j = 0;
		File file = new File("Message.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String temp=null;
		StringBuffer sb= new StringBuffer();
		temp = br.readLine();
		String []message = new String[5]; 
		while(temp!=null){
        	String sbstring = temp.toString();
        	int n = sbstring.length();            //测字符串长度
        	for (int i=0; i<5; i++)
        		message[i] = "";
        	int k=0;       
        	for (int i=0; i<n; i++)
        	{
        		if(sbstring.charAt(i)=='~')
        		{
        			if(k==0)
        				name_List[j] = message[k];
        			else if(k==1)
        				password_List[j] = message[k];
        			else if(k==2) 
        				score_List[j] = message[k];
        			k++;
        		}
        		else 
        			message[k] += sbstring.charAt(i);
        	}
			temp=br.readLine();
			j++;
		}
	}
	
	
	//程序的入口
	public static void main(String[] args) throws Exception {
		try {
			getData(score_List,name_List,password_List);
		} catch (IOException e) {
			e.printStackTrace();
		}  
		//显示开始界面
		StartFrame.drawStartFrame();
		//GameFrame.drawGameFrame();
	}
}

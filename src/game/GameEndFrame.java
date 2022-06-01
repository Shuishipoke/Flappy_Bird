  package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class GameEndFrame extends MyFrame{
	private static String newScore;
	private static Image text_game_over = GameUtil.getImage("images/text_game_over.png");
	private static Image scorePanel = GameUtil.getImage("images/score_panel.png");
	private static ImageIcon menu = new ImageIcon(GameUtil.getImage("images/button_menu.png"));
	private static ImageIcon rankList = new ImageIcon(GameUtil.getImage("images/button_score.png"));
	
	public static void drawGameEndFrame() {
		GameEndFrame f = new GameEndFrame();
		f.launchFrame();
		//用按钮监听实现返回开始界面
		f.setLayout(null);
		JButton b1 = new JButton();
		b1.setIcon(menu);
        b1.setBounds(310, 280, 80, 30);
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	f.dispose();
				StartFrame.drawStartFrame();}
        });
        f.add(b1);
        //用按钮监听实现查看排行榜
		JButton b2 = new JButton();
		b2.setIcon(rankList);
        b2.setBounds(300, 350, 100, 52);
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				try {
					new Rank();
				} catch (IOException e1) {
					e1.printStackTrace();}}
        });
        f.add(b2);

	}
	
	public void paint(Graphics g) {
		bg.paint_bg(g, bg_day, x_bg);
		ld.paint_land(g,  land, x_land);
		paint(g, text_game_over, 248, 50);
		paint(g, scorePanel, 238, 150);
		g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,15)); 
		g.drawString(score.toString(), 428,200);
		if(!userName.equals("")) {
			newScore = updateScore(name_List,score_List,j,score);
			g.drawString(newScore, 428,250);}
		g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,15));
		g.drawString(userName, 268,200);
		try {
			 emptyFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			updateInFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//清空文件
	public static void emptyFile() throws Exception{
		File f = new File ("Message.txt");
		FileWriter fw = new FileWriter (f);
		fw.write("");
		fw.flush();
		fw.close();
	}
	
	//更新最高分数
	public String updateScore(String []name,String []score_list,Integer j,Integer score) {
		int i;
		for(i = 0; i<j;i++) 
			if(userName.equals(name[i])) 
				break;
		if(Integer.parseInt(score_list[i]) < score)
			score_list[i] = score.toString();
		return score_List[i];
	}
	
	//重写文件
	public void updateInFile() throws IOException{
		File file = new File("Message.txt");
		BufferedReader br =  new BufferedReader(new FileReader(file));
		String temp=null;
		StringBuffer sb= new StringBuffer();
		temp = br.readLine();
		String []message = new String[5]; 
		FileWriter fileWritter = new FileWriter(file.getName(),true);
        for(int i=0;i<j;i++) {
    		//存储信息
        	fileWritter.write(name_List[i]);
        	fileWritter.write("~");
        	fileWritter.write(password_List[i]);
        	fileWritter.write("~");
        	fileWritter.write(score_List[i]);
        	fileWritter.write("~\n");
        }
        fileWritter.close();
	} 
	
	
}

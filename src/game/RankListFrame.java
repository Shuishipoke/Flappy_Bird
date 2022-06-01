package game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class RankListFrame extends MyFrame{
	Image ranklist = GameUtil.getImage("images/button_score.png");
	public static void drawRankListFrame() {
		RankListFrame f = new RankListFrame();
		f.launchFrame();
		f.setLayout(null);
		JButton b = new JButton("return");
		b.setBounds(285, 330, 116, 70);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	f.dispose();
				GameEndFrame.drawGameEndFrame();
            }
        });
        f.add(b);
	}
	public void paint(Graphics g) {
		paint_RankList(g, ranklist ,10,10);
	}
	
	public static void paint_RankList(Graphics g, Image image,int x,int y){
		paint_RankList(g,image,10,10);
	}


}
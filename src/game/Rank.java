
package game;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Rank extends MyFrame implements ActionListener{
	
	private JButton jb;
	private JLabel jlb1,jlb2,jlb3;
	private JTextField jtf3,jtf4;
	private JPasswordField jpf;
	private JPanel jp1,jp2,jp3,jp4,jp5,jp6,jp7,jp8,jp9,jp10,jp11,jp12;

	
	public Rank() throws IOException {

		this.setSize(500,350);
		this.setTitle("排行榜");
		this.setLocationRelativeTo(null);//屏幕居中
		this.setResizable(false);
		this.setVisible(true);
		this.addWindowListener(new WindowAdapter() {
		    public void windowClosing(WindowEvent e) {
		        dispose();
		    }
		});
		this.setResizable(false);//不可拉伸大小
		
        }
		
	
	public void paint(Graphics g) {
		g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,25)); 
		g.drawString("排名", 50, 60);
		g.drawString("用户", 145, 60);
		g.drawString("得分", 240, 60);
		Sort(name_List,score_List,j);
		for(Integer i = 1; i < j+1;i++) {
			g.setFont(new Font("Times New Roman",Font.BOLD,25));
			g.drawString(i.toString(), 70, 90+30*i);
			g.drawString(name_List[i-1], 150, 90+30*i);
			g.drawString(score_List[i-1], 250, 90+30*i);
		}
		
	}

	//将读取的分数进行排序
	public void Sort(String[] name,String [] score,Integer j) {
		for(int n = 0;n < j;n++) 
			for(int m = n;m < j;m++) 
				if(Integer.parseInt(score[n]) <= Integer.parseInt(score[m])) {
					String t = score[m];
					score[m] = score[n];
					score[n] = t;
					t = name[m];
					name[m] = name[n];
					name[n] = t;
				}
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand()=="返回")
		{
			new UserLoadFrame();
			dispose();
		}
	}
	
	private void clear() {
		jtf3.setText("");
		jtf4.setText("");
	}	

}
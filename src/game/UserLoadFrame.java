package game;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class UserLoadFrame extends MyFrame implements ActionListener{
	private JButton jb1,jb2,jb3;
	private JPanel jp1,jp2,jp3,jp4;
	private JTextField jtf;
	private JLabel jlb1,jlb2,jlb3;
	private JPasswordField jpf;
	
	public UserLoadFrame() {
		
		jb1 = new JButton("��¼");
		jb2 = new JButton("ע��");
		jb3 = new JButton("���а�");
		//��Ӱ�ť����
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		jp4 = new JPanel();
		
		jlb1 = new JLabel("�û���");
		jlb2 = new JLabel("����");
		
		
		jtf = new JTextField(10);
		jpf = new JPasswordField(10);
		
		jp1.add(jlb1);
		jp1.add(jtf);
		
		jp2.add(jlb2);
		jp2.add(jpf);
		
		jp3.add(jb1);
		jp3.add(jb2);
		jp3.add(jb3);
		
		//��JPanel����JFrame
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		
		//����
		this.setTitle("�û���¼");
		this.setLayout(new GridLayout(3,1));
		this.setSize(300,200);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter() {
		    public void windowClosing(WindowEvent e) {
		        dispose();
		}});
		
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand()=="��¼")
		{
			try {
				login();
			}catch (HeadlessException |IOException e1) {
				e1.printStackTrace();
			}
		}
		else if(e.getActionCommand()=="ע��")
		{
			new Register();
			dispose();
		}
		else if(e.getActionCommand()=="���а�")
		{
			try {
				new Rank();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			dispose();
		}
	}
	
	
	//����˺ź������
	private void clear() {
		jtf.setText("");
		jpf.setText("");
	}
	
	//������֤��¼��Ϣ
	@SuppressWarnings("deprecation")
	public void login() throws HeadlessException, IOException{
		//�ж��û����������Ƿ�����  
		if(new Check().checkcountname(jtf.getText())||new Check().checkcountname(jpf.getText())) {
			JOptionPane.showMessageDialog(null, "�û������벻Ӧ��������!",
					"��Ϣ��ʾ",JOptionPane.WARNING_MESSAGE);
		}
		else if(jtf.getText().isEmpty()&&jpf.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,"�˺����벻��Ϊ��!",
					"��Ϣ��ʾ",JOptionPane.WARNING_MESSAGE);
		}
		else if(jtf.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,"�˺Ų���Ϊ��!",
					"��Ϣ��ʾ",JOptionPane.WARNING_MESSAGE);
		}
		else if(jpf.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,"���벻��Ϊ��!",
					"��Ϣ��ʾ",JOptionPane.WARNING_MESSAGE);
		}
		else if(new Check().check1(jtf.getText(),jpf.getText())) {
			userName = jtf.getText();
			JOptionPane.showMessageDialog(null,"������!��½�ɹ���",
					"��Ϣ��ʾ",JOptionPane.WARNING_MESSAGE);
			dispose();
		}
		else JOptionPane.showMessageDialog(null, "�˺��������",
				"��Ϣ��ʾ",JOptionPane.WARNING_MESSAGE);
		clear();//����
	}
}
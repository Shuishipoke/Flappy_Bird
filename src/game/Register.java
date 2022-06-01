package game;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Register extends MyFrame implements ActionListener{
	
	private JButton jb1,jb2;
	private JLabel jlb3,jlb4,jlb5,jlb6;
	private JTextField jtf3,jtf4;
	private JPasswordField jpf;
	private JPanel jp4,jp5,jp6,jp7;
	
	public Register() {
		jb1 = new JButton("�ύ");
		jb2 = new JButton("��¼");
		
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		
		jlb3 = new JLabel("�˺�");
		jlb4 = new JLabel("����");
		jtf3 = new JTextField(13);
		jtf4 = new JTextField(13);
		
		jp4 = new JPanel();
		jp5 = new JPanel();
		jp6 = new JPanel();
		jp7 = new JPanel();
		
		jp4.add(jlb3);
		jp4.add(jtf3);
		
		jp5.add(jlb4);
		jp5.add(jtf4);
		
		jp6.add(jb1);
		jp6.add(jb2);
		
		this.add(jp7);
		this.add(jp4);
		this.add(jp5);
		this.add(jp6);
		
		//����
		this.setTitle("ע����Ϣ");
		this.setLayout(new GridLayout(4,1));
		this.setSize(250,240);
		this.setLocationRelativeTo(null);//��Ļ����
		this.setVisible(true);
		this.setResizable(false);//���������С
		this.addWindowListener(new WindowAdapter() {
		    public void windowClosing(WindowEvent e) {
		        dispose();
		}});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand()=="�ύ")
		{
			try {
				register();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if (e.getActionCommand()=="��¼");
		{
			new UserLoadFrame();
			dispose();
		}
	}

	private void register() throws IOException{
		// ��Ϣ�Ƿ���ȫ
		if(jtf3.getText().isEmpty()||jtf4.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "������Ϣ��ȫ!",
					"��Ϣ��ʾ",JOptionPane.WARNING_MESSAGE);
		}
		// �˺������Ƿ��������
		else if(new Check().checkcountname(jtf3.getText())||new Check().checkcountname(jtf4.getText())) {
			JOptionPane.showMessageDialog(null, "�˺����벻��Ϊ����!",
					"��Ϣ��ʾ",JOptionPane.WARNING_MESSAGE);
		}
		else if(!jtf3.getText().isEmpty()&&!jtf4.getText().isEmpty()) {
			//ע��ɹ�������Ϣ�����UserMessage
			String []message = new String[3];
			message[0] = jtf3.getText();
			name_List[j] = message[0];
			message[1] = jtf4.getText();
			password_List[j] = message[1];
			message[2] = "0";
			score_List[j] = message[2]; 
			j++; 
			boolean bl = true;
			if(bl != new Check().check2(message[0])){ //����˺��Ƿ����
				new UserMessage().write(message);
			JOptionPane.showMessageDialog(null, "ע��ɹ���",
					"��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
			dispose();//ʹ������ʧ
			//new UserLoadFrame();
			}
			else if(bl == new Check().check2(message[0])){
				JOptionPane.showMessageDialog(null, "�˺��Ѵ��ڣ�",
					"��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
			}
		}	
	}
	//�������
	private void clear() {
		jtf3.setText("");
		jtf4.setText("");
	}

}

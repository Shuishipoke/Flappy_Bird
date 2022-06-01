package game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UserMessage {

	//��ע����Ϣд���ı�
	public void write(String[] message) throws IOException {
		// TODO Auto-generated method stub
		File file = new File("Message.txt");
		String messagesum = "";
		int k=1;
		for(int i=0;i<3;i++) {
			//�洢��Ϣ
			if((i+1)%3!=0) {
				messagesum+=message[i]+"~";
			}
			else if((i+1)%3==0) {
				messagesum+=message[i]+"~\n";
			}
		}
		if(!file.exists()) {
			file.createNewFile();
		}
		 FileWriter fileWritter = new FileWriter(file.getName(),true);
	      fileWritter.write(messagesum);
	      fileWritter.close();
	}
	//��ȡ��Ϣ�����û�����Ϣ����
	public String[] read(String countname) throws IOException {
		File file = new File("Message.txt");
		if(!file.exists()||file.isDirectory()) {
			throw new FileNotFoundException();
		}
		BufferedReader br = new BufferedReader(new FileReader(file));
		String temp=null;
		StringBuffer sb= new StringBuffer();
		temp = br.readLine();
		String []message = new String[5];     //��~��� ��5���ַ������飬���˺ź����������Ϣ��֤
		while(temp!=null){
        	String sbstring = temp.toString();
        	int n = sbstring.length();            //���ַ�������
        	for (int i=0; i<5; i++)
        		message[i] = "";
        	
        	int k=0;
        	for (int i=0; i<n; i++)
        	{
        		if(sbstring.charAt(i)=='~')
        		{
        			k++;
        		}
        		else 
        		{
        			message[k] += sbstring.charAt(i);
        		}
        	}
        	if (message[2].equals(countname))  //�����ҵ��û�����Ϣ
        	{
        		return message;
        	}
            temp=br.readLine();
        }
		return null;
	}
	//��������
		public String updatepwd(String countname,String pwd) throws IOException
		{
	        File file=new File("Message.txt");
	        if(!file.exists()||file.isDirectory())
	            throw new FileNotFoundException(); 
	        //���ļ�  
	        BufferedReader br=new BufferedReader(new FileReader(file));
	        String temp=null;
	        StringBuffer sb=new StringBuffer();
	        //д�ļ�       
	        StringBuffer sb1=new StringBuffer();
	        
	        String moneystring="";
	        
	        temp=br.readLine();
	        String []message = new String[2];     //��~��� ��5���ַ������飬���˺ź����������Ϣ��֤
	        while(temp!=null){
	        	String sbstring = temp.toString();
	        	int n = sbstring.length();            //���ַ�������
	        	for (int i=0; i<2; i++)
	        		message[i] = "";
	        	
	        	int k=0;
	        	for (int i=0; i<n; i++)      //���5��String
	        	{
	        		if(sbstring.charAt(i)=='~')
	        		{
	        			k++;
	        		}
	        		else 
	        		{
	        			message[k] += sbstring.charAt(i);
	        		}
	        	}
	        	
	        	if (message[0].equals(countname))   //�ҵ����˻���
	        	{
	        		//�޸�����
	        		for (int i=0; i<3; i++)
	        			sb1.append(message[i]+"~");
	        		sb1.append(pwd+"~");
	        		sb1.append(message[4]+"~\n");
	        	}
	        	else
	        	{
	        		sb1.append(temp+"\n");
	        	}
	        	temp=br.readLine();
	        }
	        File file1=new File("Message.txt");
	        if(!file1.exists())
	           file1.createNewFile();
	        FileOutputStream out=new FileOutputStream(file1,false);
	        out.write(sb1.toString().getBytes("gb2312"));
	        out.close();
	        
			return moneystring;
		}

}

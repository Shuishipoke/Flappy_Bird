package game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UserMessage {

	//将注册信息写入文本
	public void write(String[] message) throws IOException {
		// TODO Auto-generated method stub
		File file = new File("Message.txt");
		String messagesum = "";
		int k=1;
		for(int i=0;i<3;i++) {
			//存储信息
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
	//读取信息，将用户名信息返回
	public String[] read(String countname) throws IOException {
		File file = new File("Message.txt");
		if(!file.exists()||file.isDirectory()) {
			throw new FileNotFoundException();
		}
		BufferedReader br = new BufferedReader(new FileReader(file));
		String temp=null;
		StringBuffer sb= new StringBuffer();
		temp = br.readLine();
		String []message = new String[5];     //按~拆分 成5个字符串数组，按账号和密码进行信息验证
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
        			k++;
        		}
        		else 
        		{
        			message[k] += sbstring.charAt(i);
        		}
        	}
        	if (message[2].equals(countname))  //返回找到用户的信息
        	{
        		return message;
        	}
            temp=br.readLine();
        }
		return null;
	}
	//更新密码
		public String updatepwd(String countname,String pwd) throws IOException
		{
	        File file=new File("Message.txt");
	        if(!file.exists()||file.isDirectory())
	            throw new FileNotFoundException(); 
	        //读文件  
	        BufferedReader br=new BufferedReader(new FileReader(file));
	        String temp=null;
	        StringBuffer sb=new StringBuffer();
	        //写文件       
	        StringBuffer sb1=new StringBuffer();
	        
	        String moneystring="";
	        
	        temp=br.readLine();
	        String []message = new String[2];     //按~拆分 成5个字符串数组，按账号和密码进行信息验证
	        while(temp!=null){
	        	String sbstring = temp.toString();
	        	int n = sbstring.length();            //测字符串长度
	        	for (int i=0; i<2; i++)
	        		message[i] = "";
	        	
	        	int k=0;
	        	for (int i=0; i<n; i++)      //拆乘5个String
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
	        	
	        	if (message[0].equals(countname))   //找到该账户名
	        	{
	        		//修改密码
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

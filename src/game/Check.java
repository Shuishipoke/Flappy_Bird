package game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Check {
	
	/**
	 * 在登录时， 验证账号密码是否正确
	 */
	public boolean  check1(String countname,String pwd) throws IOException{
		
		File file=new File("Message.txt");   //创建文件类
        if(!file.exists()||file.isDirectory()) //判断文件是否存在
        	file.createNewFile();
        BufferedReader br=new BufferedReader(new FileReader(file)); //创建读入缓冲流，按行读入
        String temp=null;   
        temp=br.readLine();   //先读取一行
        while(temp!=null){
        	String sbstring = temp.toString();   //转化为string
        	int n = sbstring.length();            //测字符串长度
        	String []message = new String[5];     //按~拆分 成5个字符串数组，按账号和密码进行信息验证
        	int k=0;
        	
        	for (int i=0; i<2; i++)
        		message[i]="";
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
        	if (countname.equals(message[0])&&pwd.equals(message[1]))//比较账户密码是否相等
        		return true;
            temp=br.readLine();  //读取下一行
        }
        return false;
			
		
	}
	
	//在注册时 验证账号是否存在
	public boolean  check2(String countname) throws IOException{
		
		File file=new File("Message.txt");   //创建文件类
        if(!file.exists()||file.isDirectory()) //判断文件是否存在
        	file.createNewFile();
        BufferedReader br=new BufferedReader(new FileReader(file)); //创建读入缓冲流，按行读入
        String temp=null;   
        temp=br.readLine();   //先读取一行
        while(temp!=null){
        	String sbstring = temp.toString();   //转化为string
        	int n = sbstring.length();            //测字符串长度
        	String []message = new String[5];     //按~拆分 成5个字符串数组，按账号和密码进行信息验证
        	int k=0;
        	
        	for (int i=0; i<5; i++)
        		message[i]="";
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
        	if (countname.equals(message[0]))
        		return true;//验证是否存在过此账号
            temp=br.readLine();
        }
        return false;
	}

	//验证用户名和密码是否为中文
	public boolean checkcountname(String countname)
	{
		 Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
	        Matcher m = p.matcher(countname);
	        if (m.find()) {
	            return true;
	        }
	        return false;
	}
	//验证姓名是否为中文
	public boolean checkname(String name)
	{
		int n = 0;
	    for(int i = 0; i < name.length(); i++) {
	        n = (int)name.charAt(i);
	        if(!(19968 <= n && n <40869)) {
	            return false;
	        }
	    }
	    return true;
	}
}


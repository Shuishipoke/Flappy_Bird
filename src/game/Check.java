package game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Check {
	
	/**
	 * �ڵ�¼ʱ�� ��֤�˺������Ƿ���ȷ
	 */
	public boolean  check1(String countname,String pwd) throws IOException{
		
		File file=new File("Message.txt");   //�����ļ���
        if(!file.exists()||file.isDirectory()) //�ж��ļ��Ƿ����
        	file.createNewFile();
        BufferedReader br=new BufferedReader(new FileReader(file)); //�������뻺���������ж���
        String temp=null;   
        temp=br.readLine();   //�ȶ�ȡһ��
        while(temp!=null){
        	String sbstring = temp.toString();   //ת��Ϊstring
        	int n = sbstring.length();            //���ַ�������
        	String []message = new String[5];     //��~��� ��5���ַ������飬���˺ź����������Ϣ��֤
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
        	if (countname.equals(message[0])&&pwd.equals(message[1]))//�Ƚ��˻������Ƿ����
        		return true;
            temp=br.readLine();  //��ȡ��һ��
        }
        return false;
			
		
	}
	
	//��ע��ʱ ��֤�˺��Ƿ����
	public boolean  check2(String countname) throws IOException{
		
		File file=new File("Message.txt");   //�����ļ���
        if(!file.exists()||file.isDirectory()) //�ж��ļ��Ƿ����
        	file.createNewFile();
        BufferedReader br=new BufferedReader(new FileReader(file)); //�������뻺���������ж���
        String temp=null;   
        temp=br.readLine();   //�ȶ�ȡһ��
        while(temp!=null){
        	String sbstring = temp.toString();   //ת��Ϊstring
        	int n = sbstring.length();            //���ַ�������
        	String []message = new String[5];     //��~��� ��5���ַ������飬���˺ź����������Ϣ��֤
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
        		return true;//��֤�Ƿ���ڹ����˺�
            temp=br.readLine();
        }
        return false;
	}

	//��֤�û����������Ƿ�Ϊ����
	public boolean checkcountname(String countname)
	{
		 Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
	        Matcher m = p.matcher(countname);
	        if (m.find()) {
	            return true;
	        }
	        return false;
	}
	//��֤�����Ƿ�Ϊ����
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


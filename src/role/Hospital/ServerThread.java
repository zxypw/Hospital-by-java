package role.Hospital;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.rmi.UnknownHostException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServerThread extends Thread {
	public static int pa_max=1000;
	public static int pa_no=0;
	public String id;	//用户id
	public String role; //用户类型
	public static String command="1 001 123456 吴奕锋 3 10001 感冒 白加黑";	//接收到来自客户端的命令数据包
	public boolean conn_state;	//状态
	public ArrayList<String> command_array=new ArrayList<String>();	//ArrayList 类用以存放分割后的命令
	public String sql_command;	//为接收到的命令创建sql语句
	public ResultSet re;	//执行sql命令后返回的结果集
	public String result;	//生成返回客户端的数据包
	static Date dt=new Date();	//
	static SimpleDateFormat matter1=new SimpleDateFormat("yyyy-MM-dd");
	public static String date=matter1.format(dt);
	//对命令进行解析
	public void wordscut(){
		int i=0;
		String [] comm=command.split(" ");							//将接收到的命令字符串分割存入到comm字符串数组中
		int count_comm=comm.length;
		for(i=0;i<count_comm;i++)
		{
			command_array.add(comm[i]);
		}
		
	}
	//生成DB实体
	DB user;
	public String connect(String mes)
	{
		   Socket server=null;
		   String ex=null; 
	        try{
	        String inputString;
	        server=new Socket("192.168.1.102",4444);
	        System.out.println("连接成功");
	        BufferedReader sin =new BufferedReader(new InputStreamReader(System.in));
	        PrintWriter os=new PrintWriter(server.getOutputStream());
	        BufferedReader is=new BufferedReader(new InputStreamReader(server.getInputStream(),"UTF-8"));
	        inputString=mes;
	       	os.println(inputString);;
	     	os.flush();
	        ex=is.readLine();
	        System.out.println(ex);
	        os.close();
	        is.close();
	        server.close();
	        }catch(UnknownHostException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
			return ex;
	}
	public void run(){
		if(this.command!=null)
		{
			this.wordscut();
			user=new DB(command_array.get(1).toString(),command_array.get(2).toString());
			try {
				init_thread();
			} 
			catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	//初始化线程
	public void init_thread() throws ClassNotFoundException{
		role=command_array.get(0).toString();
		id=command_array.get(1).toString();
		conn_state=user.connect();
	}
	
	//处理接收到的命令，创建sql_command
	public void sql_make(){
		wordscut();
		sql_command=command_array.toString();
	}
	
	//进行数据库操作，生成结果集
	public String getresult(String sql){
		re=user.inquire(sql);
		result=re.toString();
		return result;
	}									
	
	
}
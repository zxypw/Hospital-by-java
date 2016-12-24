package role.Hospital;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServerThread extends Thread {
	public static int pa_max=1000;
	public String id;	//用户id
	public String role; //用户类型
	public static String command=null;	//接收到来自客户端的命令数据包
	public boolean conn_state;	//状态
	public ArrayList<String> client=new ArrayList<String>();	//ArrayList 类用以存放分割后的命令
	public String sql_command;	//为接收到的命令创建sql语句
	public ResultSet re;	//执行sql命令后返回的结果集
	public String result;	//生成返回客户端的数据包
	static Date dt=new Date();	//
	static SimpleDateFormat matter1=new SimpleDateFormat("yyyy-MM-dd");
	public static String date=matter1.format(dt);
	//对命令进行解析
	public void wordscut(){
		String [] comm=command.split(" ");							//将接收到的命令字符串分割存入到comm字符串数组中
		int count_comm=comm.length;
		while(count_comm!=0)										//将comm中的字符串存入ArrayList类中
		{
			int i=0;
			client.add(comm[i++]);
			count_comm--;
		}
	}
	//生成DB实体
	DB user=new DB(client.get(1).toString(),client.get(2).toString());
	
	public void run(){
		if(this.command!=null)
		{
			this.wordscut();
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
		role=client.get(0).toString();
		id=client.get(1).toString();
		conn_state=user.connect();
	}
	
	//处理接收到的命令，创建sql_command
	public void sql_make(){
		wordscut();
		sql_command=client.toString();
	}
	
	//进行数据库操作，生成结果集
	public String getresult(String sql){
		re=user.inquire(sql);
		result=re.toString();
		return result;
	}									
	
	
}
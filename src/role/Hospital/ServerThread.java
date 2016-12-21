package role.Hospital;

import java.sql.ResultSet;
import java.util.ArrayList;

public class ServerThread extends Thread {
	public String name;	//线程名
	public String id;	//用户id
	public String command=null;	//接收到来自客户端的命令数据包
	public boolean conn_state;	//状态
	public ArrayList<String> client=new ArrayList<String>();	//ArrayList 类用以存放分割后的命令
	public String sql_command;	//为接收到的命令创建sql语句
	public ResultSet re;	//执行sql命令后返回的结果集
	public String result;	//生成返回客户端的数据包
	//对命令进行解析
	public void wordscut(){
		String [] comm=command.split(" ");							//将接收到的命令字符串分割存入到comm字符串数组中
		int count_comm=comm.length;
		while(count_comm!=0)										//将comm中的字符串存入ArrayList类中
		{
			int i=0;
			this.client.add(comm[i++]);
			count_comm--;
		}
	}
	//生成DB实体
	DB user=new DB(client.get(0).toString(),client.get(1).toString());
	//初始化线程
	public void init_this() throws ClassNotFoundException{
		name=client.get(2).toString();
		id=client.get(3).toString();
		conn_state=user.connect();
	}
					
	//进行数据库操作，生成结果集
	public String getresult(String sql){
		re=user.inquire(sql);
		result=re.toString();
		return result;
	}									
	
	
}
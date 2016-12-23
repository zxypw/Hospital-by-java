package role.Hospital;

import java.util.Hashtable;

public class ThreadDoctor extends ServerThread {
	String sql_init="SELECT * FROM Patient WHERE Do.id="+id;	//初始sql操作语句，查询医生本人名下挂号的病人
	public void run(){
		try {
			init_thread();		//初始化线程
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(!conn_state)
		{
			result="用户id或密码错误";
		}
		this.start();
		while(conn_state)
		{
			if(this.command!=null)
			{
				wordscut();
				deal();
				getresult(sql_command);
			}
			else if(getresult(sql_init)!=result)	
				;
				/*
				 此处为将result发送到对应客户端
				 * */
			try {
				this.sleep(1000);
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}	
		}
		
	}
	
	//处理病人情况
	public void deal(){
		String patientid=client.get(4).toString();
		String prescription=client.get(5).toString();
		String illness=client.get(6).toString();
		sql_command="UPDATE Patient SET Pa_illness='"+illness+"',Pa_prescription='"+prescription
				+"',Pa_state=2,"	+" WHERE Pa_id='"+patientid+"'";
	}
	public static void main(String[] args) {
		ThreadDoctor doctor=new ThreadDoctor();
		doctor.command="001 123456 吴奕锋 1 1 10001 感冒 白加黑";
		System.out.println(doctor.command);
		doctor.wordscut();
		System.out.println(doctor.client);
	}
}

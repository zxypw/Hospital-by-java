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
		String patientid=command_array.get(4).toString();	//获取病人id
		String prescription=command_array.get(6).toString();//获取开药单
		String illness=command_array.get(5).toString();		//获取诊断信息（什么病）
		sql_command="UPDATE Patient SET Pa_illness='"+illness+"',Pa_prescription='"+prescription
				+"',Pa_state=4,"+" WHERE Pa_id='"+patientid+"'";		//医生就诊，开药，生成修改病人信息的sql命令，将病人状态修改为4待取药
	}
	public static void main(String[] args) {
		ThreadDoctor doctor=new ThreadDoctor();
		doctor.command="2 610001 123456 3 001 感冒 白加黑";
		System.out.println(doctor.command);
		doctor.wordscut();
		doctor.deal();
		for(int i=0;i<doctor.command_array.size();i++)
		System.out.println(doctor.command_array.get(i));
		System.out.println(doctor.sql_command);
		
	}
}

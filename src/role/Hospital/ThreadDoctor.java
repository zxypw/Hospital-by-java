package role.Hospital;

import java.util.Hashtable;

public class ThreadDoctor extends ServerThread {
	String init_sql="SELECT * FROM Patient WHERE Do.id="+id;	//初始sql操作语句，查询医生本人名下挂号的病人
	//线程工作，查询
	public void work(){
		while(conn_state)
		{
			result=this.getresult(init_sql);
			if(this.command!=null)
			{
				this.deal();
				result=this.getresult(sql_command);	//执行sql_command
			}
		}
	}
	//处理病人情况
	public void deal(){
		String patientid=client.get(4).toString();
		String prescription=client.get(5).toString();
		String illness=client.get(6).toString();
		sql_command="UPDATE Patient SET Pa_illness='"+illness+"',Pa_prescription='"+prescription
				+"' WHERE Pa_id='"+patientid+"'";
	}
}

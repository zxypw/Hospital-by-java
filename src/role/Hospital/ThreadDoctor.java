package role.Hospital;

import java.util.Hashtable;

public class ThreadDoctor extends ServerThread {
	String init_sql="SELECT * FROM Patient WHERE Do.id="+id;	//初始sql操作语句，查询医生本人名下挂号的病人
	public void run(){
		this.start();
		while(conn_state)
		{
			this.work();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	//线程工作内容
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
	public static void main(String[] args) {
		ThreadDoctor doctor;
	}
}

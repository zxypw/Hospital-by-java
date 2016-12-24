package role.Hospital;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadPatient extends ServerThread {
	String sql_init="SELECT * FROM Patient WHERE Pa.id="+id;//查询病人本人信息
	void ThreatPatient(int No){
		String Pa_id=date+pa_max;
	}
	public void run(){
		try {
			init_thread();		//初始化线程
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		this.start();
		while(conn_state)
		{
			if(this.command!=null)
			{
				wordscut();
				dealcomm();
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
	public void dealcomm(){	
	}
}

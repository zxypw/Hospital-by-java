package role.Hospital;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ThreadPatient extends ServerThread {
	String sql_init="SELECT * FROM Patient WHERE Pa.id="+id;//查询病人本人信息
	String Pa_id=null;
	void ThreatPatient(){
		Pa_id=date+pa_no;
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
				deal();
				getresult(sql_command);
				sql_command=null;
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
	public void deal(){
		String [] patient_data_str=this.command_array.get(4).split(",");
		ArrayList patient_data_arr=new ArrayList();
		//生成patient_data arraylist
		for(int i=0;i<patient_data_str.length;i++)
		{
			patient_data_arr.add(patient_data_str[i]);
		}
		//sql命令：向病人表中插入数据
		sql_command="INSERT INTO Patient(ID,Pa_id,Pa_name,Pa_age,Pa_sex,De_id,Do_id,Pa_state,Pa_time)"
				+"VALUES ('"+patient_data_arr.get(1)+"'"	//身份证号
				+ ",'"+Pa_id+"'"							//病号Pa_id
				+",'"+patient_data_arr.get(2)+"'"			//姓名name
				+",'"+patient_data_arr.get(3)+"'"			//年龄age
				+",'"+patient_data_arr.get(4)+"'"			//性别
				+",'"+patient_data_arr.get(5)+"'"			//选择科室
				+",'"+patient_data_arr.get(6)+"'"			//选择医生
				+","+patient_data_arr.get(0)+""				//状态
				+",getdate())";
	}
	
	public static void main(String[] args) {
		ThreadPatient patient=new ThreadPatient();
		patient.command="1 0 0 2 0,1412480000,吴一封,73,男,61000,610001";
		patient.wordscut();
		patient.deal();
		System.out.println(patient.command);
		for(int i=0;i<patient.command_array.size();i++)
			System.out.println(patient.command_array.get(i));
		patient.deal();
		System.out.println(patient.sql_command);
	}
}

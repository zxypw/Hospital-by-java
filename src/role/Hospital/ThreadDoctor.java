package role.Hospital;

public class ThreadDoctor extends ServerThread {
	String init_sql="SELECT * FROM Patient WHERE Do.id="+client.get(0).toString();	//初始sql操作语句，查询医生本人名下挂号的病人
	public void work(){
		while(conn_state)
		{
			re=user.inquire(init_sql);
			result=getresult();
			
		}
	}
	//处理病人情况
	public void deal(){
		
	}
}

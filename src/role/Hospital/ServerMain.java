package role.Hospital;

import java.util.ArrayList;

public class ServerMain {
	public static int client_count;
	private static ThreadPatient [] patient;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerThread server=new ServerThread();
		server.start();
		while(true)
		{
			try {
				server.init_thread();				//线程初始化
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			switch(server.role)
			{
			case "1":if(ServerThread.pa_no<=ServerThread.pa_max)
						{
							cre_patient(server.id);
						}
					else
						System.out.println("病人数已达上限");
					break;
			case "2":
			case "3":
			case "4":
			case "5":
			case "6":
			}
		}
		
	}
	private static void cre_patient(String id){
		int num=ServerThread.pa_no;
		patient[num]=new ThreadPatient();
		patient[num].setName(id);			//将病人线程名设置为当前id
		patient[num].start();				//病人线程启动
	}
}

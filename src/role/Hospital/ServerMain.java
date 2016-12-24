package role.Hospital;

import java.util.ArrayList;

public class ServerMain {
	
	private static int pa_No=0;
	public static int client_count;
	private static ThreadPatient [] patient;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerThread server=new ServerThread();
		server.start();
		switch(server.role)
		{
		case "1":if(pa_No<=ServerThread.pa_max)
					cre_patient(server.id);
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
	private static void cre_patient(String id){
		patient[pa_No]=new ThreadPatient();
		pa_No++;
	}
}

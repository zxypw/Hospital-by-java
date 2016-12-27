package patient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.rmi.UnknownHostException;

public class Connect {
	public static String connect(String mes)
	{
		   Socket server=null;
		   String ex=null; 
	        try{
	        String inputString;
	        server=new Socket("127.0.0.1",4444);
	        System.out.println("连接成功");
	        BufferedReader sin =new BufferedReader(new InputStreamReader(System.in));
	        PrintWriter os=new PrintWriter(server.getOutputStream());
	        BufferedReader is=new BufferedReader(new InputStreamReader(server.getInputStream(),"UTF-8"));
	        inputString=mes;
	       	os.println(inputString);;
	     	os.flush();
	        ex=is.readLine();
	        //System.out.println(ex);
	        os.close();
	        is.close();
	        server.close();
	        }catch(UnknownHostException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
			return ex;
	}
}

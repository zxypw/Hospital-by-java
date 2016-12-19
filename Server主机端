package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        try{
        	ServerSocket server=null;//创建服务器端
        	System.out.println("端口1211创建成功!");
		try {
			server=new ServerSocket(1211);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("端口创建错误:"+e);
			System.exit(1);
			
		}
		Socket client=null;
		try{
			client=server.accept();//创建客户端
		}catch (Exception e){
			System.out.println("客户端向服务器接受请求失败!");
			System.exit(-1);
		}
        String inputString="test";
        BufferedReader is=new BufferedReader(new InputStreamReader(client.getInputStream()));//IS从服务器端接收
        PrintWriter os=new PrintWriter(client.getOutputStream());
        BufferedReader sin=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("客户端发送的消息为:"+is.readLine());
        
      
        while (inputString!=null&&!inputString.trim().equals("quit")){
        	
        	
        	System.out.println("服务器想要发送消息:");
        	inputString=sin.readLine();
        	
        	System.out.println("服务器发送的消息为:"+inputString);
        	os.println(inputString);
        	os.flush();
        	System.out.println("客户端发送的消息为:"+is.readLine());
        	//inputString=sin.readLine();
        }
        os.close();
        is.close();
        client.close();
        server.close();
        System.out.println("聊天结束!");
        
	}catch(Exception e){
		System.out.println("Error:"+e);
	}
	}//服务器端程序

}



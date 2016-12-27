package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.rmi.UnknownHostException;

import server.Server_main;

public class Client客户端 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Socket server=null;
        try{
        String inputString="test";
        server=new Socket("192.168.1.103",1211);
        System.out.println("连接服务器(端口1211)成功，当前是"+Server_main.num+"号客户端，请输入信息:");//num需要存储在数据库里，实时显示当前有几个客户端在与主机连接。
        BufferedReader sin =new BufferedReader(new InputStreamReader(System.in));
        PrintWriter os=new PrintWriter(server.getOutputStream());
        BufferedReader is=new BufferedReader(new InputStreamReader(server.getInputStream()));
        System.out.println("客户端想要发送消息:");
    	inputString=sin.readLine();
        while(inputString!=null&&!inputString.trim().equals("quit")){
        	os.println(inputString);;
        	os.flush();
        	System.out.println("服务器发送的消息为:"+is.readLine());
        	System.out.println("客户端想要发送消息:");
        	inputString=sin.readLine();
        	System.out.println("客户端发送的消息为:"+inputString);
        	
        	
        	//inputString=sin.readLine();
        }
        os.close();
        is.close();
        server.close();
        System.out.println("聊天结束!");
        }catch(UnknownHostException e){
        	e.printStackTrace();
		
	}catch(IOException e){
		System.out.println("与服务器连接失败");
		e.printStackTrace();
	}
	

}
}

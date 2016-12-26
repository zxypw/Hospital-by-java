package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server主机端 {
	public static int num=1;//客户端计数
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ServerSocket serverSocket=null;
        Socket client=null;
        while(true){
        	
        		try {
        			System.out.println("端口1211创建成功");
					serverSocket=new ServerSocket(1211);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("Error:"+e);
					System.exit(-1);
				}
        		try {
					client=serverSocket.accept();//产生一个socket对象
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("接受请求失败!");
					System.exit(-1);
				}
        		System.out.println("客户端"+server_mult.num+"号登陆");
        		ServerThread st=new ServerThread(client);
        		Thread t=new Thread(st);
        		t.start();//监听到客户请求，据客户技术创建服务线程并启动
        	    try{serverSocket.close();}
        	    catch (IOException e){ 
        	    System.out.println("关闭失败!");
        	    }
        	    num++;
         }
        }
}

      class ServerThread implements Runnable{
    	  private Socket client;
    	  public ServerThread(Socket client){
    		  this.client=client;
    	  }
    	  public void run()
    	  {
    		  try{
    			  BufferedReader is=new BufferedReader(new InputStreamReader(client.getInputStream()));
    			  PrintWriter os=new PrintWriter(client.getOutputStream());
    			  BufferedReader sin=new BufferedReader(new InputStreamReader(System.in));
    			  System.out.println("客户端: "+is.readLine());
    			  String inputString=sin.readLine();
    			  while(inputString!=null&&!inputString.trim().equals("quit")){
    				  os.println(inputString);
    				  os.flush();
    				  System.out.println("服务器发送的消息是:"+inputString);
    				  System.out.println("客户端发送的消息是:"+is.readLine());
    				  inputString= sin.readLine();
    			  }
    			  os.close();
    			  is.close();
    			  client.close();
    			  System.out.println("聊天结束!");
    			  
    		  }catch (IOException e){
    			  e.printStackTrace();
    		  }
    		  
    	  }
        
	}



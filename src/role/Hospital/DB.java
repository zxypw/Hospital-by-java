package role.Hospital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
	String user_id;
	String user_pwd;
	Connection con=null;
	DB(String account,String pwd) {
		// TODO Auto-generated constructor stub
		this.user_id=account;
		this.user_pwd=pwd;
	}
	

	
	//建立数据库连接，传入参数为用户名，密码
	public boolean connect() throws ClassNotFoundException {
		
		//加载数据库驱动程序
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		//建立数据库连接，登录名为account，密码为pwd
		try {
			con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=Hospital",user_id,user_pwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(con!=null)
			return false;
		else return true;
	}
	public ResultSet inquire(String sql){
		ResultSet result=null;
		Statement st=null;
		try {
			st=this.con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			result=st.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result==null)
			return null;
		return result;
	}
		
	
}

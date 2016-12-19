package db.Hospital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
	public DB(String sqlcom){
		
	}
	
	public class Connect {
		public boolean connect(String account,String pwd) throws ClassNotFoundException {
			Connection con=null;
			//加载数据库驱动程序
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			//建立数据库连接，登录名为account，密码为pwd，查询语句为sql
			try {
				con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=Hospital",account,pwd);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(con!=null)
				return false;
			else return true;
		}//建立数据库连接
		public boolean select(Connection con,String sql){
			ResultSet result=null;
			Statement st=null;
			try {
				st=con.createStatement();
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
				return false;
			return true;
		}	
		
	}
}

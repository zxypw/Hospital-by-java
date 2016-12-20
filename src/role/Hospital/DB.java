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
	

	
	//�������ݿ����ӣ��������Ϊ�û���������
	public boolean connect() throws ClassNotFoundException {
		
		//�������ݿ���������
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		//�������ݿ����ӣ���¼��Ϊaccount������Ϊpwd
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
		ResultSet result=null;
		Statement st=null;
		try {
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

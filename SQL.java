import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQL {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con=null;
		try {
			Class.forName("com.microsoft.sqlserver.jabc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//建立数据库连接
		try {
			con=DriverManager.getConnection("jabc:sqlserver：//localhost：1433；DatabaseName=zero","Tom","123456");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


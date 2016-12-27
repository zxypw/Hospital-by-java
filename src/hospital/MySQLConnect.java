package hospital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class MySQLConnect {

	public static final String url = "jdbc:mysql://114.215.112.200/hospital";	
	public static final String name = "com.mysql.jdbc.Driver";						
	public static final String user = "tempuserfordage";									
	public static final String password = "123456";									
	
	public Connection conn = null;				  
	public PreparedStatement pst = null;		         

	public MySQLConnect(String sql) {
		try {
			Class.forName(name);										
			conn = DriverManager.getConnection(url, user, password);	
			pst = conn.prepareStatement(sql);							
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
    public void close() {  
            try {
				this.conn.close();		
				this.pst.close();		
			} catch (SQLException e) {
				
				e.printStackTrace();
			}  
    }  
}

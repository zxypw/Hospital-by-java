import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQL {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con=null;
		Statement stmt=null;
		String strTemp="";
		try {
			Class.forName("com.microsoft.sqlserver.jabc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//建立数据库连接
		try {
			con=DriverManager.getConnection("jabc:sqlserver：//localhost：1433；DatabaseName=zero","Tom","123456");
			stmt=con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//建表
		strTemp="create table Patient(Pa_id int,Pa_name char(20),Pa_age int,Pa_sex char(4),De_id int,Do_id int)";
		strTemp="create table Department(De_id int,De_name char(50),De_id char(20) primary key,De_name char(50) not null)";
		strTemp="create table Doctor(Do_id char(20) primary key,Do_name char(20) not null,Do_sex char(4) not null,Do_age int not null,De_id char(20)not null,Do_prof char(20) not null,Do_tel char(11) not null)";
		strTemp="create table Medicine(Me_id char(20) primary key,Me_name char(50) not null,Me_price float not null,Me_inventory int not null)";
		strTemp="create table Account(Ac_id char(20) primary key,Ac_pwd char(20) not null,Ac_prof char(10) not null)";
		strTemp="create table Department add De_earn float)";
	}
}


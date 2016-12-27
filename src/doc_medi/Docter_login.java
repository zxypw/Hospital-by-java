package doc_medi;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mySQL.MySQLConnect;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Docter_login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private static String id;		//用户输入的ID
	private static String pwd;		//用户输入的密码
	private String pwd_sql=null;	//从数据库读取出来的密码
	private String role=null;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	public static String name=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Docter_login frame = new Docter_login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Docter_login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 513, 397);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		     
		JLabel label = new JLabel("用户名：");
		label.setBounds(80, 95, 72, 18);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("密码：");
		label_1.setBounds(80, 138, 72, 18);
		contentPane.add(label_1);
		
		textField = new JTextField();
		textField.setBounds(166, 92, 127, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(166, 135, 127, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("登录");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					login();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				

			}
		});
		btnNewButton.setBounds(80, 191, 113, 27);
		contentPane.add(btnNewButton);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(326, 95, 72, 18);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(326, 138, 72, 18);
		contentPane.add(lblNewLabel_1);
	}
	
	public void login() throws SQLException{
		id=textField.getText();	//读取id
		pwd=textField_1.getText();	//读取密码
		String sql="SELECT Ac_pwd,Ac_role FROM Account WHERE Ac_id='"+id+"' AND Ac_role='1';";
		MySQLConnect conn=new MySQLConnect(sql);
		try {
			ResultSet re=conn.pst.executeQuery();
			if(re.next())
			{
				pwd_sql=re.getString(1);
				role=re.getString(2);
			}
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(role.equals('1'))
			lblNewLabel.setText("身份不正确,登录失败");
		else if(pwd.equals(pwd_sql))
		{
			lblNewLabel_1.setText("登录成功");
			String sql1="SELECT Do_name FROM Doctor WHERE Do_id='"+id+"'";
			conn=new MySQLConnect(sql1);
			ResultSet re=conn.pst.executeQuery();
			while (re.next())name=re.getString("Do_name");
			//name=textField.getText(); 
			//System.out.println(name);
			
			kanbing kb=new kanbing();
			kb.main(null);
			
		}
		else 
			lblNewLabel_1.setText("密码不正确");
		System.out.println(sql);
		System.out.println(role);
		System.out.println(pwd_sql);
	}
}

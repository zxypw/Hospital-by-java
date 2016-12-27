package doc_medi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mySQL.MySQLConnect;
import patient.Connect;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class kanbing extends JFrame {
    static int i=0;
    static String choose;
    static Object[] yao;
    String result2=null;// 将传输走的字符串 
    String a;
    String bingdan=null;
    String result3="5";//排队人数
	private JPanel contentPane;
	private JTextField textField;
	double d = 0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					kanbing frame = new kanbing();
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
	public kanbing() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 MySQLConnect db = null;  
	     ResultSet ret = null;  
	     String sql = "select Pa_id,Pa_name,Pa_age,Pa_sex,Pa_illness from Patient where (Do_id='"+Docter_login.name+"' and Pa_state=2);";
	     
		 db = new MySQLConnect(sql);
		 int n=0;
		 String [] result1 = new String [20];
			try {int i=0;
				ret=db.pst.executeQuery();					// 执行sql语句，得到结果集
			    while(ret.next()){
			    	
			    	String aa=(ret.getString("Pa_id"));
			    	String bb=(ret.getString("Pa_name"));
			    	String cc=(ret.getString("Pa_age"));
			    	String dd=(ret.getString("Pa_sex"));
			    	String ee=(ret.getString("Pa_illness"));
			    	result1[n]=aa+"-"+bb+"-"+cc+"-"+dd+"-"+ee;
			    	n++;
			    	System.out.println(n);
			    	i++;
			    }
			    ret.close();
	            db.close();			// 关闭数据库连接
		        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		    }

		//String result = "select Pa_id,Pa_name,Pa_age,Pa_sex,Pa_illness from Patient";   // 得到病人信息，包括病人号，姓名，性别，年龄，症状    ps:可以直接传送给抓药和收费
		MySQLConnect db1 = null;  
	     ResultSet ret1 = null;  
	     String sql1 = "select Me_name from Medicine;";
	     
		 db1 = new MySQLConnect(sql1);
		 String result="";
			try {int i=0;
				ret1=db1.pst.executeQuery();					// 执行sql语句，得到结果集
			    while(ret1.next()){
			    	if (i!=0)result=result.concat("-");
			    	String bb=(ret1.getString("Me_name"));
			    	result=result+(bb);
			    	
			    	i++;
			    }
			    ret1.close();
	            db1.close();			// 关闭数据库连接
		        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		    }
		//String result1="select Me_name from Medicine";   //得到药品信息
		
		
		yao=result.split("-");
		String bingren="";
		//System.out.println(n);
		for(i=0;i<n;i++)bingren=bingren+"病人"+i+"号:"+result1[i]+"\n";
		

		
		JButton button = new JButton("\u786E\u5B9A");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a=textField.getText();
				String []b=result1[0].split("-");
				
				MySQLConnect db1 = null;  
			     ResultSet ret1 = null;  
			     String sql1 = "select Me_price from Medicine where Me_name='"+choose+"';";
			     
				 db1 = new MySQLConnect(sql1);
				 String result="";
					try {int i=0;
						ret1=db1.pst.executeQuery();					// 执行sql语句，得到结果集
					    while(ret1.next()){
					    	 d=ret1.getDouble("Me_price");
					    }
					    ret1.close();
			            db1.close();			// 关闭数据库连接
				        } catch (SQLException e1) {
					// TODO Auto-generated catch block
				        	//阿斯顿
					e1.printStackTrace();
				    }  
					int i = Integer.parseInt(a);
					sql1="insert into Me_List values('"+b[0]+"','"+choose+"',"+i+","+d+");";
					db1=new MySQLConnect(sql1);
					try {
					     db1.pst.executeUpdate();					// 执行sql语句，得到结果集
				         db1.close();			// 关闭数据库连接
			        } catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			    }
					//bingdan=b[0]+choose+a+Double.toString(d);
					//System.out.println(bingdan);
				 sql1="update Patient set Pa_state=4 where Pa_id='"+b[0]+"';";
				 db1=new MySQLConnect(sql1);
					try {
					     db1.pst.executeUpdate();					// 执行sql语句，得到结果集
				         db1.close();			// 关闭数据库连接
			        } catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			    }    
					JOptionPane.showMessageDialog(null, "开药成功");  
					kanbing kb=new kanbing();
					kb.main(null);
			}       
		});
		button.setBounds(162, 228, 93, 23);
		contentPane.add(button);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 64, 400, 46);
		contentPane.add(panel);
		
		JButton btnNewButton = new JButton("\u9009\u836F");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 choose = (String) JOptionPane.showInputDialog(null,"请选择需要的药:\n", "药", JOptionPane.PLAIN_MESSAGE, new ImageIcon("icon.png"), yao, "");  
			}
		});
		
		panel.add(btnNewButton);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(22, 10, 351, 55);
		contentPane.add(textPane);
		textPane.setText(bingren);
		 String bingdan=null;
		//bingdan
		}
}

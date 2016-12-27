package patient;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mySQL.MySQLConnect;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class gaohao0_5 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gaohao0_5 frame = new gaohao0_5();
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
	public gaohao0_5() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u7535\u8BDD\u4E3A\u60A8\u6302\u53F7");
		lblNewLabel.setBounds(138, 20, 135, 38);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(138, 68, 110, 38);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u786E\u5B9A");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
               String pa_id=textField.getText();

			   MySQLConnect db = null;  
			     ResultSet ret = null;  
			     String sql = "update Patient set Pa_state=2 where Pa_id="+pa_id+";";
			     System.out.println(sql);
				 db = new MySQLConnect(sql);
					try {
						db.pst.executeUpdate();					// 执行sql语句，得到结果集
					    
			            db.close();			// 关闭数据库连接
				        } catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				    }
                guahao2 newframe = new guahao2();
				newframe.setVisible(true);
			    dispose();
			}
		});
		btnNewButton.setBounds(144, 176, 93, 23);
		contentPane.add(btnNewButton);
	}

}

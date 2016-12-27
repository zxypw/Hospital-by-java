package phar;

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

public class UpdateMed extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private String Me_id=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateMed frame = new UpdateMed();
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
	public UpdateMed() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 502, 438);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("输入药品名：");
		lblNewLabel.setBounds(44, 33, 90, 18);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(161, 30, 99, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("查找");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					search();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(291, 29, 82, 27);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("药品名");
		lblNewLabel_1.setBounds(80, 112, 45, 18);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("药品号");
		lblNewLabel_2.setBounds(80, 144, 45, 18);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("单价");
		lblNewLabel_3.setBounds(80, 175, 30, 18);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("库存");
		lblNewLabel_4.setBounds(80, 206, 30, 18);
		contentPane.add(lblNewLabel_4);
		
		textField_1 = new JTextField();
		textField_1.setBounds(271, 172, 86, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(271, 203, 86, 24);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("输入新值");
		lblNewLabel_9.setBounds(285, 80, 72, 18);
		contentPane.add(lblNewLabel_9);
		
		JButton btnNewButton_1 = new JButton("确定");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_1.getText()!=null && textField_2.getText()!=null)
					update();
				close();
			}
		});
		btnNewButton_1.setBounds(260, 255, 113, 27);
		contentPane.add(btnNewButton_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(155, 109, 86, 24);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(155, 141, 86, 24);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(155, 172, 86, 24);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(155, 203, 86, 24);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
	}
	
	public void search() throws SQLException {
		String name=textField.getText();
		String sql="SELECT * FROM Medicine WHERE Me_name='"+name+"';";
		MySQLConnect conn=new MySQLConnect(sql);
		ResultSet re=conn.pst.executeQuery();
		if(re.next())
		{
			textField_3.setText(re.getString(2));
			textField_4.setText(re.getString(1));
			textField_5.setText(re.getString(3));
			textField_6.setText(re.getString(4));
			Me_id=re.getString(1);
		}
		conn.close();
	}
	public void update(){
		String new_price =textField_1.getText();
		String new_count=textField_2.getText();
		String sql="UPDATE Medicine SET Me_price="+new_price+",Me_inventory="+new_count+" WHERE Me_id='"+Me_id+"';";
		MySQLConnect conn=new MySQLConnect(sql);
		try {
			conn.pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		conn.close();
	}
	public void close(){
		this.dispose();
	}
}

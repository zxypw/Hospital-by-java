package phar;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javafx.scene.control.TextField;
import mySQL.MySQLConnect;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class InsertMed extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main( ) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertMed frame = new InsertMed();
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
	public InsertMed() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 398);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("药品号");
		lblNewLabel.setBounds(52, 43, 72, 18);
		getContentPane().add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(162, 40, 86, 24);
		getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("药品名");
		lblNewLabel_1.setBounds(52, 98, 72, 18);
		getContentPane().add(lblNewLabel_1);

		textField_1 = new JTextField();
		textField_1.setBounds(162, 95, 86, 24);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("定价");
		lblNewLabel_2.setBounds(52, 154, 72, 18);
		getContentPane().add(lblNewLabel_2);

		textField_2 = new JTextField();
		textField_2.setBounds(162, 151, 86, 24);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("库存");
		lblNewLabel_3.setBounds(52, 215, 72, 18);
		getContentPane().add(lblNewLabel_3);

		textField_3 = new JTextField();
		textField_3.setBounds(162, 212, 86, 24);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);

		JButton btnNewButton = new JButton("确定");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insert();
			}
		});
		btnNewButton.setBounds(117, 290, 113, 27);
		getContentPane().add(btnNewButton);
	}
	private void insert(){
		String mid=textField.getText();
		String mname=textField_1.getText();
		String mprice=textField_2.getText();
		String minv=textField_3.getText();
		String sql="INSERT Medicine VALUES ('"+mid+"','"+mname+"',"+mprice+","+minv+");";
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

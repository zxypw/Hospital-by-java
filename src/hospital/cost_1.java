package hospital;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.sql.*;

import javax.swing.*;

import hospital.MySQLConnect;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import hospital.MySQLConnect;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

public class cost_1 extends JFrame implements ActionListener  {
	/**
	 * 
	 */ 
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    JTable jt=null;
    JScrollPane jsp=null;
    private JTextField PaField;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cost_1 frame = new cost_1();
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
	public cost_1() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 355, 172);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		

		       
		
		
		setTitle("\u836F\u623F\u6536\u8D39");
		

        cost_2 rm=new cost_2();
		jt=new JTable(rm);
		jsp=new JScrollPane(jt);
		jsp.setBounds(5, 67, 354, 356);
		getContentPane().add(jsp);
		
		PaField = new JTextField();
		PaField.setBounds(119, 16, 158, 21);
		contentPane.add(PaField);
		PaField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u75C5\u4EBAid");
		lblNewLabel.setBounds(69, 10, 60, 33);
		contentPane.add(lblNewLabel);
		
		JButton Dispending = new JButton("收费");
		Dispending.setBounds(5, 433, 354, 79);
		contentPane.add(Dispending);
		Dispending.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql="delete from Me_List where Pa_id ='"+PaField.getText()+"';";
				MySQLConnect con=new MySQLConnect(sql);	
				int key=1;
				try{
					if(PaField.getText().equals("")){
						JOptionPane.showMessageDialog(null, "用户不存在"); key=0;}
					if(key==1){ con.pst.executeUpdate();   JOptionPane.showMessageDialog(null, "收费成功");}
					con.pst.executeUpdate();
				}catch(SQLException e1){
					e1.printStackTrace();
				}
			}
		});
		this.setBounds(12, 76, 380, 560);
		this.setVisible(true);

		}
	
	public void actionPerformed(ActionEvent arg0) {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
}



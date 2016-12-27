package patient;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import doc_medi.Docter_login;
import hospital.CostLogin;
import phar.PharLogin;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import javax.swing.JTextArea;

public class sys_hospital extends JFrame {
	String De_id,Do_name;
	private JPanel f1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sys_hospital frame = new sys_hospital();
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
	public sys_hospital() {
		setTitle("\u533B\u9662\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		f1 = new JPanel();
		f1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(f1);
		f1.setLayout(null);
		
		
		
        JButton btnNewButton = new JButton("\u75C5\u4EBA\r\n\u7CFB\u7EDF");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				patient newframe = new patient();
				newframe.setVisible(true);
			    dispose();
			    }
		});
		btnNewButton.setBounds(10, 63, 96, 139);
		f1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u533B\u751F\u5C31\u8BCA");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Docter_login newframe = new Docter_login();
				newframe.setVisible(true);
			    dispose();
			}
		});
		btnNewButton_1.setBounds(117, 63, 96, 139);
		f1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("抓药收费");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CostLogin newframe = new CostLogin();
				newframe.setVisible(true);
			    dispose();
			}
		});
		btnNewButton_2.setBounds(223, 63, 90, 139);
		f1.add(btnNewButton_2);
		
		
		JButton btnNewButton_3 = new JButton("药房管理");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PharLogin newframe = new PharLogin();
				newframe.setVisible(true);
			    dispose();
			}
		});
		btnNewButton_3.setBounds(323, 63, 90, 139);
		f1.add(btnNewButton_3);
	}
}

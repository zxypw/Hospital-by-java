package hospital;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class guahao2 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					guahao2 frame = new guahao2();
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
	public guahao2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u6302\u53F7\u6210\u529F\uFF01\u8BF7\u70B9\u51FB\u8FD4\u56DE\u9996\u9875");
		lblNewLabel.setBounds(128, 67, 173, 39);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("\u8FD4\u56DE\u9996\u9875");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sys_hospital newframe = new sys_hospital();
				newframe.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(156, 135, 93, 31);
		contentPane.add(btnNewButton);
	}

}

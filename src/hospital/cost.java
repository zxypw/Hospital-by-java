package hospital;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class cost extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cost frame = new cost();
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
	public cost() {
		setTitle("\u6536\u8D39\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 581, 401);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(150, 30, 179, 31);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnNewButton.setBounds(343, 30, 93, 31);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u75C5\u4EBAid\r\n");
		lblNewLabel.setBounds(62, 30, 87, 31);
		contentPane.add(lblNewLabel);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(150, 90, 179, 78);
		contentPane.add(textPane);
		
		JLabel lblNewLabel_1 = new JLabel("\u75C5\u4EBA\u4FE1\u606F");
		lblNewLabel_1.setBounds(62, 90, 78, 31);
		contentPane.add(lblNewLabel_1);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(150, 208, 179, 78);
		contentPane.add(textPane_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u8BA2\u5355\u4FE1\u606F");
		lblNewLabel_2.setBounds(62, 208, 66, 31);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(429, 296, 66, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u5408\u8BA1\u91D1\u989D\r\n");
		lblNewLabel_3.setBounds(359, 299, 54, 15);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton_1 = new JButton("\u6536\u8D39");
		btnNewButton_1.setBounds(170, 317, 93, 23);
		contentPane.add(btnNewButton_1);
	}
}

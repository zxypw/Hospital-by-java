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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u5269\u4F59\u4ED8\u8D39\u4EBA\u6570");
		label.setBounds(283, 10, 78, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u836F \u7269 \u540D \u79F0");
		label_1.setBounds(78, 52, 78, 15);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u836F\u7269\u6570\u91CF");
		label_2.setBounds(215, 52, 54, 15);
		contentPane.add(label_2);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(78, 77, 78, 150);
		contentPane.add(textPane);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(215, 78, 54, 150);
		contentPane.add(textPane_1);
		
		JLabel label_3 = new JLabel("\u5408\u8BA1\u91D1\u989D\uFF1A");
		label_3.setBounds(283, 237, 69, 15);
		contentPane.add(label_3);
		
		textField = new JTextField();
		textField.setBounds(346, 234, 66, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(368, 7, 40, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("\u6536\u8D39");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cost2 newframe = new cost2();
				newframe.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(287, 125, 93, 38);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u9000\u51FA\u7CFB\u7EDF");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sys_hospital newframe = new sys_hospital();
				newframe.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(287, 173, 93, 38);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u4FEE\u6539\u836F\u4EF7");
		btnNewButton_2.setBounds(287, 77, 93, 38);
		contentPane.add(btnNewButton_2);
	}

}

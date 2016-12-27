package patient;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class kanbing extends JFrame {
    static int i=0;
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
		
		
		
//		JComboBox comboBox = new JComboBox();
//		comboBox.setBounds(20, 66, 160, 21);
//		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("\u75C5\u4EBA\u75C7\u72B6\uFF1A");
		lblNewLabel.setBounds(10, 10, 245, 46);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("\u5269\u4F59\u6392\u961F\u75C5\u4EBA\u4EBA\u6570\uFF1A      ");
		label.setBounds(280, 10, 144, 31);
		contentPane.add(label);
		
//		while(i==1)
//		{
//			JList list = new JList();
//		list.setBounds(114, 138, 48, -25);
//		contentPane.add(list);
//		
//		JButton btnAdd = new JButton("add");
//		btnAdd.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				
//			}
//		});
//		btnAdd.setBounds(265, 65, 93, 23);
//		contentPane.add(btnAdd);
//		}
		
		
		JButton button = new JButton("\u786E\u5B9A");
		button.setBounds(162, 228, 93, 23);
		contentPane.add(button);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 64, 400, 46);
		contentPane.add(panel);
		
		JComboBox comboBox = new JComboBox();
		panel.add(comboBox);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 137, 400, 46);
		contentPane.add(panel_1);
		
		JComboBox comboBox_1 = new JComboBox();
		panel_1.add(comboBox_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		panel_1.add(textField_1);
		
		JButton button_1 = new JButton("New button");
		panel_1.add(button_1);
	}
	
}

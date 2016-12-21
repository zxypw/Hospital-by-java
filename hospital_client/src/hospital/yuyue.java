package hospital;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class yuyue extends JFrame {

	private JPanel f3;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					yuyue frame = new yuyue();
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
	public yuyue() {
		setTitle("\u586B\u5199\u4E2A\u4EBA\u4FE1\u606F");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		f3 = new JPanel();
		f3.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(f3);
		f3.setLayout(null);
		
		JLabel label = new JLabel(" \u59D3\u540D");
		label.setBounds(55, 20, 40, 20);
		f3.add(label);
		
		textField = new JTextField();
		textField.setBounds(90, 20, 100, 20);
		f3.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel(" \u6027\u522B");
		lblNewLabel.setBounds(55, 40, 40, 20);
		f3.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(90, 40, 100, 20);
		f3.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel(" \u5E74\u9F84");
		lblNewLabel_1.setBounds(55, 60, 40, 20);
		f3.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(" \u79D1\u5BA4\r\n");
		lblNewLabel_2.setBounds(55, 80, 40, 20);
		f3.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(" \u533B\u751F");
		lblNewLabel_3.setBounds(55, 100, 40, 20);
		f3.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel(" \u75C7\u72B6");
		lblNewLabel_4.setBounds(55, 120, 40, 20);
		f3.add(lblNewLabel_4);
		
		textField_2 = new JTextField();
		textField_2.setBounds(90, 60, 100, 20);
		f3.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("\u786E\u5B9A");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				yuyue2 newframe = new yuyue2();
				newframe.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(90, 213, 93, 30);
		f3.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u53CD\u56DE\u9996\u9875");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sys_hospital newframe = new sys_hospital();
				newframe.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(249, 213, 93, 30);
		f3.add(btnNewButton_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"    \u79D1\u5BA41", "    \u79D1\u5BA42"}));
		comboBox.setForeground(Color.BLACK);
		comboBox.setToolTipText("");
		comboBox.setBounds(90, 80, 100, 20);
		f3.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"\u79D1\u5BA41 \u533B\u751FA", "\u79D1\u5BA41 \u533B\u751FA", "\u79D1\u5BA41 \u533B\u751FA", "\u79D1\u5BA42 \u533B\u751FA", "\u79D1\u5BA42 \u533B\u751FA", "\u79D1\u5BA42 \u533B\u751FA"}));
		comboBox_1.setBounds(90, 100, 100, 20);
		f3.add(comboBox_1);
		
		JLabel lblNewLabel_5 = new JLabel(" \u65F6\u95F4");
		lblNewLabel_5.setToolTipText("");
		lblNewLabel_5.setBounds(224, 20, 40, 20);
		f3.add(lblNewLabel_5);
		
		textField_3 = new JTextField();
		textField_3.setBounds(264, 20, 40, 20);
		f3.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("\u5E74");
		lblNewLabel_6.setBounds(304, 20, 15, 20);
		f3.add(lblNewLabel_6);
		
		textField_4 = new JTextField();
		textField_4.setBounds(319, 20, 20, 20);
		f3.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("\u6708");
		lblNewLabel_7.setBounds(339, 20, 15, 20);
		f3.add(lblNewLabel_7);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(349, 20, 20, 20);
		f3.add(textField_6);
		
		JLabel label_1 = new JLabel("\u65E5");
		label_1.setBounds(369, 20, 15, 20);
		f3.add(label_1);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(90, 120, 200, 60);
		f3.add(textPane);
	}
}

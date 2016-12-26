package hospital;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class guahao extends JFrame {
	private static String command;
	private String name;
	private JPanel f3;
	String De_id,Do_name;
	 static Object[] keshi;
	 static Object[] yisheng;

	private static JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
   
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					guahao frame = new guahao();
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
	public guahao() {
		setTitle("\u586B\u5199\u4E2A\u4EBA\u4FE1\u606F");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		f3 = new JPanel();
		f3.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(f3);
		f3.setLayout(null);
		
		String result1="1-2";//"result1为接受到的药的信息"
        keshi=result1.split("-"); //将药的信息分好
        String result2="1.a-1.b-1.c-2.a-2.b-2.c";//"result1为接受到的药的信息"
        yisheng=result2.split("-"); //将药的信息分好
		
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
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(90, 120, 200, 60);
		f3.add(textPane);
		
		JLabel label_1 = new JLabel("\u7535\u8BDD");
		label_1.setBounds(214, 23, 54, 15);
		f3.add(label_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(259, 20, 100, 21);
		f3.add(textField_3);
		textField_3.setColumns(10);
		
		
		
		JButton button = new JButton("\u9009\u62E9\u79D1\u5BA4");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 De_id = (String) JOptionPane.showInputDialog(null,"请选择你要的科室:\n", "科室", JOptionPane.PLAIN_MESSAGE, new ImageIcon("icon.png"), keshi, ""); 
			}
		});
		button.setBounds(90, 79, 93, 23);
		f3.add(button);
		
		JButton button_1 = new JButton("\u9009\u62E9\u533B\u751F");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Do_name = (String) JOptionPane.showInputDialog(null,"请选择你要的医生:\n", "医生", JOptionPane.PLAIN_MESSAGE, new ImageIcon("icon.png"), yisheng, ""); 
			}
		});
		button_1.setBounds(90, 99, 93, 23);
		f3.add(button_1);
		
		JButton btnNewButton = new JButton("\u786E\u5B9A");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String pa_id,pa_name,pa_age,pa_sex,pa_zhengzhuang,papa;
				pa_name=textField.getText();
				pa_id=textField_3.getText();
				pa_age=textField_1.getText();
				pa_sex=textField_2.getText();
				pa_zhengzhuang=textPane.getText();
				papa="1 0 2 "+pa_id+" "+pa_name+" "+pa_age+" "+pa_sex+" "+De_id+" "+Do_name+" "+pa_zhengzhuang;
				System.out.println(papa);
				guahao2 newframe = new guahao2();
				newframe.setVisible(true);
				dispose();
				
			}
		});
		
		btnNewButton.setBounds(90, 213, 93, 30);
		f3.add(btnNewButton);
		
		
		
				
	}
}

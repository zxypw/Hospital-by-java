package patient;

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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.rmi.UnknownHostException;
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
	String De_id,Do_name;
	static Object[] keshi;
	 static Object[] yisheng;
	 private JTextField textField_5;
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

	
	public String connect(String mes)
	{
		   Socket server=null;
		   String ex=null; 
	        try{
	        String inputString;
	        server=new Socket("127.0.0.1",4444);
	       //System.out.println("连接成功");
	        BufferedReader sin =new BufferedReader(new InputStreamReader(System.in));
	        PrintWriter os=new PrintWriter(server.getOutputStream());
	        BufferedReader is=new BufferedReader(new InputStreamReader(server.getInputStream(),"UTF-8"));
	        inputString=mes;
	       	os.println(inputString);;
	     	os.flush();
	        ex=is.readLine();
	        System.out.println(ex);
	        os.close();
	        is.close();
	        server.close();
	        }catch(UnknownHostException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
			return ex;
	}
	/**
	 * Create the frame.
	 */
	public yuyue() {
		String  result1=Connect.connect("查询有哪些科室");
	//	System.out.println(result1);
		
	//	result1="1-2";//"result1为接受到的科室的信息"
        keshi=result1.split("-"); //将科室的信息分好
        
        String result2=Connect.connect("查询有哪些医生");
        //String result2="1.a-1.b-1.c-2.a-2.b-2.c";//"result1为接受到的医生的信息"
        yisheng=result2.split("-"); //将药的信息分好
        
        
		
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
		
		final JTextPane textPane = new JTextPane();
		textPane.setBounds(90, 120, 200, 60);
		f3.add(textPane);
		
		JButton btnNewButton = new JButton("\u786E\u5B9A");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String pa_id,pa_name,pa_age,pa_sex,pa_zhengzhuang,papa;
				pa_name=textField.getText();
				pa_id=textField_5.getText();
				pa_age=textField_1.getText();
				pa_sex=textField_2.getText();
				pa_zhengzhuang=textPane.getText();
				
				papa="1 "+pa_id+" 0 2 "+"1 "+pa_id+" "+pa_name+" "+pa_age+" "+pa_sex+" "+De_id+" "+Do_name+" "+pa_zhengzhuang;
				System.out.println(papa);
				String up=Connect.connect(papa);
				yuyue2 newframe = new yuyue2();
				newframe.setVisible(true);
				dispose();
				
				
			}
		});
		btnNewButton.setBounds(90, 213, 93, 30);
		f3.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("\u79D1\u5BA4");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 De_id = (String) JOptionPane.showInputDialog(null,"请选择你要的科室:\n", "科室", JOptionPane.PLAIN_MESSAGE, new ImageIcon("icon.png"), keshi, "");
			}
		});
		btnNewButton_2.setBounds(90, 79, 93, 23);
		f3.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\u533B\u751F");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Do_name = (String) JOptionPane.showInputDialog(null,"请选择你要的医生:\n", "医生", JOptionPane.PLAIN_MESSAGE, new ImageIcon("icon.png"), yisheng, "");
			}
		});
		btnNewButton_3.setBounds(90, 99, 93, 23);
		f3.add(btnNewButton_3);
		
		JLabel label_2 = new JLabel("\u7535\u8BDD");
		label_2.setBounds(234, 43, 54, 15);
		f3.add(label_2);
		
		textField_5 = new JTextField();
		textField_5.setBounds(274, 40, 100, 21);
		f3.add(textField_5);
		textField_5.setColumns(10);
		
	}
}

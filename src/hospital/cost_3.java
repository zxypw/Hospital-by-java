package hospital;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class cost_3 extends JFrame {
	DecimalFormat    df   = new DecimalFormat("######0.00");   
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cost_3 frame = new cost_3();
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
	public cost_3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("\u8FD4\u56DE\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cost_1 newframe = new cost_1();
				newframe.setVisible(true);
			    dispose();
			}
		});
		btnNewButton.setBounds(160, 214, 93, 23);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(187, 121, 139, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		double sum=cost_2.num*cost_2.price;  
		String sum_str="\""+sum+"\"";
		textField.setText(sum_str);
		
		
		JLabel label = new JLabel("\u5143");
		label.setBounds(336, 124, 54, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u5171\u6536\u8D39");
		label_1.setBounds(128, 124, 54, 15);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u8BF7\u70B9\u51FB\u8FD4\u56DE");
		label_2.setBounds(175, 177, 78, 15);
		contentPane.add(label_2);
	}
}


//

package doc_medi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class shoufei extends JFrame {

	private JPanel contentPane;
	String result2="5";  //根据药名搜索出价格
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					shoufei frame = new shoufei();
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
	public shoufei() {
		String result="w-h-b-x-s";  //接受病人信息     "4 0 1 "+"Pa_name"+" "+"Pa_illness"
		String result1="a-4"; //接受药方                           "4 0 1 "+"Pa_prescriprion"
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(result);
		lblNewLabel.setBounds(124, 10, 149, 49);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(result1);
		lblNewLabel_1.setBounds(124, 69, 149, 49);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("\u6536\u8D39");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "收费成功总共"+result2+"元");    
			}
		});
		btnNewButton.setBounds(150, 189, 93, 23);
		contentPane.add(btnNewButton);
	}
}

package hospital;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class adm extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adm frame = new adm();
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
	public adm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2\u8D26\u6237");
		btnNewButton.setBounds(61, 93, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u4FEE\u6539\u8D26\u6237");
		btnNewButton_1.setBounds(180, 93, 93, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u8FD4\u56DE\u9996\u9875");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sys_hospital newframe = new sys_hospital();
				newframe.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton_2.setBounds(294, 93, 93, 23);
		contentPane.add(btnNewButton_2);
	}

}

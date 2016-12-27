package patient;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class patient extends JFrame {

	private JPanel f2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					patient frame = new patient();
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
	public patient() {
		setTitle("\u75C5\u4EBA\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		f2 = new JPanel();
		f2.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(f2);
		f2.setLayout(null);
		
		JButton btnNewButton = new JButton("\u6302\u53F7");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guahao0 newframe = new guahao0();
				newframe.setVisible(true);
			    dispose();
				
				
			}
		});
		btnNewButton.setBounds(0, 0, 207, 252);
		f2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u9884\u7EA6");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				yuyue newframe = new yuyue();
				newframe.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(206, 0, 218, 252);
		f2.add(btnNewButton_1);
	}

}

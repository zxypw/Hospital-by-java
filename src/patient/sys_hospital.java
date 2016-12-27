package patient;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import javax.swing.JTextArea;

public class sys_hospital extends JFrame {
	String De_id,Do_name;
	private JPanel f1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sys_hospital frame = new sys_hospital();
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
	public sys_hospital() {
		setTitle("\u533B\u9662\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		f1 = new JPanel();
		f1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(f1);
		f1.setLayout(null);
		
		
		
        JButton btnNewButton = new JButton("\u75C5\u4EBA\r\n\u7CFB\u7EDF");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				patient newframe = new patient();
				newframe.setVisible(true);
			    dispose();
			    }
		});
		btnNewButton.setBounds(10, 63, 96, 139);
		f1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u533B\u751F\u5C31\u8BCA");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(90, 63, 96, 139);
		f1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u836F\u623F\u6536\u8D39");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				costenter newframe = new costenter();
				newframe.setVisible(true);
			    dispose();
			}
		});
		btnNewButton_2.setBounds(170, 63, 90, 139);
		f1.add(btnNewButton_2);
		
		
		JButton btnNewButton_3 = new JButton("\u9662\u957F\u67E5\u8BE2");
		btnNewButton_3.setBounds(249, 63, 90, 139);
		f1.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("\u7BA1\u7406\u5458");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admenter newframe = new admenter();
				newframe.setVisible(true);
			    dispose();
				
			}
		});
		btnNewButton_4.setBounds(328, 63, 81, 139);
		f1.add(btnNewButton_4);
	}
}

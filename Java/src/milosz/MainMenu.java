package milosz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import martin.ClockInRecord;

import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
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
	public MainMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 523, 404);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Employee Menu", null, panel, null);
		panel.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Your Weeks Schedule");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Timetable T = new Timetable();
				
				T.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(10, 11, 472, 47);
		panel.add(btnNewButton_1);
		
		if(milosz.IronGiant.getUser() == null || !milosz.IronGiant.getUser().isManager())
			return;
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Manager Menu", null, panel_1, null);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Employee Clock-Ins");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClockInRecord P = new ClockInRecord();
				dispose();
			}
		});
		btnNewButton.setBounds(10, 11, 472, 47);
		panel_1.add(btnNewButton);
	}
}

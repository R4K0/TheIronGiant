package milosz;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField LoginText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Log-In", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblPpsNumber = new JLabel("PPS Number");
		lblPpsNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblPpsNumber.setBounds(10, 11, 399, 14);
		panel_1.add(lblPpsNumber);
		
		LoginText = new JTextField();
		LoginText.setBounds(10, 36, 399, 20);
		panel_1.add(LoginText);
		LoginText.setColumns(10);
		
		JButton btnNewButton = new JButton("Log-In");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String Text = LoginText.getText();
				
				if(Text.equals("") || Text == null ) {
					JOptionPane.showMessageDialog( contentPane, "Please input in your PPS number" );
					return;
				}
				
				try {
					PreparedStatement STM = milosz.IronGiant.DB.prepareStatement( "SELECT * FROM employees WHERE pps = ? LIMIT 1");
					STM.setString(1, Text);
					ResultSet Result = STM.executeQuery();
					
					if(!Result.isBeforeFirst()) {
						JOptionPane.showMessageDialog( contentPane, "Couldn't find an employee with that PPS number" );
						
						int Create = JOptionPane.showConfirmDialog( contentPane, "Would you like to create an employee with that PPS Number?",
								"Employee Creation", 2 );
						
						if(Create==0) {
							new CreateEmployee(Text).setVisible(true);
						}
						return;
					}
					
					Result.next();
					
					Employee Current = new Employee(Result.getString(1), Result.getString(2), Result.getString(3));
					Current.setManager( Result.getBoolean(4) );
					
					milosz.IronGiant.setUser( Current );
					new MainMenu().setVisible( true );
					dispose();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(10, 160, 399, 52);
		panel_1.add(btnNewButton);
	}
}

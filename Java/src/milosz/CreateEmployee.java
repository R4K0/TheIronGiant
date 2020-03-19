package milosz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class CreateEmployee extends JFrame {

	private JPanel contentPane;
	private JTextField PPSText;
	private JTextField FirstNameText;
	private JTextField SecondNameText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateEmployee frame = new CreateEmployee();
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
	public CreateEmployee( String PPS ) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		PPSText = new JTextField();
		PPSText.setBounds(10, 29, 139, 20);
		contentPane.add(PPSText);
		PPSText.setColumns(10);
		PPSText.setText( PPS );
		PPSText.setEnabled( false );
		
		JLabel lblNewLabel = new JLabel("PPS");
		lblNewLabel.setBounds(10, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(10, 60, 67, 14);
		contentPane.add(lblFirstName);
		
		FirstNameText = new JTextField();
		FirstNameText.setColumns(10);
		FirstNameText.setBounds(10, 78, 139, 20);
		contentPane.add(FirstNameText);
		
		JLabel lblSecondName = new JLabel("Second Name");
		lblSecondName.setBounds(159, 60, 139, 14);
		contentPane.add(lblSecondName);
		
		SecondNameText = new JTextField();
		SecondNameText.setColumns(10);
		SecondNameText.setBounds(159, 78, 139, 20);
		contentPane.add(SecondNameText);
		
		JCheckBox Manager = new JCheckBox("Manager");
		Manager.setBounds(6, 105, 97, 23);
		contentPane.add(Manager);
		
		JButton btnNewButton = new JButton("Create");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					PreparedStatement STM = milosz.IronGiant.DB.prepareStatement( "INSERT INTO employees(pps, first_name, second_name, manager)"
							+ "VALUES (?, ?, ?, ?);");
					
					STM.setString( 1, PPSText.getText());
					STM.setString( 2, FirstNameText.getText());
					STM.setString( 3, SecondNameText.getText());
					STM.setBoolean( 4, Manager.isSelected() );
					
					boolean Success = STM.executeUpdate() > 0 ? true : false;
					
					JOptionPane.showMessageDialog( contentPane, Success == true ? "Successfully created an employee!" : "Creation failed!" );
					dispose();
				} catch (SQLException e) {
					JOptionPane.showMessageDialog( contentPane, "Failed to create an employee record!\nError:\n" + e.getLocalizedMessage());
				}
			}
		});
		btnNewButton.setBounds(10, 227, 414, 23);
		contentPane.add(btnNewButton);		
	}
	
	public CreateEmployee(){
		this("");
		this.PPSText.setEnabled( true );
	}
}

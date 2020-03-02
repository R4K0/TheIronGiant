package martin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JTextPane;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class ClockInRecord {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClockInRecord window = new ClockInRecord();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ClockInRecord() {
		initialize();
		
		this.frame.setVisible( true );
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 600, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 63, 564, 301);
		frame.getContentPane().add(panel);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"", "(Current-Date)", "", null},
				{"  Employee", "  Clock-In", "  Clock-Out", "  Record"},
				{"  1", null, null, null},
				{"  2", null, null, null},
				{"  3", null, null, null},
				{"  4", null, null, null},
				{"  5", null, null, null},
			},
			new String[] {
				"Employee", "Clock-In", "Clock-Out", "Link To Record"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(120);
		table.getColumnModel().getColumn(0).setMinWidth(120);
		table.getColumnModel().getColumn(1).setPreferredWidth(120);
		table.getColumnModel().getColumn(1).setMinWidth(120);
		table.getColumnModel().getColumn(2).setPreferredWidth(120);
		table.getColumnModel().getColumn(2).setMinWidth(120);
		table.getColumnModel().getColumn(3).setPreferredWidth(120);
		table.getColumnModel().getColumn(3).setMinWidth(120);
		table.setFillsViewportHeight(true);
		panel.add(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 11, 564, 41);
		frame.getContentPane().add(panel_1);
		
		JTextPane txtpnEmployeeClockinRecords = new JTextPane();
		txtpnEmployeeClockinRecords.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtpnEmployeeClockinRecords.setText("Employee Clock-In Records");
		panel_1.add(txtpnEmployeeClockinRecords);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 375, 564, 75);
		frame.getContentPane().add(panel_2);
		
		JButton btnBack = new JButton("Back");
		panel_2.add(btnBack);
	}
}

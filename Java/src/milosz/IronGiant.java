package milosz;
import java.sql.*;
import javax.swing.JOptionPane;

public class IronGiant {
	public static Connection DB;
	private static milosz.Employee User;
	
	public static milosz.Employee getUser() {
		return User;
	}

	public static void setUser(milosz.Employee user) {
		User = user;
	}

	private static void InitializeDatabase() throws SQLException {
		Statement STM = DB.createStatement();
		
		STM.execute( "CREATE TABLE IF NOT EXISTS employees ("
				+ "pps VARCHAR(17) PRIMARY KEY,"
				+ "first_name VARCHAR(30) NOT NULL,"
				+ "second_name VARCHAR(30) NOT NULL,"
				+ "manager BOOLEAN DEFAULT FALSE"
				+ ");" );
		STM.execute("CREATE TABLE IF NOT EXISTS schedules ("
				+ "pps VARCHAR(17),"
				+ "starttime integer,"
				+ "endtime integer,"
				+ "FOREIGN KEY(pps) REFERENCES employees(pps)"
				+ ");" );
		STM.close();
		
		System.out.println("Created the database!");
	}
	
	private static void DropDatabase() throws SQLException {
		Statement STM = DB.createStatement();
		
		STM.execute("DROP TABLE IF EXISTS employees");
		STM.execute("DROP TABLE IF EXISTS schedules");
		STM.close();
		
		System.out.println("Dropped the database!");
	}
	
	public static void main(String[] args) {
		final String DBLoc = "jdbc:sqlite:../main.sqlite";

		try {
			DB = DriverManager.getConnection(DBLoc);
			
			if(DB==null) {
				JOptionPane.showMessageDialog( null, "Couldn't estabilish a connection to the database!");
				System.exit(0);
			}
			
			int shouldWipe = JOptionPane.showConfirmDialog( null, "Do you want to wipe the database?\nShould only be used for development", "Development", 2);
			
			if(shouldWipe==0)
				DropDatabase();
			
			InitializeDatabase();
			
			 new Login().setVisible( true );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
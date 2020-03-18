import java.sql.*;

public class IronGiant {
	public static Connection DB;
	
	public static void main(String[] args) {
		final String DBLoc = "jdbc:sqlite:../main.db";

		try {
			DB = DriverManager.getConnection(DBLoc);
			
			System.out.println( "Database connected!" );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
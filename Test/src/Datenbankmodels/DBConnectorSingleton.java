package Datenbankmodels;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectorSingleton { //Ben Kröncke
	
	private static Connection conn;
	
	static
	{
		try {
			
			//Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "sa");
			
			
		}
		catch(/**ClassNotFoundException |**/ SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getCon() {
		return conn;
	}
	
	
	public static void closeCon() throws SQLException {
		conn.close();
	}
	

}

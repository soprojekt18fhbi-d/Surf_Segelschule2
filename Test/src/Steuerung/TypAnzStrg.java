package Steuerung;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class TypAnzStrg {
	public static void main(String[] a)
	
            throws Exception {
        Connection conn = DriverManager.
            getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "sa");
        // add application code here
        viewTable(conn);
        
        conn.close();
    }

	public static String viewTable(Connection con)
	    throws SQLException {
		
	    Statement stmt = null;
	    String query = "select * from TYP";
	    try {
	        stmt = con.createStatement();
	        ResultSet rs = stmt.executeQuery(query);
	        while (rs.next()) {
	        	
	        	String id = rs.getString(1);
	        	String name = rs.getString(2);
	        	String ausgabe = id+", "+name;
	        	
	        	
	        	return ausgabe;
	        }
	       
	    } catch (SQLException e ) {
	    	e.printStackTrace();
	    } finally {
	        if (stmt != null) { stmt.close(); }
	    }
	    return query;
	}
}


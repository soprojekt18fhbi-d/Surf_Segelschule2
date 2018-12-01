package Steuerung;

import java.sql.*;


public class Testanbindung{
	
	public static void main(String[] a)
	
            throws Exception {
        Connection conn = DriverManager.
            getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "sa");
        // add application code here
        viewTable(conn);
        
        conn.close();
    }



public static void viewTable(Connection con)
	    throws SQLException {

	    Statement stmt = null;
	    String query = "select * from KUNDE";
	    try {
	        stmt = con.createStatement();
	        ResultSet rs = stmt.executeQuery(query);
	        while (rs.next()) {
	        	
	        	String vorname = rs.getString("VORNAME");
	            String nachname = rs.getString("NACHNAME");
	            String email = rs.getString("EMAIL");
	            String eintrittsdatum = rs.getString("EINTRITTSDATUM");
	            
	            
	            System.out.println(vorname + " " + nachname + " hat die E-Mail " + email + " und ist bei uns seit dem " + eintrittsdatum);
	        }
	    } catch (SQLException e ) {
	    	e.printStackTrace();
	    } finally {
	        if (stmt != null) { stmt.close(); }
	    }
	}
}
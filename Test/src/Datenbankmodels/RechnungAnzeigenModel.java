package Datenbankmodels;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.table.TableModel;

import Domaenklassen.GeraeteModell;
import Domaenklassen.GeraeteTyp;
import Domaenklassen.Rechnung;
import GUI.IObjektView;
import net.proteanit.sql.DbUtils;


/**
 * @author Darnel
 *
 */
public class RechnungAnzeigenModel implements IObjektModel{
	
	private ArrayList<IObjektView> observers = new ArrayList<IObjektView>();
	private ArrayList<Rechnung> mengeAnRechnungen = new ArrayList<Rechnung>();
	private TableModel table;
	private TableModel result;
	private int rechnungID = 0;
	private int rechnungsNr;
	private String talking;
	private String search;

	@Override
	public void anmelden(IObjektView view) {
		try {
			observers.add(view);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void abmelden(IObjektView view) {
		try {
			if(observers.contains(view));
				observers.remove(view);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateObserver() {
		try {
			for (int i = 0; i < observers.size(); ++i) 
				observers.get(i).aktualisieren(this);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	// Wird ausgeführt, wenn die Rechnungsübersicht aufgerufen wird.
	public void holeDatenSuche(String search) {

		this.search = search;
		
        try {
			Connection conn = DriverManager.
			    getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "sa");
			// add application code here
			rechnungSuche(conn);
			
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
        updateObserver();
	}
	
	// Wird ausgeführt, wenn ein Kunde nach Rechnungen sucht. 
	public void holeDaten() {
		
		 System.out.println();
        try {
        	
			Connection conn = DriverManager.
			    getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "sa");
			// add application code here
			viewTable(conn);
			
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        updateObserver();
	}
	
//	public void viewTable(Connection con)
//	    throws SQLException {
//
//	    Statement stmt = null;
//		String query = "select * from RECHNUNG";
//		   
//		try {
//			stmt = con.createStatement();
//
//			System.out.println(query);
//				
//			ResultSet rs = stmt.executeQuery(query);
//			table = DbUtils.resultSetToTableModel(rs);
//
//		} catch (SQLException e ) {
//			e.printStackTrace();
//		} finally {
//			if (stmt != null) { stmt.close(); }
//		}
//
//	}
	
	public void viewTable(Connection con)
    throws SQLException {

    Statement stmt = null;
	String query = "select * from RECHNUNG ORDER BY ID DESC";
	   
	try {
		stmt = con.createStatement();

		System.out.println(query);
			
		ResultSet rs = stmt.executeQuery(query);
		table = DbUtils.resultSetToTableModel(rs);

	} catch (SQLException e ) {
		e.printStackTrace();
	} finally {
		if (stmt != null) { stmt.close(); }
	}

}
	
	public void rechnungSuche(Connection con)
		    throws SQLException {

		 Statement stmt = con.createStatement();
		    String query = null;
		    
		    if(search.equals(""))
		    	query = "SELECT * FROM RECHNUNG ORDER BY ID DESC;";
		    else 
		    	query = "SELECT * FROM RECHNUNG WHERE KUNDEID LIKE '%" +search+ "%' ORDER BY ID DESC";
		   
		    
		    System.out.println(query);
		    System.out.println(search);
		    
		    
		    try {
		        stmt = con.createStatement();
		        ResultSet rs = stmt.executeQuery(query);
		        
		        table = DbUtils.resultSetToTableModel(rs);
		        
		    } catch (SQLException e ) {
		    	e.printStackTrace();
		    } finally {
		        if (stmt != null) { stmt.close(); }
		    }

		}
	

	

	

	@Override
	public ArrayList<Object> getObjekte() {
		// TODO Auto-generated method stub
		return null;
	}

	public TableModel getTableModel() {
		// TODO Auto-generated method stub
		return table;
	}
}


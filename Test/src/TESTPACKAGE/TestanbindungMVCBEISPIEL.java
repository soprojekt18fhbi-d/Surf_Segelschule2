package TESTPACKAGE;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListModel;

import DataModelKlassen.IModel;
import Domaenklassen.Kunde;
import GUI.IView;


public class TestanbindungMVCBEISPIEL implements IModel{
	
	/**
	 * @author Benkr
	 * Testklasse zum verstehen des MVC-Models und zum Verstehen, wie die Datenbankanbindung umgesetzt werden soll
	 * (wird im meeting von mir erklärt)
	 */
	
	private ArrayList<IView> observers = new ArrayList<IView>();

	private int kundeNr = 0;
	
	private ArrayList<Kunde> mengeAnKunden = new ArrayList<Kunde>();
	
	public void holeKunden() {
	
 
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

	
	
	


	public void viewTable(Connection con)
	    throws SQLException {

	    Statement stmt = null;
	    String query = "select * from KUNDE";
	    try {
	        stmt = con.createStatement();
	        ResultSet rs = stmt.executeQuery(query);
	        while (rs.next()) {
	        	
	        	kundeNr = kundeNr++;
	        	String id = rs.getString("ID");
	        	String name =  rs.getString("NACHNAME");
	        	String vorname =  rs.getString("VORNAME");
	        	String email =  rs.getString("EMAIL");
	        	Kunde kundeNr  = new Kunde(name, vorname, null, false, false, false, 0, email);
	        	mengeAnKunden.add(kundeNr);
	        }
	        
	    } catch (SQLException e ) {
	    	e.printStackTrace();
	    } finally {
	        if (stmt != null) { stmt.close(); }
	    }
	    
	    
	}

	

	@Override
	public void anmelden(IView view) {
		/**
		 * Anmelden einer View
		 * @author Benkr
		 * 
		 */
		
		try {
			observers.add(view);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
}



	@Override
	public void abmelden(IView view) {
		/**
		 * Abmelden einer View.
		 * @author Benkr
		 * 
		 */
		
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
		/**
		 * updaten der Views
		 * @author Benkr
		 * 
		 */
		try {
			for (int i = 0; i < observers.size(); ++i) 
				observers.get(i).aktualisieren(this);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public DefaultListModel getKunden(){
		
		DefaultListModel<String> listmodel = new DefaultListModel<String>();
		
				
		for(int i = 0; i < mengeAnKunden.size(); i++) {
			listmodel.addElement(mengeAnKunden.get(i).getName() + ", " + mengeAnKunden.get(i).getVorname() + ", " + mengeAnKunden.get(i).getEmail());
		}
		return listmodel;
		
		
		
	}







	
	
}











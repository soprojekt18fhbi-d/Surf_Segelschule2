package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.table.TableModel;

import com.entity.GeraeteModell;
import com.entity.GeraeteTyp;
import com.entity.Rechnung;
import com.view.IObjektView;

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
	private String search;
	private int rechnungsID;
	private double summe;
	private double summeMitMwst;
	private double mwst;
	private String ausleihdatum;
	private String verkaufsdatum;
	private int kundeID;
	private int buchungsID;
	private int reparaturID;
	private String art;
	private int sportgeraetID;
	private int modellID;
	private String farbe;
	private String modellname;
	private String vorname;
	private String nachname;
	private String eMail;
	private int plz;
	private String strasse;
	private String ort;
	private String hnr;
	private int heim_Urlaub;


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
			Connection conn = DBConnectorSingleton.getCon();
			// add application code here
			rechnungSuche(conn);
			
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
        	
			Connection conn = DBConnectorSingleton.getCon();
			// add application code here
			viewTable(conn);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        updateObserver();
	}
	
	public void holeDatenDrucken(int rechnungsID, int heim_Urlaub) {

		this.rechnungsID = rechnungsID;
		
        try {
			Connection conn = DBConnectorSingleton.getCon();
			// add application code here
			rechnungDruckenRechnung(conn, rechnungsID);
			rechnungDruckenBuchung(conn, buchungsID);
			rechnungDruckenSportgeraet(conn, sportgeraetID);
			rechnungDruckenModell(conn, modellID);
			rechnungDruckenKunde(conn, kundeID);
			rechnungDruckenAdresse(conn, kundeID, heim_Urlaub);

			
			
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
        updateObserver();
	}
	
	
	public void viewTable(Connection con)
    throws SQLException {

    Statement stmtRechnungAnzeigenModel = null;
	String query = "select * from RECHNUNG ORDER BY ID DESC";
	   
	try {
		stmtRechnungAnzeigenModel = con.createStatement();

		System.out.println(query);
			
		ResultSet rs = stmtRechnungAnzeigenModel.executeQuery(query);
		table = DbUtils.resultSetToTableModel(rs);

	} catch (SQLException e ) {
		e.printStackTrace();
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
	
	public void rechnungDruckenRechnung(Connection con, int rechnungsID)
		    throws SQLException {

		 Statement stmt = con.createStatement();
		    String query = "SELECT * FROM RECHNUNG WHERE ID = "+rechnungsID;
		    System.out.println(query);
		    
		    try {
		        stmt = con.createStatement();
		        ResultSet rs = stmt.executeQuery(query);
		        System.out.println(rs);
		        while(rs.next()) {
		        summe = rs.getDouble(2);
		        mwst = rs.getDouble(3);
		        summeMitMwst = rs.getDouble(4);
		        kundeID = rs.getInt(5);
		        reparaturID = rs.getInt(6);
		        buchungsID = rs.getInt(7);
		        System.out.println("Model:" +summe+" "+ mwst +" "+ summeMitMwst +" "+ kundeID+" "+reparaturID+" "+  buchungsID);
		        }
		    } catch (SQLException e ) {
		    	e.printStackTrace();
		    } finally {
		        if (stmt != null) { stmt.close(); }
		    }

		}
	
	public void rechnungDruckenBuchung(Connection con, int buchungsID)
		    throws SQLException {

		 Statement stmt = con.createStatement();
		    String query = "SELECT * FROM BUCHUNG WHERE ID = "+buchungsID;
		    System.out.println(query);
		   
		    
		    try {
		        stmt = con.createStatement();
		        ResultSet rs = stmt.executeQuery(query);
		        while(rs.next()) {
		        ausleihdatum = rs.getString(2);
		        verkaufsdatum = rs.getString(5); 
		        art = rs.getString(6);
		        sportgeraetID  = rs.getInt(7);
		        System.out.println("Buchung:" + art +" "+ sportgeraetID);
		        }
		    } catch (SQLException e ) {
		    	e.printStackTrace();
		    } finally {
		        if (stmt != null) { stmt.close(); }
		    }

		}
	
	public void rechnungDruckenSportgeraet(Connection con, int sportgeraetID)
		    throws SQLException {

		 Statement stmt = con.createStatement();
		    String query = "SELECT * FROM SPORTGERAET WHERE ID = "+sportgeraetID;
		    System.out.println(query);
		   
		    
		    try {
		        stmt = con.createStatement();
		        ResultSet rs = stmt.executeQuery(query);
		        while(rs.next()) {
		        modellID = rs.getInt(5);
		        farbe  = rs.getString(8);
		        System.out.println("Sportgeraet:" + modellID +" "+ farbe);
		        }
		    } catch (SQLException e ) {
		    	e.printStackTrace();
		    } finally {
		        if (stmt != null) { stmt.close(); }
		    }

		}
	
	public void rechnungDruckenModell(Connection con, int modellID)
		    throws SQLException {

		 Statement stmt = con.createStatement();
		    String query = "SELECT * FROM MODELL WHERE ID = "+modellID;
		    System.out.println(query);
		   
		    
		    try {
		        stmt = con.createStatement();
		        ResultSet rs = stmt.executeQuery(query);
		        while(rs.next()) {
		        modellname  = rs.getString(2);
		        System.out.println("Modell:" + modellname);
		        }
		    } catch (SQLException e ) {
		    	e.printStackTrace();
		    } finally {
		        if (stmt != null) { stmt.close(); }
		    }

		}
	
	public void rechnungDruckenKunde(Connection con, int kundenID)
		    throws SQLException {

		 Statement stmt = con.createStatement();
		    String query = "SELECT * FROM KUNDE WHERE ID = "+kundenID;
		    System.out.println(query);
		    
		    try {
		        stmt = con.createStatement();
		        ResultSet rs = stmt.executeQuery(query);
		        System.out.println(rs);
		        while(rs.next()) {
		        vorname = rs.getString(2);
		        nachname = rs.getString(3);
		        eMail = rs.getString(4);
		        System.out.println("Kunde:" +vorname+" "+ nachname +" "+ eMail);
		        }
		    } catch (SQLException e ) {
		    	e.printStackTrace();
		    } finally {
		        if (stmt != null) { stmt.close(); }
		    }

		}
	
	public void rechnungDruckenAdresse(Connection con, int kundenID, int heim_Urlaub)
		    throws SQLException {

		 Statement stmt = con.createStatement();
		 	String query = null;
		 	System.out.println();
		 	
		 	if(heim_Urlaub==1) {
			    query = "SELECT * FROM ADRESSE WHERE KUNDEID = "+kundenID+"ORDER BY ART ASC";
		 	}
		 	else{
			    query = "SELECT * FROM ADRESSE WHERE KUNDEID = "+kundenID+"ORDER BY ART DESC";

		 	}

		    System.out.println(query);
		    
		    try {
		        stmt = con.createStatement();
		        ResultSet rs = stmt.executeQuery(query);
		        System.out.println(rs);
		        while(rs.next()) {
		        plz = rs.getInt(2);
		        strasse = rs.getString(3);
		        ort = rs.getString(4);
		        hnr = rs.getString(6);
		        System.out.println("Kunde:" +plz+" "+ strasse +" "+ ort+ "" + hnr);
		        }
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

	public int getRechnungsID() {
		return rechnungsID;
	}

	public double getSummeMitMwst() {
		return summeMitMwst;
	}

	public double getMwst() {
		return mwst;
	}

	public int getKundeID() {
		return kundeID;
	}

	public int getBuchungsID() {
		return buchungsID;
	}

	public double getSumme() {
		return summe;
	}

	public String getAusleihdatum() {
		return ausleihdatum;
	}

	public String getVerkaufsdatum() {
		return verkaufsdatum;
	}

	public ArrayList<IObjektView> getObservers() {
		return observers;
	}

	public int getReparaturID() {
		return reparaturID;
	}

	public String getArt() {
		return art;
	}

	public int getSportgeraetID() {
		return sportgeraetID;
	}

	public int getModellID() {
		return modellID;
	}

	public String getFarbe() {
		return farbe;
	}

	public String getModellname() {
		return modellname;
	}

	public String getVorname() {
		return vorname;
	}

	public int getPlz() {
		return plz;
	}

	public String getStrasse() {
		return strasse;
	}

	public String getOrt() {
		return ort;
	}

	public String getHnr() {
		return hnr;
	}

	public String getNachname() {
		return nachname;
	}

	public String geteMail() {
		return eMail;
	}

}


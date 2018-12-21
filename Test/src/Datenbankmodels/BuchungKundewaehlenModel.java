package Datenbankmodels;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.table.TableModel;

import Domaenklassen.IAdresse;
import Domaenklassen.IKunde;
import Domaenklassen.Kunde;
import GUI.IObjektView;
import net.proteanit.sql.DbUtils;

public class BuchungKundewaehlenModel implements IObjektModel {
	
	private ArrayList<IObjektView> observers = new ArrayList<IObjektView>();

	private ArrayList<Object> mengeAnKunden = new ArrayList<Object>();
	private ArrayList<IAdresse> mengeAnAdressen = new ArrayList<IAdresse>();
	
	private TableModel result;
	
	private int kundeNr = 0;
	private String talking = "master";
	private String search;
	
	
	public void holeDaten(String talking2, String searchtxt) {
			
		this.talking = talking2;
		this. search = searchtxt;
		
		
		
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
	
	
	public void viewTable(Connection con)
		    throws SQLException {

			
		
		    Statement stmt = con.createStatement();
		    String query = "Select * from kunde";
		    
		    if(talking.equals("master") || search.equals(""))
		    	query = "SELECT * FROM KUNDE;";
		    else if(talking.equals("Nachname"))
		    	query = "SELECT * FROM KUNDE WHERE NACHNAME LIKE '%" + search + "%'";
		    else if(talking.equals("Vorname"))
		    	query = "SELECT * FROM KUNDE WHERE VORNAME LIKE '%" + search + "%'";
		    else if(talking.equals("E-Mail"))
		    	query = "SELECT * FROM KUNDE WHERE EMAIL LIKE '%" + search + "%'";
		    else if(talking.equals("PLZ"))
		    	query = "SELECT KUNDEID, PLZ, ORT, STRASSE, ART FROM ADRESSE WHERE PLZ LIKE '%" + search + "%'";
		    else if(talking.equals("Ort"))
		    	query = "SELECT KUNDEID, PLZ, ORT, STRASSE, ART FROM ADRESSE WHERE ORT LIKE '%" + search + "%'";
		    else if(talking.equals("Strasse"))
		    	query = "SELECT KUNDEID, PLZ, ORT, STRASSE, ART FROM ADRESSE WHERE STRASSE LIKE '%" + search + "%'";
		    
		    System.out.println(query);
		    
		    
		    try {
		    	System.out.println(query);
		        stmt = con.createStatement();
		        ResultSet rs = stmt.executeQuery(query);
		        
		        result = DbUtils.resultSetToTableModel(rs);
		        
		    } catch (SQLException e ) {
		    	e.printStackTrace();
		    } finally {
		        if (stmt != null) { stmt.close(); }
		    }
		    
		    
		}

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


	public ArrayList<Object> getObjekte() {
		
		return mengeAnKunden;
	}

	public TableModel getTableModel() {
		
		return result;
	}


	public void erstelleKunde(String knr) throws SQLException {
		try {
       	
			Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "sa");
			// add application code here	
			
			String name = "";
			String vorname = "";
			String email = "";
			boolean surfschein = false;
			boolean motorbootschein = false;
			boolean segelschein = false;
			
			
			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM KUNDE WHERE ID = " + knr;
			ResultSet rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				
				name = rs.getString("NACHNAME");
				vorname = rs.getString("VORNAME");
				email = rs.getString("EMAIL");
				if(rs.getString("SURFSCHEIN").equals("J"))
					surfschein = true;
				if(rs.getString("SEGELSCHEIN").equals("J"))
					segelschein = true;
				if(rs.getString("MOTORBOOTSCHEIN").equals("J"))
					motorbootschein = true;
			}
			
			
			System.out.println("" +name+ vorname+ email+ surfschein+ segelschein+ motorbootschein);
			
			IKunde kunde = new Kunde(name, vorname, email, surfschein, segelschein, motorbootschein);
			mengeAnKunden.add(kunde);
			mengeAnKunden.set(0, kunde);
			
			conn.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	       	updateObserver();
			}
	
}

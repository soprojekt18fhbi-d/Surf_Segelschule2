package Datenbankmodels;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.DefaultListModel;

import Domaenklassen.GeraeteModell;
import Domaenklassen.GeraeteTyp;
import GUI.IObjektView;


/**
 * @author michi
 *
 */
public class ModellAnzeigeModel implements IObjektModel{
	
	private ArrayList<IObjektView> observers = new ArrayList<IObjektView>();
	private ArrayList<GeraeteModell> mengeAnModellen = new ArrayList<GeraeteModell>();
	private int modellNr = 0;

	@Override
	public void anmelden(IObjektView view) {
		try {
			observers.add(view);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		try {
			if(observers.contains(view));
				observers.remove(view);
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


	
	public void holeModelle() {

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
		    Statement stmt2 = null;
		    String query = "select * from MODELL";
		    try {
		        stmt = con.createStatement();
		        ResultSet rs = stmt.executeQuery(query);
		        while (rs.next()) {
		        	
		        	modellNr = modellNr++;
		        	int modellID = Integer.parseInt(rs.getString("MODELLID"));
		        	String name =  rs.getString("MODELLNAME"); 
		        	int preisID = Integer.parseInt(rs.getString("VERLEIHPREISID"));
		        	int typID = Integer.parseInt(rs.getString("TYPID"));
		        	
		        	 
		        	String query2 = "select * from TYP WHERE TYPID = " +typID;
		        	stmt2 = con.createStatement();
			        ResultSet rs2 = stmt2.executeQuery(query2);
			        
			        while (rs2.next()) {
			        	String typ =  rs2.getString("NAME");
			        	String führerschein = rs2.getString("FUEHRERSCHEIN");
				        
				        
				        GeraeteModell modellNr  = new GeraeteModell(typID, typ, führerschein, name, modellID, preisID);
			        	mengeAnModellen.add(modellNr);
			        }
		        }

		    } catch (SQLException e ) {
		    	e.printStackTrace();
		    } finally {
		        if (stmt != null) { stmt.close(); }
		    }

		}
	

	
	public DefaultListModel getObjekte(){
		
		DefaultListModel<String> listmodel = new DefaultListModel<String>();
	
		for(int i = 0; i < mengeAnModellen.size(); i++) {
			listmodel.addElement(mengeAnModellen.get(i).getModellID()+ ", "+ mengeAnModellen.get(i).getModellName() + ", Preiskategorie:" + mengeAnModellen.get(i).getKosten() );
		}
		return listmodel;

	}	
	/* Datenbank
		create table MODELL(
		MODELLID int (6) not null,
		MODELLNAME varchar (50) not null,
		TYPID int(2) not null,
		VERLEIHPREISID int (2) not null,
		constraint pk_modell primary key (MODELLID),
		constraint fk_modell_typ foreign key (TYPID)
		references TYP(TYPID));
		
		insert into modell
		values (10101, 'COSTWAY Surfbrett Surfboard Stand up', 10, 1),
		(10102, 'Bestway HYDRO-FORCE iSUP Oceana', 10, 1),
		(20101, 'Segelboot Leisure 17', 20, 2),
		(30101, 'ZRAY Nassau 13,4" Professional Kajak 2 Personen', 30, 3);
	 * 
	 * 
	 */
}


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
		    String query = "select * from MODELL";
		    try {
		        stmt = con.createStatement();
		        ResultSet rs = stmt.executeQuery(query);
		        while (rs.next()) {
		        	
		        	modellNr = modellNr++;
		        	String id = rs.getString("MODELLID");
		        	String name =  rs.getString("NAME"); 
		        	//double verleihpreis = rs.getDouble("VERLEIHPREIS"); 
		        	
		        	GeraeteModell modellNr  = new GeraeteModell(name, id);
		        	mengeAnModellen.add(modellNr);
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
			listmodel.addElement(mengeAnModellen.get(i).getModellName() + ", " + mengeAnModellen.get(i).getModellID() );
		}
		return listmodel;

	}	
	
	/* Datenbank
		create table MODELL(
		NAME varchar (50) not null,
		MODELLID int (6) not null,
		VERLEIHPREIS double (7) not null,
		TYPID int(2) not null,
		constraint pk_modell primary key (MODELLID),
		constraint fk_modell_typ foreign key (TYPID)
		references TYP(TYPID));
		
		insert into modell
		values ('COSTWAY Surfbrett Surfboard Stand up', 10101, 29.99, 10),
		('Bestway HYDRO-FORCE iSUP Oceana', 10102, 69.99, 10),
		('Segelboot Leisure 17', 20101, 299.99, 20),
		('ZRAY Nassau 13,4" Professional Kajak 2 Personen', 30101, 49.99, 30);
	 * 
	 * 
	 * 
	 * 
	 * 
	 */

}

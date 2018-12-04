/**package Datenbankmodels;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.DefaultListModel;

import Domaenklassen.Geraet;
import Domaenklassen.GeraeteTyp;
import GUI.IObjektView;


/**
 * @author michi
 *
 *
public class GeraetAnzeigeModel implements IObjektModel{
	
	private ArrayList<IObjektView> observers = new ArrayList<IObjektView>();
	private ArrayList<Geraet> mengeAnGeraeten = new ArrayList<Geraet>();
	private int geraetNr = 0;

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


	
	public void holeGeraete() {

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
		    String query = "select * from GERAET";
		    try {
		        stmt = con.createStatement();
		        ResultSet rs = stmt.executeQuery(query);
		        while (rs.next()) {
		        	
		        	geraetNr = geraetNr++;
		        	String id = rs.getString("GERAETEID");
		        	String name =  rs.getString("NAME");       
		        	Geraet geraetNr  = new Geraet(name, id);
		        	mengeAnGeraeten.add(geraetNr);
		        }

		    } catch (SQLException e ) {
		    	e.printStackTrace();
		    } finally {
		        if (stmt != null) { stmt.close(); }
		    }

		}
	

	
	public DefaultListModel getObjekte(){
		
		DefaultListModel<String> listmodel = new DefaultListModel<String>();
	
		for(int i = 0; i < mengeAnGeraeten.size(); i++) {
			listmodel.addElement(mengeAnGeraeten.get(i).getGeraeteName() + ", " + mengeAnGeraeten.get(i).getGeraeteID() );
		}
		return listmodel;

	}
	**/
	
	/*
	 * 	create table GERAET(
		NAME varchar (50) not null,
		GERAETEID int (9) not null,
		MODELLID int(6) not null,
		constraint pk_geraet primary key (GERAETEID),
		constraint fk_geraet_modell foreign key (MODELLID)
		references MODELL(MODELLID));
		
		insert into GERAET
		values ('COSTWAY Surfbrett Surfboard Stand up', 10101101, 10101),
		('COSTWAY Surfbrett Surfboard Stand up', 10101102, 10101),
		('Bestway HYDRO-FORCE iSUP Oceana', 10102101, 10102),
		('Segelboot Leisure 17', 20101101, 20101),
		('ZRAY Nassau 13,4" Professional Kajak 2 Personen', 30101101, 30101);
		
	 */



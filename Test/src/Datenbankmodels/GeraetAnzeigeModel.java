package Datenbankmodels;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.DefaultListModel;

import Domaenklassen.SportGeraet;
import Domaenklassen.GeraeteTyp;
import GUI.IObjektView;


/**
 * @author michi
 *
 */
public class GeraetAnzeigeModel implements IObjektModel{
	
	private ArrayList<IObjektView> observers = new ArrayList<IObjektView>();
	private ArrayList<SportGeraet> mengeAnGeraeten = new ArrayList<SportGeraet>();
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
		    Statement stmt2 = null;
		    Statement stmt3 = null;
		    String query = "select * from SPORTGERAET";
		    try {
		        stmt = con.createStatement();
		        ResultSet rs = stmt.executeQuery(query);
		        while (rs.next()) {
		        	
		        	geraetNr = geraetNr++;
		        	int geraeteÍD = Integer.parseInt(rs.getString("GERAETEID"));
		        	String farbe = rs.getString("FARBE");
		        	double verkaufspreis = Double.parseDouble(rs.getString("VERKAUFSPREIS"));
		        	double anschaffungspreis = Double.parseDouble(rs.getString("ANSCHAFFUNGSPREIS"));
		        	int status = Integer.parseInt(rs.getString("STATUS"));
		        	String makel = rs.getString("MAKEL");
		        	int modellID = Integer.parseInt(rs.getString("MODELLID"));
		        	
		        	
		        	
		        	String query2 = "select * from MODELL WHERE MODELLID = " +modellID;
		        	stmt2 = con.createStatement();
			        ResultSet rs2 = stmt2.executeQuery(query2);
			        
			        while (rs2.next()) {
				        String name =  rs2.getString("MODELLNAME"); 
			        	int preisID = Integer.parseInt(rs2.getString("VERLEIHPREISID"));
			        	int typID = Integer.parseInt(rs2.getString("TYPID"));
			        	
			        	String query3 = "select * from TYP WHERE typID = " +typID;
			        	stmt3 = con.createStatement();
				        ResultSet rs3 = stmt3.executeQuery(query3);
				        
				        while (rs3.next()) {
					        String typ =  rs3.getString("NAME");
				        	String führerschein = rs3.getString("FUEHRERSCHEIN");      	
				        			        	
				        	SportGeraet geraetNr  = new SportGeraet(typID, typ, führerschein, name, modellID, preisID, geraeteÍD, farbe, verkaufspreis, anschaffungspreis, status, makel);
				        	mengeAnGeraeten.add(geraetNr);
				        }
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
	
		for(int i = 0; i < mengeAnGeraeten.size(); i++) {
			listmodel.addElement(mengeAnGeraeten.get(i).getGeraeteID() + ", " + mengeAnGeraeten.get(i).getModellName() + ", " + mengeAnGeraeten.get(i).getFarbe() + ", Verkaufspreis: " + mengeAnGeraeten.get(i).getVerkaufsPreis() + "€, Status: " + mengeAnGeraeten.get(i).getStatus());
		}
		return listmodel;

	}
	
	
	/*
	 * 	create table SPORTGERAET(
		GERAETEID int (9) not null,
		FARBE varchar(20) not null,
		STATUS int(1) not null,
		VERKAUFSPREIS numeric (8,2) not null,
		ANSCHAFFUNGSPREIS numeric (8,2) not null,
		MODELLID int(6) not null,
		Makel varchar(255),
		constraint pk_geraet primary key (GERAETEID),
		constraint fk_geraet_modell foreign key (MODELLID)
		references MODELL(MODELLID));
		
		insert into SPORTGERAET
		values (10101101,'blau', 1, 129.99, 109.99, 10101, null),
		(10101102, 'rot', 0, 119.99, 5.99,  10101, 'Kratzer'),
		(10102101,'weiss', 1, 99.99, 89.99, 10102, null),
		(20101101,'weiss', 2, 449.99, 12.99, 20101, null),
		(30101101, 'gelb', 0, 1129.99, 800.01, 30101, 'Lackierung blättert ab');
		
	 */

}

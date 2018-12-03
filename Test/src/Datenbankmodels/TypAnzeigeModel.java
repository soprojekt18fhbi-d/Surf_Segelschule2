package Datenbankmodels;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.DefaultListModel;

import Domaenklassen.GeraeteTyp;
import GUI.IObjektView;
import GUI.IView;

/**
 * @author michi
 *
 */
public class TypAnzeigeModel implements IObjektModel{
	
	private ArrayList<IObjektView> observers = new ArrayList<IObjektView>();
	private ArrayList<GeraeteTyp> mengeAnTypen = new ArrayList<GeraeteTyp>();
	private int typNr = 0;

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


	
	public void holeTypen() {

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
		    String query = "select * from TYP";
		    try {
		        stmt = con.createStatement();
		        ResultSet rs = stmt.executeQuery(query);
		        while (rs.next()) {
		        	
		        	typNr = typNr++;
		        	String id = rs.getString("TYPID");
		        	String name =  rs.getString("NAME");       
		        	GeraeteTyp typNr  = new GeraeteTyp(name, id);
		        	mengeAnTypen.add(typNr);
		        }

		    } catch (SQLException e ) {
		    	e.printStackTrace();
		    } finally {
		        if (stmt != null) { stmt.close(); }
		    }

		}
	

	
	public DefaultListModel getObjekte(){
		
		DefaultListModel<String> listmodel = new DefaultListModel<String>();
	
		for(int i = 0; i < mengeAnTypen.size(); i++) {
			listmodel.addElement(mengeAnTypen.get(i).getTypName() + ", " + mengeAnTypen.get(i).getTypID() );
		}
		return listmodel;

	}	
	
	/*
	 * 
	 * Datenbank
		create table TYP(
		NAME varchar (20) not null,
		TYPID int (3) not null,
		FUEHRERSCHEIN varchar (20),
		constraint pk_typ primary key (TYPID));
		
		
		insert into TYP
		values ('Surfboard', 10, null),
		('Segelboot', 20, 'Segelschein'),
		('Kajak', 30, null),
		('Jetski', 40, 'Bootschein'),
		('Motorboot', 50, 'Bootschein'),
	 */
	
}


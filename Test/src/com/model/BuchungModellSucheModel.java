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
import com.view.IObjektView;

import net.proteanit.sql.DbUtils;

public class BuchungModellSucheModel implements IObjektModel{ //Ben Kröncke
	
	private ArrayList<IObjektView> observers = new ArrayList<IObjektView>();
	private ArrayList<GeraeteModell> mengeAnModellen = new ArrayList<GeraeteModell>();
	private TableModel table;
	private int modellNr = 0;
	private int typNr;
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


	
	public void holeModelle(String talking2, int typNr2, String search) {

		talking = talking2;
		typNr = typNr2;
		this.search = search;
		
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
	
	public void viewTable(Connection con)
	    throws SQLException {

	    Statement stmtBuchungModellSucheModel = null;
		String query = "select * from MODELL";
		   
	    if(talking.equals("master"))
	    	query = "select * from MODELL where TYPID = '" + typNr + "'";
	    if(talking.equals("gesamt"))
	    	query = "select * from MODELL";
		if(talking.equals("search"))
		    query = "select * from Modell where TYPID = '" + typNr + "' AND NAME LIKE '" + search + "%'";
		if(talking.equals("suchen"))
			query = "select * from Modell WHERE ID LIKE '"+search+"%' OR NAME LIKE '"+search+"%' OR TYPID LIKE '"+search+"%' OR PREISLISTEID LIKE '"+search+"%'";
		try {
			stmtBuchungModellSucheModel = con.createStatement();

			System.out.println(query);
				
			ResultSet rs = stmtBuchungModellSucheModel.executeQuery(query);
			table = DbUtils.resultSetToTableModel(rs);

		} catch (SQLException e ) {
			e.printStackTrace();
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


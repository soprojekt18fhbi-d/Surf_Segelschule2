/*
 *  @author Michael Schmidt
 */

package com.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.view.IAnlegenView;

public class ModellAnlegenModel implements IAnlegenModel {

	private ArrayList<IAnlegenView> observers = new ArrayList<IAnlegenView>();
	private ArrayList<String> mengeAnTypen = new ArrayList<String>();
	private String talking = "first";
	private String[] modell;
	private String name;
	private String typ;
	private int preis;
	private int id;
	private Statement stmtModellHinzufuegenModel;
	private Statement stmtModellHinzufuegenModel2;
	private String query;
	private ResultSet rs;

	public void anfrage(String talking2, String[] modell) {

		this.talking = talking2;
		this.modell = modell;

		try {
			Connection conn = DBConnectorSingleton.getCon();
			// add application code here
			viewTable(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void viewTable(Connection con) throws SQLException {

		stmtModellHinzufuegenModel = con.createStatement();
		stmtModellHinzufuegenModel2 = con.createStatement();	
		
		try {
			if (talking.equals("first"))
				holeTypnamen();					
			if (talking.equals("second"))
				holePreisID();
			if (talking.equals("hinzufuegen")) 
				modellAnlegen();
			if (talking.equals("aendern")) 
				modellAendern();	
			if (talking.equals("typname"))
				holeTyp();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmtModellHinzufuegenModel != null) {
				stmtModellHinzufuegenModel.close();
			}
			if (stmtModellHinzufuegenModel != null) {
				stmtModellHinzufuegenModel.close();
			}
		}
		updateObserver();
	}

	//Metohode holt bestimmten Typnamen, abhägig von der TypID
	private void holeTyp() throws SQLException {
		werteUebergeben();
		query = "Select * from TYP WHERE ID = '" + id + "'";
		System.out.println(query);
		rs = stmtModellHinzufuegenModel.executeQuery(query);
		while (rs.next()) {
			mengeAnTypen.add(rs.getString("NAME"));
		}
	}
	
	//Metohode zum Aendern eines Modells in der Datenbank
	private void modellAendern() throws SQLException {
		werteUebergeben();

		query = "select * from TYP WHERE NAME = '" + typ + "'";
		rs = stmtModellHinzufuegenModel.executeQuery(query);
		while (rs.next()) {
			int typID = Integer.parseInt(rs.getString("ID"));
			String sqlupdate = "UPDATE MODELL SET NAME = '" + name + "', TYPID = '" + typID
					+ "' , PREISLISTEID = '" + preis + "' WHERE ID = " + id + "";
			stmtModellHinzufuegenModel2.executeUpdate(sqlupdate);
		}
	}

	//Metohode zum Anlegen eines Modells in der Datenbank, Vergleich mit TypID
	private void modellAnlegen() throws SQLException {
		werteUebergeben();

		query = "select * from TYP WHERE NAME = '" + typ + "'";
		System.out.println(query);
		rs = stmtModellHinzufuegenModel.executeQuery(query);

		while (rs.next()) {
			int typID = Integer.parseInt(rs.getString("ID"));
			String sqlupdate = "INSERT INTO MODELL VALUES (default,'" + name + "','" + typID + "','" + preis
					+ "')";
			System.out.println(sqlupdate);
			stmtModellHinzufuegenModel2.executeUpdate(sqlupdate);
		}
	}

	//Methode holt PreisIDs zum Füllen der Comboboxen (bei ModellAnlegen, ModellAendern)
	private void holePreisID() throws SQLException {
		query = "Select * from PREISLISTE";
		System.out.println(query);
		rs = stmtModellHinzufuegenModel.executeQuery(query);
		while (rs.next()) {
			mengeAnTypen.add(rs.getString("ID"));
		}
	}
	
	//Methode holt alle Typnamen zum Füllen der Comboboxen (bei ModellAnlegen, ModellAendern)
	private void holeTypnamen() throws SQLException {
		query = "Select * from TYP";
		System.out.println(query);
		rs = stmtModellHinzufuegenModel.executeQuery(query);
		while (rs.next()) {
			mengeAnTypen.add(rs.getString("NAME"));
		}
	}

	private void werteUebergeben() {
		name = modell[0];
		typ = modell[1];
		preis = Integer.parseInt(modell[2]);
		id = Integer.parseInt(modell[3]);
	}

	@Override
	public void anmelden(IAnlegenView view) {
		// TODO Auto-generated method stub
		try {
			observers.add(view);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void abmelden(IAnlegenView view) {
		// TODO Auto-generated method stub
		try {
			if (observers.contains(view))
				;
			observers.remove(view);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateObserver() {
		// TODO Auto-generated method stub
		try {
			for (int i = 0; i < observers.size(); ++i)
				observers.get(i).aktualisieren(this);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<String> getObertypen() {
		// TODO Auto-generated method stub
		return mengeAnTypen;
	}
}

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

public class GeraetAnlegenModel implements IAnlegenModel {

	private ArrayList<IAnlegenView> observers = new ArrayList<IAnlegenView>();

	private ArrayList<String> mengeAnModellen = new ArrayList<String>();
	private ArrayList<String> mengeAnTypen = new ArrayList<String>();
	private String talking = "first";
	private String[] geraet;
	private int standortID;
	private String typ;
	private String modell;
	private String makel;
	private double verkaufspreis;
	private double anschaffungspreis;
	private String farbe;
	private int baujahr;
	private Statement stmtGeraetAnlegenModel;
	private Statement stmtGeraetAnlegenModel2;
	private Statement stmtGeraetAnlegenModel3;
	private String query;
	private String query2;
	private ResultSet rs;
	private ResultSet rs2;

	public void anfrage(String talking2, String[] geraet) {
		this.talking = talking2;
		this.geraet = geraet;

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

		stmtGeraetAnlegenModel = con.createStatement();
		stmtGeraetAnlegenModel2 = con.createStatement();
		stmtGeraetAnlegenModel3 = con.createStatement();
		
		try {
			if (talking.equals("first")) 
				holeTypnamen();
			if (talking.equals("second"))
				holeModellVonTyp();
			if (talking.equals("modellname"))
				holeModellnamen();
			if (talking.equals("standortID"))
				holeStandortID();
			if (talking.equals("hinzufuegen"))
				geraetAnlegen();
			if (talking.equals("aendern")) 
				geraetAendern();
			if (talking.equals("status")) 
				statusAendern();
			if (talking.equals("reparatur")) 
				reparaturAnlegen();						
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			if (stmtGeraetAnlegenModel2 != null) {
				stmtGeraetAnlegenModel2.close();
			}
			if (stmtGeraetAnlegenModel != null) {
				stmtGeraetAnlegenModel.close();
			}
			if (stmtGeraetAnlegenModel3 != null) {
				stmtGeraetAnlegenModel3.close();
			}
		}
		updateObserver();
	}	

	//Methode die alle Modelle eines ausgewählten Typens holt
	private void holeModellVonTyp() throws SQLException {
		String typ = geraet[0];

		query = "Select * from TYP WHERE NAME = '" + typ + "'";
		rs = stmtGeraetAnlegenModel.executeQuery(query);

		while (rs.next()) {
			int typID = Integer.parseInt(rs.getString("ID"));

			query2 = "select * from MODELL WHERE TYPID = '" + typID + "'";
			rs2 = stmtGeraetAnlegenModel2.executeQuery(query2);
			while (rs2.next()) {
				mengeAnModellen.add(rs2.getString("NAME"));
			}
		}
	}
	
	//Methode die eine Reparatur in der Datenbank anlegt
	private void reparaturAnlegen() throws SQLException {
		int geraeteID = Integer.parseInt(geraet[1]);
		String beschreibung = geraet[2];
		double kosten = Double.parseDouble(geraet[3]);
		String sqlupdate = "INSERT INTO REPARATUR VALUES(default,'" + beschreibung + "','" + kosten + "','"
				+ geraeteID + "')";
		stmtGeraetAnlegenModel.executeUpdate(sqlupdate);
	}

	//Methode die den Status eines Sportgerätes ändert
	private void statusAendern() throws SQLException {
		int geraeteID = Integer.parseInt(geraet[0]);
		String status = geraet[1];
		String sqlupdate = "UPDATE SPORTGERAET SET STATUS = '" + status + "'  WHERE ID = " + geraeteID + "";
		stmtGeraetAnlegenModel.executeUpdate(sqlupdate);
	}

	//Methode die die Werte eines bereits angelegten Sportgerätes ändert
	private void geraetAendern() throws SQLException {
		werteUebergeben();
		int modellID = Integer.parseInt(typ);
		int standortID = Integer.parseInt(modell);
		String sqlupdate = "UPDATE SPORTGERAET SET MAKEL = '" + makel + "', FARBE = '" + farbe
				+ "' , BAUJAHR = '" + baujahr + "', STANDORTID = '" + standortID + "', VERKAUFSPREIS = '"
				+ verkaufspreis + "', ANSCHAFFUNGSPREIS = '" + anschaffungspreis + "'  WHERE ID = " + modellID
				+ "";
		stmtGeraetAnlegenModel.executeUpdate(sqlupdate);
	}

	//Methode die ein Sportgerät anlegt
	private void geraetAnlegen() throws SQLException {
		werteUebergeben();
		String status = "OK";

		query = "select * from TYP WHERE NAME = '" + typ + "'";
		System.out.println(query);
		query2 = "select * from MODELL WHERE NAME = '" + modell + "'";
		rs = stmtGeraetAnlegenModel.executeQuery(query);

		while (rs.next()) {
			int typID = Integer.parseInt(rs.getString("ID"));
			rs2 = stmtGeraetAnlegenModel2.executeQuery(query2);

			while (rs2.next()) {
				int modellID = Integer.parseInt(rs2.getString("ID"));

				String sqlupdate = "INSERT INTO SPORTGERAET VALUES (default,'" + makel + "','" + verkaufspreis
						+ "','" + typID + "','" + modellID + "','" + status + "','" + standortID + "','" + farbe
						+ "','" + baujahr + "','" + anschaffungspreis + "')";
				System.out.println(sqlupdate);
				stmtGeraetAnlegenModel3.executeUpdate(sqlupdate);
			}
		}
	}

	//Methode die einen bestimmten Modellnamen aus der Datenabnk holt (abhängig von ModellID)
	private void holeModellnamen() throws SQLException {
		int modellID = Integer.parseInt(geraet[6]);
		query = "Select * from MODELL WHERE ID = '" + modellID + "'";
		System.out.println(query);
		rs = stmtGeraetAnlegenModel.executeQuery(query);
		while (rs.next()) {
			mengeAnTypen.add(rs.getString("NAME"));
		}
	}

	//Methode holt StandortIDs zum Füllen der Comboboxen (bei GeraetAnlegen, GeraetAendern)
	private void holeStandortID() throws SQLException {
		query = "Select * from STANDORT";
		System.out.println(query);
		rs = stmtGeraetAnlegenModel.executeQuery(query);
		while (rs.next()) {
			mengeAnTypen.add(rs.getString("ID"));
		}
	}

	//Methode holt Typnamen zum Füllen der Comboboxen (bei GeraetAnlegen, GeraetAendern)
	private void holeTypnamen() throws SQLException {
		query = "Select * from TYP";
		System.out.println(query);
		rs = stmtGeraetAnlegenModel.executeQuery(query);
		while (rs.next()) {
			mengeAnTypen.add(rs.getString("NAME"));
		}
	}

	private void werteUebergeben() {
		typ = geraet[0];
		modell = geraet[1];
		makel = geraet[2];
		verkaufspreis = Double.parseDouble(geraet[3]);
		anschaffungspreis = Double.parseDouble(geraet[4]);
		farbe = geraet[5];
		baujahr = Integer.parseInt(geraet[6]);
	}

	@Override
	public void anmelden(IAnlegenView view) {
		try {
			observers.add(view);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
	public void abmelden(IAnlegenView view) {
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
		if (talking == "first")
			return mengeAnTypen;
		else if (talking == "standortID")
			return mengeAnTypen;
		else if (talking == "modellname")
			return mengeAnTypen;
		else
			return mengeAnModellen;
	}

	public void setStandort(int id) {
		standortID = id;
	}

}
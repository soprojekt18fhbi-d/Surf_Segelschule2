package Datenbankmodels;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.table.TableModel;

import Domaenklassen.IKunde;
import GUI.IObjektView;
import net.proteanit.sql.DbUtils;

public class BuchungAnzeigeModel implements IObjektModel { //Ben Kröncke

	private ArrayList<IObjektView> observers = new ArrayList<IObjektView>();
	private TableModel table;
	private String talking;
	private String search;
	private String mode;
	private int kNr;
	private int geraetNrloc;
	private int buchungID = 0;
	private String makel = "";
	
	
	public void holeBuchung(String talking2, int buchungID2, int kNr2, int geraetNr, String search2, String mode2, String makel2) {

		setVars(talking2, buchungID2, kNr2, geraetNr, search2, mode2, makel2);
		
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

		
				Statement stmtBuchungAnzeigeModel = null;
				String query = null;
				String update = null;
				
				String pattern = "yyyy-MM-dd' 'HH:mm:ss";
				String date = new SimpleDateFormat(pattern).format(new Date());

			try {
				
				stmtBuchungAnzeigeModel = con.createStatement();
				if(mode.equals("Verleih"))
				{
					if(talking.equals("master"))
					{
						alleVerleihe(stmtBuchungAnzeigeModel);
					}
					if(talking.equals("search"))
					{
						searchVerleihe(stmtBuchungAnzeigeModel);
					}
					if(talking.equals("rckButton"))
					{
						vollendeAusleihe(stmtBuchungAnzeigeModel, date);
					}
					if(talking.equals("stornButton"))
					{
						storniereBuchung(stmtBuchungAnzeigeModel);
					}
				}
				if(mode.equals("Verkauf"))
				{
					if(talking.equals("master"))
					{
						holeVerkaeufe(stmtBuchungAnzeigeModel);
					}
					if(talking.equals("search"))
					{
						sucheVerkaeufe(stmtBuchungAnzeigeModel);
					}
					if(talking.equals("rckButton"))
					{
						erstelleRechnungVerkauf(stmtBuchungAnzeigeModel);
					}
					if(talking.equals("stornButton"))
					{
						storniereBuchung(stmtBuchungAnzeigeModel);
					}
				}
				
				

			} catch (SQLException e ) {
				e.printStackTrace();
			}

		}


	private void erstelleRechnungVerkauf(Statement stmt) throws SQLException {
		String query;
		String update;
		double verkaufspreis = 0;
		query = "SELECT VERKAUFSPREIS FROM SPORTGERAET WHERE ID = " + geraetNrloc;
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next())
		{
			verkaufspreis = rs.getDouble("VERKAUFSPREIS");
		}
		update = "INSERT INTO RECHNUNG VALUES( default, " + (verkaufspreis/1.19) + ", " + (verkaufspreis/119)*19 + ", " + verkaufspreis + ", " + kNr + ", null, " + buchungID + ")";
		System.out.println(update);
		stmt.executeUpdate(update);
		update = "UPDATE BUCHUNG SET ART = 'Abgewickelter Verkauf' WHERE ID = " + buchungID;
		stmt.executeUpdate(update);
	}


	private void vollendeAusleihe(Statement stmt, String date) throws SQLException {
		String update;
		update = "UPDATE BUCHUNG SET RÜCKGABEDATUM = '" + date + "' WHERE ID = " + buchungID;
		System.out.println(update);
		stmt.executeUpdate(update);
		update = "UPDATE SPORTGERAET SET STATUS = 'OK', MAKEL = '" + makel + "' WHERE ID = " + geraetNrloc;
		System.out.println(update);
		stmt.executeUpdate(update);
	}


	private void storniereBuchung(Statement stmt) throws SQLException {
		String update;
		update = "DELETE FROM BUCHUNG WHERE ID = " + buchungID;
		System.out.println(update);
		stmt.executeUpdate(update);
		update = "UPDATE SPORTGERAET SET STATUS = 'OK' WHERE ID = " + geraetNrloc;
		System.out.println(update);
		stmt.executeUpdate(update);
	}


	private void sucheVerkaeufe(Statement stmt) throws SQLException {
		String query;
		query = "SELECT ID,KUNDEID,SPORTGERAETID,VERKAUFSDATUM FROM BUCHUNG WHERE ART = 'Verkauf' AND VERKAUFSDATUM LIKE '%" + search + "%'";
		ResultSet rs = stmt.executeQuery(query);
		table = DbUtils.resultSetToTableModel(rs);
	}


	private void holeVerkaeufe(Statement stmt) throws SQLException {
		String query;
		query = "SELECT ID,KUNDEID,SPORTGERAETID,VERKAUFSDATUM FROM BUCHUNG WHERE ART = 'Verkauf' ORDER BY VERKAUFSDATUM DESC";
		ResultSet rs = stmt.executeQuery(query);
		table = DbUtils.resultSetToTableModel(rs);
	}


	private void searchVerleihe(Statement stmt) throws SQLException {
		String query;
		query = "SELECT ID,KUNDEID,SPORTGERAETID,AUSLEIHDATUM,RÜCKGABEDATUM FROM BUCHUNG WHERE ART = 'Verleih' AND AUSLEIHDATUM LIKE '%" + search + "%'";
		System.out.println(query);
		ResultSet rs = stmt.executeQuery(query);
		table = DbUtils.resultSetToTableModel(rs);
	}


	private void alleVerleihe(Statement stmt) throws SQLException {
		String query;
		query = "SELECT ID,KUNDEID,SPORTGERAETID,AUSLEIHDATUM,RÜCKGABEDATUM FROM BUCHUNG WHERE ART = 'Verleih' AND RÜCKGABEDATUM IS NULL ORDER BY AUSLEIHDATUM DESC";
		System.out.println(query);
		ResultSet rs = stmt.executeQuery(query);
		table = DbUtils.resultSetToTableModel(rs);
	}
	



	private void setVars(String talking2, int buchungID2, int kNr2, int geraetNr, String search2, String mode2, String makel2) {
		talking = talking2;
		kNr = kNr2;
		geraetNrloc = geraetNr;
		search = search2;
		mode = mode2;
		buchungID = buchungID2;
		if (makel2.equals(""))
			makel = "Kein";
		else
			makel = makel2;
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
		// TODO Auto-generated method stub
		return null;
	}

	public TableModel getTableModel() {
		// TODO Auto-generated method stub
		return table;
	}

}

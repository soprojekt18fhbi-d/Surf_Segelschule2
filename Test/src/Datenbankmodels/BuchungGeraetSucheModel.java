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

import Domaenklassen.GeraeteModell;
import Domaenklassen.IKunde;
import GUI.IObjektView;
import net.proteanit.sql.DbUtils;

public class BuchungGeraetSucheModel implements IObjektModel { //@author Ben Kröncke
	
	private ArrayList<IObjektView> observers = new ArrayList<IObjektView>();
	private TableModel table;
	private int modellNr;
	private int typNr;
	private String talking;
	private String search;
	private int kNr;
	private IKunde kunde;
	private int geraetNrloc;
	private int buchungID = 0;
	private int standort = 0;
	
	public void holeGeraete(String talking2, int modellNr2, int kNr2, int geraetNr, int standort2) {

		talking = talking2;
		kNr = kNr2;
		modellNr = modellNr2;
		geraetNrloc = geraetNr;
		standort = standort2;
		
		System.out.println(talking);
		
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

		
				Statement stmtBuchungGeraetSucheModel = null;
				String query = "select ID,MAKEL,VERKAUFSPREIS, FARBE from SPORTGERAET where MODELLID = '" + modellNr + "' AND STATUS = 'OK' AND STANDORTID = " + standort;
				String update = null;
				
				String pattern = "yyyy-MM-dd' 'HH:mm:ss";
				String date = new SimpleDateFormat(pattern).format(new Date());

			try {
				
				stmtBuchungGeraetSucheModel = con.createStatement();

				if(talking.equals("Verleih"))
				{
					
					erfasseVerleih(stmtBuchungGeraetSucheModel, date);
				}
				if(talking.equals("Verkauf"))
				{
					erfasseVerkauf(stmtBuchungGeraetSucheModel, query, date);
				}
				
				erzeugeGeraetTabelle(stmtBuchungGeraetSucheModel);

			} catch (SQLException e ) {
				e.printStackTrace();
			}


		}

	private void erzeugeGeraetTabelle(Statement stmt) throws SQLException {
		String query;
		
		//Die Sucheingabe wurde als "modellNr" übergeben, damit methode nicht mehr verändert werden muss!
		String textEingabe = talking;
			query = "select ID,MAKEL,VERKAUFSPREIS, FARBE from SPORTGERAET where MODELLID = '" + modellNr + "' AND STATUS = 'OK' AND STANDORTID = " + standort;
		if (talking.equals("gesamt"))
			query = "select * from SPORTGERAET";
		if (modellNr == 123456789)
			query = "select * from SPORTGERAET WHERE ID LIKE '"+textEingabe+"%' OR MAKEL LIKE '"+textEingabe+"%' OR TYPID LIKE '"+textEingabe+"%' OR MODELLID LIKE '"+textEingabe+"%' OR STATUS LIKE '"+textEingabe+"%' OR FARBE LIKE '"+textEingabe+"%' OR BAUJAHR LIKE '"+textEingabe+"%' OR VERKAUFSPREIS LIKE '"+textEingabe+"%' OR ANSCHAFFUNGSPREIS LIKE '"+textEingabe+"%'" ;
		System.out.println(query);
			
		ResultSet rs = stmt.executeQuery(query);
		table = DbUtils.resultSetToTableModel(rs);	//abgefragets ResultSet wird umgewandelt in ein TableModel und hier in der Variable table gespeichert  
	}

	private void erfasseVerkauf(Statement stmt, String query, String date) throws SQLException {
		String update;
		update = "INSERT INTO BUCHUNG VALUES(default, null, null, '" + kNr + "', '" + date + "', 'Verkauf', " + geraetNrloc + ")";
		int ergebnis = stmt.executeUpdate(update);
		update = "UPDATE SPORTGERAET SET STATUS = 'Verkauft' WHERE ID = " + geraetNrloc;
		System.out.println(query);
		stmt.executeUpdate(update);
		update = "UPDATE KUNDE SET BESTANDSKUNDE = 'J' WHERE ID = " + kNr;
		System.out.println(update);
		stmt.executeUpdate(update);
	}

	private void erfasseVerleih(Statement stmt, String date) throws SQLException {
		String update;
		update = "INSERT INTO BUCHUNG VALUES(default, '" + date + "', null, '" + kNr + "', null, 'Verleih', " + geraetNrloc +")";
		int ergebnis = stmt.executeUpdate(update);
		update = "UPDATE SPORTGERAET SET STATUS = 'Verliehen' WHERE ID = " + geraetNrloc;
		stmt.executeUpdate(update);
		update = "UPDATE KUNDE SET BESTANDSKUNDE = 'J' WHERE ID = " + kNr;
		System.out.println(update);
		stmt.executeUpdate(update);
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

	public int getModellNr() {
		return modellNr;
	}

	public void setModellNr(int modellNr) {
		this.modellNr = modellNr;
	}

	public int getkNr() {
		return kNr;
	}

	public void setkNr(int kNr) {
		this.kNr = kNr;
	}

	public IKunde getKunde() {
		return kunde;
	}

	public void setKunde(IKunde kunde) {
		this.kunde = kunde;
	}

}

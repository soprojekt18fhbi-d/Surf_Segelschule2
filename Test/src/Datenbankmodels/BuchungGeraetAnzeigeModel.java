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

public class BuchungGeraetAnzeigeModel implements IObjektModel { //@author Ben Kröncke
	
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
	
	public void holeGeraete(String talking2, int modellNr2, int kNr2, int geraetNr) {

		talking = talking2;
		kNr = kNr2;
		modellNr = modellNr2;
		geraetNrloc = geraetNr;
		
		System.out.println(talking);
		
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
				String query = "select ID,MAKEL,VERKAUFSPREIS, FARBE from SPORTGERAET where MODELLID = '" + modellNr + "' AND STATUS = 'OK'";
				String update = null;
				
				String pattern = "yyyy-MM-dd' 'HH:mm:ss";
				String date = new SimpleDateFormat(pattern).format(new Date());

			try {
				
				stmt = con.createStatement();

				if(talking.equals("Verleih"))
				{
					
					erfasseVerleih(stmt, date);
				}
				if(talking.equals("Verkauf"))
				{
					erfasseVerkauf(stmt, query, date);
				}
				
				erzeugeGeraetTabelle(stmt);

			} catch (SQLException e ) {
				e.printStackTrace();
			} finally {
				if (stmt != null) { stmt.close(); }
			}

		}

	private void erzeugeGeraetTabelle(Statement stmt) throws SQLException {
		String query;
		query = "select ID,MAKEL,VERKAUFSPREIS, FARBE from SPORTGERAET where MODELLID = '" + modellNr + "' AND STATUS = 'OK'";
		
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

package Datenbankmodels;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.table.TableModel;

import Domaenklassen.GeraeteModell;
import Domaenklassen.GeraeteTyp;
import Domaenklassen.Rechnung;
import GUI.IObjektView;
import net.proteanit.sql.DbUtils;


/**
 * @author Darnel
 *
 */
public class RechnungAnzeigenModel implements IObjektModel{
	
	private ArrayList<IObjektView> observers = new ArrayList<IObjektView>();
	private ArrayList<Rechnung> mengeAnRechnungen = new ArrayList<Rechnung>();
	private TableModel table;
	private int rechnungID = 0;
	private int rechnungsNr;
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


	
	public void holeRechnungen(String talking2, int rechnungsNr2, String search) {

		talking = talking2;
		rechnungsNr = rechnungsNr2;
		this.search = search;
		
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
		String query = "select * from RECHNUNG";
		   
	   // if(talking.equals("master"))
	   // 	query = "select * from RECHNUNG where TYPID = '" + rechnungsNr + "'";
		//if(talking.equals("search"))
		//    query = "select * from Modell where TYPID = '" + rechnungsNr + "' AND NAME LIKE '" + search + "%'";
		try {
			stmt = con.createStatement();

			System.out.println(query);
				
			ResultSet rs = stmt.executeQuery(query);
			table = DbUtils.resultSetToTableModel(rs);

		} catch (SQLException e ) {
			e.printStackTrace();
		} finally {
			if (stmt != null) { stmt.close(); }
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


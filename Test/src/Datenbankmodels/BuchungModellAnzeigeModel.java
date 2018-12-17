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
import GUI.IObjektView;
import net.proteanit.sql.DbUtils;


/**
 * @author michi
 *
 */
public class BuchungModellAnzeigeModel implements IObjektModel{
	
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
		String query = "select * from MODELL";
		   
	    if(talking.equals("master"))
	    	query = "select * from MODELL where TYPID = '" + typNr + "'";
	    if(talking.equals("gesamt"))
	    	query = "select * from MODELL";
		if(talking.equals("search"))
		    query = "select * from Modell where TYPID = '" + typNr + "' AND NAME LIKE '" + search + "%'";
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
	

	

	/* Datenbank
		create table MODELL(
		MODELLID int (10) not null AUTO_INCREMENT,
		MODELLNAME varchar (50) not null,
		TYPID int(10) not null,
		PREISLISTEID int (10) not null,
		constraint pk_modell primary key (MODELLID),
		constraint fk_modell_typ foreign key (TYPID)
		references TYP(TYPID));
		
		insert into modell
		values (default, 'COSTWAY Surfbrett Surfboard Stand up', 1, 1),
		(default, 'Bestway HYDRO-FORCE iSUP Oceana', 1, 1),
		(default, 'Segelboot Leisure 17', 2, 2),
		(default, 'ZRAY Nassau 13,4" Professional Kajak 2 Personen', 3, 3);
	 * 
	 * 
	 */

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


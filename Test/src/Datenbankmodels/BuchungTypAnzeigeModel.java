package Datenbankmodels;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.table.TableModel;

import Domaenklassen.GeraeteTyp;
import Domaenklassen.IKunde;
import GUI.IObjektView;
import net.proteanit.sql.DbUtils;


/**
 * @author michi / Ben Kröncke
 *
 */
public class BuchungTypAnzeigeModel implements IObjektModel{
	
	private ArrayList<IObjektView> observers = new ArrayList<IObjektView>();
	private ArrayList<GeraeteTyp> mengeAnTypen = new ArrayList<GeraeteTyp>();
	private int typNr = 0;
	private TableModel tableModel;
	private String talking = "master";
	private int knrloc;
	private String name;
	private IKunde kunde;
	
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


	
	public void holeTypen(int knr, String talking2, String searchtxt, IKunde kunde) {
		
		talking = talking2;
		knrloc = knr;
		name = searchtxt;
		this.kunde = kunde;

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
		    String query = null;
		    
		    String motor = "Motorbootschein";
		    String segel = "Segelschein";
		    String surf = "Surfschein";
		    
		    if(talking.equals("master"))
		    {
		    	if(kunde.getMotorbootschein() == false)
		    		motor = "";
		    	if(kunde.getSegelschein() == false)
		    		segel = "";
		    	if(kunde.getSurfschein() == false)
		    		surf = "";
		    	query = "select * from typ where Fuehrerschein in('" + motor + "','" + segel + "','" + surf + "','Kein')";
		    	System.out.println(query);

		    }
		    
		    else if(talking.equals("gesamt")){
		    	query = "select * from typ";
		    }
		    
		    
		    else if(talking.equals("name"))
		    	query = "select * from TYP where name LIKE '%" + name + "%' and Fuehrerschein in('" + motor + "','" + segel + "','" + surf + "','Kein')";
		    System.out.println(query);
		    
		    
		    try {
		        stmt = con.createStatement();
		        ResultSet rs = stmt.executeQuery(query);
		        tableModel = DbUtils.resultSetToTableModel(rs);
		        
		        
		        

		    } catch (SQLException e ) {
		    	e.printStackTrace();
		    } finally {
		        if (stmt != null) { stmt.close(); }
		    }

		}
	

	
	public ArrayList<Object> getObjekte(){
	
		return null;
	
	}

	@Override
	public TableModel getTableModel() {
		// TODO Auto-generated method stub
		return tableModel;
	}
	
}


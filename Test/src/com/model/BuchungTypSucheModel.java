package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.table.TableModel;

import com.entity.GeraeteTyp;
import com.entity.IKunde;
import com.view.IObjektView;

import net.proteanit.sql.DbUtils;


/**
 * @author Ben Kr�ncke
 *
 */
public class BuchungTypSucheModel implements IObjektModel{
	
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

		    Statement stmtBuchungTypSucheModel = null;
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
		    
		    else if(talking.equals("suchen")){
		    	query = "select * from typ WHERE NAME LIKE '"+name+"%' OR ID LIKE '"+name+"%' OR FUEHRERSCHEIN LIKE '"+name+"%'";
		    }
		    
		    
		    else if(talking.equals("name"))
		    	query = "select * from TYP where name LIKE '%" + name + "%' and Fuehrerschein in('" + motor + "','" + segel + "','" + surf + "','Kein')";
		    System.out.println(query);
		    
		    
		    try {
		        stmtBuchungTypSucheModel = con.createStatement();
		        ResultSet rs = stmtBuchungTypSucheModel.executeQuery(query);
		        tableModel = DbUtils.resultSetToTableModel(rs);
		        
		        
		        

		    } catch (SQLException e ) {
		    	e.printStackTrace();
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


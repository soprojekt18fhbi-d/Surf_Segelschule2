package Datenbankmodels;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ComboBoxModel;
import javax.swing.table.TableModel;

import Domaenklassen.IAdresse;
import GUI.IObjektView;
import GUI.IWirtschaftlichkeitView;

public class WirtschaftlichkeitModel implements IWirtschaftlichkeitModel{ //Ben Kröncke

	private ArrayList<IWirtschaftlichkeitView> observers = new ArrayList<IWirtschaftlichkeitView>();
	private ArrayList<String> cboxStrings = new ArrayList<String>();
	private String mode = "";
	private String talking = "";
	private int income = 0;
	private int expenses = 0;
	private int specialID = 0;
	
	
	public void holeDaten(String talking2, String mode2, int id2) {
		
		talking = talking2;
		mode = mode2;
		specialID = id2;
		
		
		 try {
			 
			 
			this.talking = talking2;
			Connection conn = DriverManager.
			    getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "sa");
			
			viewTable(conn);
			
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        updateObserver();
	}
	
	
	public void viewTable(Connection con) throws SQLException {

		    Statement stmt = con.createStatement();
		    String queryIncome = "SELECT SUMME FROM RECHNUNG WHERE REPARATURID IS NULL";
		    String queryExpensesDevices = "SELECT ANSCHAFFUNGSPREIS FROM SPORTGERAET";
		    String queryExpensesRepair = "SELECT SUMME FROM RECHNUNG WHERE REPARATURID IS NOT NULL";
		    String query = "";
		    cboxStrings.clear();
		    
		    try {
		    	
		    	if(talking.equals("category"))
		    	{
		    		if(mode.equals("Sportgeraet") || mode.equals("Unternehmen"))
		    		{
		    			//Wird in GUI geklärt ID wird eingegeben
		    		}
		    		else
		    		{
		    			query = "SELECT NAME FROM " + mode;
				        ResultSet rs = stmt.executeQuery(query);
				        while (rs.next())
				        {
				        	cboxStrings.add(rs.getString("NAME"));
				        }
		    		}
		    	}

		        
        
		    } catch (SQLException e ) {
		    	e.printStackTrace();
		    } finally {
		        if (stmt != null) { stmt.close(); }
		    }
		    
		    
		}
	
	
	@Override
	public void anmelden(IWirtschaftlichkeitView view) {
		// TODO Auto-generated method stub
		try {
			observers.add(view);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void abmelden(IWirtschaftlichkeitView view) {
		// TODO Auto-generated method stub
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
	public int getIncome() {
		// TODO Auto-generated method stub
		return income;
	}

	@Override
	public int getExpenses() {
		// TODO Auto-generated method stub
		return expenses;
	}

	@Override
	public ArrayList<String> getStrings() {
		// TODO Auto-generated method stub
		return cboxStrings;
		
	}

}

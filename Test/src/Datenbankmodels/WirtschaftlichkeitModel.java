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
	private double income = 0;
	private double expenses = 0;
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
		    income = 0;
		    expenses = 0;
		    
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
		    	
		    	if (talking.equals("calc"))
		    	{
		    		if(mode.equals("Unternehmen"))
		    		{
		    			calcExpInc(stmt, queryIncome, queryExpensesDevices, queryExpensesRepair);
		    		}
		    		if(mode.equals("STANDORT"))
		    		{
		    			
		    		}
		    		if(mode.equals("TYP"))
		    		{
		    			
		    		}
		    		if(mode.equals("MODELL"))
		    		{
		    			
		    		}
		    		if(mode.equals("Sportgeraet"))
		    		{
		    			
		    		}
		    	}

		        
        
		    } catch (SQLException e ) {
		    	e.printStackTrace();
		    } finally {
		        if (stmt != null) { stmt.close(); }
		    }
		    
		    
		}


	private void calcExpInc(Statement stmt, String queryIncome, String queryExpensesDevices, String queryExpensesRepair)
			throws SQLException {
		ResultSet rs = stmt.executeQuery(queryIncome);
		while (rs.next())
		{
			income += rs.getDouble("SUMME");
			System.out.println(income);
		}
		
		rs = stmt.executeQuery(queryExpensesDevices);
		while (rs.next())
		{
			expenses += rs.getDouble("ANSCHAFFUNGSPREIS");
			System.out.println(expenses);
		}
		
		rs = stmt.executeQuery(queryExpensesRepair);
		while (rs.next())
		{
			expenses += rs.getDouble("SUMME");
			System.out.println(expenses);
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
	public double getIncome() {
		// TODO Auto-generated method stub
		return income;
	}

	@Override
	public double getExpenses() {
		// TODO Auto-generated method stub
		return expenses;
	}

	@Override
	public ArrayList<String> getStrings() {
		// TODO Auto-generated method stub
		return cboxStrings;
		
	}

}

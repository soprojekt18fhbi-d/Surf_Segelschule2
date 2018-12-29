package Datenbankmodels;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Domaenklassen.GeraeteModell;
import GUI.IAnlegenView;

public class ModellAnlegenModel implements IAnlegenModel{

	
	@Override
	public void anmelden(IAnlegenView view) {
		
		try {
			observers.add(view);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		try {
			if(observers.contains(view));
				observers.remove(view);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void abmelden(IAnlegenView view) {

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
	
	public void modellAnlegen(String[] modell) {
		Statement statementModellAnlegenModel = null;
		Statement statementModellAnlegenModel2 = null;
 
        try {
			Connection conn = DBConnectorSingleton.getCon();

			statementModellAnlegenModel = conn.createStatement();
			
			String name = modell[0];
			String typ = modell[1];
			int preis = Integer.parseInt(modell[2]);
			
						
			String query = "select * from TYP WHERE NAME = '" +typ+ "'";
            ResultSet rs = statementModellAnlegenModel.executeQuery(query);
            while (rs.next()){
		        int typID =  Integer.parseInt(rs.getString("TYPID"));
		        
		        
		        statementModellAnlegenModel2 = conn.createStatement();
			    String sqlupdate = "INSERT INTO MODELL VALUES (default,'" + name + "','" +typID+ "','" +preis+"')";
				int ergebnis = statementModellAnlegenModel2.executeUpdate(sqlupdate);
            }
	        
	        

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
        updateObserver();
		}
        
	}

	@Override
	public ArrayList<String> getObertypen() {
		// TODO Auto-generated method stub
		return null;
	}

}
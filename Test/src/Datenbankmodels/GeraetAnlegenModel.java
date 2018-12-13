package Datenbankmodels;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Domaenklassen.GeraeteTyp;
import GUI.IAnlegenView;

public class GeraetAnlegenModel implements IAnlegenModel{
	
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
	
	public void geraetAnlegen(String[] geraet) {
		Statement statement = null;
		Statement statement2 = null;
 
        try {
			Connection conn = DriverManager.
			    getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "sa");

			statement = conn.createStatement();
			
			String typ = geraet[0];
			String modell = geraet[1];
			int geraeteID = Integer.parseInt(geraet[2]);
			double anschaffungspreis = Double.parseDouble(geraet[3]);
			double verkaufspreis = Double.parseDouble(geraet[4]);
			String farbe = geraet[5];
			int baujahr = Integer.parseInt(geraet[6]);
			String makel = geraet[7];
			
			
						
			String query = "select * from MODELL WHERE MODELLNAME = '" +modell+ "'";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()){
		        int modellID =  Integer.parseInt(rs.getString("MODELLID"));
		        
		        
		        statement2 = conn.createStatement();
			    String sqlupdate = "INSERT INTO SPORTGERAET VALUES ('" +geraeteID+ "','" + farbe + "','0','" +verkaufspreis+ "','" + anschaffungspreis+ "','" +modellID+ "','" +makel+ "')";
				int ergebnis = statement2.executeUpdate(sqlupdate);
            }
	        
	        
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
        updateObserver();
		}
        
	}

}
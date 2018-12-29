package Datenbankmodels;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Domaenklassen.GeraeteTyp;
import GUI.IAnlegenView;

public class TypAnlegenModel implements IAnlegenModel{

	
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
	
	public void typAnlegen(String[] typ) {
	
 
        try {
			Connection conn = DBConnectorSingleton.getCon();

			Statement statementTypAnlegenModel = conn.createStatement();
			
			String talking = typ[0];
			int id = Integer.parseInt(typ[1]);
			String name = typ[2];
			String schein = typ[3];
			String sqlupdate;
			
			if (talking.equals("anlegen"))
				sqlupdate = "INSERT INTO TYP VALUES (default,'" + name + "','"+ schein+ "')";
			else 
				sqlupdate = "UPDATE TYP SET NAME = '"+name+"', FUEHRERSCHEIN = '"+schein+"' WHERE ID = "+id+"";
			
			
			int ergebnis = statementTypAnlegenModel.executeUpdate(sqlupdate);
			
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

package Datenbankmodels;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import GUI.IView;

/**
 * @author michi
 *
 */
public class ModellAnzeigeModel implements IModel{

	@Override
	public void anmelden(IView view) {
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
	public void abmelden(IView view) {
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

	public ArrayList<String> modelleHolen(){
		ArrayList<String>modellListe = new ArrayList<String>();
		
		try {
			Connection conn = DriverManager.
	            getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "sa");
			Statement stmt = conn.createStatement();
			String query = "select * from MODELL";
			ResultSet rs;
			rs = stmt.executeQuery(query);
						
			while (rs.next()) {
	        	
	        	String id = rs.getString(1);
	        	String name = rs.getString(2);
	        	String verleihPreis = rs.getString(3);
	        	String ausgabe = id+", "+name+", "+verleihPreis;
	        	modellListe.add(ausgabe);
	        	
	        }	
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		updateObserver();
		return modellListe;
	}
}

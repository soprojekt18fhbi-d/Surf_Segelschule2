package Datenbankmodels;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.DefaultListModel;

import Domaenklassen.Kunde;
import GUI.IView;

public class KundeRegistrierenModel implements IModel{

	
	
	@Override
	public void anmelden(IView view) {
		/**
		 * Anmelden einer View
		 * @author Benkr
		 * 
		 */
		
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
		/**
		 * Abmelden einer View.
		 * @author Benkr
		 * 
		 */
		
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
		/**
		 * updaten der Views
		 * @author Benkr
		 * 
		 */
		try {
			for (int i = 0; i < observers.size(); ++i) 
				observers.get(i).aktualisieren(this);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void kundeAnlegen(Kunde kunde) {
	
 
        try {
			Connection conn = DriverManager.
			    getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "sa");

			Statement statement = conn.createStatement();
			
			String name = kunde.getName();
			String vorname = kunde.getVorname();
			String email = kunde.getEmail();
			boolean surfs = kunde.getSurfschein();
			boolean segels = kunde.getSegelschein();
			boolean motorboots = kunde.getMotorbootschein();
			String surfschein = "N";
			String segelschein = "N";
			String motorbootschein = "N";
			if(surfs == true)
				surfschein = "J";
			if(segels == true)
				segelschein = "J";
			if(motorboots == true)
				motorbootschein = "J";
			
			
			
			
			String sqlupdate = "INSERT INTO KUNDE " + "VALUES (default, " + "'" + vorname + "', '" + name + "', '" + email +"', 'N', '" + segelschein + "', '" + motorbootschein + "', '" + surfschein + "')";
			
			
			int ergebnis = statement.executeUpdate(sqlupdate);
			
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
        updateObserver();
        
	}



	}
}










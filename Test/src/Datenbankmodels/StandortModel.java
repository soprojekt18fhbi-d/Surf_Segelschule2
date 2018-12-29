package Datenbankmodels;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.table.TableModel;

import Domaenklassen.GeraeteTyp;
import Domaenklassen.IKunde;
import GUI.IObjektView;
import GUI.IStandortView;
import net.proteanit.sql.DbUtils;

public class StandortModel implements IStandortModel { //Ben Kröncke

	private ArrayList<IStandortView> observers = new ArrayList<IStandortView>();
	
	private String talking;
	private String standortID;
	private String standortName;
	private String telnr;
	private String password;
	private String plz;
	private String strasse;
	private String ort;
	private String hnr;
	private int addressID;
	private boolean success = false;
	
	
	public void registriere(String standortID2, String standortName2, String telnr2, String talking2, String password2, String plz2, String strasse2, String ort2, String hnr2) {
		
		talking = talking2;
		standortID = standortID2;
		standortName = standortName2;
		telnr = telnr2;
		password = password2;
		plz = plz2;
		strasse = strasse2;
		ort = ort2;
		hnr = hnr2;

        try {
			Connection conn = DBConnectorSingleton.getCon();
			// add application code here
			vergleicheDaten(conn);
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        updateObserver();
	}
	
	public void vergleicheDaten(Connection con)
		    throws SQLException {

		    Statement stmtStandortModel = con.createStatement();
		    String update = null;
		    String query = null;

		    try {
		    	if(talking.equals("register"))
		    	{
		    		registerStandort(stmtStandortModel);
		    	}
		    	else if(talking.equals("login"))
		    	{
		    		loginStandort(stmtStandortModel);
		    	}

		    
		    
		    

		        
		        
		        

		    } catch (SQLException e ) {
		    	e.printStackTrace();
		    }

		}

	private void loginStandort(Statement stmt) throws SQLException {
		String query;
		query = "SELECT ID,NAME,PASSWORD FROM STANDORT WHERE NAME = '" + standortName + "' AND PASSWORD = '" + password + "'";
		
  	
		String chckName = null;
		String chckPW = null;
		
		ResultSet rs = stmt.executeQuery(query);
		System.out.println(query);
		while (rs.next())
		{
			chckName = rs.getString("NAME");
			chckPW = rs.getString("PASSWORD");
		}
		
		System.out.println(chckName);
		System.out.println(chckPW);
		
		if(standortName.equals(chckName) && password.equals(chckPW))
			success = true;
		else
			success = false;
	}

	private void registerStandort(Statement stmt) throws SQLException {
		String update;
		String query;
		update = "INSERT INTO ADRESSE VALUES (default, '" + plz + "', '" + strasse + "', '" + ort + "', 'Standortadresse', '" + hnr + "', null)";
		stmt.executeUpdate(update);
		System.out.println(update);
		query = "SELECT ID FROM ADRESSE WHERE PLZ = '" + plz + "' AND STRASSE = '" + strasse + "' AND hnr = '" + hnr + "' AND ORT = '" + ort + "'";
		System.out.println(query);
		ResultSet rs = stmt.executeQuery(query);
  	
		while (rs.next())
			addressID = rs.getInt("ID");
		System.out.println(addressID);
  	
  	
		update = "INSERT INTO STANDORT VALUES('" + standortID + "', '" + telnr + "', '" + addressID + "', '" + standortName + "', '" + password + "')";
		stmt.executeUpdate(update);
		System.out.println(update);
	}
	
	
	
	
	
	
	
	
	@Override
	public void anmelden(IStandortView view) {
		try {
			observers.add(view);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}

	@Override
	public void abmelden(IStandortView view) {
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
	
	@Override
	public boolean pruefen() {
		// TODO Auto-generated method stub
		return success;
	}




	
	
	
}

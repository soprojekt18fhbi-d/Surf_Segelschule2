/**
 * @author Grundstruktur: Ben S / Detailabfragen Ben K
 */

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


public class KundeSucheModel implements IModel  {

	private ArrayList<IView> observers = new ArrayList<IView>();

	private ArrayList<Kunde> mengeAnKunden = new ArrayList<Kunde>();
	
	private int kundeNr = 0;

	
	
	public void holeKunden(String kdID, String nname, String vname, String plz, String ort,
			String strasse, String hausnr) {

		try {
			Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "sa");
			// add application code here
			viewTable(conn, kdID, nname, vname, plz, ort, strasse, hausnr);

			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		updateObserver();
	}
	

	
	
	
	public void viewTable(Connection con, String kdID, String nname, String vname, String plz, String ort,
			String strasse, String hausnr) throws SQLException {

		Statement stmt = null;
		
		//Abfrage aufgrund der Parameter
		
		String query = "select * from KUNDE";
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			//Ausgabe der Kundendaten
			
			while (rs.next()) {

				
				
				//Was passiert mit der Kundennummer??? @Ben K
				
				kundeNr = kundeNr++;
				int kundennummer = Integer.parseInt(rs.getString("ID"));
				String name = rs.getString("NACHNAME");
				String vorname = rs.getString("VORNAME");
				boolean surfschein = Boolean.parseBoolean(rs.getString("SURFSCHEIN"));
				boolean segelschein = Boolean.parseBoolean(rs.getString("SEGELSCHEIN"));
				boolean motorbootschein = Boolean.parseBoolean(rs.getString("MOTORBOOTSCHEIN"));
				String email = rs.getString("EMAIL");
				
				//Wie sollen Führerscheine übergeben werden? Notwendig für Abfrage im Ausleih-Prozess
				Kunde kundeNr = new Kunde (name, vorname , email, surfschein, segelschein, motorbootschein);
				mengeAnKunden.add(kundeNr);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}

	}
	
	
	public DefaultListModel getKunden() {

		DefaultListModel<String> listmodel = new DefaultListModel<String>();

		for (int i = 0; i < mengeAnKunden.size(); i++) {
			listmodel.addElement(mengeAnKunden.get(i).getName() + ", " + mengeAnKunden.get(i).getVorname() + ", "
					+ mengeAnKunden.get(i).getEmail());
		}
		return listmodel;

	}
	
	
	
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
	
	
	
	

}

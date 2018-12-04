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


public class KundeSucheModel implements IModelSuche  {

	private ArrayList<IView> observers = new ArrayList<IView>();

	private ArrayList<Kunde> mengeAnKunden = new ArrayList<Kunde>();
	
	private int kundeNr = 0;

	
	
	/* (non-Javadoc)
	 * @see Datenbankmodels.ModelSuchInterface#holeKunden(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void holeDaten(String kdID, String nname, String vname, String plz, String ort,
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
	

	
	
	
	/* (non-Javadoc)
	 * @see Datenbankmodels.ModelSuchInterface#viewTable(java.sql.Connection, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void viewTable(Connection con, String kdID, String nname, String vname, String plz, String ort,
			String strasse, String hausnr) throws SQLException {
		
		Statement stmt = null;
		stmt = con.createStatement();
		
		
		try {
		
			String query = "select * from kunde";
			
			//Abfrage aufgrund der Parameter
			
		
		
			
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
				kundeNr.setKundennummer(kundennummer);
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
	
	
	/* (non-Javadoc)
	 * @see Datenbankmodels.ModelSuchInterface#getKunden()
	 */
	@Override
	public DefaultListModel holeModel() {

		DefaultListModel<String> listmodel = new DefaultListModel<String>();

		for (int i = 0; i < mengeAnKunden.size(); i++) {
			listmodel.addElement(mengeAnKunden.get(i).getKundennummer() + ", " + mengeAnKunden.get(i).getName() + ", " + mengeAnKunden.get(i).getVorname() + ", "
					+ mengeAnKunden.get(i).getEmail());
		}
		return listmodel;

	}
	
	
	
	/* (non-Javadoc)
	 * @see Datenbankmodels.ModelSuchInterface#anmelden(GUI.IView)
	 */
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

	/* (non-Javadoc)
	 * @see Datenbankmodels.ModelSuchInterface#abmelden(GUI.IView)
	 */
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

	/* (non-Javadoc)
	 * @see Datenbankmodels.ModelSuchInterface#updateObserver()
	 */
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

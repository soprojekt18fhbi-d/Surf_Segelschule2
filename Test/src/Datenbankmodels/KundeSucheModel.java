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
import javax.swing.table.TableModel;

import Domaenklassen.Adresse;
import Domaenklassen.IAdresse;
import Domaenklassen.IKunde;
import Domaenklassen.Kunde;
import GUI.IObjektView;
import GUI.IView;
import net.proteanit.sql.DbUtils;


public class KundeSucheModel implements IObjektModel  {

	private ArrayList<IObjektView> observers = new ArrayList<IObjektView>();

	private ArrayList<IKunde> mengeAnKunden = new ArrayList<IKunde>();
	private ArrayList<IAdresse> mengeAnAdressen = new ArrayList<IAdresse>();
	
	private TableModel result;
	
	private int kundeNr = 0;
	
	private String knrplzloc = "";
	private String nachnameortloc = "";
	private String vornamestrasseloc = "";
	private String emailhnrloc = "";
	private String mode = "";
	private String knr = "";
	private String talking = "";
	private String variableKnr = "";
	private String surf;
	private String segel;
	private String motor;
	private String heimat;

	/*
	 * @author BenKr
	 * 
	 * 
	 */
	
	public void holeDaten(String knrplz, String nachnameort, String vornamestrasse, String emailhnr, String selectedMode, String variableKnr, String talking, String surf2, String segel2, String motor2, String heimat2) {
		
		knrplzloc = knrplz;
		nachnameortloc = nachnameort;
		vornamestrasseloc = vornamestrasse;
		emailhnrloc = emailhnr;
		mode = selectedMode;
		knr = variableKnr;
		this.talking = talking;
		this.variableKnr = variableKnr;
		this.segel = segel2;
		this.surf = surf2;
		this.motor = motor2;
		this.heimat = heimat2;
		
		
		
		 System.out.println("" + knrplz + nachnameort + vornamestrasse + emailhnr + selectedMode + variableKnr + motor2 + segel2 + surf2 + heimat2);
        try {
        	
			Connection conn = DBConnectorSingleton.getCon();
			// add application code here
			viewTable(conn);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        updateObserver();
	}

	@Override
	public void anmelden(IObjektView view) {
		// TODO Auto-generated method stub
		try {
			observers.add(view);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void viewTable(Connection con)
		    throws SQLException {

			
		
		    Statement stmtKundeSucheModel = con.createStatement();
		    String query = null;
		    
		    if(mode == "Kunde")
		    {
		    	if (talking == "knrplz")
			    	query = "SELECT * FROM KUNDE WHERE (ID = '" + knrplzloc + "');";
		    	if(talking == "boss")
		    		query = "SELECT * FROM KUNDE;";
		    	if(talking == "nachnameort")
		    		query = "SELECT * FROM KUNDE WHERE (NACHNAME = '" + nachnameortloc + "');";
		    	if (talking == "vornamestrasse")
		    		query = "SELECT * FROM KUNDE WHERE (VORNAME = '" + vornamestrasseloc + "');";
		    	if (talking == "emailhnr")
		    		query = "SELECT * FROM KUNDE WHERE (EMAIL = '" + emailhnrloc + "');";
		    }
		    
		    
		    
		    if(mode == "Adresse")
		    {
		    	if (talking == "knrplz")
			    	query = "SELECT * FROM ADRESSE WHERE (PLZ = '" + knrplzloc + "') AND ART NOT IN('Standortadresse');";
		    	if(talking == "boss")
		    		query = "SELECT * FROM ADRESSE WHERE ART NOT IN('Standortadresse');";
		    	if(talking == "nachnameort")
		    		query = "SELECT * FROM ADRESSE WHERE (ORT = '" + nachnameortloc + "');";
		    	if (talking == "vornamestrasse")
		    		query = "SELECT * FROM ADRESSE WHERE (STRASSE = '" + vornamestrasseloc + "');";
		    	if (talking == "emailhnr")
		    		query = "SELECT * FROM ADRESSE WHERE (HNR = '" + emailhnrloc + "');";
		    	if (talking == "variableKnr")
		    		query = "SELECT * FROM ADRESSE WHERE (KUNDEID = '" + variableKnr + "');";
		    }
		    
		    if(talking.equals("deaktivierenkunde"))
		    {
		    	query = "Select * from Kunde;";
		    	
		    	
		    	String sql = "UPDATE KUNDE SET BESTANDSKUNDE = 'N' WHERE ID = '" + knrplzloc + "';";
		    	
		    	int ergebnis = stmtKundeSucheModel.executeUpdate(sql);
		    	
		    }
		    else if (talking.equals("deaktivierenadresse"))
		    {
		    	query = "Select * from Adresse WHERE ART NOT IN('Standortadresse');";
		    	
		    	String sql = "DELETE FROM ADRESSE WHERE KUNDEID = '" + variableKnr + "' AND PLZ ='" + this.knrplzloc + "' AND STRASSE = '" + this.vornamestrasseloc + "';";
		    	
		    	int ergebnis = stmtKundeSucheModel.executeUpdate(sql);
		    	
		    }
		    else if(talking.equals("kundespeichern"))
		    {
		    	query = "Select * from Kunde;";
		    	

		    		
		    	changeVorname(stmtKundeSucheModel);

			    changeNachname(stmtKundeSucheModel);
			    	
			   	changeEmail(stmtKundeSucheModel);
			    	
			   	changeSegel(stmtKundeSucheModel);
			    	
			   	changeMotor(stmtKundeSucheModel);
			    	
			    changeSurf(stmtKundeSucheModel);
			    
		    }
		    else if(talking.equals("adressespeichern"))
		    {
		    	query = "Select * from Adresse WHERE ART NOT IN('Standortadresse');";
		    	
		    	String sql = "INSERT INTO ADRESSE VALUES(default, " + this.knrplzloc + ", '" + this.vornamestrasseloc + "', '" + this.nachnameortloc + "', '" + this.heimat + "', " + this.emailhnrloc + ", " + this.variableKnr + ");";
		    	
		    	int ergebnis = stmtKundeSucheModel.executeUpdate(sql);
		    	
		    }
		    

		    try {
		    	System.out.println(query);
		        stmtKundeSucheModel = con.createStatement();
		        ResultSet rs = stmtKundeSucheModel.executeQuery(query);
		        
		        result = DbUtils.resultSetToTableModel(rs);
		        
		    } catch (SQLException e ) {
		    	e.printStackTrace();
		    }
		    
		    
		}

	private void changeVorname(Statement stmt) throws SQLException {
		String sql = "UPDATE KUNDE SET VORNAME = '" + this.vornamestrasseloc + "' WHERE ID = " + this.knrplzloc;
		System.out.println(sql);
		int ergebnis = stmt.executeUpdate(sql);
	}

	private void changeNachname(Statement stmt) throws SQLException {
		String sql;
		int ergebnis;
		sql = "UPDATE KUNDE SET NACHNAME = '" + this.nachnameortloc + "' WHERE ID = " + this.knrplzloc;
		System.out.println(sql);
		ergebnis = stmt.executeUpdate(sql);
	}

	private void changeEmail(Statement stmt) throws SQLException {
		String sql;
		int ergebnis;
		sql = "UPDATE KUNDE SET EMAIL = '" + this.emailhnrloc + "' WHERE ID = " + this.knrplzloc;
		System.out.println(sql);
		ergebnis = stmt.executeUpdate(sql);
	}

	private void changeSegel(Statement stmt) throws SQLException {
		String sql;
		int ergebnis;
		sql = "UPDATE KUNDE SET SEGELSCHEIN = '" + this.segel + "' WHERE ID = " + this.knrplzloc;
		System.out.println(sql);
		ergebnis = stmt.executeUpdate(sql);
	}

	private void changeMotor(Statement stmt) throws SQLException {
		String sql;
		int ergebnis;
		sql = "UPDATE KUNDE SET MOTORBOOTSCHEIN = '" + this.motor + "' WHERE ID = " + this.knrplzloc;
		System.out.println(sql);
		ergebnis = stmt.executeUpdate(sql);
	}

	private void changeSurf(Statement stmt) throws SQLException {
		String sql;
		int ergebnis;
		sql = "UPDATE KUNDE SET SURFSCHEIN = '" + this.surf + "' WHERE ID = " + this.knrplzloc;
		System.out.println(sql);
		ergebnis = stmt.executeUpdate(sql);
	}

	@Override
	public void abmelden(IObjektView view) {
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
	public ArrayList<Object> getObjekte() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TableModel getTableModel() {
		// TODO Auto-generated method stub
		return result;
	}


	


	
	
	
}

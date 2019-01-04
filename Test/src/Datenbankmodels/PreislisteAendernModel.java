package Datenbankmodels;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Berechnung.DatentypUmwandlung;
import Domaenklassen.Preisliste;
import GUI.IAnlegenView;
import GUI.PreislisteAendernGUI;

public class PreislisteAendernModel implements IAnlegenModel {

	private ArrayList<IAnlegenView> observers = new ArrayList<IAnlegenView>();
	
	private ArrayList <Object> mengeAnPreislisten = new ArrayList<Object>();
	private String talking = "first";
	private double[] preisliste;
	
	int id;
	String  preisEineStd;
	String  preisZweiStd;
	String  preisVierStd;
	String  preisEinenTag;
	String  preisZweiTage;
	String  preisDreiTage;
	String  preisVierTage;
	String  preisFuenfTage;
	String  preisSechsSiebenTage;
	String  preisAchtTage;
	String  preisNeunTage;
	String  preisZehnTage;
	String  preisElfTage;
	String  preisZwoelfVierzehnTage;
	String  preisFuenfzehnTage;
	String  preisSechzehnTage;
	String  preisSiebzehnTage;
	String  preisAchtzehnEinundzwanzigTage;
	String  preisTagVierWochen;
	String  preisVierWochen;
	String  preisAchtWochen;
	String  preisKauf;
	
	public void anfrage(String talking, double[] preisliste) {
		
		this.talking = talking;
		this.preisliste = preisliste;
		
        try {
        	
			Connection conn = DBConnectorSingleton.getCon();
			// add application code here
			viewTable(conn);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
	
	public void setPreislisteStrings (double[] preisliste) {

		  id = (int) Math.floor(preisliste[0]);
		  preisEineStd = DatentypUmwandlung.doubleZuString(preisliste[1]);
		  preisZweiStd = DatentypUmwandlung.doubleZuString(preisliste[2]);
		  preisVierStd = DatentypUmwandlung.doubleZuString(preisliste[3]);
		  preisEinenTag = DatentypUmwandlung.doubleZuString(preisliste[4]);
		  preisZweiTage = DatentypUmwandlung.doubleZuString(preisliste[5]);
		  preisDreiTage = DatentypUmwandlung.doubleZuString(preisliste[6]);
		  preisVierTage = DatentypUmwandlung.doubleZuString(preisliste[7]);
		  preisFuenfTage = DatentypUmwandlung.doubleZuString(preisliste[8]);
		  preisSechsSiebenTage = DatentypUmwandlung.doubleZuString(preisliste[9]);
		  preisAchtTage = DatentypUmwandlung.doubleZuString(preisliste[10]);
		  preisNeunTage= DatentypUmwandlung.doubleZuString(preisliste[11]);
		  preisZehnTage = DatentypUmwandlung.doubleZuString(preisliste[12]);
		  preisElfTage = DatentypUmwandlung.doubleZuString(preisliste[13]);
		  preisZwoelfVierzehnTage = DatentypUmwandlung.doubleZuString(preisliste[14]);
		  preisFuenfzehnTage = DatentypUmwandlung.doubleZuString(preisliste[15]);
		  preisSechzehnTage = DatentypUmwandlung.doubleZuString(preisliste[16]);
		  preisSiebzehnTage = DatentypUmwandlung.doubleZuString(preisliste[17]);
		  preisAchtzehnEinundzwanzigTage = DatentypUmwandlung.doubleZuString(preisliste[18]);
		  preisTagVierWochen = DatentypUmwandlung.doubleZuString(preisliste[19]);
		  preisVierWochen = DatentypUmwandlung.doubleZuString(preisliste[20]);
		  preisAchtWochen = DatentypUmwandlung.doubleZuString(preisliste[21]);
		  preisKauf = DatentypUmwandlung.doubleZuString(preisliste[22]);
		
	}
	
	

	
	public void viewTable(Connection con)
		    throws SQLException {
		
	    Statement stmtModellHinzufuegenModel = con.createStatement();
	    String query = null;
	    
		
		if(talking.equals("aendern"))
		{
			try {
				
				setPreislisteStrings(preisliste);
				
				
				query = "select * from Preisliste WHERE ID = '"+preisliste+"'";
				
				ResultSet rs = stmtModellHinzufuegenModel.executeQuery(query);
				while (rs.next()){
					int preislisteID =  Integer.parseInt(rs.getString("ID"));
					String sqlupdate = "UPDATE Preisliste SET EINESTD = '"+preisEineStd+"', ZWEISTD = '"+preisZweiStd+"'"
							+ " , VIERSTD = '"+preisVierStd+ " , EINENTAG = '"+preisEinenTag+ " , ZWEITAGE = '"+preisZweiTage
							+ " , DREITAGE = '"+preisDreiTage+ " , VIERTAGE = '"+preisVierTage+ " , FUENFTAGE = '"+preisFuenfTage
							+ " , SECHS-SIEBENTAGE = '"+preisSechsSiebenTage+ " , ACHTTAGE = '"+preisAchtTage+ " , NEUNTAGE = '"+preisNeunTage
							+ " , ZEHNTAGE = '"+preisZehnTage+ " , ELFTAGE = '"+preisElfTage+ " , ZWOELF-VIERZEHNTAGE = '"+preisZwoelfVierzehnTage
							+ " , FUENFZEHNTAGE = '"+preisFuenfzehnTage+ " , SECHSZEHNTAGE = '"+preisSechzehnTage+ " , SIEBZEHNTAGE = '"+preisSiebzehnTage
							+ " , ACHTZEHN-EINUNDZWANZIGTAGE = '"+preisAchtzehnEinundzwanzigTage+ " , TAG-VIERWOCHEN = '"+preisTagVierWochen
							+ " , VIERWOCHEN = '"+preisVierWochen+ " , ACHTWOCHEN = '"+preisAchtWochen+ " , KAUF = '"+preisKauf
							+"' WHERE ID = "+id+"";
					int ergebnis = stmtModellHinzufuegenModel.executeUpdate(sqlupdate);		
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			} finally {
				 if (stmtModellHinzufuegenModel != null) { stmtModellHinzufuegenModel.close(); }
			}
		}	
		
	}
	
	
	@Override
	public void anmelden(IAnlegenView view) {
		// TODO Auto-generated method stub
		try {
			observers.add(view);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void abmelden(IAnlegenView view) {
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
	public ArrayList<String> getObertypen() {
		// TODO Auto-generated method stub
		return null;
	}
	

}

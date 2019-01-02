package Datenbankmodels;

import java.sql.SQLException;
import java.sql.Statement;

import Berechnung.DatentypUmwandlung;
import Domaenklassen.Preisliste;
import GUI.PreislisteAendernGUI;

public class PreislisteAendernModel {

	Preisliste preisliste;
	
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
	String  presVierWochen;
	String  preisAchtWochen;
	String  preisKauf;
	
	public void setPreislisteStrings () {

		  preisEineStd = DatentypUmwandlung.doubleZuString(preisliste.getEineStd());
		  preisZweiStd = DatentypUmwandlung.doubleZuString(preisliste.getZweiStd());
		  preisVierStd = DatentypUmwandlung.doubleZuString(preisliste.getVierStd());
		  preisEinenTag = DatentypUmwandlung.doubleZuString(preisliste.getEinenTag());
		  preisZweiTage = DatentypUmwandlung.doubleZuString(preisliste.getZweiTage());
		  preisDreiTage = DatentypUmwandlung.doubleZuString(preisliste.getDreiTage());
		  preisVierTage = DatentypUmwandlung.doubleZuString(preisliste.getVierTage());
		  preisFuenfTage = DatentypUmwandlung.doubleZuString(preisliste.getFuenfTage());
		  preisSechsSiebenTage = DatentypUmwandlung.doubleZuString(preisliste.getSechsSiebenTage());
		  preisAchtTage = DatentypUmwandlung.doubleZuString(preisliste.getAchtTage());
		  preisNeunTage= DatentypUmwandlung.doubleZuString(preisliste.getNeunTage());
		  preisZehnTage = DatentypUmwandlung.doubleZuString(preisliste.getZehnTage());
		  preisElfTage = DatentypUmwandlung.doubleZuString(preisliste.getElfTage());
		  preisZwoelfVierzehnTage = DatentypUmwandlung.doubleZuString(preisliste.getZwoelfVierzehnTage());
		  preisFuenfzehnTage = DatentypUmwandlung.doubleZuString(preisliste.getFuenfzehnTage());
		  preisSechzehnTage = DatentypUmwandlung.doubleZuString(preisliste.getSechzehnTage());
		  preisSiebzehnTage = DatentypUmwandlung.doubleZuString(preisliste.getSiebzehnTage());
		  preisAchtzehnEinundzwanzigTage = DatentypUmwandlung.doubleZuString(preisliste.getAchtzehnEinundzwanzigTage());
		  preisTagVierWochen = DatentypUmwandlung.doubleZuString(preisliste.getTagVierWochen());
		  presVierWochen = DatentypUmwandlung.doubleZuString(preisliste.getVierWochen());
		  preisAchtWochen = DatentypUmwandlung.doubleZuString(preisliste.getAchtWochen());
		  preisKauf = DatentypUmwandlung.doubleZuString(preisliste.getKauf());
		
	}
	private void PreislisteAendern(Statement stmt, Preisliste preisliste) throws SQLException {
		this.preisliste = preisliste;
		setPreislisteStrings();
		String update;

		update = "UPDATE Preisliste SET RÜCKGABEDATUM = '" + "" + "' WHERE ID = " + "";
		System.out.println(update);
		stmt.executeUpdate(update);
		update = "UPDATE SPORTGERAET SET STATUS = 'OK', MAKEL = '" + "" + "' WHERE ID = " + "";
		System.out.println(update);
		stmt.executeUpdate(update);
		
		this.preisliste=null;
	}
	public void anmelden(PreislisteAendernGUI preislisteAendernGUI) {
		// TODO Auto-generated method stub
		
	}

}

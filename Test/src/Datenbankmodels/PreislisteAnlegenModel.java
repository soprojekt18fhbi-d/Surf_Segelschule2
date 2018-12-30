/**
 * @author Ben S
 */

package Datenbankmodels;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Berechnung.DatentypUmwandlung;
import Domaenklassen.Preisliste;
import GUI.IAnlegenView;

public class PreislisteAnlegenModel implements IAnlegenModel {


	 String eineStd;
	 String zweiStd;
	 String vierStd;
	 String einenTag;
	 String zweiTage;
	 String dreiTage;
	 String vierTage;
	 String fuenfTage;
	 String sechsSiebenTage;
	 String achtTage;
	 String neunTage;
	 String zehnTage;
	 String elfTage;
	 String zwoelfVierzehnTage;
	 String fuenfzehnTage;
	 String sechzehnTage;
	 String siebzehnTage;
	 String achtzehnEinundzwanzigTage;
	 String tagVierWochen;
	 String vierWochen;
	 String achtWochen;
	 String kauf;

	@Override
	public void anmelden(IAnlegenView view) {

		try {
			observers.add(view);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			if (observers.contains(view))
				;
			observers.remove(view);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void abmelden(IAnlegenView view) {

		try {
			if (observers.contains(view))
				;
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

	public void PreislisteAnlegen(Preisliste preisliste) {

		try {
			Connection conn = DBConnectorSingleton.getCon();

			Statement statementPreislisteAnlegenModel = conn.createStatement();

			//Strings für Abfrage initialisieren und aus den double Werten die 0.0'en filtern
			eineStd= DatentypUmwandlung.doubleZuString(preisliste.getEineStd());
			zweiStd= DatentypUmwandlung.doubleZuString(preisliste.getZweiStd());
			vierStd= DatentypUmwandlung.doubleZuString(preisliste.getVierStd());
			einenTag= DatentypUmwandlung.doubleZuString(preisliste.getEinenTag());
			zweiTage= DatentypUmwandlung.doubleZuString(preisliste.getZweiTage());
			dreiTage= DatentypUmwandlung.doubleZuString(preisliste.getDreiTage());
			vierTage= DatentypUmwandlung.doubleZuString(preisliste.getVierTage());
			fuenfTage= DatentypUmwandlung.doubleZuString(preisliste.getFuenfTage());
			sechsSiebenTage= DatentypUmwandlung.doubleZuString(preisliste.getSechsSiebenTage());
			achtTage= DatentypUmwandlung.doubleZuString(preisliste.getAchtTage());
			neunTage= DatentypUmwandlung.doubleZuString(preisliste.getNeunTage());			
			zehnTage= DatentypUmwandlung.doubleZuString(preisliste.getZehnTage());
			elfTage= DatentypUmwandlung.doubleZuString(preisliste.getElfTage());
			zwoelfVierzehnTage= DatentypUmwandlung.doubleZuString(preisliste.getZwoelfVierzehnTage());
			fuenfzehnTage= DatentypUmwandlung.doubleZuString(preisliste.getFuenfzehnTage());
			sechzehnTage= DatentypUmwandlung.doubleZuString(preisliste.getSechzehnTage());
			siebzehnTage= DatentypUmwandlung.doubleZuString(preisliste.getSiebzehnTage());
			achtzehnEinundzwanzigTage= DatentypUmwandlung.doubleZuString(preisliste.getAchtzehnEinundzwanzigTage());
			tagVierWochen= DatentypUmwandlung.doubleZuString(preisliste.getTagVierWochen());
			vierWochen= DatentypUmwandlung.doubleZuString(preisliste.getVierWochen());
			achtWochen= DatentypUmwandlung.doubleZuString(preisliste.getAchtWochen());
			kauf= DatentypUmwandlung.doubleZuString(preisliste.getKauf());



			String sqlupdate = "INSERT INTO Preisliste VALUES"
					+ "(default," + eineStd + ", " + zweiStd +", " + vierStd + ", " + einenTag +
					", " + zweiTage + ", " + dreiTage +", " + vierTage + ", " + fuenfTage +", " + sechsSiebenTage +
					", " + achtTage + ", " + neunTage +", " + zehnTage + ", " + elfTage +", " + zwoelfVierzehnTage +
					", " + fuenfzehnTage + ", " + sechzehnTage +", " + siebzehnTage + ", " + achtzehnEinundzwanzigTage +", " + tagVierWochen +
					", " + vierWochen + ", " + achtWochen +", " + kauf + ")";
			

			int ergebnis = statementPreislisteAnlegenModel.executeUpdate(sqlupdate);

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

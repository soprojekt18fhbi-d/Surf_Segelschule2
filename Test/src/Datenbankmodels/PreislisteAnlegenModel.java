/**
 * @author Ben S
 */

package Datenbankmodels;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Domaenklassen.Preisliste;
import GUI.IAnlegenView;

public class PreislisteAnlegenModel implements IAnlegenModel {

	 int preislisteID;
	 double eineStd;
	 double zweiStd;
	 double vierStd;
	 double einenTag;
	 double zweiTage;
	 double dreiTage;
	 double vierTage;
	 double fuenfTage;
	 double sechsSiebenTage;
	 double achtTage;
	 double neunTage;
	 double zehnTage;
	 double elfTage;
	 double zwoelfVierzehnTage;
	 double fuenfzehnTage;
	 double sechzehnTage;
	 double siebzehnTage;
	 double achtzehnEinundzwanzigTage;
	 double tagVierWochen;
	 double vierWochen;
	 double achtWochen;
	 double kauf;

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

			preislisteID= preisliste.getPreislisteID();
			eineStd= preisliste.getEineStd();
			zweiStd= preisliste.getZweiStd();
			vierStd= preisliste.getVierStd();
			einenTag= preisliste.getEinenTag();
			zweiTage=preisliste.getZweiTage(); 
			dreiTage= preisliste.getDreiTage();
			vierTage= preisliste.getVierTage();
			fuenfTage= preisliste.getFuenfTage();
			sechsSiebenTage= preisliste.getSechsSiebenTage();
			achtTage= preisliste.getAchtTage();
			neunTage= preisliste.getNeunTage();
			zehnTage= preisliste.getZehnTage();
			elfTage= preisliste.getElfTage();
			zwoelfVierzehnTage= preisliste.getZwoelfVierzehnTage();
			fuenfzehnTage= preisliste.getFuenfzehnTage();
			sechzehnTage= preisliste.getSechzehnTage();
			siebzehnTage= preisliste.getSiebzehnTage();
			achtzehnEinundzwanzigTage= preisliste.getAchtzehnEinundzwanzigTage();
			tagVierWochen= preisliste.getTagVierWochen();
			vierWochen= preisliste.getVierWochen();
			achtWochen= preisliste.getAchtWochen();
			kauf= preisliste.getKauf();

			String sqlupdate = "INSERT INTO Preisliste VALUES"
					+ "(default,'" + preislisteID + "', '" + eineStd + "', '" + zweiStd +"', '" + vierStd + "', '" + einenTag +
					"', '" + zweiTage + "', '" + dreiTage +"', '" + vierTage + "', '" + fuenfTage +"', '" + sechsSiebenTage +
					"', '" + achtTage + "', '" + neunTage +"', '" + zehnTage + "', '" + elfTage +"', '" + zwoelfVierzehnTage +
					"', '" + fuenfzehnTage + "', '" + sechzehnTage +"', '" + siebzehnTage + "', '" + achtzehnEinundzwanzigTage +"', '" + tagVierWochen +
					"', '" + vierWochen + "', '" + achtWochen +"', '" + kauf + "',  ')";
			

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

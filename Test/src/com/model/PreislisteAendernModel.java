/**
 * @author Ben S
 */

package com.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.berechnung.DatentypUmwandlung;
import com.entity.Preisliste;
import com.view.IAnlegenView;
import com.view.PreislisteAendernGUI;

public class PreislisteAendernModel implements IAnlegenModel {

	private ArrayList<IAnlegenView> observers = new ArrayList<IAnlegenView>();

	private String talking = "first";
	private Preisliste preisliste;

	int id;
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

	public void anfrage(String talking, int id, Preisliste preisliste) {

		this.talking = talking;
		this.id = id;
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

	public void setPreislisteStrings() {
		// Strings für Abfrage initialisieren und aus den double Werten die 0.0'en
		// filtern
		eineStd = DatentypUmwandlung.doubleZuString(preisliste.getEineStd());
		zweiStd = DatentypUmwandlung.doubleZuString(preisliste.getZweiStd());
		vierStd = DatentypUmwandlung.doubleZuString(preisliste.getVierStd());
		einenTag = DatentypUmwandlung.doubleZuString(preisliste.getEinenTag());
		zweiTage = DatentypUmwandlung.doubleZuString(preisliste.getZweiTage());
		dreiTage = DatentypUmwandlung.doubleZuString(preisliste.getDreiTage());
		vierTage = DatentypUmwandlung.doubleZuString(preisliste.getVierTage());
		fuenfTage = DatentypUmwandlung.doubleZuString(preisliste.getFuenfTage());
		sechsSiebenTage = DatentypUmwandlung.doubleZuString(preisliste.getSechsSiebenTage());
		achtTage = DatentypUmwandlung.doubleZuString(preisliste.getAchtTage());
		neunTage = DatentypUmwandlung.doubleZuString(preisliste.getNeunTage());
		zehnTage = DatentypUmwandlung.doubleZuString(preisliste.getZehnTage());
		elfTage = DatentypUmwandlung.doubleZuString(preisliste.getElfTage());
		zwoelfVierzehnTage = DatentypUmwandlung.doubleZuString(preisliste.getZwoelfVierzehnTage());
		fuenfzehnTage = DatentypUmwandlung.doubleZuString(preisliste.getFuenfzehnTage());
		sechzehnTage = DatentypUmwandlung.doubleZuString(preisliste.getSechzehnTage());
		siebzehnTage = DatentypUmwandlung.doubleZuString(preisliste.getSiebzehnTage());
		achtzehnEinundzwanzigTage = DatentypUmwandlung.doubleZuString(preisliste.getAchtzehnEinundzwanzigTage());
		tagVierWochen = DatentypUmwandlung.doubleZuString(preisliste.getTagVierWochen());
		vierWochen = DatentypUmwandlung.doubleZuString(preisliste.getVierWochen());
		achtWochen = DatentypUmwandlung.doubleZuString(preisliste.getAchtWochen());

	}

	public void viewTable(Connection con) throws SQLException {

		Statement stmtPreislisteAendernModel = con.createStatement();
// 		Unterscheidung durch talking zwischen Ändern- & Löschen-Prozess mit unterschiedlichen daraus resultierenden SQL-Statements
		if (talking.equals("aendern")) {
			try {
				setPreislisteStrings();
				String sqlupdate = "UPDATE PREISLISTE SET EINESTD = " + eineStd + ", ZWEISTD =" + zweiStd
						+ " , VIERSTD = " + vierStd + " , EINENTAG = " + einenTag + " , ZWEITAGE = "
						+ zweiTage + " , DREITAGE = " + dreiTage + " , VIERTAGE = " + vierTage
						+ " , FUENFTAGE = " + fuenfTage + " , SECHSSIEBENTAGE = " + sechsSiebenTage
						+ " , ACHTTAGE = " + achtTage + " , NEUNTAGE = " + neunTage + " , ZEHNTAGE = "
						+ zehnTage + " , ELFTAGE = " + elfTage + " , ZWOELFVIERZEHNTAGE = "
						+ zwoelfVierzehnTage + " , FUENFZEHNTAGE = " + fuenfzehnTage + " , SECHZEHNTAGE = "
						+ sechzehnTage + " , SIEBZEHNTAGE = " + siebzehnTage
						+ " , ACHTZEHNEINUNDZWANZIGTAGE = " + achtzehnEinundzwanzigTage + " , TAGVIERWOCHEN = "
						+ tagVierWochen + " , VIERWOCHEN = " + vierWochen + " , ACHTWOCHEN = "
						+ achtWochen + " WHERE ID = " + id + ";";

				int resultSet = stmtPreislisteAendernModel.executeUpdate(sqlupdate);
			} catch (SQLException e1) {

				e1.printStackTrace();
			} finally {
				{
					stmtPreislisteAendernModel.close();
				}
			}
		}

		if (talking.equals("loeschen")) {
			try {
				String sqlupdate = "DELETE FROM PREISLISTE WHERE ID = " + id + ";";
				int resultSet = stmtPreislisteAendernModel.executeUpdate(sqlupdate);
			} catch (SQLException e1) {
				e1.printStackTrace();
			} finally {
				{
					stmtPreislisteAendernModel.close();
				}
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

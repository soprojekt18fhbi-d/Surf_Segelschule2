/**
 * @author Ben S
 */

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

	private ArrayList<Object> mengeAnPreislisten = new ArrayList<Object>();
	private String talking = "first";
	private double[] preisliste;

	int id;
	String preisEineStd;
	String preisZweiStd;
	String preisVierStd;
	String preisEinenTag;
	String preisZweiTage;
	String preisDreiTage;
	String preisVierTage;
	String preisFuenfTage;
	String preisSechsSiebenTage;
	String preisAchtTage;
	String preisNeunTage;
	String preisZehnTage;
	String preisElfTage;
	String preisZwoelfVierzehnTage;
	String preisFuenfzehnTage;
	String preisSechzehnTage;
	String preisSiebzehnTage;
	String preisAchtzehnEinundzwanzigTage;
	String preisTagVierWochen;
	String preisVierWochen;
	String preisAchtWochen;

	public void anfrage(String talking, int id, double[] preisliste) {

		this.talking = talking;
		this.id=id;
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

	public void setPreislisteStrings(double[] preisliste) {

		preisEineStd = DatentypUmwandlung.doubleZuString(preisliste[0]);
		preisZweiStd = DatentypUmwandlung.doubleZuString(preisliste[1]);
		preisVierStd = DatentypUmwandlung.doubleZuString(preisliste[2]);
		preisEinenTag = DatentypUmwandlung.doubleZuString(preisliste[3]);
		preisZweiTage = DatentypUmwandlung.doubleZuString(preisliste[4]);
		preisDreiTage = DatentypUmwandlung.doubleZuString(preisliste[5]);
		preisVierTage = DatentypUmwandlung.doubleZuString(preisliste[6]);
		preisFuenfTage = DatentypUmwandlung.doubleZuString(preisliste[7]);
		preisSechsSiebenTage = DatentypUmwandlung.doubleZuString(preisliste[8]);
		preisAchtTage = DatentypUmwandlung.doubleZuString(preisliste[9]);
		preisNeunTage = DatentypUmwandlung.doubleZuString(preisliste[10]);
		preisZehnTage = DatentypUmwandlung.doubleZuString(preisliste[11]);
		preisElfTage = DatentypUmwandlung.doubleZuString(preisliste[12]);
		preisZwoelfVierzehnTage = DatentypUmwandlung.doubleZuString(preisliste[13]);
		preisFuenfzehnTage = DatentypUmwandlung.doubleZuString(preisliste[14]);
		preisSechzehnTage = DatentypUmwandlung.doubleZuString(preisliste[15]);
		preisSiebzehnTage = DatentypUmwandlung.doubleZuString(preisliste[16]);
		preisAchtzehnEinundzwanzigTage = DatentypUmwandlung.doubleZuString(preisliste[17]);
		preisTagVierWochen = DatentypUmwandlung.doubleZuString(preisliste[18]);
		preisVierWochen = DatentypUmwandlung.doubleZuString(preisliste[19]);
		preisAchtWochen = DatentypUmwandlung.doubleZuString(preisliste[20]);

	}

	public void viewTable(Connection con)
		    throws SQLException {
		
	    Statement stmtPreislisteAendernModel = con.createStatement();
		
		if(talking.equals("aendern"))
		{
			try {
				setPreislisteStrings(preisliste);
				String sqlupdate = "UPDATE PREISLISTE SET EINESTD = "+preisEineStd+", ZWEISTD =" +preisZweiStd
						+ " , VIERSTD = "+preisVierStd+" , EINENTAG = "+preisEinenTag+ " , ZWEITAGE = "+preisZweiTage
						+ " , DREITAGE = "+preisDreiTage+ " , VIERTAGE = "+preisVierTage+ " , FUENFTAGE = "+preisFuenfTage
						+ " , SECHSSIEBENTAGE = "+preisSechsSiebenTage+ " , ACHTTAGE = "+preisAchtTage+ " , NEUNTAGE = "+preisNeunTage
						+ " , ZEHNTAGE = "+preisZehnTage+ " , ELFTAGE = "+preisElfTage+ " , ZWOELFVIERZEHNTAGE = "+preisZwoelfVierzehnTage
						+ " , FUENFZEHNTAGE = "+preisFuenfzehnTage+ " , SECHZEHNTAGE = "+preisSechzehnTage+ " , SIEBZEHNTAGE = "+preisSiebzehnTage
						+ " , ACHTZEHNEINUNDZWANZIGTAGE = "+preisAchtzehnEinundzwanzigTage+ " , TAGVIERWOCHEN = "+preisTagVierWochen
						+ " , VIERWOCHEN = "+preisVierWochen+ " , ACHTWOCHEN = "+preisAchtWochen
						+ " WHERE ID = "+id+";";
			
					int resultSet = stmtPreislisteAendernModel.executeUpdate(sqlupdate);		
				}
			 catch (SQLException e1) {
				e1.printStackTrace();
			} finally {
				{ stmtPreislisteAendernModel.close(); }
			}
		}
		
		if(talking.equals("loeschen"))
		{
			try {
				setPreislisteStrings(preisliste);
					String sqlupdate = "DELETE FROM PREISLISTE WHERE ID = "+id+";";
					int resultSet = stmtPreislisteAendernModel.executeUpdate(sqlupdate);		
				}
			 catch (SQLException e1) {
				e1.printStackTrace();
			} finally {
				{ stmtPreislisteAendernModel.close(); }
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

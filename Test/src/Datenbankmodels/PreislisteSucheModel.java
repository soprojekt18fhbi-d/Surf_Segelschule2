package Datenbankmodels;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.DefaultListModel;

import Domaenklassen.Preisliste;
import GUI.IView;



public class PreislisteSucheModel implements IModel{

	private ArrayList<IView> observers = new ArrayList<IView>();

	private int preislisteNr = 0;

	private ArrayList<Preisliste> mengeAnPreislisten = new ArrayList<Preisliste>();

	public void holePreisliste() {

		try {
			Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "sa");
			// add application code here
			viewTable(conn);

			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		updateObserver();
	}

	public void viewTable(Connection con) throws SQLException {

		Statement stmt = null;
		String query = "select * from PREISLISTE";
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {

				preislisteNr = preislisteNr++;
				
				
				String preislisteID= rs.getString("ID");
				String eineStd= rs.getString("EineStd");
				String zweiStd= rs.getString("ZweiStd");
				String vierStd= rs.getString("VierStd");
				String einenTag= rs.getString("EinenTag");
				String zweiTage= rs.getString("ZweiTage");
				String dreiTage= rs.getString("DreiTage");
				String vierTage= rs.getString("VierTage");
				String fuenfTage= rs.getString("FuenfTage");
				String sechsSiebenTage= rs.getString("SechsSiebenTage");
				String achtTage= rs.getString("AchtTage");
				String neunTage= rs.getString("NeunTage");
				String nehnTage= rs.getString("ZehnTage");
				String elfTage= rs.getString("ElfTage");
				String zwoelfVierzehnTage= rs.getString("ZwoelfVierzehnTage");
				String fuenfzehnTage= rs.getString("FuenfzehnTage");
				String sechzehnTage= rs.getString("SechzehnTage");
				String siebzehnTage= rs.getString("SiebzehnTage");
				String achtzehnEinundzwanzigTage= rs.getString("AchtzehnEinundzwanzigTage");
				String tagVierWochen= rs.getString("TagVierWochen");
				String VierWochen= rs.getString("VierWochen");

				
				
				
				Preisliste preislisteNr = new Preisliste(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
				mengeAnPreislisten.add(preislisteNr);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}

	}

	@Override
	public void anmelden(IView view) {

		try {
			observers.add(view);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void abmelden(IView view) {

		try {
			if (observers.contains(view))
				;
			observers.remove(view);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void updateObserver() {
		/**
		 * updaten der Views
		 * 
		 * @author Benkr
		 * 
		 */
		try {
			for (int i = 0; i < observers.size(); ++i)
				observers.get(i).aktualisieren(this);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public DefaultListModel getPreislisten() {

		DefaultListModel<String> listmodel = new DefaultListModel<String>();

		for (int i = 0; i < mengeAnPreislisten.size(); i++) {
			listmodel.addElement(mengeAnPreislisten.get(i).getEineStd()+
					", " + mengeAnPreislisten.get(i).getZweiStd()+
					", "+ mengeAnPreislisten.get(i).getVierStd()+
					", "+ mengeAnPreislisten.get(i).getEinenTag()+
					", "+ mengeAnPreislisten.get(i).getZweiTage()+
					", "+ mengeAnPreislisten.get(i).getDreiTage()+
					", "+ mengeAnPreislisten.get(i).getVierTage()+
					", "+ mengeAnPreislisten.get(i).getFuenfTage()+
					", "+ mengeAnPreislisten.get(i).getSechsSiebenTage()+
					", "+ mengeAnPreislisten.get(i).getAchtTage()+
					", "+ mengeAnPreislisten.get(i).getZehnTage()+
					", "+ mengeAnPreislisten.get(i).getElfTage()+
					", "+ mengeAnPreislisten.get(i).getZwoelfVierzehnTage()+
					", "+ mengeAnPreislisten.get(i).getFuenfzehnTage()+
					", "+ mengeAnPreislisten.get(i).getSechzehnTage()+
					", "+ mengeAnPreislisten.get(i).getSiebzehnTage()+
					", "+ mengeAnPreislisten.get(i).getAchtzehnEinundzwanzigTage()+
					", "+ mengeAnPreislisten.get(i).getTagVierWochen()+
					", "+ mengeAnPreislisten.get(i).getVierWochen()+
					", "+ mengeAnPreislisten.get(i).getAchtWochen()+
					", "+ mengeAnPreislisten.get(i).getKauf()
			);
		}
		return listmodel;

	}

	@Override
	public DefaultListModel holeModel() {
		// TODO Auto-generated method stub
		return null;
	}


	
}

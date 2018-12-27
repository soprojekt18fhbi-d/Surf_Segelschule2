/**
 * @author Ben S
 */

package Datenbankmodels;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.table.TableModel;

import Domaenklassen.Preisliste;
import GUI.IObjektView;
import net.proteanit.sql.DbUtils;

public class PreislisteSucheModel implements IObjektModel {

	private ArrayList<IObjektView> observers = new ArrayList<IObjektView>();
	private ArrayList<Object> mengeAnPreislisten = new ArrayList<Object>();
	private int preislisteNr = 0;
	private TableModel tableModel;
	private String talking = "master";
	private String suchTxt;

	@Override
	public void anmelden(IObjektView view) {

		try {
			observers.add(view);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void abmelden(IObjektView view) {
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

	public void holeDaten(String talking, String suchTxt) {

		this.talking = talking;
		this.suchTxt = suchTxt;
		System.out.println(suchTxt);
		System.out.println(talking);

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

	public void viewTable(Connection conn) throws SQLException {

		Statement stmt = conn.createStatement();
		String query = "TestQuery";
		System.out.println(query);

//		if (talking.equals("master")) {
			if (suchTxt.equals(""))
				query = "SELECT * FROM PREISLISTE";
			else  
				query = "SELECT * FROM PREISLISTE WHERE ID LIKE '%" + suchTxt + "%'";
//		}

		try {
			stmt = conn.createStatement();
			
			System.out.println(query);
			
			ResultSet rs = stmt.executeQuery(query);
			tableModel = DbUtils.resultSetToTableModel(rs);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}

		// String preislisteID= rs.getString("ID");
		// String eineStd= rs.getString("EineStd");
		// String zweiStd= rs.getString("ZweiStd");
		// String vierStd= rs.getString("VierStd");
		// String einenTag= rs.getString("EinenTag");
		// String zweiTage= rs.getString("ZweiTage");
		// String dreiTage= rs.getString("DreiTage");
		// String vierTage= rs.getString("VierTage");
		// String fuenfTage= rs.getString("FuenfTage");
		// String sechsSiebenTage= rs.getString("SechsSiebenTage");
		// String achtTage= rs.getString("AchtTage");
		// String neunTage= rs.getString("NeunTage");
		// String zehnTage= rs.getString("ZehnTage");
		// String elfTage= rs.getString("ElfTage");
		// String zwoelfVierzehnTage= rs.getString("ZwoelfVierzehnTage");
		// String fuenfzehnTage= rs.getString("FuenfzehnTage");
		// String sechzehnTage= rs.getString("SechzehnTage");
		// String siebzehnTage= rs.getString("SiebzehnTage");
		// String achtzehnEinundzwanzigTage= rs.getString("AchtzehnEinundzwanzigTage");
		// String tagVierWochen= rs.getString("TagVierWochen");
		// String VierWochen= rs.getString("VierWochen");

	}

	public ArrayList<Object> getObjekte() {

		return mengeAnPreislisten;


	}

	public TableModel getTableModel() {
		return tableModel;
	}

}

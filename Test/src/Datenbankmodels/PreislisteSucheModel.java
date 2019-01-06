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
			Connection conn = DBConnectorSingleton.getCon();
			// add application code here
			viewTable(conn);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		updateObserver();
	}

	public void viewTable(Connection conn) throws SQLException {

		Statement stmtPreislisteSucheModel = conn.createStatement();
		String query = "TestQuery";
		System.out.println(query);

//		if (talking.equals("master")) {
			if (suchTxt.equals(""))
				query = "SELECT * FROM PREISLISTE";
			else  
				query = "SELECT * FROM PREISLISTE WHERE ID LIKE '%" + suchTxt + "%'";
//		}

		try {
			stmtPreislisteSucheModel = conn.createStatement();
			
			System.out.println(query);
			
			ResultSet rs = stmtPreislisteSucheModel.executeQuery(query);
			tableModel = DbUtils.resultSetToTableModel(rs);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		



	}

	public ArrayList<Object> getObjekte() {

		return mengeAnPreislisten;


	}

	public TableModel getTableModel() {
		return tableModel;
	}

}

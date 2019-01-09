package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ComboBoxModel;
import javax.swing.table.TableModel;

import com.entity.IAdresse;
import com.view.IObjektView;
import com.view.IWirtschaftlichkeitView;

public class WirtschaftlichkeitModel implements IWirtschaftlichkeitModel { // Ben Kröncke

	private ArrayList<IWirtschaftlichkeitView> observers = new ArrayList<IWirtschaftlichkeitView>();
	private ArrayList<String> cboxStrings = new ArrayList<String>();
	private String mode = "";
	private String talking = "";
	private double income = 0;
	private double expenses = 0;
	private int specialID = 0;
	private String givenString = "";
	ArrayList<Integer> geraete = new ArrayList<Integer>();

	public void holeDaten(String talking2, String mode2, int id2, String giveString) {

		talking = talking2;
		mode = mode2;
		specialID = id2;
		givenString = giveString;

		try {

			this.talking = talking2;
			Connection conn = DBConnectorSingleton.getCon();

			viewTable(conn);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		updateObserver();
	}

	public void viewTable(Connection con) throws SQLException {

		Statement stmtWirtschaftlichkeitModel = con.createStatement();
		String queryIncome = "SELECT SUMME FROM RECHNUNG WHERE REPARATURID IS NULL";
		String queryExpensesDevices = "SELECT ANSCHAFFUNGSPREIS FROM SPORTGERAET";
		String queryExpensesRepair = "SELECT SUMME FROM RECHNUNG WHERE REPARATURID IS NOT NULL";
		String query = "";
		cboxStrings.clear();
		income = 0;
		expenses = 0;

		try {

			if (talking.equals("category")) {
				if (mode.equals("Sportgeraet") || mode.equals("Unternehmen")) {
					// Wird in GUI geklärt ID wird eingegeben
				} else {
					query = "SELECT NAME FROM " + mode;
					ResultSet rs = stmtWirtschaftlichkeitModel.executeQuery(query);
					while (rs.next()) {
						cboxStrings.add(rs.getString("NAME"));
					}
				}
			}

			if (talking.equals("calc")) {
				if (mode.equals("Unternehmen")) {
					calcExpInc(stmtWirtschaftlichkeitModel, queryIncome, queryExpensesDevices, queryExpensesRepair,
							"SUMME");
				}
				if (mode.equals("Standort")) {

					starteBerechnung(stmtWirtschaftlichkeitModel);

					motiviereGeraete(stmtWirtschaftlichkeitModel);

					incomeGeraete(stmtWirtschaftlichkeitModel);

					expensesGeraete(stmtWirtschaftlichkeitModel);

				}
				if (mode.equals("Typ")) {
					starteBerechnung(stmtWirtschaftlichkeitModel);

					motiviereGeraete(stmtWirtschaftlichkeitModel);

					incomeGeraete(stmtWirtschaftlichkeitModel);

					expensesGeraete(stmtWirtschaftlichkeitModel);

				}
				if (mode.equals("Modell")) {
					starteBerechnung(stmtWirtschaftlichkeitModel);

					motiviereGeraete(stmtWirtschaftlichkeitModel);

					incomeGeraete(stmtWirtschaftlichkeitModel);

					expensesGeraete(stmtWirtschaftlichkeitModel);
				}
				if (mode.equals("Sportgeraet")) {
					queryIncome = "SELECT RECHNUNG.SUMME FROM RECHNUNG, BUCHUNG WHERE BUCHUNG.ID = RECHNUNG.BUCHUNGID AND RECHNUNG.REPARATURID IS NULL AND BUCHUNG.SPORTGERAETID = "
							+ specialID;
					queryExpensesDevices = "SELECT ANSCHAFFUNGSPREIS FROM SPORTGERAET WHERE ID = " + specialID;
					queryExpensesRepair = "SELECT KOSTEN FROM REPARATUR WHERE SPORTGERAETID = " + specialID;

					calcExpInc(stmtWirtschaftlichkeitModel, queryIncome, queryExpensesDevices, queryExpensesRepair,
							"KOSTEN");
				}

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmtWirtschaftlichkeitModel != null) {
				stmtWirtschaftlichkeitModel.close();
			}
		}

	}

	private void expensesGeraete(Statement stmt) throws SQLException {
		for (int i = 0; i < geraete.size(); i++) {
			String query4 = "SELECT KOSTEN FROM REPARATUR WHERE SPORTGERAETID = " + geraete.get(i);
			ResultSet rs4 = stmt.executeQuery(query4);
			while (rs4.next()) {
				expenses += rs4.getDouble("KOSTEN");

			}
		}
	}

	private void incomeGeraete(Statement stmt) throws SQLException {
		for (int i = 0; i < geraete.size(); i++) {
			String query3 = "SELECT RECHNUNG.SUMME FROM RECHNUNG, BUCHUNG WHERE BUCHUNG.ID = RECHNUNG.BUCHUNGID AND RECHNUNG.REPARATURID IS NULL AND BUCHUNG.SPORTGERAETID = "
					+ geraete.get(i);
			ResultSet rs3 = stmt.executeQuery(query3);
			while (rs3.next()) {
				income += rs3.getDouble("SUMME");
			}
		}
	}

	private void motiviereGeraete(Statement stmt) throws SQLException {
		String queryGetDevice = "SELECT ID,ANSCHAFFUNGSPREIS FROM SPORTGERAET WHERE " + mode + "ID = " + specialID;

		ResultSet rs2 = stmt.executeQuery(queryGetDevice);

		while (rs2.next()) {
			geraete.add(rs2.getInt("ID"));
			expenses += rs2.getDouble("ANSCHAFFUNGSPREIS");

		}
	}

	private void starteBerechnung(Statement stmt) throws SQLException {
		String query;
		geraete.clear();

		query = "SELECT ID FROM " + mode + " WHERE NAME = '" + givenString + "'";

		ResultSet rs = stmt.executeQuery(query);

		while (rs.next())
			specialID = rs.getInt("ID");
	}

	private void calcExpInc(Statement stmt, String queryIncome, String queryExpensesDevices, String queryExpensesRepair,
			String uebergabe) throws SQLException {
		ResultSet rs = stmt.executeQuery(queryIncome);
		while (rs.next()) {
			income += rs.getDouble("SUMME");
			System.out.println(income);
		}

		rs = stmt.executeQuery(queryExpensesDevices);
		while (rs.next()) {
			expenses += rs.getDouble("ANSCHAFFUNGSPREIS");
			System.out.println(expenses);
		}

		rs = stmt.executeQuery(queryExpensesRepair);
		while (rs.next()) {
			expenses += rs.getDouble(uebergabe);
			System.out.println(expenses);
		}
	}

	@Override
	public void anmelden(IWirtschaftlichkeitView view) {
		// TODO Auto-generated method stub
		try {
			observers.add(view);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void abmelden(IWirtschaftlichkeitView view) {
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
	public double getIncome() {
		// TODO Auto-generated method stub
		return income;
	}

	@Override
	public double getExpenses() {
		// TODO Auto-generated method stub
		return expenses;
	}

	@Override
	public ArrayList<String> getStrings() {
		// TODO Auto-generated method stub
		return cboxStrings;

	}

}

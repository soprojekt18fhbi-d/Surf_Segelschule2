package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.DefaultListModel;

import com.entity.IAdresse;
import com.entity.IKunde;
import com.view.IView;

public class KundeAnlegenModel implements IModel {

	private String vorname;
	private String name;
	private String email;
	private int kNr;

	@Override
	public void anmelden(IView view) {
		/**
		 * Anmelden einer View
		 * 
		 * @author Benkr
		 * 
		 */

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
	public void abmelden(IView view) {
		/**
		 * Abmelden einer View.
		 * 
		 * @author Benkr
		 * 
		 */

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

	public void kundeAnlegen(IKunde kunde) {

		try {
			Connection conn = DBConnectorSingleton.getCon();

			Statement kundeAnlegenModel = conn.createStatement();

			name = kunde.getName();
			vorname = kunde.getVorname();
			email = kunde.getEmail();
			boolean surfs = kunde.getSurfschein();
			boolean segels = kunde.getSegelschein();
			boolean motorboots = kunde.getMotorbootschein();
			String surfschein = "N";
			String segelschein = "N";
			String motorbootschein = "N";
			if (surfs == true)
				surfschein = "J";
			if (segels == true)
				segelschein = "J";
			if (motorboots == true)
				motorbootschein = "J";

			String sqlupdate = "INSERT INTO KUNDE " + "VALUES (default, " + "'" + vorname + "', '" + name + "', '"
					+ email + "', 'N', '" + segelschein + "', '" + motorbootschein + "', '" + surfschein + "')";

			int ergebnis = kundeAnlegenModel.executeUpdate(sqlupdate);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			updateObserver();

		}
	}

	// DK
	public void AdresseAnlegen(IAdresse adresse) {

		try {
			Connection conn = DBConnectorSingleton.getCon();

			Statement statement = conn.createStatement();

			String ort = adresse.getOrt();
			int plz = adresse.getPlz();
			String hausnummer = adresse.getHausnummer();
			String strasse = adresse.getStrasse();
			String art = adresse.getArt();

			String query = "SELECT ID FROM KUNDE WHERE NACHNAME = '" + name + "' AND EMAIL = '" + email
					+ "' AND vorname = '" + vorname + "'";

			ResultSet rs = statement.executeQuery(query);

			while (rs.next()) {
				kNr = rs.getInt("ID");
			}

			String sqlupdate = "INSERT INTO ADRESSE " + "VALUES (default, " + "'" + plz + "', '" + strasse + "', '"
					+ ort + "', '" + art + "', '" + hausnummer + "', " + kNr + ")";

			int ergebnis = statement.executeUpdate(sqlupdate);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			updateObserver();

		}
	}

	@Override
	public DefaultListModel holeModel() {
		// TODO Auto-generated method stub
		return null;
	}

}

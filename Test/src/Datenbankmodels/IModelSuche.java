package Datenbankmodels;

import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.DefaultListModel;

import GUI.IView;

public interface IModelSuche extends IModel {

	void holeDaten(String kdID, String nname, String vname, String plz, String ort, String strasse, String hausnr);

	void viewTable(Connection con, String kdID, String nname, String vname, String plz, String ort, String strasse,
			String hausnr) throws SQLException;

	DefaultListModel holeModel();

	void anmelden(IView view);

	void abmelden(IView view);

	void updateObserver();

}
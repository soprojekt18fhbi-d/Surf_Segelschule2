package Datenbankmodels;

import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.DefaultListModel;

import GUI.IObjektView;
import GUI.IView;

//Interface, dass für Klassen gedacht ist, die Daten auslesen und anzeigen wollen


public interface IModelSuche extends IModel {

	void holeDaten(String kdID, String nname, String vname, String plz, String ort, String strasse, String hausnr);

	void viewTable(Connection con, String kdID, String nname, String vname, String plz, String ort, String strasse,
			String hausnr) throws SQLException;

	DefaultListModel holeModel();

	void anmelden(IView view);
	
	void anmelden(IObjektView view);

	void abmelden(IView view);
	
	void abmelden(IObjektView view);

	void updateObserver();

}
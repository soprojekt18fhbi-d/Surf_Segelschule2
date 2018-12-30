package Datenbankmodels;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.table.TableModel;

import GUI.IObjektView;
import GUI.IView;

//Interface, dass f�r Klassen gedacht ist, die Daten auslesen und anzeigen wollen

public interface IObjektModel {

	
	/**
	 * ArrayList f�r M�glichkeit der Aufnahme mehrerer Observer(Views)
	 * 
	 * 
	 */
	public ArrayList<IView> observers = new ArrayList<IView>();
	
	
	
	/**
	 * Anmelden einer View.
	 * 
	 *
	 */
	public void anmelden(IObjektView view);

	/**
	 * Abmelden einer View.
	 * 
	 * 
	 */
	public void abmelden(IObjektView view);
	
	
	/**
	 * Durchgehen der Observer und Updateaufruf.
	 * 
	 *
	 */
	public void updateObserver();


	public ArrayList<Object> getObjekte();

	public TableModel getTableModel();

	
}
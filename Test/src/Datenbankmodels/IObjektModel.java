package Datenbankmodels;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.table.TableModel;

import GUI.IObjektView;
import GUI.IView;



public interface IObjektModel {

	
	/**
	 * ArrayList für Möglichkeit der Aufnahme mehrerer Observer(Views)
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
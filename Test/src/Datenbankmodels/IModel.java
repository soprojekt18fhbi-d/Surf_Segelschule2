package Datenbankmodels;

import java.util.ArrayList;

import javax.swing.DefaultListModel;

import GUI.IView;



public interface IModel {

	
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
	public void anmelden(IView view);

	/**
	 * Abmelden einer View.
	 * 
	 * 
	 */
	public void abmelden(IView view);
	
	
	/**
	 * Durchgehen der Observer und Updateaufruf.
	 * 
	 *
	 */
	public void updateObserver();
	

	
	
}

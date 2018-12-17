package Datenbankmodels;

import java.util.ArrayList;

import javax.swing.table.TableModel;

import GUI.IObjektView;
import GUI.IStandortView;
import GUI.IView;

public interface IStandortModel {

	/**
	 * ArrayList für Möglichkeit der Aufnahme mehrerer Observer(Views)
	 * 
	 * 
	 */
	public ArrayList<IStandortView> observers = new ArrayList<IStandortView>();
	
	
	
	/**
	 * Anmelden einer View.
	 * 
	 *
	 */
	public void anmelden(IStandortView view);

	/**
	 * Abmelden einer View.
	 * 
	 * 
	 */
	public void abmelden(IStandortView view);
	
	
	/**
	 * Durchgehen der Observer und Updateaufruf.
	 * 
	 *
	 */
	public void updateObserver();




	public boolean pruefen();
	
	
}
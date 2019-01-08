package com.model;

import java.util.ArrayList;

import javax.swing.table.TableModel;

import com.view.IObjektView;
import com.view.IStandortView;
import com.view.IView;

//Spezielles Interface, dass für die Standortklasse gedacht ist, da diese mit Passwörten arbeitet dachte ich es wäre klüger für diese Klasse ein neues Interface zu entwerfen, dass unter umständen später erweitert
//werden kann für weitere Operationen dieser Art, falls die Software weiterentwickelt wird

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
package com.model;

import java.util.ArrayList;

import javax.swing.table.TableModel;

import com.view.IObjektView;
import com.view.IStandortView;
import com.view.IView;

//Spezielles Interface, dass f�r die Standortklasse gedacht ist, da diese mit Passw�rten arbeitet dachte ich es w�re kl�ger f�r diese Klasse ein neues Interface zu entwerfen, dass unter umst�nden sp�ter erweitert
//werden kann f�r weitere Operationen dieser Art, falls die Software weiterentwickelt wird

public interface IStandortModel {

	/**
	 * ArrayList f�r M�glichkeit der Aufnahme mehrerer Observer(Views)
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
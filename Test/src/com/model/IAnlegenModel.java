package com.model;

import java.util.ArrayList;

import com.view.IAnlegenView;

//Model F�r Klassen, die haupts�chlich Entit�ten in der Datenbank einpflegen wollen

public interface IAnlegenModel {

	/**
	 * ArrayList f�r M�glichkeit der Aufnahme mehrerer Observer(Views)
	 * 
	 * 
	 */
	public ArrayList<IAnlegenView> observers = new ArrayList<IAnlegenView>();

	/**
	 * Anmelden einer View.
	 * 
	 *
	 */
	public void anmelden(IAnlegenView view);

	/**
	 * Abmelden einer View.
	 * 
	 * 
	 */
	public void abmelden(IAnlegenView view);

	/**
	 * Durchgehen der Observer und Updateaufruf.
	 * 
	 *
	 */
	public void updateObserver();

	/**
	 * Werte f�r Comboboxen bei Ger�ten
	 * 
	 */
	public ArrayList<String> getObertypen();

}
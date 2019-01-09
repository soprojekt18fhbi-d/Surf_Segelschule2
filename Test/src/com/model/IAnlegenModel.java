package com.model;

import java.util.ArrayList;

import com.view.IAnlegenView;

//Model Für Klassen, die hauptsächlich Entitäten in der Datenbank einpflegen wollen

public interface IAnlegenModel {

	/**
	 * ArrayList für Möglichkeit der Aufnahme mehrerer Observer(Views)
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
	 * Werte für Comboboxen bei Geräten
	 * 
	 */
	public ArrayList<String> getObertypen();

}
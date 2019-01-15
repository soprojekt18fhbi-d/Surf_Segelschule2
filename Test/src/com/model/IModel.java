package com.model;

import java.util.ArrayList;

import javax.swing.DefaultListModel;

import com.view.IView;

//Generelles Interface f�r Klassen, die andere Interfaces nicht verwenden k�nnen, da ihre Aufgabe in anderen Bereichen liegt.

public interface IModel {// Ben Kr�ncke

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

	DefaultListModel holeModel();

}

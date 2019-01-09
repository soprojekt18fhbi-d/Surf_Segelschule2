package com.model;

import java.util.ArrayList;

import javax.swing.ComboBoxModel;

import com.view.IWirtschaftlichkeitView;

//Interface, dass den Beobachtern auch erm�glicht, auf die jeweiligen Wirtschaftlichkeitswerte aus dem Model zuzugreifen

public interface IWirtschaftlichkeitModel { // Ben Kr�ncke

	/**
	 * ArrayList f�r M�glichkeit der Aufnahme mehrerer Observer(Views)
	 * 
	 * 
	 */
	public ArrayList<IWirtschaftlichkeitView> observers = new ArrayList<IWirtschaftlichkeitView>();

	/**
	 * Anmelden einer View.
	 * 
	 *
	 */
	public void anmelden(IWirtschaftlichkeitView view);

	/**
	 * Abmelden einer View.
	 * 
	 * 
	 */
	public void abmelden(IWirtschaftlichkeitView view);

	/**
	 * Durchgehen der Observer und Updateaufruf.
	 * 
	 *
	 */
	public void updateObserver();

	public double getIncome();

	public double getExpenses();

	public ArrayList<String> getStrings();

}

package com.model;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.table.TableModel;

import com.view.IObjektView;
import com.view.IView;

//Interface, dass für Klassen gedacht ist, die Daten auslesen und anzeigen wollen

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
package Datenbankmodels;

import java.util.ArrayList;

import javax.swing.ComboBoxModel;

import GUI.IWirtschaftlichkeitView;

public interface IWirtschaftlichkeitModel { //Ben Kröncke
		
		/**
		 * ArrayList für Möglichkeit der Aufnahme mehrerer Observer(Views)
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

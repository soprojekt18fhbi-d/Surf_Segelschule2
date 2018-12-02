package Steuerung;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import Datenbankmodels.GeraetAnzeigeModel;
import GUI.IView;

/**
 * 
 * @author michi
 *
 */
public class GeraetAnzeigeStrg {

	private GeraetAnzeigeModel model;
	private IView view;
	
	public GeraetAnzeigeStrg(GeraetAnzeigeModel smodel)
	{
		model = smodel;
		
	}
	
	public DefaultListModel<String> geraeteAnzeigen(){
		DefaultListModel<String> dlm = new DefaultListModel<String>();
		ArrayList<String> geraetListe;
		geraetListe = model.geraeteHolen();
		
		for (String ausgabe: geraetListe){
			dlm.addElement(ausgabe);
		}
		return dlm;
	}

}

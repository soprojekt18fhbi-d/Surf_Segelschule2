package Steuerung;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import Datenbankmodels.TypAnzeigeModel;
import GUI.IView;

/**
 * 
 * @author michi
 *
 */
public class TypAnzeigeStrg {
	
	private TypAnzeigeModel model;
	private IView view;
	
	public TypAnzeigeStrg(TypAnzeigeModel smodel)
	{
		model = smodel;
		
	}
	
	public DefaultListModel<String> typenAnzeigen(){
		DefaultListModel<String> dlm = new DefaultListModel<String>();
		ArrayList<String> typListe;
		typListe = model.typenHolen();
		
		for (String ausgabe: typListe){
			dlm.addElement(ausgabe);
		}
		return dlm;
	}
}

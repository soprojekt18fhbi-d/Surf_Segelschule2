package Steuerung;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import Datenbankmodels.ModellAnzeigeModel;
import GUI.IView;

/**
 * 
 * @author michi
 *
 */
public class ModellAnzeigeStrg {

	private ModellAnzeigeModel model;
	private IView view;
	
	public ModellAnzeigeStrg (ModellAnzeigeModel smodel)
	{
		model = smodel;
		
	}
	
	public DefaultListModel<String> modelleAnzeigen(){
		DefaultListModel<String> dlm = new DefaultListModel<String>();
		ArrayList<String> modellListe;
		modellListe = model.modelleHolen();
		
		for (String ausgabe: modellListe){
			dlm.addElement(ausgabe);
		}
		return dlm;
	}
}

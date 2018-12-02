package Steuerung;

import java.util.ArrayList;

import javax.swing.DefaultListModel;

import Datenbankmodels.AusleiheAnlegenModel;
import Domaenklassen.Buchung;
import GUI.IView;

public class AusleihAnlegenStrg extends BuchungAnlegenStrg {
	
	/**
	 * @author michi
	 *
	 */
	private Buchung buchung;
	private AusleiheAnlegenModel model;
	private IView view;
	
	public AusleihAnlegenStrg(AusleiheAnlegenModel smodel)
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
	
	public DefaultListModel<String> modelleAnzeigen(){
		DefaultListModel<String> dlm = new DefaultListModel<String>();
		ArrayList<String> modellListe;
		modellListe = model.modelleHolen();
		
		for (String ausgabe: modellListe){
			dlm.addElement(ausgabe);
		}
		return dlm;
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

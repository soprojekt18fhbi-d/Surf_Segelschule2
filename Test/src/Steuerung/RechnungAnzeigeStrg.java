package Steuerung;

import java.util.ArrayList;

import javax.swing.DefaultListModel;

import Datenbankmodels.RechnungAnzeigenModel;
import GUI.IObjektView;


/**
 * 
 * @author Darnel
 *
 */
public class RechnungAnzeigeStrg implements IController{
	
	private RechnungAnzeigenModel model;
	private IObjektView view;
	private String search;
	

	
	public RechnungAnzeigeStrg(RechnungAnzeigenModel smodel)
	{
		model = smodel;
		
	}
	

	
	public void getRechnungenSuche(String search) {
		
		model.holeDatenSuche(search);
		
	}
	
	public void getRechnungen() {
		
		model.holeDaten();
		
		
	}
}

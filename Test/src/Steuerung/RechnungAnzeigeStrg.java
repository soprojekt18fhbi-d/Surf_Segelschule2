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
	

	
	public RechnungAnzeigeStrg(RechnungAnzeigenModel smodel)
	{
		model = smodel;
		
	}
	

	
	public void fetchRechnungen(String search) {
		
		model.holeRechnungen(search);
		
	}
	
	public void getRechnungen(String search) {
		
		model.holeDaten(search);
		
		
	}
}

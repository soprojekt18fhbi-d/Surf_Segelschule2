package Steuerung;

import java.util.ArrayList;

import javax.swing.DefaultListModel;

import Datenbankmodels.BuchungModellAnzeigeModel;
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
	

	
	public void fetchRechnungen(String talking, int rechnungsNr, String search) {
		
		model.holeRechnungen(talking, rechnungsNr, search);
		
		
	}
}

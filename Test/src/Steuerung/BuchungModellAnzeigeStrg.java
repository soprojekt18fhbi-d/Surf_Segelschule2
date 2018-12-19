package Steuerung;

import java.util.ArrayList;

import javax.swing.DefaultListModel;

import Datenbankmodels.BuchungModellAnzeigeModel;
import GUI.IObjektView;


/**
 * 
 * @author michi
 *
 */
public class BuchungModellAnzeigeStrg implements IController{
	
	private BuchungModellAnzeigeModel model;
	private IObjektView view;
	
	public BuchungModellAnzeigeStrg(BuchungModellAnzeigeModel smodel)
	{
		model = smodel;
		
	}
	

	
	public void fetchModelle(String talking, int typNr, String search) {
		
		model.holeModelle(talking, typNr, search);
		
		
	}
}

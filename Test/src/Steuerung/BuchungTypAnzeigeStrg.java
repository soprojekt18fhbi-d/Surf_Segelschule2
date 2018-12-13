package Steuerung;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import Datenbankmodels.BuchungTypAnzeigeModel;
import Domaenklassen.IKunde;
import GUI.IObjektView;

/**
 * 
 * @author michi
 *
 */
public class BuchungTypAnzeigeStrg implements IController{
	
	private BuchungTypAnzeigeModel model;
	private IObjektView view;
	
	public BuchungTypAnzeigeStrg(BuchungTypAnzeigeModel smodel)
	{
		model = smodel;
		
	}
	

	
	public void fetchTypen(int knr, String talking, String searchtxt, IKunde kunde) {
		
		model.holeTypen(knr, talking, searchtxt, kunde);
		
		
	}
}

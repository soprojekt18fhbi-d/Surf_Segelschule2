package Steuerung;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import Datenbankmodels.TypAnzeigeModel;
import GUI.IObjektView;

/**
 * 
 * @author michi
 *
 */
public class TypAnzeigeStrg implements IController{
	
	private TypAnzeigeModel model;
	private IObjektView view;
	
	public TypAnzeigeStrg(TypAnzeigeModel smodel)
	{
		model = smodel;
		
	}
	

	
	public void fetchTypen() {
		
		model.holeTypen();
		
		
	}
}

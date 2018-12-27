package Steuerung;

import java.util.ArrayList;

import javax.swing.DefaultListModel;

import Datenbankmodels.BuchungModellSucheModel;
import GUI.IObjektView;


/**
 * 
 * @author michi
 *
 */
public class BuchungModellSucheStrg implements IController{
	
	private BuchungModellSucheModel model;
	private IObjektView view;
	
	public BuchungModellSucheStrg(BuchungModellSucheModel smodel)
	{
		model = smodel;
		
	}
	

	
	public void fetchModelle(String talking, int typNr, String search) {
		
		model.holeModelle(talking, typNr, search);
		
		
	}



	@Override
	public void anfrage() {
		// TODO Auto-generated method stub
		
	}
}

package Steuerung;

import Datenbankmodels.PreislisteSucheModel;
import GUI.PreislisteGUI;


public class PreislisteSucheStrg {

	
	private PreislisteSucheModel model;
	private PreislisteGUI view;
	
	public PreislisteSucheStrg(PreislisteSucheModel smodel)
	{
		model = smodel;
		
	}
	
	public void fetchObjekte(int preislisteId, String talking, String suchTxt) {
		
		model.holeDaten(preislisteId, talking, suchTxt);
		
		
	}
}

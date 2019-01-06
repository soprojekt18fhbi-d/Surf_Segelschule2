/**
 * @author Ben S
 */

package Steuerung;

import Datenbankmodels.PreislisteSucheModel;
import GUI.PreislisteGUI;

 
public class PreislisteSucheStrg implements IController {

	
	private PreislisteSucheModel model;
	private PreislisteGUI view;
	
	public PreislisteSucheStrg(PreislisteSucheModel smodel)
	{
		model = smodel;
		
	}
	
	public void fetchObjekte(String talking, String suchTxt) {
		
		model.holeDaten(talking, suchTxt);
		
		
	}

	@Override
	public void anfrage() {
		// TODO Auto-generated method stub
		
	}


}

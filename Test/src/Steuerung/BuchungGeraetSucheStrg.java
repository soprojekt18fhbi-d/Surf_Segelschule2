package Steuerung;

import Datenbankmodels.BuchungGeraetSucheModel;
import Datenbankmodels.BuchungModellSucheModel;
import GUI.IObjektView;

public class BuchungGeraetSucheStrg implements IController{
	
	private BuchungGeraetSucheModel model;
	private IObjektView view;
	
	public BuchungGeraetSucheStrg(BuchungGeraetSucheModel smodel)
	{
		model = smodel;
		
	}
	

	
	public void fetchGeraete(String talking, int modellNr, int kNr, int geraetNr) {
		
		model.holeGeraete(talking, modellNr, kNr, geraetNr);
		
		
	}



	@Override
	public void anfrage() {
		// TODO Auto-generated method stub
		
	}
	
	
}

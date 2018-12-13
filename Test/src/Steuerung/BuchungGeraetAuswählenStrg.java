package Steuerung;

import Datenbankmodels.BuchungGeraetAnzeigeModel;
import Datenbankmodels.BuchungModellAnzeigeModel;
import GUI.IObjektView;

public class BuchungGeraetAuswählenStrg implements IController{
	
	private BuchungGeraetAnzeigeModel model;
	private IObjektView view;
	
	public BuchungGeraetAuswählenStrg(BuchungGeraetAnzeigeModel smodel)
	{
		model = smodel;
		
	}
	

	
	public void fetchGeraete(String talking, int modellNr, int kNr, int geraetNr) {
		
		model.holeGeraete(talking, modellNr, kNr, geraetNr);
		
		
	}
	
	
}

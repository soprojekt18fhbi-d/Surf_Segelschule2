package Steuerung;

import Datenbankmodels.BuchungBuchungAnzeigenModel;
import Datenbankmodels.BuchungGeraetAnzeigeModel;
import GUI.IObjektView;

public class BuchungBuchungAnzeigenStrg implements IController {
	
	private BuchungBuchungAnzeigenModel model;
	private IObjektView view;
	
	public BuchungBuchungAnzeigenStrg(BuchungBuchungAnzeigenModel smodel)
	{
		model = smodel;
		
	}
	

	
	public void fetchBuchung(String talking2, int buchungID2, int kNr2, int geraetNr, String search2, String mode2, String makel) {
		
		model.holeBuchung(talking2, buchungID2, kNr2, geraetNr, search2, mode2, makel);
		
		
	}
	

}

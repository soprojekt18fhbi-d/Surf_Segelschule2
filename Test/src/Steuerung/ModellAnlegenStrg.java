package Steuerung;

import Datenbankmodels.ModellAnlegenModel;
import Domaenklassen.GeraeteModell;
import Domaenklassen.GeraeteTyp;
import GUI.IAnlegenView;

public class ModellAnlegenStrg {

	
	private GeraeteModell modell;
	private ModellAnlegenModel model;
	private IAnlegenView view;
	
	public ModellAnlegenStrg (ModellAnlegenModel smodel)
	{
		model = smodel;
		
	}

	
	public void modellUebergeben(int id, String name, String typ, int preis) {
		
		String modellID = String.valueOf(id);
		String modellname = name;
		String typname = typ;
		String preisID = String.valueOf(preis);
		String [] values = {modellID, modellname, typname, preisID};
		model.modellAnlegen(values);
	}
	
}
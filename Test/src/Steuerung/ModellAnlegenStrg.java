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

	
	public void modellUebergeben(String name, String typ, int preis) {
		
		String modellname = name;
		String typname = typ;
		String preisID = String.valueOf(preis);
		String [] values = {modellname, typname, preisID};
		model.modellAnlegen(values);
	}
	
}
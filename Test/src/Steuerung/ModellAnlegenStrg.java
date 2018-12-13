package Steuerung;

import Datenbankmodels.ModellAnlegenModel;
import Datenbankmodels.ModellhinzufuegenModel;
import Domaenklassen.GeraeteModell;
import Domaenklassen.GeraeteTyp;
import GUI.IAnlegenView;
import GUI.Modellhinzufuegen;

public class ModellAnlegenStrg {

	
	private GeraeteModell modell;
	private ModellhinzufuegenModel model;
	private Modellhinzufuegen view;
	
	public ModellAnlegenStrg (ModellhinzufuegenModel smodel)
	{
		model = smodel;
		
	}

	
	public void anfrageModellhinzufuegen(String talking, String name, String typ, int preis) {
		
		String [] values = {name, typ, "" + preis};
		model.anfrage(talking, values);
	}
	
}
package Steuerung;

import Datenbankmodels.ModellAnlegenModel;
import Datenbankmodels.ModellHinzufuegenModel;
import Domaenklassen.GeraeteModell;
import Domaenklassen.GeraeteTyp;
import GUI.IAnlegenView;
import GUI.ModellAnlegenGUI;

public class ModellAnlegenStrg implements IController {

	
	private GeraeteModell modell;
	private ModellHinzufuegenModel model;
	private ModellAnlegenGUI view;
	
	public ModellAnlegenStrg (ModellHinzufuegenModel smodel)
	{
		model = smodel;
		
	}

	
	public void anfrageModellhinzufuegen(String talking, String name, String typ, int preis) {
		
		String [] values = {name, typ, "" + preis};
		model.anfrage(talking, values);
	}


	@Override
	public void anfrage() {
		// TODO Auto-generated method stub
		
	}
	
}
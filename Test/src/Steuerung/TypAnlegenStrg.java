package Steuerung;

import Datenbankmodels.TypAnlegenModel;
import Domaenklassen.GeraeteTyp;
import GUI.IAnlegenView;


public class TypAnlegenStrg {

	
	private GeraeteTyp typ;
	private TypAnlegenModel model;
	private IAnlegenView view;
	
	public TypAnlegenStrg (TypAnlegenModel smodel)
	{
		model = smodel;
		
	}

	
	public void typUebergeben(int id, String name, String f�hrerschein) {
		typ = new GeraeteTyp(id, name, f�hrerschein);
		model.typAnlegen(typ);
	}
	
}


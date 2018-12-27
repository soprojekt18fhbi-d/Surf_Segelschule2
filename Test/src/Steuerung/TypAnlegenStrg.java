package Steuerung;

import Datenbankmodels.TypAnlegenModel;
import Domaenklassen.GeraeteTyp;
import GUI.IAnlegenView;


public class TypAnlegenStrg implements IController{

	
	private GeraeteTyp typ;
	private TypAnlegenModel model;
	private IAnlegenView view;
	
	public TypAnlegenStrg (TypAnlegenModel smodel)
	{
		model = smodel;
		
	}

	
	public void typUebergeben(String name, String f�hrerschein) {
		String typname = name;
		String schein = f�hrerschein;
		String[] values = {typname, schein};
		model.typAnlegen(values);
	}


	@Override
	public void anfrage() {
		// TODO Auto-generated method stub
		
	}
	
}


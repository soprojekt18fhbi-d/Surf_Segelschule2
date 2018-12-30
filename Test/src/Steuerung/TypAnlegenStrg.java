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

	
	public void typUebergeben(String talking, int id, String name, String f�hrerschein) {
		String idS = String.valueOf(id);
		String[] values = {talking, idS, name, f�hrerschein};
		model.typAnlegen(values);
	}


	@Override
	public void anfrage() {
		// TODO Auto-generated method stub
		
	}
	
}


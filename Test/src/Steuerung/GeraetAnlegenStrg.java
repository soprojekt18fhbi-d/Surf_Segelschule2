package Steuerung;

import Datenbankmodels.GeraetAnlegenModel;
import Domaenklassen.SportGeraet;
import GUI.IAnlegenView;

public class GeraetAnlegenStrg {

	
	private SportGeraet geraet;
	private GeraetAnlegenModel model;
	private IAnlegenView view;
	
	public GeraetAnlegenStrg (GeraetAnlegenModel smodel)
	{
		model = smodel;
		
	}

	
	public void modellUebergeben(int id, String name, String typ, int preis) {
		
		String modellID = String.valueOf(id);
		String modellname = name;
		String typname = typ;
		String preisID = String.valueOf(preis);
		String [] values = {modellID, modellname, typname, preisID};
		model.geraetAnlegen(values);
	}
	
}
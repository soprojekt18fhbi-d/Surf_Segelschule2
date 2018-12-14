package Steuerung;

import Datenbankmodels.GeraetAnlegenModel;
import Domaenklassen.SportGeraet;
import GUI.Geraethinzufuegen;
import GUI.IAnlegenView;

public class GeraetAnlegenStrg {

	
	private SportGeraet geraet;
	private GeraetAnlegenModel model;
	private Geraethinzufuegen view;
	
	public GeraetAnlegenStrg (GeraetAnlegenModel smodel)
	{
		model = smodel;
		
	}
	
	public void anfrageGeraethinzufuegen(String talking, String typ, String modell, String makel, double verkaufspreis, double anschaffungspreis, String farbe, int baujahr) {
		
		String [] values = {typ, modell, makel, ""+verkaufspreis, ""+anschaffungspreis, farbe, ""+baujahr};
		model.anfrage(talking, values);
	}
	
}
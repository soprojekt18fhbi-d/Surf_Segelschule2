package Steuerung;

import Datenbankmodels.GeraetAnlegenModel;
import Domaenklassen.SportGeraet;
import GUI.IAnlegenView;

public class GeraetAnlegenStrg {

	private GeraetAnlegenModel model;
	private IAnlegenView view;
	
	public GeraetAnlegenStrg (GeraetAnlegenModel smodel)
	{
		model = smodel;
		
	}

	
	public void geraetUebergeben(String typ, String modell, int id, double apreis, double vpreis, String gfarbe, int gbaujahr, String gmakel) {
		
		String typname = typ;
		String modellname = modell;
		String geraeteID = String.valueOf(id);
		String anschaffungspreis = String.valueOf(apreis);
		String verkaufspreis = String.valueOf(vpreis);
		String farbe = gfarbe;
		String baujahr = String.valueOf(gbaujahr);
		String makel = gmakel;
		
		String [] values = {typname, modellname, geraeteID, anschaffungspreis, verkaufspreis, farbe, baujahr, makel};
		model.geraetAnlegen(values);
	}
	
}
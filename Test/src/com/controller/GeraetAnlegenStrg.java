 /*
  *  @author Michael Schmidt
  */

package com.controller;

import com.entity.SportGeraet;
import com.model.GeraetAnlegenModel;
import com.view.GeraetAnlegenGUI;
import com.view.IAnlegenView;
import com.view.MainFrame;

public class GeraetAnlegenStrg implements IController {

	
	private SportGeraet geraet;
	private GeraetAnlegenModel model;
	private GeraetAnlegenGUI view;
	
	public GeraetAnlegenStrg (GeraetAnlegenModel smodel)
	{
		model = smodel;
		
	}
	
	public void anfrageGeraethinzufuegen(String talking, String typ, String modell, String makel, double verkaufspreis, double anschaffungspreis, String farbe, int baujahr) {
		
		String [] values = {typ, modell, makel, ""+verkaufspreis, ""+anschaffungspreis, farbe, ""+baujahr};
		model.anfrage(talking, values);
	}

	@Override
	public void anfrage() {
		// TODO Auto-generated method stub
		
	}
	
	public void setzeStandort() {
		model.setStandort(MainFrame.getStandort());
	}
	
}
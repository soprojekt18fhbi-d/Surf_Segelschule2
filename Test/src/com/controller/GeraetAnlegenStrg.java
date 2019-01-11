/*
 *  @author Michael Schmidt
 */

package com.controller;

import com.model.GeraetAnlegenModel;
import com.view.MainFrame;

public class GeraetAnlegenStrg {

	private GeraetAnlegenModel model;

	public GeraetAnlegenStrg(GeraetAnlegenModel smodel) {
		model = smodel;

	}

	public void anfrageGeraethinzufuegen(String talking, String typ, String modell, String makel, double verkaufspreis,
			double anschaffungspreis, String farbe, int baujahr) {

		String[] values = { typ, modell, makel, "" + verkaufspreis, "" + anschaffungspreis, farbe, "" + baujahr };
		model.anfrage(talking, values);
	}



	public void setzeStandort() {
		model.setStandort(MainFrame.getStandort());
	}

}
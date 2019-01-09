package com.controller;

import com.model.BuchungGeraetSucheModel;
import com.model.BuchungModellSucheModel;
import com.view.IObjektView;

public class BuchungGeraetSucheStrg implements IController {

	private BuchungGeraetSucheModel model;
	private IObjektView view;

	public BuchungGeraetSucheStrg(BuchungGeraetSucheModel smodel) {
		model = smodel;

	}

	public void fetchGeraete(String talking, int modellNr, int kNr, int geraetNr, int standort2) {

		model.holeGeraete(talking, modellNr, kNr, geraetNr, standort2);

	}

	@Override
	public void anfrage() {
		// TODO Auto-generated method stub

	}

}

package com.controller; //author Ben Kröncke

import com.entity.IKunde;
import com.model.BuchungTypSucheModel;
import com.model.StandortModel;
import com.view.IObjektView;
import com.view.IStandortView;
import com.view.MainFrame;

public class StandortStrg implements IController {

	private StandortModel model;
	private IStandortView view;

	public StandortStrg(StandortModel smodel) {
		model = smodel;

	}

	public void registriere(String standortID2, String standortName2, String telnr2, String talking2, String password2,
			String plz2, String strasse2, String ort2, String hnr2) {
		// TODO Auto-generated method stub
		model.registriere(standortID2, standortName2, telnr2, talking2, password2, plz2, strasse2, ort2, hnr2);
		if (model.pruefen() == true)
			MainFrame.setStandort(model.getStandort());
	}

	@Override
	public void anfrage() {
		// TODO Auto-generated method stub

	}

}

package com.controller;

import com.model.BuchungAnzeigeModel;
import com.model.WirtschaftlichkeitModel;
import com.view.IObjektView;
import com.view.IWirtschaftlichkeitView;

public class WirtschaftlichkeitStrg { // Ben Kröncke

	private WirtschaftlichkeitModel model;
	private IWirtschaftlichkeitView view;

	public WirtschaftlichkeitStrg(WirtschaftlichkeitModel smodel) {
		model = smodel;

	}



	public void holeDaten(String talking2, String mode2, int id2, String giveString) {

		model.holeDaten(talking2, mode2, id2, giveString);

	}

}

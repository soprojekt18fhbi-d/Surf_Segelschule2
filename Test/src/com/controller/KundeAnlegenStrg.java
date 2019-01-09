package com.controller;

import com.entity.Adresse;
import com.entity.IAdresse;
import com.entity.IKunde;
import com.entity.Kunde;
import com.model.KundeAnlegenModel;
import com.view.IView;

public class KundeAnlegenStrg implements IController {

	private IKunde kunde;
	private IAdresse adresse;
	private KundeAnlegenModel model;
	private IView view;

	public KundeAnlegenStrg(KundeAnlegenModel smodel) {
		model = smodel;

	}

	public void KundeAnlegen(String name, String vorname, String email, Boolean surfschein, Boolean segelschein,
			Boolean motorbootschein) {
		kunde = new Kunde(name, vorname, email, surfschein, segelschein, motorbootschein);
		model.kundeAnlegen(kunde);
	}

	public void AdresseAnlegen(String strasse, String hausnummer, String ort, int plz, String art) {
		adresse = new Adresse(strasse, hausnummer, ort, plz, art);
		model.AdresseAnlegen(adresse);
	}

	@Override
	public void anfrage() {
		// TODO Auto-generated method stub

	}

}

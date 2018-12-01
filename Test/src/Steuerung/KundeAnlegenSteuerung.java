package Steuerung;

import Datenbankmodels.KundeRegistrierenModel;
import Domaenklassen.Adresse;
import Domaenklassen.Kunde;
import GUI.IView;
import TESTPACKAGE.TestanbindungMVCBEISPIEL;
import TESTPACKAGE.TestframeMVCBeispiel;

public class KundeAnlegenSteuerung {
	
	private Kunde kunde;
	private KundeRegistrierenModel model;
	private IView view;
	
	public KundeAnlegenSteuerung(KundeRegistrierenModel smodel)
	{
		model = smodel;
		
	}

	
	public void KundeAnlegen(String name, String vorname, String email, Boolean surfschein, Boolean segelschein, Boolean motorbootschein) {
		kunde = new Kunde(name, vorname, email, surfschein, segelschein, motorbootschein);
		model.kundeAnlegen(kunde);
	}
	
}

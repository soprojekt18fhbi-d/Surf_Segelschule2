package Steuerung;

import Datenbankmodels.KundeAnlegenModel;
import Domaenklassen.Adresse;
import Domaenklassen.IAdresse;
import Domaenklassen.IKunde;
import Domaenklassen.Kunde;
import GUI.IView;
import TESTPACKAGE.TestanbindungMVCBEISPIEL;
import TESTPACKAGE.TestframeMVCBeispiel;

public class KundeAnlegenStrg {
	
	private IKunde kunde;
	private IAdresse adresse;
	private KundeAnlegenModel model;
	private IView view;
	
	public KundeAnlegenStrg(KundeAnlegenModel smodel)
	{
		model = smodel;
		
	}

	
	public void KundeAnlegen(String name, String vorname, String email, Boolean surfschein, Boolean segelschein, Boolean motorbootschein) {
		kunde = new Kunde(name, vorname, email, surfschein, segelschein, motorbootschein);
		model.kundeAnlegen(kunde);
	}
	
	public void AdresseAnlegen(String strasse, String hausnummer, String ort, int plz, String art) {
		adresse = new Adresse(strasse, hausnummer, ort, plz, art);
		model.AdresseAnlegen(adresse);
	}
	
}

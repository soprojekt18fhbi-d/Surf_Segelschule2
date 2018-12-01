package Steuerung;

import Domaenklassen.Adresse;
import Domaenklassen.Kunde;

public class KundeAnlegenSteuerung {
	
	

//	public static void AdresseAnlegen(String strasse, String hausnummer, String ort, int plz, String eMail) {
//		Adresse Adresse = new Adresse (strasse, hausnummer, ort, plz, eMail);
//		System.out.println(Adresse);
//	}
	
	public static void KundeAnlegen(String name, String vorname, Adresse heimadresse, Adresse urlaubsadresse, Boolean surfschein, Boolean segelschein, Boolean motorbootschein, int geburtsdatum) {
		Kunde Kunde = new Kunde (name, vorname, heimadresse, urlaubsadresse, surfschein, segelschein, motorbootschein, geburtsdatum);
	
	}
	
}

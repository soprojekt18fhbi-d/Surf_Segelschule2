package Steuerung;

import java.util.ArrayList;

import Domaenklassen.IKunde;
import Domaenklassen.Kunde;

public class KundeAusleihStrg {

	
public KundeAusleihStrg() {
		
	}

	// Start der Datenbankabfragen mit einer ArrayList als Ergebnis

	private ArrayList getKundeListeBuchung(int kdID) {
		ArrayList <Kunde> kundeListe = KundeSucheStrg.sucheKunde(kdID);
		return kundeListe;
	}



	// Wahl eines Typs/Modells/Geraets aus der Liste

	private IKunde selectKunde(ArrayList kundeListe) {
		IKunde suchKunde = KundeAuswStrg.auswKunde(kundeListe);
		return suchKunde;
	}

}



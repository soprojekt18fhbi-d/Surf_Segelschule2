/**
 * @author Ben S
 */

package Steuerung;

import java.util.ArrayList;

import Domaenklassen.IKunde;
import Domaenklassen.Kunde;

public class KundeBuchungStrg {

	private static KundeBuchungStrg instance;
	private static KundeSucheStrg kundenSuche;
	private static KundeAuswStrg kundenAuswahl;
	private ArrayList <Kunde> kundenListe;
	private IKunde suchKunde;

	
	
	//Strg erstellen
	
	static KundeBuchungStrg getKundeAusleihStrg() {
		if (instance == null) {
			instance = new KundeBuchungStrg();
		}
		return instance;	
		}
	
	// Strg schlieﬂen
	
	static void closeKundeAusleihStrg() {
		if (instance != null) {
			instance = null;
		}
	}

		 
	
	//Start der Datenbankabfrage mit einer ArrayList als Ergebnis
	
	private ArrayList getKundeSuchenStrg(String suchKundennummer, String nname, String vname) {
		kundenSuche = new KundeSucheStrg();
		kundenListe = KundeSucheStrg.sucheKunde(suchKundennummer, nname, vname);
		return kundenListe;
	}
	
	
	
	//Wahl eines Kunden aus der KundenListe
	
	private IKunde selectKunde(ArrayList kundenListe) {
		kundenAuswahl = new KundeAuswStrg();
		suchKunde = KundeAuswStrg.auswKunde(kundenListe);
		return suchKunde;
	}
	 
	 
	
}

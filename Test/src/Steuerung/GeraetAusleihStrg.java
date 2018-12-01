/**
 *@author Ben S 
 **/

package Steuerung;

import java.util.ArrayList;

import Domaenklassen.Kunde;

public class GeraetAusleihStrg {

	private static GeraetAusleihStrg instance;
	

	private ArrayList<GeraeteTyp> typListe;
	private GeraeteTyp suchTyp;



	private ArrayList<GeraeteModell> modellListe;
	private GeraeteModell suchModell;

	private ArrayList<Geraet> geraeteListe;
	private Geraet suchGeraet;

	private Fuehrerschein buchungsFuehrerschein;

	// Strg erstellen

	static GeraetAusleihStrg getGeraetAusleihStrg() {
		if (instance == null) {
			instance = new GeraetAusleihStrg();
		}
		return instance;
	}

	// Strg schlieﬂen

	static void closeGeraetAusleihStrg() {
		if (instance != null) {
			instance = null;
		}
	}



	// Start der Datenbankabfragen mit einer ArrayList als Ergebnis


	private ArrayList getTypListeBuchung(Kunde buchungsKunde) {
		Fuehrerschein buchungsSurfschein=buchungsKunde.isSurfschein();
		Fuehrerschein buchungsSegelschein=buchungsKunde.isSegelschein();
		Fuehrerschein buchungsMotorbootschein=buchungsKunde.isMotorbootschein();
		typListe = TypSucheStrg.sucheTyp(buchungsSurfschein, buchungsSegelschein, buchungsMotorbootschein);
		return typListe;
	}
	
	
	private ArrayList getModellListe(GeraeteTyp suchTyp) {
		modellListe = ModellSucheStrg.sucheModell();
		return modellListe;
	}
	
	
	private ArrayList getGeraetListe(GeraeteModell suchModell) {
		geraeteListe = GeraetSucheStrg.sucheGeraet();
		return geraeteListe;
	}

	// Wahl eines Typs/Modells/Geraets aus der Liste

	private GeraeteTyp selectTyp(ArrayList typListe) {
		suchTyp = TypAuswStrg.auswTyp(typListe);
		return suchTyp;
	}

	private GeraeteModell selectModell(ArrayList modellListe) {
		suchModell = ModellAuswStrg.auswModell(modellListe);
		return suchModell;
	}

	private Geraet selectGeraet(ArrayList typGeraet) {
		suchGeraet = GeraetAuswStrg.auswGeraet(geraeteListe);
		return suchGeraet;
	}

}

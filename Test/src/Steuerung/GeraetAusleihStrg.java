/**
 *@author Ben S 
 **/

package Steuerung;

import java.util.ArrayList;

import Domaenklassen.Kunde;

public class GeraetAusleihStrg implements IController{

	public GeraetAusleihStrg() {
		
	}

	// Start der Datenbankabfragen mit einer ArrayList als Ergebnis

	private ArrayList getTypListeBuchung(Kunde buchungsKunde) {
		Fuehrerschein buchungsSurfschein = buchungsKunde.isSurfschein();
		Fuehrerschein buchungsSegelschein = buchungsKunde.isSegelschein();
		Fuehrerschein buchungsMotorbootschein = buchungsKunde.isMotorbootschein();
		ArrayList <GeraeteTyp> typListe = TypSucheStrg.sucheTyp(buchungsSurfschein, buchungsSegelschein, buchungsMotorbootschein);
		return typListe;
	}

	private ArrayList getModellListe(GeraeteTyp suchTyp) {
		ArrayList<GeraeteModell> modellListe = ModellSucheStrg.sucheModell();
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

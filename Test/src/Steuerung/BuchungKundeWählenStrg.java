package Steuerung;

import Datenbankmodels.BuchungKundewaehlenModel;
import Datenbankmodels.KundeSucheModel;
import Domaenklassen.Kunde;
import GUI.KundeAendern;
import GUIBuchungsverwaltung.KundeWaehlen;

public class BuchungKundeWählenStrg implements IController {
	
	private BuchungKundewaehlenModel model;
	private KundeWaehlen view;

	public BuchungKundeWählenStrg(BuchungKundewaehlenModel smodel) {
		model = smodel;

	}

	/**
	 * Der Button wurde gedrückt und es sollen Kunden geholt werden.
	 * @param string 
	 * @param talking 
	 * @param variableKnr 
	 * @param selectedMode 
	 * @param talking 
	 * @param heimat 
	 * @param motor 
	 * @param segel 
	 * @param surf 
	 * 
	 */
	public void fetchObjekte(String talking, String searchtxt) {

		
		try {
			model.holeDaten(talking, searchtxt);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void erstelleKunde(String knr) {
		try {
			model.erstelleKunde(knr);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	




}

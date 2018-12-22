package Steuerung;

import Datenbankmodels.BuchungKundeSucheModel;
import Datenbankmodels.KundeSucheModel;
import Domaenklassen.Kunde;
import GUI.KundeAendernGUI;
import GUIBuchungsverwaltung.BuchungKundeSucheGUI;

public class BuchungKundeSucheStrg implements IController {
	
	private BuchungKundeSucheModel model;
	private BuchungKundeSucheGUI view;

	public BuchungKundeSucheStrg(BuchungKundeSucheModel smodel) {
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

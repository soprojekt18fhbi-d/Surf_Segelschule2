/**
 * @author Ben Kröncke
 *
 */


package com.controller;

import com.entity.Kunde;
import com.model.BuchungKundeSucheModel;
import com.model.KundeSucheModel;
import com.view.BuchungKundeSucheGUI;
import com.view.KundeAendernGUI;

public class BuchungKundeSucheStrg {

	private BuchungKundeSucheModel model;
	private BuchungKundeSucheGUI view;

	public BuchungKundeSucheStrg(BuchungKundeSucheModel smodel) {
		model = smodel;

	}

	/**
	 * Der Button wurde gedrückt und es sollen Kunden geholt werden.
	 * 
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

/**
 * @author Ben S
 */

package com.controller;

import java.util.ArrayList;

import javax.swing.JTextField;

import com.entity.Kunde;
import com.model.IModelSuche;
import com.model.KundeSucheModel;
import com.view.KundeAendernGUI;

public class KundeSucheStrg {

	private KundeSucheModel model;
	private KundeAendernGUI view;

	public KundeSucheStrg(KundeSucheModel smodel) {
		model = smodel;

	}

	public void fetchObjekte(String knrplz, String nachnameort, String vornamestrasse, String emailhnr,
			String selectedMode, String variableKnr, String talking, String surf, String segel, String motor,
			String heimat) {

		try {
			model.holeDaten(knrplz, nachnameort, vornamestrasse, emailhnr, selectedMode, variableKnr, talking, surf,
					segel, motor, heimat);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}



}

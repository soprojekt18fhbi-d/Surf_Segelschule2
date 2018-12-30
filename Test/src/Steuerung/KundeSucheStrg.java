/**
 * @author Ben S
 */

package Steuerung;

import java.util.ArrayList;

import javax.swing.JTextField;

import Datenbankmodels.IModelSuche;
import Datenbankmodels.KundeSucheModel;
import Domaenklassen.Kunde;
import GUI.KundeAendernGUI;


public class KundeSucheStrg implements IController {

	private KundeSucheModel model;
	private KundeAendernGUI view;

	public KundeSucheStrg(KundeSucheModel smodel) {
		model = smodel;

	}


	public void fetchObjekte(String knrplz, String nachnameort, String vornamestrasse, String emailhnr, String selectedMode, String variableKnr, String talking, String surf, String segel, String motor, String heimat) {

		
		try {
			model.holeDaten(knrplz, nachnameort, vornamestrasse, emailhnr, selectedMode, variableKnr, talking, surf, segel, motor, heimat);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void anfrage() {
		// TODO Auto-generated method stub
		
	}




}

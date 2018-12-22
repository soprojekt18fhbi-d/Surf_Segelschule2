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
import TESTPACKAGE.TestanbindungMVCBEISPIEL;
import TESTPACKAGE.TestframeMVCBeispiel;

public class KundeSucheStrg implements IController {

	private KundeSucheModel model;
	private KundeAendernGUI view;

	public KundeSucheStrg(KundeSucheModel smodel) {
		model = smodel;

	}

	/**
	 * Der Button wurde gedrückt und es sollen Kunden geholt werden.
	 * @param variableKnr 
	 * @param selectedMode 
	 * @param talking 
	 * @param heimat 
	 * @param motor 
	 * @param segel 
	 * @param surf 
	 * 
	 */
	public void fetchObjekte(String knrplz, String nachnameort, String vornamestrasse, String emailhnr, String selectedMode, String variableKnr, String talking, String surf, String segel, String motor, String heimat) {

		
		try {
			model.holeDaten(knrplz, nachnameort, vornamestrasse, emailhnr, selectedMode, variableKnr, talking, surf, segel, motor, heimat);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}




}

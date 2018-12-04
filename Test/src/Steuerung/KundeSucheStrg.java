/**
 * @author Ben S
 */

package Steuerung;

import java.util.ArrayList;

import Datenbankmodels.IModelSuche;
import Datenbankmodels.KundeSucheModel;
import Domaenklassen.Kunde;
import GUI.KundeAendern;
import TESTPACKAGE.TestanbindungMVCBEISPIEL;
import TESTPACKAGE.TestframeMVCBeispiel;

public class KundeSucheStrg implements IController {

	private KundeSucheModel model;
	private KundeAendern view;

	public KundeSucheStrg(KundeSucheModel smodel) {
		model = smodel;

	}

	/**
	 * Der Button wurde gedrückt und es sollen Kunden geholt werden.
	 * 
	 */
	public void fetchKunde(String kdID, String nname, String vname, String plz, String ort,
			String strasse, String hausnr) {

		model.holeDaten(kdID, nname, vname, plz, ort, strasse, hausnr);

	}


}

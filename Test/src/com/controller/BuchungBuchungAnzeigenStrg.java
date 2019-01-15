/**
 * @author Ben Kröncke
 *
 */

package com.controller;

import com.model.BuchungAnzeigeModel;
import com.model.BuchungGeraetSucheModel;
import com.view.IObjektView;

public class BuchungBuchungAnzeigenStrg {

	private BuchungAnzeigeModel model;
	private IObjektView view;

	public BuchungBuchungAnzeigenStrg(BuchungAnzeigeModel smodel) {
		model = smodel;

	}

	public void fetchBuchung(String talking2, int buchungID2, int kNr2, int geraetNr, String search2, String mode2,
			String makel) {

		model.holeBuchung(talking2, buchungID2, kNr2, geraetNr, search2, mode2, makel);

	}



}

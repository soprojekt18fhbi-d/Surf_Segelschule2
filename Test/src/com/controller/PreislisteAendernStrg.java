/**
 * @author Ben S
 */

package com.controller;

import com.entity.Preisliste;
import com.model.PreislisteAendernModel;
import com.view.PreislisteAendernGUI;

public class PreislisteAendernStrg {

	private Preisliste preisliste;
	private PreislisteAendernModel model;
	private PreislisteAendernGUI view;

	public PreislisteAendernStrg(PreislisteAendernModel model) {

		this.model = model;
	}

	public void preislisteUebergeben(String talking, int id, double preisEineStd, double preisZweiStd,
			double preisVierStd, double preisEinenTag, double preisZweiTage, double preisDreiTage, double preisVierTage,
			double preisFuenfTage, double preisSechsSiebenTage, double preisAchtTage, double preisNeunTage,
			double preisZehnTage, double preisElfTage, double preisZwoelfVierzehnTage, double preisFuenfzehnTage,
			double preisSechzehnTage, double preisSiebzehnTage, double preisAchtzehnEinundzwanzigTage,
			double preisTagVierWochen, double presVierWochen, double preisAchtWochen) {
//		Umwandlung in ein Preislisten-Objekt um nachfolgend übersichtlichere Parameter nutzen zu können
		preisliste = new Preisliste(preisEineStd, preisZweiStd, preisVierStd, preisEinenTag, preisZweiTage, preisDreiTage, preisVierTage, preisFuenfTage,
				preisSechsSiebenTage, preisAchtTage, preisNeunTage, preisZehnTage, preisElfTage, preisZwoelfVierzehnTage, preisFuenfzehnTage, preisSechzehnTage,
				preisSiebzehnTage, preisAchtzehnEinundzwanzigTage, preisTagVierWochen, presVierWochen, preisAchtWochen);

		model.anfrage(talking, id, preisliste);

	}


}

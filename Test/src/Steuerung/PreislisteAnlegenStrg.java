/**
 * @author Ben S
 */

package Steuerung;

import java.util.ArrayList;

import Datenbankmodels.PreislisteAnlegenModel;
import Domaenklassen.Preisliste;
import GUI.IAnlegenView;

public class PreislisteAnlegenStrg {

	private Preisliste preisliste;
	private PreislisteAnlegenModel model;
	private IAnlegenView view;
	
	public PreislisteAnlegenStrg (PreislisteAnlegenModel smodel)
	{
		model = smodel;
		
	}

	
	public void preislisteUebergeben(String eineStd, String zweiStd, String vierStd, String einenTag,
			String zweiTage, String dreiTage, String vierTage, String fuenfTage, String sechsSiebenTage,
			String achtTage, String neunTage, String zehnTage, String elfTage, String zwoelfVierzehnTage,
			String fuenfzehnTage, String sechzehnTage, String siebzehnTage, String achtzehnEinundzwanzigTage,
			String tagVierWochen, String vierWochen, String achtWochen, String kauf) {
		
		//Strings in 
		String[] values = { eineStd,  zweiStd,  vierStd,  einenTag,
				 zweiTage,  dreiTage,  vierTage,  fuenfTage,  sechsSiebenTage,
				 achtTage,  neunTage,  zehnTage,  elfTage,  zwoelfVierzehnTage,
				 fuenfzehnTage,  sechzehnTage,  siebzehnTage,  achtzehnEinundzwanzigTage,
				 tagVierWochen,  vierWochen,  achtWochen,  kauf};
		
		model.PreislisteAnlegen(values);
	}
	
}

/**
 * @author Ben S
 */

package Steuerung;

import java.util.ArrayList;

import Datenbankmodels.PreislisteAnlegenModel;
import Domaenklassen.Preisliste;
import GUI.IAnlegenView;

public class PreislisteAnlegenStrg implements IController {

	private Preisliste preisliste;
	private PreislisteAnlegenModel model;
	private IAnlegenView view;
	
	public PreislisteAnlegenStrg (PreislisteAnlegenModel smodel)
	{
		model = smodel;
		
	}

	
	public void preislisteUebergeben(double eineStd, double zweiStd, double vierStd, double einenTag,
			double zweiTage, double dreiTage, double vierTage, double fuenfTage, double sechsSiebenTage,
			double achtTage, double neunTage, double zehnTage, double elfTage, double zwoelfVierzehnTage,
			double fuenfzehnTage, double sechzehnTage, double siebzehnTage, double achtzehnEinundzwanzigTage,
			double tagVierWochen, double vierWochen, double achtWochen, double kauf) {
		

		preisliste=new Preisliste( eineStd,  zweiStd,  vierStd,  einenTag,
			 zweiTage,  dreiTage,  vierTage,  fuenfTage,  sechsSiebenTage,
			 achtTage,  neunTage,  zehnTage,  elfTage,  zwoelfVierzehnTage,
			 fuenfzehnTage,  sechzehnTage,  siebzehnTage,  achtzehnEinundzwanzigTage,
			 tagVierWochen,  vierWochen,  achtWochen,  kauf);
		model.PreislisteAnlegen(preisliste);
	}


	@Override
	public void anfrage() {
		// TODO Auto-generated method stub
		
	}
	
}

/**
 * @author Ben S
 */

package Steuerung;

import Datenbankmodels.PreislisteAendernModel;
import Domaenklassen.Preisliste;
import GUI.PreislisteAendernGUI;

public class PreislisteAendernStrg implements IController{

	private Preisliste preisliste;
	private PreislisteAendernModel model;
	private PreislisteAendernGUI view;
	
	public PreislisteAendernStrg(PreislisteAendernModel model) {
		
		this.model=model;
	} 


	public void preislisteUebergeben(String talking, int id, double preisEineStd, double preisZweiStd, double preisVierStd,
			double preisEinenTag, double preisZweiTage, double preisDreiTage, double preisVierTage,
			double preisFuenfTage, double preisSechsSiebenTage, double preisAchtTage, double preisNeunTage,
			double preisZehnTage, double preisElfTage, double preisZwoelfVierzehnTage, double preisFuenfzehnTage,
			double preisSechzehnTage, double preisSiebzehnTage, double preisAchtzehnEinundzwanzigTage,
			double preisTagVierWochen, double presVierWochen, double preisAchtWochen) {
		double[] values = doublePreislisteInArray(preisEineStd, preisZweiStd, preisVierStd, preisEinenTag,
				preisZweiTage, preisDreiTage, preisVierTage, preisFuenfTage, preisSechsSiebenTage, preisAchtTage,
				preisNeunTage, preisZehnTage, preisElfTage, preisZwoelfVierzehnTage, preisFuenfzehnTage,
				preisSechzehnTage, preisSiebzehnTage, preisAchtzehnEinundzwanzigTage, preisTagVierWochen,
				presVierWochen, preisAchtWochen);
		
		model.anfrage(talking, id, values);
		
	}


	public double[] doublePreislisteInArray(double preisEineStd, double preisZweiStd, double preisVierStd,
			double preisEinenTag, double preisZweiTage, double preisDreiTage, double preisVierTage,
			double preisFuenfTage, double preisSechsSiebenTage, double preisAchtTage, double preisNeunTage,
			double preisZehnTage, double preisElfTage, double preisZwoelfVierzehnTage, double preisFuenfzehnTage,
			double preisSechzehnTage, double preisSiebzehnTage, double preisAchtzehnEinundzwanzigTage,
			double preisTagVierWochen, double presVierWochen, double preisAchtWochen) {
		double [] values = {preisEineStd, preisZweiStd, preisVierStd,
				preisEinenTag, preisZweiTage, preisDreiTage, preisVierTage,
				preisFuenfTage, preisSechsSiebenTage, preisAchtTage, preisNeunTage,
				preisZehnTage, preisElfTage, preisZwoelfVierzehnTage, preisFuenfzehnTage,
				preisSechzehnTage, preisSiebzehnTage, preisAchtzehnEinundzwanzigTage,
				preisTagVierWochen, presVierWochen, preisAchtWochen};
		return values;
	}


	@Override
	public void anfrage() {
		// TODO Auto-generated method stub
		
	}

}

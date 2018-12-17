package Steuerung; //author Ben Kröncke

import Datenbankmodels.BuchungTypAnzeigeModel;
import Datenbankmodels.StandortModel;
import Domaenklassen.IKunde;
import GUI.IObjektView;
import GUI.IStandortView;

public class StandortStrg implements IController{


		
		private StandortModel model;
		private IStandortView view;
		
		public StandortStrg(StandortModel smodel)
		{
			model = smodel;
			
		}
		




		public void registriere(String standortID2, String standortName2, String telnr2, String talking2, String password2, String plz2, String strasse2, String ort2, String hnr2) {
			// TODO Auto-generated method stub
			model.registriere(standortID2, standortName2, telnr2, talking2, password2, plz2, strasse2, ort2, hnr2);
		}




	
	
	
}

package Steuerung;

import Domaenklassen.Kunde;
import Domaenklasse.Geraet;

public class BuchungAnlegenStrg {


		private Kunde buchungsKunde;
		private Geraet buchungsGeraet;
		private BuchungsTyp buchungsTyp;
		
		private static GeraetAusleihStrg instance;
		
		static GeraetAusleihStrg getGeraetAusleihStrg() {
			if (instance == null) {
				instance = new GeraetAusleihStrg();
			}
			return instance;
		}
		


		public void BuchungAnlegen(Kunde buchungsKunde, Geraet buchungsGeraet, BuchungsTyp buchungsTyp){
			Buchung buchung = new Buchung (Kunde buchungsKunde, Geraet buchungsGeraet, BuchungsTyp buchungsTyp);
		}

	
}

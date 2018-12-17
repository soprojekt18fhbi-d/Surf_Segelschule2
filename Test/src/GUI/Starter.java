package GUI;

import java.awt.EventQueue;

import Datenbankmodels.StandortModel;
import Steuerung.StandortStrg;

public class Starter {

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					StandortModel standortModel = new StandortModel();
					StandortStrg standortStrg = new StandortStrg(standortModel);
					
					StandortGUI frame = new StandortGUI(standortModel, standortStrg);
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		

	}


}

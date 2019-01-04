 /*
  *  @author Michael Schmidt
  */

package Steuerung;

import Datenbankmodels.ModellAnlegenModel;
import Datenbankmodels.ModellAnlegenModel;
import Domaenklassen.GeraeteModell;
import Domaenklassen.GeraeteTyp;
import GUI.IAnlegenView;
import GUI.ModellAnlegenGUI;

public class ModellAnlegenStrg implements IController {

	
	private GeraeteModell modell;
	private ModellAnlegenModel model;
	private ModellAnlegenGUI view;
	
	public ModellAnlegenStrg (ModellAnlegenModel smodel)
	{
		model = smodel;
		
	}

	
	public void anfrageModellhinzufuegen(String talking, String name, String typ, int preis, int id) {
		
		String [] values = {name, typ, "" + preis, "" + id};
		model.anfrage(talking, values);
	}


	@Override
	public void anfrage() {
		// TODO Auto-generated method stub
		
	}
	
}
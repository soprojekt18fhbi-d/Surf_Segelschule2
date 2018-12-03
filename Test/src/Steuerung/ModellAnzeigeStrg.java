package Steuerung;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import Datenbankmodels.ModellAnzeigeModel;
import GUI.IObjektView;


/**
 * 
 * @author michi
 *
 */
public class ModellAnzeigeStrg implements IController{
	
	private ModellAnzeigeModel model;
	private IObjektView view;
	
	public ModellAnzeigeStrg(ModellAnzeigeModel smodel)
	{
		model = smodel;
		
	}
	

	
	public void fetchModelle() {
		
		model.holeModelle();
		
		
	}
}

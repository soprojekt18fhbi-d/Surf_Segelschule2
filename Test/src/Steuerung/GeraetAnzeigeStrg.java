package Steuerung;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import Datenbankmodels.GeraetAnzeigeModel;
import GUI.IObjektView;


/**
 * 
 * @author michi
 *
 */
public class GeraetAnzeigeStrg implements IController{
	
	private GeraetAnzeigeModel model;
	private IObjektView view;
	
	public GeraetAnzeigeStrg(GeraetAnzeigeModel smodel)
	{
		model = smodel;
		
	}
	

	
	public void fetchModelle() {
		
		model.holeGeraete();
		
		
	}
}

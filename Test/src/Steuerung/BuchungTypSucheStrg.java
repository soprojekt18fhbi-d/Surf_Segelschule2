package Steuerung;

import java.util.ArrayList;

import javax.swing.DefaultListModel;

import Datenbankmodels.BuchungTypSucheModel;
import Domaenklassen.IKunde;
import GUI.IObjektView;

/**
 * 
 * @author michi
 *
 */
public class BuchungTypSucheStrg implements IController{
	
	private BuchungTypSucheModel model;
	private IObjektView view;
	
	public BuchungTypSucheStrg(BuchungTypSucheModel smodel)
	{
		model = smodel;
		
	}
	

	
	public void fetchTypen(int knr, String talking, String searchtxt, IKunde kunde) {
		
		model.holeTypen(knr, talking, searchtxt, kunde);
		
		
	}
}

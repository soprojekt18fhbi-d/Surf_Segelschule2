package Steuerung;

import java.util.ArrayList;

import javax.swing.DefaultListModel;

import Datenbankmodels.RechnungAnzeigenModel;
import GUI.IObjektView;


/**
 * 
 * @author Darnel
 *
 */
public class RechnungAnzeigeStrg implements IController{
	
	private RechnungAnzeigenModel model;
	private IObjektView view;
	private String search;
	private int kundenID;
	private double summe;
	private double summeMitMwst;
	private double mwst;
	private int kundeID;
	private int buchungsID;
	private int rechnungsID;

	
	public RechnungAnzeigeStrg(RechnungAnzeigenModel smodel)
	{
		model = smodel;
		
	}
	
	public void getRechungDruck(int rechnungsID)
	{
		model.holeDatenDrucken(rechnungsID);
		summe = model.getSumme();
		kundenID = model.getKundeID();
		summeMitMwst = model.getSummeMitMwst();
		mwst = model.getMwst();
		rechnungsID = model.getRechnungsID();
		buchungsID = model.getBuchungsID();
		
		System.out.println(summe);
	}

	
	public void getRechnungenSuche(String search) {
		
		model.holeDatenSuche(search);
		
	}
	
	public void getRechnungen() {
		
		model.holeDaten();
		
	}

	@Override
	public void anfrage() {
		// TODO Auto-generated method stub
		
	}
	
}

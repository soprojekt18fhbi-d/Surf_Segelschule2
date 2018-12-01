package Domaenklassen;

import java.util.ArrayList;

/**
 * @author michi
 */
public class GeraeteModell extends GeraeteTyp{
	
	private int modellID;
	private double ausleihkosten;
	private String bezeichnung;
	
	public ArrayList<GeraeteModell>listeModelle = new ArrayList<GeraeteModell>();


	public GeraeteModell(String name) {
		super(name);
	}

	public int getModellID() {
		return modellID;
	}

	public double getAusleihkosten() {
		return ausleihkosten;
	}

	public void setAusleihkosten(double ausleihkosten) {
		this.ausleihkosten = ausleihkosten;
	}

	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}
	
	
	public void hinzufuegen(GeraeteModell element){
		listeModelle.add(element);
	}
	
	public void entfernen(GeraeteModell element){
		listeModelle.remove(element);
	}

}

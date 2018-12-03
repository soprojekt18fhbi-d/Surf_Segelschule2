package Domaenklassen;

import java.util.ArrayList;

/**
 * @author michi
 */
public class GeraeteModell extends GeraeteTyp{
	
	private String modellID;
	private double ausleihkosten;
	private String name;
	
	public ArrayList<GeraeteModell>listeModelle = new ArrayList<GeraeteModell>();


	public GeraeteModell(String name, String id) {
		super(name, id);
		this.name = name;
		this.modellID = id;
	}

	public String getModellID() {
		return modellID;
	}

	public double getAusleihkosten() {
		return ausleihkosten;
	}

	public void setAusleihkosten(double ausleihkosten) {
		this.ausleihkosten = ausleihkosten;
	}

	public String getModellName() {
		return name;
	}

	public void setModellName(String bezeichnung) {
		this.name = bezeichnung;
	}
	
	
	public void hinzufuegen(GeraeteModell element){
		listeModelle.add(element);
	}
	
	public void entfernen(GeraeteModell element){
		listeModelle.remove(element);
	}

}

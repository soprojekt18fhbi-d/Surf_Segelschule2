package Domaenklassen;

import java.util.ArrayList;

/**
 * @author michi
 */
public class Geraet extends GeraeteModell{
	
	private String bezeichnung;
	private String ger�teID;
	private String farbe;
	private double verkaufsPreis;
	private int status;
	
	public ArrayList<Geraet>listeGeraete = new ArrayList<Geraet>();

	public Geraet(String name, String id) {
		super(name, id);
		this.ger�teID = id;
		this.bezeichnung = name;
	}

	public String getGeraeteID() {
		return ger�teID;
	}

	public void setGeraeteID(String ger�teID) {
		this.ger�teID = ger�teID;
	}

	public String getFarbe() {
		return farbe;
	}

	public void setFarbe(String farbe) {
		this.farbe = farbe;
	}

	public double getVerkaufsPreis() {
		return verkaufsPreis;
	}

	public void setVerkaufsPreis(double verkaufsPreis) {
		this.verkaufsPreis = verkaufsPreis;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
	public void hinzufuegen(Geraet element){
		listeGeraete.add(element);
	}
	
	public void entfernen(Geraet element){
		listeGeraete.remove(element);
	}

	public String getGeraeteName() {
		return bezeichnung;
	}

	public void setGeraeteName(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

}

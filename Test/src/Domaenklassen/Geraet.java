package Domaenklassen;

import java.util.ArrayList;

/**
 * @author michi
 */
public class Geraet extends GeraeteModell{
	
	private int ger�teID;
	private String farbe;
	private double verkaufsPreis;
	private int status;
	
	public ArrayList<Geraet>listeGeraete = new ArrayList<Geraet>();

	public Geraet(String name) {
		super(name);
	}

	public int getGer�teID() {
		return ger�teID;
	}

	public void setGer�teID(int ger�teID) {
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

}

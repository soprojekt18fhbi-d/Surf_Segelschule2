// @author Darnel

package Domaenklassen;

public class Adresse {
	private String strasse;
	private String ort;
	private int plz;
	private String hausnummer;
	private String art;
	

	public Adresse(String strasse, String hausnummer, String ort, int plz, String art) {
		this.strasse = strasse;
		this.hausnummer = hausnummer;
		this.ort = ort;
		this.plz = plz;
		this.art = art;
	}

	public String getStrasse() {
		return this.strasse;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	public String getOrt() {
		return this.ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public int getPlz() {
		return this.plz;
	}

	public void setPlz(int plz) {
		this.plz = plz;
	}

	public String getHausnummer() {
		return this.hausnummer;
	}

	public void setHausnummer(String hausnummer) {
		this.hausnummer = hausnummer;
	}
	
	public String getArt() {
		return art;
	}

	public void setArt(String art) {
		this.art = art;
	}
	
	@Override
	public String toString(){
		return this.strasse + ";" + this.hausnummer + ";" + this.plz + ";" + this.ort;
	}
	
	

}

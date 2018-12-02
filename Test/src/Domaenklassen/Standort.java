package Domaenklassen;

//@author Darnel

public class Standort {
	
	private int id;
	private int telefonnummer;
	private Adresse adresse;
	
	public Standort(int id, int telefonnummer, Adresse adresse) {
		super();
		this.id = id;
		this.telefonnummer = telefonnummer;
		this.adresse = adresse;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTelefonnummer() {
		return telefonnummer;
	}
	public void setTelefonnummer(int telefonnummer) {
		this.telefonnummer = telefonnummer;
	}
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	
	

}

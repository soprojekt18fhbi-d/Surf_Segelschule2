package Domaenklassen;

//@author Darnel

public class Buchung {
	
	private int buchungsId;
	private int ausleihdatum;
	private int rueckgabedatum;
	private Kunde kunde;
	private int verkaufsdatum;
	private Rechnung rechnung;
	
	
	
	public int getId() {
		return buchungsId;
	}
	public void setId(int id) {
		this.buchungsId = id;
	}
	public int getAusleihdatum() {
		return ausleihdatum;
	}
	public void setAusleihdatum(int ausleihdatum) {
		this.ausleihdatum = ausleihdatum;
	}
	public int getRueckgabedatum() {
		return rueckgabedatum;
	}
	public void setRueckgabedatum(int rueckgabedatum) {
		this.rueckgabedatum = rueckgabedatum;
	}
	public Kunde getKunde() {
		return kunde;
	}
	public void setKunde(Kunde kunde) {
		this.kunde = kunde;
	}
	public int getVerkaufsdatum() {
		return verkaufsdatum;
	}
	public void setVerkaufsdatum(int verkaufsdatum) {
		this.verkaufsdatum = verkaufsdatum;
	}
	public Rechnung getRechnung() {
		return rechnung;
	}
	public void setRechnung(Rechnung rechnung) {
		this.rechnung = rechnung;
	}
	
	
	

}

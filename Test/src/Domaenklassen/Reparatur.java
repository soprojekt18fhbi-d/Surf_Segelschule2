package Domaenklassen;

//@author Darnel



public class Reparatur {
	
	private int id;
	private String Beschreibung;
	private double Kosten;
	private Geraet Geraet;
	
	
	public Reparatur(int id, String beschreibung, double kosten, Geraet geraet) {
		super();
		this.id = id;
		Beschreibung = beschreibung;
		Kosten = kosten;
		Geraet = geraet;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBeschreibung() {
		return Beschreibung;
	}
	public void setBeschreibung(String beschreibung) {
		Beschreibung = beschreibung;
	}
	public double getKosten() {
		return Kosten;
	}
	public void setKosten(double kosten) {
		Kosten = kosten;
	}
	public Geraet getGeraet() {
		return Geraet;
	}
	public void setGeraet(Geraet geraet) {
		Geraet = geraet;
	}

}

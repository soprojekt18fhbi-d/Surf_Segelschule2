package Domaenklassen;

import Steuerung.Fuehrerschein;

public class Kunde {

	private int lastKundennummer = 10000;
	
	private int kundennummer;
	private String name;
	private String vorname;
	private Adresse heimadresse;
	private Adresse urlaubsadresse;
	private boolean surfschein;
	private boolean segelschein;
	private boolean motorbootschein;
<<<<<<< HEAD
	private String email;
=======
	private int geburtsdatum;
	private boolean bestandskunde;
>>>>>>> branch 'master' of https://github.com/soprojekt18fhbi-d/Surf_Segelschule
	
	
<<<<<<< HEAD
	public Kunde(String name, String vorname, Adresse adresse, Boolean surfschein, Boolean segelschein, Boolean motorbootschein, int kundennummer, String email) {
		this.kundennummer = kundennummer;
=======
	public Kunde(String name, String vorname, Adresse heimadresse, Adresse urlaubsadresse, Boolean surfschein, Boolean segelschein, Boolean motorbootschein, int geburtsdatum) {
		this.kundennummer = ++lastKundennummer;
		
>>>>>>> branch 'master' of https://github.com/soprojekt18fhbi-d/Surf_Segelschule
		this.name = name;
		this.vorname = vorname;
		this.heimadresse = heimadresse;
		this.urlaubsadresse = urlaubsadresse;
		this.surfschein = surfschein;
		this.segelschein = segelschein;
		this.motorbootschein = motorbootschein;
<<<<<<< HEAD
		this.setEmail(email);
=======
		this.geburtsdatum = geburtsdatum;
		this.bestandskunde = false;
		
>>>>>>> branch 'master' of https://github.com/soprojekt18fhbi-d/Surf_Segelschule
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public int getKundennummer() {
		return kundennummer;
	}
	
	public boolean isSurfschein() {
		return surfschein;
	}
	public void setSurfschein(boolean surfschein) {
		this.surfschein = surfschein;
	}
	public boolean isSegelschein() {
		return segelschein;
	}
	public void setSegelschein(boolean segelschein) {
		this.segelschein = segelschein;
	}
	public boolean isMotorbootschein() {
		return motorbootschein;
	}
	public void setMotorbootschein(boolean motorbootschein) {
		this.motorbootschein = motorbootschein;
	}

	public void drucken(){
		System.out.println("\n" + this.kundennummer + ": " + this.name + ", " + this.vorname) ;
		this.heimadresse.drucken();
	}
	
	@Override
	public String toString(){
		return this.kundennummer + ";" + this.name + ";" + this.vorname + ";" + this.segelschein + ";" + this.surfschein + ";" + this.motorbootschein + ";"+  this.heimadresse.toString(); 
	}
	public Fuehrerschein getFuehrerschein() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}

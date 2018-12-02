package Domaenklassen;

//@author Darnel


public class Kunde {

	private int lastKundennummer = 10000;
	
	private int kundennummer;
	private String name;
	private String vorname;
	private boolean surfschein;
	private boolean segelschein;
	private boolean motorbootschein;
	private String email;



	public Kunde(String name, String vorname, String email, Boolean surfschein, Boolean segelschein, Boolean motorbootschein) {

		this.name = name;
		this.vorname = vorname;
		this.surfschein = surfschein;
		this.segelschein = segelschein;
		this.motorbootschein = motorbootschein;
		this.email = email;

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
	}
	
	@Override
	public String toString(){
		return this.kundennummer + ";" + this.name + ";" + this.vorname + ";" + this.segelschein + ";" + this.surfschein + ";" + this.motorbootschein + ";".toString(); 
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}

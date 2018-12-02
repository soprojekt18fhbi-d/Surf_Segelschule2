package Domaenklassen;

//@author Darnel

class Wirtschaftlichkeit {
	
	private int wirtschaftlichkeitId;
	private double kosten;
	private double umsatz;
	private double gewinn;
	
	
	public Wirtschaftlichkeit(int id, double kosten, double umsatz, double gewinn) {
		super();
		this.wirtschaftlichkeitId = id;
		this.kosten = kosten;
		this.umsatz = umsatz;
		this.gewinn = gewinn;
	}


	public int getId() {
		return wirtschaftlichkeitId;
	}


	public void setId(int id) {
		this.wirtschaftlichkeitId = id;
	}


	public double getKosten() {
		return kosten;
	}


	public void setKosten(double kosten) {
		this.kosten = kosten;
	}


	public double getUmsatz() {
		return umsatz;
	}


	public void setUmsatz(double umsatz) {
		this.umsatz = umsatz;
	}


	public double getGewinn() {
		return gewinn;
	}


	public void setGewinn(double gewinn) {
		this.gewinn = gewinn;
	}

}

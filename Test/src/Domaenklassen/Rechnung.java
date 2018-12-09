package Domaenklassen;

//@author Darnel

public class Rechnung {
	

	private int id;
	private double summe;
	private double mwSt;
	private double betrag;
	private double bezahlt;
	private int bezahldatum;
	private IKunde kunde;
	private Reparatur reparatur;
	
	
	public Rechnung(int id, double summe, double mwSt, double betrag, double bezahlt, int bezahldatum, IKunde kunde) {
		super();
		this.id = id;
		this.summe=summe;
		this.mwSt=mwSt;
		this.betrag=betrag;
		this.bezahlt = bezahlt;
		this.bezahldatum = bezahldatum;
		this.kunde = kunde;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBezahlt() {
		return bezahlt;
	}

	public void setBezahlt(double bezahlt) {
		this.bezahlt = bezahlt;
	}

	public int getBezahldatum() {
		return bezahldatum;
	}

	public void setBezahldatum(int bezahldatum) {
		this.bezahldatum = bezahldatum;
	}

	public IKunde getKunde() {
		return kunde;
	}

	public double getSumme() {
		return summe;
	}

	public double getMwSt() {
		return mwSt;
	}

	public double getBetrag() {
		return betrag;
	}
	
	public void setKunde(IKunde kunde) {
		this.kunde = kunde;
	}

	public Reparatur getReparatur() {
		return reparatur;
	}

	public void setReparatur(Reparatur reparatur) {
		this.reparatur = reparatur;
	}
	
	
	

}

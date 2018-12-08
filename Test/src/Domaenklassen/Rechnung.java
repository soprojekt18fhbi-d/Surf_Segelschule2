package Domaenklassen;

//@author Darnel

public class Rechnung {
	
	private int id;
	private double bezahlt;
	private int bezahldatum;
	private IKunde kunde;
	private Reparatur reparatur;
	
	public Rechnung(int id, double bezahlt, int bezahldatum, IKunde kunde) {
		super();
		this.id = id;
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

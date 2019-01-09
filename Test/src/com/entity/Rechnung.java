package com.entity;

//@author Darnel

public class Rechnung {

	private int id;
	private double summe;
	private double mwSt;
	private double summe_mit_mwst;
	private IKunde kunde;
	private Reparatur reparatur;
	private Buchung buchung;

	public Rechnung(int id, double summe, double mwSt, double summe_mit_mwst, IKunde kunde, Buchung buchung) {
		super();
		this.id = id;
		this.summe = summe;
		this.mwSt = mwSt;
		this.summe_mit_mwst = summe_mit_mwst;
		this.kunde = kunde;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getSumme_mit_mwst() {
		return summe_mit_mwst;
	}

	public void setSumme_mit_mwst(double summe_mit_mwst) {
		this.summe_mit_mwst = summe_mit_mwst;
	}

	public Buchung getBuchung() {
		return buchung;
	}

	public void setBuchung(Buchung buchung) {
		this.buchung = buchung;
	}

	public void setSumme(double summe) {
		this.summe = summe;
	}

	public void setMwSt(double mwSt) {
		this.mwSt = mwSt;
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
		return summe_mit_mwst;
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

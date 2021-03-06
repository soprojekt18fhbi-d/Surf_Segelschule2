package com.entity;

/**
 * @author Michael Schmidt
 */
public class SportGeraet extends GeraeteModell {

	private int typID;
	private String name;
	private String führerschein;
	private String modellName;
	private int modellID;
	private int kostenID;
	private String farbe;
	private int geraeteID;
	private double verkaufspreis;
	private double anschaffungspreis;
	private int status;
	private String makel;

	public SportGeraet(int id, String name, String führerschein, String modellName, int modellID, int kostenID,
			int geraeteID, String farbe, double verkaufspreis, double anschaffungspreis, int status, String makel) {
		super(id, name, führerschein, modellName, modellID, kostenID);
		this.name = name;
		this.typID = id;
		this.führerschein = führerschein;
		this.modellName = modellName;
		this.modellID = modellID;
		this.kostenID = kostenID;
		this.geraeteID = geraeteID;
		this.farbe = farbe;
		this.verkaufspreis = verkaufspreis;
		this.setAnschaffungspreis(anschaffungspreis);
		this.status = status;
		this.setMakel(makel);
	}

	public int getGeraeteID() {
		return geraeteID;
	}

	public void setGeraeteID(int geräteID) {
		this.geraeteID = geräteID;
	}

	public String getFarbe() {
		return farbe;
	}

	public void setFarbe(String farbe) {
		this.farbe = farbe;
	}

	public double getVerkaufsPreis() {
		return verkaufspreis;
	}

	public void setVerkaufsPreis(double verkaufsPreis) {
		this.verkaufspreis = verkaufsPreis;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getModellName() {
		return modellName;
	}

	public void setModellName(String bezeichnung) {
		this.modellName = bezeichnung;
	}

	public int getTypID() {
		return typID;
	}

	public void setTypID(int id) {
		this.typID = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String bezeichnung) {
		this.name = bezeichnung;
	}

	public String getFührerschein() {
		return führerschein;
	}

	public void setFührerschein(String schein) {
		this.führerschein = schein;
	}

	public int getKosten() {
		return kostenID;
	}

	public void setKosten(int kostenID) {
		this.kostenID = kostenID;
	}

	public int getModellID() {
		return modellID;
	}

	public void setModellID(int modellID) {
		this.modellID = modellID;
	}

	public double getAnschaffungspreis() {
		return anschaffungspreis;
	}

	public void setAnschaffungspreis(double anschaffungspreis) {
		this.anschaffungspreis = anschaffungspreis;
	}

	public String getMakel() {
		return makel;
	}

	public void setMakel(String makel) {
		this.makel = makel;
	}

}

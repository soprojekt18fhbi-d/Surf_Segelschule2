package com.entity;

/**
 * @author Michael Schmidt
 */
public class GeraeteModell extends GeraeteTyp {

	private int typID;
	private String name;
	private String f�hrerschein;
	private String modellName;
	private int modellID;
	private int kostenID;

	public GeraeteModell(int id, String name, String f�hrerschein, String modellName, int modellID, int kostenID) {
		super(id, name, f�hrerschein);
		this.name = name;
		this.typID = id;
		this.f�hrerschein = f�hrerschein;
		this.modellName = modellName;
		this.modellID = modellID;
		this.kostenID = kostenID;
	}

	public int getModellID() {
		return modellID;
	}

	public void setModellID(int modellID) {
		this.modellID = modellID;
	}

	public String getName() {
		return name;
	}

	public void setName(String bezeichnung) {
		this.name = bezeichnung;
	}

	public int getTypID() {
		return typID;
	}

	public void setTypID(int id) {
		this.typID = id;
	}

	public String getF�hrerschein() {
		return f�hrerschein;
	}

	public void setF�hrerschein(String schein) {
		this.f�hrerschein = schein;
	}

	public int getKosten() {
		return kostenID;
	}

	public void setKosten(int kostenID) {
		this.kostenID = kostenID;
	}

	public String getModellName() {
		return modellName;
	}

	public void setModellName(String modellName) {
		this.modellName = modellName;
	}

}

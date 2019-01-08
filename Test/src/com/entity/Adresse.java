// @author Darnel

package com.entity;

public class Adresse implements IAdresse {
	private String strasse;
	private String ort;
	private int plz;
	private String hausnummer;
	private String art;
	

	public Adresse(String strasse, String hausnummer, String ort, int plz, String art) {
		this.strasse = strasse;
		this.hausnummer = hausnummer;
		this.ort = ort;
		this.plz = plz;
		this.art = art;
	}

	/* (non-Javadoc)
	 * @see Domaenklassen.IAdresse#getStrasse()
	 */
	@Override
	public String getStrasse() {
		return this.strasse;
	}

	/* (non-Javadoc)
	 * @see Domaenklassen.IAdresse#setStrasse(java.lang.String)
	 */
	@Override
	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	/* (non-Javadoc)
	 * @see Domaenklassen.IAdresse#getOrt()
	 */
	@Override
	public String getOrt() {
		return this.ort;
	}

	/* (non-Javadoc)
	 * @see Domaenklassen.IAdresse#setOrt(java.lang.String)
	 */
	@Override
	public void setOrt(String ort) {
		this.ort = ort;
	}

	/* (non-Javadoc)
	 * @see Domaenklassen.IAdresse#getPlz()
	 */
	@Override
	public int getPlz() {
		return this.plz;
	}

	/* (non-Javadoc)
	 * @see Domaenklassen.IAdresse#setPlz(int)
	 */
	@Override
	public void setPlz(int plz) {
		this.plz = plz;
	}

	/* (non-Javadoc)
	 * @see Domaenklassen.IAdresse#getHausnummer()
	 */
	@Override
	public String getHausnummer() {
		return this.hausnummer;
	}

	/* (non-Javadoc)
	 * @see Domaenklassen.IAdresse#setHausnummer(java.lang.String)
	 */
	@Override
	public void setHausnummer(String hausnummer) {
		this.hausnummer = hausnummer;
	}
	
	/* (non-Javadoc)
	 * @see Domaenklassen.IAdresse#getArt()
	 */
	@Override
	public String getArt() {
		return art;
	}

	/* (non-Javadoc)
	 * @see Domaenklassen.IAdresse#setArt(java.lang.String)
	 */
	@Override
	public void setArt(String art) {
		this.art = art;
	}
	
	/* (non-Javadoc)
	 * @see Domaenklassen.IAdresse#toString()
	 */
	public String toString(){
		return this.strasse + ";" + this.hausnummer + ";" + this.plz + ";" + this.ort;
	}
	
	

}

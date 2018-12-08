package Domaenklassen;

public interface IAdresse {

	String getStrasse();

	void setStrasse(String strasse);

	String getOrt();

	void setOrt(String ort);

	int getPlz();

	void setPlz(int plz);

	String getHausnummer();

	void setHausnummer(String hausnummer);

	String getArt();

	void setArt(String art);

	String toString();

}
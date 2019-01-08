package com.entity;

public interface IKunde {

	String getName();

	void setName(String name);

	String getVorname();

	void setVorname(String vorname);

	int getKundennummer();

	boolean isSurfschein();

	void setSurfschein(boolean surfschein);

	boolean isSegelschein();

	void setSegelschein(boolean segelschein);

	boolean isMotorbootschein();

	void setMotorbootschein(boolean motorbootschein);

	void drucken();

	String toString();

	String getEmail();

	void setEmail(String email);

	boolean getSurfschein();

	boolean getSegelschein();

	boolean getMotorbootschein();

	void setKundennummer(int nummer);

}
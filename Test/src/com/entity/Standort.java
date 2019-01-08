package com.entity;

//@author Darnel

public class Standort {
	
	private int id;
	private int telefonnummer;
	private IAdresse adresse;
	
	public Standort(int id, int telefonnummer, IAdresse adresse) {
		super();
		this.id = id;
		this.telefonnummer = telefonnummer;
		this.adresse = adresse;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTelefonnummer() {
		return telefonnummer;
	}
	public void setTelefonnummer(int telefonnummer) {
		this.telefonnummer = telefonnummer;
	}
	public IAdresse getAdresse() {
		return adresse;
	}
	public void setAdresse(IAdresse adresse) {
		this.adresse = adresse;
	}
	
	
	

}

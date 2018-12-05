package Domaenklassen;


/**
 * @author michi
 */
public class GeraeteTyp {
	private int typID;
	private String typName;
	private String führerschein;
	
	
	public GeraeteTyp(int id, String name, String führerschein){
		this.typName = name;
		this.typID = id;
		this.führerschein = führerschein;
	}

	public int getTypID() {
		return typID;
	}

	public void setTypID(int typID) {
		this.typID = typID;
	}

	public String getName() {
		return typName;
	}

	public void setName(String typName) {
		this.typName = typName;
	}
	

	public String getFührerschein() {
		return führerschein;
	}

	public void setFührerschein(String führerschein) {
		this.führerschein = führerschein;
	}
	
}

package Domaenklassen;


/**
 * @author michi
 */
public class GeraeteTyp {
	private int typID;
	private String typName;
	private String f�hrerschein;
	
	
	public GeraeteTyp(int id, String name, String f�hrerschein){
		this.typName = name;
		this.typID = id;
		this.f�hrerschein = f�hrerschein;
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
	

	public String getF�hrerschein() {
		return f�hrerschein;
	}

	public void setF�hrerschein(String f�hrerschein) {
		this.f�hrerschein = f�hrerschein;
	}
	
}

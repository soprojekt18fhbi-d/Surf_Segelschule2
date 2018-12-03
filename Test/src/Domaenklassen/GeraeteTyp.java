package Domaenklassen;
import java.util.ArrayList;

/**
 * @author michi
 */
public class GeraeteTyp {
	private String typID;
	private String typName;
	private String f�hrerschein;
	
	public ArrayList<GeraeteTyp>listeTypen = new ArrayList<GeraeteTyp>();
	
	public GeraeteTyp(String name, String id){
		this.typName = name;
		this.typID = id;
	}

	public String getTypID() {
		return typID;
	}

	public void setTypID(String typID) {
		this.typID = typID;
	}

	public String getTypName() {
		return typName;
	}

	public void setTypName(String typName) {
		this.typName = typName;
	}
	
	public void hinzufuegen(GeraeteTyp element){
		listeTypen.add(element);
	}
	
	public void entfernen(GeraeteTyp element){
		listeTypen.remove(element);
	}

	public String getF�hrerschein() {
		return f�hrerschein;
	}

	public void setF�hrerschein(String f�hrerschein) {
		this.f�hrerschein = f�hrerschein;
	}
	
}

package Domaenklassen;
import java.util.ArrayList;

/**
 * @author michi
 */
public class GeraeteTyp {
	private int typID;
	private String typName;
	private String f�hrerschein;
	
	public ArrayList<GeraeteTyp>listeTypen = new ArrayList<GeraeteTyp>();
	
	public GeraeteTyp(String name){
		this.typName = name;
	}

	public int getTypID() {
		return typID;
	}

	public void setTypID(int typID) {
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

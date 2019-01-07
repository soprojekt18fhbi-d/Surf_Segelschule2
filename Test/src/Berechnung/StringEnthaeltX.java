package Berechnung;

public class StringEnthaeltX {

	public static boolean stringIstZahl(String str)  
	{  
	    try {
	    	if (str.isEmpty()==false) {
	    		double d = Double.parseDouble(str);
	    	}
	        
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}  
	
	
	public static boolean stringIstKeineZahl(String str)
	{ 
		boolean zahl = stringIstZahl(str);
		if (zahl == false) {
			return true;
		}
		else
			return false;
	}
	
}

/**
 * @author BenS
 */

package Berechnung;

public class DatentypUmwandlung {

	public static double stringZuDouble(String string) {
		
		//null kann nicht als Double Wert gespeichert werden -> Strings werden überprüft
		Double zahl=0.0;
		try {
			if (string.isEmpty()==false){
				string.replace(',', '.');
				System.out.println(string);
				zahl = Double.valueOf(string);
			}
			
		}
		catch(NumberFormatException numFormExc){
			
		}
		return zahl;
	}
	
	
	public static String doubleZuString(double zahl) {
		
		//null kann nicht als Double Wert gespeichert werden -> Strings werden überprüft
		
		String string=null;
		try {
			if (zahl > 0.0){
				string = "'"+String.valueOf(zahl)+"'";
			}
		}
		catch(NumberFormatException numFormExc){
			
		}
		return string;
	}
	
}

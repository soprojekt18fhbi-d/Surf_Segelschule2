package Berechnung;

public class DatentypUmwandlung {

	public static double stringZuDouble(String string) {
		
		//null kann nicht als Double Wert gespeichert werden -> Strings werden überprüft
		System.out.println(string +" TestString");
		Double zahl=0.0;
		if (string.isEmpty()==false || string!= "0,0" || string !="0" || string !="0.0"){
			zahl = Double.parseDouble(string);
		}
		System.out.println(zahl);
		return zahl;
	}
	
	
	public static String doubleZuString(double zahl) {
		
		//null kann nicht als Double Wert gespeichert werden -> Strings werden überprüft
		
		String string=null;
		if (zahl > 0.0){
			string = String.valueOf(zahl);
		}

		return string;
	}
	
}

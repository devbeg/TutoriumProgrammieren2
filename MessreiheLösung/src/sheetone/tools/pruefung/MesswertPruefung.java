package sheetone.tools.pruefung;




import sheetone.messdaten.Messwert;

public class MesswertPruefung implements IMesswertPruefung{


	
	public  boolean checkForEmptySpaces(Messwert[] messwerte) {
	
		for (Messwert messwert : messwerte) {
			if(messwert == null){
				System.err.println("Failure.Not all fields contain a value");
				return false;
			}
			
		}
		return true;
	}


	public  boolean checkSkalaValuation(Messwert[] messwerte, double min,
			double max) {

		for (Messwert messwert : messwerte) {
			if(messwert.getWert() < min || messwert.getWert() > max){
				
				System.err.println(messwert.getWert() + " not in range! [" + min + "," + max + "]");
				return false;
			}
		}
		return true;
	}

	

	
	

}

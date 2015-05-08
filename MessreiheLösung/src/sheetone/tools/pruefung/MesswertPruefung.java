package sheetone.tools.pruefung;

import sheetone.messdaten.Messwert;

public class MesswertPruefung implements IMesswertPruefung{


	
	/* Überprüft das array auf Nullstellen, die auf ein Fehlerhaftes Verhalten beim adden hindeuten
	 * @see sheetone.tools.pruefung.IMesswertPruefung#checkForEmptySpaces(sheetone.messdaten.Messwert[])
	 */
	public  boolean checkForEmptySpaces(Messwert[] messwerte) {
	
		for (Messwert messwert : messwerte) {
			if(messwert == null){
				System.err.println("Failure.Not all fields contain a value");
				return false;
			}
			
		}
		return true;
	}


	/* Diese Methode überprüft für jeden Wert ob er sich innerhalb eines Wertebereichs liegt. Bei Interesse kann ich das gleiche Verhalten unter
	 * Verwendung von regulären Ausdrücken zeigen
	 * @see sheetone.tools.pruefung.IMesswertPruefung#checkSkalaValuation(sheetone.messdaten.Messwert[], double, double)
	 */
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

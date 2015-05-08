package sheetone.temperaturmessung;

import java.util.GregorianCalendar;

import sheetone.custom.enums.Skala;
import sheetone.messdaten.Messwert;


/** Diese Klasse erbt von der Oberklasse Messwert. Dadurch beinhaltet sie alle deren Methoden und Parameter und kann diese erweitern bzw. das
 * Verhalten für sich anpassen.
 * @author Marcel
 *
 */
public class Temperatur extends Messwert{
	
	private Skala skala;
	private boolean isValidated;
	

	public Temperatur(double messwert, GregorianCalendar messDatum,Skala skala) {
		super(messwert, messDatum);
		this.skala = skala;
	}


	public boolean isValidated() {
		return isValidated;
	}
	
	
	public void setValidated(boolean isValidated) {
		this.isValidated = isValidated;
	}
	
	
	public Skala getSkala() {
		return skala;
	}
	
	
	
	/* Erweiter die to toString Methode der Obeklasse durch den Parameter skala.
	 * @see sheetone.messdaten.Messwert#toString()
	 */
	@Override
	public String toString() {
		
		/**Bitte nicht verwirrt sein. Der Klasse StringBuilder kann bei instanziierung gleich ein 
		   String als Startwert mitgegeben werden.Durch den Aufruf super.toString() wird die toString Methode der Oberklasse aufgerufen,
		   die eine String Präsentation der Klasse zurück liefert.
		    * Die Ausgabe würde wie folgt aussehen: 
		    * 
		    * 			sheetone.temperaturmessung.Temperatur Object { 
		    *			ID: 0
		    *			Wert: 11.874357288129577
		    *			Datum: 9-4-2015
		    *			Skala: CELSIUS }
		    								**/
		StringBuilder builder = new StringBuilder(super.toString());
		
		builder.insert(this.INDEX_FOR_INSERT,"Skala: " + this.skala);
		return builder.toString();
	}
	

}

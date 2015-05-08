package sheetone.messdaten;

import java.util.GregorianCalendar;


/** Implementiert das Interface IMesswert
 * @author Marcel
 *
 */
public class Messwert implements IMesswert {

	protected int INDEX_FOR_INSERT;

	protected static int anzahlMesswerte;
	protected double wert;
	protected GregorianCalendar messDatum;
	protected int messwertID;
	

	
	/**Der geschütze Konstruktor erlaubt nur die Nutzung aus dem gleichen Paket heraus oder durch erbende Klassen.
	 * Dadurch nimmt die Klasse die Rolle einer Oberklasse an, von der geerbt und das Verhalten für den speziellen Zweck angepasst werden kann
	 * --> Siehe Temperatur
	 * @param messwert
	 * @param messDatum
	 */
	protected Messwert(double messwert,GregorianCalendar messDatum){
		
		this.messwertID = anzahlMesswerte++;
		this.wert = messwert;
		this.messDatum = messDatum;
	}
		
	

	/**In der Klasse wurde absichtlich für die ID nur ein getter gesetzt und kein setter. Die ID wird im Konstruktor vergeben.
	 * Dadurch kann die ID im Nachhinein nicht mehr von außen verändert werden.Da der Messwert durch die ID identifiziert wird,
	 * muss diese fix sein und darf nicht mehr verändert werden!
	 * **/
	



	public double getWert() {
		return wert;
	}

	

	public void setWert(double wert) {
		this.wert = wert;
	}



	public void setMessDatum(GregorianCalendar messDatum) {
		this.messDatum = messDatum;
	}



	public GregorianCalendar getMessDatum() {
		return messDatum;
	}
	
	/**Diese Methode gibt das Datum als lesbaren String zurück **/
	public String getMessDatumAsString() {
		return    
		String.valueOf(messDatum.get(GregorianCalendar.DAY_OF_MONTH)) + "-" + 
		String.valueOf(messDatum.get(GregorianCalendar.MONTH)) + "-" +        
		String.valueOf(messDatum.get(GregorianCalendar.YEAR));
	}



	public int getMesswertID() {
		return messwertID;
	}
	
	
	
	/** 
	 * Eine Überladung der toString Methode, die durch die Klasse StringBuilder realisiert wurde. Die Klasse erleichtert das
	 * Zusammensetzen von Strings ohne die "+" Notation. 
	 * 
	 * Klassendefinition: https://docs.oracle.com/javase/7/docs/api/java/lang/StringBuilder.html
	 * 
	 * Die Ausgabe würde wie folgt aussehen: 
	 * 
	 * 			sheetone.messdaten.Messwert Object { 
	 *			ID: 0
     *			Wert: 11.874357288129577
     *			Datum: 9-4-2015}
     *
     *Durch vererbung kann diese Methode dann von den Unterklassen ohne neue Implementierung verwendet und bei Bedarf erweitert werden
	 * 
	 * **/
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder builder = new StringBuilder();
		builder.append(getClass().getName().toString() + " Object { \n");
		builder.append("ID: " + this.getMesswertID() +"\n");
		builder.append("Wert: " +  this.getWert() +"\n");
		builder.append("Datum: " +  this.getMessDatumAsString() +"\n }");
		
		this.INDEX_FOR_INSERT = builder.indexOf("}") - 1;
		
		return builder.toString();
	}

	
}

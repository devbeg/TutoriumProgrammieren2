package sheetone.temperaturmessung;

import java.util.GregorianCalendar;

import sheetone.custom.enums.Skala;
import sheetone.messdaten.Messreihe;
import sheetone.messdaten.Messwert;
import sheetone.tools.pruefung.MesswertPruefung;

public class TemperaturMessreihe extends Messreihe {

	private Skala skala;

	public TemperaturMessreihe(int messwertAnzahl, Skala skala) {
		super(messwertAnzahl);
		this.messwerte = new Temperatur[messwertAnzahl];
		this.skala = skala;
	}

	
	/* Erstellt aus dem messwert und dem datum eine Temperatur und f[gt diese in das array falls platz ist
	 * ansonsten wird eine Exception geworfen. Diese Exception muss in der Methodendeklaration angekündigt werden,
	 * damit aufrufender Code die Exception mit try/catch abfangen oder nach oben weiterreichen kann.
	 * @see sheetone.messdaten.Messreihe#addMesswert(double, java.util.GregorianCalendar)
	 */
	@Override
	public void addMesswert(double messwert, GregorianCalendar datum)
			throws IndexOutOfBoundsException {

		if (index == messwerte.length) {
			throw new IndexOutOfBoundsException(
					"The container for the messwerte is already full");
		} else {
			messwerte[index++] = new Temperatur(messwert, datum, this.skala);
		}
	}

	
	@Override
	public Temperatur getMesswert(GregorianCalendar datum) throws IllegalArgumentException {

		/** 
		 * Eine sog. foreach Schleife
		 * syntax (Datentyp variablenname : container)
		 * Es wird zunächst der Datentyp der Elemente im Container genannt, anschließend ein variablen Name und
		 * zum schluss der container (array,liste,map etc) durch das iteriert werden soll.
		 * Java nimmt dann jeden einzelnen wert aus dem Array und packt ihn in die variable.
		 * Vorteile: 
		 * -	kürzere Schreibweise
		 * -	keine Fehler durch falsche längen angaben
		 * Nachteile:
		 * -	kein index
		 * **/
		for(Messwert messung : this.messwerte) {
			if (messung.getMessDatum().equals(datum)) {
				if(!(messung instanceof Temperatur)){
					throw new IllegalArgumentException("the container contains wrong types");}
				else{
				return (Temperatur)messung;}
			}
		}
		return null;
	}

	
	/* Aufruf der Prüfung.Setzt das Attribute der Klasse auf true oder false, daran lässt sich von außen schnell erkennen
	 * ob die Klasse erfolgreich validiert wurde.
	 * @see sheetone.messdaten.Messreihe#runValidation(double, double)
	 */
	@Override
	public void runValidation(double min,double max) {
		MesswertPruefung pruefung = new MesswertPruefung();
		this.validated = pruefung.checkForEmptySpaces(messwerte);
		this.validated = pruefung.checkSkalaValuation(messwerte, min,max);
	}

	
	
	/**Print ist eine allgemeine alternative zu toString()
	 * @return
	 */
	public String print() {
		// TODO Auto-generated method stub
		StringBuilder builder = new StringBuilder();
		builder.append(getClass().getSimpleName() + " Object { \n");
		builder.append("ID: " + this.id + "\n");
		builder.append("Anzahl Messwerte: " + this.messwerte.length + "\n");
		builder.append("Skala: " + this.skala + "\n");
		builder.append("Geprueft: " + this.validated + "\n }");
		return builder.toString();
	}


}

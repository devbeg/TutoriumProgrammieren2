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

		for (Messwert messung : this.messwerte) {
			if (messung.getMessDatum().equals(datum)) {
				if(!(messung instanceof Temperatur)){
					throw new IllegalArgumentException("the container contains wrong types");}
				else{
				return (Temperatur)messung;}
			}
		}
		return null;
	}

	@Override
	public void runValidation(double min,double max) {
		MesswertPruefung pruefung = new MesswertPruefung();
		this.validated = pruefung.checkForEmptySpaces(messwerte);
		this.validated = pruefung.checkSkalaValuation(messwerte, min,max);
	}

	
	
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

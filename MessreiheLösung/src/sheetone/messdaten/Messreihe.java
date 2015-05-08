package sheetone.messdaten;

import java.util.GregorianCalendar;
import java.util.UUID;


/** Die abstrakte Klasse wird verwendet um gleiches Verhalten in einer Klasse zu abstrahieren. Dadurch wird gleiches Verhalten, das
 * in allen Unterklassen nötig ist, in einer Klasse vereint und nimmt damit die erneute Implementierung ab.Dies betrifft vorallem die deklaration 
 * und initialisierung von parametern und Konstruktoren, sowie gleichen Methoden. Die abstrakten Methoden müssen durch die Unterklassen implementiert werden
 * ansonsten wird die Unterklasse selbst abstrakt. Abstrakte Klassen können nicht instanziiert werden!
 * @author Marcel
 *
 */
public abstract class Messreihe implements Cloneable, IMessreihe {

	protected int countValues;
	protected final UUID id;
	protected Messwert[] messwerte;
	protected int index;
	protected boolean validated = false;

	
	public Messreihe(int messwertAnzahl) {
		this.countValues = messwertAnzahl;
		id = UUID.randomUUID();
		index = 0;
		
	}

	/* (non-Javadoc)
	 * @see sheetone.messdaten.IMessreihe#addMesswert(double, java.util.GregorianCalendar)
	 */
	@Override
	public abstract void addMesswert(double messwert, GregorianCalendar datum);

	/* (non-Javadoc)
	 * @see sheetone.messdaten.IMessreihe#getMesswert(java.util.GregorianCalendar)
	 */
	@Override
	public abstract Messwert getMesswert(GregorianCalendar datum);
	
	/* (non-Javadoc)
	 * @see sheetone.messdaten.IMessreihe#runValidation(double, double)
	 */
	@Override
	public abstract void runValidation(double min,double max);
	
	

	
	/* (non-Javadoc)
	 * @see sheetone.messdaten.IMessreihe#getId()
	 */
	@Override
	public UUID getId() {
		return id;
	}

	/* (non-Javadoc)
	 * @see sheetone.messdaten.IMessreihe#getMesswerte()
	 */
	@Override
	public Messwert[] getMesswerte() {
		return messwerte;
	}


}

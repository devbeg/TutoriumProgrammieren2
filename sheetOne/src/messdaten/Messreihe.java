package messdaten;

import java.util.GregorianCalendar;
import java.util.UUID;


public abstract class Messreihe implements Cloneable {

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

	public abstract void addMesswert(double messwert, GregorianCalendar datum);

	public abstract Messwert getMesswert(GregorianCalendar datum);
	
	public abstract void runValidation(double min,double max);

	
	public UUID getId() {
		return id;
	}

	public Messwert[] getMesswerte() {
		return messwerte;
	}


}

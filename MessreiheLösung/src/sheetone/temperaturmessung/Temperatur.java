package sheetone.temperaturmessung;

import java.util.GregorianCalendar;

import sheetone.custom.enums.Skala;
import sheetone.messdaten.Messwert;

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
	
	
	@Override
	public String toString() {
		
		StringBuilder builder = new StringBuilder(super.toString());
		
		builder.insert(this.INDEX_FOR_INSERT,"Skala: " + this.skala);
		return builder.toString();
	}
	

}

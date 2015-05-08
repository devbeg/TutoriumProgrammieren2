package sheetone.messdaten;

import java.util.GregorianCalendar;


public class Messwert implements IMesswert {

	protected int INDEX_FOR_INSERT;

	protected static int anzahlMesswerte;
	protected double wert;
	protected GregorianCalendar messDatum;
	protected int messwertID;
	

	
	protected Messwert(double messwert,GregorianCalendar messDatum){
		
		this.messwertID = anzahlMesswerte++;
		this.wert = messwert;
		this.messDatum = messDatum;
	}
		
	

	protected static int getAnzahlMesswerte() {
		return anzahlMesswerte;
	}


	public double getWert() {
		return wert;
	}

	public void setWert(double wert) {
		this.wert = wert;
	}

	public GregorianCalendar getMessDatum() {
		return messDatum;
	}


	public int getMesswertID() {
		return messwertID;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder builder = new StringBuilder();
		builder.append(getClass().getName().toString() + " Object { \n");
		builder.append("ID: " + this.getMesswertID() +"\n");
		builder.append("Wert: " +  this.getWert() +"\n");
		builder.append("Datum: " +  this.getMessDatum() +"\n }");
		
		this.INDEX_FOR_INSERT = builder.indexOf("}") - 1;
		
		return builder.toString();
	}

	
}

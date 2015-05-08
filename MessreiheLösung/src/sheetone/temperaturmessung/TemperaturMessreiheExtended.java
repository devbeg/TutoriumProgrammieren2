package sheetone.temperaturmessung;

import java.lang.reflect.Field;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import sheetone.custom.enums.Skala;
import sheetone.messdaten.Messreihe;
import sheetone.messdaten.Messwert;

public class TemperaturMessreiheExtended extends Messreihe {
	private Skala scala;


	private Map<Skala, Messwert[]> skalaColumnMap;
	private List<Skala> skalaSet;
	private Map<Skala, Integer> indizes;
	private Skala skala;
	boolean multi = false;

	

	public TemperaturMessreiheExtended(int messwertAnzahl, Skala skala) {
		super(messwertAnzahl);
		this.skala = skala;
		this.multi = false;

	}

	public TemperaturMessreiheExtended(int messwertAnzahl, List<Skala> skalaSet) {
		super(messwertAnzahl);
		this.skalaSet = skalaSet;
		this.multi = true;
		initializeSkalarMapping(skalaSet);
	}

	private void initializeSkalarMapping(List<Skala> skalaSet) {
		this.skalaColumnMap = new HashMap<Skala, Messwert[]>();

		for (int i = 0; i < skalaSet.size(); i++) {
			this.skalaColumnMap.put(skalaSet.get(i),
					new Temperatur[this.countValues]);
		}

	}

	public void addTemperatur(double messwert, GregorianCalendar datum,
			Skala skala) {
		if (this.skala == skala) {
			this.addMesswert(messwert, datum);
		}
		if (this.multi || this.skala != skala) {
			this.addToRightContainer(skala, new Temperatur(messwert, datum,
					skala));
		}
	}


	public boolean isMulti() {
		return multi;
	}
	
	public Skala getSkala() {
		return skala;
	}
	
	@Override
	public Messwert[] getMesswerte() {
		return messwerte;
	}

	public Messwert[] getTemperature(Skala skala) {

		return this.skalaColumnMap.get(skala);
	}

	
	public Map<Skala, Messwert[]> getSkalaColumnMap() {
		return skalaColumnMap;
	}
	
	
	public double getTemperatur(GregorianCalendar datum, Skala skala) {
		if (skala == null) {
			if (this.skalaSet.contains(Skala.CELSIUS)) {
				this.getTemperatur(datum, Skala.CELSIUS);
			}
			this.getTemperatur(datum, this.skalaSet.iterator().next());
		}
		for (Messwert messung : super.messwerte) {
			if (messung.getMessDatum().equals(datum)) {
				return messung.getWert();
			}
		}
		return -1;
	}

	private void addToRightContainer(Skala skala, Temperatur value)
			throws NullPointerException, IndexOutOfBoundsException {

		if (!this.multi) {
			this.skalaColumnMap = new HashMap<Skala, Messwert[]>();
			this.skalaColumnMap.put(this.skala, this.messwerte);
			this.skala = null;
			this.messwerte = null;
			this.multi = true;
		}

		if (!this.skalaColumnMap.keySet().contains(skala)) {
			this.skalaColumnMap.put(skala, new Temperatur[super.countValues]);
			this.indizes.put(skala, 0);

		}
		int index = this.indizes.get(skala);
		this.skalaColumnMap.get(skala)[index++] = value;

	}

	@Override
	protected TemperaturMessreiheExtended clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		TemperaturMessreiheExtended clone;

		if (this.scala == null) {
			clone = new TemperaturMessreiheExtended(this.countValues, this.skalaSet);
		} else {
			clone = new TemperaturMessreiheExtended(this.countValues, this.scala);
		}

		try {
			for (Field field : getClass().getFields()) {

				if (field.getName().equalsIgnoreCase("id")) {
					continue;
				}
				Object value = field.get(this);
				field.set(clone, value);

			}
			return clone;
		} catch (IllegalAccessException e) {
			return null;
		}
	}

	@Override
	public void addMesswert(double messwert, GregorianCalendar datum) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Messwert getMesswert(GregorianCalendar datum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void runValidation(double min, double max) {
		// TODO Auto-generated method stub
		
	}

}

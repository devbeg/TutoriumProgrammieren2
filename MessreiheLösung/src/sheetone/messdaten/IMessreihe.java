package sheetone.messdaten;

import java.util.GregorianCalendar;

public interface IMessreihe {

	double getWert();
	GregorianCalendar getMessDatum();
	int getMesswertID();
	
}

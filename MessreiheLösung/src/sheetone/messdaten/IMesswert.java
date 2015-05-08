package sheetone.messdaten;

import java.util.GregorianCalendar;

public interface IMesswert {

	double getWert();
	GregorianCalendar getMessDatum();
	int getMesswertID();
	
}

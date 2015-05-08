package sheetone.tools.pruefung;


import sheetone.messdaten.Messwert;


public interface IMesswertPruefung {

	
	 boolean checkForEmptySpaces(Messwert[] messwerte);
	
	 boolean checkSkalaValuation (Messwert[] messwerte,double min,double max);
	
	
	
}

package sheetone.main;

import java.util.Date;
import java.util.GregorianCalendar;

import sheetone.custom.enums.Skala;
import sheetone.temperaturmessung.TemperaturMessreihe;

public class Test {

	
	public static void main(String[] args) {
		
		//deklarationen können hintereinander geschrieben werden, falls sie den gleichen Datentyp haben
		int skalaUntergrenze = -273, skalaObergrenze = 273;
		
		GregorianCalendar calender = new GregorianCalendar();
		int messungen = 12;
		TemperaturMessreihe tempMessreihe = new TemperaturMessreihe(messungen, Skala.CELSIUS);
		
		
		for (int i = 0; i < messungen; i++) {
			double messwert = Math.random() * 100;
			tempMessreihe.addMesswert(messwert, calender);
		}
		
		tempMessreihe.runValidation(skalaUntergrenze, skalaObergrenze);
		
		System.out.println(tempMessreihe.print());
		
		
		
	}
	
	
}

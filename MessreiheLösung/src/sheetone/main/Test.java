package sheetone.main;

import java.util.GregorianCalendar;

import sheetone.custom.enums.Skala;
import sheetone.temperaturmessung.TemperaturMessreihe;

public class Test {

	
	public static void main(String[] args) {
		
		GregorianCalendar calender = new GregorianCalendar(2015, 10, 15);
		int messungen = 12;
		TemperaturMessreihe tempMessreihe = new TemperaturMessreihe(messungen, Skala.CELSIUS);
		
		
		for (int i = 0; i < messungen; i++) {
			double messwert = Math.random() * 100;
			tempMessreihe.addMesswert(messwert, calender);
		}
		
		tempMessreihe.runValidation(-273, 273);
		
		System.out.println(tempMessreihe.print());
		
		
		
	}
	
	
}

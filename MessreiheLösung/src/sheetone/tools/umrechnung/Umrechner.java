package sheetone.tools.umrechnung;

import sheetone.custom.enums.Skala;

public class Umrechner {

	private static final double KELVIN_NULL = 273.15;
	private static final int FAHRENHEIT_NULL = 32;
	private static final double DIVIDER = 1.8;

	private static double celsiusNachFahrenheit(double celsius) {
		return celsius * DIVIDER + FAHRENHEIT_NULL;
	}

	private static double fahrenheitNachCelsius(double fahrenheit) {
		return (fahrenheit - FAHRENHEIT_NULL) / DIVIDER;
	}

	private static double fahreneinheitNachKelvin(double fahrenheit) {
		double celsius = fahrenheitNachCelsius(fahrenheit);
		return celsius - KELVIN_NULL;
	}

	private static double KelvinNachFahrenheit(double kelvin) {
		double celsius = kelvin + KELVIN_NULL;
		return celsiusNachFahrenheit(celsius);

	}

	private static double CelsiusNachKelvin(double celsius) {
		return celsius + KELVIN_NULL;
	}

	private static double KelvinNachCelcius(double kelvin) {
		return kelvin - KELVIN_NULL;
	}

	public static double umrechnen(double value, Skala old, Skala target) {
		switch (old) {
		case CELSIUS:
			if (target == Skala.FAHRENHEIT) {
					return celsiusNachFahrenheit(value);
			} else {
				return CelsiusNachKelvin(value);
			}
		case FAHRENHEIT:
			if (target == Skala.CELSIUS) {
				return fahrenheitNachCelsius(value);
			} else {
				return fahreneinheitNachKelvin(value);
			}
		case KELVIN:
			if (target == Skala.FAHRENHEIT) {
				return KelvinNachFahrenheit(value);
			} else {
				return KelvinNachCelcius(value);
			}
		}
		
		String wrongParam = Skala.valueOf(old.toString()) == null ? "old" : "target" ; 
		
		throw new IllegalArgumentException("You have set a value for " + wrongParam + "that doesn't exists");
	}

}

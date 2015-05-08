package sheetone.messdaten;

import java.util.GregorianCalendar;
import java.util.UUID;



/** Es ist üblich für die wichtigen Klassen oder die etwas ausführlicheren ein Interface zu erstellen.
 *  Dies hat verschiedene Gründe:
 *  -	es kann sichergestellt werden dass eine Klasse eine Mindestanforderung an Methoden enthält
 *  -	es ist übersichtlicher sowohl für den Programmierer als auch für jeden der den Code danach in die Finger bekommt
 *  -	sie lassen eine Abstraktion der Klassen zu, die eine schnellere Übersicht über geplantes Verhalten einer Klasse erlauben
 * @author Marcel
 * In eclipse lassen sich aus fertigen Klassen leicht Interfaces generieren, indem man in der Klasse "refactor" und dann "extract interface" wählt
 */
public interface IMessreihe {

	public abstract void addMesswert(double messwert, GregorianCalendar datum);

	public abstract Messwert getMesswert(GregorianCalendar datum);

	public abstract void runValidation(double min, double max);

	public abstract UUID getId();

	public abstract Messwert[] getMesswerte();

}
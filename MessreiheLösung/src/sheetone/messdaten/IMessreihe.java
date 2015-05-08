package sheetone.messdaten;

import java.util.GregorianCalendar;
import java.util.UUID;



/** Es ist �blich f�r die wichtigen Klassen oder die etwas ausf�hrlicheren ein Interface zu erstellen.
 *  Dies hat verschiedene Gr�nde:
 *  -	es kann sichergestellt werden dass eine Klasse eine Mindestanforderung an Methoden enth�lt
 *  -	es ist �bersichtlicher sowohl f�r den Programmierer als auch f�r jeden der den Code danach in die Finger bekommt
 *  -	sie lassen eine Abstraktion der Klassen zu, die eine schnellere �bersicht �ber geplantes Verhalten einer Klasse erlauben
 * @author Marcel
 * In eclipse lassen sich aus fertigen Klassen leicht Interfaces generieren, indem man in der Klasse "refactor" und dann "extract interface" w�hlt
 */
public interface IMessreihe {

	public abstract void addMesswert(double messwert, GregorianCalendar datum);

	public abstract Messwert getMesswert(GregorianCalendar datum);

	public abstract void runValidation(double min, double max);

	public abstract UUID getId();

	public abstract Messwert[] getMesswerte();

}
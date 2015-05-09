// Datei: KleinteileMagazin_Vorlage.java

package magazin;

import java.util.ArrayList;

// Die benoetigten Klassen der hinzu gekauften
// Klassenbibliothek importieren
. . . . .

// Die generische Klasse soll Objekte vom Typ Teil verwalten koennen
public class KleinteileMagazin . . . . .
{
   // Das Vector<T>-Objekt dient als interne Datenstruktur
   private ArrayList<T> magazin;
   
   public KleinteileMagazin()
   {
      magazin = new ArrayList<T>();
   }

   // Aufnemhen des uebergebenen Postens in das Magazin 
   public boolean aufnehmen (T posten)
   {
      // Pruefen, ob der Posten mit Bezeichnung und Ausfuehrung schon vorhanden ist
      int index = . . . . .

      // Ist der Posten schon vorhanden, so soll die Methode false zurueckliefern
      . . . . .
      
      // Aufnehmen des Postens in das Magazin
      . . . . .
   }

   // Einlagern des Kleinteils in beschriebener Ausfuehrung
   public boolean einlagern (String bezeichnung, String ausfuehrung, int stueckzahl)
   {
      // Ist der Posten verfuegbar (Die vorhandene Stueckzahl ist egal)?
      int index = . . . . .

      // Wenn ja, dann die vorhandene Stueckzahl 
      // des Postens um die uebergebene Stueckzahl erhoehen
      if (index >= 0)
      {
         . . . . .
      }

      // Posten ist nicht vorhanden
      . . . . .
   }

   // Entnehmen des gewuenschten Kleinteils
   public boolean entnehmen (String bezeichnung, String ausfuehrung, int stueckzahl)
   {
      // Ist der gesuchte Posten in ausreichender Stueckzahl verfuegbar?
      int index = . . . . .

      // Wenn ja, dann die gewuenschte Stueckzahl entnehmen
      if (index >= 0)
      {
         . . . . .
      }
      
      // Nicht in ausreichender Stueckzahl verfuegbar
      . . . . .
   }
   
   
   // Den Bestand des Magazins ausdrucken
   public void druckeMagazin()
   {
      . . . . .
   }
   
   // Hilfsmethode, die ueberprueft, ob der Posten in Bezeichnung, Ausfuehrung und gewuenschter Stueckzahl 
   // schon im Magazin vorhanden ist. Sie liefert dann dessen Index im Vector<T>-Objekt zurueck, sonst -1  
   private int istVerfuegbar (String bezeichnung, String ausfuehrung, int anzahl)
   {
      // Suchen, bis der Posten in Bezeichnung und Ausfuehrung gefunden wurde.
      // Dann den Index im Vector<T>-Objekt zurueckliefern.
      for (T posten : magazin) 
      {
         . . . . .
      }
      
      // Nicht verfuegbar? -1 zurueckliefern.
      . . . . .
   }
}

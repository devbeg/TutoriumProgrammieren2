// Datei: RostfreieKleinteileMagazin.java

package magazin;

import java.util.ArrayList;

import teile.Rostfrei;
import teile.Teil;
import utils.TeileUtils;

//Die generische Klasse soll Objekte vom Typ Teil verwalten koennen
public class RostfreieKleinteileMagazin<T extends Teil<?> & Rostfrei> 
{
   // Das ArrayList<T>-Objekt dient als interne Datenstruktur
   private ArrayList<T> magazin;
   
   public RostfreieKleinteileMagazin()
   {
      magazin = new ArrayList<T>();
   }

   // Aufnemhen des uebergebenen Postens in das Magazin 
   public boolean aufnehmen (T posten)
   {
      // Pruefen, ob der Posten mit Bezeichnung und Ausfuehrung schon vorhanden ist
      int index = istVerfuegbar ( posten.getBezeichnung()
                                , posten.getAusfuehrung()
                                , posten.getAnzahl()); 

      // Ist der Posten schon vorhanden, so soll die Methode false zurueckliefern
      if (index >= 0)
      {
         return false;
      }
      
      // Aufnehmen des Postens in das Magazin
      return magazin.add (posten);
   }

   // Einlagern des Kleinteils in beschriebener Ausfuehrung
   public boolean einlagern (String bezeichnung, String ausfuehrung, int stueckzahl)
   {
      // Ist der Posten verfuegbar (Die vorhandene Stueckzahl ist egal)?
      int index = istVerfuegbar (bezeichnung, ausfuehrung, 0);

      // Wenn ja, dann die vorhandene Stueckzahl 
      // des Postens um die uebergebene Stueckzahl erhoehen
      if (index >= 0)
      {
         T posten = magazin.get (index);
         
         int aktuelleAnzahl = posten.getAnzahl();
         
         aktuelleAnzahl += stueckzahl;
         posten.setAnzahl (aktuelleAnzahl);
         
         //TODO: Notwendig?
         //magazin.set (index, posten);
         
         return true;
      }

      // Posten ist nicht vorhanden
      return false;
   }

   // Entnehmen des gewuenschten Kleinteils
   public boolean entnehmen (String bezeichnung, String ausfuehrung, int stueckzahl)
   {
      // Ist der gesuchte Posten in ausreichender Stueckzahl verfuegbar?
      int index = istVerfuegbar (bezeichnung, ausfuehrung, stueckzahl);

      // Wenn ja, dann die gewuenschte Stueckzahl entnehmen
      if (index >= 0)
      {
         T posten = magazin.get (index);
         int aktuelleAnzahl = posten.getAnzahl();
         
         aktuelleAnzahl -= stueckzahl;
         posten.setAnzahl (aktuelleAnzahl);
         
         //TODO: Notwendig?
         //magazin.set (index, posten);
         
         return true;
      }
      
      // Nicht in ausreichender Stueckzahl verfuegbar
      return false;
   }
   
   
   // Den Bestand des Magazins ausdrucken
   public void druckeMagazin()
   {
      for (T posten : magazin) 
      {
         System.out.println (posten);
      }
   }

   public void sortiereMagazin()
   {
       TeileUtils.sortiereMagazin (magazin);
   }
   
   // Hilfsmethode, die ueberprueft, ob der Posten in Bezeichnung, Ausfuehrung und gewuenschter Stueckzahl 
   // schon im Magazin vorhanden ist. Sie liefert dann dessen Index im ArrayList<T>-Objekt zurueck, sonst -1  
   private int istVerfuegbar (String bezeichnung, String ausfuehrung, int anzahl)
   {
      // Suchen, bis der Posten in Bezeichnung und Ausfuehrung gefunden wurde.
      // Dann den Index im ArrayList<T>-Objekt zurueckliefern.
      for (T posten : magazin) 
      {
         if (posten.getBezeichnung().equals (bezeichnung) &&
             posten.getAusfuehrung().equals (ausfuehrung) &&
             posten.getAnzahl() >= anzahl)
         {
            return magazin.indexOf (posten);
         }
      }
      
      // Nicht verfuegbar? -1 zurueckliefern.
      return -1;
   }
}

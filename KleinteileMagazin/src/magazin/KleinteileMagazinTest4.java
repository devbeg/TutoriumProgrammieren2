// Datei: KleinteileMagazinTest4_Vorlage.java

package magazin;

import teile.GewindeTeil;
import teile.Mutter;
import teile.RostgarantieNichtErfuelltException;
import teile.Scheibe;
import teile.Schraube;

public class KleinteileMagazinTest4 
{
   public static void main (String[] args) 
   {
      // Anlegen zweier Magazine fuer Gewindeteile und Scheiben 
      RostfreieKleinteileMagazin<GewindeTeil<Float>> gewindeteile = new RostfreieKleinteileMagazin<GewindeTeil<Float>>();
      RostfreieKleinteileMagazin<Scheibe<Float>> scheiben = new RostfreieKleinteileMagazin<Scheibe<Float>>();
      
      // Hinzufuegen der unterschiedlichen Magazine zu einem Array
      RostfreieKleinteileMagazin<?>[] magazine = {gewindeteile, scheiben};

      try 
      {
         // Anlegen dreier Gewindeteile
         gewindeteile.aufnehmen (new Mutter<Float> (1000, Mutter.NORMAL, 6, 5f, 0.01f));
         gewindeteile.aufnehmen (new Mutter<Float> (1000, Mutter.SICHERUNG, 6, 6f, 0.01f, 18));
         gewindeteile.aufnehmen (new Schraube<Float> (1000, Schraube.SENKKOPF, Schraube.KREUZSCHLITZ, 6f, 0.01f, 18));

         // Anlegen einer Scheibe
         scheiben.aufnehmen (new Scheibe<Float> (1000, Scheibe.FEDER, 5.5f, 10.1f, 0.01f, 12));

         // Das Magazin gewindeteile sortieren
         gewindeteile.sortiereMagazin();

         // Inhalt der Magazine ausdrucken
         for (RostfreieKleinteileMagazin<?> magazin : magazine)
         {
            magazin.druckeMagazin();
         }
      } 
      catch (RostgarantieNichtErfuelltException e) 
      {
         System.out.println(e.getMessage());
      }
   }
}

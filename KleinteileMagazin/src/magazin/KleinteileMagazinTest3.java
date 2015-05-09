// Datei: KleinteileMagazinTest3_Vorlage.java

package magazin;

import teile.GewindeTeil;
import teile.Mutter;
import teile.RostgarantieNichtErfuelltException;
import teile.Scheibe;

import java.util.ArrayList;
import java.util.List;

public class KleinteileMagazinTest3 
{
   public static void main (String[] args) 
   {
      // Anlegen zweier Magazine fuer Gewindeteile und Scheiben 
      RostfreieKleinteileMagazin<GewindeTeil<Float>> gewindeteile = new RostfreieKleinteileMagazin<GewindeTeil<Float>>();
      RostfreieKleinteileMagazin<Scheibe<Float>> scheiben = new RostfreieKleinteileMagazin<Scheibe<Float>>();
      
      try 
      {
         // Anlegen einer Mutter mit garantierter Rostfreiheit des Herstellers
         Mutter<Float> mutter_m5 = new Mutter<Float> (1000, Mutter.NORMAL, 6, 5f, 0.01f);
         gewindeteile.aufnehmen (mutter_m5);

         // Anlegen einer Mutter mit 18-monatiger Rostfreiheit
         Mutter<Float> mutter_m6 = new Mutter<Float> (1000, Mutter.SICHERUNG, 6, 6f, 0.01f, 18);
         gewindeteile.aufnehmen (mutter_m6);
         
         // Gewindeteile-Magazin ausdrucken
         gewindeteile.druckeMagazin();

         // Versuch, eine Scheibe anzulegen, mit 11-monatiger Rostfreiheit
         Scheibe<Float> scheibe_m5 = new Scheibe<Float> (1000, Scheibe.FEDER, 5.5f, 10.1f, 0.01f, 11);
         scheiben.aufnehmen (scheibe_m5);

         scheiben.druckeMagazin();
      } 
      catch (RostgarantieNichtErfuelltException e) 
      {
         System.out.println(e.getMessage());
      }
   }
}

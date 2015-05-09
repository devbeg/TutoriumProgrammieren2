// Datei: KleinteileMagazinTest2_Vorlage.java

package magazin;

import teile.GewindeTeil;
import teile.Mutter;
import teile.Scheibe;
import teile.Schraube;

public class KleinteileMagazinTest2 
{
   public static void main (String[] args) 
   {
      // Anlegen zweier Magazine fuer Gewindeteile und Scheiben 
      KleinteileMagazin<GewindeTeil<?>> gewindeteile = new KleinteileMagazin<GewindeTeil<?>>();
      KleinteileMagazin<Scheibe<Float>> scheiben = new KleinteileMagazin<Scheibe<Float>>();
      
      // Anlegen von Gewindeteilen
      Mutter<Float> mutter_m5 = new Mutter<Float> (1000, Mutter.NORMAL, 6, 5f, 0.01f);
      Mutter<Integer> mutter_m60 = new Mutter<Integer> (1000, Mutter.NORMAL, 6, 60, 1);
      Schraube<Float> schraube_m3 = new Schraube<Float> (1000, Schraube.EINFACHSCHLITZ, Schraube.LINSENKOPF, 3f, 0.001f);

      // Gewindeteile aufnehmen
      gewindeteile.aufnehmen (mutter_m5);
      gewindeteile.aufnehmen (mutter_m60);
      gewindeteile.aufnehmen (schraube_m3);
      
      // Gewindeteile-Magazin ausdrucken
      gewindeteile.druckeMagazin();

      // Scheiben anlegen
      Scheibe<Float> scheibe_m5 = new Scheibe<Float> (1000, Scheibe.FEDER, 5.5f, 10.1f, 0.01f);
      Scheibe<Float> scheibe_m2 = new Scheibe<Float> (1000, Scheibe.NORMAL, 2.11f, 3.001f, 0.0001f);

      // Scheiben im Scheiben-Magazin aufnehmen
      scheiben.aufnehmen (scheibe_m5);
      scheiben.aufnehmen (scheibe_m2);
      
      // Scheiben-Magazin ausdrucken
      scheiben.druckeMagazin();
   }
}

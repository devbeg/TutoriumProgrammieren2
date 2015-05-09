// Datei: KleinteileMagazinTest_Vorlage.java

package magazin;

import teile.GewindeTeil;
import teile.Mutter;
import teile.Scheibe;
import teile.Schraube;

public class KleinteileMagazinTest 
{
   public static void main (String[] args) 
   {
      // Anlegen zweier Magazine fuer Gewindeteile und Scheiben 
      KleinteileMagazin<GewindeTeil> gewindeteile = new KleinteileMagazin<GewindeTeil>();
      KleinteileMagazin<Scheibe> scheiben = new KleinteileMagazin<Scheibe>();
      
      // Anlegen von Gewindeteilen
      Mutter mutter_m5 = new Mutter (1000, Mutter.NORMAL, 6, 5);
      Mutter mutter_m6 = new Mutter (1000, Mutter.SICHERUNG, 6, 6);
      Schraube schraube_m30 = new Schraube (1000, Schraube.EINFACHSCHLITZ, Schraube.LINSENKOPF, 30);
      Schraube schraube_m40 = new Schraube (1000, Schraube.KREUZSCHLITZ, Schraube.LINSENKOPF, 40);

      // Gewindeteile aufnehmen
      gewindeteile.aufnehmen (mutter_m5);
      gewindeteile.aufnehmen (mutter_m6);
      gewindeteile.aufnehmen (schraube_m30);
      gewindeteile.aufnehmen (schraube_m40);
      
      // Gewindeteile-Magazin ausdrucken
      gewindeteile.druckeMagazin();

      // Verschiedenste Gewindeteile enthemen und wieder einlagern   
      gewindeteile.entnehmen (mutter_m5.getBezeichnung(), mutter_m5.getAusfuehrung(), 600);
      gewindeteile.entnehmen ("Mutter", Mutter.NORMAL, 500);
      gewindeteile.einlagern ("Mutter", Mutter.SICHERUNG, 4000);

      // Gewindeteile-Magazin ausdrucken
      gewindeteile.druckeMagazin();

      // Scheiben anlegen
      Scheibe scheibe_m5 = new Scheibe (1000, Scheibe.FEDER, 6, 10);
      Scheibe scheibe_m6 = new Scheibe (1000, Scheibe.NORMAL, 7, 11);

      // Scheiben im Scheiben-Magazin aufnehmen
      scheiben.aufnehmen (scheibe_m5);
      scheiben.aufnehmen (scheibe_m6);
      
      // Scheiben-Magazin ausdrucken
      scheiben.druckeMagazin();
   }
}

// Datei: Mutter_Vorlage.java

package teile;

public class Mutter extends GewindeTeil 
{
   public static final String NORMAL = "Normal";
   public static final String SICHERUNG = "Sicherung";
   public static final String FLUEGEL = "Fluegel";
   
   private int anzahlSeiten;
   
   public Mutter (int anzahl, String ausfuehrung, int anzahlSeiten, int gewindeGroesse)
   {
      super (anzahl, "Mutter", ausfuehrung, gewindeGroesse);
      this.anzahlSeiten = anzahlSeiten;
   }
   
   public int getAnzahlSeiten()
   {
      return anzahlSeiten;
   }
   
   public String toString()
   {
      return super.toString() + 
         ", Anzahl Seiten: " + anzahlSeiten;
   }
}

// Datei: Mutter.java

package teile;

public class Mutter<T extends Number> extends GewindeTeil<T> 
{
   public static final String NORMAL = "Normal";
   public static final String SICHERUNG = "Sicherung";
   public static final String FLUEGEL = "Fluegel";
   
   private int anzahlSeiten;
   
   public Mutter (int anzahl, String ausfuehrung, int anzahlSeiten, T gewindeGroesse, T toleranz, int monate)
      throws RostgarantieNichtErfuelltException
   {
      super (anzahl, "Mutter", ausfuehrung, gewindeGroesse, toleranz, monate);
      this.anzahlSeiten = anzahlSeiten;
   }
   
   public Mutter (int anzahl, String ausfuehrung, int anzahlSeiten, T gewindeGroesse, T toleranz)
      throws RostgarantieNichtErfuelltException
   {
      this (anzahl, ausfuehrung, anzahlSeiten, gewindeGroesse, toleranz, MINDEST_GARANTIEZEIT);
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

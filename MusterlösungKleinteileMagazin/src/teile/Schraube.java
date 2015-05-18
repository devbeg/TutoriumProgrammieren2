// Datei: Schraube.java

package teile;

public class Schraube<T extends Number> extends GewindeTeil<T> 
{
   public static final String LINSENKOPF = "Linsenkopf";
   public static final String SENKKOPF = "Senkkopf";
   
   public static final String KREUZSCHLITZ = "Kreuzschlitz";
   public static final String EINFACHSCHLITZ = "Einfachschlitz";
   
   private String schlitzart;
   
   public Schraube (int anzahl, String ausfuehrung, String kopfart, T gewindeGroesse, T toleranz, int monate)
      throws RostgarantieNichtErfuelltException
   {
      super (anzahl, "Schraube", ausfuehrung, gewindeGroesse, toleranz, monate);
      this.schlitzart = kopfart;
   }

   public Schraube (int anzahl, String ausfuehrung, String kopfart, T gewindeGroesse, T toleranz)
      throws RostgarantieNichtErfuelltException
   {
      this (anzahl, ausfuehrung, kopfart, gewindeGroesse, toleranz, MINDEST_GARANTIEZEIT);
   }
   
   public String getSchlitzart()
   {
      return schlitzart;
   }

   public String toString()
   {
      return super.toString() + 
         ", Schlitzart: " + schlitzart;
   }
}

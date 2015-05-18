// Datei: Scheibe.java

package teile;

public class Scheibe<T extends Number> extends Teil<T>
{
   public static final String NORMAL = "Normal";
   public static final String FEDER = "Feder";
   
   private T innendurchmesser;
   private T aussendurchmesser;
   
   public Scheibe (int anzahl, String ausfuehrung, T innenDurchmesser, T aussendurchmesser, T toleranz, int monate)
      throws RostgarantieNichtErfuelltException
   {
      super (anzahl, "Scheibe", ausfuehrung, toleranz, monate);
      this.innendurchmesser = innenDurchmesser;
      this.aussendurchmesser = aussendurchmesser;
   }
   
   public Scheibe (int anzahl, String ausfuehrung, T innenDurchmesser, T aussendurchmesser, T toleranz)
      throws RostgarantieNichtErfuelltException
   {
      this (anzahl, ausfuehrung, innenDurchmesser, aussendurchmesser, toleranz, MINDEST_GARANTIEZEIT);
   }
   
   public T getInnendurchmesser()
   {
      return innendurchmesser;
   }
   
   public T getAussendurchmesser()
   {
      return aussendurchmesser;
   }
   
   public String toString()
   {
      return super.toString() + 
         ", D innen: " + innendurchmesser + 
         ", D aussen: " + aussendurchmesser;
   }
}

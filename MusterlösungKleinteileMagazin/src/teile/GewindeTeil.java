// Datei: GewindeTeil.java

package teile;

public abstract class GewindeTeil<T extends Number> extends Teil<T>
{
   private T gewindeGroesse;
   
   public GewindeTeil (int anzahl, String bezeichnung, String ausfuehrung, T gewindeGroesse, T toleranz, int monate)
      throws RostgarantieNichtErfuelltException
   {
      super (anzahl, bezeichnung, ausfuehrung, toleranz, monate);
      this.gewindeGroesse = gewindeGroesse;
   }
   
   public T getGewindeGroesse()
   {
      return gewindeGroesse;
   }
   
   public String toString()
   {
      return super.toString() + 
         ", Gewindegroesse: " + gewindeGroesse;
   }
}

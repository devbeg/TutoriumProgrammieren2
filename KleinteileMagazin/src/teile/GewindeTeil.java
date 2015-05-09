// Datei: GewindeTeil_Vorlage.java

package teile;

public abstract class GewindeTeil extends Teil 
{
   private int gewindeGroesse;
   
   public GewindeTeil (int anzahl, String bezeichnung, String ausfuehrung, int gewindeGroesse)
   {
      super (anzahl, bezeichnung, ausfuehrung);
      this.gewindeGroesse = gewindeGroesse;
   }
   
   public int getGewindeGroesse()
   {
      return gewindeGroesse;
   }
   
   public String toString()
   {
      return super.toString() + 
         ", Gewindegroesse: " + gewindeGroesse;
   }
}

// Datei: Scheibe_Vorlage.java

package teile;

public class Scheibe extends Teil 
{
   public static final String NORMAL = "Normal";
   public static final String FEDER = "Feder";
   
   private int innendurchmesser;
   private int aussendurchmesser;
   
   public Scheibe (int anzahl, String ausfuehrung, int innendurchmesser, int aussendurchmesser)
   {
      super (anzahl, "Scheibe", ausfuehrung);
      this.innendurchmesser = innendurchmesser;
      this.aussendurchmesser = aussendurchmesser;
   }
   
   public int getInnendurchmesser()
   {
      return innendurchmesser;
   }
   
   public int getAussendurchmesser()
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

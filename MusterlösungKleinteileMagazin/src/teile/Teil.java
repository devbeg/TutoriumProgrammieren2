// Datei: Teil.java

package teile;

public abstract class Teil<T extends Number> implements Rostfrei
{
   public static final int MINDEST_GARANTIEZEIT = 12;
   
   private int anzahl;
   private String bezeichnung;
   private String ausfuehrung;
   private T toleranz;
   private int garantierteRostfreiheit;
   
   public Teil (int anzahl, String bezeichnung, String ausfuehrung, T toleranz, int monate) 
      throws RostgarantieNichtErfuelltException
   {
      if (monate < MINDEST_GARANTIEZEIT)
      {
         String msg = "Teil nicht aufnahmefaehig! Nur " + monate + " Monate Rostfreiheit garantiert!";
         throw new RostgarantieNichtErfuelltException (msg);
      }
      
      this.anzahl = anzahl;
      this.bezeichnung = bezeichnung;
      this.ausfuehrung = ausfuehrung;
      this.toleranz = toleranz;
      this.garantierteRostfreiheit = monate;
   }
   
   public int getAnzahl()
   {
      return anzahl;
   }
   
   public void setAnzahl (int anzahl)
   {
      this.anzahl = anzahl;
   }
   
   public String getBezeichnung()
   {
      return bezeichnung;
   }
   
   public String getAusfuehrung()
   {
      return ausfuehrung;
   }
   
   public T getToleranz()
   {
      return toleranz;
   }
   
   public int gibZeitraumRostfreiheit()
   {
      return garantierteRostfreiheit;
   }
   
   public String toString()
   {
      return "Anzahl: " + anzahl +
         ", Bezeichung: " + bezeichnung +
         ", Ausfuehrung: " + ausfuehrung +
         ", Toleranz: " + toleranz + 
         ", Monate Rostfrei garantiert: " + garantierteRostfreiheit;
   }
}

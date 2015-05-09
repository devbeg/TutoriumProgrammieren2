// Datei: Teil_Vorlage.java

package teile;

public abstract class Teil 
{
   private int anzahl;
   private String bezeichnung;
   private String ausfuehrung;
   
   public Teil (int anzahl, String bezeichnung, String ausfuehrung)
   {
      this.anzahl = anzahl;
      this.bezeichnung = bezeichnung;
      this.ausfuehrung = ausfuehrung;
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
   
   public String toString()
   {
      return "Anzahl: " + anzahl +
         ", Bezeichung: " + bezeichnung +
         ", Ausfuehrung: " + ausfuehrung;
   }
}

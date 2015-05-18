// Datei: TeileUtils.java

package utils;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import teile.Teil;

public class TeileUtils<T extends Teil<?>> implements Comparator<T> {

   private TeileUtils()
   {
   }
   
   public int compare (T t1, T t2)
   {
      int ret = t1.getBezeichnung().compareToIgnoreCase (t2.getBezeichnung());
      return ret == 0 ? t1.getAusfuehrung().compareToIgnoreCase (t2.getAusfuehrung()) : ret;
   }

   public static<T extends Teil<?>> void sortiereMagazin(List<T> teile)
   {
       Collections.sort (teile, new TeileUtils<T>());
   }
}

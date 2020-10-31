/**
 * The category central.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/10
 */

public class PremonCatCentral
extends PremonCat
{
  public void print (Printer p)  {
    p.printBold ("central");
  }
  public PremonCat join (PremonCat C)  {
    if (C instanceof PremonCatVal) {
      return this;
    } else {
      return C;
    }
  }
  public boolean equals (PremonCat C)  {
    return (C instanceof PremonCatCentral);
  } 
  public boolean subcat (PremonCat C)  {
    return !(C instanceof PremonCatVal);
  } 
}


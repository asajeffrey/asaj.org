/**
 * The category val.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/10
 */

public class PremonCatVal
extends PremonCat
{
  public void print (Printer p)  {
    p.printBold ("val");
  }
  public PremonCat join (PremonCat C)  {
    return C;
  }
  public boolean equals (PremonCat C)  {
    return (C instanceof PremonCatVal);
  } 
  public boolean subcat (PremonCat C)  {
    return true;
  } 
}


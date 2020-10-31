/**
 * The category proc.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/10
 */

public class PremonCatProc
extends PremonCat
{
  public void print (Printer p)  {
    p.printBold ("proc");
  }
  public PremonCat join (PremonCat C)  {
    return this;
  }
  public boolean equals (PremonCat C)  {
    return (C instanceof PremonCatProc);
  } 
  public boolean subcat (PremonCat C)  {
    return (C instanceof PremonCatProc);
  } 
}

/**
 * The category val.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/10
 */

public class PremonJJTCatVal
extends PremonJJTCat
{
  public PremonJJTCatVal (int id) {
    super (id);
  }
  public void print (Printer p)  {
    p.printBold ("val");
  }
  public PremonCat desugar ()  {
    return PremonCat.val;
  }
}


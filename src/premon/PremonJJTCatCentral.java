/**
 * The category central.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/10
 */

public class PremonJJTCatCentral
extends PremonJJTCat
{
  public PremonJJTCatCentral (int id) {
    super (id);
  }
  public void print (Printer p)  {
    p.printBold ("central");
  }
  public PremonCat desugar ()  {
    return PremonCat.central;
  }
}



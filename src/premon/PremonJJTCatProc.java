/**
 * The category proc.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/10
 */

public class PremonJJTCatProc
extends PremonJJTCat
{
  public PremonJJTCatProc (int id) {
    super (id);
  }
  public void print (Printer p)  {
    p.printBold ("proc");
  }
  public PremonCat desugar ()  {
    return PremonCat.proc;
  }
}

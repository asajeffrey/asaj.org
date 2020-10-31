/**
 * A function application <i>M</i> <i>N</i>
 * where <i>M</i> is a value of function type.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/09
 */

public class PremonJJTExpApp
extends PremonJJTExp
{
  public PremonJJTExpApp (int id) {
    super (id);
  }
  public void print (Printer p)  {
    p.print (childExp (0));
    p.printSpace ();
    p.printB (childExp (1));
  }
  public void printA (Printer p)  {
    print (p);
  }
  public PremonExp desugar (PremonCon Gamma) throws TypeError  {
    return childExp (0).desugar (Gamma).apply (childExp (1).desugar (Gamma));
  }
}


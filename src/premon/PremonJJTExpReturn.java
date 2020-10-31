/**
 * An expression <b>return</b>&nbsp;<i>M</i>,
 * syntax sugar for <i>M</i>.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/10
 */

public class PremonJJTExpReturn
extends PremonJJTExp
{
  public PremonJJTExpReturn (int id) {
    super (id);
  }
  public void print (Printer p)  {
    p.printBold ("return");
    p.printSpace ();
    p.printA (childExp (0));
    p.printString (";");
  }
  public PremonExp desugar (PremonCon Gamma) throws TypeError  {
    return childExp (0).desugar (Gamma);
  }
}


/**
 * A top-level expression.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/10
 */

public class PremonJJTExpTopLevel
extends PremonJJTExp
{
  public PremonJJTExpTopLevel (int id) {
    super (id);
  }
  public void print (Printer p)  {
    p.print (childExp (0));
  }
  public PremonExp desugar (PremonCon Gamma) throws TypeError  {
    return new PremonExpTopLevel (childExp (0).desugar (Gamma));
  }
}

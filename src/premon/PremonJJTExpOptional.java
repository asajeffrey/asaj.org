/**
 * An optional expression, by default ().
 * @author Alan Jeffrey
 * @version v1.0 1998/06/10
 */

public class PremonJJTExpOptional
extends PremonJJTExp
{
  public PremonJJTExpOptional (int id) {
    super (id);
  }
  public void print (Printer p)  {
    if (children.length>0) {
      p.print (childExp (0));
    }
  }
  public PremonExp desugar (PremonCon Gamma) throws TypeError  {
    if (children.length>0) {
      return childExp (0).desugar (Gamma);
    } else {
      return PremonExpTuple.empty;
    }
  }
}


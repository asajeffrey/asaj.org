/**
 * An infix function application <i>M</i> <i>x</i> <i>N</i>
 * where <i>x</i> is a variable of function type.
 * This is syntax sugar for <i>x</i>&nbsp;(<i>M</i>,<i>N</i>).
 * @author Alan Jeffrey
 * @version v1.0 1998/06/09
 */

public class PremonJJTExpAppInfix
extends PremonJJTExp
{
  public PremonJJTExpAppInfix (int id) {
    super (id);
  }
  public void print (Printer p)  {
    p.printA (childExp (0));
    p.printSpace ();
    p.print (childId (1));
    p.printSpace ();
    p.printA (childExp (2));
  }
  public PremonExp desugar (PremonCon Gamma) throws TypeError  {
    PremonExp[] pair = new PremonExp[2];
    pair[0] = childExp (0).desugar (Gamma);
    pair[1] = childExp (2).desugar (Gamma);
    return new PremonExpVar (Gamma.lookup (childId (1).name)).apply 
      (new PremonExpTuple (pair));      
  }
}


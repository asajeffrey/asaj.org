/**
 * An expression (<i>M</i><sub>1</sub>,...,<i>M<sub>n</sub></i>).
 * @author Alan Jeffrey
 * @version v1.0 1998/06/09
 */

public class PremonJJTExpTuple
extends PremonJJTExp
{
  public PremonJJTExpTuple (int id) {
    super (id);
  }
  public void print (Printer p)  {
    p.printRoman ("(");
    p.printArray (children, ", ");
    p.printRoman (")");
  }
  public void printB (Printer p)  {
    print (p);
   }
  public PremonExp desugar (PremonCon Gamma) throws TypeError  {
    PremonExp[] tuple = new PremonExp[children.length];
    for (int i=0; i < children.length; i++) {
      tuple[i] = childExp(i).desugar(Gamma);
    }
    return new PremonExpTuple ( tuple );
  }
}


/**
 * A pattern (<i>P</i><sub>1</sub>,...,<i>P<sub>n</sub></i>).
 * @author Alan Jeffrey
 * @version v1.0 1998/06/09
 */

public class PremonJJTPatTuple
extends PremonJJTPat
{
  public PremonJJTPatTuple (int id) {
    super (id);
  }
  public void print (Printer p)  {
    p.printString ("(");
    p.printArray (children, ", ");
    p.printString (")");
  }
  public void printB (Printer p)  {
    print (p);
  }
  public PremonPat desugar ()  {
    PremonPat[] tuple = new PremonPat[children.length];
    int i = 0;
    while (i < children.length) {
      tuple[i] = childPat(i).desugar();
      i++;
    }
    return new PremonPatTuple ( tuple );
  }
}


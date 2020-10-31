/**
 * An expression <i>D</i>&nbsp;<i>M</i> where <i>D</i> is a declaration
 * which may bind variables in <i>M</i>.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/09
 */

public class PremonJJTExpDec
extends PremonJJTExp
{
  public PremonJJTExpDec (int id) {
    super (id);
  }
  public void print (Printer p)  {
    p.print (childDec (0));
    p.newLine ();
    if (childExp (1) instanceof PremonJJTExpDec) {
      p.printB (childExp (1));
    } else {
      p.print (childExp (1));
    }
    p.newLine ();
  }
  public void printB (Printer p)  {
    p.printString ("(");
    p.newLine ();
    p.indent ();
    print (p);
    p.outdent ();
    p.newLine ();
    p.printString (")");
  }
  public PremonExp desugar (PremonCon Gamma) throws TypeError  {
    PremonDec D = childDec (0).desugar (Gamma);
    PremonExp M = childExp (1).desugar (Gamma.comp (D.bind));
    return new PremonExpDec (D,M);
  }
}


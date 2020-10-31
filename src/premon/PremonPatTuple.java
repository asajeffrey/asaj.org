/**
 * A pattern matching a tuple (<i>p</i><sub>1</sub>,...,<i>p<sub>n</sub></i>).
 * @author Alan Jeffrey
 * @version v1.0 1998/06/03
 */

public class PremonPatTuple
extends PremonPat
{

  /**
   * An empty pattern ().
   */
  public static final PremonPatTuple empty = 
    new PremonPatTuple (new PremonPat[0]);

  private PremonPat[] Ps;

  /**
   * Build a new tuple pattern from an array of patterns.
   * @param Ps the patterns <i>p</i><sub>1</sub>,...,<i>p<sub>n</sub></i>.
   */
  public PremonPatTuple (PremonPat[] Ps) {
    this.Ps = Ps;
    PremonType[] Ts = new PremonType[Ps.length];
    bind = PremonCon.empty;
    for (int i=0; i<Ps.length; i++) {
      Ts[i] = Ps[i].type;
      bind = bind.comp (Ps[i].bind);
    }
    type = new PremonTypeTuple (Ts);
  }

  public void print (Printer p)  {
    p.printString ("("); p.printArray (Ps, ", "); p.printString (")");
  }
  public void printB (Printer p)  {
    print (p);
  }

}


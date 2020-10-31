/**
 * A pattern (<i>p</i><code>...</code><i>q</i>).
 * This has no categorical significance, but is used to draw graphs
 * containing ellipses.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/03
 */

public class PremonPatDots
extends PremonPat
{
  private PremonPat P;
  private PremonPat Q;

  /**
   * The pattern <i>P</i><code>...</code><i>Q</i>.
   * @param P the lh pattern
   * @param Q the rh pattern
   */
  public PremonPatDots (PremonPat P, PremonPat Q) {
    this.P = P;
    this.Q = Q;
    type = new PremonTypeDots (P.type, Q.type);
    bind = P.bind.comp (Q.bind);
  }

  public void print (Printer p)  {
    p.printString ("("); 
    p.print (P); 
    p.printString (" ... "); 
    p.print (Q); 
    p.printString (")");
  }
  public void printB (Printer p)  {
    print (p);
  }

}


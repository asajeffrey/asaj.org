/**
 * An expression <i>M</i><code>...</code><i>N</i> used in drawing
 * graphs containing ellipses.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/10
 */

public class PremonExpDots
extends PremonExp
{
  private PremonExp M;
  private PremonExp N;

  /**
   * Create an expression <i>M</i><code>...</code><i>N</i>
   * @param M the lh expression
   * @param N the rh expression
   */
  public PremonExpDots (PremonExp M, PremonExp N) {
    this.M = M;
    this.N = N;
    cat = M.cat.join (N.cat);
    type = new PremonTypeDots (M.type, N.type);
    free = M.free.comp (N.free);
  }
  public void print (Printer p)  {
    p.printString ("("); 
    p.print (M); 
    p.printString (" ... "); 
    p.print (N); 
    p.printString (")");
  }
  public void printB (Printer p)  {
    print (p);
  }
  /**
   * The semantics of the expression.
   * @return [[<i>M</i>]] <img src=img-otimes.gif> [[<i>N</i>]]
   */
  public Mor semantics ()  {
    return M.semantics ().tensorDots (N.semantics ());
  }
}


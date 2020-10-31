/**
 * A variable expression <i>x</i>.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/10
 */

public class PremonExpVar
extends PremonExp
{
  private PremonVar x;

  /** 
   * Create a new expression.
   * @param x the variable.
   */
  public PremonExpVar (PremonVar x) {
    this.x = x;
    cat = PremonCat.val;
    type = x.type;
    free = x.free;
  }

  public void print (Printer p)  {
    p.print (x);
  }
  public void printA (Printer p)  {
    print (p);
  }

  /**
   * The semantics of the expression.
   * @return [[<i>x</i>:<i>T</i> <img src=img-vdash.gif> <i>x</i>:<i>T</i>]]
   *   = [[<i>T</i>]]
   */
  public Mor semantics ()  {
    return x.semantics ();
  }
}


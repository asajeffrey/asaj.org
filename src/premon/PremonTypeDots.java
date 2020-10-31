/**
 * A type constructor <i>T</i><code>...</code><i>U</i>.
 * This has no categorical significance, but is very useful in drawing
 * graphs which contain ellipses.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/03
 */

public class PremonTypeDots
extends PremonType
{

  private PremonType T;
  private PremonType U;

  /**
   * The type <i>T</i>...<i>U</i>.
   * @param T the lh type.
   * @param U the rh type.
   */
  public PremonTypeDots (PremonType T, PremonType U) {
    this.T = T;
    this.U = U;
  }

  public void print (Printer p)  {
    p.printString ("("); 
    p.print (T); 
    p.printString (" ... "); 
    p.print (U); 
    p.printString (")");
  }
  public void printB (Printer p)  {
    print (p);
  }

  /**
   * The semantics is just given as tensor.
   * @return [[<i>T</i>]] <img src=img-otimes.gif> [[<i>U</i>]]
   */
  public Obj semantics ()  {
    return T.semantics ().tensor (U.semantics ());
  }

  public boolean equals (PremonType V)  {
    if (V instanceof PremonTypeDots) {
      PremonTypeDots V1 = (PremonTypeDots)V;
      return T.equals (V1.T) && U.equals (V1.U);
    } else {
      return false;
    }
  }

  /**
   * This type is not traceable.
   * @return false.
   */
  public boolean traceable ()  {
    return false;
  }

}


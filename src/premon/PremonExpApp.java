/**
 * A function application <i>M N</i>.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/10
 */

public class PremonExpApp
extends PremonExp
{
  private PremonExp M;
  private PremonExp N;

  /**
   * Create a new application.
   * @param M the function.
   * @param N the argument.
   * @exception SemanticError thrown if M is not a function.
   */
  public PremonExpApp (PremonExp M, PremonExp N) {
    this.M = M;
    this.N = N;
    if (M.type instanceof PremonTypeFun) {
      PremonTypeFun T = (PremonTypeFun)(M.type);
      cat = N.cat.join (T.cat);
      type = T.target;
      free = M.free.comp (N.free);
    } else {
      /* This shouldn't happen! */
      throw new SemanticError ();
    }
  }

  public void print (Printer p)  {
    p.print (M); p.printSpace (); p.printB(N);
  }
  public void printA (Printer p)  {
    print (p);
  }

  /**
   * The semantics of the expression.
   * @return (id <img src=img-otimes.gif> [[<i>N</i>]]) ; uncurry[[<i>M</i>]]
   */
  public Mor semantics ()  {
    return 
      (M.free.semantics ().id ()).tensor 
      (N.semantics ()).comp 
      (M.semantics ().uncurry ());
  }
}


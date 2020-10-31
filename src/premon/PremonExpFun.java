/**
 * A function expression <b>fn</b> <i>C</i> <i>P</i> { <i>M</i> } 
 * @author Alan Jeffrey
 * @version v1.0 1998/06/09
 */

public class PremonExpFun
extends PremonExp
{
  private PremonCat C;
  private PremonPat P;
  private PremonExp M;

  /**
   * Create a new function.
   * @param C the category of the function (val, central or proc).
   * @param P the argument pattern
   * @param M the function body
   */
  public PremonExpFun (PremonCat C, PremonPat P, PremonExp M) {
    this.C = C;
    this.P = P;
    this.M = M;
    cat = PremonCat.val;
    type = new PremonTypeFun (C, P.type, M.type);
    free = M.free.uniq ().hide (P.bind);
  }
  public void print (Printer p)  {
    p.printBold ("fn"); 
    p.printSpace (); 
    p.print (C);
    p.printSpace (); 
    p.printB (P); 
    p.printSpace (); 
    p.printLBrace (); 
    p.indent (); 
    p.newLine ();
    p.print (M); 
    p.outdent (); 
    p.newLine ();
    p.printRBrace ();
  }
  public void printA (Printer p)  {
    print (p);
  }

  /**
   * The semantics of the expression.
   * @return curry[[<i>M</i>]]
   */
  public Mor semantics ()  {
    Obj X = this.free.semantics ();
    Obj Y = P.type.semantics ();
    return M.semanticsFrom (this.free.comp (P.bind)).curry (C, X, Y);
  }
}


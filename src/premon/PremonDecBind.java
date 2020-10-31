/**
 * A declaration <b>let</b> <i>P</i> = <i>M</i>;
 * @author Alan Jeffrey
 * @version v1.0 1998/06/09
 */

public class PremonDecBind
extends PremonDec
{
  private PremonPat P;
  private PremonExp M;

  /**
   * Create a new declaration.
   * @param P the binding pattern.
   * @param M the bound expression.
   */
  public PremonDecBind (PremonPat P, PremonExp M) {
      this.P = P;
      this.M = M;
      bind = P.bind;
      free = M.free.uniq ();
      cat = M.cat;
  }

  public void print (Printer p)  {
    p.newLine ();
    p.printBold ("let"); p.printSpace (); 
    p.print (P); p.printString (" = "); p.print (M);
    p.printString (";");
  }

  /**
   * The semantics of the declaration.
   * @return [[<i>M</i>]] ; [[<i>P</i> <img src=img-vdash.gif> <i>target</i>]]
   */
  public Mor semanticsTo (PremonCon target)  {
    return 
      (this.free.semanticsTo (M.free)).comp 
      (M.semantics ()).comp 
      (P.bind.semanticsTo (target));
  }
}


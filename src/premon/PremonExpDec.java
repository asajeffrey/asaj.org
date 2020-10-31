/**
 * An expression <i>D M</i> binding a declaration <i>D</i> to an expression <i>M</i>.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/10
 */

public class PremonExpDec
extends PremonExp
{
  private PremonCon MfreeUniq;
  private PremonCon MfreeDunbound;
  private PremonCon MfreeDbound;
  private PremonDec D;
  private PremonExp M;

  /**
   * Create a new binding.
   * @param D the declaration
   * @param M the expression
   */
  public PremonExpDec (PremonDec D, PremonExp M) {
    this.D = D;
    this.M = M;
    cat = D.cat.join (M.cat);
    type = M.type;
    MfreeUniq = M.free.uniq ();
    MfreeDunbound = MfreeUniq.hide (D.bind);
    MfreeDbound = MfreeUniq.hide (MfreeDunbound);
    free = D.free.comp (MfreeDunbound);
  }

  public void print (Printer p)  {
    p.print (D);
    p.newLine ();
    p.printA (M);
    p.newLine ();
  }
  public void printB (Printer p)  {
    p.printString ("(");
    p.indent ();
    p.print (D);
    p.newLine ();
    p.printA (M);
    p.outdent ();
    p.newLine ();
    p.printString (")");
  }

  /**
   * The semantics of the expression.
   * @return ([[<img src=img-Gamma.gif>&nbsp;<img src=img-vdash.gif>&nbsp;<i>D</i>&nbsp;:&nbsp;<img src=img-Delta.gif>]]&nbsp;<img src=img-otimes.gif>&nbsp;[[<img src=img-Xi.gif>]])&nbsp;;&nbsp;[[<img src=img-Delta.gif><img src=img-Xi.gif>&nbsp;<img src=img-vdash.gif>&nbsp;<i>M</i>&nbsp;:&nbsp;<i>T</i>]]
   */
  public Mor semantics ()  {
    return (D.semanticsTo (MfreeDbound)).tensor 
      (MfreeDunbound.semantics ().id ()).simpleComp 
      (M.semanticsFrom (MfreeDbound.comp (MfreeDunbound)));
   }
}


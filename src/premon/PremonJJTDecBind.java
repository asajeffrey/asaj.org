/**
 * A binding declaration <b>let</b>&nbsp;<i>P</i>&nbsp;=&nbsp;<i>M</i>;
 * @author Alan Jeffrey
 * @version v1.0 1998/06/10
 */

public class PremonJJTDecBind
extends PremonJJTDec
{
  public PremonJJTDecBind (int id) {
    super (id);
  }
  public void print (Printer p)  {
    p.newLine ();
    p.printBold ("let");
    p.printSpace ();
    p.print (childPat (0));
    p.printString (" = ");
    p.print (childExp (1));
    p.printString (";");
  }
  public PremonCon getBind () throws TypeError  {
    return childPat (0).desugar ().bind;
  }
  public PremonDec desugar (PremonCon Gamma) throws TypeError  {
    PremonPat P = childPat (0).desugar ();
    PremonExp M = childExp (1).desugar (Gamma);
    if (P.type.equals (M.type)) {
      return new PremonDecBind (P,M);
    } else {
      throw new TypeError 
	(
	 "Type error in binding:\n\n" +
	 this.toString () +
	 "\n\nThe pattern has type:\n\n" +
	 P.type.toString () +
	 "\n\nThe expression has type:\n\n" +
	 M.type.toString ()
         );
    }
  }
}

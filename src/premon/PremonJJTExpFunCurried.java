/**
 * <p>An anonymous function
 * <b>fn</b>&nbsp;<i>C</i>&nbsp;<i>P</i><sub>1</sub>&nbsp;...&nbsp;<i>P<sub>n</sub></i>&nbsp;{<i>M</i>}
 * where:
 * <blockquote>
 * <b>fn</b>&nbsp;<i>C</i>&nbsp;<i>P</i><sub>1</sub>&nbsp;<i>P</i><sub>2</sub>&nbsp;...&nbsp;<i>P<sub>n</sub></i>&nbsp;{<i>M</i>}
 * </blockquote>
 * is sugar for
 * <blockquote>
 * <b>fn</b>&nbsp;<b>val</b>&nbsp;<i>P</i><sub>1</sub>&nbsp;{<b>fn</b>&nbsp;<i>P</i><sub>2</sub>&nbsp;...&nbsp;<i>P<sub>n</sub></i>&nbsp;{<i>M</i>}}.
 * </blockquote>
 * Note that the return type of an anonymous function can be determined from
 * the type of its body.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/09
 */

public class PremonJJTExpFunCurried
extends PremonJJTExp
{
  public PremonJJTExpFunCurried (int id) {
    super (id);
  }
  public void print (Printer p)  {
    p.printBold ("fn");
    p.printSpace ();
    p.print (childCat (0));
    p.printSpace ();
    int i = 0;
    while (i < children.length-2) {
      p.printB (childPat (++i));
      p.printSpace ();
    }
    p.printLBrace ();
    p.indent (); 
    p.newLine ();
    p.print (childExp (children.length-1));
    p.outdent ();
    p.newLine ();
    p.printRBrace ();
  }
  public void printA (Printer p)  {
    print (p);
  }
  public PremonExp desugarFrom (int i, PremonCon Gamma) throws TypeError  {
    PremonPat P = childPat (i).desugar ();
    if (i == children.length-2) {
      PremonCat C = childCat (0).desugar ();
      PremonExp M = childExp (children.length-1).desugar (Gamma.comp (P.bind));
      if (M.cat.subcat (C)) {
	return new PremonExpFun (C,P,M);
      } else {
	throw new TypeError 
	  (
	   "Type error in anonymous function:\n\n" +
	   this.toString () +
	   "\n\nThe declared category is:\n\n" +
	   C.toString () +
	   "\n\nThe expression has category:\n\n" +
	   M.cat.toString ()
	   );
      }
    } else {
      return new PremonExpFun 
	(
	 PremonCat.val,
	 P,
	 desugarFrom (i+1, Gamma.comp (P.bind))
         );
    }
  }
  public PremonExp desugar (PremonCon Gamma) throws TypeError  {
    return desugarFrom (1, Gamma);
  }
}


/**
 * A curried function declaration
 * <i>C</i>&nbsp;<i>x</i>&nbsp;<i>P</i><sub>1</sub>&nbsp;...&nbsp;<i>P<sub>n</sub></i>&nbsp;:&nbsp;<i>T</i>&nbsp;{<i>M</i>}
 * which is syntax sugar for
 * <b>let</b>&nbsp;<i>x</i>&nbsp;:&nbsp;<i>U</i>&nbsp;=&nbsp;<b>fn</b>&nbsp;<i>C</i>&nbsp;<i>P</i><sub>1</sub>&nbsp;...&nbsp;<i>P<sub>n</sub></i>&nbsp;{<i>M</i>}
 * where <i>U</i> is the appropriate type (determined from the types of <i>P<sub>i</sub></i> and <i>T</i>).
 * @author Alan Jeffrey
 * @version v1.01 1998/07/20

 */
public class PremonJJTDecBindFunCurried
extends PremonJJTDec
{
  public PremonJJTDecBindFunCurried (int id) {
    super (id);
  }
  public void print (Printer p)  {
    p.newLine ();
    p.print (childCat (0));
    p.printSpace ();
    p.print (childId (1));
    for (int i = 2; i < children.length-2; i++) {
      p.printSpace ();
      p.printB (childPat (i));
    }
    p.print (childType (children.length-2));
    p.printSpace ();
    p.printLBrace ();
    p.indent (); 
    p.newLine ();
    p.print (childExp (children.length-1));
    p.outdent ();
    p.newLine ();
    p.printRBrace ();
  }
  public PremonCon getBind () throws TypeError  {
    PremonType resultType = new PremonTypeFun 
      (
       childCat (0).desugar (),
       childPat (children.length-3).desugar ().type,
       childType (children.length-2).desugar ()         
       );
    for (int i = children.length-4; i>1; i--) {
      resultType = new PremonTypeFun 
	(
	 PremonCat.val,
	 childPat (i).desugar ().type,
	 resultType
	 );
    }
    return new PremonConBind (childId (1).desugarVar (resultType));
  }
  private PremonExp desugarFrom (int i, PremonCon Gamma, PremonType T) throws TypeError  {
    PremonPat P = childPat (i).desugar ();
    if (i == children.length-3) {
      PremonCat C = childCat (0).desugar ();
      PremonExp M = childExp (children.length-1).desugar (Gamma.comp (P.bind));
      if (M.cat.subcat (C)) {
	if (M.type.equals (T)) {
	  return new PremonExpFun (C,P,M);
	} else {
	  throw new TypeError 
	    (
	     "Type error in function declaration:\n\n" +
	     this.toString () +
	     "\n\nThe declared result type is:\n\n" +
	     T.toString () +
	     "\n\nThe expression has type:\n\n" +
	     M.type.toString ()
	     );
	}
      } else {
	throw new TypeError 
	  (
	   "Type error in function declaration:\n\n" +
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
	 desugarFrom (i+1, Gamma.comp (P.bind), T)
         );
    }
  }
  public PremonDec desugar (PremonCon Gamma) throws TypeError  {
    PremonExp M = desugarFrom (2, Gamma, childType (children.length-2).desugar ());
    return new PremonDecBind 
      (
       new PremonPatBind (childId (1).desugarVar (M.type)),
       M
       );
  }
}


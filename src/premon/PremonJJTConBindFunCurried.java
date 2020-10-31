/**
 * The context <i>C</i>&nbsp;<i>x</i>&nbsp;<i>T</i><sub>1</sub>&nbsp;...&nbsp;<i>T<sub>n</sub></i>&nbsp;:&nbsp;<i>T</i>;
 * sugar for
 * <i>x</i>&nbsp;:&nbsp;<i>C</i>&nbsp;<i>T</i><sub>1</sub>&nbsp;...&nbsp;<i>T<sub>n</sub></i>&nbsp;:&nbsp;<i>T</i>;
 * with a default return type of ().
 * @author Alan Jeffrey
 * @version v1.0 1998/06/09
 */

public class PremonJJTConBindFunCurried
extends PremonJJTCon
{
  public PremonJJTConBindFunCurried (int id) {
    super (id);
  }
  public void print (Printer p)  {
    p.print (childCat (0));
    p.printSpace ();
    p.print (childId (1));
    for (int i = 2; i < children.length-1; i++) {
      p.printSpace ();
      p.printB (childType (i));
    }
    p.print (childType (children.length-1));
    p.printString (";");
    p.newLine ();
  }
   public PremonType desugarFrom (int i)  {
     if (i == children.length-2) {
       return new PremonTypeFun 
	 (
	  childCat (0).desugar (),
	  childType (i).desugar (),
	  childType (i+1).desugar ()
	  );
     } else {
       return new PremonTypeFun 
	 (
	  PremonCat.val,
	  childType (i).desugar (),
	  desugarFrom (i+1)
	  );
     }
   }
  public PremonCon desugar ()  {
    return new PremonConBind (childId (1).desugarVar (desugarFrom (2)));
  }
  public PremonCon desugarPrimitives ()  {
    return new PremonConBind 
      (
       childId (1).desugarVarPrimitiveFun (desugarFrom (2), children.length-3)
       );
  }
}


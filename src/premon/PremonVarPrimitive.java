/**
 * This class represents the syntactic class of primitive functions.
 * There is a bit of a hack here, where primitive functions are drawn
 * curried, to improve their appearance.  The <code>curryings</code>
 * parameter says how many times the function should be curried before
 * being drawn (for example for 
 * <code>val&nbsp;+(int,int):int</code> it's one, but for
 * <code>proc&nbsp;if(bool)(proc():int)(proc():int):int</code> it's three).
 */
public class PremonVarPrimitive
extends PremonVar
{

  private int curryings;

  /**
   * Create a new primitive function.
   * @param name the name of the function
   * @param type the type of the function
   * @param curryings how many times to curry the function before drawing it.
   */
  public PremonVarPrimitive (String name, PremonType type, int curryings) {
    super (name, type);
    this.curryings = curryings;
    this.free = PremonCon.empty;
  }

  /**
   * Create a new primitive function with no currying.
   * @param name the name of the function
   * @param type the type of the function
   */
  public PremonVarPrimitive (String name, PremonType type) {
    this (name, type, 0);
  }

  public void print (Printer p)  {
    p.printRoman (name);
  }
  public Mor semantics () {
    return semanticsFun (PremonCat.val, Obj.unit, type, curryings);
  }
  private Mor semanticsFun (PremonCat C, Obj X, PremonType T, int n)  {
    if (n > 0) {
      PremonTypeFun T1 = (PremonTypeFun)T;
      Obj Y = T1.source.semantics ();
      return this.semanticsFun (T1.cat, X.tensor (Y), T1.target, n-1).curry (T1.cat,X,Y);
    } else {
      return new MorGenerator (C, X, T.semantics (), name);
    }
  }

}

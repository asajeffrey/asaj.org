/**
 * The tuple type.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/02
 */

public class PremonTypeTuple
extends PremonType
{

  /**
   * The emtpy tuple type ().
   */
  public static final PremonTypeTuple empty = 
    new PremonTypeTuple (new PremonType[0]);

  private PremonType[] Ts;

  /**
   * A new tuple type.
   * @param Ts the array of types <i>T</i><sub>1</sub>...<i>T<sub>n</sub></i>
   * to tuple together.
   */
  public PremonTypeTuple (PremonType[] Ts) {
    this.Ts = Ts;
  }

  public void print (Printer p)  {
    p.printString ("("); p.printArray (Ts, ", "); p.printString (")");
  }
  public void printB (Printer p)  {
    print (p);
  }

  /**
   * The semantics using tensor.
   * @return [[<i>T</i><sub>1</sub>]]<img src=img-otimes.gif>...<img src=img-otimes.gif>[[<i>T<sub>n</sub></i>]].
   */
  public Obj semantics ()  {
    Obj result = new ObjI ();
    for (int i=0; i<Ts.length; i++) {
      result = result.tensor (Ts[i].semantics());
    }
    return result;
  }

  public boolean equals (PremonType T)  {
    if (T instanceof PremonTypeTuple) {
      PremonTypeTuple T1 = (PremonTypeTuple)(T);
      if (Ts.length != T1.Ts.length) { return false; }
      for (int i=0; i < Ts.length; i++) {
	if (!(Ts[i].equals (T1.Ts[i]))) { return false; }
      }
      return true;
    } else {
      return false;
    }
  }

  /**
   * Tuple types are not traceable.
   * @return false
   */
  public boolean traceable ()  {
    return false;
  }

}


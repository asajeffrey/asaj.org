/**
 * An expression representing a floating point constant <i>d</i>.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/10
 */

public class PremonExpDouble
extends PremonExp
{
  private double d;
  public PremonExpDouble (double d) {
    this.d = d;
    cat = PremonCat.val;
    type = PremonTypeVar.dubble;
    free = PremonCon.empty;
  }
  public void print (Printer p)  {
    p.printString (Double.toString (d));
  }
  public void printA (Printer p)  {
    print (p);
  }
  /**
   * The semantics of the expression.
   * @return <i>d</i> : <i>I</i> <img src=img-rightarrow.gif> <i>double</i>
   */
  public Mor semantics ()  {
    return new MorGenerator 
      (
       this.cat, 
       Obj.unit, 
       ObjGenerator.dubble,
       Double.toString (d)
       );
  }
}


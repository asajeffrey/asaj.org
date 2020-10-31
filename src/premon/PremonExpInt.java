/**
 * An integer constant expression <i>n</i> : <i>int</i>.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/09
 */

public class PremonExpInt
extends PremonExp
{
  private int i;

  /**
   * Create a new integer expression.
   * @param i the integer value.
   */
  public PremonExpInt (int i) {
    this.i = i;
    cat = PremonCat.val;
    type = PremonTypeVar.integer;
    free = PremonCon.empty;
  }
  
  public void print (Printer p)  {
    p.printString (Integer.toString (i));
  }
  public void printA (Printer p)  {
    print (p);
  }
 
  /** 
   * The semantics of the expression.
   * @return <i>n</i> : <i>I</i> <img src=img-rightarrow.gif> <i>int</i>
   */ 
  public Mor semantics ()  {
    return new MorGenerator 
      (
       this.cat, 
       Obj.unit, 
       ObjGenerator.integer,
         Integer.toString (i)
       );
  }
}


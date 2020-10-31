/**
 * A string constant expression "<i>s</i>" : <i>string</i>.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/09
 */

public class PremonExpString
extends PremonExp
{
  private String s;
  /**
   * Create a new expression.
   * @param s the string contents.
   */
  public PremonExpString (String s) {
    this.s = s;
    cat = PremonCat.val;
    type = PremonTypeVar.string;
    free = PremonCon.empty;
  }

  public void print (Printer p)  {
    p.printTypewriter (s);
  }
  public void printA (Printer p)  {
    print (p);
  }
  /**
   * The semantics of the expression.
   * @return <i>s</i> : <i>I</i> <img src=img-rightarrow.gif> <i>string</i>
   */
  public Mor semantics ()  {
    return new MorGenerator 
      (
       this.cat, 
       Obj.unit, 
       ObjGenerator.string,
       s
       );
  }
}


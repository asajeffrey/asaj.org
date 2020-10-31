/**
 * A possibly empty context.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/10
 */

public class PremonJJTConOptional
extends PremonJJTCon
{
  public PremonJJTConOptional (int id) {
    super (id);
  }
   public void print (Printer p)  {
     if (children.length > 0) {
       p.print (childCon (0));
     }
   }
  public PremonCon desugar ()  {
    if (children.length > 0) {
      return childCon (0).desugar ();
    } else {
      return new PremonConEmpty ();
    }
  }
  public PremonCon desugarPrimitives ()  {
    if (children.length > 0) {
      return childCon (0).desugarPrimitives ();
    } else {
      return new PremonConEmpty ();
    }
  }
}

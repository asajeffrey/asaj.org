/**
 * The composition of two contexts.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/10
 */

public class PremonJJTConComp
extends PremonJJTCon
{
  public PremonJJTConComp (int id) {
    super (id);
  }
  public void print (Printer p)  {
    p.print (childCon (0));
    p.print (childCon (1));
  }
  public PremonCon desugar ()  {
    return new PremonConComp 
      (
       childCon (0).desugar (),
       childCon (1).desugar ()
       );
  }
  public PremonCon desugarPrimitives ()  {
    return new PremonConComp 
      (
       childCon (0).desugarPrimitives (),
       childCon (1).desugarPrimitives ()
       );
  }
}


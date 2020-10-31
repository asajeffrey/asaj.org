/**
 * A type variable.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/04
 */
public class PremonJJTTypeVar
extends PremonJJTType
{
  /** 
   * Create the type variable.
   * @param id the node identifier (needed by JJTree).
   */
  public PremonJJTTypeVar (int id) {
    super (id);
  }
  public void print (Printer p)  {
    p.print (childId (0));
  }
  public PremonType desugar ()  {
    return childId (0).desugarTypeVar ();
  }
}


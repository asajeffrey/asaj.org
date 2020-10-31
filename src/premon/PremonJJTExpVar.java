/**
 * An expression <i>x</i>.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/10
 */

public class PremonJJTExpVar
extends PremonJJTExp
{
  public PremonJJTExpVar (int id) {
    super (id);
  }
  public void print (Printer p)  {
    p.print (childId (0));
  }
  public void printA (Printer p)  {
    p.print (childId (0));
  }
  
  /**
   * Desugar it.
   * @param the context.
   * @return this variable, typed as it appears in Gamma.
   * @exception TypeError thrown if this variable does not appear in Gamma.
   */
  public PremonExp desugar (PremonCon Gamma) throws TypeError  {
    return new PremonExpVar (Gamma.lookup (childId (0).name));
  }
}




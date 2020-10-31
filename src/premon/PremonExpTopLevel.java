/**
 * A top-level expression.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/09
 */
public class PremonExpTopLevel
extends PremonExp
{
  private PremonExp M;
  
  /**
   * Create a new top-level expression.
   * @param M the expression.
   */
  public PremonExpTopLevel (PremonExp M) {
    this.M = M;
    cat = M.cat;
    type = M.type;
    free = M.free.uniq ();
  }
  
  public void print (Printer p)  {
    M.print (p);
  }
  public Mor semantics ()  {
    return M.semanticsFrom (this.free);
  }
}


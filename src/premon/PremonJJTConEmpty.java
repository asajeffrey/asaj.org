/**
 * An empty context.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/10
 */

public class PremonJJTConEmpty
extends PremonJJTCon
{
  public PremonJJTConEmpty (int id) {
    super (id);
  }
  public void print (Printer p)  {
  }
  public PremonCon desugar ()  {
    return PremonCon.empty;
  }
  public PremonCon desugarPrimitives ()  {
    return PremonCon.empty;
  }
}


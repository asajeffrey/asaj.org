/**
 * The composition of two declarations.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/10
 */

public class PremonJJTDecComp
extends PremonJJTDec
{
  public PremonJJTDecComp (int id) {
    super (id);
  }
  public void print (Printer p)  {
    p.print (childDec (0));
    p.print (childDec (1));
  }
  public PremonCon getBind () throws TypeError  {
    return childDec (0).getBind ().comp (childDec (1).getBind ());
  }
  public PremonDec desugar (PremonCon Gamma) throws TypeError  {
    PremonDec D = childDec (0).desugar (Gamma);
    PremonDec E = childDec (1).desugar (Gamma.comp (D.bind));
    return new PremonDecComp (D,E);
  }
}



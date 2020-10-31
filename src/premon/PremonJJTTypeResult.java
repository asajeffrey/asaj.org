/**
 * An optional result type for a function.  By default the result type is ().
 * @author Alan Jeffrey
 * @version v1.0 1998/06/04
 */
public class PremonJJTTypeResult
extends PremonJJTType
{
  public PremonJJTTypeResult (int id) {
    super (id);
  }
  public void print (Printer p)  {
    if (children.length > 0) {
      p.printString (" : ");
      p.print (childType (0));
    }
  }
  public PremonType desugar ()  {
    if (children.length > 0) {
      return childType (0).desugar ();
    } else {
      return PremonTypeTuple.empty;
    }
  }
}


/**
 * A pattern <i>x</i>&nbsp;:&nbsp;<i>T</i>
 * @author Alan Jeffrey
 * @version v1.0 1998/06/09
 */

public class PremonJJTPatBind
extends PremonJJTPat
{
  public PremonJJTPatBind (int id) {
    super (id);
  }
  public void print (Printer p)  {
    p.print (childId (0));
    p.printString (" : ");
    p.print (childType (1));
  }
  public PremonPat desugar ()  {
    return new PremonPatBind 
      (childId (0).desugarVar (childType (1).desugar ()));
  }
}


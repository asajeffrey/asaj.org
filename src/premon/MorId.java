/**
 * An identity morphism.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/11
 */
public class MorId
extends MorShuffle
{
  /**
   * Create a new identity morphism id<sub>X</sub>.
   * @param X the source and target object.
   */
  public MorId (Obj X) {
    super (Shuffle.identity (X));
  }

  public void print (Printer p)  {
    p.printRoman ("id"); p.printSubscript (source);
  }

  public Graph0 graph0 (Constraints C, Interface source)  {
    return new Graph0Id (C, source);
  }

  public Mor simpleComp (Mor f)  {
    return f;
  }

  public Mor tensor (Mor f)  { 
    if (f instanceof MorIdI) {
      return this;
    } else if (f instanceof MorId) {
      return source.tensor (f.source).id ();
    } else {
      return super.tensor (f);
    }
  }

}


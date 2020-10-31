/**
 * An empty context.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/09
 */

public class PremonConEmpty
extends PremonCon
{
  public void print (Printer p)  {
  }
  public PremonVar lookup (String s) throws TypeError {
    throw TypeError.unknownVar;
  }
  public boolean binds (PremonVar y)  {
    return false;
  }
  public PremonCon hide (PremonCon Gamma)  {
    return this;
  }
  public PremonCon uniq ()  {
    return this;
  }
  public Obj semantics ()  {
    return Obj.unit;
  }
  public Shuffle shuffleTo (PremonCon Gamma)  {
    return Shuffle.initial (Gamma.semantics ());
  }
  public Shuffle shuffleFromVar (PremonVar x)  {
    return Shuffle.terminal (x.type.semantics ());
  }
  public Shuffle shuffleToVar (PremonVar x)  {
    return Shuffle.initial (x.type.semantics ());
  }
  public PremonCon comp (PremonCon Gamma)  {
    return Gamma;
  }
}


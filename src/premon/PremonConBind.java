/**
 * A context which binds a variable <i>x</i>:<i>T</i>.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/10
 */

public class PremonConBind
extends PremonCon
{
  private PremonVar x;
  
  public PremonConBind (PremonVar x) {
    this.x = x;
  }
  
  public void print (Printer p)  {
    p.printItalic (x.name);
    p.printString (" : ");
    p.print (x.type); 
  }

  public PremonVar lookup (String s) throws TypeError {
    if (s.equals (x.name)) {
      return x;
    } else {
      throw TypeError.unknownVar;
    }
  }
  
  public PremonCon hide (PremonCon Gamma)  {
    if (Gamma.binds (x)) {
      return PremonCon.empty;
    } else {
      return this;
    }
  }
  public boolean binds (PremonVar y)  {
    return (x.name.equals (y.name));
  }
  public PremonCon uniq ()  {
    return this;
   }
  public Obj semantics ()  {
    return x.type.semantics ();
  }
  public Shuffle shuffleTo (PremonCon Gamma)  {
    return Gamma.shuffleFromVar (x);
  }
  public Shuffle shuffleFromVar (PremonVar y)  {
    if (x.name.equals (y.name)) {
      return Shuffle.identity (y.type.semantics ());
    } else {
      return Shuffle.zero (y.type.semantics (), x.type.semantics ());
    }
  }
  public Shuffle shuffleToVar (PremonVar y)  {
    if (x.name.equals (y.name)) {
      return Shuffle.identity (x.type.semantics ());
    } else {
      return Shuffle.zero (x.type.semantics (), y.type.semantics ());
    }
  }
}


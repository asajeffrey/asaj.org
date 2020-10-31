/**
 * The composition of two contexts.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/10
 */

public class PremonConComp
extends PremonCon
{
  private PremonCon Gamma1;
  private PremonCon Gamma2;

  public PremonConComp (PremonCon Gamma1, PremonCon Gamma2) {
    this.Gamma1 = Gamma1;
    this.Gamma2 = Gamma2;
  }
  public void print (Printer p)  {
    p.print (Gamma1); p.printString (";"); p.newLine (); p.print (Gamma2);
  }
  public PremonVar lookup (String s) throws TypeError {
    try {
       return Gamma2.lookup (s);
    } catch (TypeError e) {
      return Gamma1.lookup (s);
    }
  }
  public PremonCon hide (PremonCon Gamma)  {
    PremonCon Gamma2a = Gamma2.hide (Gamma);
    PremonCon Gamma1a = Gamma1.hide (Gamma);
    if ((Gamma1 == Gamma1a) && (Gamma2 == Gamma2a)) {
      return this;
    } else {
      return Gamma1a.comp (Gamma2a);
    }
  }
  public PremonCon uniq ()  {
    PremonCon Gamma2a = Gamma2.uniq ();
    PremonCon Gamma1a = Gamma1.uniq ().hide (Gamma2a);
    if ((Gamma1 == Gamma1a) && (Gamma2 == Gamma2a)) {
      return this;
    } else {
      return Gamma1a.comp (Gamma2a);
    }
  }
  public boolean binds (PremonVar x)  {
    return Gamma1.binds (x) || Gamma2.binds (x);
  }
  public Obj semantics ()  {
    return Gamma1.semantics ().tensor (Gamma2.semantics ());
  }
  public Shuffle shuffleTo (PremonCon Gamma)  {
    return Gamma1.shuffleTo (Gamma).comediate (Gamma2.shuffleTo (Gamma));
  }
  public Shuffle shuffleFromVar (PremonVar x)  {
    return Gamma1.shuffleFromVar (x).mediate (Gamma2.shuffleFromVar (x));
  }
  public Shuffle shuffleToVar (PremonVar x)  {
    return Gamma1.shuffleToVar (x).comediate (Gamma2.shuffleToVar (x));
  }
}


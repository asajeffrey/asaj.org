/**
 * A variable pattern <i>x</i>:<i>T</i>.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/02
 */
public class PremonPatBind
extends PremonPat
{
  private PremonVar x;

  /**
   * Create a binding pattern.
   * @param x the binding typed variable.
   */
  public PremonPatBind (PremonVar x) {
    this.x = x;
    type = x.type;
    bind = x.free;
  }

  public void print (Printer p)  {
    p.printItalic (x.name);
    p.printString (" : ");
    p.print (x.type);
  }
}


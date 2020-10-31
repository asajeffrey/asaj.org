/**
 * An integer constant.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/10
 */

public class PremonJJTExpInt
extends PremonJJTExp
{
  private int value;
  public PremonJJTExpInt (int id) {
    super (id);
  }
  /**
   * Set the value of the integer.
   * @param n the new integer value.
   */
  public void setValue (int n)  {
    this.value = n;
  }
  public void print (Printer p)  {
    p.printString (Integer.toString (value));
  }
  public void printA (Printer p)  {
    p.printString (Integer.toString (value));
  }
  public PremonExp desugar (PremonCon Gamma) throws TypeError  {
    return new PremonExpInt (value);
  }
}


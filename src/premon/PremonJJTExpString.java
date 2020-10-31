/**
 * A string constant.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/10
 */

public class PremonJJTExpString
extends PremonJJTExp
{
  private String value;
  public PremonJJTExpString (int id) {
    super (id);
  }

  /**
   * Set the string contents.
   * @param s the new contents.
   */
  public void setValue (String s)  {
    this.value = s;
  }

  public void print (Printer p)  {
    p.printTypewriter (value);
  }
  public void printA (Printer p)  {
    p.printTypewriter (value);
  }
  public PremonExp desugar (PremonCon Gamma) throws TypeError  {
    return new PremonExpString (value);
  }
}


/**
 * An expression representing a floating point constant.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/09
 */

public class PremonJJTExpDouble
extends PremonJJTExp
{
  private double value;
  public PremonJJTExpDouble (int id) {
    super (id);
  }
  public void setValue (double d)  {
    this.value = d;
  }
  public void print (Printer p)  {
    p.printString (Double.toString (value));
  }
  public void printA (Printer p)  {
    p.printString (Double.toString (value));
  }
  public PremonExp desugar (PremonCon Gamma) throws TypeError  {
    return new PremonExpDouble (value);
  }
}


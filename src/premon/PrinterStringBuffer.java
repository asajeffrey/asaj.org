/**
 * An implementation of the <code>Printer</code> class which sends all
 * output to a string buffer.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/02
 */
public class PrinterStringBuffer
extends Printer
{
  private StringBuffer b;

  /**
   * Create a new printer which stores the output.
   */
  public PrinterStringBuffer () {
    b = new StringBuffer ();
  }

  /**
   * Append a string to the buffer.
   * @param s the string to append.
   */
  public void printRawString (String s)  {
    b.append (s);
  }

  /**
   * Convert the string buffer back to a string.
   * @result the contents of the string buffer.
   */
  public String toString ()  {
    return b.toString ();
  }

}


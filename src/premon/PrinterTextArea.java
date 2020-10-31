import java.awt.*;
/**
 * An implementation of the <code>Printer</code> class which sends
 * all output to a text area.
 * @author Alan Jeffrey
 * @version v1.02 1998/06/27
 */
public class PrinterTextArea
extends Printer
{
  private TextArea ta;

  /**
   * Create a new printer.
   * @param ta the TextArea to print to.
   */
  public PrinterTextArea (TextArea ta) {
    this.ta = ta;
  }

  /**
   * Append a string to the text area.
   * @param s the string to append.
   */
  public void printRawString (String s)  {
    ta.append (s);
  }

}


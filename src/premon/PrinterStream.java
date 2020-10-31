import java.io.*;
/**
 * An implementation of the <code>Printer</code> class which sends the
 * output to a stream.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/02
 */
public class PrinterStream
extends Printer
{
  private PrintStream p;

  /**
   * Create a new printer stream.
   * @param os the stream to send output to.
   */ 
  public PrinterStream (OutputStream os) {
    p = new PrintStream (os);
  }

  /**
   * Print on the output stream.
   * @param s the string to print.
   */
  public void printRawString (String s)  {
    p.print (s);
  }

  /**
   * Close down the output stream.
   */
  public void close ()  {
    p.close ();
  }

}


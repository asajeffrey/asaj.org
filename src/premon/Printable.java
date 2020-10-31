/**
 * A class of printable terms.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/02
 */
public abstract class Printable
{
  /**
   * How to print this term.  This is the only method which needs to be
   * defined, all the others have default implementations.
   * @param p where to print to.
   */
  public abstract void print (Printer p);

  /**
   * Print out debugging information.
   */
  public void debug ()  {
    Printer o = new StdOut ();
    o.printString ("DEBUG: "); o.print (this); o.printString (" END\n");
  }

  /**
   * Print the term as an atom (bracketed by default).
   * @param p where to print to.
   */
  public void printA (Printer p)  {
    this.printB (p);
  }

  /**
   * Print the term with brackets round it.
   * @param p where to print to.
   */
  public void printB (Printer p)  {
    p.printString ("("); this.print (p); p.printString (")");
  }

  /**
   * Convert the term to a string.
   * @return the result of printing the term into a string buffer,
   * then converting the string buffer back to a string.
   */
  public String toString ()  {
    Printer p = new PrinterStringBuffer ();
    this.print (p);
    return p.toString ();
  }
}


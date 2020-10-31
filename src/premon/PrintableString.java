/**
 * An implementation of the <code>Printable</code> class which prints
 * a constant string.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/02
 */
public class PrintableString
extends Printable
{
   private String s;
   public PrintableString (String s) {
      this.s = s;
   }
   public void print (Printer p)  { p.printString (s); }
}


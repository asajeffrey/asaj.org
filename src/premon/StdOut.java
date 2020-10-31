/**
 * An implementation of the <code>Printer</code> class which sends the
 * text to the standard output (useful for debugging).
 * @author Alan Jeffrey
 * @version v1.0 1998/06/02
 */
public class StdOut
extends Printer
{
   public void printRawString (String s)  {
      System.out.print (s);
   }
}


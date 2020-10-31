/**
 * A type <i>T</i><code>...</code><i>U</i>
 * used in drawing graphs with ellipses.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/02
 */
public class PremonJJTTypeDots
extends PremonJJTTypeTuple
{
   public PremonJJTTypeDots (int id) {
      super (id);
   }
   public void print (Printer p)  {
      p.printRoman ("(");
      p.printArray (children, " ... ");
      p.printRoman (")");
   }
   public PremonType desugar ()  {
      return new PremonTypeDots (
         childType (0).desugar (),
         childType (1).desugar ()
      );
   }
}


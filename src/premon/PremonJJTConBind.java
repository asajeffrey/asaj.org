/**
 * The context <i>x</i>&nbsp;:&nbsp;<i>T</i>;
 * @author Alan Jeffrey
 * @version v1.0 1998/06/09
 */

public class PremonJJTConBind
extends PremonJJTCon
{
   public PremonJJTConBind (int id) {
      super (id);
   }
   public void print (Printer p)  {
      p.print (childId (0));
      p.printString (" : ");
      p.print (childType (1));
      p.printString (";");
      p.newLine ();
   }
   public PremonCon desugar ()  {
      return new PremonConBind (
         childId (0).desugarVar (childType (1).desugar ())
      );
   }
   public PremonCon desugarPrimitives ()  {
      return new PremonConBind (
         childId (0).desugarVarPrimitive (childType (1).desugar ())
      );
   }
}


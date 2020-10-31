/**
 * A thunked expression {<i>M</i>},
 * sugar for <b>fn&nbsp;proc</b>&nbsp;()&nbsp;{<i>M</i>}
 * @author Alan Jeffrey
 * @version v1.0 1998/06/09
 */

public class PremonJJTExpFunThunk
extends PremonJJTExp
{
   public PremonJJTExpFunThunk (int id) {
      super (id);
   }
   public void print (Printer p)  {
      p.printLBrace ();
      p.indent ();
         p.newLine ();
         p.print (childExp (0));
      p.outdent ();
      p.newLine ();
      p.printRBrace ();
   }
   public void printB (Printer p)  {
      print (p);
   }
   public PremonExp desugar (PremonCon Gamma) throws TypeError  {
      return new PremonExpFun (
         PremonCat.proc,
         PremonPatTuple.empty,
         childExp (0).desugar (Gamma)
      );
   }
}


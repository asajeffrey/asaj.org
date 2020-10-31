/**
 * An expression (<i>M</i><code>...</code><i>N</i>)
 * used to produce graphs containing ellipses.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/09
 */

public class PremonJJTExpDots
extends PremonJJTExpTuple
{
  public PremonJJTExpDots (int id) {
    super (id);
  }
  public void print (Printer p)  {
    p.printRoman ("(");
    p.printArray (children, " ... ");
    p.printRoman (")");
  }
  public PremonExp desugar (PremonCon Gamma) throws TypeError  {
    PremonExp M = new PremonExpDots 
      (
       childExp (0).desugar (Gamma),
       childExp (1).desugar (Gamma)
       );
    if (M.cat instanceof PremonCatProc) {
      throw new TypeError 
	(
	 "Type error in ellipsis expression:\n\n" +
	 this.toString () +
	 "\n\nThe category should be:\n\n" +
	 "val or central" +
	 "\n\nThe expression has category:\n\n" +
	 M.cat.toString ()
         );         
    } else {
      return M;
    }
  }
}

/**
 * A pattern <i>P</i><code>...</code><i>Q</i>.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/09
 */

public class PremonJJTPatDots
extends PremonJJTPatTuple
{
  public PremonJJTPatDots (int id) {
    super (id);
  }
  public void print (Printer p)  {
    p.printString ("(");
    p.printArray (children, " ... ");
    p.printString (")");
  }
  public PremonPat desugar ()  {
      return new PremonPatDots 
	(
         childPat (0).desugar (),
         childPat (1).desugar ()
	 );
  }
}


/**
 * A composition of two expressions <i>M</i>; <i>N</i>,
 * sugar for <b>let</b>&nbsp;<i>x</i>&nbsp;:&nbsp;<i>T</i>&nbsp;=&nbsp;<i>M</i>;&nbsp;<i>N</i>, where <i>M</i> has type <i>T</i>.
 * <i>M</i>; is sugar for <i>M</i>;&nbsp;().
 * @author Alan Jeffrey
 * @version v1.0 1998/06/09
 */
public class PremonJJTExpComp
extends PremonJJTExp
{
  public PremonJJTExpComp (int id) {
    super (id);
  }
  public void print (Printer p)  {
    p.print (childExp (0));
    p.printString (";");
    p.newLine ();
    if (children.length>1) {
      p.print (childExp (1));
    }
  }
  public PremonExp desugar (PremonCon Gamma) throws TypeError  {
    PremonExp M = childExp (0).desugar (Gamma);
    PremonExp N;
    if (children.length>1) {
      N = childExp (1).desugar (Gamma);
    } else {
      N = PremonExpTuple.empty;
    }
    return new PremonExpDec 
      (
       new PremonDecBind 
       (
	new PremonPatBind (new PremonVar (M.type)), 
	M
	),
       N
       );
  }
}


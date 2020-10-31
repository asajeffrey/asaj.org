/**
 * <p>A pattern binding <i>C</i>&nbsp;<i>x</i>&nbsp;<i>T</i><sub>1</sub>&nbsp;...&nbsp;<i>T<sub>n</sub></i>&nbsp;:&nbsp;<i>U</i> 
 * which is sugar for
 * <i>x</i>&nbsp;:&nbsp;<i>C</i>&nbsp;<i>T</i><sub>1</sub>&nbsp;...&nbsp;<i>T<sub>n</sub></i>&nbsp;:&nbsp;<i>U</i>.</p>
 * In turn, <i>C</i>&nbsp;<i>T</i><sub>1</sub>&nbsp;<i>T</i><sub>2</sub>&nbsp;...&nbsp;<i>T<sub>n</sub></i>&nbsp;:&nbsp;<i>U</i>
 * is sugar for
 * <b>val</b>&nbsp;<i>T</i><sub>1</sub>&nbsp;:&nbsp;<i>C</i>&nbsp;<i>T</i><sub>2</sub>&nbsp;...&nbsp;<i>T<sub>n</sub></i>&nbsp;:&nbsp;<i>U</i>.</p>
 * <p>By default, the return type is ().</p>
 * <p>For example:</p>
 * <ul>
 * <li><p><b>proc</b>&nbsp;<i>x</i>&nbsp;(int)&nbsp;:&nbsp;int
      is sugar for <i>x</i>&nbsp;:&nbsp;<b>proc</b>&nbsp;(int)&nbsp;:&nbsp;int</p></li>
 * <li><p><b>proc</b>&nbsp;<i>x</i>(int)&nbsp;(int)&nbsp;:&nbsp;int
      is sugar for <i>x</i>&nbsp;<b>val</b>&nbsp;(int)&nbsp;:&nbsp;<b>proc</b>&nbsp;(int)&nbsp;:&nbsp;int</p></p></li>
 * <li><p><b>proc</b>&nbsp;<i>if</i>&nbsp;(bool)&nbsp;(<b>proc</b>&nbsp;())&nbsp;(<b>proc</b>&nbsp;())
 *    is sugar for <i>if</i>&nbsp;:&nbsp;<b>val</b>&nbsp;(bool)&nbsp;:&nbsp;<b>val</b>&nbsp;(<b>proc</b>&nbsp;()&nbsp;:&nbsp;())&nbsp;:&nbsp<b>proc</b>&nbsp;(<b>proc</b>&nbsp;()&nbsp;:&nbsp;())&nbsp;:&nbsp;()</p></li>
 * </ul>
 * @author Alan Jeffrey
 * @version v1.0 1998/06/09
 */

public class PremonJJTPatBindFunCurried
extends PremonJJTPat
{
  public PremonJJTPatBindFunCurried (int id) {
    super (id);
  }
  public void print (Printer p)  {
    p.print (childCat (0));
    p.printSpace ();
    p.print (childId (1));
    int i = 1;
    while (i < children.length-2) {
      p.printSpace ();
      p.printB (childType (++i));
    }
    p.print (childType (children.length-1));
  }
  private PremonType desugarFrom (int i)  {
    if (i == children.length-2) {
      return new PremonTypeFun 
	(
	 childCat (0).desugar (),
	 childType (i).desugar (),
	 childType (i+1).desugar ()
         );
    } else {
      return new PremonTypeFun 
	(
	 PremonCat.val,
	 childType (i).desugar (),
	 desugarFrom (i+1)
         );
    }
  }
  public PremonPat desugar ()  {
    return new PremonPatBind 
      (childId (1).desugarVar (desugarFrom (2)));
  }
}


/**
 * <p>A type for functions including syntax sugar for curried
 * functions <i>C</i>&nbsp;<i>T</i><sub>1</sub>&nbsp;...&nbsp;<i>T<sub>n</sub></i>&nbsp;:&nbsp;<i>U</i>.</p>
 * <p><i>C</i>&nbsp;<i>T</i><sub>1</sub>&nbsp;<i>T</i><sub>2</sub>&nbsp;...&nbsp;<i>T<sub>n</sub></i>&nbsp;:&nbsp;<i>U</i>
 * is sugar for
 * <b>val</b>&nbsp;<i>T</i><sub>1</sub>&nbsp;:&nbsp;<i>C</i>&nbsp;<i>T</i><sub>2</sub>&nbsp;...&nbsp;<i>T<sub>n</sub></i>&nbsp;:&nbsp;<i>U</i>.</p>
 * <p>By default, the return type is ().</p>
 * <p>For example:</p>
 * <ul>
 * <li><p><b>proc</b>&nbsp;(int)&nbsp;:&nbsp;int
      is sugar for <b>proc</b>&nbsp;(int)&nbsp;:&nbsp;int</p></li>
 * <li><p><b>proc</b>&nbsp;(int)&nbsp;(int)&nbsp;:&nbsp;int
      is sugar for <b>val</b>&nbsp;(int)&nbsp;:&nbsp;<b>proc</b>&nbsp;(int)&nbsp;:&nbsp;int</p></p></li>
 * <li><p><b>proc</b>&nbsp;(bool)&nbsp;(<b>proc</b>&nbsp;())&nbsp;(<b>proc</b>&nbsp;())
 *    is sugar for <b>val</b>&nbsp;(bool)&nbsp;:&nbsp;<b>val</b>&nbsp;(<b>proc</b>&nbsp;()&nbsp;:&nbsp;())&nbsp;:&nbsp<b>proc</b>&nbsp;(<b>proc</b>&nbsp;()&nbsp;:&nbsp;())&nbsp;:&nbsp;()</p></li>
 * </ul>
 * @author Alan Jeffrey
 * @version v1.01 1998/07/20
 */

public class PremonJJTTypeFunCurried
extends PremonJJTType
{
  public PremonJJTTypeFunCurried (int id) {
    super (id);
  }
  public void print (Printer p)  {
    p.print (childCat (0));
    for (int i = 1; i < children.length-1; i++) {
      p.printSpace ();
      p.printB (childType (i));
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
  public PremonType desugar ()  {
    return desugarFrom (1);
  }
}



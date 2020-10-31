/**
 * A function type.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/02
 */
public class PremonTypeFun
extends PremonType
{
  /**
   * The category of the function.
   */
  public PremonCat cat;

  /**
   * The source type of the function.
   */
  public PremonType source;

  /**
   * The target type of the function.
   */
  public PremonType target;

  /**
   * Create a new function type.
   * @param cat the category of the function.
   * @param source the argument type.
   * @param U the result type.
   */
  public PremonTypeFun (PremonCat cat, PremonType source, PremonType target) {
    this.cat = cat;
    this.source = source;
    this.target = target;
  }

  public void print (Printer p)  {
    p.print (cat); 
    p.printSpace ();
    p.printB (source); 
    p.printString (" : ");; 
    p.print (target); 
  }

  /**
   * The semantics is given using the appropriate function space.
   * @return [[<i>T</i>]] <img src=img-blue-Rightarrow.gif> [[<i>U</i>]] if <i>C</i> is <font color=blue>val</font>,
   * [[<i>T</i>]] <img src=img-magenta-Rightarrow.gif> [[<i>U</i>]] if <i>C</i> is <font color=magenta>central</font>, and
   * [[<i>T</i>]] <img src=img-red-Rightarrow.gif> [[<i>U</i>]] if <i>C</i> is <font color=red>proc</font>.
   */  
  public Obj semantics ()  { 
    return new ObjFun (cat,source.semantics (),target.semantics ());
  }

  public boolean equals (PremonType V)  {
    if (V instanceof PremonTypeFun) {
      PremonTypeFun V1 = (PremonTypeFun)(V);
      return cat.equals (V1.cat) && source.equals (V1.source) && target.equals (V1.target);
    } else {
      return false;
    }
  }

  /**
   * This type is traceable iff <i>C</i> is <font color=red>proc</font>
   * or (<i>C</i> is <font color=blue>val</font> and <i>U</i> is traceable).
   */
  public boolean traceable ()  {
    if (cat instanceof PremonCatProc) {
      return true;
    } else if (cat instanceof PremonCatVal) {
      return target.traceable ();
    } else {
      return false;
    }
  }
}


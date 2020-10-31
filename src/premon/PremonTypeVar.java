/**
 * A type variable.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/02
 */

public class PremonTypeVar
extends PremonType
{

  private String s;

  /**
   * The type variable <code>string</code>.
   */
  public static PremonTypeVar string = new PremonTypeVar ("string");
  
  /**
   * The type variable <code>int</code>.
   */
  public static PremonTypeVar integer = new PremonTypeVar ("int");
  
  /**
   * The type variable <code>double</code>.
   */
  public static PremonTypeVar dubble = new PremonTypeVar ("double");
  
  /** 
   * Create a new type variable.
   * @param s the name of the type.
   */
  public PremonTypeVar (String s) {
    this.s = s;
  }
  
  public void print (Printer p)  {
    p.printRoman (s);
  }
  
  /**
   * Returns a generator.
   * @return s (viewed as a sort).
   */
  public Obj semantics ()  {
    return new ObjGenerator (s);
  }
  
  public boolean equals (PremonType T)  {
    if (T instanceof PremonTypeVar) {
      return s.equals (((PremonTypeVar)T).s);
    } else {
      return false;
    }
  }
  
  /** 
   * Type variables are not traceable.
   * @return false.
   */
  public boolean traceable ()  {
    return false;
  }

}



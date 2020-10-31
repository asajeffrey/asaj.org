/**
 * A homobject C[X,Y].
 * @author Alan Jeffrey
 * @version v1.0 1998/06/09
 */
public class ObjFun
extends Obj
{

  /**
   * The category of the homobject.
   */
  public final PremonCat cat;

  /**
   * The source object.
   */
  public final Obj source;

  /** 
   * The target object.
   */
  public final Obj target;

  /**
   * Create a new homobject C[X,Y].
   * @param C the category.
   * @param X the source object.
   * @param Y the target object.
   * @return C[X,Y] the homobject.
   */
   public ObjFun (PremonCat C, Obj X, Obj Y) {
     cat = C;
     source = X;
     target = Y;
     size = 1;
   }

  public void print (Printer p)  {
    p.print (cat); p.printString ("["); p.print (source); 
    p.printString (", "); 
    p.print (target); p.printString ("]");
  }

}


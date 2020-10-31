/**
 * The class of objects.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/11
 */
public abstract class Obj
extends Printable
{
  /** 
   * Each object has a size (given by the homomorphic map which takes
   * <i>I</i> to 0, primitives and functions to 1, 
   * and <img src=img-otimes.gif> to +).
   */
  public int size;

  /**
   * The unit object <i>I</i>.
   */
  public static Obj unit = new ObjI ();

  /**
   * The identity morphism for this object.
   * @return the identity morphism for this object.
   */
  public Mor id ()  { return new MorId (this); }

  /**
   * The tensor of two objects.
   * @param X the other object to tensor with.
   * @return this <img src=img-otimes.gif> X.
   */
  public Obj tensor (Obj X)  { 
    if (X instanceof ObjI) {
      return this;
    } else {
      return new ObjTensor (this,X);
    }
  }

  /**
   * A homobject with this as source.
   * @param C the category of the hom.
   * @param X the target object.
   * @return the homobject C[this,X]
   */
  public Obj fun (PremonCat C, Obj X)  { return new ObjFun (C,this,X); }

}


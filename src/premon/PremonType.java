/**
 * The class representing a type.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/03
 */
public abstract class PremonType
extends Printable
{
  /** 
   * Find the semantics of the type as an object.
   * @return [[<i>this</i>]].
   */
  public abstract Obj semantics ();

  /**
   * Equality on types.
   * @param T the type to compare to.
   * @return true iff this type equals T.
   */
  public abstract boolean equals (PremonType T);

  /**
   * Is the type traceable?
   * @return true iff this type is traceable.
   */
  public abstract boolean traceable ();

}


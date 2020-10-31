/**
 * The syntactic class of type-annotated declarations, without syntax sugar.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/10
 */

public abstract class PremonDec
extends Printable
{
  /**
   * The category of the declaration.
   */
  public PremonCat cat;

  /**
   * The bound variables of the declaration.
   */
  public PremonCon bind;

  /** 
   * The free variables of the declaration.
   */
  public PremonCon free;

  /**
   * The semantics of the declaration, with a given context to aim 
   * for.  The context should be a subset of the bound variables of
   * the declaration.
   * @param target the context to aim at.
   * @return [[<i>free</i> <img src=img-vdash.gif> <i>D</i> : <i>target</i>]]
   */
  public abstract Mor semanticsTo (PremonCon target);

}


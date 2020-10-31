/**
 * The syntactic class of contexts <img src=img-Gamma.gif>.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/10
 */

public abstract class PremonCon
extends Printable
{

  /**
   * An empty context.
   */
   public final static PremonCon empty = new PremonConEmpty ();

  /**
   * Remove the variables in one context from the current ones.
   * @param Gamma the variables to remove.
   * @return this context with the variables from Gamma removed.
   */
  public abstract PremonCon hide (PremonCon Gamma);

  /**
   * Does this context bind a given variable?
   * @param x the variable to check.
   * @return true if this context contains x.
   */
  public abstract boolean binds (PremonVar x);

  /**
   * `Uniqueify' the context, by removing any duplicate variables.
   * @return this context with any duplicate variables removed.
   */
  public abstract PremonCon uniq ();

  /**
   * The semantics of the context as an object.
   * @return [[<img src=img-Gamma.gif>]]
   */
  public abstract Obj semantics ();

  /**
   * The (partial) shuffle from this context to another.
   * The shuffle will be total if Gamma is contained in this context.
   * @param Gamma the context to shuffle to.
   * @return a shuffle [[<i>this</i>]] <img src=img-rightarrow.gif> [[<img src=img-Gamma.gif>]]
   */
  public abstract Shuffle shuffleTo (PremonCon Gamma);

  /**
   * The (partial) shuffle from a variable to this context.
   * The shuffle will be total if this context binds at most x.
   * @param x the variable to shuffle from.
   * @return a shuffle [[<i>x</i>:<i>T</i>]] <img src=img-rightarrow.gif> [[<i>this</i>]]
   */
  public abstract Shuffle shuffleFromVar (PremonVar x);

  /**
   * The (partial) shuffle from this context to a variable.
   * The shuffle will be total if this context binds at least x.
   * @param the variable to shuffle to.
   * @return a shuffle [[<i>this</i>]] <img src=img-rightarrow.gif> [[<i>x</i>:<i>T</i>]]
   */
  public abstract Shuffle shuffleToVar (PremonVar x);

  /**
   * Look up a variable in the context.
   * @param s the name of the variable to find.
   * @return the variable of that name in this context.
   * @exception TypeError thrown if this context does not contain s.
   */
  public abstract PremonVar lookup (String s) throws TypeError;

  /**
   * Compose this context with another.
   * @param Gamma the context to compose with.
   * @return the composite of the two contexts.
   */
  public PremonCon comp (PremonCon Gamma)  {
    if (Gamma instanceof PremonConEmpty) {
      return this;
    } else {
      return new PremonConComp (this,Gamma);
    }
  }

  /**
   * The semantics of this context as a shuffle.
   * @param Gamma the context to shuffle to.
   * @return [[[<i>this</i> : <i>Gamma</i>]]
   */
  public Mor semanticsTo (PremonCon Gamma)  {
    return shuffleTo (Gamma).morphism ();
  }

}


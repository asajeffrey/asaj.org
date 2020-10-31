/**
 * The syntactic class of contexts (including syntax sugar).
 * @author Alan Jeffrey
 * @version v1.0 1998/06/09
 */

public abstract class PremonJJTCon
extends PremonJJTNode
{
  /**
   * Desugar it.
   * @return the context with the syntax sugar removed.
   */
  public abstract PremonCon desugar ();

  /**
   * Desugar it.
   * @return the context with the syntax sugar removed, and all
   *   the variables tagged as being primitives.
   */
  public abstract PremonCon desugarPrimitives ();

  public PremonJJTCon (int id) {
    super (id);
  }
}


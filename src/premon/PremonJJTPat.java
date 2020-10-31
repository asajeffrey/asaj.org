/**
 * The syntactic class of patterns (including syntax sugar).
 * @author Alan Jeffrey
 * @version v1.0 1998/06/09
 */

public abstract class PremonJJTPat
extends PremonJJTNode
{
  /**
   * Desugar it.
   * @return the pattern with syntax sugar stripped out.
   */
  public abstract PremonPat desugar ();
  public PremonJJTPat (int id) {
    super (id);
  }
}


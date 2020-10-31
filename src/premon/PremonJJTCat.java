/**
 * A category (either val, central or proc).
 * @author Alan Jeffrey
 * @version v1.0 1998/06/09
 */

public abstract class PremonJJTCat
extends PremonJJTNode
{
  /**
   * Desugar it.
   * @return the category as a PremonCat.
   */
  public abstract PremonCat desugar ();
  public PremonJJTCat (int id) {
    super (id);
  }
}


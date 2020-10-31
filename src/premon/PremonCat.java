/**
 * The syntactic category of categories (either val, central or proc).
 * @author Alan Jeffrey
 * @version v1.0 1998/06/10
 */

public abstract class PremonCat
extends Printable
{
  /**
   * Find the join of two categories under the partial order val <= central <= proc.
   * @param C the category to compare with.
   * @return the larger of the two categories.
   */
  public abstract PremonCat join (PremonCat C);

  /**
   * Are two categories equal?
   * @param C the category to compare with.
   * @return true if the categories are equal.
   */
  public abstract boolean equals (PremonCat C);

  /** 
   * Is one category a subcat of another?
   * @param C the category to compare with.
   * @return true if this is a subcat of C.
   */
  public abstract boolean subcat (PremonCat C);

  /**
   * The category val.
   */
  public static final PremonCat val = new PremonCatVal ();

  /**
   * The category central.
   */
  public static final PremonCat central = new PremonCatCentral ();

  /**
   * The category proc.
   */
  public static final PremonCat proc = new PremonCatProc ();
}


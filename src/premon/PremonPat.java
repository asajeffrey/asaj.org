/**
 * The syntactic class of patterns.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/03
 */
public abstract class PremonPat
extends Printable
{
  /**
   * The type of the pattern.
   */
   public PremonType type;

  /**
   * The bound variables of the pattern.
   */
   public PremonCon bind;

}


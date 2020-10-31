/**
 * The syntactic class of types (including syntax sugar).
 * @author Alan Jeffrey
 * @version v1.0 1998/06/04
 */
public abstract class PremonJJTType
extends PremonJJTNode
{
  /**
   * Remove the syntax sugar.
   * @return the type with all syntax sugar removed.
   */
   public abstract PremonType desugar ();

  /**
   * Create a node.
   * @param id the node identifier (needed by JJTree).
   */
   public PremonJJTType (int id) {
      super (id);
   }

}


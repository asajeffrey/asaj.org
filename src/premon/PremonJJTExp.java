/**
 * The syntactic class of expressions (including syntax sugar).
 * @author Alan Jeffrey
 * @version v1.0 1998/06/09
 */

public abstract class PremonJJTExp
extends PremonJJTNode
{
  /**
   * Desugar it.
   * @param Gamma the type context (since desugared terms are type-annotated).
   * @returns this expression with the syntax sugar stripped out,
   *   and with type annotations.
   * @exception TypeError thrown if the term does not typecheck.
   */
  public abstract PremonExp desugar (PremonCon Gamma) throws TypeError;
  
  public PremonJJTExp (int id) {
    super (id);
  }

}


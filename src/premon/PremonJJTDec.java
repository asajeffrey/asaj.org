/**
 * The syntactic class of declarations (including syntax sugar).
 * @author Alan Jeffrey
 * @version v1.0 1998/06/10
 */

public abstract class PremonJJTDec
extends PremonJJTNode
{
  /**
   * Desugar it.
   * @param Gamma the type context for all the variables.
   * @return the declaration with all syntax sugar removed, and
   *   annotated with types.
   * @exception TypeError thrown if the declaration fails to typecheck.
   */
  public abstract PremonDec desugar (PremonCon Gamma) throws TypeError;
 
  /**
   * Find the bound variables of the context.
   * @return the bound variables, with their types.
   * @exception TypeError thrown if the declaration fails to typecheck.
   */
  public abstract PremonCon getBind () throws TypeError;

  public PremonJJTDec (int id) {
    super (id);
  }

}


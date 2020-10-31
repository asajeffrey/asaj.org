/**
 * A class of semantic errors.  This exception can only be raised by
 * finding the semantics of ill-typed terms.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/02
 */
public class SemanticError
extends RuntimeException
{
  public SemanticError () {
    super ("A semantic error has occurred.\nThis should not happen if the term has been typechecked.\nYou may have found a bug...");
   }
}

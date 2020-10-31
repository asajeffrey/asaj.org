/**
 * An exception which indicates a type error.  This is raised when
 * sugared syntax is typechecked and desugared.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/10
 */
public class TypeError
extends Exception
{
  public static final TypeError unknownVar = 
    new TypeError ("Unknown variable");
  public TypeError (String explanation) {
    super (explanation);
  }
}


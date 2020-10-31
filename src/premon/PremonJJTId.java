/**
 * An identifier.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/09
 */

public class PremonJJTId
extends PremonJJTNode
{
  static int counter = 0;
  public String name;

  public PremonJJTId (int id) {
    super (id);
  }

  /**
   * Set the name of the identifier.
   * @param s the name.
   * @return this identifier.
   */
  public PremonJJTId setName (String s)  {
    this.name = s;
    return this;
  }

  public void print (Printer p)  {
    p.printItalic (name);
  }
  public String toString ()  {
    return "Id " + name;
  }

  /**
   * Desugar the identifer.
   * @param T the type of the desugared variable.
   * @return this identifier as a typed variable.
   */
  public PremonVar desugarVar (PremonType T)  {
    return new PremonVar (name, T);
  }

  /**
   * Desugar the identifer.
   * @param T the type of the desugared constant.
   * @return this identifier as a typed primitive constant.
   */
  public PremonVar desugarVarPrimitive (PremonType T)  {
    return new PremonVarPrimitive (name, T);
  }

  /**
   * Desugar the identifer.
   * @param T the type of the desugared function.
   * @param curryings how many times the function has been curried.
   * @return this identifier as a typed primitive function.
   */
  public PremonVar desugarVarPrimitiveFun (PremonType T, int curryings)  {
    return new PremonVarPrimitive (name, T, curryings);
  }

  /**
   * Desugar the identifier.
   * @return this identifier as a type variable.
   */
  public PremonType desugarTypeVar ()  {
    return new PremonTypeVar (name);
  }

}

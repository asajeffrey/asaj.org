/**
 * The syntactic class of variables.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/02
 */
public class PremonVar
extends Printable
{
  private static int count = 0;

  /**
   * The name of the variable.
   */
  public String name;

  /**
   * The type of the variable.
   */
  public PremonType type;

  /**
   * The free variables.
   */
  public PremonCon free;

  /**
   * Create a new variable.
   * @param name the name of the variable.
   * @param type the type of the variable.
   */
  public PremonVar (String name, PremonType type) {
    this.name = name;
    this.type = type;
    this.free = new PremonConBind (this);
  }

  /**
   * Create a new fresh variable.
   * @return a fresh variable.
   */
  public PremonVar (PremonType type) {
    this ("a_" + count++, type);
  }

  /**
   * Find the semantics of the variable.
   * @return the identity morphism of the variable's type.
   */
  public Mor semantics () {
    return type.semantics (). id ();
  }

  /**
   * Alpha-convert the variable.
   * @return a new variable with a distinct name.
   */
  public PremonVar alphaConvert ()  {
    return new PremonVar (name + "_" + count++, type);
  }

  /**
   * Print the variable.
   * @param p where to print to.
   */
  public void print (Printer p)  {
    p.printItalic (name);
  }
}

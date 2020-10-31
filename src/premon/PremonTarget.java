/**
 * A class used by the source editor, which allows either the
 * constructors, the context, or the term to be edited.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/03
 */

public abstract class PremonTarget
{
  /**
   * The raw text being edited.
   */
  public Printable text;

  /**
   * The parsed version of the text being edited.
   */ 
  public Printable parsed;

  /**
   * The desugared version of the text being edited.
   */
  public Printable desugared;

  /**
   * The name of the class being edited.
   */
  public String name;

  /**
   * Desugar it.
   * @exception TypeError if the new term is not typesafe.
   */
  public abstract void desugar () throws TypeError;

  /** 
   * Parse it.
   * @param s the string to parse.
   * @exception ParseException if the new term is not syntactically well formed.
   */
  public abstract void parse (String s) throws ParseException;

  /**
   * Reset it to the original value.
   */
  public abstract void reset ();

}


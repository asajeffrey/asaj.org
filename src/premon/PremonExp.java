/**
 * The syntactic class of expressions (without syntax sugar,
 * and with type annotations).
 * @author Alan Jeffrey
 * @version v1.0 1998/06/09
 */

public abstract class PremonExp
extends Printable
{
  /**
   * The category of the expression.
   */
  public PremonCat cat;

  /**
   * The type of the expression.
   */
  public PremonType type;

  /**
   * The free variables of the expression.
   */
  public PremonCon free;

  /**
   * The semantics of the expression.
   * @return 
   *  [[<i>free</i>&nbsp;<img src=img-vdash.gif>&nbsp;<i>this</i>&nbsp;:&nbsp;<i>type</i>]]&nbsp;:&nbsp;[[<i>free</i>]]&nbsp;<img src=img-rightarrow.gif>&nbsp;[[<i>type</i>]]
   */
  public abstract Mor semantics ();

  /**
   * The semantics of the expression, from a given context
   * (which should be an extension of <i>free</i>).
   * @param Gamma the context to use.
   * @return 
   *  [[<i>Gamma</i>&nbsp;<img src=img-vdash.gif>&nbsp;<i>this</i>&nbsp;:&nbsp;<i>type</i>]]&nbsp;:&nbsp;[[<i>Gamma</i>]]&nbsp;<img src=img-rightarrow.gif>&nbsp;[[<i>type</i>]]
   * = 
   * [[<i>Gamma</i>&nbsp;<img src=img-vdash.gif>&nbsp;<i>free</i>]]&nbsp;;&nbsp;[[<i>free</i>&nbsp;<img src=img-vdash.gif>&nbsp;<i>this</i>&nbsp;:&nbsp;<i>type</i>]]
   */
  public Mor semanticsFrom (PremonCon Gamma)  {
    return Gamma.semanticsTo (this.free).comp (this.semantics ());
  }
  
  /**
   * Apply this expression to another.
   * @param N the argument.
   * @return the application of this to N.
   * @exception TypeError if either:
   * <ul>
   * <li> this is not a value.
   * <li> this is not a function type.
   * <li> the argument type of this is different from the type of N.
   * </ul>
   */
  public PremonExp apply (PremonExp N) throws TypeError {
    if (cat instanceof PremonCatVal) {
      if (type instanceof PremonTypeFun) {
	PremonTypeFun T = (PremonTypeFun)(type);
	if (T.source.equals (N.type)) {
	  return new PremonExpApp (this,N);
	} else {
	  throw new TypeError 
	    (
	     "Type error in function application:\n\n" +
	     toString () +
	     "\n\nThe function expects argument type:\n\n" +
	     T.source.toString () +
	     "\n\nThe argument has type:\n\n" +
	     N.type.toString ()
	     );
	}
      } else {
	throw new TypeError 
	  (
	   "Type error in function application:\n\n" +
	   toString () +
	   "\n\nThe function has non-function type:\n\n" +
	   type.toString () 
	   );
      }
    } else {
      throw new TypeError 
	(
	 "Type error in function application:\n\n" +
	 toString () +
	 "\n\nThe function is not a value."
	 );
    }
  }
}



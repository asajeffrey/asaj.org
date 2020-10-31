/**
 * <p>A <i>shuffle</i> is a morphism built from tensor, composition,
 * identity, symmetry, terminal and diagonal.  A shuffle can be
 * represented as a function from integers (the size of the target)
 * to integers (the size of the source).  A <i>partial
 * shuffle</i> can be represented by a partial function.</p>
 * <p>The operations on a partial shuffle are:</p>
 * <ul>
 * <li><p>identity shuffle.</p></li>
 * <li><p>tensor of two shuffles.</p></li>
 * <li><p>composition of two shuffles.</p></li>
 * <li><p>terminal (an empty shuffle with empty target)</p></li>
 * <li><p>zero (an empty partial shuffle).</p></li>
 * <li><p>mediator of two shuffles (using the product structure of shuffles).</p></li>
 * <li><p>comediator of two partial shuffles (using the coproduct structure of partial shuffles).</p></li>
 * </ul>
 * @author Alan Jeffrey
 * @version v1.0 1998/06/02
 */
public abstract class Shuffle
extends Printable
{

  /**
   * The size of the source object.
   */
  public Obj source;

  /**
   * The size of the target object.
   */
  public Obj target;

  /**
   * The (partial) shuffle viewed as a (partial) function on integers.
   * @param i the index ranging 1..target.size.
   * @return the result ranging 1..source.size (0 if undefined).
   */
  public abstract int shuffle (int i);

  private boolean isIdentity () {
    if (source.size != target.size) { return false; }
    for (int i=1; i <= source.size; i++) {
      if (shuffle (i) != i) { return false; }
    }
    return true;
  }
  
  /**
   * An identity shuffle.
   * @param X the object.
   * @return the identity morphism.
   */
  static public Shuffle identity (Obj X) {
    return new ShuffleIdentity (X);
  }

  /**
   * An empty partial shuffle.
   * @param X the source object.
   * @param Y the target object.
   * @return the empty partial shuffle.
   */
  static public Shuffle zero (Obj X, Obj Y) {
    return new ShuffleZero (X,Y);
  }

  /**
   * A terminal shuffle.
   * @param X the object.
   * @return the terminal morphism.
   */
  static public Shuffle terminal (Obj X) {
    return new ShuffleTerminal (X);
  }

  /**
   * A initial shuffle.
   * @param X the object.
   * @return the initial morphism.
   */
  static public Shuffle initial (Obj X) {
    return new ShuffleInitial (X);
  }

  /**
   * The comediation of two partial shuffles.
   * @param f the other partial suffle.
   * @return the comediation.
   */
  public Shuffle comediate (Shuffle f)  { 
    return new ShuffleCoMediate (this,f);
  }

  /**
   * The mediation of two (partial) shuffles.
   * @param f the other (partial) shuffle.
   * @return the mediation.
   */
  public Shuffle mediate (Shuffle f)  { 
    return new ShuffleMediate (this,f);
  }

  /**
   * The composition of two (partial) shuffles.
   * @param f the other (partial) shuffle.
   * @return the composition.
   */
  public Shuffle comp (Shuffle f)  { 
    return new ShuffleComp (this,f);
  }

  /**
   * The tensor fo two (partial) shuffles.
   * @param f the other (partial) shuffle.
   * @return the tensor.
   */
  public Shuffle tensor (Shuffle f)  { 
    return new ShuffleTensor (this,f);
  }

  /**
   * Build a morphism from a shuffle.
   * @return this shuffle as a morphism.
   */
  public Mor morphism ()  {
    if (this.isIdentity ()) {
      return source.id ();
    } else {
      return new MorShuffle (this);
    }
  }

  /**
   * Print the shuffle (useful for debugging).
   * @param p where to print to.
   */
  public void print (Printer p)  {
    p.printString ("[");
    if (this.target.size > 0) {
      for (int i = 1; i < target.size; i++) {
	p.printString (Integer.toString (this.shuffle (i)));
	p.printArrow ();
	p.printString (Integer.toString (i));
	p.printString (", ");
      }
      p.printString (Integer.toString (this.shuffle (target.size)));
      p.printArrow ();
      p.printString (Integer.toString (target.size));
    }
    p.printString ("]");
  }
}


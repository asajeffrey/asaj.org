import java.awt.*;
import java.util.*;

/**
 * <p>A class representing a collection of constraints.  Each constraint is
 * of the form <i>x</i>&nbsp;+<i>d</i>&nbsp;<=&nbsp;<i>y</i> where
 * <i>x</i> and <i>y</i> are variables and <i>d</i> is a non-negative
 * constant.</p>
 * <p>There should be no cyclic dependencies, such as 
 * <i>x</i>&nbsp;+&nbsp;1&nbsp;<=&nbsp;<i>y</i>, 
 * <i>y</i>&nbsp;+&nbsp;1&nbsp;<=&nbsp;<i>x</i>, 
 * since such dependencies obviously have no solution.</p>
 * <p>Variables are implemented as integers.</p>
 * <p>Constraint sets can be <i>solved</i> returning an object of
 * class <code>Solution</code>.</p>
 * @see Solution
 */
public class Constraints
extends Printable
{

  /**
   * The font metrics used in these constraints.
   */
  public final FontMetrics fm;

  /**
   * The number of variables in the constraint set.
   */
  public int varCount;

  /**
   * The constraints on which variables are above which others.
   */
  public ConstraintVector above;

  /**
   * The constraints on which variables are below which others.
   */
  public ConstraintVector below;

  /*
   * Which variables are horizontal.
   */
  private BitSet horizontal;

  /*
   * The font height.
   */
  private int fontHeight;

  /**
   * Create a new constraint set.
   * @param fm the font metrics to base all distances on.
   */
  public Constraints (FontMetrics fm) {
    this.fm = fm;
    varCount = 0;
    above = new ConstraintVector ();
    below = new ConstraintVector ();
    horizontal = new BitSet ();
    fontHeight = fm.getMaxAscent () + fm.getMaxDescent ();
  }

  /**
   * Print the constraint set (useful for debugging).
   * @param p where to print to.
   */
  public void print (Printer p)  {
    int i = 0;
    while (i < this.varCount) {
      p.printString ("[" + i + "] <= ");
      p.print (this.above.get (i));
      p.newLine ();
      i = i+1;
    }
  }

  /**
   * Solve the constraint set.
   * @return the solution.
   */
  public Solution solve ()  {
    return new Solution (this);
  }

  /**
   * Create a new vertical variable.
   * @return the new variable.
   */
  public int newVVar ()  {
    varCount = varCount + 1;
    above.create ();
    below.create ();
    return varCount - 1;;
  }

  /**
   * Create a new horizontal variable.
   * @return the new variable.
   */
  public int newHVar ()  {
    horizontal.set (varCount);
    return newVVar ();
  }

  /**
   * Is this variable horizontal or vertical?
   * @param x the variable.
   * @return true iff the variable is horizontal.
   */
  public boolean isHorizontal (int x) {
    return horizontal.get (x);
  }

  /**
   * Add a constraint <i>x</i> + 0 <= <i>y</i>
   * @param x the lower variable
   * @param y the higher variable
   */
   public void gap0 (int x, int y)  {
      above.gap (0,x,y);
      below.gap (0,y,x);
   }

  /**
   * Add a constraint <i>x</i> + <i>d</i> <= <i>y</i>
   * where <i>d</i> is a `small' gap (20% of the font height).
   * @param x the lower variable
   * @param y the higher variable
   */
   public void gap1 (int x, int y)  {
      above.gap (fontHeight/5,x,y);
      below.gap (fontHeight/5,y,x);
   }

  /**
   * Add a constraint <i>x</i> + <i>d</i> <= <i>y</i>
   * where <i>d</i> is a `large' gap (50% of the font height).
   * @param x the lower variable
   * @param y the higher variable
   */
   public void gap2 (int x, int y)  {
      above.gap (fontHeight/2,x,y);
      below.gap (fontHeight/2,y,x);
   }

  /**
   * Add a constraint <i>x</i> + <i>d</i> <= <i>y</i>
   * where <i>d</i> is the width of the string.
   * @param s the string to measure
   * @param x the lower variable
   * @param y the higher variable
   */
   public void gapStringWidth (String s, int x, int y)  {
      int d = fm.stringWidth (s) + (fontHeight/2);
      above.gap (d,x,y);
      below.gap (d,y,x);      
   }

  /**
   * Add a constraint <i>x</i> + <i>d</i> <= <i>y</i>
   * where <i>d</i> is the height of the string.
   * @param s the string to measure
   * @param x the lower variable
   * @param y the higher variable
   */
   public void gapStringHeight (String s, int x, int y)  {
      above.gap (fontHeight,x,y);
      below.gap (fontHeight,y,x);      
   }

}


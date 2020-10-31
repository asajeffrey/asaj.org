/**
 * <p>A class which solves a set of constraints.</p>
 * <p>The algorithm is a simple 2-pass dynamic program.</p>
 * <p>In the first pass, we minimize all of the variables, and find
 * the maximum horizontal and maximum vertical variables.</p>
 * <p>In the second pass, we maximize all of the variables, using the
 * previously found maxima as upper bounds.</p>
 * <p>This gives two values for each variable: a minimum and a maximum.
 * We just average the two to give a result.</p>
 * <p>This algorithm sometimes produces sub-optimal results (sometimes
 * it can result in pretty extreme diagonals) but most times it produces
 * reasonable graphs.  It runs in linear time in the number of variables.</p>
 * @author Alan Jeffrey
 * @version v1.0 1998/06/02
 * @see Constraints
 */
public class Solution
{
   private int[] minimals;
   private int[] maximals;

  /**
   * The constraints solved.
   */
   public Constraints C;

  /**
   * The largest value of any horizontal variable.
   */
   public int hMax;

  /**
   * The largest value of any horizontal variable.
   */
   public int vMax;

  /**
   * Build a solution to a constraint set.
   */
   public Solution (Constraints C) {
      this.C = C;
      minimals = new int [C.varCount];
      maximals = new int [C.varCount];
      hMax = 0;
      vMax = 0;
      for (int i = 0; i < C.varCount; i++) {
	if (C.isHorizontal (i)) {
	  hMax = Math.max (hMax, minimal (i));
	} else {
	  vMax = Math.max (vMax, minimal (i));
	}
      }
   }

  /** Find the minimum value associated with a variable.
   * @param x the variable number to look up.
   * @return the value of the variable.
   * @exception ArrayIndexOutOfBoundsException if the variable number
   *   is not a valid index.
   */
   public int minimal (int x) {
      if (minimals[x] == 0) {
         minimals[x] = C.below.get (x).minimize (10,this);
      }
      return minimals[x];
   }

  /** Find the maximum value associated with a variable.
   * @param x the variable number to look up.
   * @return the value of the variable.
   * @exception ArrayIndexOutOfBoundsException if the variable number
   *   is not a valid index.
   */
   public int maximal (int x) {
      if (maximals[x] == 0) {
         if (C.isHorizontal (x)) {
            maximals[x] = C.above.get (x).maximize (hMax,this);
         } else {
            maximals[x] = C.above.get (x).maximize (vMax,this);
         }
      }
      return maximals[x];
   }

  /**
   * Find the average value associated with a variable.
   * @param x the variable number to look up.
   * @return the value of the variable.
   * @exception ArrayIndexOutOfBoundsException if the variable number
   *   is not a valid index.
   */
   public int value (int x) {
      return (this.minimal (x) + this.maximal (x)) / 2;
   }

}


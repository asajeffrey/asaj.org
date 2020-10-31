/**
 * The constaints about a single variable.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/09
 * @see Constraints
 */
public abstract class Constraint
extends Printable
{
  /**
   * Find the maximum value for this variable,
   * (at least d) using the solution set s.
   * @param d the minimum result.
   * @param s the solution set.
   */
  public abstract int maximize (int d, Solution s);

  /**
   * Find the minimum value for this variable,
   * (at most d) using the solution set s.
   * @param d the maximum result.
   * @param s the solution set.
   */
  public abstract int minimize (int d, Solution s);
}


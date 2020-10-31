/**
 * Add an extra constraint to a variable.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/11
 */
public class ConstraintCons
extends Constraint
{
   private int d;
   private int x;
   private Constraint c;

  /**
   * Create a new constraint about a variable.
   * This variable has to be at least d pixels away from variable x.
   * @param d the minimum distance.
   * @param x the other variable.
   * @param c the other constraints on this variable.
   */
   public ConstraintCons (int d, int x, Constraint c) {
      this.d = d;
      this.x = x;
      this.c = c;
   }
   public int maximize (int e, Solution s)  {       
      return c.maximize (Math.min (e, s.maximal (x) - d), s);
   }
   public int minimize (int e, Solution s)  {
      return c.minimize (Math.max (e, s.minimal (x) + d), s);
   }
   public void print (Printer p)  {
      p.printString ("[" + x + "]-" + d);
      p.printSpace ();
   }
}


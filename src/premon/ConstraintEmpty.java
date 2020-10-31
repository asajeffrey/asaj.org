/**
 * A variable with no constraints on it at all.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/11
 */
public class ConstraintEmpty
extends Constraint
{
   public int maximize (int d, Solution s)  { return d; }
   public int minimize (int d, Solution s)  { return d; }
   public void print (Printer p)  {}
}

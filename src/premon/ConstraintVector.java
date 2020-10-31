import java.util.*;
/**
 * A vector of constraints.
 */
public class ConstraintVector
extends Vector
{
  /**
   * Add a new constraint to the vector.
   */
  public void create ()  {
    addElement (new ConstraintEmpty ());
  }

  /**
   * Add a gap of size d between variables x and y.
   * @param d the minimum distance.
   * @param x the variable to update.
   * @param y the other variable.
   */
  public void gap (int d, int x, int y)  {
    setElementAt (new ConstraintCons (d,y, (Constraint) elementAt (x)),x);
  }

  /**
   * Find the constraints about variable x.
   * @param x the variable to look up.
   * @return the constraints on x.
   */
  public Constraint get (int x)  {
    return (Constraint) elementAt (x);
  }
}


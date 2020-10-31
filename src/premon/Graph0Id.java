/**
 * A graph just consisting of arcs from left to right.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/11
 */
public class Graph0Id
extends Graph0
{
  /**
   * Create a new identity graph.
   * @param C the constraint set.
   * @param i the source and target interface.
   */
  public Graph0Id (Constraints C, Interface i) {
    super (C,i,i);
  }
  public void draw (Drawer d)  {
    d.drawLines (left, right, target);
  }

}


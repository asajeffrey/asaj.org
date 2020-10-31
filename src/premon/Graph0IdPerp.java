/**
 * A graph consisting of arcs running from right to left (this
 * is used to draw the trace structure, using the fact that any
 * *-autonomous category has a trace.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/11
 */
public class Graph0IdPerp
extends Graph0
{
  /**
   * Create a new inverted identity graph.
   * @param C the ocnstraints set.
   * @param i the source and target interface.
   */
  public Graph0IdPerp (Constraints C, Interface i) {
    super (C,i,i);
  }
  public void draw (Drawer d)  {
    d.drawArrows (left, right, target);
  }
}


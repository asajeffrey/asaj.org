/**
 * A graph where the source and target interfaces are connected by
 * a shuffle.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/11
 */
public class Graph0Shuffle
extends Graph0
{
  private Shuffle f;

  /**
   * Create a new graph from a shuffle.
   * @param C the constraints set.
   * @param f the shuffle (whose source should have the same size
   *   as the source interface, and whose target should have the same
   *   size as the target interface).
   */
  public Graph0Shuffle (Constraints C, Shuffle f, Interface source, Interface target) {
    super (C, source, target);
    this.f = f;
  }
  public void draw (Drawer d)  {
    d.drawShuffle (left,right,f,source,target);
  }
}


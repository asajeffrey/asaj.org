/**
 * Compose two graphs together
 * @author Alan Jeffrey
 * @version v1.0 1998/06/11
 */

public class Graph0Comp
extends Graph0
{
  private Graph0 G;
  private Graph0 H;

  /**
   * Create a new composition of graphs.
   * @param C the constraint set
   * @param G the lh graph
   * @param H the rh graph
   */
  public Graph0Comp (Constraints C, Graph0 G, Graph0 H) {
    super (C,G.source,H.target);
    this.G = G;
    this.H = H;
    C.gap0 (left,G.left);
    C.gap0 (H.right,right);
    C.gap0 (G.top,top);
    C.gap0 (H.top,top);
    C.gap0 (bot,G.bot);
    C.gap0 (bot,H.bot);
    C.gap1 (G.right, H.left);
  }
  public void draw (Drawer d)  {
    G.draw (d);
    H.draw (d);
    d.drawLines (left, G.left, G.source);
    d.drawLines (G.right, H.left, G.target);
    d.drawLines (H.right, right, H.target);
  }
}


/**
 * Compose two graphs together
 * @author Alan Jeffrey
 * @version v1.0 1998/06/11
 */
public class Graph1Comp
extends Graph1
{
  private Graph1 G;
  private Graph1 H;

  /**
   * Create a new composition of graphs.
   * @param C the constraint set
   * @param G the lh graph
   * @param H the rh graph
   */
  public Graph1Comp (Constraints C, Graph1 G, Graph1 H) {
    super (C,G.source,H.target,G.controlIn,H.controlOut);
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
    d.drawControlLine (left, G.controlIn, G.left, G.controlIn);
    d.drawControlLine (G.right, G.controlOut, H.left, H.controlIn);
    d.drawControlLine (H.right, H.controlOut, right, H.controlOut);
   }

}


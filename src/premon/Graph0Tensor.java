/**
 * A graph built from two subgraphs, neither of which has a control line.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/11
 */
public class Graph0Tensor
extends Graph0
{
  private Graph0 G;
  private Graph0 H;

  /**
   * Create a new graph from two subgraphs.
   * @param C the constraints
   * @param G the bottom subgraph
   * @param H the top subgraph
   */
  public Graph0Tensor (Constraints C, Graph0 G, Graph0 H) {
    super (C,G.source.tensor (H.source),G.target.tensor (H.target));
    this.G = G;
    this.H = H;
    C.gap0 (bot,G.bot);
    C.gap0 (H.top,top);
    C.gap0 (left,G.left);
    C.gap0 (left,H.left);
    C.gap0 (G.right,right);
    C.gap0 (H.right,right);
    C.gap1 (G.top, H.bot);
  }
  public void draw (Drawer d)  {
    G.draw (d);
    H.draw (d);
    d.drawLines (left,G.left,G.source);
    d.drawLines (left,H.left,H.source);
    d.drawLines (G.right,right,G.target);
    d.drawLines (H.right,right,H.target);
  }

}


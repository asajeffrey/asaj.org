/**
 * A graph built from two subgaphs, where the top graph has a control
 * line and the bottom one does not.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/11
 */
public class Graph1TensorR
extends Graph1
{
   private Graph0 G;
   private Graph1 H;

  /**
   * Create a new graph from two subgraphs.
   * @param C the constraints
   * @param G the graph without a control line
   * @param H the graph with a control line
   */
  public Graph1TensorR (Constraints C, Graph0 G, Graph1 H) {
    super (C,G.source.tensor (H.source),G.target.tensor (H.target),H.controlIn,H.controlOut);
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
    d.drawControlLine (left,H.controlIn,H.left,H.controlIn);
    d.drawControlLine (H.right,H.controlOut,right,H.controlOut);
  }
}


/**
 * A graph built from two subgaphs, where the bottom graph has a control
 * line and the top one does not.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/11
 */
public class Graph1TensorL
extends Graph1
{
  private Graph1 G;
  private Graph0 H;

  /**
   * Create a new graph from two subgraphs.
   * @param C the constraints
   * @param G the graph with a control line
   * @param H the graph without a control line
   * @param control the control line variable
   */
  public Graph1TensorL (Constraints C, Graph1 G, Graph0 H, int control) {
    super (C,G.source.tensor (H.source),G.target.tensor (H.target),control,control);
    this.G = G;
    this.H = H;
    C.gap0 (bot,G.bot);
    C.gap0 (H.top,top);
    C.gap2 (left,G.left);
    C.gap2 (left,H.left);
    C.gap2 (G.right,right);
    C.gap2 (H.right,right);
    C.gap1 (G.top, H.bot);
  }
  public void draw (Drawer d)  {
    G.draw (d);
    H.draw (d);
    d.drawLines (left,G.left,G.source);
    d.drawLines (left,H.left,H.source);
    d.drawLines (G.right,right,G.target);
    d.drawLines (H.right,right,H.target);
    d.drawControlLine (left,controlIn,G.left,G.controlIn);
    d.drawControlLine (G.right,G.controlOut,right,controlOut);
  }
}


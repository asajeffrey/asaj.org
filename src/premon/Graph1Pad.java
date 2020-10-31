/**
 * Add some padding to a graph.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/11
 */
public class Graph1Pad
extends Graph1
{
  private Graph1 G;

  /**
   * Create a new graph by padding an existing graph.
   * @param C the constraint set.
   * @param G the graph to pad.
   */
  public Graph1Pad (Constraints C, Graph1 G) {
    super (C, G.source, G.target, G.controlIn, G.controlOut);
    this.C = C;
    this.G = G;
    C.gap2 (left,G.left);
    C.gap2 (G.right,right);
    C.gap1 (bot,G.bot);
    C.gap1 (G.top,top);
  }
  public void draw (Drawer d)  {
    G.draw (d);
    d.drawLines (left,G.left,G.source);
    d.drawLines (G.right,right,G.target);
    d.drawControlLine (left,G.controlIn,G.left,G.controlIn);
    d.drawControlLine (G.right,G.controlOut,right,G.controlOut);
  }
}


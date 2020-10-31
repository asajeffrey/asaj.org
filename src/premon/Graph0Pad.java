/**
 * Add some padding to a graph.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/11
 */

public class Graph0Pad
extends Graph0
{
  private Graph0 G;

  /**
   * Create a new graph by padding an existing graph.
   * @param C the constraint set.
   * @param G the graph to pad.
   */
  public Graph0Pad (Constraints C, Graph0 G) {
    super (C, G.source, G.target);
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
  }

}


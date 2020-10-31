/**
 * Create a function node (a node containing a subgraph) where
 * the subgraph has a control line.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/11
 */

public class Graph0Curry1
extends Graph0
{

  private Graph1 G;
  private Interface args;

  /**
   * Create a new function node.
   * @param C the constraint set.
   * @param G the subgraph (whose source should be source.tensor (args)).
   * @param source the source of the graph
   * @param target the target of the graph
   * @param args the interface for the bound variables of the subgraph.
   */
  public Graph0Curry1 (Constraints C, Graph1 G, Interface source, Interface target, Interface args) {
    super (C, source, target);
    this.G = G;
    this.args = args;
    C.gap1 (left,G.left);
    C.gap1 (G.right,right);
    C.gap1 (bot,G.bot);
    C.gap1 (G.top,top);
  }
  public void draw (Drawer d)  {
    G.draw (d);
    d.drawRectangle (left,bot,right,top);
    d.drawLines (left, G.left, G.source);
    d.drawControlLine (left,G.controlIn,G.left,G.controlIn);
    d.drawLines (G.right, right, G.target);
    d.drawControlLine (right,G.controlOut,G.right,G.controlOut);
    d.drawCircles (left, args);
    d.drawControlCircle (left, G.controlIn);
    d.drawCircles (right, G.target);
    d.drawControlCircle (right, G.controlIn);
  }
}


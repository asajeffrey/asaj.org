/**
 * Add a control line to a graph without a control line.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/11
 */
public class Graph1Embed
extends Graph1
{
  private Graph0 G;

  /**
   * Add a control line to a graph without a control line.
   * @param C the constraint set
   * @param G the graph without a control line
   * @param control the variable for the control line
   */
  public Graph1Embed (Constraints C, Graph0 G, int control) {
    super (C, G.source, G.target, control, control);
    this.G = G;
    C.gap0 (bot,G.bot);
    C.gap2 (G.top,control);
    C.gap0 (left,G.left);
    C.gap0 (G.right,right);   
  }
  public void draw (Drawer d)  {
    G.draw (d);
    d.drawLines (left,G.left,G.source);
    d.drawLines (G.right,right,G.target);
    d.drawControlLine (left,controlIn,right,controlOut);
  }
}


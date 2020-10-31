/**
 * A graph containing one red node.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/11
 */
public class Graph1RedNode
extends Graph1
{
  private String s;

  /**
   * Create a new graph containing one node.
   * @param C the constraints set.
   * @param s the name of the node.
   * @param source the lh interface of the graph.
   * @param target the rh interface of the graph.
   * @param controlIn the incoming control line.
   * @param controlOut the outgoing control line.
   */
  public Graph1RedNode (Constraints C, String s, Interface source, Interface target, int controlIn, int controlOut) {
    super (C, source, target, controlIn, controlOut);
    this.C = C;
    this.s = s;
    this.source = source;
    this.target = target;
    this.controlIn = controlIn;
    this.controlOut = controlOut;
    C.gapStringWidth (s,left,right);
    C.gapStringHeight (s,bot,top);
  }

  public void draw (Drawer d)  {
    d.drawRedText (left,bot,right,top,s);
  }

}


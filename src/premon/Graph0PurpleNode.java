/**
 * A graph containing one blue node.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/11
 */

public class Graph0PurpleNode
extends Graph0
{
  private String s;

  /**
   * Create a new graph containing one node.
   * @param C the constraints set.
   * @param s the name of the node.
   * @param source the lh interface of the graph.
   * @param target the rh interface of the graph.
   */
  public Graph0PurpleNode (Constraints C, String s, Interface source, Interface target) {
    super (C, source, target);
    this.s = s;
    C.gapStringWidth (s,left,right);
    C.gapStringHeight (s,bot,top);
  }
  public void draw (Drawer d)  {
    d.drawPurpleText (left,bot,right,top,s);
  }
}


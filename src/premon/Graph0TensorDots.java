/**
 * A graph built from two subgraphs one above the other, with ellipses (...)
 * between them.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/11
 */

public class Graph0TensorDots
extends Graph0Tensor
{
  private int dotV1;
  private int dotV2;
  private int dotV3;
  private int dotH;

  /**
   * Create a new graph from two subgraphs.
   * @param C the constraints
   * @param G the bottom subgraph
   * @param H the top subgraph
   */
  public Graph0TensorDots (Constraints C, Graph0 G, Graph0 H) {
    super (C, G, H);
    dotV1 = C.newVVar ();
    dotV2 = C.newVVar ();
    dotV3 = C.newVVar ();
    dotH = C.newHVar ();
    C.gap1 (G.top, dotV1);
    C.gap1 (dotV1, dotV2);
    C.gap1 (dotV2, dotV3);
    C.gap1 (dotV3, H.bot);
    C.gap1 (left, dotH);
    C.gap1 (dotH, right);
  }
  public void draw (Drawer d)  {
    super.draw (d);
    d.drawDot (dotH, dotV1);
    d.drawDot (dotH, dotV2);
    d.drawDot (dotH, dotV3);
  }
}


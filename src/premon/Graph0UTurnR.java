/**
 * A graph with an empty source interface,
 * and a target interface split into two equal-sized interfaces.
 * The graph is drawn by drawing a `uturn' which looks like an inverted C.
 */
public class Graph0UTurnR
extends Graph0
{
  private Interface botI;
  private Interface horizI;
  private Interface topI;

  /**
   * Create a U-turn graph (the three interfaces should have the same size).
   * @param C the constraint set.
   * @param botI the lower target interface.
   * @param horizI an interface of horizontal variables, which determines
   *    where the left of the U-turn is.
   * @param topI the upper target interface.
   */
  public Graph0UTurnR (Constraints C, Interface botI, Interface horizI, Interface topI) {
    super (C, botI.tensor (topI), horizI.empty ());
    this.botI = botI;
    this.horizI = horizI;
    this.topI = topI;
    C.gap1 (left,horizI.botOr(right));
    C.gap1 (horizI.topOr(left),right);
  }
  public void draw (Drawer d)  {
    d.drawUTurns (botI, horizI, topI, left);
  }
}


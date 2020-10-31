/**
 * A graph without a control line.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/11
 */
public abstract class Graph0
extends Drawable
{
  /** 
   * The variable for the lhs of the graph.
   */
  public int left;

  /**
   * The variable for the rhs of the graph.
   */
  public int right;

  /**
   * The variable for the bottom of the graph.
   */
  public int bot;

  /**
   * The variable for the top of the graph.
   */
  public int top;

  /**
   * The constraints of the graph.
   */
  public Constraints C;

  /**
   * The interface at the lhs of the graph.
   */
  public Interface source;

  /**
   * The interface at the rhs of the graph.
   */
  public Interface target;

  /**
   * Create a new graph.
   * @param C the constraint set.
   * @param source the incoming interface.
   * @param target the outgoing interface.
   */
  public Graph0 (Constraints C, Interface source, Interface target) {
    this.C = C;
    this.source = source;
    this.target = target;
    left = C.newHVar ();
    right = C.newHVar ();
    bot = C.newVVar ();
    top = C.newVVar ();
    C.gap2 (left,right);
    C.gap1 (bot,source.botOr(top));
    C.gap1 (source.topOr(bot),top);
    C.gap1 (bot,target.botOr(top));
    C.gap1 (target.topOr(bot),top);
  }

  /**
   * Pad the graph a bit.
   * @return this graph, with extra space at the left and right.
   */
  public Graph0 pad ()  { return new Graph0Pad (C,this); }
}


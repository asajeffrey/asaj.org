/**
 * A graph with a control line.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/11
 */
public abstract class Graph1
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
   * The variable for the position of the incoming control line.
   */
  public int controlIn;

  /**
   * The variable for the position of the outgoing control line.
   */
  public int controlOut;

  /**
   * Create a new graph.
   * @param C the constraint set.
   * @param source the incoming interface.
   * @param target the outgoing interface.
   * @param controlIn the incoming control line.
   * @param controlOut the outgoing control line.
   */
  public Graph1 (Constraints C, Interface source, Interface target, int controlIn, int controlOut) {
    this.C = C;
    this.source = source;
    this.target = target;
    this.controlIn = controlIn;
    this.controlOut = controlOut;
    left = C.newHVar ();
    right = C.newHVar ();
    bot = C.newVVar ();
    top = C.newVVar ();
    C.gap2 (left,right);
    C.gap1 (controlIn,top);
    C.gap2 (source.topOr(bot),controlIn);
    C.gap1 (bot,source.botOr(controlIn));
    C.gap1 (controlOut,top);
    C.gap2 (target.topOr(bot),controlOut);
    C.gap1 (bot,target.botOr(controlOut));
  }

  /**
   * Pad the graph a bit.
   * @return this graph, with extra space at the left and right.
   */
  public Graph1 pad ()  { return new Graph1Pad (C,this); }

}


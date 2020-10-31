/**
 * An interface which is a subrange of another interface.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/11
 */
public class InterfaceSubrange
extends Interface
{

  private Interface i;

  /**
   * Create a new subrange.
   * @param i the interface to subrange.
   * @param l the new low index.
   * @param h the new high index.
   */
  public InterfaceSubrange (Interface i, int l, int h) {
    this.i = i;
    vars = i.vars;
    low = l;
    high = h;
    con = i.con;
  }

}

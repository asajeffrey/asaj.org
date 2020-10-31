/**
 * The concatenation of two interfaces.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/11
 */
public class InterfaceTensor
extends Interface
{
  /**
   * Concatenate two non-empty interfaces.
   * @param i the first interface.
   * @param j the second interface.
   */
  public InterfaceTensor (Interface i, Interface j) {
    low = 0;
    high = (i.high-i.low)+(j.high-j.low);
    vars = new int[high];
    con = i.con; /* == j.con */
    for (int n = i.low; n < i.high; n++) {
      vars [n-i.low] = i.vars[n];
    }
    for (int n = j.low; n < j.high; n++) {
      vars [(i.high-i.low)+n-j.low] = j.vars[n];
    }
    con.gap2 (i.vars[i.high-1], j.vars[j.low]);
  }
}


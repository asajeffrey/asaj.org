/**
 * Create a new interface <i>v</i><sub>1</sub>...<i>v<sub>X.size</sub></i>
 * where each <i>v<sub>i</sub></i> is a new variable.
 */
public class InterfaceObj
extends Interface
{
  /**
   * Create a new interface.
   * @param X determines how many variables to create.
   * @param C the constraint set where the variables should come from.
   * @param horizontal whether the variables should be horizontal or vertical.
   */
  public InterfaceObj (Obj X, Constraints C, boolean horizontal) {
    low = 0;
    high = X.size;
    vars = new int [high];
    con = C;
    for (int i = 0; i < high; i++) {
      if (horizontal) {
	vars [i] = C.newHVar ();
      } else {
	vars [i] = C.newVVar ();
      }
      if (i > 0) {
	C.gap2 (vars[i-1],vars[i]);
      }
    }
   }

}


/**
 * An <i>interface</i> for a constraint set consists of 
 * a list of variables <i>v</i><sub>1</sub>...<i>v<sub>n</sub></i>.
 */
public abstract class Interface
extends Printable
{
  /**
   * An array containing the list of variables.
   */
  public int[] vars;

  /**
   * The starting index for the interface.
   */
  public int low;

  /** 
   * The finishing index for the interface, plus 1.
   */
  public int high;

  /** 
   * The constraint set the variables come from.
   */
  public Constraints con;

  public void print (Printer p)  {
    p.printString ("[");
    if (this.low == this.high) {
      p.printString ("]");
    } else {
      for (int i = this.low; i < (this.high-1); i++) {
	p.printString (vars[i] + ",");
      }
      p.printString (vars[this.high-1] + "]");
    }
  }

  /**
   * Concatenate this interface with another one.
   * @param i an interface <i>w</i><sub>1</sub>...<i>w<sub>m</sub></i>.
   * @return the interface 
   * <i>v</i><sub>1</sub>...<i>v<sub>n</sub></i><i>w</i><sub>1</sub>...<i>w<sub>m</sub></i>.
   */
  public Interface tensor (Interface i)  {
    if (i.low == i.high) {
      return this;
    } else if (this.low == this.high) {
      return i;
    } else {
      return new InterfaceTensor (this,i);
    }
  }

  /**
   * An empty interface.
   * @return an empty interface.
   */
  public Interface empty ()  {
    if (this.low == this.high) {
      return this;
    } else {
      return new InterfaceSubrange (this, low, low);
    }
  }

  /**
   * Split the interfce into two parts and return the first.
   * This interface must have size Y.size + Z.size, otherwise
   * a semantic error will be thrown.
   * @param Y the first object.
   * @param Z the second object.
   * @return <i>v</i><sub>1</sub>...<i>v</i><sub>Y.size</sub>.
   */
  public Interface splitL (Obj Y, Obj Z)  {
    if ((Y.size + Z.size) == (high - low)) {
      return new InterfaceSubrange (this, low, low+Y.size);
    } else {
      throw new SemanticError ();
    }
  }

  /**
   * Split the interfce into two parts and return the second.
   * This interface must have size Y.size + Z.size, otherwise
   * a semantic error will be thrown.
   * @param Y the first object.
   * @param Z the second object.
   * @return <i>v</i><sub>Y.size+1</sub>...<i>v<sub>n</sub></i>.
   */
  public Interface splitR (Obj Y, Obj Z)  {
    if ((Y.size + Z.size) == (high - low)) {
      return new InterfaceSubrange (this, low+Y.size, high);
    } else {
      throw new SemanticError ();
    }
  }

  /**
   * Return <i>v</i><sub>1</sub> if it exists, otherwise return x.
   * @param x the variable to return if <i>n</i> = 0.
   * @return <i>v</i><sub>1</sub> if it exists, otherwise x.
   */
  public int botOr (int x)  {
    if (low == high) { return x; } else { return this.vars[low]; }
  }

  /**
   * Return <i>v<sub>n</sub></i> if it exists, otherwise return x.
   * @param x the variable to return if <i>n</i> = 0.
   * @return <i>v<sub>n</sub></i> if it exists, otherwise x.
   */
  public int topOr (int x)  {
    if (low == high) { return x; } else { return this.vars[high-1]; }
  }

}


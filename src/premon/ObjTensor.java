/**
 * The tensor of two objects <i>X</i> <img src=img-otimes.gif> <i>Y</i>.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/11
 */
public class ObjTensor
extends Obj
{
   private Obj X;
   private Obj Y;

  /**
   * Create a new tensor.
   * @param X the lh object.
   * @param Y the rh object.
   */
  public ObjTensor (Obj X, Obj Y) {
    this.X = X;
    this.Y = Y;
    size = X.size + Y.size;
  }

  public void print (Printer p)  {
    p.printString ("("); p.print (X); 
    p.printOtimes (); 
    p.print (Y); p.printString (")");
  }

}


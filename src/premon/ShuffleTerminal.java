/**
 * The terminal shuffle from any object <i>X</i> to <i>I</i>.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/03
 */
public class ShuffleTerminal
extends Shuffle
{
  public ShuffleTerminal (Obj X) {
    this.source = X;
    this.target = Obj.unit;
  }
  public int shuffle (int i)  { return 0; }
}


/**
 * The initial partial shuffle from <i>I</i> to <i>X</i>,
 * which is nowhere defined.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/03
 */
public class ShuffleInitial
extends Shuffle
{
  public ShuffleInitial (Obj X) {
    this.source = Obj.unit;
    this.target = X;
  }
  public int shuffle (int i) { 
    return 0;
  }
}


/**
 * The identity shuffle.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/03
 */
public class ShuffleIdentity
extends Shuffle
{
  public ShuffleIdentity (Obj X) {
    this.source = X;
    this.target = X;
  }
  public int shuffle (int i)  { 
    if (i <= source.size) { return i; } else { return 0; } 
  }
}


/**
 * A partial shuffle which is the comediation of two partial shuffles.
 * If <i>f</i>&nbsp;:&nbsp;<i>X</i><img src=img-rightarrow.gif><i>Z</i>
 * and <i>f</i>&nbsp;:&nbsp;<i>Y</i><img src=img-rightarrow.gif><i>Z</i>
 * then [<i>f</i>,<i>g</i>]&nbsp;:&nbsp;<i>X</i><img src=img-otimes.gif><i>Y</i><img src=img-rightarrow.gif><i>Z</i>.
 * This is slightly dodgly notation since we are using an asymmetric
 * comediation (if both shuffles are defined, then <i>g</i> takes precedence).
 * @author Alan Jeffrey
 * @version v1.0 1998/06/03
 */
public class ShuffleCoMediate
extends Shuffle
{
  private Shuffle f;
  private Shuffle g;
  public ShuffleCoMediate (Shuffle f, Shuffle g) {
    this.f = f;
    this.g = g;
    this.source = f.source.tensor (g.source);
    this.target = f.target; /* == g.target */
  }
  public int shuffle (int i) {
    int n = g.shuffle (i);
    if (n == 0) {
      return f.shuffle (i);
    } else {
      return n + f.source.size;
    }
  }
}

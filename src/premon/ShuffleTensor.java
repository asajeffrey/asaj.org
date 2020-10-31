/**
 * A shuffle which is the tensor of two shuffles.
 * If <i>f</i>&nbsp;:&nbsp;<i>W</i><img src=img-rightarrow.gif><i>X</i>
 * and <i>f</i>&nbsp;:&nbsp;<i>Y</i><img src=img-rightarrow.gif><i>Z</i>
 * then <i>f</i><img src=img-otimes.gif><i>g</i>&nbsp;:&nbsp;<i>W</i><img src=img-otimes.gif><i>Y</i><img src=img-rightarrow.gif><i>X</i><img src=img-otimes.gif><i>Z</i>.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/03
 */
public class ShuffleTensor
extends Shuffle
{
  private Shuffle f;
  private Shuffle g;
  public ShuffleTensor (Shuffle f, Shuffle g) {
    this.f = f;
    this.g = g;
    this.source = f.source.tensor (g.source);
    this.target = f.target.tensor (g.target);
  }
  public int shuffle (int i)  {
    if (i <= f.target.size) {
      return f.shuffle (i);
    } else {
      return f.source.size + g.shuffle (i - f.target.size);
    }
  }
}


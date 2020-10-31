/**
 * A shuffle which is the composition of two shuffles.
 * If <i>f</i>&nbsp;:&nbsp;<i>X</i><img src=img-rightarrow.gif><i>Y</i>
 * and <i>f</i>&nbsp;:&nbsp;<i>Y</i><img src=img-rightarrow.gif><i>Z</i>
 * then <i>f</i>;<i>g</i>&nbsp;:&nbsp;<i>X</i><img src=img-rightarrow.gif><i>Z</i>.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/03
 */
public class ShuffleComp
extends Shuffle
{
  private Shuffle f;
  private Shuffle g;
  public ShuffleComp (Shuffle f, Shuffle g) {
    this.f = f;
    this.g = g;
    this.source = f.source;
    this.target = g.target;
  }
  public int shuffle (int i) { 
    return f.shuffle (g.shuffle (i));
  }
}

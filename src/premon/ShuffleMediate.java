/**
 * A shuffle which is the mediateion of two shuffles.
 * If <i>f</i>&nbsp;:&nbsp;<i>X</i><img src=img-rightarrow.gif><i>Y</i>
 * and <i>f</i>&nbsp;:&nbsp;<i>X</i><img src=img-rightarrow.gif><i>Z</i>
 * then &lt;<i>f</i>,<i>g</i>&gt;&nbsp;:&nbsp;<i>X</i><img src=img-rightarrow.gif><i>Y</i><img src=img-otimes.gif><i>Z</i>.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/03
 */
public class ShuffleMediate
extends Shuffle
{
   private Shuffle f;
   private Shuffle g;
   public ShuffleMediate (Shuffle f, Shuffle g) {
     this.f = f;
     this.g = g;
     this.source = f.source; /* == g.source */
     this.target = f.target.tensor(g.target);
   }
   public int shuffle (int i)  { 
     return Math.max (f.shuffle (i), g.shuffle (i - f.target.size)); 
   }
}


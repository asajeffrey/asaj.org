/**
 * The totally undefined partial shuffle between any two objects.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/02
 */
public class ShuffleZero
extends Shuffle
{
   public ShuffleZero (Obj X, Obj Y) {
     this.source = X;
     this.target = Y;
   }
   public int shuffle (int i)  { return 0; }
}


/**
 * A shuffle morphism (one built only from composition, tensor, 
 * symmetry, diagonal and terminal).
 * @author Alan Jeffrey
 * @version v1.0 1998/06/11
 */
public class MorShuffle
extends Mor
{
  private Shuffle f;

  /** 
   * Create a new shuffle morphism.
   * (Note f should be a total shuffle, or unpredictable errors will result!)
   * @param f the shuffle.
   */
  public MorShuffle (Shuffle f) {
    this.f = f;
    cat = PremonCat.val;
    source = f.source;
    target = f.target;
  }

  public void print (Printer p)  {
    p.printRoman ("shuffle");
    p.print (f);
  }

  public Mor comp (Mor g)  {
    if (g instanceof MorShuffle) {
      return f.comp (((MorShuffle)g).f).morphism ();
    } else {
      return super.comp (g);
    }
  }

  public Mor tensor (Mor g)  {
    if (g instanceof MorShuffle) {
      return f.tensor (((MorShuffle)g).f).morphism ();
    } else {
      return super.tensor (g);
    }
  }
   
  public Graph0 graph0 (Constraints C, Interface source)  {      
    return new Graph0Shuffle (C, f, source, new InterfaceObj (target,C,false));
  }

}


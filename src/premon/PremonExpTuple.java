/**
 * An expression (<i>M</i><sub>1</sub>,...,<i>M<sub>n</sub></i>).
 */

public class PremonExpTuple
extends PremonExp
{
  /**
   * An empty tuple.
   */
  public static final PremonExpTuple empty = 
    new PremonExpTuple (new PremonExp[0]);

  private PremonExp[] Ms;

  /**
   * Create a new tuple.
   * @param Ms the expressions <i>M</i><sub>1</sub>,...,<i>M<sub>n</sub></i>
   */
  public PremonExpTuple (PremonExp[] Ms) {
    this.Ms = Ms;
    cat = PremonCat.val;
    free = PremonCon.empty;
    if (Ms.length == 0) {
      type = PremonTypeTuple.empty;
    } else {
      PremonType[] Ts = new PremonType[Ms.length];
      for (int i=0; i<Ms.length; i++) {
	cat = cat.join (Ms[i].cat);
	free = free.comp (Ms[i].free);
	Ts[i] = Ms[i].type;
      }
      type = new PremonTypeTuple (Ts);
    }
  }

  public void print (Printer p)  {
    p.printString ("("); p.printArray (Ms, ", "); p.printString (")");
  }
  public void printB (Printer p)  {
    print (p);
  }

  /**
   * The semantics of the expression.
   * @return [[<i>M</i><sub>1</sub>]] <img src=img-otimes.gif>...<img src=img-otimes.gif> [[<i>M<sub>n</sub></i>]]
   */
  public Mor semantics ()  {
    Mor result = Mor.unit;
    for (int i=0; i<Ms.length; i++) {
      result = result.tensor (Ms[i].semantics());
    }
    return result;
  }
}


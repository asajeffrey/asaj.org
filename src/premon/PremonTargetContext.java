/**
 * Allows a context to be edited.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/03
 */
public class PremonTargetContext
extends PremonTarget
{
  private PremonJJTCon oriContext;
  private PremonCon oriContextDesugared;

  /**
   * Create a new target.
   * @param oriContext the raw context to edit.
   * @param oriContextDesugared the desugared context to edit.
   */
  public PremonTargetContext (PremonJJTCon oriContext, PremonCon oriContextDesugared) {
    this.oriContext = oriContext;
    this.oriContextDesugared = oriContextDesugared;
    text = oriContext;
    parsed = oriContext;
    desugared = oriContextDesugared;
    name = "context";
  }

  public void desugar () throws TypeError  {
    desugared = ((PremonJJTCon)parsed).desugar ();
  }

  public void parse (String s) throws ParseException {
    text = new PrintableString (s);
    parsed = new PremonJJTParser (s).parseCon ();
  }

  public void reset ()  {
    text = oriContext;
    parsed = oriContext;
    desugared = oriContextDesugared;
  }

  /**
   * The desugared context.
   * @return the desugared context.
   */
  public PremonCon context () {
    return (PremonCon)desugared;
  }

}



/**
 * Allows the constructors to be edited.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/03
 */
public class PremonTargetConstructors
extends PremonTarget
{
  private PremonJJTCon oriConstructors;
  private PremonCon oriConstructorsDesugared;

  /**
   * Create a new target.
   * @param oriConstructors the raw context to edit.
   * @param oriConstructorsDesugared the desugared context to edit.
   */
  public PremonTargetConstructors (PremonJJTCon oriConstructors, PremonCon oriConstructorsDesugared) {
    this.oriConstructors = oriConstructors;
    this.oriConstructorsDesugared = oriConstructorsDesugared;
    text = oriConstructors;
    parsed = oriConstructors;
    desugared = oriConstructorsDesugared;
    name = "constructors";
  }

  public void desugar () throws TypeError {
    desugared = ((PremonJJTCon)parsed).desugarPrimitives ();
  }

  public void parse (String s) throws ParseException  {
    text = new PrintableString (s);
    parsed = new PremonJJTParser (s).parseCon ();
  }

  public void reset ()  {
    text = oriConstructors;
    parsed = oriConstructors;
    desugared = oriConstructorsDesugared;
  }

  /**
   * The desugared constructors.
   * @return the desugared constructors.
   */
  public PremonCon constructors () {
    return (PremonCon)desugared;
  }

}


/**
 * Allows a term to be edited.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/03
 */
public class PremonTargetTerm
extends PremonTarget
{

  private PremonJJTExp oriTerm;
  private PremonExp oriTermDesugared;
  private PremonTargetContext context;
  private PremonTargetConstructors constructors;

  /**
   * Create a new editable term.
   * Requires the context and constructors, (for desugaring).
   */
  public PremonTargetTerm (PremonJJTExp oriTerm, PremonExp oriTermDesugared, PremonTargetContext context, PremonTargetConstructors constructors) {
    this.oriTerm = oriTerm;
    this.oriTermDesugared = oriTermDesugared;
    this.context = context;
    this.constructors = constructors;
    text = oriTerm;
    parsed = oriTerm;
    desugared = oriTermDesugared;
    name = "term";
  }

  public void desugar () throws TypeError  {
    desugared = ((PremonJJTExp)parsed).desugar (
      (context.context ()).comp (constructors.constructors ())
    ); 
  }

  public void parse (String s) throws ParseException {
    text = new PrintableString (s);
    parsed = new PremonJJTParser (s).parseExp ();
  }

  public void reset ()  {
    text = oriTerm;
    parsed = oriTerm;
    desugared = oriTermDesugared;
  }

  /**
   * The desugared term.
   * @return the desugared term.
   */
  public PremonExp term () {
    return (PremonExp)desugared;
  }

}


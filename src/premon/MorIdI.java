/**
 * The identity morphism <i>I</i> <img src=img-rightarrow.gif> <i>I</i>.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/11
 */
public class MorIdI
extends MorId
{

  public MorIdI () {
    super (Obj.unit);
  }

  public Mor tensor (Mor f)  {
    return f;
  }

}


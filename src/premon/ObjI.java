/**
 * The unit object <i>I</i>.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/11
 */
public class ObjI
extends Obj
{
  /**
   * Create a new unit object.
   */
  public ObjI () {
    size = 0;
  }

  public void print (Printer p)  {
    p.printItalic ("I");
  }

  public Obj tensor (Obj X)  {
    return X;
  }
  
  public Mor id ()  { return Mor.unit; }

}


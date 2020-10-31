/**
 * The type of tuples (<i>T</i><sub>1</sub>,...,<i>T<sub>n</sub></i>).
 * @author Alan Jeffrey
 * @version v1.0 1998/06/04
 */
public class PremonJJTTypeTuple
extends PremonJJTType
{
  public PremonJJTTypeTuple (int id) {
    super (id);
  }
  public void print (Printer p)  {
    p.printString ("(");
    p.printArray (children, ", ");
    p.printString (")");
  }
  public void printB (Printer p)  {
    print (p);
  }
  public PremonType desugar ()  {
    PremonType[] tuple = new PremonType[children.length];
    for (int i = 0; i < children.length; i++) {
      tuple[i] = childType(i).desugar();
    }
    return new PremonTypeTuple (tuple);
  }
}

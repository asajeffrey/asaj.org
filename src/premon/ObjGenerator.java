/**
 * A primitive object.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/11
 */
public class ObjGenerator
extends Obj
{
  /**
   * The primitive type double.
   */
  public static ObjGenerator dubble = new ObjGenerator ("double");
  
  /**
   * The primitive type int.
   */
  public static ObjGenerator integer = new ObjGenerator ("int");
  
  /**
   * The primitive type string.
   */
  public static ObjGenerator string = new ObjGenerator ("string");
  
  private String s;

  /**
   * Create a new primitive type.
   * @param s the name of the type.
   */
  public ObjGenerator (String s) {
    this.s = s;
    size = 1;
  }

  public void print (Printer p)  {
    p.printRoman (s); 
  }  

}


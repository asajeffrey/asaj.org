/**
 * A local recursive declaration <b>local rec</b> <i>x</i>; <i>D</i>
 * @author Alan Jeffrey
 * @version v1.0 1998/06/10
 */

public class PremonDecLocalRec
extends PremonDec
{
  private PremonCon bindX;
  private PremonVar x;
  private PremonDec D;

  /**
   * Create a new declaration <b>local rec</b> <i>x</i>; <i>D</i>
   * @param x the recursive variable
   * @param D the declaration defining x
   */
  public PremonDecLocalRec (PremonVar x, PremonDec D) {
    this.x = x;
    this.D = D;
    bindX = new PremonConBind (x);
    bind = D.bind.hide (bindX);
    free = D.free.hide (bindX).uniq();
    cat = D.cat;
  }

  public void print (Printer p)  {
    p.newLine ();
    p.printBold ("local"); p.printSpace (); p.printBold ("rec"); 
    p.printSpace (); p.print (x); p.printString (";"); 
    p.indent (); p.print (D); p.outdent ();
  }

  /** 
   * The semantics of the declaration.
   * @return Tr[[<i>D</i>]]
   */
  public Mor semanticsTo (PremonCon target)  {
    Obj X = x.type.semantics ();
    Obj Y = this.free.semantics ();
    Obj Z = target.semantics ();
    return 
      (this.free.comp (bindX).semanticsTo (D.free)).comp 
      (D.semanticsTo (target.comp (bindX))).trace (X,Y,Z);
  }   
}

/**
 * The composition of two declarations.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/10
 */

public class PremonDecComp
extends PremonDec
{
  private PremonCon EfreeDunbound;
  private PremonCon EfreeDbound;
  private PremonCon DboundEunbound;
  private PremonDec D;
  private PremonDec E;

  /**
   * Create a new declaration <i>D E</i>.
   * @param D the first declaration
   * @param E the second declaration
   */
  public PremonDecComp (PremonDec D, PremonDec E) {
    this.D = D;
    this.E = E;
    EfreeDunbound = E.free.hide (D.bind);
    EfreeDbound = E.free.hide (EfreeDunbound);
    DboundEunbound = D.bind.hide (E.bind);
    bind = DboundEunbound.comp (E.bind);
    free = D.free.comp (EfreeDunbound);
    cat = D.cat.join (E.cat);
  }
  
  public void print (Printer p)  {
    p.print (D); p.print (E);
  }
  
  /**
   * The semantics of the declaration.
   * @return 
   *   <img src=img-Delta.gif> ; 
   *   ([[<img src=img-Gamma.gif> <img src=img-vdash.gif> <i>D</i> : <img src=img-Delta.gif>]] <img src=img-otimes.gif> [[<img src=img-Gamma.gif>]]) ;
   *   [[<img src=img-Gamma.gif> <img src=img-vdash.gif> <i>E</i> : <img src=img-Xi.gif>]]
   *   (with some tidying up).
   */
  public Mor semanticsTo (PremonCon target)  {
    PremonCon Dtarget = target.hide (E.bind);
    PremonCon Etarget = target.hide (Dtarget);
    Mor f = D.semanticsTo (Dtarget.comp (EfreeDbound));
    Mor g = E.semanticsTo (Etarget);
    if (EfreeDbound instanceof PremonConEmpty) {
      return 
	(f.tensor (g)). comp 
	(Dtarget.comp (Etarget).semanticsTo (target));
      } else {
         return 
	   (f.tensor (EfreeDunbound.semantics ().id ())).comp 
	   (Dtarget.semantics ().id ().tensor 
	    (EfreeDbound.comp (EfreeDunbound).semanticsTo 
	     (E.free).comp (g))).comp 
	   (Dtarget.comp (Etarget).semanticsTo (target));
      }
   }
}


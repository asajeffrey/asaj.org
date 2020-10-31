/**
 * A curried morphism.
 */
public class MorCurry
extends Mor
{
  private Mor f;
  private PremonCat C;
  private Obj Y;

  /**
   * Create a new curried morphism curry(f) : V[X,C[Y,Z]]
   * @param f the morphism to curry, of type 
   *    f : X <img src=img-otimes.gif> Y <img src=img-rightarrow.gif> Z in C
   * @param C the category of the morphism.
   * @param X the lh source object.
   * @param Y the rh source object.
   */
  public MorCurry (Mor f, PremonCat C, Obj X, Obj Y) {
    this.f = f;
    this.C = C;
    this.Y = Y;
    cat = PremonCat.val;
    source = X;
    target = Y.fun (f.cat,f.target);
  }

  public void print (Printer p)  {
    p.printRoman ("curry"); p.printSubscript (this.target); 
    p.print(f);
  }

  public Mor uncurry ()  { return f; }
  
  public Graph0 graph0 (Constraints Con, Interface source)  {
    Interface target = new InterfaceObj (this.target,Con,false);
    Interface fArgs = new InterfaceObj (Y,Con,false);
    Interface fSource = source.tensor (fArgs);
    if (C instanceof PremonCatProc) {
      Graph1 F = f.graph1 (Con, fSource, Con.newVVar ());
      return new Graph0Curry1 (Con, F, source, target, fArgs);
    } else {
      Graph0 F = f.graph0 (Con, fSource);
      return new Graph0Curry0 (Con, F, source, target, fArgs);
    }
  }

}


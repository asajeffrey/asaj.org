/**
 * A traced morphism Tr(f).
 * @author Alan Jeffrey
 * @version v1.0 1998/06/11
 */
public class MorTrace
extends Mor
{
  private Mor f;
  private Obj X;
  private Obj Y;
  private Obj Z;
  
  /**
   * Create a new traced morphism
   * Tr(f) : X <img src=img-rightarrow.gif> Y.
   * Note that f should be a morphism in V, and Z should be a traceable object.
   * @param f the morphism to trace, of type f : X <img src=img-otimes.gif> Z <img src=img-rightarrow.gif> Y <img src=img-otimes.gif> Z.
   * @param X the source of the traced morphism.
   * @param Y the target of the traced morphism.
   * @param Z the traced object.
   */
  public MorTrace (Mor f, Obj X, Obj Y, Obj Z) {
    this.f = f;
    this.X = X;
    this.Y = Y;
    this.Z = Z;
    cat = f.cat;
    source = Y;
    target = Z;
  }

  public void print (Printer p)  {
    p.printRoman ("trace"); p.printSubscript (X);
    p.print(f);
  }

  public Graph0 graph0 (Constraints C, Interface source)  {
    Interface fTraceIn = new InterfaceObj (X,C,false);
    Graph0 F = f.graph0 (C,source.tensor (fTraceIn));
    Interface fTraceHIn = new InterfaceObj (X,C,true);
    Interface fTraceHOut = new InterfaceObj (X,C,true);
    Interface fTraceMid = new InterfaceObj (X,C,false);
    Interface target = F.target.splitL (Z,X);
    Interface fTraceOut = F.target.splitR (Z,X);
    return new Graph0Comp 
      (C,
       new Graph0Tensor 
       (C,
	new Graph0Id (C,source),
	new Graph0UTurnL (C,fTraceIn,fTraceHIn,fTraceMid)),
       new Graph0Comp 
       (C,
	new Graph0Tensor 
	(C, 
	 F, 
	 new Graph0IdPerp (C,fTraceMid)),
	new Graph0Tensor 
	(C,
	 new Graph0Id (C,target),
	 new Graph0UTurnR (C,fTraceOut,fTraceHOut,fTraceMid))));
   }
}


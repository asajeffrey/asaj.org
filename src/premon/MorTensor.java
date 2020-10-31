/**
 * The tensor of two morphisms <i>f</i> <img src=img-otimes.gif> <i>g</i>.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/11
 */

public class MorTensor
extends Mor
{
  private Mor f;
  private Mor g;

  /**
   * Create a new tensor <i>f</i> <img src=img-otimes.gif> <i>g</i>.
   * Note that at most one of f and g should be premonoidal morphisms.
   * @param f the lh morphism.
   * @param g the rh morphism.
   */
  public MorTensor (Mor f, Mor g) {
    this.f = f;
    this.g = g;
    cat = f.cat.join (g.cat);
    source = f.source.tensor (g.source);
    target = f.target.tensor (g.target);
  }

  public void print (Printer p)  {
    p.printString ("("); p.print (f); p.indent (); p.newLine (); 
    p.printOtimes (); p.print (g); p.printString (")");
    p.outdent ();
  }

  public Graph0 graph0 (Constraints C, Interface source)  {
    Interface sourceF = source.splitL (f.source,g.source);
    Interface sourceG = source.splitR (f.source,g.source);
    return new Graph0Tensor (C,f.graph0 (C,sourceF), g.graph0 (C,sourceG));
  }

  public Graph1 graph1 (Constraints C, Interface source, int control)  {
    Interface sourceF = source.splitL (f.source,g.source);
    Interface sourceG = source.splitR (f.source,g.source);
    if (f.cat instanceof PremonCatProc) {
      if (g.cat instanceof PremonCatProc) {
	Graph1 F = f.graph1 (C,sourceF,C.newVVar ());
	Graph1 G = g.graph1 (C,sourceG,control);
	return new Graph1Comp 
	  (
	   C,
	   new Graph1TensorL 
	   (
	    C,
	    F, 
	    new Graph0Id (C,G.source),
	    control
	    ),
	   new Graph1TensorR 
	   (
	    C, 
	    new Graph0Id (C,F.target), 
	    G
	    )
	   );
      } else {
	return new Graph1TensorL 
	  (
	   C,
	   f.graph1 (C,sourceF,C.newVVar ()), 
	   g.graph0 (C,sourceG),
	   control
	   );
      }
    } else {
      return new Graph1TensorR 
	(
	 C,
	 f.graph0 (C,sourceF), 
	 g.graph1 (C,sourceG,control)
         );
    }
  }
}


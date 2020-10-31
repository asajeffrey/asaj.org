/**
 * A tensor of two morphisms, but drawn with ellipses between them
 * (there is no categorical significance to the ellipses, they are
 * just useful in writing papers about graphs!)
 * @author Alan Jeffrey
 * @version v1.0 1998/06/11
 */

public class MorTensorDots
extends Mor
{
  private Mor f;
  private Mor g;

  public MorTensorDots (Mor f, Mor g) {
    this.f = f;
    this.g = g;
    cat = f.cat.join (g.cat);
    source = f.source.tensor (g.source);
    target = f.target.tensor (g.target);
  }

  public void print (Printer p)  {
    p.printString ("("); p.print (f); p.indent (); p.newLine (); 
    p.printString ("..."); p.print (g); p.printString (")");
    p.outdent ();
  }

  public Graph0 graph0 (Constraints C, Interface source)  {
    Interface sourceF = source.splitL (f.source,g.source);
    Interface sourceG = source.splitR (f.source,g.source);
    return new Graph0TensorDots (C,f.graph0 (C,sourceF), g.graph0 (C,sourceG));
  }

}


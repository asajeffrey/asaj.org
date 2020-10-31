/**
 * The composition of two morphisms <i>f</i>;<i>g</i>.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/11
 */

public class MorComp
extends Mor
{

  private Mor f;
  private Mor g;

  /**
   * Create a new composition.
   * @param f the lh morphism
   * @param g the rh morphism
   */
  public MorComp (Mor f, Mor g) {
    this.f = f;
    this.g = g;
    cat = f.cat.join (g.cat);
    source = f.source;
    target = g.target;
  }

  public void print (Printer p)  {
    p.printString ("("); p.print (f); p.indent (); p.newLine (); 
    p.printString ("; "); p.print (g); p.printString (")");
    p.outdent ();
  }

  public Mor uncurry ()  {
    if (this.target instanceof ObjFun) {
      ObjFun X = (ObjFun)(this.target);
      return new MorComp 
	(
	 f.tensor (X.source.id ()),
	 g.uncurry ()
	 );
    } else {
      throw new SemanticError ();
    }      
  }

  public Mor comp (Mor h)  {
    return f.simpleComp (g.comp (h));
  }

  public Mor simpleComp (Mor h)  {
    return f.simpleComp (g.simpleComp (h));
  }

  public Graph0 graph0 (Constraints C, Interface source)  {
    Graph0 F = f.graph0 (C,source);
    Graph0 G = g.graph0 (C,F.target);
    return new Graph0Comp (C,F,G);
  }

  public Graph1 graph1 (Constraints C, Interface source, int control)  {
    Graph1 F = f.graph1 (C,source,control);
    Graph1 G = g.graph1 (C,F.target,F.controlOut);
    return new Graph1Comp (C,F,G);
  }

}


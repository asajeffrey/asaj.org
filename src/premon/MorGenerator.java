/**
 * A generating morphism (drawn as a node in the graph).
 * @author Alan Jeffrey
 * @version v1.0 1998/06/11
 */
public class MorGenerator
extends Mor
{
   private String s;

  /**
   * Create a new generating morphism.
   * @param C the category of the morphism.
   * @param X the source of the morphism.
   * @param Y the target of the morphism.
   * @param s the name of the morphism.
   */
  public MorGenerator (PremonCat C, Obj X, Obj Y, String s) {
    this.s = s;
    cat = C;
    source = X;
    target = Y;
  }

  public void print (Printer p)  {
    p.printRoman (s); p.printSubscript (source); p.printSubscript (target);
  }
  
  public Graph0 graph0 (Constraints con, Interface source)  {      
    if (cat instanceof PremonCatVal) {
      return new Graph0BlueNode (con, s, source, new InterfaceObj (target,con,false));
    } else if (cat instanceof PremonCatCentral) {
      return new Graph0PurpleNode (con, s, source, new InterfaceObj (target,con,false));
    } else {
      throw new SemanticError ();
    }
  }

  public Graph1 graph1 (Constraints con, Interface source, int control)  {
    if (cat instanceof PremonCatProc) {
      return new Graph1RedNode (con, s, source, new InterfaceObj (target,con,false), control, control);
    } else {
      return new Graph1Embed (con, this.graph0 (con,source), control);
    }
  }

}


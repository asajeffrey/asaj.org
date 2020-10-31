/**
 * A morphism.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/11
 */
public abstract class Mor
extends Printable
{
  /** 
   * The category of the morphism.
   */
  public PremonCat cat;

  /**
   * The source object of the morphism.
   */
  public Obj source;

  /**
   * The target object of the morphism.
   */
  public Obj target;

  /**
   * Construct a graph (without a control line) from the morphism.
   */
  public abstract Graph0 graph0 (Constraints C, Interface source);

  /**
   * Construct a graph (with a control line) from the morphism.
   */
  public Graph1 graph1 (Constraints C, Interface source, int control)  {
    return new Graph1Embed (C, this.graph0 (C,source), control);
  }

  /**
   * The identity morphism <i>I</i> <img src=img-rightarrow.gif> <i>I</i>.
   */
  public static final Mor unit = new MorIdI ();

  /**
   * Compose this morphism with another.
   * (note that if both morphisms are shuffles, then the two shuffles
   * are composed together, which produces nicer graphs).
   * For example, symm.comp (symm) will draw the identity graph.
   * @param f the morphism to compose with.
   * @return this;f
   */
  public Mor comp (Mor f)  { 
    return simpleComp (f);
  }

  /**
   * Compose this morphism with another.
   * (note that if both morphisms are shuffles, then the two shuffles
   * are <i>not</i> composed).  For example symm.simpleComp (symm) will
   * draw an XX-shaped graph.
   * @param f the morphism to compose with.
   * @return this;f
   */
  public Mor simpleComp (Mor f)  { 
    if (f instanceof MorId) {
      return this;
    } else {
      return new MorComp (this, f);
    }
  }

  /**
   * Tensor this morphism with another.
   * @param f the morphism to tensor with
   * @return this <img src=img-otimes.gif> f
   */
  public Mor tensor (Mor f)  { 
    if (f instanceof MorIdI) {
      return this;
    } else {
      return new MorTensor (this, f);
    }
  }

  /**
   * Tensor this morphism with another
   * (but when the graph is drawn, draw ellipses between the morphisms).
   * @param f the morphism to tensor with
   * @return this <img src=img-otimes.gif> f
   */
  public Mor tensorDots (Mor f)  { 
    return new MorTensorDots (this, f);
  }

  /**
   * Curry this morphism.
   * @param C the category to curry in (should be a supercategory
   *   of this.cat(
   * @param X the source object.
   * @param Y the target object.
   * @return curry(this).
   */
  public Mor curry (PremonCat C, Obj X, Obj Y)  { 
    return new MorCurry (this,C,X,Y); 
  }

  /**
   * Trace this morphism.
   * @param X the source object of the traced morphism.
   * @param Y the target object of the traced morphism.
   * @param Z the traced object (should be traceable).
   * @return Tr(this).
   */
  public Mor trace (Obj X, Obj Y, Obj Z)  { 
    return new MorTrace (this,X,Y,Z); 
  }

  /**
   * Uncurry this morphism.
   * @return uncurry(this).
   */
  public Mor uncurry ()  {
    if (this.target instanceof ObjFun) {
      ObjFun target = (ObjFun)(this.target);
      return this.tensor 
	(target.source.id ()).comp 
	(new MorGenerator 
	 (
	  target.cat, 
	  target.source.fun (target.cat,target.target).tensor (target.source),
	  target.target, 
	  "@"
	  )
         );
    } else {
      throw new SemanticError ();
    }
  }
}


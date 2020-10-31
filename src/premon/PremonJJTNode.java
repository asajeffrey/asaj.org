/**
 * <p>A node in the sugared abstract syntax tree.</p>
 * <p>This AST representation is used by JJTree/JavaCC.
 * See <a href=http://www.sunteset.com/javacc>the JavaCC documentation</a>
 * for more details.</p>
 * @author Alan Jeffrey
 * @version v1.0 1998/06/02
 */
public abstract class PremonJJTNode
extends Printable 
implements Node {

  private static final PremonJJTNode[] noChildren = new PremonJJTNode[0];

  /**
   * The children of this node.
   */
  protected PremonJJTNode[] children = noChildren;

  /**
   * Create a node.
   * @param i identifies the class of node.
   */
  public PremonJJTNode (int i) {
  }

  /**
   * Initialize the node.
   */
  public void jjtOpen() {
  }

  /** 
   * Finalize the node.
   */
  public void jjtClose() {
  }
  
  /**
   * Set the parent node.
   * @param n the new parent.
   */
  public void jjtSetParent(Node n) { 
  }

  /**
   * Returns a null pointer (this node class does not record
   * parent information).
   * @return a null pointer.
   */
  public Node jjtGetParent() { return null; }

  /**
   * Add a node as the <code>i</code>th child.
   * @param n the node to add.
   * @param i the index to add the node as.
   */
  public void jjtAddChild(Node n, int i) {
    if (i >= children.length) {
      PremonJJTNode c[] = new PremonJJTNode[i + 1];
      System.arraycopy(children, 0, c, 0, children.length);
      children = c;
    }
    children[i] = (PremonJJTNode)n;
  }

  /**
   * Find the <code>i</code>th child.
   * @param i the index to find.
   * @return the child.
   */
  public Node jjtGetChild(int i) {
    return children[i];
  }

  /**
   * Find the number of children.
   * @return the number of children.
   */
  public int jjtGetNumChildren() {
    return children.length;
  }

  /**
   * Find the <code>i</code>th child of class <code>PremonJJTCat</code>.
   * @param i the index to look for.
   * @return the child.
   */
  public PremonJJTCat childCat (int i)  {
      return ((PremonJJTCat)children[i]);
  }

  /**
   * Find the <code>i</code>th child of class <code>PremonJJTExp</code>.
   * @param i the index to look for.
   * @return the child.
   */
  public PremonJJTExp childExp (int i)  {
      return ((PremonJJTExp)children[i]);
  }

  /**
   * Find the <code>i</code>th child of class <code>PremonJJTPat</code>.
   * @param i the index to look for.
   * @return the child.
   */
  public PremonJJTPat childPat (int i)  {
      return ((PremonJJTPat)children[i]);
  }

  /**
   * Find the <code>i</code>th child of class <code>PremonJJTType</code>.
   * @param i the index to look for.
   * @return the child.
   */
  public PremonJJTType childType (int i)  {
      return ((PremonJJTType)children[i]);
  }

  /**
   * Find the <code>i</code>th child of class <code>PremonJJTDec</code>.
   * @param i the index to look for.
   * @return the child.
   */
  public PremonJJTDec childDec (int i)  {
      return ((PremonJJTDec)children[i]);
  }

  /**
   * Find the <code>i</code>th child of class <code>PremonJJTCon</code>.
   * @param i the index to look for.
   * @return the child.
   */
  public PremonJJTCon childCon (int i)  {
      return ((PremonJJTCon)children[i]);
  }

  /**
   * Find the <code>i</code>th child of class <code>PremonJJTId</code>.
   * @param i the index to look for.
   * @return the child.
   */
  public PremonJJTId childId (int i)  {
      return ((PremonJJTId)children[i]);
  }

}


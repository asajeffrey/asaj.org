/**
 * A drawable object is one which knows how to draw itself
 * using a Drawer object.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/09
 * @see Drawer
 */
public abstract class Drawable
{

  /**
   * Draw it.
   * @param d where to draw to.
   */
  public abstract void draw (Drawer d);

}


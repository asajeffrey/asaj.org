/**
 * A class of `places that graphs can be drawn'.  This is implemented
 * either using AWT calls to a graphics context, or with a PostScript
 * back end (all this stuff predates AWT1.1 PrintGraphics contexts).
 * @author Alan Jeffrey
 * @version v1.0 1998/06/11
 */
public abstract class Grapher
{
  /**
   * Draw a line.
   * @param llX the lower left x coordinate.
   * @param llY the lower left y coordinate.
   * @param urX the upper right x coordinate.
   * @param urY the upper right y coordinate.
   */
  public abstract void drawLine (int llX, int llY, int urX, int urY);

  /**
   * Draw an arrow.
   * @param llX the lower left x coordinate.
   * @param llY the lower left y coordinate.
   * @param urX the upper right x coordinate.
   * @param urY the upper right y coordinate.
   */
  public abstract void drawArrow (int llX, int llY, int urX, int urY);

  /**
   * Draw a rectangle.
   * @param llX the lower left x coordinate.
   * @param llY the lower left y coordinate.
   * @param urX the upper right x coordinate.
   * @param urY the upper right y coordinate.
   */
  public abstract void drawRectangle (int llX, int llY, int urX, int urY);

  /**
   * Draw some text.
   * @param x the left-hand x coordinate.
   * @param y the baseline y coordinate.
   * @param text the text to draw.
   */
  public abstract void drawText (int x, int y, String text);

  /**
   * Draw a circle.
   * @param x the centre x coordinate.
   * @param y the centre y coordinate.
   */
  public abstract void drawCircle (int x, int y);

  /**
   * Draw a dot.
   * @param x the centre x coordinate.
   * @param y the centre y coordinate.
   */
  public abstract void drawDot (int x, int y);

  /**
   * Draw a uturn
   * @param bot the lower y coordinate.
   * @param left the left x coordinate.
   * @param top the upper y coordinate.
   * @param right the right x coordinate.
   */
  public abstract void drawUTurn (int bot, int left, int top, int right);

  /**
   * Set the colour to black.
   */
  public abstract void black ();

  /**
   * Set the colour to blue.
   */
  public abstract void blue ();

  /**
   * Set the colour to purple (well, magenta actually).
   */
  public abstract void purple ();

  /**
   * Set the colour to red.
   */
  public abstract void red ();

  /**
   * Close the output stream (if there is one).
   */
  public abstract void close ();

  /**
   * Set the appropriate colour for a given category
   * (blue for val, purple for central, red for proc).
   * @param C the category.
   */
  public void setColour (PremonCat C)  {
    if (C instanceof PremonCatVal) {
      this.blue ();
    } else if (C instanceof PremonCatCentral) {
      this.purple ();
    } else {
      this.red ();
    }
  }

}


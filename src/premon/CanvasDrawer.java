import java.awt.*;

/**
 * A canvas containing a drawing area for a graph.
 * @author Alan Jeffrey
 * @version v1.02 1998/06/27
 * @see Drawer
 */
public class CanvasDrawer
extends Canvas
{
   private int dx;
   private int dy;
   private Drawable d;
   private Solution s;
   private Font textFont;

  /** 
   * Create a new canvas containing a graph.
   * @param d the graph to draw.
   * @param s the solution set for the graph.
   * @param textFont the font to use.
   */
  public CanvasDrawer (Drawable d, Solution s, Font textFont) {
    this.d = d;
    this.s = s;
    this.textFont = textFont;
    setBackground (Color.white);
  }
  public void translate (int x, int y)  {
    dx = x;
    dy = y;
    repaint ();
  }
  public void paint (Graphics g)  {
    g.translate (-dx, -dy);
    g.setFont (textFont);
    d.draw (new Drawer (new GraphicsGrapher (g, s.hMax+10, s.vMax+10), s));
  }
}


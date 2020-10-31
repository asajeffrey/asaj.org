import java.awt.*;
/**
 * An implementation of the Grapher class which draws to a graphics context.
 * Note that graphers use PS coordinates (ie bottom = 0 not top = 0).
 */
public class GraphicsGrapher
extends Grapher
{
  private Graphics g;
  private int maxX;
  private int maxY;
  
  /**
   * Create a new grapher.
   * @param g the graphics context to draw to.
   * @param maxX the maximum x coordinate.
   * @param maxY the maximum y coordinate.
   */
  public GraphicsGrapher (Graphics g, int maxX, int maxY) {
    this.g = g;
    this.maxX = maxX;
    this.maxY = maxY;
  }

  public void drawLine (int llX, int llY, int urX, int urY)  {
    g.drawLine (llX, (maxY-llY), urX, (maxY-urY));
  }
  public void drawArrow (int llX, int llY, int urX, int urY)  {
    g.drawLine (llX, (maxY-llY), urX, (maxY-urY));
  }
  public void drawRectangle (int llX, int llY, int urX, int urY)  {
    g.drawRect (llX, maxY-urY, urX-llX, urY-llY);
  }
  public void drawText (int x, int y, String text)  {
    g.drawString (text, x, maxY-y);
  }
  public void drawCircle (int x, int y)  {
    g.fillOval (x-2, maxY-(y+2), 4, 4);
  }
  public void drawDot (int x, int y)  {
    g.fillOval (x-1, maxY-(y+1), 2, 2);
  }
  public void drawUTurn (int bot, int left, int top, int right)  {
    g.drawLine (right, (maxY-(bot)), left, (maxY-(((bot+top))/2)));
    g.drawLine (right, (maxY-(top)), left, (maxY-(((bot+top))/2)));
  }
  public void black ()  { g.setColor (Color.black); }
  public void blue ()  { g.setColor (Color.blue); }
  public void purple ()  { g.setColor (Color.magenta); }
  public void red ()  { g.setColor (Color.red); }
  public void close ()  {}
}


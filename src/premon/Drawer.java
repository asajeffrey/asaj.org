/**
 * A drawing area graphs can be drawn on.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/11
 */
public class Drawer
{
  private Grapher g;
  private Solution s;
  
  /**
   * Create a new drawing area.
   * @param g the graphics area to draw on.
   * @param s the solution set to look up variables in.
   */
  public Drawer (Grapher g, Solution s) {
    this.g = g;
    this.s = s;
  }

  /**
   * Draw black horizontal lines.
   * @param fromX the starting x coordinate variable
   * @param toX the finishing x coordinate variable
   * @param ys the y coordinate variables.
   */
  public void drawLines (int fromX, int toX, Interface ys)  {
    int x1 = s.value (fromX);
    int x2 = s.value (toX);
    g.black ();
    for (int i = ys.low; i < ys.high; i++) {
      int y = s.value (ys.vars[i]);
      g.drawLine (x1,y,x2,y);
    }
  }

  /**
   * Draw a red line.
   * @param fromX the starting x coordinate variable
   * @param fromY the starting y coordinate variable
   * @param toX the finishing x coordinate variable
   * @param toY the finishing y coordinate variable
   */
  public void drawControlLine (int fromX, int fromY, int toX, int toY)  {
    g.red ();
    g.drawLine (s.value (fromX), s.value (fromY), s.value (toX), s.value (toY));
  }

  /**
   * Draw horizontal arrows.
   * @param fromX the starting x coordinate variable
   * @param toX the finishing x coordinate variable
   * @param ys the y coordinate variables.
   */
  public void drawArrows (int fromX, int toX, Interface ys)  {
    int x1 = s.value (fromX);
    int x2 = s.value (toX);
    g.black ();
    for (int i = ys.low; i < ys.high; i++) {
      int y = s.value (ys.vars[i]);
      g.drawArrow (x1,y,x2,y);
    }
  }

  /**
   * Draw a blue rectangle.
   * @param llX the lower left x coordinate variable
   * @param llY the lower left y coordinate variable
   * @param urX the upper right x coordinate variable
   * @param urY the upper right y coordinate variable
   */
  public void drawRectangle (int llX, int llY, int urX, int urY)  {
    g.blue ();
    g.drawRectangle (s.value(llX),s.value(llY),s.value(urX),s.value(urY));
  }
  
  /**
   * Draw a vertical line of circles.
   * @param x the x coordinate variable for all of the circles
   * @param ys the y coordinate variables
   */
  public void drawCircles (int x, Interface ys)  {
    int x1 = s.value (x);
    g.black ();
    for (int i = ys.low; i < ys.high; i++) {
      g.drawCircle (x1,s.value (ys.vars[i]));
    }      
  }

  /**
   * Draw a black dot.
   * @param x the x coordinate variable for the dot.
   * @param x the y coordinate variable for the dot.
   */
  public void drawDot (int x, int y)  {
    g.black ();
    g.drawDot (s.value (x), s.value (y));
  }

  /**
   * Draw a red dot.
   * @param x the x coordinate variable for the dot.
   * @param x the y coordinate variable for the dot.
   */
  public void drawControlCircle (int x, int y)  {
    g.red ();
    g.drawCircle (s.value (x), s.value (y));
  }

  /**
   * Draw some C-shaped U-turns
   * @param botI the lower y coordinate variables
   * @param horizI the left-hand x coordinate variables
   * @param topI the upper y coordinate variables
   * @param right the right-hand x coordinate variable
   */
  public void drawUTurns (Interface botI, Interface horizI, Interface topI, int right)  {
    int length = botI.high - botI.low;
    int right1 = s.value (right);
    g.black ();
    if (((horizI.high - horizI.low) != length) || ((topI.high - topI.low) != length)) {
      throw new SemanticError ();
    } else {
      for (int i = 0; i < length; i++) {
	g.drawUTurn 
	  (
	   s.value (botI.vars[botI.low+i]),
	   s.value (horizI.vars[horizI.low+i]),
	   s.value (topI.vars[topI.high-(i+1)]),
	   right1
	   );
      }
    }
  }

  private void drawText (int llX, int llY, int urX, int urY, String text)  {
    int llx = s.value (llX);
    int lly = s.value (llY);
    int urx = s.value (urX);
    int ury = s.value (urY);
    int x = (int)(((llx + urx) - s.C.fm.stringWidth (text)) / 2);
    int y = (int)(((lly + ury) / 2) - s.C.fm.getMaxDescent ());
    g.drawRectangle (llx,lly,urx,ury);
    g.drawText (x,y,text);
  }

  /** 
   * Draw some blue text with a blue box round it.
   * @param llX the lower left x coordinate variable
   * @param llY the lower left y coordinate variable
   * @param urX the upper right x coordinate variable
   * @param urY the upper right y coordinate variable
   * @param text the text to draw.
   */
  public void drawBlueText (int llX, int llY, int urX, int urY, String text)  {
    g.blue ();
    this.drawText (llX, llY, urX, urY, text);
  }

  /** 
   * Draw some purple text with a purple box round it.
   * @param llX the lower left x coordinate variable
   * @param llY the lower left y coordinate variable
   * @param urX the upper right x coordinate variable
   * @param urY the upper right y coordinate variable
   * @param text the text to draw.
   */
  public void drawPurpleText (int llX, int llY, int urX, int urY, String text)  {
    g.purple ();
    this.drawText (llX, llY, urX, urY, text);
  }

  /** 
   * Draw some red text with a red box round it.
   * @param llX the lower left x coordinate variable
   * @param llY the lower left y coordinate variable
   * @param urX the upper right x coordinate variable
   * @param urY the upper right y coordinate variable
   * @param text the text to draw.
   */
  public void drawRedText (int llX, int llY, int urX, int urY, String text)  {
    g.red ();
    this.drawText (llX, llY, urX, urY, text);
  }

  /**
   * Draw a shuffle.
   * @param left the left-hand x coordinate variable
   * @param right the right-hand x coordinate variable
   * @param f the shuffle
   * @param source the left-hand y coordinate variables
   * @param target the right-hand y coordinate variables
   */
  public void drawShuffle (int left, int right, Shuffle f, Interface source, Interface target)  {
    int left1 = s.value (left);
    int right1 = s.value (right);
    g.black ();
    int[] count = new int[f.source.size + 1];
    for (int i = 1; i <= f.target.size; i++) {
      int k = f.shuffle (i);
      count[k]++;
      g.drawLine 
	(
	 left1, s.value (source.vars[source.low + (k-1)]), 
	 right1, s.value (target.vars[target.low + (i-1)])
	 );
    }
    for (int j = 1; j <= f.source.size; j++) {
      if (count[j] != 1) {
	g.drawCircle 
	  (
	   left1,
	   s.value (source.vars[source.low + (j-1)])
	   );
      }
    }
  }
}


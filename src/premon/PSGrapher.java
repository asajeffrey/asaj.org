/**
 * A PostScript back end for the application.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/10
 */
public class PSGrapher
extends Grapher
{
   private int BLACK;
   private int BLUE;
   private int PURPLE;
   private int RED;
   private int colour;
   private int llX;
   private int llY;
   private int urX;
   private int urY;
   private String font;
   private int size;
   private Printer p;

  /**
   * Create a new graph-drawing object which will send PostScript
   * instructions to a printer.
   * @param llX the lower left  x-coordinate of the bounding box
   * @param llY the lower left  y-coordinate of the bounding box
   * @param urX the upper right x-coordinate of the bounding box
   * @param urY the upper right y-coordinate of the bounding box
   * @param font the name of the font
   * @param size the size of the font
   * @param p the printer to print to
   */
  public PSGrapher (int llX, int llY, int urX, int urY, String font, int size, Printer p) {
    this.llX = llX;
    this.llY = llY;
    this.urX = urX;
    this.urY = urY;
    this.font = font;
    this.size = size;
    this.p = p;
    BLACK = 0;
    BLUE = 1;
    PURPLE = 2;
    RED = 3;
    colour = BLACK;
    p.printString (
      "%! This is some PostScript\n" +
      "%%BoundingBox: " + llX + " " + llY + " " + urX + " " + urY + "\n" +      
      "/rect {\n" +
      "   /y2 exch def /x2 exch def /y1 exch def /x1 exch def\n" +
      "   x1 y1 moveto x1 y2 lineto x2 y2 lineto x2 y1 lineto closepath stroke\n" +
      "} def\n" +
      "/line {\n" +
      "   moveto lineto stroke\n" +
      "} def\n" +
      "/arrow {\n" +
      "   4 copy line\n" +
      "   moveto 2 2 rmoveto -4 -2 rlineto 4 -2 rlineto stroke\n" +
      "} def\n" +
      "/uturn {\n" +
      "   moveto lineto lineto stroke\n" +
      "} def\n" +
      "/circle {\n" +
      "   newpath 1 0 360 arc fill\n" +
      "} def\n" +
      "/dot {\n" +
      "   newpath .5 0 360 arc fill\n" +
      "} def\n" +
      "/blue {\n" +
      "   0 0 1 setrgbcolor\n" +
      "} def\n" +
      "/red {\n" +
      "   1 0 0 setrgbcolor\n" +
      "} def\n" +
      "/purple {\n" +
      "   1 0 1 setrgbcolor\n" +
      "} def\n" +
      "/black {\n" +
      "   0 0 0 setrgbcolor\n" +
      "} def\n" +
      ".4 setlinewidth\n" +
      "/fontsize { " + size + " } def\n" +
      "/" + font + " findfont " + size + " scalefont setfont\n"
      );
  }
  public void black ()  {
    if (colour != BLACK) {
      p.printString ("black\n");
      colour = BLACK;
    }
   }
  public void blue ()  {
    if (colour != BLUE) {
      p.printString ("blue\n");
      colour = BLUE;
    }
  }
  public void purple ()  {
    if (colour != PURPLE) {
      p.printString ("purple\n");
      colour = PURPLE;
    }
  }
  public void red ()  {
    if (colour != RED) {
      p.printString ("red\n");
      colour = RED;
    }
  }
  public void drawLine (int llX, int llY, int urX, int urY)  {
    p.printString 
      (
       llX + " " + llY + " " + urX + " " + urY + " line\n"
       );
  }
  public void drawArrow (int llX, int llY, int urX, int urY)  {
    p.printString 
      (
       ((llX + urX) / 2) + " " + ((llY + urY) / 2) + " " +
       llX + " " + llY + " " + urX + " " + urY + " arrow\n"
       );
  }
  public void drawRectangle (int llX, int llY, int urX, int urY)  {
    p.printString 
      (
       llX + " " + llY + " " + urX + " " + urY + " rect\n"
       );
  }
  public void drawText (int x, int y, String text)   {
    p.printString 
      (
       x + " " + y + " moveto (" + text + ") show\n"
       );
  }
  public void drawCircle (int x, int y)  {
    p.printString 
      (
       x + " " + y + " circle\n"
       );
  }
  public void drawDot (int x, int y)  {
    p.printString 
      (
       x + " " + y + " dot\n"
       );
  }
  public void drawUTurn (int bot, int left, int top, int right)  {
    p.printString 
      (
       right + " " + bot + " " + 
       left + " " + ((top + bot) / 2) + " " + 
       right + " " + top + " uturn\n"
       );
  }
  public void close ()  {
    p.printString ("%%EndDocument\n");
    p.close ();
  }
}







import java.awt.*;
import java.applet.*;
/**
 * An applet which allows the user to edit the source code of an expression,
 * and draws the resulting flow graphs.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/03
 */
public class AppletPremonEditor
extends Applet
{
  public void init () {
    setLayout (new FlowLayout ());
    Panel p = new PremonPanel (new PremonEnvironment (this));
    setLayout (new BorderLayout ());
    add ("Center", p);
  }
}

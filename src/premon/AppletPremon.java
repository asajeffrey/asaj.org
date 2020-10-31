import java.awt.*;
import java.awt.event.*;
import java.applet.*;

/**
 * This is an applet which displays a flow graph.
 * It is described in 
 * <a href=index.html>Flow graphs and semantics of programs</a>.
 * @version 1.0 1998/06/02
 * @author Alan Jeffrey
 */
public class AppletPremon 
extends Applet
{
    private PremonEnvironment env;
    private CanvasDrawer canvas;

    /** 
     * Initialize the applet.
     */
    public void init ()  {
	env = new PremonEnvironment (this);
	canvas = new CanvasDrawer (env.d, env.s, env.textFont);
	canvas.resize (env.s.hMax + 10, env.s.vMax + 10);
	setBackground (Color.white);
	setLayout (new FlowLayout ());
	add ("Centre", canvas);
	addMouseListener (new MouseAdapter () {
	    public void mouseReleased (MouseEvent me) {
		Frame f = new PremonFrame (env);
		f.resize (500,300);
		f.show ();
	    }
	});
    }
}

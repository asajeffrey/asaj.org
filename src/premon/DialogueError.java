import java.awt.*;
import java.awt.event.*;

/**
 * A dialogue box consisting of an error message.
 * @author Alan Jeffrey
 * @version v1.02 1998/06/27
 */
public class DialogueError
extends Frame
{
  /**
   * Create a new non-modal dialogue box.
   * @param pe the exception containing the error message.
   */
  public DialogueError (Exception pe) {
    super ("Error");
    TextArea ta = new TextArea (pe.toString ());
    ta.setEditable (false);
    add ("Center", ta);
    Button b = new Button ("Close");
    b.addActionListener (new ActionListener () {
	public void actionPerformed (ActionEvent ae) {
	    dispose ();
	}
    });
    add ("South", b);
    resize (400,250);
  }
}

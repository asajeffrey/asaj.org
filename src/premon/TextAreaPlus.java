import java.awt.*;
/**
 * An extension of the <code>TextArea</code> class which adds a method 
 * to find out whether the text area has been modified since the last
 * <code>setText</code> command.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/02
 */
public class TextAreaPlus
extends TextArea
{
   private String oldContents;
   public TextAreaPlus (String s) {
      super (s);
      oldContents = s;
   }
   public void setText (String s)  {
      oldContents = s;
      super.setText (s);
   }
  /**
   * Has the text area been modified since the last <code>setText</code>?
   * @return true iff the text area has been modified.
   */
   public boolean getDirty ()  {
      return (getText() != oldContents);
   }
}


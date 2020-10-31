import java.awt.*;

/**
 * A frame containing a source code editor.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/10
 */
public class PremonFrame
extends Frame
{
   public PremonFrame (PremonEnvironment env) {
      super ("Editor");
      add ("Center", new PremonPanel (env,this));
   }
}


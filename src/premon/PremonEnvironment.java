import java.awt.*;
import java.applet.*;
import java.io.*;

/**
 * <p>A class which contains the `environment' of a Premon applet.</p>
 * <p>A premon applet is called with four arguments:</p>
 * <ul>
 * <li><p>The base context (the nodes in the graph).</p></li>
 * <li><p>The free variables (the incoming edges of the graph).</p></li>
 * <li><p>The expression (the graph).</p></li>
 * <li><p>A flag to say whether the graph should be drawn with a 
 * control line or not.</p></li>
 * </ul>
 * <p>This information is stored as a parsed syntax tree, and as a 
 * desugared and typechecked syntax tree.</p>
 * <p>In addition, the current font and font metrics are stored,
 * as well as the graph (as a constraint set) and the solution to
 * the constraints.  These allow the graph to be drawn.</p>
 * @author Alan Jeffrey
 * @version v1.0 1998/06/02
 */
public class PremonEnvironment
{
  /**
   * The sugared context.
   */
  public PremonJJTCon context; 
  /**
   * The sugared constructors.
   */
  public PremonJJTCon constructors;
  /**
   * The sugared term.
   */
  public PremonJJTExp term;
  /**
   * The desugared context.
   */
  public PremonCon contextDesugared;
  /**
   * The desugared constructors.
   */
  public PremonCon constructorsDesugared;
  /**
   * The desugared term.
   */
  public PremonExp termDesugared;
  /**
   * Should the graph contain a control line?
   */
  public boolean isRed;
  /**
   * The text font for the graph.
   */
  public Font textFont;
  /** 
   * The text font metrics for the graph.
   */
  public FontMetrics textFontMetrics;
  /**
   * The graph as a constraint set.
   */
  public Drawable d;
  /**
   * The solution to the constraints.
   */
  public Solution s;

  /**
   * Initialize the fields.
   * @param parent The applet which created the context (necessary
   * in order to get the parameters and find the fonts).
   */
  public PremonEnvironment (Applet parent) {
    textFont = new Font ("TimesRoman", Font.PLAIN, 18);
    textFontMetrics = parent.getFontMetrics (textFont);
    String base = parent.getParameter ("base");
    parent.getAppletContext ().showStatus ("Parsing base context...");
    if (base != null) {
      try {
	constructors = new PremonJJTParser (
          new StringBufferInputStream (base)
	  ).parseCon ();
      } catch (ParseException pe) {
	constructors = new PremonJJTConEmpty (0);
        new DialogueError (pe).show ();
      }
    } else {
      constructors = new PremonJJTConEmpty (0);
    }
    String free = parent.getParameter ("free");
    if (free != null) {
      parent.getAppletContext ().showStatus ("Parsing free variables...");
      try {
        context = new PremonJJTParser (
          new StringBufferInputStream (free)
        ).parseCon ();
      } catch (ParseException pe) {
	context = new PremonJJTConEmpty (0);
	new DialogueError (pe).show ();
      }
    } else {
      context = new PremonJJTConEmpty (0);
    }
    parent.getAppletContext ().showStatus ("Parsing expression...");
    try {
      term = new PremonJJTParser (
        new StringBufferInputStream (
	  parent.getParameter ("exp")
	)
      ).parseExp ();
    } catch (ParseException pe) {
      term = new PremonJJTExpTuple (0);
      new DialogueError (pe).show ();
    }
    parent.getAppletContext ().showStatus ("Removing syntax sugar...");
    contextDesugared = context.desugar ();
    constructorsDesugared = constructors.desugarPrimitives ();
    try {
      termDesugared = term.desugar (contextDesugared.comp (constructorsDesugared));
    } catch (TypeError te) {
      termDesugared = new PremonExpTuple (new PremonExp [] {});
      new DialogueError (te).show ();
    }
    parent.getAppletContext ().showStatus ("Finding semantics...");
    Mor f = termDesugared.semantics ();
    Constraints C = new Constraints (textFontMetrics);
    Interface source = new InterfaceObj (f.source,C,false);
    parent.getAppletContext ().showStatus ("Finding graph...");
    isRed = (parent.getParameter ("red") != null);
    if (f.cat instanceof PremonCatProc) {
      d = f.graph1 (C,source,C.newVVar ()).pad ();
    } else {
      if (isRed) {
	d = f.graph1 (C,source,C.newVVar ()).pad ();
      } else {
	d = f.graph0 (C,source).pad ();
      }
    }
    parent.getAppletContext ().showStatus ("Solving constraints...");
    s = C.solve ();
    parent.getAppletContext ().showStatus ("Done.");    
  }

}

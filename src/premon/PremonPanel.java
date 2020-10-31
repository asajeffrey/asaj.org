import java.awt.*;
import java.awt.event.*;
/**
 * A panel containing the source code editor.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/03
 */
public class PremonPanel
extends Panel
{
  private PremonTargetContext contextTarget;
  private PremonTargetConstructors constructorsTarget;
  private PremonTargetTerm termTarget;
  private PremonTarget currTarget;
  private String editingAction;
  private String viewingParsedAction;
  private String viewingDesugaredAction;
  private String currAction;
  private CheckboxGroup viewGroup;
  private Checkbox viewTerm;
  private Checkbox viewContext;
  private Checkbox viewConstructors;
  private CheckboxGroup actionGroup;
  private Checkbox actionEditing;
  private Checkbox actionViewingParsed;
  private Checkbox actionViewingDesugared;
  private CheckboxGroup categoryGroup;
  private Checkbox categoryVal;
  private Checkbox categoryCentral;
  private Checkbox categoryProc;
  private Button graphButton;
  private Button closeButton;
  private Button resetButton;
  private TextAreaPlus editor;
  private Printer printer;
  private Label message;
  private Panel controls;
  private Frame graphFrame;
  private final PremonFrame parent;
  private final PremonEnvironment env;

  /**
   * Create a new editor.
   * @param env the applet environment.
   * @param parent the parent frame (if there is one).
   */
  public PremonPanel (PremonEnvironment env, PremonFrame parent) {

      this.env = env;
      this.parent = parent;

      /* State consists of 3 targets... */
      contextTarget = new PremonTargetContext 
	(env.context, env.contextDesugared);
      constructorsTarget = new PremonTargetConstructors 
	(env.constructors, env.constructorsDesugared);
      termTarget = new PremonTargetTerm 
	(
         env.term, env.termDesugared,
         contextTarget, 
         constructorsTarget
	 );

      /* ...one of which we are currently acting on... */
      currTarget = termTarget;
      
      /* ...with one of three actions... */
      editingAction = "Editing";
      viewingParsedAction = "Viewing parsed";
      viewingDesugaredAction = "Viewing desugared";
      
      /* ...this is what we are currently doing. */
      currAction = editingAction;
      
      /* Are we viewing the term, context or constuctors? */
      viewGroup = new CheckboxGroup ();
      viewTerm = new Checkbox ("Term", viewGroup, true);
      viewContext = new Checkbox ("Context", viewGroup, false);
      viewConstructors = new Checkbox ("Constructors", viewGroup, false);
      
      /* What are we doing to it? */
      actionGroup = new CheckboxGroup ();
      actionEditing = new Checkbox ("Original", actionGroup, true);
      actionViewingParsed = new Checkbox ("Parsed", actionGroup, false);
      actionViewingDesugared = new Checkbox ("Desugared", actionGroup, false);
      
      /* Which category should we find the semantics in? */
      categoryGroup = new CheckboxGroup ();
      categoryVal = new Checkbox ("Value", categoryGroup, false);
      categoryCentral = new Checkbox ("Central", categoryGroup, false);
      categoryProc = new Checkbox ("Process", categoryGroup, false);
      if (env.isRed) {
	categoryVal.setForeground (Color.gray);
	categoryCentral.setForeground (Color.gray);
	categoryProc.setState (true);
      } else if ((termTarget.term ().cat) instanceof PremonCatVal) {
	categoryVal.setState (true);
      } else if ((termTarget.term ().cat) instanceof PremonCatCentral) {
	categoryVal.setForeground (Color.gray);
	categoryCentral.setState (true);
      } else {
	categoryVal.setForeground (Color.gray);
	categoryCentral.setForeground (Color.gray);
	categoryProc.setState (true);
      }
      
      /* Buttons */
      graphButton = new Button ("Draw Graph");
      closeButton = new Button ("Close");
      resetButton = new Button ("Reset");
      
      /* The edit area */
      editor = new TextAreaPlus (env.term.toString ());
      printer = new PrinterTextArea (editor);
      
      /* A status indicator */
      message = new Label (currAction + " " + currTarget.name + ".");
      
      /* The graph (initially hidden). */

      graphFrame = new Frame ("Graph");
      graphFrame.resize 
	(
	 Math.max (Math.min (600, env.s.hMax + 40), 150),
	 Math.max (Math.min (400, env.s.vMax + 75), 150)
	 );

      /* What do the buttons do? */

      viewTerm.addItemListener (new ItemListener () {
	  public void itemStateChanged (ItemEvent ae) {
              parseCurrentTarget ();
	      currTarget = termTarget;
	      maintainInvariants ();
	  }
      });

      viewContext.addItemListener (new ItemListener () {
	  public void itemStateChanged (ItemEvent ae) {
              parseCurrentTarget ();
	      currTarget = contextTarget;
	      maintainInvariants ();
	  }
      });

      viewConstructors.addItemListener (new ItemListener () {
	  public void itemStateChanged (ItemEvent ae) {
              parseCurrentTarget ();
	      currTarget = constructorsTarget;
	      maintainInvariants ();
	  }
      });

      actionEditing.addItemListener (new ItemListener () {
	  public void itemStateChanged (ItemEvent ae) {
              parseCurrentTarget ();
	      currAction = editingAction;
	      maintainInvariants ();
	  }
      });

      actionViewingParsed.addItemListener (new ItemListener () {
	  public void itemStateChanged (ItemEvent ae) {
              parseCurrentTarget ();
	      currAction = viewingParsedAction;
	      maintainInvariants ();
	  }
      });

      actionViewingDesugared.addItemListener (new ItemListener () {
	  public void itemStateChanged (ItemEvent ae) {
              parseCurrentTarget ();
	      currAction = viewingDesugaredAction;
	      maintainInvariants ();
	  }
      });

      categoryVal.addItemListener (new ItemListener () {
	  public void itemStateChanged (ItemEvent ae) {
              parseCurrentTarget ();
	      checkCategory ();
	  }
      });

      categoryCentral.addItemListener (new ItemListener () {
	  public void itemStateChanged (ItemEvent ae) {
              parseCurrentTarget ();
	      checkCategory ();
	  }
      });

      categoryProc.addItemListener (new ItemListener () {
	  public void itemStateChanged (ItemEvent ae) {
              parseCurrentTarget ();
	      checkCategory ();
	  }
      });

      graphButton.addActionListener (new ActionListener () {
	  public void actionPerformed (ActionEvent ae) {
              parseCurrentTarget ();
	      maintainInvariants ();
	      message.setText ("Finding semantics...");
	      Mor f = termTarget.term ().semantics ();
	      Constraints C = new Constraints (getTextFontMetrics ());
	      Interface source = new InterfaceObj (f.source,C,false);
	      message.setText ("Finding graph...");
	      Drawable G;
	      if (categoryProc.getState ()) {
		  G = f.graph1 (C,source,C.newVVar ()).pad ();
	      } else {
		  G = f.graph0 (C,source).pad ();
	      }
	      message.setText ("Solving constraints...");
	      Solution s = C.solve ();
	      CanvasDrawer c = new CanvasDrawer (G, s, getTextFont ());
	      c.resize (s.hMax + 10, s.vMax + 10);
	      ScrollPane sp = new ScrollPane ();
	      graphFrame.add (sp);
	      sp.add (c);
	      message.setText ("Drawing graph...");
	      graphFrame.show ();
	      message.setText ("Drawn graph.");
	  } 
      });

      resetButton.addActionListener (new ActionListener () {
	  public void actionPerformed (ActionEvent ae) {
	      contextTarget.reset ();
	      constructorsTarget.reset ();
	      termTarget.reset ();
	      maintainInvariants ();
	  }
      });

      closeButton.addActionListener (new ActionListener () {
	  public void actionPerformed (ActionEvent ae) {
	      shutdown ();
	  }
      });

      /* Build the GUI */
      
      setLayout (new BorderLayout ());
      controls = new Panel ();
      controls.setLayout (new GridLayout (3,4));

      controls.add (viewTerm);
      controls.add (actionEditing);
      controls.add (categoryVal);
      controls.add (graphButton);
      
      controls.add (viewContext);
      controls.add (actionViewingParsed);
      controls.add (categoryCentral);
      controls.add (resetButton);
      
      controls.add (viewConstructors);
      controls.add (actionViewingDesugared);
      controls.add (categoryProc);
      controls.add (closeButton);

      add ("North", message);
      add ("South", controls);
      add ("Center", editor);
      
  }

    /**
     * Create a new editor without a parent frame.
     * @param env the applet environment.
     */
    
    public PremonPanel (PremonEnvironment env) {
	this (env,null);
    }

    private FontMetrics getTextFontMetrics () {
	return env.textFontMetrics;
    }
    private Font getTextFont () {
	return env.textFont;
    }

    private void shutdown () {
	if (parent == null) {
	    graphFrame.hide ();
	} else {
	    if (graphFrame != null) { graphFrame.dispose (); }
	    parent.dispose ();
	}
    }

    private void checkCategory ()  {
	if ((termTarget.term ().cat) instanceof PremonCatVal) {
	    categoryVal.setForeground (Color.black);
	    categoryCentral.setForeground (Color.black);
	} else if ((termTarget.term ().cat) instanceof PremonCatCentral) {
	    categoryVal.setForeground (Color.gray);
	    categoryCentral.setForeground (Color.black);
	    if (categoryVal.getState ()) {
		categoryCentral.setState (true);
	    }
	} else {
	    categoryVal.setForeground (Color.gray);
	    categoryCentral.setForeground (Color.gray);
	    categoryProc.setState (true);
	}
    }
    
    private void parseCurrentTarget () {
	if ((currAction == editingAction) && (editor.getDirty ())) {
	    message.setText ("Parsing " + currTarget.name + "...");
	    try {
		currTarget.parse (editor.getText ());
	    } catch (ParseException pe) {
		new DialogueError (pe).show ();
	    }
	    try {
		currTarget.desugar ();
		termTarget.desugar ();
	    } catch (TypeError te) {
		new DialogueError (te).show ();
	    }
	}
    }

  private void maintainInvariants ()  {
    message.setText (currAction + " " + currTarget.name + ".");
    if (currAction == editingAction) {
      editor.setText (currTarget.text.toString ());
      editor.setEditable (true);
    } else if (currAction == viewingParsedAction) {
      editor.setText (currTarget.parsed.toString ());
      editor.setEditable (false);
    } else {
      editor.setText (currTarget.desugared.toString ());
      editor.setEditable (false);
    }
    checkCategory ();
  }

}


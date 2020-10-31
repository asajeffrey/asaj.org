/**
 * A class of printers.
 * You can print strings in roman, bold, italic and typewriter to a printer.
 * The printer will also keep track of indentation.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/02
 */
public abstract class Printer
{
  private int indentation;
  private boolean newline;
  private boolean printedSomething;

  /**
   * Create a new printer.
   */
  public Printer () {
    indentation = 0;
    newline = false;
    printedSomething = false;
  }

  /**
   * An abstract method to print a string with no clever formatting.
   * This is the only method a subclass needs to implement, all the
   * others have default implementations.
   * @param s the string to print.
   */
  public abstract void printRawString (String s);

  /**
   * Print a string.
   * @param s the string to print.
   */
  public void printString (String s)  { 
    if (this.newline && this.printedSomething) {
      this.printNewLine ();  
    }
    this.printedSomething = true;
    this.newline = false;
    this.printRawString (s);
  }

  /** 
   * Print a new line.
   */
  public void printNewLine ()  {
    this.printRawString ("\n");
    for (int i = 0; i < indentation; i++) { this.printRawString ("   "); }
  }

  /**
   * Print a string in roman.
   * @param s the string to print.
   */
  public void printRoman (String s)  { this.printString (s); }
  
  /**
   * Print a string in roman.
   * @param s the string to print.
   */
  public void printBold (String s)  { this.printString (s); }

  /**
   * Print a string in italic.
   * @param s the string to print.
   */
  public void printItalic (String s)  { this.printString (s); }

  /**
   * Print a string in typewriter.
   * @param s the string to print.
   */
  public void printTypewriter (String s)  { this.printString (s); }

  /**
   * Print a space.
   */
  public void printSpace ()  { this.printString (" "); }
  
  /**
   * Print a left brace.
   */
  public void printLBrace () { this.printString (" {"); }

  /**
   * Print a right arrow.
   */
  public void printArrow ()  { this.printString ("->"); }

  /**
   * Print a right brace.
   */
  public void printRBrace ()  { this.printString ("}"); }

  /**
   * Print an otimes symbol.
   */
  public void printOtimes ()  { this.printString ("#"); }

  /**
   * Print a subscripted term.
   * @param p the term to be printed.
   */
  public void printSubscript (Printable p)  { 
    this.printString ("_"); this.printB (p); 
  }

  /**
   * Print an array of terms.
   * @param Ps the terms to be printed.
   * @param separator the string to print between terms.
   */
  public void printArray ( Printable[] Ps, String separator )  {
    if (Ps.length != 0) {
      Ps[0].print (this);
      for (int i=1; i<Ps.length; i++) {
	this.printString (separator);
	Ps[i].print (this);
      }
    }
  }

  /**
   * Print a printable term.
   * @param p the term to be printed.
   */
  public void print (Printable p)  {
    p.print (this);
  }

  /**
   * Print a term as an `atom' (bracketed by default).
   * @param p the term to be printed.
   */
   public void printA (Printable p)  {
      p.printA (this);
   }

  /**
   * Print a bracketed term.
   * @param p the term to be printed.
   */
   public void printB (Printable p)  {
      p.printB (this);
   }

  /**
   * Print a new line.
   */
   public void newLine ()  {
      this.newline = true;
   }

  /**
   * Indent by one level.
   */
   public void indent ()  {
      ++this.indentation;
   }

  /** 
   * Undo one level of indentation.
   */
   public void outdent ()  {
      --this.indentation;
   }

  /**
   * Close the output stream down.
   */
   public void close ()  {}

}


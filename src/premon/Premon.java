import java.awt.*;
import java.io.*;
/**
 * An application which reads a collection of program files, and
 * writes the graphs as PostScript.
 * @author Alan Jeffrey
 * @version v1.0 1998/06/02
 */

public class Premon
{
   public static void main (String[] argv) throws Exception {
      Font textFont = new Font ("TimesRoman", Font.PLAIN, 10);
      Frame godAwfulHackJob = new Frame ();
      FontMetrics textFontMetrics = godAwfulHackJob.getFontMetrics (textFont);
      int i = 0;
      boolean red = false;
      if (argv[i].equals ("-red")) {
         red = true;
         i = i+1;
      }
      while (i < argv.length) {
         String prefix = argv[i].substring (0, argv[i].indexOf ('.'));
         PremonCon Gamma = new PremonConEmpty ();
         try {
            FileInputStream fs = new FileInputStream ("base-" + prefix + ".pre");            
            Gamma = Gamma.comp (
               new PremonJJTParser (fs).parseCon ().desugarPrimitives ()
            );
            fs.close ();
         } catch (IOException ioE) {
         }
         try {
            FileInputStream fs = new FileInputStream ("free-" + prefix + ".pre");            
            Gamma = Gamma.comp (
               new PremonJJTParser (fs).parseCon ().desugar ()
            );
            fs.close ();
         } catch (IOException ioE) {
         }
         System.out.print ("Reading file " + argv[i] + "...\n");
         FileInputStream fs = new FileInputStream (argv[i]);
         PremonExp M = new PremonJJTParser (fs).parseExp ().desugar (Gamma);
         fs.close ();
         System.out.print ("Calculating semantics...\n");
         Mor f = M.semantics ();
         Constraints C = new Constraints (textFontMetrics);
         Interface source = new InterfaceObj (f.source,C,false);
         System.out.print ("Calculating graph...\n");
         Drawable G;
         if (f.cat instanceof PremonCatProc) {
            G = f.graph1 (C,source,C.newVVar ()).pad ();
         } else {
            if (red) {
               G = f.graph1 (C,source,C.newVVar ()).pad ();
            } else {
               G = f.graph0 (C,source).pad ();
            }
         }
         System.out.print ("Solving " + C.varCount + " constraints...\n");
         Solution s = C.solve ();
         Printer sem = new PrinterStream (new FileOutputStream (prefix + "-sem.txt"));
         System.out.print ("Printing semantics " + prefix + "-sem.txt...\n");
         f.print (sem);
         sem.close ();
         Grapher EPSfile = new PSGrapher (10,10,s.hMax,s.vMax,"Times-Roman",10,new PrinterStream (new FileOutputStream (prefix + ".eps")));
         System.out.print ("Printing graph " + prefix + ".eps...\n");
         G.draw (new Drawer (EPSfile, s));
         EPSfile.close ();
         System.out.print ("Done.\n");
         i = i+1;
      }
      System.exit (0);
   }
}

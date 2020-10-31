/**
 * A recursive declaration <b>rec</b>&nbsp;<i>x</i><sub>1</sub>,...,<i>x<sub>n</sub></i>;&nbsp;<i>D</i>,
 * sugar for <b>rec</b>&nbsp;<i>x</i><sub>1</sub>;...<b>rec</b>&nbsp;<i>x<sub>n</sub></i>;&nbsp;<i>D</i>, where
 * <b>rec</b>&nbsp;<i>x</i>;&nbsp;<i>D</i>
 * is sugar for <b>local&nbsp;rec</b>&nbsp;<i>y</i>;&nbsp;<b>let</b>&nbsp;<i>x</i>=<i>y</i>;&nbsp;<i>D</i>&nbsp;<b>let</b>&nbsp;<i>y</i>=<i>x</i>;
 * @author Alan Jeffrey
 * @version v1.0 1998/06/10
 */

public class PremonJJTDecRecMany
extends PremonJJTDec
{
   private PremonCon bind;
   private PremonCon rec;
   public PremonJJTDecRecMany (int id) {
     super (id);
   }
   public void print (Printer p)  {
     p.newLine ();
     p.printBold ("rec");
     p.printSpace ();
     p.print (childId (0));
     int i = 1;
     while (i < children.length-1) {
       p.printString (", ");
       p.print (childId (i++));
     }
     p.printString (";");
     p.indent (); 
     p.print (childDec (children.length-1)); 
     p.outdent ();
   }
   public PremonCon getBind () throws TypeError  {
     if (bind == null) {
       rec = new PremonConEmpty ();
       bind = childDec (children.length-1).getBind ();
       int i = 0;
       while (i < children.length-1) {
	 rec = rec.comp (new PremonConBind (bind.lookup (childId (i++).name)));
       }      
     }
     return bind;
   }
   public PremonDec desugar (PremonCon Gamma) throws TypeError  {
     getBind ();
     PremonDec result = childDec (children.length-1).desugar (Gamma.comp (rec));
     if (result.cat instanceof PremonCatVal) {
     } else {
       throw new TypeError 
	 (
	  "Type error in rec declaration:\n\n" +
	  childDec (children.length-1).toString () +
	  "\n\nis not a declaration of values."
	  );
     }
     for (int i = children.length-2; i>=0; i--) {
       PremonVar x = rec.lookup (childId (i).name);
       PremonVar y = x.alphaConvert ();
       if (!(x.type.traceable ())) {
	 throw new TypeError 
	   (
	    "Type error in rec " + x.name + ":\n\n" +
	    x.type.toString () +
	    "\n\nis not a traceable type."
            );
       }         
       result = new PremonDecLocalRec 
	 (
	  y,
	  new PremonDecComp 
	  (
	   new PremonDecComp 
	   (
	    new PremonDecBind 
	    (
	     new PremonPatBind (x), 
	     new PremonExpVar (y)
	     ),
	    result
	    ),
	   new PremonDecBind 
	   (
	    new PremonPatBind (y), 
	    new PremonExpVar (x)
	    )
	   )  
	  );
     }      
     return result;
   }
}


%.java: %.jj
	javacc $<

%.jj: %.jjt
	jjtree $<

%.class: %.pre prefiles
	javac -depend $*.java

%.class: %.java
	javac -depend $<

%.eps: %.pre Premon.class
	java Premon $<

fig-%.eps: %.fig
	fig2dev -L ps -p portrait $< $@

%-slides.tex: %.html premon.sty
	rm -f $@
	echo "\documentclass[magstep5,landscape]{ajslide}\usepackage[slides]{premon}\start{document}" > $@
	echo "\htmlinput{"$<"}\end{document}" >> $@

%-2col.tex: %.html premon.sty
	rm -f $@
	echo "\documentclass[twocolumn,a4paper]{article}\usepackage{premon}\start{document}" > $@
	echo "\htmlinput{"$<"}\end{document}" >> $@

%.tex: %.html premon.sty
	rm -f $@
	echo "\documentclass[12pt,a4paper]{article}\usepackage{premon}\start{document}" > $@
	echo "\htmlinput{"$<"}\end{document}" >> $@

img-blue-%.tex:
	rm -f $@
	echo "\documentclass[12pt]{article}\usepackage{premon}\\""begin{document}" > $@
	echo "\pagestyle{empty}\\""textcolor{blue}{\img{" \\$* "}}\end{document}" >> $@

img-magenta-%.tex:
	rm -f $@
	echo "\documentclass[12pt]{article}\usepackage{premon}\\""begin{document}" > $@
	echo "\pagestyle{empty}\\""textcolor{magenta}{\img{" \\$* "}}\end{document}" >> $@

img-red-%.tex:
	rm -f $@
	echo "\documentclass[12pt]{article}\usepackage{premon}\\""begin{document}" > $@
	echo "\pagestyle{empty}\\""textcolor{red}{\img{" \\$* "}}\end{document}" >> $@

img-%.tex:
	rm -f $@
	echo "\documentclass[12pt]{article}\usepackage{premon}\\""begin{document}" > $@
	echo "\pagestyle{empty}\img{" \\$* "}\end{document}" >> $@

%.dvi: %.tex
	latex $<

%-slides.ps: %-slides.dvi
	dvips -x2488 -tlandscape -o $@ $<

%.ps: %.dvi
	dvips -o $@ $<

%.eps: %.dvi
	dvips -E -o $@ $<

uncropped-%.gif: %.eps
	convert $< $@

%.gif: uncropped-%.gif
	rm -f $@
	giftopnm $< | pnmcrop -left | pnmcrop -right | pnmcrop -top | ppmtogif > $@

%.gz: %
	gzip -f $<

r90-%.gif: %.gif
	rm -f $@
	giftopnm $< | pnmflip -r90 | ppmtogif > $@

r270-%.gif: %.gif
	rm -f $@
	giftopnm $< | pnmflip -r270 | ppmtogif > $@

talk.dvi: talk.tex tracepmc.sty 
	latex talk
	java Premon `ls talk-*.pre`
	java Premon -red `ls talk-red-*.pre`
	latex talk

# Grumble mutter, JDK 1.0 under Linux seems to have a limit of ~250 input files.
# So I have to chop processing the graphs into chunks.  Sigh.

paper.dvi: paper.tex premon.sty paper-toc.html paper-intro.html paper-value.html paper-central.html paper-process.html paper-trace.html paper-fun.html paper-opsem.html paper-future.html fig-coprod.eps fig-mediate.eps fig-inl.eps fig-inr.eps fig-if.eps fig-sample.eps fig-fork.eps fig-commOne.eps fig-commTwo.eps
	latex paper
	java Premon `ls paper-graph-1*.pre`
	java Premon `ls paper-graph-2*.pre`
	java Premon `ls paper-graph-3*.pre`
	java Premon `ls paper-graph-4*.pre`
	java Premon `ls paper-graph-5*.pre`
	java Premon `ls paper-graph-6*.pre`
	java Premon `ls paper-graph-7*.pre`
	java Premon `ls paper-graph-8*.pre`
	java Premon `ls paper-graph-9*.pre`
	java Premon -red `ls red-paper-graph-*.pre`
	latex paper

appendices.dvi: appendices.tex paper-complete-cfp.html paper-complete-smc.html paper-complete-pmc.html paper-complete-ptm.html paper-bib.html proof-bisim-cong.html proof-permute-normal.html proof-complete-ptm.html proof-q-is-state-d.html proof-complete-shuffle.html proof-trace-normal.html proof-full-subcat.html proof-tracedblsym.html proof-node-cancel.html proof-traceshuffle.html proof-paramdinat.html proof-tracetensor.html proof-permute-cancel.html proof-traceunit.html
	latex appendices
	java Premon `ls appendices-graph-1*.pre`
	java Premon `ls appendices-graph-2*.pre`
	java Premon `ls appendices-graph-3*.pre`
	java Premon `ls appendices-graph-4*.pre`
	java Premon `ls appendices-graph-5*.pre`
	java Premon `ls appendices-graph-6*.pre`
	java Premon `ls appendices-graph-7*.pre`
	java Premon `ls appendices-graph-8*.pre`
	java Premon `ls appendices-graph-9*.pre`
	java Premon -red `ls red-appendices-graph-*.pre`
	latex appendices

talk-slides.dvi: talk-slides.tex premon.sty talk-toc.html talk-title.html talk-intro1.html talk-intro2.html talk-intro3.html talk-intro4.html talk-intro5.html talk-intro6.html talk-bisim1.html
	latex talk-slides
	java Premon `ls talk-slides-graph-*.pre`
	java Premon -red `ls red-talk-slides-graph-*.pre`
	latex talk-slides

prefiles: Constraints.pre Obj.pre Premon.pre Printer.pre Graph0.pre Graph1.pre PremonCat.pre PremonPat.pre Shuffle.pre Grapher.pre PremonMaybeVar.pre PremonCon.pre Interface.pre PremonDec.pre PremonType.pre Mor.pre PremonExp.pre PremonVar.pre Drawer.pre AppletPremon.pre PremonJJTNode.pre PremonJJTId.pre PremonJJTCat.pre PremonJJTCon.pre PremonJJTType.pre PremonJJTPat.pre PremonJJTDec.pre PremonJJTExp.pre PremonFrame.pre AppletPremonEditor.pre
	pre2java $^

images: img-hookrightarrow.gif img-simeq.gif img-blue-Rightarrow.gif img-blue-times.gif img-magenta-Rightarrow.gif img-magenta-otimes.gif img-red-Rightarrow.gif img-red-oslash.gif img-vdash.gif img-neq.gif img-cap.gif img-nin.gif img-mapsto.gif img-otimes.gif img-times.gif img-rightarrow.gif img-bot.gif img-blue-otimes.gif img-Box.gif img-cdots.gif r270-img-hookrightarrow.gif r90-img-red-oslash.gif img-downarrow.gif img-rrightarrow.gif r270-img-fullrightarrow.gif r90-img-eq.gif img-Sigma.gif img-Gamma.gif r90-img-cdots.gif img-red-eq.gif img-red-alpha.gif img-red-beta.gif img-magenta-alpha.gif img-magenta-beta.gif img-magenta-eq.gif img-blue-eq.gif fig-coprod.gif fig-mediate.gif fig-if.gif fig-inl.gif fig-inr.gif fig-sample.gif fig-fork.gif fig-commOne.gif fig-commTwo.gif img-lambda.gif img-magenta-neq.gif img-sim.gif img-cup.gif img-in.gif img-blue-Sigma.gif img-magenta-Sigma.gif img-red-Sigma.gif img-nsimeq.gif img-nsim.gif img-vee.gif img-eta.gif img-mu.gif img-leftarrow.gif img-lceil.gif img-rceil.gif img-nu.gif img-Delta.gif img-Xi.gif img-primesup.gif
	cp r90-img-eq.gif img-downeq.gif 
	cp r90-img-cdots.gif img-vdots.gif 
	cp r90-img-red-oslash.gif img-red-obslash.gif 
	cp r270-img-hookrightarrow.gif img-hookdownarrow.gif
	cp r270-img-fullrightarrow.gif img-fulldownarrow.gif 
	cp fig-coprod.gif img-coprodeps.gif
	cp fig-mediate.gif img-mediateeps.gif
	cp fig-if.gif img-ifeps.gif
	cp fig-inl.gif img-inleps.gif
	cp fig-inr.gif img-inreps.gif
	cp fig-sample.gif img-sampleeps.gif
	cp fig-fork.gif img-forkeps.gif
	cp fig-commOne.gif img-commOneeps.gif
	cp fig-commTwo.gif img-commTwoeps.gif

applet: PremonJJTParser.java
	javac *.java

application: PremonJJTParser.java Premon.java
	javac -depend Premon.java

javadoc: 
	cp index.html index-ori.html
	javadoc -author -sourceversion -index -tree *.java
	mv index-ori.html index.html

sourcefiles:
	rm -f sources.html
	echo "<!DOCTYPE HTML PUBLIC "-//IETF//DTD HTML//EN">" > sources.html
	echo "<html>" >> sources.html
	echo "  <head>" >> sources.html
	echo "    <title>Premon applet</title>" >> sources.html
	echo "  </head>" >> sources.html
	echo "  <body bgcolor=ffffff>" >> sources.html
	echo "    <h1>Source Code</h1>" >> sources.html
	ls *.java *.jjt | sort | sed -e "s/\(.*\)/    <a href=\1>\1<\/a><br>/" >> sources.html
	echo "  </body>" >> sources.html  
	echo "</html>" >> sources.html  

archives: clean
	rm -f premon.tgz premon.zip ../premon.tgz ../premon.zip
	cd .. ;	tar -cvzf /tmp/premon.tgz premon
	cd .. ;	zip -r /tmp/premon premon
	mv /tmp/premon.tgz /tmp/premon.zip .

docs: paper.ps.gz appendices.ps.gz talk-slides.ps.gz javadoc sourcefiles

all: applet images docs archives clean

clean:
	rm -f *~ *.eps *-graph-* *-sem.txt *.dvi *.aux *.log *.jj *.pre *.tmp

veryclean: clean
	rm -f *.class *.ps img-* *.tgz *.zip
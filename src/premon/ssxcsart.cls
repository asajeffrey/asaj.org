%%% ====================================================================
%%%  @LaTeX-style-file{
%%%     author          = "Alan Jeffrey",
%%%     version         = "0.32",
%%%     date            = "17 March 1994",
%%%     time            = "17:39:27 GMT",
%%%     filename        = "ssxcsart.cls",
%%%     address         = "School of Cognitive and Computing Sciences
%%%                        University of Sussex
%%%                        Brighton BN1 9QH
%%%                        UK",
%%%     FAX             = "+44 273 678188",
%%%     email           = "alanje@cogs.sussex.ac.uk",
%%%     codetable       = "ISO/ASCII",
%%%     keywords        = "document style",
%%%     supported       = "yes",
%%%     abstract        = "This is a class for University of Sussex CS
%%%                        articles, published as technical reports.",
%%%     docstring       = "This is a class for University of Sussex CS
%%%                        articles, published as technical reports.
%%%                        It understands the following document style
%%%                        options:
%%%
%%%                        crc      (camera ready copy, suitable for
%%%                                  printing at magstep 2)
%%%                        lics     (use the LICS page dimensions)
%%%                        lncs     (use Springer's LNCS page dimensions)
%%%                        oneside  (this is a one-sided document)
%%%                        cover    (include a cover page)
%%%                        draft    (indicate overfull hboxes with rules)
%%%                        ssxtimes (uses Times Roman and Helvetica
%%%                                  rather than Computer Modern)
%%%                        ssxlucid (uses Lucida Bright fonts
%%%                                  rather than Computer Modern)
%%%                        report   (acts like report.sty rather than
%%%                                  article.sty)
%%%
%%%                        In addition, the following document style
%%%                        options have no effect: 10pt, 11pt, 12pt,
%%%                        twoside, twocolumn.
%%%
%%%                        The interface is similar to article, except
%%%                        that maketitle now looks like:
%%%
%%%                        \title{Fishing for fun and profit}
%%%                        \author{Fred Bloggs \and Jane Doe}
%%%                        \date{March 1992} % optional
%%%                        \reportnumber{0/92} % optional unless producing crc
%%%                        \indicia{Copyright \copyright\ 1992 us.} % optional
%%%
%%%                        \title and \author both take optional
%%%                        arguments for shortened versions, if the
%%%                        title or author list is too long for the
%%%                        headings, e.g:
%%%
%%%                        \title[Fly fishing\ldots]
%%%                           {Fly fishing and its applications to
%%%                           pseudo-orthocomplements in Gelfand quantales}
%%%                        \author[Fred Bloggs et al.]
%%%                           {Fred Bloggs \and Jane Doe \and
%%%                           \and Joe Doe \and His Aunty Mable \and
%%%                           Her Dog Fifi}
%%%
%%%                        \thanks is not provided---use the \indicia
%%%                        command instead.
%%%
%%%                        Other than that, standard LaTeX articles
%%%                        should go through fine.
%%%
%%%                        The page design is heavily influenced by
%%%                        the way journals lay out papers (to the
%%%                        point that Peter Dybjer commented `Ah,
%%%                        rather than getting your papers published,
%%%                        you're LaTeXing them so they look like they
%%%                        have been.') specifically TCS and JACM.
%%%                        Hopefully the end result is significantly
%%%                        more sober than the very American
%%%                        article.sty layout. Oh well, I like it, and
%%%                        if you don't, then write your own.  :-P",
%%%     package         = "stands alone",
%%%     dependencies    = "pslucida.sty pstimesm.sty pshelv.sty pscour.sty",
%%%  }
%%%  ====================================================================
%
% 3 Mar 1992, v0.00: Created the file from yellow.sty.
%
% 4 Mar 1992, v0.01: Finished the first version.
%
% 5 Mar 1992, v0.02: Renamed the style from susxcsar to ssxcsart, made the
%    document style options orthogonal, and defined \and properly.
%
% 6 Mar 1992, v0.03: Fixed a bug with \caption, and set captions in
%    \footnotesize.
%
% 9 Mar 1992, v0.04: Front cover now runs in Helvetica :-P and uses the
%    epsf macros to load the crest (which I encapsulated).
%
% 12 Mar 1992, v0.05: Added the message `To be printed with dvips \jobname.'
%    if a cover is being printed.
%
% 17 Mar 1992, v0.06: Added the \coverpage command, so that Berry Harper
%    can generate covers without generating a document.
%
% 5 Jun 1992, v0.07: Added the various font commands like \sectionfont,
%    \subsectionfont, etc.
%
% 6 Jun 1992, v0.08: Removed some leftover \sc.
%
% 7 Jun 1992, v0.09: Added a \raggedbottom for one-sided documents.
%
% 18 Jun 1992, v0.10: Added the new headers, and added itemize* and
%    enumerate*.
%
% 23 Jun 1992, v0.11: Added the ssxtimes document style option,
%    and added \floatfont, which is \footnotesize by default.
%
% 24 Jun 1992, v0.12: Debugged the ssxtimes option and added the
%    \abstractfont and \abstractnamefont.
%
% 25 Jun 1992, v0.13: Introduced a bug by adding \floatfont *after*
%    \@float{table} rather than before it, which caused the optional
%    arguments to \table not to be picked up.  Oops.
%
% 4 Aug 1992, v0.14: Added an extra \bigskip between `Computer
%    Science' and the crest on the cover page.  Added the report
%    option.
%
% 5 Aug 1992, v0.15: Corrected some typos in the header (thanks to
%    Edmund Robinson).
%
% 16 Dec 1992, v0.16: Added the ssxlucid option.
%
% 18 Jan 1993, v0.17: Fixed a bug with \today.
%
% 3 Feb 1993, v0.18: Changed the leading depending on which type style
%    is in use.  Added more leading for Lucida Bright (which needs
%    generous leading!)  To do this, I added all the \@PTSIZEbaseline
%    dimensions.
%
% 10 Feb 1993, v0.19: Changed \descriptionfont in the Times and Lucida
%    variants from \sf to \bfsf.
%
% 14 Apr 1993, v0.20: \chapter* and \part* now produce toc entries
%    with the report option.
%
% 15 Apr 1993, v0.21: \section, \subsection and \subsubsection are now
%    set ragged right.  Lucida is now run at 9pt rather than 10pt.
%    Chapters and parts in reports now have pagestyle empty rather
%    than plain.
%
% 23 Aug 1993, v0.22: Added the ISSN number.
%
% 8 Sep 1993, v0.23: Changed the name of the crest to ssxcrest.eps.
%
% 17 Sep 1993, v0.24: \Huge was selecting 15pt by mistake rather than
%    25pt!
%
% 5 Dec 1993, v0.25: Corrected bugs with \def@normalsize etc. which
%    included a space in the output...
%
% 9 Dec 1993, v0.26: Added the lics option.
%
% 21 Dec 1993, v0.27: Updated to LaTeX2e.
%
% 18 Jan 1994, v0.28: Fixed a typo: \lics@true replaced by \@licstrue.
%
% 24 Jan 1994, v0.29: Removed \normalshape.
%
% 25 Jan 1994, v0.30: Made the default theorem font \emfont rather
%    than \sl, so that changes to \emfont will also change theorems.
%
% 22 Feb 1994, v0.31: Added the definitions of \bf, \normalsize, etc.
%
% 17 Mar 1994, v0.32: Fixed a bug with \tiny.
%
% 22 Jun 1994, v0.33: Updated to 1994/06/01 release of LaTeX.

% Copyright 1992, 1993, 1994 Alan Jeffrey.

\NeedsTeXFormat{LaTeX2e}
\ProvidesClass{ssxcsart}[1994/06/22 Sussex CS Article Class v0.33]

% To kick off with, some other .sty files may need \@ptsize.

\def\@ptsize{0}

% Set up the document style options:

\newif\if@crc \@crcfalse
\newif\if@cover \@coverfalse
\newif\if@lics \@licsfalse
\newif\if@lncs \@lncsfalse
\newif\if@report \@reportfalse

\def\font@style{\cmr@style}

\@twosidetrue\@mparswitchtrue

\DeclareOption{oneside}{\@twosidefalse}
\DeclareOption{twoside}{\@twosidetrue}
\DeclareOption{crc}{\@crctrue}
\DeclareOption{lics}{\@licstrue}
\DeclareOption{lncs}{\@lncstrue}
\DeclareOption{cover}{\@covertrue}
\DeclareOption{draft}{\overfullrule 5pt}
\DeclareOption{ssxtimes}{\def\font@style{\times@style}}
\DeclareOption{ssxlucid}{\def\font@style{\lucida@style}}
\DeclareOption{report}{\@reporttrue}

\ProcessOptions

% Leading:

\lineskip 1pt \normallineskip 1pt
\def\baselinestretch{1}

% Some standard vertical glues:

\bigskipamount 10pt plus 2pt minus 2pt
\medskipamount 5pt plus 1pt minus 1pt
\smallskipamount 2.5pt plus 1pt

% Standard font switches:

\DeclareOldFontCommand{\rm}{\normalfont\rmfamily}{\mathrm}
\DeclareOldFontCommand{\sf}{\normalfont\sffamily}{\mathsf}
\DeclareOldFontCommand{\tt}{\normalfont\ttfamily}{\mathtt}
\DeclareOldFontCommand{\bf}{\normalfont\bfseries}{\mathbf}
\DeclareOldFontCommand{\it}{\normalfont\itshape}{\mathit}
\DeclareOldFontCommand{\sl}{\normalfont\slshape}{\relax}
\DeclareOldFontCommand{\sc}{\normalfont\scshape}{\relax}

% Commands to define the size-changing commands:

\def\def@normalsize#1#2#3{\def\normalsize{\@setsize
\normalsize{#1}{#2}{#3}%
\abovedisplayskip \medskipamount
\belowdisplayskip \abovedisplayskip
\abovedisplayshortskip \smallskipamount
\belowdisplayshortskip \belowdisplayskip
\let\@listi\@listI}}

\def\def@small#1#2#3{\def\small{\@setsize
\small{#1}{#2}{#3}%
\abovedisplayskip .9\medskipamount
\belowdisplayskip \abovedisplayskip
\abovedisplayshortskip .9\smallskipamount
\belowdisplayshortskip .9\abovedisplayskip
\def\@listi{\leftmargin\leftmargini
\topsep .9\medskipamount
\parsep .9\smallskipamount
\itemsep \parsep}}}

\def\def@footnotesize#1#2#3{\def\footnotesize{\@setsize
\footnotesize{#1}{#2}{#3}%
\abovedisplayskip .8\medskipamount
\belowdisplayskip \abovedisplayskip
\abovedisplayshortskip .8\smallskipamount
\belowdisplayshortskip \belowdisplayskip
\def\@listi{\leftmargin\leftmargini
\topsep .8\medskipamount
\parsep .8\smallskipamount
\itemsep \parsep}}}

\def\def@scriptsize#1#2#3{\def\scriptsize{\@setsize\scriptsize{#1}{#2}{#3}}}
\def\def@tiny#1#2#3{\def\tiny{\@setsize\tiny{#1}{#2}{#3}}}
\def\def@large#1#2#3{\def\large{\@setsize\large{#1}{#2}{#3}}}
\def\def@Large#1#2#3{\def\Large{\@setsize\Large{#1}{#2}{#3}}}
\def\def@LARGE#1#2#3{\def\LARGE{\@setsize\LARGE{#1}{#2}{#3}}}
\def\def@huge#1#2#3{\def\huge{\@setsize\huge{#1}{#2}{#3}}}
\def\def@Huge#1#2#3{\def\Huge{\@setsize\Huge{#1}{#2}{#3}}}

% The default values for all the fonts.  First, Times Roman, with
% Helvetica (bleuch) heads.

\def\times@style{
   \def@tiny{6pt}\vpt\@vpt
   \def@scriptsize{8.5pt}\viipt\@viipt
   \def@footnotesize{9.5pt}\viiipt\@viiipt
   \def@small{11pt}\ixpt\@ixpt
   \def@normalsize{12pt}\xpt\@xpt
   \def@large{14pt}\xiipt\@xiipt
   \def@Large{18pt}\xivpt\@xivpt
   \def@LARGE{22pt}\xviipt\@xviipt
   \def@huge{25pt}\xxpt\@xxpt
   \def@Huge{30pt}\xxvpt\@xxvpt
   \normalsize
   \RequirePackage{pstimes,pstimesm,pscour,pshelv}
   \def\reportpartfont{\Large\bfsf}
   \def\chapterfont{\Large\bfsf}
   \def\partfont{\bfsf}
   \def\parttocfont{\bfsf}
   \def\chaptertocfont{\bfsf}
   \def\sectionfont{\bfsf}
   \def\subsectionfont{\sf}
   \def\subsubsectionfont{\sf}
   \def\paragraphfont{\bfsf}
   \def\subparagraphfont{\bfsf}
   \def\descriptionfont{\bfsf}
   \def\captionnamefont{\footnotesize\bfsf}
   \def\captionfont{\footnotesize\sf}
   \def\foliofont{\footnotesize\sf}
   \def\headfont{\footnotesize\sf}
   \def\theoremfont{\emfont}
   \def\theoremnamefont{\bfsf}
   \def\titlefont{\Large\bfsf}
   \def\authorfont{\sf}
   \def\authorandfont{\sf}
   \def\floatfont{\footnotesize}
   \def\abstractfont{\footnotesize}
   \def\abstractnamefont{\bfsf}
   \def\emfont{\it}}

% Then Lucida Bright, with Lucida sans heads.

\def\lucida@style{
   \def@tiny{6.5pt}\vpt\@vpt
   \def@scriptsize{8pt}\vipt\@vipt
   \def@footnotesize{9pt}\viipt\@viipt
   \def@small{10.5pt}\viiipt\@viiipt
   \def@normalsize{11.5pt}\ixpt\@ixpt
   \def@large{14pt}\xipt\@xipt
   \def@Large{19pt}\xivpt\@xivpt
   \def@LARGE{23pt}\xviipt\@xviipt
   \def@huge{27pt}\xxpt\@xxpt
   \def@Huge{32pt}\xxvpt\@xxvpt
   \normalsize
   \RequirePackage{pslucida}
   \def\reportpartfont{\Large\bfsf}
   \def\chapterfont{\Large\bfsf}
   \def\partfont{\bfsf}
   \def\parttocfont{\bfsf}
   \def\chaptertocfont{\bfsf}
   \def\sectionfont{\bfsf}
   \def\subsectionfont{\sf}
   \def\subsubsectionfont{\sf}
   \def\paragraphfont{\bfsf}
   \def\subparagraphfont{\bfsf}
   \def\descriptionfont{\bfsf}
   \def\captionnamefont{\footnotesize\bfsf}
   \def\captionfont{\footnotesize\sf}
   \def\foliofont{\footnotesize\sf}
   \def\headfont{\footnotesize\sf}
   \def\theoremfont{\emfont}
   \def\theoremnamefont{\bfsf}
   \def\titlefont{\Large\bfsf}
   \def\authorfont{\sf}
   \def\authorandfont{\sf}
   \def\floatfont{\footnotesize}
   \def\abstractfont{\footnotesize}
   \def\abstractnamefont{\bfsf}
   \def\emfont{\it}}

% Then CMR.  This uses small caps for headings rather than sans, since a)
% CM sans is rather dodgy at low resolutions, b) CM sans bold is a bit
% yucky, with those rounded corners, and c) the PostScript small caps
% generated by afm2tfm are pretty bad---there's no letter spacing.  I've
% set the \em font to be \sl, since CM italic is rather overpowering.

\def\cmr@style{
   \def@tiny{6pt}\vpt\@vpt
   \def@scriptsize{8.5pt}\viipt\@viipt
   \def@footnotesize{9.5pt}\viiipt\@viiipt
   \def@small{11pt}\ixpt\@ixpt
   \def@normalsize{12pt}\xpt\@xpt
   \def@large{14pt}\xiipt\@xiipt
   \def@Large{18pt}\xivpt\@xivpt
   \def@LARGE{22pt}\xviipt\@xviipt
   \def@huge{25pt}\xxpt\@xxpt
   \def@Huge{30pt}\xxvpt\@xxvpt
   \normalsize
   \def\reportpartfont{\Large\bf\boldmath}
   \def\chapterfont{\Large\bf\boldmath}
   \def\partfont{\sc}
   \def\parttocfont{\sc}
   \def\chaptertocfont{\bf\boldmath}
   \def\sectionfont{\bf\boldmath}
   \def\subsectionfont{\emfont}
   \def\subsubsectionfont{\emfont}
   \def\paragraphfont{\sc}
   \def\subparagraphfont{\sc}
   \def\descriptionfont{\sc}
   \def\captionnamefont{\footnotesize\sc}
   \def\captionfont{\footnotesize}
   \def\foliofont{\footnotesize}
   \def\headfont{\footnotesize\emfont}
   \def\theoremfont{\emfont}
   \def\theoremnamefont{\sc}
   \def\titlefont{\Large\bf\boldmath}
   \def\authorfont{\sc}
   \def\authorandfont{\fontshape{n}\selectfont}
   \def\floatfont{\footnotesize}
   \def\abstractfont{\footnotesize}
   \def\abstractnamefont{\rm\sc}
   \def\emfont{\sl}}

% And load the font style.

\font@style

% Print out a warning message:

\if@crc
   \typeout{}
   \typeout{Camera ready copy, to be printed with `dvips -x1440 \jobname'.}
   \typeout{}
\else\if@cover
   \typeout{}
   \typeout{To be printed with `dvips \jobname'.}
   \typeout{}
\fi\fi

% The command to print `Table of contents', `References', etc.

\if@report
   \def\section@star{\chapter*}
\else
   \def\section@star{\section*}
\fi

% The page size:

\if@lics
   \textheight = 225mm
   \textwidth = 175mm
\else\if@lncs
   \textheight = 516pt
   \textwidth 125mm
\else
   \textheight = 485pt
   \textwidth 320pt
\fi\fi

\divide\textheight by \baselineskip
\multiply\textheight by \baselineskip
\advance\textheight by \topskip

% The paper size:

\newdimen\paperwidth \paperwidth=210mm
\newdimen\paperheight \paperheight=298mm
\newdimen\stupidoffset \stupidoffset=1in

\if@crc
   \paperwidth = .707\paperwidth
   \paperheight= .707\paperheight
   \stupidoffset=.707\stupidoffset
\fi

% The margins:

\if@twoside

   \oddsidemargin\paperwidth
   \advance\oddsidemargin by -\textwidth
   \multiply\oddsidemargin by 2
   \divide\oddsidemargin by 5
   \advance\oddsidemargin by -\stupidoffset

   \evensidemargin\paperwidth
   \advance\evensidemargin by -\textwidth
   \multiply\evensidemargin by 3
   \divide\evensidemargin by 5
   \advance\evensidemargin by -\stupidoffset

   \marginparwidth \evensidemargin
   \advance\marginparwidth by 15mm

\else

   \oddsidemargin\paperwidth
   \advance\oddsidemargin by -\textwidth
   \divide\oddsidemargin by 2
   \advance\oddsidemargin by -\stupidoffset

   \evensidemargin \oddsidemargin

   \marginparwidth \evensidemargin
   \advance\marginparwidth by 15mm

\fi

\columnsep 10pt \columnseprule 0pt
\marginparpush \medskipamount
\marginparsep 1em

% The headers and footers:

\headheight 12pt
\headsep \medskipamount
\footskip 2\baselineskip
\footnotesep \medskipamount
\skip\footins 12pt plus 12pt

\topmargin \paperheight
\advance\topmargin by -\textheight
\multiply\topmargin by 2
\divide\topmargin by 5
\advance\topmargin by -\headheight
\advance\topmargin by -\headsep
\advance\topmargin by -\stupidoffset

% Floats:

\floatsep \bigskipamount
\textfloatsep \bigskipamount
\intextsep \bigskipamount
\dbltextfloatsep \bigskipamount

\@fptop 0pt plus 1fil
\@fpsep 12pt plus 1fil
\@fpbot 0pt plus 1fil
\@dblfptop 0pt plus 1fil
\@dblfpsep 12pt plus 1fil
\@dblfpbot 0pt plus 1fil

% Paragraph spacing:

\parskip 0pt
\parindent 15pt
\partopsep 0pt

% Penalties:

\@lowpenalty 51
\@medpenalty 151
\@highpenalty 301
\@beginparpenalty -\@lowpenalty
\@endparpenalty -\@lowpenalty
\@itempenalty -\@lowpenalty

% Parts:

\if@report

   \def\part{\clearpage\thispagestyle{empty}
      \cleardoublepage\thispagestyle{empty}
      \secdef\@part\@spart}

   \def\@part[#1]#2{\refstepcounter{part}
      \addcontentsline{toc}{part}{\thepart\hspace{10pt}#1}
      {\raggedright\hbox{}\bigskip
         \interlinepenalty \@M
         \reportpartfont \thepart\quad#2
         \par}\@endpart}

   \def\@endpart{\vfil\newpage
      \if@twoside
          \hbox{}%
          \thispagestyle{empty}%
          \newpage
      \fi}

   \def\@spart#1{\addcontentsline{toc}{part}{#1}{\centering
      \interlinepenalty \@M
      \partfont#1\par}\@endpart}

   \def\chapter{\clearpage
      \thispagestyle{empty}%
      \global\@topnum\z@
      \@afterindentfalse
      \secdef\@chapter\@schapter}

   \def\@chapter[#1]#2{\pagenumbering{arabic}
      \ifnum \c@secnumdepth >\m@ne
           \refstepcounter{chapter}%
           \typeout{\@chapapp\space\thechapter.}%
           \addcontentsline{toc}{chapter}{\protect
           \numberline{\thechapter}#1}\else
         \addcontentsline{toc}{chapter}{#1}\fi
      \chaptermark{#1}%
      \addtocontents{lof}%
          {\protect\addvspace{10\p@}}
      \addtocontents{lot}%
          {\protect\addvspace{10\p@}}
      \hbox{}\bigskip
      {\raggedright\chapterfont
         \ifnum\c@secnumdepth > \m@ne \@hangfrom{\thechapter\quad}\fi
         #2 \par}
      \nobreak\bigskip\@afterheading}

   \def\@schapter#1{
      \addcontentsline{toc}{chapter}{#1}
      \hbox{}\bigskip
      {\raggedright\chapterfont #1\par}
      \nobreak\bigskip\@afterheading}

   \def\chaptermark#1{}

   \def\appendix{\par
      \def\@chapapp{\appendixname}
      \setcounter{chapter}{0}
      \setcounter{section}{0}
      \setcounter{subsection}{0}
      \def\thechapter{\Alph{chapter}}}

   \def\@chapapp{\chaptername}

\else

   \def\part{\par \addvspace{\bigskipamount} \@afterindentfalse
      \secdef\@part\@spart}
   \def\@part[#1]#2{\ifnum \c@secnumdepth >\m@ne \refstepcounter{part}
      \addcontentsline{toc}{part}{\thepart \hspace{10pt}#1}\else
      \addcontentsline{toc}{part}{#1}\fi {\centering
      \ifnum \c@secnumdepth >\m@ne \partfont \thepart\quad \fi
      \partfont #2\par } \nobreak \vskip\bigskipamount \@afterheading }
   \def\@spart#1{{\centering\partfont #1\par} \nobreak
      \vskip\bigskipamount \@afterheading }

   \def\appendix{\par
    \setcounter{section}{0}
    \setcounter{subsection}{0}
    \def\thesection{\Alph{section}}}

\fi

\def\section{\@startsection{section}
   {1}\z@{-\bigskipamount}\medskipamount{\raggedright\sectionfont}}
\def\subsection{\@startsection{subsection}
   {2}\z@{-\medskipamount}\smallskipamount{\raggedright\subsectionfont}}
\def\subsubsection{\@startsection{subsubsection}
   {3}\z@{-\medskipamount}\smallskipamount{\raggedright\subsubsectionfont}}

\def\paragraph{\@startsection{paragraph}
   {4}\z@\medskipamount{-10pt}\paragraphfont}
\def\subparagraph{\@startsection{subparagraph}
   {5}\z@\medskipamount{-10pt}\subparagraphfont}

\setcounter{secnumdepth}{2}

% Lists:

\leftmargini \parindent
\leftmarginii \parindent
\leftmarginiii \parindent
\leftmarginiv \parindent
\leftmarginv \parindent
\leftmarginvi \parindent
\leftmargin \leftmargini

\labelsep=5pt
\labelwidth\leftmargini \advance\labelwidth by -\labelsep

\def\@listI{\leftmargin\leftmargini
   \parsep \z@
   \listparindent 10pt
   \topsep \medskipamount
   \itemsep \medskipamount}
\let\@listi\@listI
\@listi

\def\@listii{\leftmargin\leftmarginii}
\def\@listiv{\leftmargin\leftmarginiv}
\def\@listv{\leftmargin\leftmarginv}
\def\@listvi{\leftmargin\leftmarginvi}

% The enumeration labels.

\def\labelenumi{\theenumi.}
\def\theenumi{\arabic{enumi}}
\def\labelenumii{(\theenumii)}
\def\theenumii{\alph{enumii}}
\def\p@enumii{\theenumi}
\def\labelenumiii{\theenumiii.}
\def\theenumiii{\roman{enumiii}}
\def\p@enumiii{\theenumi(\theenumii)}
\def\labelenumiv{\theenumiv.}
\def\theenumiv{\Alph{enumiv}}
\def\p@enumiv{\p@enumiii\theenumiii}

% The itemize labels.

\def\labelitemi{$\bullet$}
\def\labelitemii{\bf --}
\def\labelitemiii{$\ast$}
\def\labelitemiv{$\cdot$}

% The usual lists:

\def\verse{\let\\=\@centercr
 \list{}{\itemsep\z@ \itemindent -10pt\listparindent \itemindent
 \rightmargin\leftmargin\advance\leftmargin 10pt}\item[]}
\let\endverse\endlist
\def\quotation{\list{}{\listparindent 10pt
 \itemindent\listparindent
 \rightmargin\leftmargin \parsep\z@}\item[]}
\let\endquotation=\endlist
\def\quote{\list{}{\rightmargin\leftmargin}\item[]}
\let\endquote=\endlist

\def\descriptionlabel#1{\hspace\labelsep \descriptionfont #1}
\def\description{\list{}{\labelwidth\z@ \itemindent-\leftmargin
 \let\makelabel\descriptionlabel \listparindent\parindent}}
\let\enddescription\endlist

\def\itemize{\ifnum \@itemdepth >3 \@toodeep\else \advance\@itemdepth \@ne
\edef\@itemitem{labelitem\romannumeral\the\@itemdepth}%
\list{\csname\@itemitem\endcsname}{\listparindent\parindent
\def\makelabel##1{\hss\llap{##1}}}\fi}

% And variants of itemize and enumerate with no item separation.

\@namedef{itemize*}{\ifnum \@itemdepth >3 \@toodeep\else \advance\@itemdepth \@ne
\edef\@itemitem{labelitem\romannumeral\the\@itemdepth}%
\list{\csname\@itemitem\endcsname}{\itemsep\z@\listparindent\parindent
\def\makelabel##1{\hss\llap{##1}}}\fi}

\@namedef{enditemize*}{\enditemize}

\@namedef{enumerate*}{\ifnum \@enumdepth >3 \@toodeep\else
      \advance\@enumdepth \@ne
      \edef\@enumctr{enum\romannumeral\the\@enumdepth}\list
      {\csname label\@enumctr\endcsname}{\itemsep\z@\usecounter
        {\@enumctr}\def\makelabel##1{\hss\llap{##1}}}\fi}

\@namedef{endenumerate*}{\endenumerate}

% Standard dimensions:

\arraycolsep 1.3888889pt  % So array columns are separated by \thickmuskip
\tabcolsep 5pt
\arrayrulewidth .4pt
\doublerulesep 2pt
\tabbingsep \labelsep

\skip\@mpfootins = \skip\footins
\fboxsep = 2.5pt \fboxrule = .4pt

% Some toc things:

\def\@pnumwidth{1.55em}
\def\@tocrmarg {2.55em}
\def\@dotsep{4.5}

% Footnote stuff:

\def\footnoterule{\kern-3\p@
 \hrule width .4\columnwidth
 \kern 2.6\p@}

\long\def\@makefntext#1{\parindent 1em\noindent
 \hbox to 1em{\hss$^{\@thefnmark}$}#1}

% Float stuff.

\setcounter{topnumber}{2}
\def\topfraction{.7}
\setcounter{bottomnumber}{1}
\def\bottomfraction{.3}
\setcounter{totalnumber}{3}
\def\textfraction{.2}
\def\floatpagefraction{.5}
\setcounter{dbltopnumber}{2}
\def\dbltopfraction{.7}
\def\dblfloatpagefraction{.5}

\long\def\@makecaption#1#2{
 \medskip
 \setbox\@tempboxa\hbox{{\captionnamefont#1.} {\captionfont#2}}
 \ifdim \wd\@tempboxa >\hsize {\centering{\captionnamefont #1.}
 {\captionfont#2\par}} \else \hbox
to\hsize{\hfil\box\@tempboxa\hfil}
 \fi}

% Standard headings.

\if@report
   \markboth{\noexpand\@shtitle}{\noexpand\@shtitle}
\else
   \markboth{\noexpand\@useshauthor}{\noexpand\@shtitle}
\fi

\def\@useshauthor{{\def\and{\@listand{and}}\@shauthor}}
\def\@listand#1{\ifnum\@authors=2 #1 \else\unskip, \advance\@authors by -1\fi}

\def\ps@headings
   {\let\@mkboth\@gobbletwo
   \let\chaptermark\markright
   \def\@oddfoot{}\def\@evenfoot{}%
   \def\@evenhead
      {\hbox to 0pt{\foliofont\thepage\hss}\hfil
         \headfont\leftmark\hfil\hbox{}}%
   \def\@oddhead
      {\hbox{}\hfil{\headfont\rightmark}\hfil
         \hbox to 0pt{\hss\foliofont\thepage}}}

% \author and \title now look to see if there's an optional short
% title/author list.

\newcount\@authors
\def\author{\@dblarg\@@author}
\def\@@author[#1]#2%
   {\def\@shauthor{#1}\def\@author{#2}\global\@authors=1
      {\def\and{\global\advance\@authors by 1}\setbox0\hbox{\@author}}}
\def\@author{\@warning{The `author' field has not been set}
   \gdef\@author{}\gdef\@shauthor{}}
\let\@shauthor\@author

\def\title{\@dblarg\@@title}
\def\@@title[#1]#2{\def\@shtitle{#1}\def\@title{#2}}
\def\@title{\@warning{The `title' field has not been set}
   \gdef\@title{}\gdef\@shtitle{}}
\let\@shtitle\@title

% \today as per usual.

\def\today{\number\day\space \ifcase\month\or
 January\or February\or March\or April\or May\or June\or
 July\or August\or September\or October\or November\or December\fi
 \space\number\year}

% Headings is the default page style, and there's no twocolumn option.

\ps@headings \onecolumn

% \newtheorem produces its name in small caps and its text in slanted.
% It also goes into horizontal mode, so a theorem that begins with a list
% will have the first item of the list on a new line.

\def\@begintheorem#1#2{\trivlist
      \item[\hskip \labelsep{\theoremnamefont 
          #1\ #2.}]\theoremfont\leavevmode}
\def\@opargbegintheorem#1#2#3{\trivlist
      \item[\hskip \labelsep{\theoremnamefont 
          #1\ #2\ (#3).}]\theoremfont\leavevmode}

% Some hackery for page numbering...  I'd like \pagenumbering{foo} not
% to do anything if the current page numbering style is foo.  So we
% keep the current page numbering style in a macro
% \@currpagenumbering, and only change the page numbering style if the
% new page numbering is different from \@currpagenumbering.

\def\pagenumbering#1%
   {\def\@newpagenumbering{#1}%
    \ifx\@newpagenumbering\@currpagenumbering\else
       \global\c@page\@ne
       \global\let\@currpagenumbering\@newpagenumbering
    \fi}

\def\thepage{\csname @\@currpagenumbering\endcsname\c@page}

% Similarly, we keep the current page style in \@currpagestyle (you'll
% see why soon!)

\def\pagestyle#1{\def\@currpagestyle{#1}\@nameuse{ps@#1}}

\if@twoside
   \pagestyle{headings}
\else
   \pagestyle{plain}
\fi

% Then when we come to write out the checkpoint aux file, we also
% output the current values of \@currpagenumbering and
% \@currpagestyle.  This means that if we do a \includeonly{foo}
% \include{bax} \include{foo}, foo will inherit the pagestyle and
% pagenumbering of baz.  This is handy if (like me) you like to keep
% pagenumbering and pagestyle things in \chapter commands, which are
% kept in subsiduary files.
%
% NOTE: This has been inherited from blue.sty (which is designed for
% long documents).  It doesn't make much difference to most articles,
% unless an author changes the page numbering themselves.

\def\@writeckpt#1%
   {\if@filesw
       \immediate\write\@partaux
          {\string\global\string\@namedef{cp@#1}\@charlb}%
       \immediate\write\@partaux{\string\pagenumbering{\@currpagenumbering}}%
       \immediate\write\@partaux{\string\pagestyle{\@currpagestyle}}%
       {\let\@elt\@wckptelt \cl@@ckpt}%
       \immediate\write\@partaux{\@charrb}%
   \fi}

% Equations are just numbers.

\def\theequation{\arabic{equation}}

% This is the standard titlepage environment.  Please don't use it.

\def\titlepage{\@restonecolfalse\if@twocolumn\@restonecoltrue\onecolumn
 \else \newpage \fi \thispagestyle{empty}\c@page\z@}
\def\endtitlepage{\if@restonecol\twocolumn \else \newpage \fi}

% Standard counters

\if@report

   \newcounter {part}
   \newcounter {chapter}
   \newcounter {section}[chapter]
   \newcounter {subsection}[section]
   \newcounter {subsubsection}[subsection]
   \newcounter {paragraph}[subsubsection]
   \newcounter {subparagraph}[paragraph]

   \def\thepart {\Roman{part}}
   \def\thechapter {\arabic{chapter}}
   \def\thesection {\thechapter.\arabic{section}}
   \def\thesubsection {\thesection.\arabic{subsection}}
   \def\thesubsubsection {\thesubsection.\arabic{subsubsection}}
   \def\theparagraph {\thesubsubsection.\arabic{paragraph}}
   \def\thesubparagraph {\theparagraph.\arabic{subparagraph}}

\else

   \newcounter {part}
   \newcounter {section}
   \newcounter {subsection}[section]
   \newcounter {subsubsection}[subsection]
   \newcounter {paragraph}[subsubsection]
   \newcounter {subparagraph}[paragraph]

   \def\thepart {\Roman{part}}
   \def\thesection {\arabic{section}}
   \def\thesubsection {\thesection.\arabic{subsection}}
   \def\thesubsubsection {\thesubsection.\arabic{subsubsection}}
   \def\theparagraph {\thesubsubsection.\arabic{paragraph}}
   \def\thesubparagraph {\theparagraph.\arabic{subparagraph}}

\fi

% Table of contents.

\if@report

   \def\tableofcontents{\section@star{\tocname}
      {\@starttoc{toc}\clearpage}}

\else

   \def\tableofcontents{\section@star{\tocname}
      {\footnotesize\@starttoc{toc}\bigskip}}

\fi

\setcounter{tocdepth}{1}

\def\l@part#1#2{\addpenalty{-\@highpenalty}%
   \addvspace\bigskipamount
   \begingroup
   \@tempdima 3em
     \parindent \z@ \rightskip \@pnumwidth plus \linewidth
     \parfillskip\rightskip
     {\parttocfont\leavevmode #1\par}
     \nobreak\global\@nobreaktrue
    \everypar{\global\@nobreakfalse\everypar{}}%% suggested by
   \endgroup}

\if@report

\def\l@chapter#1#2{\addpenalty{-\@highpenalty}%
   \addvspace\medskipamount
   \@tempdima 1.5em
   \begingroup
     \parindent \z@ \rightskip \@pnumwidth plus \linewidth
     \parfillskip -\@pnumwidth
     \leavevmode
      \advance\leftskip\@tempdima
      \hskip -\leftskip
      \chaptertocfont
     #1\nobreak\hfil \nobreak\hbox to\@pnumwidth{\hss #2}\par
     \penalty\@highpenalty
   \endgroup}

   \def\l@section{\@dottedtocline{1}{1.5em}{2.3em}}
   \def\l@subsection{\@dottedtocline{2}{3.8em}{3.2em}}
   \def\l@subsubsection{\@dottedtocline{3}{7.0em}{4.1em}}
   \def\l@paragraph{\@dottedtocline{4}{10em}{5em}}
   \def\l@subparagraph{\@dottedtocline{5}{14em}{5em}}

\else

   \def\l@section{\@dottedtocline{1}{0em}{1.5em}}
   \def\l@subsection{\@dottedtocline{2}{1.5em}{2.3em}}
   \def\l@subsubsection{\@dottedtocline{3}{3.8em}{3.2em}}
   \def\l@paragraph{\@dottedtocline{4}{7.0em}{4.1em}}
   \def\l@subparagraph{\@dottedtocline{5}{10em}{5em}}

\fi

\def\listoffigures{\section@star{\listfigurename}
   {\footnotesize\@starttoc{lof}\bigskip}}
\def\l@figure{\@dottedtocline{1}{1.5em}{2.3em}}
\def\listoftables{\section@star{\listtablename}
   {\footnotesize\@starttoc{lot}\bigskip}}
\let\l@table\l@figure

% The bibliography, run in footnotesize.

\def\thebibliography#1{\section@star{\refname}\footnotesize\list
 {[\arabic{enumi}]}{\settowidth\labelwidth{[#1]}\leftmargin\labelwidth
 \advance\leftmargin\labelsep\itemsep\z@
 \usecounter{enumi}}
 \def\newblock{\hskip .11em plus .33em minus .07em}
 \sloppy\clubpenalty4000\widowpenalty4000
 \sfcode`\.=1000\relax}
\let\endthebibliography=\endlist

% Standard index, although god knows why anyone would want an index in an
% article...

\newif\if@restonecol
\def\theindex{\@restonecoltrue\if@twocolumn\@restonecolfalse\fi
\columnseprule \z@
\columnsep 35pt\twocolumn[\section@star{\indexname}]
 \thispagestyle{empty}\parindent\z@\footnotesize
 \parskip\z@ plus .3pt\relax\let\item\@idxitem}
\def\@idxitem{\par\hangindent 40pt}
\def\subitem{\par\hangindent 40pt \hspace*{20pt}}
\def\subsubitem{\par\hangindent 40pt \hspace*{30pt}}
\def\endtheindex{\if@restonecol\onecolumn\else\clearpage\fi}
\def\indexspace{\par \vskip\medskipamount\relax}

% Standard figures.

\newcounter{figure}
\def\thefigure{\@arabic\c@figure}
\def\fps@figure{tbp}
\def\ftype@figure{1}
\def\ext@figure{lof}
\def\fnum@figure{{\captionnamefont \figurename\ \thefigure}}
\def\figure{\floatfont\@float{figure}}
\let\endfigure\end@float
\@namedef{figure*}{\@dblfloat{figure}}
\@namedef{endfigure*}{\end@dblfloat}
\newcounter{table}
\def\thetable{\@arabic\c@table}
\def\fps@table{tbp}
\def\ftype@table{2}
\def\ext@table{lot}
\def\fnum@table{{\captionnamefont \tablename\ \thetable}}
\def\table{\floatfont\@float{table}}
\let\endtable\end@float
\@namedef{table*}{\@dblfloat{table}}
\@namedef{endtable*}{\end@dblfloat}

% The \maketitle macros.  The indicia is kept in a macro \@indicia,
% which you append to by using the standard TeX list macros from
% Appendix D.  Each indicia is put down as a \footnotetext, and we
% sneakily redefine \@makefntext to do nothing whilst the indicia is
% being printed.

\newtoks\@temptokenb

\def\@indicia{}
\def\indicia#1%
   {\@temptokena\expandafter{\@indicia}
    \@temptokenb{\an@indicia{#1}}
    \edef\@indicia{\the\@temptokena\the\@temptokenb}}

\if@report

   \def\an@indicia{\par\medskip}

\else\if@lics

   \def\an@indicia{\par}

\else

   \def\an@indicia{\footnotetext}

\fi\fi

\def\reportnumber#1{\def\@reportnumber{#1}}
\def\@reportnumber{{\bf ??/??}}

\def\date#1{\def\today{#1}\def\cover@date{#1}}
\edef\cover@date{\ifcase\month\or
 January\or February\or March\or April\or May\or June\or
 July\or August\or September\or October\or November\or December\fi
 \space\number\year}

% The cover page uses some PostScript wizardry, to read the epsf
% Sussex crest, and to put the front cover blurb in Helvetica :-P.

\def\makecover{{
   \input epsf
   \font\cover@blurb=phvr at 14.4pt
   \font\cover@title=phvb at 17.28pt
   \font\cover@author=phvr at 17.28pt
   \font\cover@address=phvr at 10pt
      \thispagestyle{empty}\centering
      \hbox{}\vskip 0pt plus \textheight minus \textheight
      \leavevmode
      \hbox to 0pt{\hss\vbox to 180mm{
         \hsize115mm \Large \cover@blurb
         UNIVERSITY OF SUSSEX
         \par\bigskip
         COMPUTER SCIENCE
         \par\bigskip\bigskip
         \leavevmode\epsfbox{ssxcrest.eps}
         \par\vfill
         {\LARGE\boldmath\cover@title\@title\par}
         \par\bigskip
         {\def\and{\par}\LARGE\cover@author\@author\par}
         \par\vfill
         \leavevmode\hbox to \textwidth{Report \@reportnumber\hfil\cover@date}
         \par\vfill
         {\normalsize\cover@address
            Computer Science \par
            School of Cognitive and Computing Sciences \par
            University of Sussex \par
            Brighton BN1 9QH \par
            \bigskip
            ISSN 1350--3170\par}}\hss}
      \par
      \vskip 0pt plus 2\textheight minus 2\textheight
      \newpage
      \addtocounter{page}{-1}}}

\if@report

   \def\maketitle
      {\if@cover\makecover\fi
       \thispagestyle{empty}
       \bgroup\raggedright
         \hbox{}
         \bigskip
         {\titlefont\@title\par}
         \bigskip
         {\def\and{\@listand{{\authorandfont and}}}\authorfont\@author}
      \egroup\vfill}

\else\if@lics

   \def\maketitle
      {\if@cover\makecover\fi
       \onecolumn
       \addtocounter{page}{-1}
       \thispagestyle{empty}
       \bgroup\centering
         \hbox{}
         \vfill
         {\titlefont\@title\par}
         \bigskip
         {\def\and{\@listand{{\authorandfont and}}}\authorfont\@author}
         \vfill
       \egroup}

\else

   \def\maketitle
      {\if@cover\makecover\fi
       \thispagestyle{empty}
       \bgroup\raggedright
         \hbox{}
         \bigskip
         {\titlefont\@title\par}
         \bigskip
         {\def\and{\@listand{{\authorandfont and}}}\authorfont\@author}
         \bigskip
         \def\@makefntext{}
         \@indicia
      \egroup
      \@afterindentfalse\@afterheading}

\fi\fi

% A rather dull abstract command.

\if@report

   \def\abstract{\paragraph*{\abstractnamefont\abstractname.}}
   \def\endabstract{\par\clearpage\thispagestyle{empty}\hbox{}\vfill
      {\raggedright\@indicia\par}\clearpage}

\else\if@lics

   \def\abstract{\centering\minipage{.6\textwidth}
      \paragraph*{\abstractnamefont\abstractname.}}
   \def\endabstract{\endminipage\vfill
      \@indicia\par
      \vfill\vfill
      \twocolumn}

\else

   \def\abstract{\abstractfont\paragraph*{\abstractnamefont\abstractname.}}
   \def\endabstract{\par\bigskip}

\fi\fi

% And page numbers are numerals, except for reports, where the front
% matter is in roman.

\if@report
   \pagenumbering{roman}
\else
   \pagenumbering{arabic}
\fi

% The default values for the various part names

\def\partname{Part}
\def\chaptername{Chapter}
\def\appendixname{Appendix}
\def\abstractname{Abstract}
\def\indexname{Index}
\def\figurename{Figure}
\def\tablename{Table}
\def\refname{References}
\def\tocname{Contents}
\def\listfigurename{List of Figures}
\def\listtablename{List of Tables}

% Define \bfsf to be bold sans, assuming the nfss is in force.  If it
% isn't, then the ssxtimes document style option won't work anyway.

\def\bfsf{\fontfamily{\sfdefault}\fontseries
   {\bfdefault}\fontshape{n}\selectfont}

% A new version of \em that calls \emfont rather than \it.

\def\@nomath#1{\relax\ifmmode \font@warning{Don't use \string#1 in
                                           math mode}\fi}
\def\pem{\@nomath\em \ifdim \fontdimen\@ne\font >\z@
                       \fontshape{n}\selectfont \else \emfont \fi}

% If we're a one-sided document, then we run with ragged bottom.

\if@twoside
\else\raggedbottom
\fi

% If we're a LICS paper, run in two column.

\if@lics
   \twocolumn
\fi

% That's all folks.

\endinput

% Filename: ajslide.sty
% Author: Alan Jeffrey
% E-mail: alanje@cogs.sussex.ac.uk
% Last modified: 12 Jan 1994

% Alan's LaTeX style for slides.

% 6 Apr 1992: Created file.
%
% 13 Sep 1993: scaled up from magstep5 to magstep6.
%
% 4 Nov 1993: Added the magstep5 and magstep6 options.
%
% 12 Jan 1994: Moved to LaTeX2e, added the landscape option.

% The magstep5 and magstep6 options change the magstep of the slides.
% The default is magstep6.

\DeclareOption{magstep5}{
   \typeout{To be printed with `dvips -x2488 \jobname'.}
   \def\shrinkage{.4019}
}

\DeclareOption{magstep6}{
   \typeout{To be printed with `dvips -x2986 \jobname'.}
   \def\shrinkage{.3349}
}

\DeclareOption{landscape}{
   \typeout{To be printed with `dvips -t landscape \jobname'.}
   \@landscapetrue
}

\newif\if@landscape
\@landscapefalse

\def\shrinkage{.3349}

\ProcessOptions

% This is a variant of the ssxcsart style.

\LoadClass{ssxcsart}
\RequirePackage[dvips]{graphics}

% PS scaling:

\def\maketitle{\slide\centering\vfil
   {\titlefont\fontsize{17}{20pt}\selectfont \@title\par}
   \vfil
   {\let\and=\\\authorfont\fontsize{14}{17pt}\selectfont\@author\par}
   \vfil\vfil\vfil
   \scalebox{.6}{\includegraphics{ssxcrest.eps}}
   \endslide}

% The basic slide:

\def\slide{\vbox to \textheight\bgroup
   \hrule\vbox to \textheight\bgroup}
\def\endslide{\vfil\egroup\vss\hrule\egroup\clearpage}

% Empty pages, ragged right.

\pagestyle{empty}
\raggedright
\parskip=\medskipamount

\newdimen\oneinch \oneinch=1in

\if@landscape

\paperwidth=298mm
\paperheight=210mm

\else

\paperwidth=210mm
\paperheight=298mm

\fi

\paperwidth=\shrinkage\paperwidth
\paperheight=\shrinkage\paperheight

\textwidth=.85\paperwidth
\textheight=.85\paperheight

\topmargin\paperheight
\advance\topmargin by -\textheight
\topmargin=.4\topmargin
\advance\topmargin by -\headheight
\advance\topmargin by -\headsep
\advance\topmargin by -\shrinkage\oneinch

\oddsidemargin\paperwidth
\advance\oddsidemargin by -\textwidth
\oddsidemargin=.5\oddsidemargin
\advance\oddsidemargin by -\shrinkage\oneinch

\evensidemargin\oddsidemargin

% Lists stuff:

\def\@listI{\leftmargin\leftmargini
   \parsep \z@
   \listparindent 10pt
   \topsep \medskipamount
   \advance \topsep by -\parskip
   \itemsep \medskipamount}
\let\@listi\@listI
\@listi

% No section numbering:

\setcounter{secnumdepth}{0}

% Some smaller text:

\def\smaller{\footnotesize\let\footnotesize\tiny}

% Sectioning:

\def\section{\@startsection{section}
   {1}\z@{-\bigskipamount}{1sp}{\sectionfont\fontsize{12}{14pt}\selectfont}}
\def\subsection{\@startsection{subsection}
   {2}\z@{-\medskipamount}{1sp}{\normalsize\subsectionfont}}
\def\subsubsection{\@startsection{subsubsection}
   {3}\z@{-\medskipamount}{1sp}{\normalsize\subsubsectionfont}}

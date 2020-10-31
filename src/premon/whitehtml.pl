#! /usr/bin/perl
#
# Replace any <body> tags in the input files by <body bgcolor=#ffffff>

foreach (@ARGV) {
  $filename = $_;
  $changed = 0;
  open (IN, $filename) || die "Can't open $filename";
  open (OUT, ">$filename.tmp") || die "Can't open $filename.tmp to write";
  while (<IN>) {
    if (
      (s/\<body\>/\<body bgcolor\=\#ffffff\>/) ||
      (s/\"packages.html\"\>All Packages\</\"sources.html\"\>Source Code\</)
    ) {
      $changed++;
    }
    print OUT;
  }
  close IN;
  close OUT;
  if ($changed) {
    print "Editing $filename\n";
    rename ("$filename.tmp", $filename);
  }
}

var bibtexParser = require("bibtex-parser");
var handlebars = require("handlebars");

function tidyBib(bib) {
    for (var key in bib) {
	for (var field in bib[key]) {
	    bib[key][field] = bib[key][field]
		.trim()
		.replace(/\~/g," ")
		.replace(/\s+/g," ")
		.replace(/[{}]/g,"");
	}
	bib[key]["AUTHOR"] = bib[key]["AUTHOR"]
	    .replace(/\s+and\s(?=.+\sand\s)/g,", ");
	bib[key]["REFEREED"] =
	    (bib[key]["entryType"] === "INPROCEEDINGS") ||
	    (bib[key]["entryType"]=== "ARTICLE");
    }
    return bib;
}

module.exports = function(grunt) {

    grunt.initConfig({
	pkg: grunt.file.readJSON("package.json"),
	copy: {
	    main: {
		cwd: 'src/',
		src: '**',
		dest: 'dist/',
		expand: true
	    }
	}
    });

    grunt.loadNpmTasks('grunt-contrib-copy');
    
    grunt.registerTask("page", "Build the web page", function() {
	var bib = tidyBib(bibtexParser(grunt.file.read("src/papers/JeffreyASA.bib")));
	var template = handlebars.compile(grunt.file.read("src/index.html"));
	var now = new Date();
	var months = [
	    "January", "February", "March", "April", "May", "June",
	    "July", "August", "September", "October", "November", "December"
	];
	grunt.file.write("dist/papers/JeffreyASAJ.json", JSON.stringify(bib, null, 2));
	grunt.file.write("dist/index.html", template({
	    bib: bib,
	    now: { date: now.getDate(), month: months[now.getMonth()], year: now.getFullYear() }
	}));
    });

    grunt.registerTask("default", ["copy","page"])				  

};

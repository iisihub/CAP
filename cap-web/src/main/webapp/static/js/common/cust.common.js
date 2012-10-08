// init
console.log("common aa init")
$(document).ready(function() {
	console.log("cust common ready init");
	router.set({
		routes : {
			"" : "loadpage",
			":page" : "loadpage",
			":page/:page2" : "loadpage"
		},

		loadpage : function(page1, page2) {
			//!page1 && !page2 && ($("#article").html(""));
			page1 && API.loadPage(page1 + ( page2 ? ('/' + page2) : ''));

		}
	});
});


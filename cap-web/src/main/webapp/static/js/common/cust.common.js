// init
$(document).ready(function() {
	console.log("cust common ready init");
	var navTop = $("nav.top"), navSub = $("nav.sub");
	router.set({
		routes : {
			"" : "loadpage", //default route
			":page" : "loadpage", // http://xxxxx/xxx/#page
			":page/:page2" : "loadpage" // http://xxxxx/xxx/#page
		},
		//router method
		loadpage : function(page1, page2) {
			if (page1) {
				navSub.find('.selected').removeClass('selected');
				var url = page1 + ( page2 ? ('/' + page2) : '');
				navSub.find("a[href='" + url + "']").parents("li").children("a").addClass("selected");
				API.loadPage(url);
			}
		}
	});
	$("a[href='#language']").click(function() {
		var o = $(this).parents("ol");
		if (o.height() == 18) {
			$(this).parent("li.lang").css('background-image', 'url(webroot/static/images/icon-down.png)');
			$(o).animate({
				height : 100
			});
		} else {
			$(this).parent("li.lang").css('background-image', 'url(webroot/static/images/icon-right.png)');
			$(o).animate({
				height : 18
			});
		}
		return false;
	});
	
	navTop.on("click","a",function(ev) {
		var _go = $(this).attr("href");
		var _path = window.location.pathname;
		var cxtPath = _path.substr(0, _path.indexOf("/", 1));
		window.location.href = cxtPath + "/page/" + _go;
		return false;
	});
	
	navSub.on("click", "a", function(ev) {
		router.to($(this).attr("href"));
		ev.preventDefault();
		return false;
	});
});


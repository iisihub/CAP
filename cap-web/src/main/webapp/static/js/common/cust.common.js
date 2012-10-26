// init
$(document).ready(function() {
	console.log("cust common ready init");
	router.set({
		routes : {
			"" : "loadpage",      //default route
			":page" : "loadpage", // http://xxxxx/xxx/#page
			":page/:page2" : "loadpage" // http://xxxxx/xxx/#page
		},
		//router method
		loadpage : function(page1, page2) {
			//!page1 && !page2 && ($("#article").html(""));
			page1 && API.loadPage(page1 + ( page2 ? ('/' + page2) : ''));

		}
	});
	$("a[href='#language']").click(function(){
		var o = $(this).parents("ol");
		if(o.height() == 18) {
			$(this).parent("li.lang").css('background-image', 'url(webroot/static/images/icon-down.png)');
			$(o).animate({height: 100});
		} else {
			$(this).parent("li.lang").css('background-image', 'url(webroot/static/images/icon-right.png)');
			$(o).animate({height: 18});
		}
		return false;
	});
	$("nav.top a").click(function(ev){
		var _go = $(this).attr("href");
		var _path = window.location.pathname;
		var cxtPath = _path.substr(0,_path.indexOf("/",1));
		window.location.href=cxtPath+"/page/"+_go;
		return false;
	});
	$("nav.sub a").click(function(ev){
		var _go = $(this);
		_go.closest('nav.sub').find('.selected').removeClass('selected');
		_go.add(_go.parents("li").children("a")).addClass('selected');
		router.to(_go.attr("href"));
		ev.preventDefault();
		return false;
	});
});


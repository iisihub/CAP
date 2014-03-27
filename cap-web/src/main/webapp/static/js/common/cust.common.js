// init
// var menu = {
    // "menu" : [{
// 
        // "name" : "系統設定",
        // "url" : "system",
        // "child" : [{
            // "name" : "代碼設定",
            // "url" : "codetype"
        // },{
            // "name" : "參數設定",
            // "url" : "sysparm"
        // },{
            // "name" : "流水號檢視",
            // "url" : "sequence"
        // }]
    // }, {
// 
        // "name" : "系统功能",
        // "url" : "sample",
        // "child" : [{
            // "name" : "檔案上下傳",
            // "url" : "fileUpdDwn"
        // }]
    // },{
        // "name" : "排程管理",
        // "url" : "batch",
        // "child" : [{
            // "name" : "排程設定",
            // "url" : "schedule"
        // }, {
            // "name" : "排程Job清單",
            // "url" : "jobs"
        // }, {
            // "name" : "排程監控",
            // "url" : "jobexecution"
        // }]
// 
    // }]
// }

// init
$(document).ready(function() {
    logDebug("cust common ready init");
    var navTop = $("nav.top"), navSub = $("nav.sub ol");
    $.get("webroot/samplehandler/queryMenu").done(function(res) {
        var _menu = res.menu, ul = $("nav.top ul.navmenu");
        $("#userName").val(res.userName);
        navTop.on("click", "li a", function(ev) {
            ev.preventDefault();
            router.to($(this).attr("url"));
            $("article").empty();
        });

        navSub.on("click", "li a", function(ev) {
            router.to($(this).attr("url"));
            ev.preventDefault();
            return false;
        });

        // render menu
        for (var m in _menu) {
            ul.append($("<li/>").append($("<a/>", {
                href : "#",
                url : _menu[m].url,
                data : {
                    smenu : _menu[m].child,
                    url : _menu[m].url
                },
                text : _menu[m].name
            })));
        }

        router.set({
            routes : {
                "" : "loadfirst", //default route
                ":page" : "loadsub", // http://xxxxx/xxx/#page
                ":page/:page2" : "loadpage" // http://xxxxx/xxx/#page
            },
            loadfirst : function() {
                ul.find("li a:first").click();
            },
            loadsub : function(folder) {
            
                var tlink = navTop.find("a").removeClass("select").filter("a[url=" + folder + "]").addClass("select");
                var smenu = tlink.data("smenu");
                if (navSub.find('a').size()) {
                    navSub.animate({
                        opacity : 0.01
                    }, 200, _f);
                } else {
                    navSub.css("opacity", "0.01");
                    _f();
                }
                
                function _s(root, s_menu){
                	for (var sm in s_menu) {
	                	if(s_menu[sm].child.length != 0){
	                		root.append($("<li/>").append($("<a/>", {
	                			url : "",
	                            data : {
	                                url : ""
	                            },
	                            text : s_menu[sm].name
	                        })
	                        .prepend("<span class='menu-icon icon-1'></span>")).append("<ul class='menu_sub'></ul>"));

	                		_s(root.find("li ul").last(), s_menu[sm].child);
	                	}else if(s_menu[sm].url){
	                		root.append($("<li/>").append($("<a/>", {
	                            url : s_menu[sm].url || "",
	                            data : {
	                                url : s_menu[sm].url || ""
	
	                            },
	                            text : s_menu[sm].name
	                        })));
	                	}else{
	                		root.append($("<li/>").append($("<a/>", {
	                            url : '#', data : { url : '#' },
	                            text : s_menu[sm].name
	                        })));
	                	}
                	}
                }

                function _f() {
                    navSub.empty().data("cmenu", folder);
                    for (var sm in smenu) {
                        navSub.append($("<li/>").append($("<a/>", {
                            url : tlink.data("url") + "/" + smenu[sm].url || "",
                            data : {
                                url : tlink.data("url") + "/" + smenu[sm].url || ""

                            },
                            text : smenu[sm].name
                        })));
                    }
                    navSub.animate({
                        opacity : 1
                    });
                }

            },
            //router method
            loadpage : function(folder, page) {
                if (!(navSub.data("cmenu") == folder)) {
                    this.loadsub(folder);
                }
                API.loadPage(folder + '/' + page, function() {
                    navSub.find('.selected').removeClass('selected').end().find("a[url='" + folder + '/' + page + "']").addClass("selected");
                });
            }
        });
    });
    
    $("a[href='#language']").click(function() {
        var o = $(this).parents("ol");
        if (o.height() == 18) {
            $(this).parent("li.lang").css('background-image', 'url('+baseUrl+'/images/icon-down.png)');
            $(o).animate({
                height : 100
            });
        } else {
            $(this).parent("li.lang").css('background-image', 'url('+baseUrl+'/images/icon-right.png)');
            $(o).animate({
                height : 18
            });
        }
        return false;
    });
    $.datepicker._gotoTodayOriginal = $.datepicker._gotoToday;
    $.datepicker._gotoToday = function(id) {
        // now, call the original handler
        $.datepicker._gotoTodayOriginal.apply(this, [id]);
        // invoke selectDate to select the current date and close datepicker.
    	var target = $(id), inst = this._getInst(target[0]);
    	var dateStr = (dateStr != null ? dateStr : this._formatDate(inst));
    	inst.input.val(dateStr);
    };
    $.datepicker.setDefaults({
    	onChangeMonthYear: function(year, month, inst){
            var ym = API.getToday().substr(0, 7), changeYm = year + "-" + (month < 10 ? "0" : "") + month;
            if (ym !== changeYm) {
                $(this).datepicker('setDate', changeYm + '-1');
            }
    	}
    });
});


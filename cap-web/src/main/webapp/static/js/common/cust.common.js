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
    
    /*timeout controls*/
 // Do idle process
	var idleDuration = 10;
	try {
		idleDuration = prop && prop[Properties.timeOut];
	}catch(e){
		logDebug("Can't find prop");
	}

	//計數器減差(這裡是分鐘)
	var gapTime = 1;
	if(Properties.remindTimeout){
		//#Cola235 增加切換頁reset timer
		//計數器(這裡是毫秒)
		window.timecount = (idleDuration-gapTime)*60*1000;
		logDebug("set timer time::"+timecount);
		var t1merConfirm =[];
		var timer2 = null;
		//TIMER FUNC1
		var cccheckMethod = function(dxx){
			$.ajax({
				url:url('checktimeouthandler/check'),
				asyn:true,
				data:{isContinues:dxx.isContinues},
				success:function(d){
					if(d.errorPage){
						window.setCloseConfirm(false);
						window.location = d.errorPage;
					}
				}
			});
		};
		//TIMER FUNC2
		var takeTimerReset = function(){
			timer.reset(timecount);
		};
		window.timer = $.timer(timecount, function(){
			var pathname = window.location.pathname;
			if(!/(timeout)$|(error)$/i.test(pathname)){
				if(t1merConfirm!=undefined && t1merConfirm[0] && t1merConfirm[0].hidden==false){
					//DO NOTTHING
				}else{
					timer2 = $.timer(gapTime*60*1000, function(){
						//超過時間沒給確認動作,就當做取消交易
						cccheckMethod({isContinues:false});
					}, false);
					t1merConfirm = CommonAPI.showConfirmMessage('您已閒置，請問是否繼續申請作業?',function(data){
						timer2.stop();
						cccheckMethod({isContinues:data});
						//按了之後,要重新倒數
						t1merConfirm = [];
						takeTimerReset();
					});
				}
			}
		}, false);
		//IDLE留著，當user沒看到confirm pop，時間到了idle還是要導倒timeout?
		ifvisible && ifvisible.setIdleDuration(idleDuration*60);//minute*60
		//logDebug("idleDuration is ::: " + idleDuration);
		ifvisible.on('idle', function() {
			$.unblockUI();
			$.ajax({
				url:url('checktimeouthandler/check'),
				asyn:true,
				data:{},
				success:function(d){
					if(d.errorPage){
						window.setCloseConfirm(false);
						window.location = d.errorPage;
					}
				}
			});
		});
		ifvisible.on('wakeup', function() {
//		$(".ui-dialog-content").dialog("close");
		});
	};

});


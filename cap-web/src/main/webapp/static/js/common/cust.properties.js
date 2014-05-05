/* 專案JS設定檔    */
$.extend(Properties || {}, {
	window : {
		closeConfirm : true,
		closeWindowMsg : '重新載入後資料將會消失!!\nReload the page data will be lost!!',
		onunload : function() {
		}
	},
	contextName : "/cap-web/",
	ajaxTimeOut : 60 * 1000 * 3, // timeOut: 1000
	// 下拉選單handler
	ComboBoxHandler : '/cap-web/codetypehandler/queryByKeys',
	Grid : {
		rowNum : 30,
		rowList : []
	},
    custLoadPageInit : function(isSubPage) {
    		//for captcha start
        this.find(".captcha").each(function() {
            var dom = $(this);
            var img = $("<img />", {
                src : url("captcha.png?cc=" + parseInt(Math.random() * 1000)),
                css : {
                    height : 24,
                    weight : 60
                }
            });
            dom.bind("refresh", function() {
            	dom.val("");
                img.attr("src", url("captcha.png?cc=" + parseInt(Math.random() * 1000)));
            });
            var refresh = $("<img />", {
                src : url("static/images/refresh.png"),
                css : {
                    height : 24,
                    cursor : 'pointer'
                },
                click : function() {
                    dom.trigger("refresh");
                }
            });
            dom.after(refresh).after(img);
        });
      //for captcha end
    },
	timeOut : 'TIME_OUT',
	remindTimeout : false
});

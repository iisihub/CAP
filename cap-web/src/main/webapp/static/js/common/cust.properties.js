/* 專案JS設定檔    */
$.extend(Properties || {}, {
	window : {
		closeConfirm : false,
		onunload : function() {
		}
	},
	ajaxTimeOut : 60 * 1000 * 3, // timeOut: 1000
	// 下拉選單handler
	ComboBoxHandler : 'webroot/handler/codetypehandler/queryByKeys',
	Grid : {
		rowNum : 30,
		rowList : []
	}

});

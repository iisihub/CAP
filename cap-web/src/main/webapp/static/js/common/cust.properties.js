/* 專案JS設定檔    */
$.extend(Properties || {}, {
	window : {
		closeConfirm : true,
		closeWindowMsg : '重新載入後資料將會消失!!\nReload the page data will be lost!!',
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

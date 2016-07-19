/* 專案JS設定檔    */
Properties = {
  window : {
    closeConfirm : false,
    closeWindowMsg : false,
    onunload : function() {

    }
  },

  title : window.document.title,
  ajaxTimeOut : 60 * 1000 * 3, // timeOut: 1000
  // 下拉選單handler
  ComboBoxHandler : "codetypehandler/queryByKeys",
  fileUploadSuccessHandler : "basehandler/fileSuccess",
  Grid : {
    rowNum : 30,
    rowList : []
  }

};

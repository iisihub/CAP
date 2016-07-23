pageInit(function() {
  $(document).ready(function() {
    var mform = $("#sendForm");
    var grid = $("#gridview").jqGrid({
      url : url('linecontactshandler/query'),
      height : "380",
      width : "100%",
      multiselect : false,
      hideMultiselect : false,
      autowidth : true,
      localFirst : false,
      colModel : [ {
        header : i18n['contacts']['picture'],
        name : 'picture',
        align : "center",
        width : 5,
        formatter : function(cellvalue, options, rowObject) {
          return "<img src='data:image/png;base64, " + cellvalue + "' height='45' width='45' />";
        }
      }, {
        header : i18n['contacts']['displayName'],// "單位名稱",
        name : 'diaplayName',
        align : "left",
        width : 15
      }, {
        header : i18n['contacts']['statusMessage'],// "法定代理人",
        name : 'statusMessage',
        align : "left",
        width : 15
      }, {
        header : i18n['contacts']['addTime'],// "單位經理",
        name : 'addTime',
        align : 'left',
        width : 15,
        sortable : false
      }, {
        header : i18n['contacts']['blocked'],// "地址",
        name : 'status',
        align : 'left',
        width : 15,
        sortable : false
      }, {
        name : 'mid',
        hidden : true
      }, {
        name : 'blocked',
        hidden : true
      } ]
    });
    var sendDialog = $("#send").dialog({
      title : '傳送訊息',
      modal : true,
      width : 500,
      height : 200,
      valign : "bottom",
      align : 'center',
      buttons : API.createJSON([ {
        key : i18n.def.sure,
        value : function() {
          if (mform.validationEngine('validate')) {
            $.ajax({
              url : url('linecontactshandler/sendMsg'),
              data : mform.serializeData(),
              success : function(responseData) {
                API.showMessage('傳送成功');
                mform.reset();
                sendDialog.dialog('close');
              }
            });
          }
        }
      }, {
        key : i18n.def.close,
        value : function() {
          mform.reset();
          sendDialog.dialog('close');
        }
      } ])
    });
    $(".btns").find("#sendMsg").click(function() {
      var sel = grid.getSelRowDatas();
      if (sel) {
        if (sel.blocked == '1') {
          API.showErrorMessage("用戶已封鎖此帳號，無法發送 LINE 訊息。");
        } else {
          mform.find("#mid").val(sel.mid);
          sendDialog.dialog('open');
        }
      } else {
        API.showErrorMessage(i18n.def.grid_selector);
      }
    });
  });
});
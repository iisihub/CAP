pageInit(function() {
  $(document).ready(function() {
    var mform = $("#mform");
    var grid = $("#gridview").jqGrid({
      url : url('sysparmhandler/query'),
      sortname : 'parmId',
      height : 350,
      colModel : [ {
        header : i18n['sysparm']['parmId'],//代碼
        name : 'parmId',
        width : 20
      }, {
        header : i18n['sysparm']['parmValue'],//參數值
        name : 'parmValue',
        width : 30
      }, {
        header : i18n['sysparm']['parmDesc'],//說明
        name : 'parmDesc',
        width : 30
      }, {
        header : i18n.def.lastModBy,
        name : 'updater',
        width : 10,
        align : "center"
      }, {
        header : i18n.def.lastModTm,
        name : 'updateTime',
        width : 10,
        align : "center"
      } ],
      ondblClickRow : function() {
        var ret = grid.getSelRowDatas();
        eDialog.dialog('open').find("#mform").injectData(ret);
      }
    });
    var eDialog = $("#editDialog"), qDialog = $("#qryDailog");
    eDialog.dialog({
      height : 250,
      width : 650,
      modal : true,
      close : function() {
        eDialog.find("#mform").reset();
      },
      buttons : API.createJSON([ {
        key : i18n.def.sure,
        value : function() {
          var mform = eDialog.find("#mform");
          mform.validationEngine('validate') && $.ajax({
            url : url("sysparmhandler/modify"),
            data : mform.serializeData(),
            success : function() {
              grid.trigger("reloadGrid");
            }
          });
        }
      }, {
        key : i18n.def.close,
        value : function() {
          eDialog.dialog('close');
        }
      } ])
    });
    qDialog.dialog({
      height : 150,
      width : 350,
      modal : true,
      buttons : API.createJSON([ {
        key : i18n.def.sure,
        value : function() {
          grid.jqGrid('setGridParam', {
            postData : {
              parmId : qDialog.find("#parmId").val()
            }
          });
          grid.trigger("reloadGrid");
          qDialog.dialog('close');
        }
      }, {
        key : i18n.def.close,
        value : function() {
          qDialog.dialog('close');
        }
      } ])
    });
    $(".btns").find("#qry").click(function() {//查詢
      qDialog.dialog('open');
    }).end().find("#add").click(function() {//新增,修改
      eDialog.dialog('open');
    }).end().find("#delete").click(function() {
      var ret = grid.getSelRowDatas();
      if (ret) {
        API.showConfirmMessage(i18n.def.actoin_001, function(data) {
          data && $.ajax({
            url : url("sysparmhandler/delete"),
            data : {
              parmId : ret.parmId
            },
            success : function() {
              grid.trigger("reloadGrid");
            }
          });
        });
      } else {
        API.showErrorMessage(i18n.def.grid_selector);
      }
    });
  });
});
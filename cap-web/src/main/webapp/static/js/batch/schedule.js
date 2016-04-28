pageInit(function() {
  $(document).ready(function() {
    var grid = $("#gridview").jqGrid({
      url : url('batchshandler/schQuery'),
      sortname : 'schId',
      sortorder : "asc",
      height : 350,
      colModel : [ {
        header : i18n['schedule']['isenable'],
        name : 'isEnabled',
        width : 15,
        align : "center"
      }, {
        header : i18n['schedule']['schId'],
        name : 'schId',
        width : 40
      }, {
        header : i18n['schedule']['schDesc'],
        name : 'schDesc',
        width : 60
      }, {
        header : i18n['schedule']['schType'],
        name : 'schType',
        width : 20
      }, {
        header : i18n.def.lastModBy,
        name : 'updater',
        width : 20,
        align : "center"
      }, {
        header : i18n.def.lastModTm,
        name : 'updateTime',
        width : 20,
        align : "center"
      } ],
      ondblClickRow : function() {
        var ret = grid.getSelRowDatas();
        $.ajax({
          url : url("batchshandler/schDetail"),
          data : {
            schId : ret.schId
          },
          success : function(r) {
            eDialog.find("#schId").readOnly(true);
            eDialog.dialog('open').find("#mform").injectData(r);
          }
        });
      }
    });
    var eDialog = $("#editDialog"), qDialog = $("#qryDailog");
    eDialog.find("input[name=schType]").click(function() {
      var v = $(this).val();
      eDialog.find(".schType" + v).show().end().find(".schType" + (v == 'C' ? 'T' : 'C')).hide();
    }).end().find("input[name=isNotify]").click(function() {
      eDialog.find(".notify")[$(this).val() == 'Y' ? 'show' : 'hide']();
    });
    eDialog.dialog({ //維護畫面
      height : 630,
      width : 650,
      modal : true,
      close : function() {
        eDialog.find("#mform").reset().find(".hide").hide().siblings(".show").show();
      },
      buttons : API.createJSON([ {
        key : i18n.def.sure,
        value : function() {
          eDialog.find("#mform").validationEngine('validate') && $.ajax({
            url : url("batchshandler/schModify"),
            data : eDialog.find("#mform").serializeData(),
            success : function() {
              eDialog.dialog('close');
              grid.jqGrid('setGridParam', {
                postData : {
                  jobId : eDialog.find("#schId").val()
                }
              });
              grid.trigger("reloadGrid");
            }
          });
        }
      }, {
        key : i18n.def.close,
        value : function() {
          $(this).dialog('close');
        }
      } ])
    });
    qDialog.dialog({ //查詢畫面
      height : 150,
      width : 350,
      modal : true,
      buttons : API.createJSON([ {
        key : i18n.def.sure,
        value : function() {
          grid.jqGrid('setGridParam', {
            postData : {
              jobId : qDialog.find("#schId").val()
            }
          });
          grid.trigger("reloadGrid");
          $(this).dialog('close');
        }
      }, {
        key : i18n.def.close,
        value : function() {
          $(this).dialog('close');
        }
      } ])
    });

    $(".btns").find("#add").click(function() { //新增
      eDialog.dialog('open').find("#schId").readOnly(false);
    }).end().find("#delete").click(function() { //刪除
      var ret = grid.getSelRowDatas();
      if (ret) {
        API.showConfirmMessage(i18n.def.actoin_001, function(data) {
          data && $.ajax({
            url : url("batchshandler/schDelete"),
            data : {
              schId : ret.schId
            },
            success : function() {
              grid.trigger("reloadGrid");
            }
          });
        });
      } else {
        API.showErrorMessage(i18n.def.grid_selector);
      }
    }).end().find("#qry").click(function() { //查詢
      qDialog.dialog('open');
    });
  });
});

pageInit(function() {
  $(document).ready(function() {
    var grid = $("#gridview").jqGrid({
      url : url('batchshandler/jobQuery'),
      sortname : 'jobId',
      sortorder : "asc",
      height : 350,
      colModel : [ {
        header : ' ',
        name : 'jobStatus',
        width : 5,
        align : 'center',
        sortable : false
      }, {
        header : i18n['jobs']['jobId'],
        name : 'jobId',
        width : 20
      }, {
        header : i18n['jobs']['jobDesc'],
        name : 'jobDesc',
        width : 30
      }, {
        header : i18n['jobs']['jobResource'],
        name : 'jobResource',
        width : 30
      }, {
        header : i18n.def.lastModBy,
        name : 'updater',
        width : 15,
        align : "center"
      }, {
        header : i18n.def.lastModTm,
        name : 'updateTime',
        width : 15,
        align : "center"
      } ],
      ondblClickRow : function() {
        var ret = grid.getSelRowDatas();
        eDialog.dialog('open').find("#mform").injectData(ret);
      }
    });
    var eDialog = $("#editDialog"), qDialog = $("#qryDailog"), exeDialog = $("#exeDailog");
    eDialog.dialog({ //維護畫面
      height : 250,
      width : 650,
      modal : true,
      close : function() {
        eDialog.find("#mform").reset();
      },
      buttons : API.createJSON([ {
        key : i18n.def.sure,
        value : function() {
          eDialog.find("#mform").validationEngine('validate') && $.ajax({
            url : url("batchshandler/jobModify"),
            data : eDialog.find("#mform").serializeData(),
            success : function() {
              grid.jqGrid('setGridParam', {
                postData : {
                  jobId : eDialog.find("#jobId").val()
                }
              });
              grid.trigger("reloadGrid");
              eDialog.dialog('close');
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
              jobId : qDialog.find("#jobId").val()
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
    exeDialog.dialog({ //手動執行畫面
      height : 300,
      width : 500,
      modal : true,
      buttons : API.createJSON([ {
        key : i18n.def.sure,
        value : function() {
          $.ajax({
            url : url("batchshandler/jobExecute"),
            data : {
              jobId : exeDialog.find("#exeJobId").text(),
              jobParams : exeDialog.find("#jobParams").val()
            },
            success : function() {
              exeDialog.dialog('close');
              CommonAPI.showMessage(i18n['jobs']['msg.job.callrun']);
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
    $(".btns").find("#add").click(function() { //新增
      eDialog.dialog('open');
    }).end().find("#delete").click(function() { //刪除
      var ret = grid.getSelRowDatas();
      if (ret) {
        API.showConfirmMessage(i18n.def.actoin_001, function(data) {
          data && $.ajax({
            url : url("batchshandler/jobDelete"),
            data : {
              jobId : ret.jobId
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
    }).end().find("#jobLoad").click(function() { //重新註冊
      var ret = grid.getSelRowDatas();
      if (ret) {
        API.showConfirmMessage(i18n.def.actoin_001, function(data) {
          data && $.ajax({
            url : url("batchshandler/jobLoad"),
            data : {
              jobId : ret.jobId
            },
            success : function() {
              grid.trigger("reloadGrid");
            }
          });
        });
      } else {
        API.showErrorMessage(i18n.def.grid_selector);
      }
    }).end().find("#jobExe").click(function() {//手動執行
      var ret = grid.getSelRowDatas();
      if (ret) {
        exeDialog.dialog('open').find("#exeJobId").html(ret.jobId);
      } else {
        API.showErrorMessage(i18n.def.grid_selector);
      }
    });

    exeDialog.find("#jglp").click(function() {//取得最後一次的執行參數
      $.ajax({
        url : url("batchshandler/jobGetParam"),
        data : {
          jobId : exeDialog.find("#exeJobId").val()
        },
        success : function(r) {
          exeDialog.find("#jobParams").val(r.jobParams);
        }
      });
    });
  });
});

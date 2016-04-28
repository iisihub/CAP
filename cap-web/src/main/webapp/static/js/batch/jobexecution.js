pageInit(function() {
  $(document).ready(function() {
    var grid = $("#gridview").jqGrid({
      url : url('batchshandler/executinsQuery'),
      localFirst : true,
      sortname : 'START_TIME',
      sortorder : "desc",
      height : 350,
      colModel : [ {
        header : 'ID',
        name : 'JOB_EXECUTION_ID',
        width : 5
      }, {
        header : i18n['jobexecution']['jobId'],
        name : 'JOB_NAME',
        width : 20
      }, {
        header : i18n['jobexecution']['startDate'],
        name : 'startDate',
        index : 'START_TIME',
        width : 10,
        align : 'center',
        sortable : false
      }, {
        header : i18n['jobexecution']['startTime'],
        name : 'START_TIME',
        width : 10,
        align : 'center'
      }, {
        header : i18n['jobexecution']['duration'],
        name : 'duration',
        width : 10,
        align : 'center',
        sortable : false
      }, {
        header : i18n['jobexecution']['sch.jobStatus'],
        name : 'STATUS',
        width : 15,
        hidden : true
      }, {
        header : i18n['jobexecution']['sch.jobExitCode'],
        name : 'EXIT_CODE',
        width : 15
      }, {
        header : i18n['jobexecution']['executor'],
        name : 'EXECUTOR',
        width : 15
      }, {
        header : "preID",
        name : 'jobInsId',
        index : 'JOB_INSTANCE_ID',
        width : 5,
        formatter : function(val, obj, ret) {
          return (ret[0] == val) ? "" : val;
        }
      }, {
        name : 'JOB_INSTANCE_ID',
        hidden : true
      } ],
      ondblClickRow : function() {
        var ret = grid.getSelRowDatas();
        exeDetail.dialog('open')
        openExeDetail(ret.JOB_EXECUTION_ID, ret.JOB_INSTANCE_ID);
      }
    });
    var qDialog = $("#qryDailog");
    qDialog.dialog({ // 查詢畫面
      height : 200,
      width : 400,
      modal : true,
      open : function() {
        qDialog.find("#startDate").val(CommonAPI.getToday()).end().find("#startTime").val("00:00");
      },
      buttons : API.createJSON([ {
        key : i18n.def.sure,
        value : function() {
          grid.jqGrid('setGridParam', {
            postData : $.extend(qDialog.find("#qform").serializeData(), {
              jobInsId : ''
            })
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
    }).dialog('open');
    $(".btns").find("#qry").click(function() { // 查詢
      qDialog.dialog('open');
    }).end().find("#jobDetail").click(function() {// 檢視明細
      var ret = grid.getSelRowDatas();
      if (ret) {
        exeDetail.dialog('open');
        openExeDetail(ret.JOB_EXECUTION_ID, ret.JOB_INSTANCE_ID);
      } else {
        API.showErrorMessage(i18n.def.grid_selector);
      }
    }).end().find("#jobStop").click(function() { // 中斷執行
      var ret = grid.getSelRowDatas();
      if (ret) {
        $.ajax({
          url : url("batchshandler/executionStop"),
          data : {
            jobExeId : ret.JOB_EXECUTION_ID
          },
          success : function(je) {
            grid.jqGrid('setGridParam', {
              postData : {
                jobExeId : ret.JOB_EXECUTION_ID
              }
            });
            grid.trigger("reloadGrid");
          }
        });
      } else {
        API.showErrorMessage(i18n.def.grid_selector);
      }
    }).end().find("#jobRestart").click(function() { // 重新啟動
      var ret = grid.getSelRowDatas();
      if (ret) {
        $.ajax({
          url : url("batchshandler/executionRestart"),
          data : {
            jobId : ret.JOB_NAME,
            jobInsId : ret.JOB_INSTANCE_ID
          },
          success : function(je) {
            grid.jqGrid('setGridParam', {
              postData : {
                jobInsId : ret.JOB_INSTANCE_ID
              }
            });
            grid.trigger("reloadGrid");
          }
        });
      } else {
        API.showErrorMessage(i18n.def.grid_selector);
      }
    });

    var exeDetail = $("#exeDetailDialog");
    exeDetail.dialog({ // Job Execution Detail畫面
      height : 500,
      width : 650,
      modal : true,
      buttons : API.createJSON([ {
        key : i18n.def.close,
        value : function() {
          $(this).dialog('close');
        }
      } ]),
      close : function() {
        exeDetail.find("#jdform").reset();
        jdgrid.clearGridData();
      }
    });
    var openExeDetail = function(eid, instId) {
      $.ajax({
        url : url("batchshandler/executionDetail"),
        data : {
          jobExeId : eid,
          jobInstId : instId
        },
        success : function(je) {
          exeDetail.find("#jdform").injectData(je);
        }
      });
      jdgrid.jqGrid('setGridParam', {
        postData : {
          jobExeId : eid
        }
      }).iGridFitSize();
      jdgrid.trigger("reloadGrid");
    };
    var jdgrid = $("#jobDetailgrid").jqGrid({
      url : url('batchshandler/stepsQuery'),
      localFirst : true,
      // caption:i18n['jobexecution']['step.gridtit'],
      pager : false,
      height : 150,
      cmTemplate : {
        sortable : false
      },
      colModel : [ {
        header : i18n['jobexecution']['step.name'],
        name : 'STEP_NAME',
        width : 15
      }, {
        header : i18n['jobexecution']['step.read'],
        name : 'READ_COUNT',
        width : 5,
        formatter : 'integer',
        align : 'right'
      }, {
        header : i18n['jobexecution']['step.write'],
        name : 'WRITE_COUNT',
        width : 5,
        formatter : 'integer',
        align : 'right'
      }, {
        header : i18n['jobexecution']['step.commit'],
        name : 'COMMIT_COUNT',
        width : 5,
        formatter : 'integer',
        align : 'right'
      }, {
        header : i18n['jobexecution']['step.rollback'],
        name : 'ROLLBACK_COUNT',
        width : 5,
        formatter : 'integer',
        align : 'right'
      }, {
        header : i18n['jobexecution']['duration'],
        name : 'duration',
        width : 10,
        align : 'center'
      }, {
        header : i18n.def.status,
        name : 'EXIT_CODE',
        width : 10
      }, {
        name : 'EXIT_MESSAGE',
        hidden : true
      } ],
      ondblClickRow : function() {
        var ret = jdgrid.getSelRowDatas();
        ret.EXIT_MESSAGE && CommonAPI.showMessage(ret.EXIT_MESSAGE);
      }
    });
  });
});

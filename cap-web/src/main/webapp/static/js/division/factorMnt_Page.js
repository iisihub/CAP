pageInit(function() {
  $(document).ready(function() {
    // debugger;
    var _mainOid = reqJSON.mainOid;
    var _factorNo = reqJSON.factorNo;
    var mform = $("#mform");

    var ftDtlGrid = $("#ftDtlGrid").jqGrid({
      url : url('factorMntGridhandler/queryFactorDtlGridByFactorNo'),
      height : 150,
      autowidth : true,
      localFirst : true,
      // needPager : true,
      // multiselect: true,
      postData : {
        factorNo : $("#factorNo").val()
      },
      colModel : [ {
        header : i18n['factorMnt_Page']['rangeNm'],
        name : "rangeNm",
        align : "left",
        width : 20
      }, {
        header : i18n['factorMnt_Page']['range1'],
        name : "range1",
        align : "left",
        width : 10
      }, {
        header : i18n['factorMnt_Page']['range2'],
        name : "range2",
        align : "left",
        width : 10
      }, {
        header : i18n['factorMnt_Page']['rangesor'],
        name : "rangesor",
        align : "left",
        width : 10,
        hidden : true
      }, {
        header : i18n['factorMnt_Page']['rangeNo'],
        name : "rangeNo",
        hidden : true,
        width : 4
      }, {
        colHeader : "oid",
        name : "oid",
        hidden : true,
        width : 6
      } ]
    });
    // .addGridData([
    // ['逾期天數 1 ~ 30','1','30','1'],
    // ['逾期天數 31 ~ 60','31','60','2'],
    // ['逾期天數 61 ~ 90','61','90','3'],
    // ['逾期天數 91 ~180','91','180','4'],
    // ['逾期天數 181~','181','999999','5']
    // ]);

    $.ajax({
      url : url("factorMnthandler/query"),
      data : {
        mainOid : _mainOid,
        factorNo : _factorNo,
      },
      success : function(json) {
        mform.injectData(json);
        ftDtlGrid.jqGrid('setGridParam', {
          postData : {
            factorNo : mform.find("#factorNo").val()
          }
        });
        ftDtlGrid.trigger("reloadGrid");
      }
    });

    mform.find("#mod_btn").click(function() {
      // open dialog
      var selrow = ftDtlGrid.getGridParam('selrow');
      if (selrow) {
        var test = $("#dataType").val();
        if (test == "3") {
          $("#edit_dialog").find(".ftType1").hide();
          $("#edit_dialog").find(".ftType2").show();
        } else {
          $("#edit_dialog").find(".ftType1").show();
          $("#edit_dialog").find(".ftType2").hide();
        }
        fDialog.dialog('open');
        var index = ftDtlGrid.jqGrid('getInd', selrow);
        fDialog.find("#mod_colId").val(index);
      } else {
        CommonAPI.showErrorMessage("請先選擇要修改的資料");
      }
    }).end().find("#new_btn").click(function() {
      // open dialog
      var test = $("#dataType").val();
      if (test == "3") {
        $("#edit_dialog").find(".ftType1").hide();
        $("#edit_dialog").find(".ftType2").show();
      } else {
        $("#edit_dialog").find(".ftType1").show();
        $("#edit_dialog").find(".ftType2").hide();
      }
      fDialog.dialog('open');
    }).end().find("#del_btn").click(function() {
      ftDtlGrid.removeSelected();
    });
    $("#save_btn").click(function() {
      var xxxData = ftDtlGrid.serializeGridData();
      var ary = new Array(xxxData.length);
      var datas = $.extend({}, mform.serializeData());
      // debugger;
      for (var i = 0; i < ary.length; i++) {
        ary[i] = JSON.stringify(xxxData[i]);
      }
      var gridData = {
        grid : ary
      };
      $.extend(datas, gridData);
      /** 儲存 連後端儲存 */
      $.ajax({
        url : url("factorMnthandler/saveFactorDtl"),
        data : datas,
        success : function(json) {
          // ftDtlGrid.jqGrid('setGridParam', {
          // postData: {
          // factorNo:mform.find("#factorNo").val()
          // }
          // });
          // ftDtlGrid.trigger("reloadGrid");
          // CommonAPI.showPopMessage("儲存因子資料完成");
        }
      });
    });

    var fDialog = $("#edit_dialog");
    fDialog.dialog({
      height : 250,
      width : 650,
      modal : true,
      close : function() {
        fDialog.find("#facform").reset();
      },
      buttons : API.createJSON([ {
        key : i18n.def.sure,
        value : function() {
          // debugger;
          var facform = fDialog.find("#facform");
          var ftDtlGridRecords = ftDtlGrid.getGridParam("records");
          var _modId = fDialog.find("#mod_colId").val();
          var rowData = {};
          if (_modId) {
            rowData = ftDtlGrid.getSelRowDatas();
          }
          if (facform.find("#range1").val() && facform.find("#range2").val()) {
            rowData = {
              rangeNm : mform.find("#factorNm").val() + " " + facform.find("#range1").val() + "~" + facform.find("#range2").val(),
              range1 : facform.find("#range1").val(),
              range2 : facform.find("#range2").val()
            };
          } else if (facform.find("#range1").val()) {
            rowData = {
              rangeNm : mform.find("#factorNm").val() + " " + facform.find("#range1").val(),
              range1 : facform.find("#range1").val(),
              range2 : facform.find("#range2").val()
            };
          } else if (facform.find("#ftTypeBlnSel").val()) {
            var selVal = "(否)";
            if (facform.find("#ftTypeBlnSel").val() == "true") {
              selVal = "(是)";
            }
            rowData = {
              rangeNm : mform.find("#factorNm").val() + "" + selVal,
              range1 : facform.find("#ftTypeBlnSel").val()
            };
          }
          if (facform.validationEngine('validate')) {
            if (_modId) {
              ftDtlGrid.setRowData(_modId, rowData);
            } else {
              ftDtlGrid.addRowData(parseInt(ftDtlGridRecords) + 1, rowData);
            }
          }
          fDialog.dialog('close');
        }
      }, {
        key : i18n.def.close,
        value : function() {
          fDialog.dialog('close');
        }
      } ])
    });

  });
});
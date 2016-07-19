pageInit(function() {
  $(document).ready(function() {
    var mform = $("#mform");
    var _mainOid = reqJSON.mainOid;
    var _factorNo = reqJSON.factorNo;

    /**
     * form initial
     */
    $.ajax({
      url : url("conditionMnthandler/query"),
      data : {
        mainOid : _mainOid,
        factorNo : _factorNo,
      },
      success : function(d) {
        mform.injectData(d);
        cndtDtlGrid.jqGrid('setGridParam', {
          postData : {
            divCtNo : mform.find("#divCtNo").val()
          }
        });
        cndtDtlGrid.trigger("reloadGrid");
      }
    });

    var divFtSel = mform.find("#divFtSel");
    $.ajax({
      url : url("conditionMnthandler/getFtSelOption"),
      data : {
      // mainOid: _mainOid,
      // factorNo: _factorNo,
      },
      success : function(d) {
        divFtSel.setOptions(d);
      }
    });
    divFtSel.change(function() {
      ftRsGrid.jqGrid('setGridParam', {
        postData : {
          factorNo : divFtSel.val()
        }
      });
      ftRsGrid.trigger("reloadGrid");
    });

    /** 因子值域 */
    var ftRsGrid = $("#ftRsGrid").jqGrid({
      url : url("conditionMnthandler/queryFactorDetailByFactorNo"),
      height : '150',
      localFirst : true,
      rownumbers : true,
      needPager : false,
      // multiselect : true,
      postData : {
        factorNo : mform.find("#divFtSel").val()
      },
      colModel : [ {
        header : "值域註解",
        name : "rangeNm",
        align : "left",
        width : 10
      }, {
        header : "值域代號",
        name : "rangeNo",
        hidden : true
      }, {
        header : "因子代碼",
        name : "factorNo",
        hidden : true
      }, {
        header : "值域代號",
        name : "rangeNo",
        hidden : true
      }, {
        header : "因子名稱",
        name : "factorNm",
        hidden : true
      }, {
        name : "oid",
        hidden : true
      } ]
    });
    // .addGridData(
    // [ [ '逾期天數 1 ~ 30','A00001' ], [ '逾期天數 31 ~ 60','00002' ],
    // [ '逾期天數 61 ~ 90','00003' ], [ '逾期天數 91 ~180','00004' ],
    // [ '逾期天數 181~99999','00005' ] ]);

    /** 條件內的因子列表 */
    var cndtDtlGrid = $("#cndtDtlGrid").jqGrid({
      url : url('conditionMnthandler/queryConditionDtlGridByDivCtNo'),
      height : '150',
      width : '100%',
      rownumbers : true,
      multiselect : false,
      hideMultiselect : false,
      autowidth : true,
      localFirst : true,
      loadonce : true,
      sortname : 'divCtSor',
      colModel : [ {
        header : "條件項目",
        name : "factorNm",
        align : "left",
        width : 10
      }, {
        header : "條件內容",
        name : "rangeNm",
        align : "left",
        width : 40
      }, {
        header : "排序",
        name : "divCtSor",
        align : "left",
        width : 5
      }, {
        header : "因子代號",
        name : "factorNo",
        hidden : true
      }, {
        header : "值域代號",
        name : "rangeNo",
        hidden : true
      }, {
        name : "oid",
        hidden : true
      } ]
    });
    // .addGridData([
    // ['產品項目','信貸,信用卡','1'],
    // ['逾期天數','逾期天數 1 ~ 30','2',''],
    // ['逾期金額','100,000 ~ 5,000,000','3'],]);

    // 新增條件的因子列表中的一筆資料
    $("#add_btn").click(function() {
      var selrow = ftRsGrid.getGridParam('selrow');
      var records = cndtDtlGrid.getGridParam('records');
      if (selrow) {
        // show 規則組合
        var ret = ftRsGrid.getSelRowDatas();
        if (ret != null) {
          // debugger;
          var newRecord = new Array(5);
          newRecord[0] = ret.factorNm;
          newRecord[1] = ret.rangeNm;
          newRecord[2] = parseInt(records) + 1;
          newRecord[3] = mform.find("#divFtSel").val();
          newRecord[4] = ret.rangeNo;
          // newRecord[4] = oid;
          cndtDtlGrid.addGridData([ newRecord ]);
        }
        cndtDtlGrid.trigger("reload");
      } else {
        API.showPopMessage(i18n.conditionMnt_Page.cond0001);
        // alert("請先選取因子值域資料");
      }
    });

    // 移除條件的因子列表中的一筆資料
    $("#del_btn").click(function() {
      var selrow = cndtDtlGrid.getGridParam('selrow');
      if (selrow) {
        cndtDtlGrid.removeSelected();
        // cndtDtlGrid.trigger("reloadGrid");
      } else {
        API.showPopMessage(i18n.conditionMnt_Page.cond0001);
        // alert("請先選取一筆條件資料");
      }
    });

    /** 排序按鈕 */
    $("#up_btn").click(function() {
      var selrow = cndtDtlGrid.getGridParam('selrow');
      var records = cndtDtlGrid.getGridParam('records');
      if (selrow) {
        // debugger;
        var index = cndtDtlGrid.jqGrid('getInd', selrow);
        var selRet = cndtDtlGrid.getSelRowDatas();// xxxGrid[selrow-1];
        var orgSeq = selRet.divCtSor;
        // debugger;
        if (orgSeq > 1) {
          selRet.divCtSor = (parseInt(selRet.divCtSor) - 1);
          var xxxGrid = cndtDtlGrid.serializeGridData();
          cndtDtlGrid.clearGridData();
          xxxGrid[index - 1] = selRet;
          // 更新其他資料排序值
          for (var i = 1; i <= records; i++) {
            if (i != index) {
              var ret = xxxGrid[i - 1];
              var retSeq = parseInt(ret.divCtSor);
              if (ret != null && retSeq == selRet.divCtSor) {
                ret.divCtSor = (retSeq + 1);
                break;
              }
            }
          }
          selRet = null;
          cndtDtlGrid.addGridData(xxxGrid);
          cndtDtlGrid.trigger("reloadGrid");
        }
      } else {
        API.showPopMessage(i18n.conditionMnt_Page.cond0003);
        // alert("請先選取一筆條件資料");
      }
    });

    $("#dwn_btn").click(function() {
      var selrow = cndtDtlGrid.getGridParam('selrow');
      var records = cndtDtlGrid.getGridParam('records');
      if (selrow) {
        // debugger;
        var index = cndtDtlGrid.jqGrid('getInd', selrow);
        var selRet = cndtDtlGrid.getSelRowDatas();// xxxGrid[selrow-1];
        var orgSeq = selRet.divCtSor;
        // debugger;
        if (orgSeq < records) {
          selRet.divCtSor = (parseInt(selRet.divCtSor) + 1);
          var xxxGrid = cndtDtlGrid.serializeGridData();
          cndtDtlGrid.clearGridData();
          xxxGrid[index - 1] = selRet;
          // 更新其他資料排序值
          for (var i = records; i >= 1; i--) {
            if (i != index) {
              var ret = xxxGrid[i - 1];
              var retSeq = parseInt(ret.divCtSor);
              if (ret != null && retSeq == selRet.divCtSor) {
                ret.divCtSor = (retSeq - 1);
                break;
              }
            }
          }
          selRet = null;
          cndtDtlGrid.addGridData(xxxGrid);
          cndtDtlGrid.trigger("reloadGrid");
        }
      } else {
        API.showPopMessage(i18n.conditionMnt_Page.cond0003);
        //	    		alert("請先選取一筆條件資料");
      }
    });

    /**儲存*/
    $("#save_btn").click(function() {
      var xxxData = cndtDtlGrid.serializeGridData();
      var array = new Array(xxxData.length);
      var datas = $.extend({}, mform.serializeData());
      for (var i = 0; i < array.length; i++) {
        array[i] = JSON.stringify(xxxData[i]);
      }
      var gridData = {
        grid : array
      };
      $.extend(datas, gridData);
      /**儲存 連後端儲存*/
      $.ajax({
        url : url("conditionMnthandler/saveConditionDtl"),
        data : datas,
        success : function() {
        }
      });
    });
  });
});
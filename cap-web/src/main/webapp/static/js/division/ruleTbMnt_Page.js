pageInit(function() {
  $(document).ready(function() {
    var mform = $("#mform");
    var _mainOid = reqJSON.mainOid;
    var _divRlNo = reqJSON.divRlNo;

    /** 條件列表 */
    var conditionGrid = $("#conditionGrid").jqGrid({
      url : url("ruleTbMnthandler/queryConditionDetail"),
      height : '150',
      // localFirst : true,
      rownumbers : true,
      sortname : 'divCtNo',
      postData : {
        factorNo : mform.find("#divFtSel").val()
      },
      colModel : [ {
        header : "條件名稱",
        name : "divCtNm",
        align : "left",
        width : 10
      }, {
        header : "條件內容",
        name : "divCtCont",
        align : "left",
        width : 20
      }, {
        header : "分派組別",
        name : "divCtAction",
        align : "left",
        width : 5
      }, {
        name : "divCtNo",
        hidden : true
      }, {
        name : "factorNo",
        hidden : true
      }, {
        name : "rangeNo",
        hidden : true
      }, {
        name : "oid",
        hidden : true
      } ]
    });
    // .addGridData([
    // ['前置協商','產品項目 信貸; 逾期天數 1~30; 逾期金額 >100,00','協商組','10'],
    // ['前置協議','產品項目 信用卡; 逾期天數 1~30; 逾期金額 >500,00','協議組', '9'],
    // ['更新','產品項目 信貸; 逾期天數 30~60; 逾期金額 >100,00','電催組', '8'],
    // ['清算','產品項目 信貸; 逾期天數 60~120; 逾期金額 >100,00','法務組', '7'],
    // ['特殊分案','產品項目 信用卡; 逾期天數 >120; 逾期金額 100,00','委外組', '6']]);

    /** 規則表內容列表 */
    var ruleMapGrid = $("#ruleMapGrid").jqGrid({
      url : url('ruleTbMnthandler/queryRuleTbDetailByDivRlNo'),
      height : '150',
      width : '100%',
      rownumbers : true,
      autowidth : true,
      localFirst : true,
      loadonce : true,
      sortname : 'divRlSor',
      colModel : [ {
        header : "條件名稱",
        name : "divCtNm",
        align : "left",
        width : 10
      }, {
        header : "排序",
        name : "divRlSor",
        align : "left",
        width : 5
      }, {
        header : "條件代號",
        name : "divCtNo",
        hidden : true
      }, {
        header : "規則表代號",
        name : "divRlNo",
        hidden : true
      }, {
        header : "divCtOid",
        name : "divCtOid",
        hidden : true
      }, {
        name : "oid",
        hidden : true
      } ]
    });

    /**
     * form initial
     */
    $.ajax({
      url : url("ruleTbMnthandler/query"),
      data : {
        mainOid : _mainOid,
        divRlNo : _divRlNo,
      },
      success : function(d) {
        mform.injectData(d);
        ruleMapGrid.jqGrid('setGridParam', {
          postData : {
            divRlNo : mform.find("#divRlNo").val()
          }
        });
        ruleMapGrid.trigger("reloadGrid");
      }
    });

    // 新增條件的因子列表中的一筆資料
    $("#addRuleBtn").click(function() {
      var selrow = conditionGrid.getGridParam('selrow');
      var records = ruleMapGrid.getGridParam('records');
      if (selrow) {
        // show 規則組合
        var ret = conditionGrid.getSelRowDatas();
        if (ret != null) {
          // debugger;
          var newRecord = new Array(5);
          newRecord[0] = ret.divCtNm;
          newRecord[1] = parseInt(records) + 1;
          newRecord[2] = ret.divCtNo;
          newRecord[3] = mform.find("#divRlNo").val();
          newRecord[4] = ret.oid; // 存放DivCtItm.Oid
          ruleMapGrid.addGridData([ newRecord ]);
        }
        ruleMapGrid.trigger("reload");
      } else {
        API.showPopMessage(i18n.ruleTbMnt_Page.ruleTb0001);
      }
    });

    // 移除條件的因子列表中的一筆資料
    $("#removeBtn").click(function() {
      var selrow = ruleMapGrid.getGridParam('selrow');
      if (selrow) {
        ruleMapGrid.removeSelected();
        // ruleMapGrid.trigger("reloadGrid");
      } else {
        API.showPopMessage(i18n.ruleTbMnt_Page.ruleTb0003);
      }
    });

    /** 排序按鈕 */
    $("#up_btn").click(function() {
      var selrow = ruleMapGrid.getGridParam('selrow');
      var records = ruleMapGrid.getGridParam('records');
      if (selrow) {
        // debugger;
        var index = ruleMapGrid.jqGrid('getInd', selrow);
        var selRet = ruleMapGrid.getSelRowDatas();// xxxGrid[selrow-1];
        var orgSeq = selRet.divRlSor;
        // debugger;
        if (orgSeq > 1) {
          selRet.divRlSor = (parseInt(selRet.divRlSor) - 1);
          var xxxGrid = ruleMapGrid.serializeGridData();
          ruleMapGrid.clearGridData();
          xxxGrid[index - 1] = selRet;
          // 更新其他資料排序值
          for (var i = 1; i <= records; i++) {
            if (i != index) {
              var ret = xxxGrid[i - 1];
              var retSeq = parseInt(ret.divRlSor);
              if (ret != null && retSeq == selRet.divRlSor) {
                ret.divRlSor = (retSeq + 1);
                break;
              }
            }
          }
          selRet = null;
          ruleMapGrid.addGridData(xxxGrid);
          ruleMapGrid.trigger("reloadGrid");
        }
      } else {
        API.showPopMessage(i18n.ruleTbMnt_Page.ruleTb0002);
      }
    });

    $("#dwn_btn").click(function() {
      var selrow = ruleMapGrid.getGridParam('selrow');
      var records = ruleMapGrid.getGridParam('records');
      if (selrow) {
        // debugger;
        var index = ruleMapGrid.jqGrid('getInd', selrow);
        var selRet = ruleMapGrid.getSelRowDatas();// xxxGrid[selrow-1];
        var orgSeq = selRet.divRlSor;
        // debugger;
        if (orgSeq < records) {
          selRet.divRlSor = (parseInt(selRet.divRlSor) + 1);
          var xxxGrid = ruleMapGrid.serializeGridData();
          ruleMapGrid.clearGridData();
          xxxGrid[index - 1] = selRet;
          // 更新其他資料排序值
          for (var i = records; i >= 1; i--) {
            if (i != index) {
              var ret = xxxGrid[i - 1];
              var retSeq = parseInt(ret.divRlSor);
              if (ret != null && retSeq == selRet.divRlSor) {
                ret.divRlSor = (retSeq - 1);
                break;
              }
            }
          }
          selRet = null;
          ruleMapGrid.addGridData(xxxGrid);
          ruleMapGrid.trigger("reloadGrid");
        }
      } else {
        API.showPopMessage(i18n.ruleTbMnt_Page.ruleTb0002);
      }
    });

    /** 儲存 */
    $("#save_btn").click(function() {
      var xxxData = ruleMapGrid.serializeGridData();
      var array = new Array(xxxData.length);
      var datas = $.extend({}, mform.serializeData());
      for (var i = 0; i < array.length; i++) {
        array[i] = JSON.stringify(xxxData[i]);
      }
      var gridData = {
        grid : array
      };
      $.extend(datas, gridData);
      /** 儲存 連後端儲存 */
      $.ajax({
        url : url("ruleTbMnthandler/saveRuleTbDtl"),
        data : datas,
        success : function() {
        }
      });
    });

    /**匯出RuleTable-->DecisionTable*/
    $("#dwnload").click(function() {
      $.capFileDownload({
        url : url("ruleTbMnthandler/dwnload"),
        data : {
          divRlNo : _divRlNo,
          oid : _mainOid
        }
      });
    });

    /**試算*/
    $("#testDrools").click(function() {
      $.ajax({
        url : url("ruleTbMnthandler/testDrools"),
        data : {
          divRlNo : _divRlNo,
          oid : _mainOid,
        },
        ajaxTimeOut : 60000 * 1000 * 3, // timeOut: 180
        success : function(d) {
          d.tMsg && CommonAPI.showPopMessage(d.tMsg);
        }
      });
    });
  });
});
pageInit(function() {
  $(document).ready(function() {
    var mform = $("#mform");
    var grid = $("#gridview").jqGrid({
      // handler : 'factorMnthandler',
      url : url('factorMntGridhandler/queryFactorItmGridByFactorNo'),
      height : "380",
      width : "100%",
      rownumbers : true,
      // localFirst: true,
      sortname : 'factorNo',
      // postData :{factorNo : mform.find("#factorNo")},
      colModel : [ {
        header : i18n['factorMnt']['factorCode'],
        name : "factorNo",
        align : "left",
        width : 5
      }, {
        header : i18n['factorMnt']['factorNm'],
        name : "factorNm",
        align : "left",
        width : 15
      }, {
        header : i18n['factorMnt']['summary'],
        name : "rangeNm",
        align : "left",
        width : 50
      }, {
        name : "oid",
        hidden : true
      } ]
    });
    // .addGridData([['A00001','逾期金額','']
    // ,['B00002','逾期天數','']
    // ,['C00003','承諾繳款','']
    // ,['D00004','協議註記','']
    // ,['E00005','特殊註記','']]);

    function openDoc(cellvalue, options, rowObject) {
      CommonAPI.formSubmit({
        url : './division/factorMnt_Page',
        data : {
          mainOid : rowObject.oid,
          factorNo : rowObject.factorNo
        },
        target : "_blank"// rowObject.oid
      });
    }
    ;

    // 查詢
    $("#qry").click(function() {
      grid.jqGrid('setGridParam', {
        postData : {}
      });
      grid.trigger("reloadGrid");
    });
    // 新增
    $("#add").click(function() {
      CommonAPI.formSubmit({
        data : {
          type : 'A'
        },
        url : './division/factorMnt_Page',
        target : "_blank"
      });
    });

    // 修改
    $("#modify").click(function() {
      var selrow = $("#gridview").getSelRowDatas();
      if (selrow) {
        openDoc('', '', selrow);
      } else {
        CommonAPI.showErrorMessage("請先選擇要修改的資料");
      }
    });
    // 刪除
    $("#delete").click(function() {
      var selrow = $("#gridview").getSelRowDatas();
      if (selrow) {
        var _factNo = selrow.factorNo;
        $.ajax({
          data : {
            oid : selrow.oid
          },
          url : url("factorMnthandler/delete"),
          success : function() {
            CommonAPI.showPopMessage("因子資料" + _factNo + "刪除完成");
            grid.trigger("reloadGrid");
          }
        });
      } else {
        CommonAPI.showErrorMessage("請先選擇要修改的資料");
      }
    });
    // insert 測試資料
    $("#insertTestCases").click(function() {
      $.ajax({
        data : {
          ftItmNos : [ 1, 2, 3, 4 ]
        },
        url : url("factorMnthandler/insertTestCases"),
        success : function() {
          CommonAPI.showPopMessage(" test insert action");
        }
      });
    });
  });
});

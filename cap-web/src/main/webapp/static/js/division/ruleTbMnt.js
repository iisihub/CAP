pageInit(function() {
  $(document).ready(function() {
    var mform = $("#mform");
    var grid = $("#gridview").jqGrid({
      url : url("ruleTbMnthandler/queryRuleItmByDivRlNo"),
      height : "380",
      width : "100%",
      rownumbers : true,
      // autowidth: true,
      // localFirst: true,
      colModel : [ {
        header : i18n['ruleTbMnt']['divRlNm'],
        name : "divRlNm",
        align : "left",
        width : 10
      }, {
        header : i18n['ruleTbMnt']['ruleCont'],
        name : "ruleCont",
        align : "left",
        width : 50
      }, {
        header : i18n['ruleTbMnt']['classify'],
        name : "classify",
        align : "left",
        width : 10
      }, {
        header : i18n['ruleTbMnt']['divRlNo'],
        name : "divRlNo",
        align : "left",
        width : 10
      }, {
        name : "oid",
        hidden : true,
        width : 5
      } ]
    });
    // .addGridData([['大型分案規則表','M0新件分案,回沖分案,月底分案,月初分案,馬上分案','件數平均','R000001']
    // ,['特殊案件規則表','M0新件分案,回沖分案,處分分案','件數平均','R000002']
    // ,['一般案件規則表','M0新件分案,回沖分案,月底分案,月初分案','金額平均','R000003']]);

    function openDoc(cellvalue, options, rowObject) {
      CommonAPI.formSubmit({
        url : './division/ruleTbMnt_Page',
        data : {
          mainOid : rowObject.oid,
          divRlNo : rowObject.divRlNo
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
        url : './division/ruleTbMnt_Page',
        target : "_blank"
      });
    });

    // 修改
    $("#modify").click(function() {
      var selrow = grid.getSelRowDatas();
      if (selrow) {
        openDoc('', '', selrow);
      } else {
        CommonAPI.showErrorMessage("請先選擇要修改的資料");
      }
    });

    // 刪除
    $("#delete").click(function() {
      var selrow = grid.getSelRowDatas();
      if (selrow) {
        var _Nm = selrow.divRlNm;
        $.ajax({
          data : {
            oid : selrow.oid
          },
          url : url("ruleTbMnthandler/delete"),
          success : function() {
            grid.trigger("reloadGrid");
          }
        });
      } else {
        CommonAPI.showErrorMessage("請先選擇要修改的資料");
      }
    });

  });
});
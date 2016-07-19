pageInit(function() {
  $(document).ready(function() {
    var mform = $("#mform");
    var grid = $("#gridview").jqGrid({
      url : url('functionsethandler/query'),
      height : "380",
      width : "100%",
      multiselect : false,
      hideMultiselect : false,
      autowidth : true,
      localFirst : true,
      colModel : [ {
        header : i18n['funcSet']['funccode'],//"功能代號",
        name : 'code',
        align : "center",
        width : 60,
        sortable : false
      }, {
        header : i18n['funcSet']['funcname'],//"功能名稱",
        name : 'name',
        align : "left",
        width : 150,
        sortable : true
      }, {
        header : i18n['funcSet']['funcdesc'],//"備註",
        name : 'desc',
        align : "left",
        width : 200,
        sortable : true
      }, {
        header : i18n['funcSet']['funclevel'],//"功能階層",
        name : 'level',
        align : "center",
        width : 60,
        sortable : true
      }, {
        header : i18n['funcSet']['funcsequence'],//"排列順序",
        name : 'sequence',
        align : "center",
        width : 60,
        sortable : true
      }, {
        header : i18n['funcSet']['funcsysType'],//"系統別",
        name : 'SYSNAME',
        index : 'sysType',
        align : "center",
        width : 150,
        sortable : true
      }, {
        name : 'sysType',
        hidden : true
      } ],
      ondblClickRow : function() {
        openEditWindow(true);
      }
    });
    function openEditWindow(isEdit, rowObject) {
      if (isEdit) {
        if (!rowObject) {
          var id = grid.jqGrid('getGridParam', 'selrow');
          if (id) {
            rowObject = grid.jqGrid('getRowData', id);
          } else {
            API.showMessage(i18n.def['selectd.msg']);
            return;
          }
        }
      }
      CommonAPI.formSubmit({
        url : './system/funcSet_Page',
        data : {
          pgmCode : rowObject ? rowObject.code : ""
        },
        target : rowObject ? rowObject.code : "_blank"//rowObject.oid
      });
    }
    function openSearchWindow() {
      var search = $("#SEARCH").dialog({
        title : i18n.def['query'],
        width : 400,
        height : 220,
        modal : true,
        buttons : API.createJSON([ {
          key : i18n.def.sure,
          value : function() {
            grid.jqGrid('setGridParam', {
              postData : search.find("#searchForm").serializeData()
            });
            grid.trigger("reloadGrid");
            search.dialog('close');
          }
        }, {
          key : i18n.def.close,
          value : function() {
            search.dialog('close');
          }
        } ])
      });
      search.dialog('open');
    }

    $(".btns").find("#qry").click(function() {//查詢
      openSearchWindow();
    }).end().find("#add").click(function() {//新增
      openEditWindow(false);
    }).end().find("#modify").click(function() {//修改
      openEditWindow(true);
    }).end().find("#delete").click(function() {
      var id = grid.jqGrid('getGridParam', 'selrow');
      if (id) {
        var rowObject = grid.jqGrid('getRowData', id);
        API.showConfirmMessage(i18n.def['del.confrim'], function(b) {
          if (b) {
            $.ajax({
              url : url('functionsethandler/delete'),
              data : {
                code : rowObject.code
              },
              success : function(responseData) {
                grid.trigger("reloadGrid");
              }
            });
          }
        });
      } else {
        API.showMessage(i18n.def['selectd.msg']);
      }
    });
    $(".btns").find("#qry").trigger("click");
  });
});
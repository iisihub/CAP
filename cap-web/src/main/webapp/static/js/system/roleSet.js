pageInit(function() {
  $(document).ready(function() {
    var mform = $("#mform");
    var grid = $("#gridview").jqGrid({
      url : url('rolesethandler/query'),
      height : "380",
      width : "100%",
      multiselect : false,
      hideMultiselect : false,
      autowidth : true,
      localFirst : false,
      colModel : [ {
        header : i18n['roleSet']['rolecode'],//"角色代碼",
        name : 'code',
        align : "left",
        width : 15,
        sortable : false
      }, {
        header : i18n['roleSet']['rolename'],//"角色名稱
        name : 'name',
        align : "left",
        width : 15,
        sortable : true
      }, {
        header : i18n['roleSet']['usercount'],//"使用人員數
        name : 'userCount',
        align : "center",
        width : 10,
        sortable : true
      }, {
        header : i18n['roleSet']['rolestatus'],//"停用
        name : 'status',
        align : "center",
        width : 5,
        sortable : true,
        formatter : function(val) {
          return i18n['roleSet']['rolestatus.' + val];
        }
      }, {
        header : i18n['roleSet']['roledesc'],//"停用原因
        name : 'desc',
        align : "center",
        width : 15,
        sortable : true
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
        url : './system/roleSet_Page',
        data : {
          code : rowObject ? rowObject.code : ""
        },
        target : rowObject ? rowObject.code : "_blank"//rowObject.oid
      });
    }

    $(".btns").find("#add").click(function() {//新增
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
              url : url('rolesethandler/delete'),
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
  });
});
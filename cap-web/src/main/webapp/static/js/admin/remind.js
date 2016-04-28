pageInit(function() {
  $(document).ready(function() {
    var mform = $("#mform");
    var grid = $("#gridview").jqGrid({
      url : url("remindhandler/query"),
      height : "380",
      width : "100%",
      multiselect : false,
      hideMultiselect : false,
      autowidth : true,
      localFirst : false,
      colModel : [ {
        header : i18n['remind']['startDate'],//"日期",
        name : 'startDate',
        align : "left",
        width : 10,
        sortable : false
      }, {
        header : i18n['remind']['content'],//"提醒事項
        name : 'content',
        align : "left",
        width : 45,
        sortable : true
      }, {
        name : 'oid',
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
        url : './admin/remind_Page',
        data : {
          oid : rowObject ? rowObject.oid : ""
        },
        target : rowObject ? rowObject.oid : "_blank"//rowObject.oid
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
              url : url("remindhandler/delete"),
              data : {
                oid : rowObject.oid
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
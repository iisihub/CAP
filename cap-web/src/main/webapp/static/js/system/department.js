pageInit(function() {
  $(document).ready(function() {
    var mform = $("#mform");
    var grid = $("#gridview").jqGrid({
      url : url('departmenthandler/query'),
      height : "380",
      width : "100%",
      multiselect : false,
      hideMultiselect : false,
      autowidth : true,
      localFirst : false,
      colModel : [ {
        header : i18n['department']['depcode'],//"單位代碼",
        name : 'code',
        align : "left",
        width : 10,
        sortable : true,
        formatter : 'click',
        onclick : doEdit,
        sortable : true
      }, {
        header : i18n['department']['depname'],//"單位名稱",
        name : 'name',
        align : "left",
        width : 15,
        sortable : true
      }, {
        header : i18n['department']['depproxy'],//"法定代理人",
        name : 'proxy',
        align : "left",
        width : 15
      }, {
        header : i18n['department']['depmanager'],//"單位經理",
        name : 'manager',
        align : 'left',
        width : 15,
        sortable : false
      }, {
        header : i18n['department']['depaddr'],//"地址",
        name : 'addr',
        align : 'left',
        width : 35,
        sortable : false
      }, {
        name : 'oid',
        hidden : true
      }, {
        name : 'zip',
        hidden : true
      }, {
        name : 'status',
        hidden : true
      }, {
        name : 'tel',
        hidden : true
      } ],
      ondblClickRow : function() {
        openEditWindow(true);
      }
    });
    function doEdit(cellvalue, options, rowObject) {
      openEditWindow(true, rowObject);
    }
    function openEditWindow(isEdit, rowObject) {
      var $form = $('#JForm');
      $form.reset();

      var oid = '';
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
        oid = rowObject.oid;
        $form.find('#code').attr("disabled", true);
        $form.injectData(rowObject);
      } else {
        $form.find('input').empty().removeAttr('disabled').removeAttr('checked');
      }
      var edit = $("#EDIT").dialog({
        title : i18n.def['edit'], // 編輯
        modal : true,
        width : 800,
        height : 300,
        valign : "bottom",
        align : 'center',
        buttons : API.createJSON([ {
          key : i18n.def.sure,
          value : function() {
            if ($form.validationEngine('validate')) {
              $.ajax({
                url : url('departmenthandler/save'),
                data : $.extend($form.serializeData(), {
                  oid : oid
                }),
                success : function(responseData) {
                  if (responseData.exist) {
                    edit.dialog('close');
                    API.showMessage(i18n.def['data.exists']);
                  } else {
                    grid.trigger("reloadGrid");
                  }
                }
              });
            }
            edit.dialog('close');
          }
        }, {
          key : i18n.def.close,
          value : function() {
            edit.dialog('close');
          }
        } ])
      });
      edit.dialog('open');
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
              url : url('departmenthandler/delete'),
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
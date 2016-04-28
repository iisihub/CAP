pageInit(function() {
  $(document).ready(function() {
    var mform = $("#mform");
    var grid = $("#gridview").jqGrid({
      url : url('errorCodehandler/query'),
      height : "380",
      width : "100%",
      multiselect : false,
      hideMultiselect : false,
      autowidth : true,
      localFirst : true,
      colModel : [ {
        header : i18n['errorCode']['code'],//"訊息代碼",
        name : 'code',
        align : 'left',
        width : 120,
        formatter : 'click',
        onclick : doEdit,
        sortable : true
      }, {
        header : i18n['errorCode']['locale'],//"語言別",
        name : 'locale',
        align : 'center',
        width : 60,
        sortable : false
      //            },  {
      //                header: i18n['errorCode']['sysId'],//"系統別",
      //                name: 'sysId', align: 'center', width: 60, sortable: true
      }, {
        header : i18n['errorCode']['severity'],//"等級",
        name : 'severity',
        align : 'left',
        width : 60,
        sortable : false
      }, {
        header : i18n['errorCode']['message'],//"狀態說明",
        name : 'message',
        align : 'left',
        width : 250,
        sortable : false
      }, {
        header : i18n['errorCode']['suggestion'],//"建議處理方式",
        name : 'suggestion',
        align : 'left',
        width : 300,
        sortable : false
      }, {
        name : 'sendMon',
        hidden : true
      }, {
        name : 'helpURL',
        hidden : true
      }, {
        name : 'oid',
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
        $form.find('#code').val(rowObject.code).attr("disabled", true);
        $form.find('#locale').val(rowObject.locale).attr("disabled", true);
        $form.find('#severity').val(rowObject.severity);
        $form.find('#message').val(rowObject.message);
        $form.find('#suggestion').text(rowObject.suggestion);
        $form.find('#sendMon').val(rowObject.sendMon);
        $form.find('#helpURL').val(rowObject.helpURL);
        $form.find('#sysId').val(rowObject.sysId);
      } else {
        $form.find('#code').val('').removeAttr("disabled");
        $form.find('#locale').val('').removeAttr("disabled");
        $form.find('#message').val('');
        $form.find('#suggestion').text('');
      }
      var edit = $("#EDIT").dialog({
        title : i18n.def['edit'], // 編輯
        modal : true,
        width : 600,
        height : 400,
        valign : "bottom",
        align : 'center',
        buttons : API.createJSON([ {
          key : i18n.def.sure,
          value : function() {
            if ($form.validationEngine('validate')) {
              $.ajax({
                url : url('errorCodehandler/save'),
                data : $.extend($form.serializeData(), {
                  oid : oid
                }),
                success : function(responseData) {
                  edit.dialog('close');
                  if (responseData.exist) {
                    API.showMessage(i18n.def['data.exists']);
                  } else {
                    grid.trigger("reloadGrid");
                  }
                }
              });
            }
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
    function openSearchWindow() {
      var search = $("#SEARCH").dialog({
        title : i18n.def['query'],
        width : 400,
        height : 200,
        modal : true,
        buttons : API.createJSON([ {
          key : i18n.def.sure,
          value : function() {
            grid.jqGrid('setGridParam', {
              postData : {
                code : search.find("#code").val(),
                locale : search.find("#locale").val(),
                sysId : search.find("#sysId").val()
              }
            });
            grid.trigger("reloadGrid");
            search.dialog('close');
          }
        }, {
          key : i18n.def.clear,
          value : function() {
            $("#searchForm").reset();
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
              url : url('errorCodehandler/delete'),
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
    $(".btns").find("#qry").trigger("click");
  });
});
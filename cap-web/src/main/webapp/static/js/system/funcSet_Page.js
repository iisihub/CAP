pageInit(function() {
  $(document).ready(function() {
    var $form = $("#JForm");
    var code = reqJSON.pgmCode;
    var isNew = code ? false : true;
    var changeCode = function() {
      var systyp = $form.find("#sysCode").find("option[showvalue='" + $form.find('#sysType').val() + "']").attr('value');
      var type = $form.find('#level').val();
      var code = $form.find('#FUNCCODE').val();
      $form.find('#FUNC').html(systyp + type);
      $form.find('#code').val(systyp + type + code);
    }
    var getParentCode = function(value) {
      $.ajax({
        url : url('functionsethandler/loadFunc'),
        data : {
          sysType : $form.find('#sysType').val(),
          level : $form.find('#level').val() - 1
        },
        success : function(responseData) {
          var items = {};
          if ($form.find('#level').val() == '1') {
            items['0'] = i18n['funcSet_Page']['level0'];
          } else if (responseData.functions.length > 0) {
            var size = responseData.functions.length;
            for (var i = 0; i < size; i++) {
              var data = responseData.functions[i];
              items[data.code] = data.name;
            }
            data = responseData.functions[0];
          } else {
            items[''] = i18n['funcSet_Page']['nooption'];
          }
          $form.find('#parent').setOptions(items);
          value && $form.find('select[name=parent]').val(value);
        }// close success function
      });
    }
    var grid = $form.find("#gridview").jqGrid({
      url : url('functionsethandler/queryRole'),
      height : "380",
      width : "100%",
      pager : false,
      postData : {
        sysType : '',
        code : code
      },
      multiselect : true,
      hideMultiselect : false,
      autowidth : true,
      localFirst : true,
      colModel : [ {
        header : i18n['funcSet_Page']['rolecode'],// "角色代碼",
        name : 'code',
        align : "center",
        sortable : false
      }, {
        header : i18n['funcSet_Page']['rolename'],// "角色名稱",
        name : 'name',
        align : "left",
        sortable : true
      } ]
    });
    var init = function() {
      $form.find('#sysType').attr('disabled', !isNew);
      $form.find('#level').attr('disabled', !isNew);
      $form.find('#FUNCCODE')[isNew ? "show" : "hide"]();
      $form.find('#FUNC').html(code);
    }
    if (code) {
      $.ajax({
        url : url("functionsethandler/queryForm"),
        data : {
          code : code
        },
        success : function(json) {
          $form.injectData(json);
          init();
          getParentCode(json.parent);
          grid.jqGrid('setGridParam', {
            postData : {
              sysType : json.sysType
            }
          });
          grid.trigger("reloadGrid");
        }
      });
    } else {
      init();
      changeCode();
      getParentCode();
    }

    $form.find("#level,#sysType").change(function() {
      changeCode();
      getParentCode();
    }).end().find("#FUNCCODE").blur(function() {
      changeCode();
    });

    $("#save_btn").click(function() {// 新增
      API.showConfirmMessage(i18n.def.actoin_001, function(data) {
        data && save();
      });
    });

    var gridRole = $("#gridviewRole").jqGrid({
      url : url('functionsethandler/queryAllRole'),
      height : "220",
      width : "620",
      pager : false,
      postData : {
        sysType : '',
        code : code
      },
      multiselect : true,
      hideMultiselect : false,
      autowidth : false,
      localFirst : true,
      pager : false,
      colModel : [ {
        header : i18n['funcSet_Page']['rolecode'],// "角色代碼",
        name : 'code',
        align : "center",
        sortable : false
      }, {
        header : i18n['funcSet_Page']['rolename'],// "角色名稱",
        name : 'name',
        align : "left",
        sortable : true
      } ]
    });
    var eDialog = $("#editRole").dialog({
      height : 400,
      width : 650,
      modal : true,
      open : function() {
        gridRole.jqGrid('setGridParam', {
          postData : {
            code : code,
            sysType : $form.find('#sysType').val()
          }
        });
        gridRole.trigger("reloadGrid");
      },
      close : function() {
        gridRole.clearGridData(true);
      },
      buttons : API.createJSON([ {
        key : i18n.def.sure,
        value : function() {
          if (gridRole.getSelRowDatas()) {
            $.ajax({
              url : url("functionsethandler/saveRfList"),
              data : {
                code : code,
                roleItem : JSON.stringify(gridRole.getSelRowDatas())
              },
              success : function(rtn) {
                grid.jqGrid('setGridParam', {
                  postData : {
                    code : code,
                    sysType : $form.find("#sysType").val()
                  }
                });
                grid.trigger("reloadGrid");
                eDialog.dialog('close');
                API.showMessage(i18n.def['addSuccess']);
              }
            });
          } else {
            API.showConfirmMessage(i18n.def['selectd.msg']);
          }
        }
      }, {
        key : i18n.def.close,
        value : function() {
          eDialog.dialog('close');
        }
      } ])
    });
    $("#btns").find("#add").click(function() {// 新增
      if (isNew) {
        API.showConfirmMessage(i18n.def.saveBeforeAction, function(data) {
          data && save({
            done : function() {
              eDialog.dialog('open')
            }
          });
        });
      } else {
        eDialog.dialog('open');
      }
    }).end().find("#delete").click(function() {// 刪除
      if (grid.getSelRowDatas()) {
        $.ajax({
          url : url("functionsethandler/deleteRfList"),
          data : {
            code : code,
            roleItem : JSON.stringify(grid.getSelRowDatas())
          },
          success : function(rtn) {
            grid.jqGrid('setGridParam', {
              postData : {
                code : code,
                sysType : $form.find("#sysType").val()
              }
            });
            grid.trigger("reloadGrid");
            API.showMessage(i18n.def['deleteSuccess']);
          }
        });
      } else {
        API.showConfirmMessage(i18n.def['selectd.msg']);
      }
    });

    var save = function(action) {
      $form.validationEngine('validate') && $.ajax({
        url : url("functionsethandler/save"),
        data : $.extend($form.serializeData(), {
          isNew : isNew
        }),
        success : function(rtn) {
          code = reqJSON.code = $form.find("#code").val();
          isNew = false;
          init();
          API.triggerOpener();
          API.showMessage(i18n.def['saveSuccess'], action && action.done && action.done());
        }
      });
    }
  });
});
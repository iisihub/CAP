pageInit(function() {
  $(document).ready(function() {
    var $form = $("#JForm");
    var code = reqJSON.code;
    var isNew = code ? false : true;

    var gridUsr = $("#gridview_usr").jqGrid({
      url : url('rolesethandler/queryGridUser'),
      height : "180",
      width : "100%",
      pager : false,
      postData : {
        code : code
      },
      multiselect : true,
      hideMultiselect : false,
      autowidth : true,
      localFirst : true,
      colModel : [ {
        header : i18n['roleSet_Page']['usercode'],//"使用者代號",
        name : 'userCode',
        align : "left",
        sortable : true
      }, {
        header : i18n['roleSet_Page']['username'],//"姓名
        name : 'userName',
        align : "left",
        sortable : true
      }, {
        header : i18n['roleSet_Page']['depcode'],//"部門代號
        name : 'depCode',
        align : "left",
        sortable : true
      }, {
        header : i18n['roleSet_Page']['depname'],//"部門名稱
        name : 'depName',
        align : "left",
        sortable : true
      } ]
    });
    var gridFunc = $("#gridview_func").jqGrid({
      url : url('rolesethandler/queryGridFunc'),
      height : "180",
      width : "100%",
      pager : false,
      postData : {
        code : code
      },
      multiselect : true,
      hideMultiselect : false,
      autowidth : true,
      localFirst : true,
      colModel : [ {
        header : i18n['roleSet_Page']['funccode'],//"功能代碼
        name : 'code',
        align : "left",
        sortable : true
      }, {
        header : i18n['roleSet_Page']['funcname'],//"功能名稱
        name : 'name',
        align : "left",
        sortable : true
      }, {
        header : i18n['roleSet_Page']['funcparent'],//"上層功能代碼
        name : 'parent',
        align : "left",
        sortable : true
      } ]
    });
    var init = function() {
      $form.find('#code').attr('disabled', !isNew);
      $form.find('#sysType').attr('disabled', !isNew);
    }
    if (code) {
      $.ajax({
        url : url("rolesethandler/queryForm"),
        data : {
          code : code
        },
        success : function(json) {
          $form.injectData(json);
          init();
          gridUsr.trigger("reloadGrid");
          gridFunc.trigger("reloadGrid");
        }
      });
    } else {
      init();
    }

    //角色
    $("#save_btn").click(function() {//新增
      API.showConfirmMessage(i18n.def.actoin_001, function(data) {
        data && save();
      });
    });
    //人員
    var gridEditUsr = $("#gridviewUsr").jqGrid({
      url : url('rolesethandler/queryEditUsr'),
      height : "220",
      width : "550",
      pager : false,
      postData : {
        depCode : '',
        roleCode : code
      },
      multiselect : true,
      hideMultiselect : false,
      autowidth : false,
      localFirst : true,
      pager : false,
      colModel : [ {
        header : i18n['roleSet_Page']['usercode'],//"使用者代號",
        name : 'code',
        align : "left",
        sortable : true
      }, {
        header : i18n['roleSet_Page']['username'],//"姓名
        name : 'name',
        align : "left",
        sortable : true
      } ]
    });
    var eDialog = $("#editUsr").dialog({
      height : 440,
      width : 600,
      modal : true,
      open : function() {
        var form = eDialog.find("#mform");
        $.ajax({
          url : url("rolesethandler/getAllDepartment"),
          success : function(json) {
            form.find("#department").setOptions(json);
          }
        });
        form.find("#query").click(function() {//查詢
          gridEditUsr.jqGrid('setGridParam', {
            postData : {
              roleCode : code,
              depCode : form.find('#department').val()
            }
          });
          gridEditUsr.trigger("reloadGrid");
        });
      },
      close : function() {
        gridEditUsr.clearGridData(true);
      },
      buttons : API.createJSON([ {
        key : i18n.def.sure,
        value : function() {
          if (gridEditUsr.getSelRowDatas()) {
            $.ajax({
              url : url("rolesethandler/saveUrList"),
              data : {
                code : code,
                users : JSON.stringify(gridEditUsr.getSelRowDatas())
              },
              success : function(rtn) {
                gridUsr.jqGrid('setGridParam', {
                  postData : {
                    code : code
                  }
                });
                gridUsr.trigger("reloadGrid");
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

    $("#btns_usr").find("#add").click(function() {//新增
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
    }).end().find("#delete").click(function() {//刪除
      if (gridUsr.getSelRowDatas()) {
        $.ajax({
          url : url("rolesethandler/deleteUrList"),
          data : {
            code : code,
            users : JSON.stringify(gridUsr.getSelRowDatas())
          },
          success : function(rtn) {
            gridUsr.jqGrid('setGridParam', {
              postData : {
                code : code
              }
            });
            gridUsr.trigger("reloadGrid");
            API.showMessage(i18n.def['deleteSuccess']);
          }
        });
      } else {
        API.showConfirmMessage(i18n.def['selectd.msg']);
      }
    });
    //權限
    var gridEditFunc = $("#gridviewFunc").jqGrid({
      url : url('rolesethandler/queryEditFunc'),
      height : "220",
      width : "550",
      pager : false,
      postData : {
        parent : '',
        code : code
      },
      multiselect : true,
      hideMultiselect : false,
      autowidth : false,
      localFirst : true,
      pager : false,
      colModel : [ {
        header : i18n['roleSet_Page']['funccode'],//"功能代碼
        name : 'code',
        align : "left",
        sortable : true
      }, {
        header : i18n['roleSet_Page']['funcname'],//"功能名稱
        name : 'name',
        align : "left",
        sortable : true
      }, {
        header : i18n['roleSet_Page']['funcparent'],//"上層功能代碼
        name : 'parent',
        align : "left",
        sortable : true
      } ]
    });
    var pDialog = $("#editFunc").dialog({
      height : 440,
      width : 600,
      modal : true,
      open : function() {
        var form = pDialog.find("#mform");
        $.ajax({
          url : url("rolesethandler/getAllFunc"),
          data : {
            sysType : $form.find("#sysType").val()
          },
          success : function(json) {
            form.find("#parent").setOptions(json);
          }
        });
        form.find("#query").click(function() {//查詢
          gridEditFunc.jqGrid('setGridParam', {
            postData : {
              code : code,
              sysType : $form.find("#sysType").val(),
              parent : form.find('#parent').val()
            }
          });
          gridEditFunc.trigger("reloadGrid");
        });
      },
      close : function() {
        gridEditFunc.clearGridData(true);
      },
      buttons : API.createJSON([ {
        key : i18n.def.sure,
        value : function() {
          if (gridEditFunc.getSelRowDatas()) {
            $.ajax({
              url : url("rolesethandler/saveRfList"),
              data : {
                code : code,
                funcItem : JSON.stringify(gridEditFunc.getSelRowDatas())
              },
              success : function(rtn) {
                gridFunc.jqGrid('setGridParam', {
                  postData : {
                    code : code
                  }
                });
                gridFunc.trigger("reloadGrid");
                pDialog.dialog('close');
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
          pDialog.dialog('close');
        }
      } ])
    });

    $("#btns_func").find("#add").click(function() {//新增
      if (isNew) {
        API.showConfirmMessage(i18n.def.saveBeforeAction, function(data) {
          data && save({
            done : function() {
              pDialog.dialog('open')
            }
          });
        });
      } else {
        pDialog.dialog('open');
      }
    }).end().find("#delete").click(function() {//刪除
      if (gridFunc.getSelRowDatas()) {
        $.ajax({
          url : url("rolesethandler/deleteRfList"),
          data : {
            code : code,
            funcItem : JSON.stringify(gridFunc.getSelRowDatas())
          },
          success : function(rtn) {
            gridFunc.jqGrid('setGridParam', {
              postData : {
                code : code
              }
            });
            gridFunc.trigger("reloadGrid");
            API.showMessage(i18n.def['deleteSuccess']);
          }
        });
      } else {
        API.showConfirmMessage(i18n.def['selectd.msg']);
      }
    });

    var save = function(action) {
      $form.validationEngine('validate') && $.ajax({
        url : url("rolesethandler/save"),
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
pageInit(function() {
  $(document).ready(function() {
    var grid, mform = $("#mform"), qform = $('#qform');
    grid = $("#gridview").jqGrid({
      url : url('usersethandler/query'),
      sortname : 'code',
      sortorder : "desc",
      height : 250,
      multiselect : true,
      colModel : [ {
        name : 'oid',
        hidden : true
      }, {
        header : i18n.userSet.usercode,
        name : 'code',
        width : 80,
        align : "center"
      }, {
        header : i18n.userSet.username,
        name : 'name',
        width : 80,
        align : "center"
      }, {
        header : i18n.userSet.userstatus,
        name : 'status',
        width : 80,
        align : "center"
      }, {
        name : 'email',
        hidden : true
      }, {
        header : i18n.userSet.pwdExpiredTime,
        name : 'pwdExpiredTime',
        width : 80,
        align : "center"
      }, {
        header : i18n.def.lastModBy,
        name : 'updater',
        width : 80,
        align : "center"
      }, {
        header : i18n.def.lastModTm,
        name : 'updateTime',
        width : 80,
        align : "center"
      } ]
    });
    grid2 = $("#roleGrid").jqGrid({
      url : url('usersethandler/findRole'),
      sortname : 'code',
      sortorder : "desc",
      height : 250,
      multiselect : true,
      colModel : [ {
        header : i18n.userSet.rolecode,
        name : 'code',
        width : 80,
        align : "center",
        hidden : true
      }, {
        header : i18n.userSet.rolename,
        name : 'name',
        width : 80
      }, {
        name : 'usercode',
        hidden : true
      } ],
      loadComplete : function(data) {
        for (var i = 0; i < data.rows.length; i++) {
          var sel = data.rows[i].cell[2];
          if (sel != null && sel != "") {
            grid2.jqGrid('setSelection', grid2.jqGrid('getDataIDs')[i], true);
          }
        }
      }
    });
    grid3 = $("#qRoleGrid").jqGrid({
      url : url('usersethandler/queryAllRole'),
      sortname : 'code',
      sortorder : "desc",
      height : 150,
      multiselect : true,
      colModel : [ {
        header : i18n.userSet.rolecode,
        name : 'code',
        width : 80,
        align : "center",
        hidden : true
      }, {
        header : i18n.userSet.rolename,
        name : 'name',
        width : 80
      } ]
    });
    grid4 = $("#statusGrid").jqGrid({
      // caption:'狀態',
      url : url('usersethandler/queryAllUserStatus'),
      sortname : 'codeValue',
      sortorder : "desc",
      height : 150,
      width : 400,
      multiselect : true,
      colModel : [ {
        name : 'codeValue',
        hidden : true
      }, {
        header : i18n.userSet.userstatus,
        name : 'codeDesc',
        width : 80
      } ]
    });
    var aDialog = $("#addDialog"), qDialog = $("#qryDailog");
    aDialog.dialog({
      height : 520,
      width : 800,
      modal : true,
      open : function() {
        var title = $("#ui-dialog-title-editDialog");
        if (aDialog.data('type') == 'add') {
          title.text(i18n.userSet.add);
          aDialog.find('#statusArea').hide();
          aDialog.find('#code').removeAttr("readonly");
          aDialog.find('#password').addClass("validate[required]");
          aDialog.find('#confirm').addClass("validate[required]");
          grid2.trigger("reloadGrid");
        } else {
          title.text(i18n.userSet.modify);
          var users = grid.getSelRowDatas();
          aDialog.find('#oid').val(users[0].oid);
          aDialog.find('#code').val(users[0].code).attr("readonly", "readonly");
          aDialog.find('#name').val(users[0].name);
          aDialog.find('#email').val(users[0].email);
          aDialog.find('#statusArea').show();
          aDialog.find('#status').text(users[0].status);
          aDialog.find('#pwdExpiredTime').text(users[0].pwdExpiredTime);
          aDialog.find('#password').removeClass();
          aDialog.find('#confirm').removeClass();
          grid2.setGridParam({
            postData : {
              type : 'modify',
              userCode : users[0].code
            }
          }).trigger("reloadGrid");
        }
        grid2.iGridFitSize();
        grid2.resetSelection();
      },
      close : function() {
        aDialog.find("#mform").reset();
      },
      buttons : API.createJSON([ {
        key : i18n.def.sure,
        value : function() {
          var mform = aDialog.find("#mform");
          mform.validationEngine('validate') && $.ajax({
            url : url("usersethandler/" + aDialog.data('type')),
            data : $.extend(mform.serializeData(), {
              roleCodes : grid2.getSelRowDatas('code')
            }),
            success : function() {
              grid.trigger("reloadGrid");
              aDialog.dialog('close');
            }
          });
        }
      }, {
        key : i18n.def.close,
        value : function() {
          aDialog.dialog('close');
        }
      } ])
    });
    qDialog.dialog({
      height : 400,
      width : 800,
      modal : true,
      close : function() {
        qDialog.find("#qform").reset();
        grid3.jqGrid('resetSelection');
        grid4.jqGrid('resetSelection');
      },
      buttons : API.createJSON([ {
        key : i18n.def.sure,
        value : function() {
          // 得這樣清 postData = =?
          grid.jqGrid('getGridParam', 'postData')['roleCodes'] = [];
          grid.jqGrid('getGridParam', 'postData')['status'] = [];
          grid.jqGrid('setGridParam', {
            postData : {
              code : qform.find("#qUserCode").val(),
              name : qform.find("#qUserName").val(),
              roleCodes : grid3.getSelRowDatas('code'),
              status : grid4.getSelRowDatas('codeValue')
            }
          });
          grid.trigger("reloadGrid");
          qDialog.dialog('close');
        }
      }, {
        key : i18n.def.close,
        value : function() {
          qDialog.dialog('close');
        }
      } ])
    });
    $(".btns").find("#filter").click(function() {
      qDialog.dialog('open');
      // 新增
    }).end().find("#add").click(function() {
      aDialog.data('type', 'add').dialog('open');
      // 修改
    }).end().find("#modify").click(function() {
      var sel = grid.getSelRowDatas();
      if (sel) {
        if (sel.length == 1) {
          aDialog.data('type', 'modify').dialog('open');
        } else {
          API.showErrorMessage(i18n.def.grid_selector_one_only);
        }
      } else {
        API.showErrorMessage(i18n.def.grid_selector);
      }
      // 删除
    }).end().find("#delete").click(function() {
      multiOperation('delete');
      // 暫禁
    }).end().find("#lock").click(function() {
      multiOperation('lock');
      // 解禁
    }).end().find("#unlock").click(function() {
      multiOperation('unlock');
    });

    function multiOperation(action) {
      if (grid.getSelRowDatas()) {
        API.showConfirmMessage(i18n.def.actoin_001, function(data) {
          data && $.ajax({
            url : url("usersethandler/" + action),
            data : {
              oids : grid.getSelRowDatas('oid')
            },
            success : function() {
              grid.trigger("reloadGrid");
            }
          });
        });
      } else {
        API.showErrorMessage(i18n.def.grid_selector);
      }
    }
  });
});

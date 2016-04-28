pageInit(function() {
  $(document).ready(function() {
    var oid = reqJSON.oid;
    var $form = $("#EDIT").find("form");
    var grid = $("#gridview").jqGrid({
      url : url('remindhandler/queryDetail'),
      height : "100",
      width : "100%",
      postData : {
        oid : oid
      },
      multiselect : true,
      hideMultiselect : true,
      autowidth : true,
      localFirst : true,
      colModel : [ {
        header : i18n['remind_Page']['styleTyp'],//"提醒方式",
        name : 'styleTyp',
        align : "left",
        width : 15,
        sortable : false
      }, {
        header : i18n['remind_Page']['styleNum'],//"數值
        name : 'style',
        align : "left",
        width : 15,
        sortable : true
      }, {
        header : i18n['remind_Page']['styleUnit'],//"單位
        name : 'unit',
        align : "left",
        width : 10,
        sortable : true
      }, {
        name : 'oid',
        hidden : true
      } ]
    });
    if (oid) {
      $.ajax({
        url : url("remindhandler/queryForm"),
        data : {
          oid : oid
        },
        success : function(json) {
          $form.injectData(json);
          grid.trigger("reloadGrid");
        }
      });
    }
    if (reqJSON.fromCal) {
      $form.injectData(reqJSON);
    }
    var dDialog = $("#DETAIL").dialog({
      title : i18n['remind_Page']["detail.title"],
      height : 200,
      width : 250,
      modal : true,
      close : function() {
        $(this).find("form").reset();
      },
      buttons : API.createJSON([ {
        key : i18n.def.sure,
        value : function() {
          var form = $(this).find("form");
          form.validationEngine('validate') && $.ajax({
            url : url("remindhandler/saveDetail"),
            data : $.extend(form.serializeData(), {
              pid : oid
            }),
            success : function(rtn) {
              grid.jqGrid('setGridParam', {
                postData : {
                  oid : oid
                }
              });
              grid.trigger("reloadGrid");
              dDialog.dialog('close');
              API.showMessage(i18n.def['addSuccess']);
            }
          });
        }
      }, {
        key : i18n.def.close,
        value : function() {
          dDialog.dialog('close');
        }
      } ])
    });

    $("#save_btn").click(function() {//新增
      API.showConfirmMessage(i18n.def.actoin_001, function(data) {
        data && save();
      });
    });

    $(".btns").find("#add").click(function() {//新增
      if (oid) {
        dDialog.dialog('open');
      } else {
        API.showConfirmMessage(i18n.def.saveBeforeAction, function(data) {
          data && save({
            done : function() {
              dDialog.dialog('open')
            }
          });
        });
      }
    }).end().find("#delete").click(function() {
      var ret = grid.getSelRowDatas();
      if (ret) {
        var oids = [];
        for ( var item in ret) {
          oids.push(ret[item].oid);
        }
        ;
        API.showConfirmMessage(i18n.def['del.confrim'], function(b) {
          if (b) {
            $.ajax({
              url : url("remindhandler/deleteDetail"),
              data : {
                oids : oids
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

    var save = function(action) {
      $form.validationEngine('validate') && $.ajax({
        url : url("remindhandler/save"),
        data : $form.serializeData(),
        success : function(rtn) {
          $form.injectData({
            oid : rtn.oid
          });
          window.name = oid = reqJSON.oid = rtn.oid;
          if (reqJSON.fromCal) {
            window.opener.$('#calendar').fullCalendar('refetchEvents');
          } else {
            API.triggerOpener();
          }
          API.showMessage(i18n.def['saveSuccess'], action && action.done && action.done());
        }
      });
    }
  });
});
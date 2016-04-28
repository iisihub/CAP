pageInit(function() {
  $(document).ready(function() {
    var mform = $("#mform");
    var grid = $("#gridview").jqGrid({
      url : url('sequencehandler/query'),
      height : 310,
      colModel : [ {
        header : i18n['sequence']['seqNode'],//流水號代碼
        name : 'seqNode',
        width : 20
      }, {
        header : i18n['sequence']['nextSeq'],//下一個序號
        name : 'nextSeq',
        width : 10
      }, {
        header : i18n['sequence']['rounds'],//rounds
        name : 'rounds',
        width : 10,
      }, {
        header : i18n.def.lastModTm,
        name : 'updateTime',
        width : 10,
        align : "center"
      } ],
      onSelectRow : function() {
        var ret = grid.getSelRowDatas();
        ret && mform.find("#seqNode").val(ret.seqNode);
      }
    });
    $("#getNewSeq").click(function() {
      mform.validationEngine('validate') && API.showConfirmMessage(i18n.def.actoin_001, function(data) {
        data && $.ajax({
          url : url("sequencehandler/getNewSeq"),
          data : mform.serializeData(),
          success : function(rtn) {
            mform.find("#theSeq").text(rtn.theSeq);
            grid.trigger("reloadGrid");
          }
        });
      });
    });
    $("#qry").click(function() {
      grid.jqGrid('setGridParam', {
        postData : {
          seqNode : mform.find("#seqNode").val()
        }
      });
      grid.trigger("reloadGrid");
    });
  });
});
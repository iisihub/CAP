pageInit(function() {
  $(document).ready(function() {
    var mform = $("#mform");
    var grid = $("#gridview").jqGrid({
      url : url('linecontactshandler/query'),
      height : "380",
      width : "100%",
      multiselect : false,
      hideMultiselect : false,
      autowidth : true,
      localFirst : false,
      colModel : [ {
        header : i18n['contacts']['picture'],
        name : 'picture',
        align : "center",
        width : 5,
        formatter : function(cellvalue, options, rowObject) {
          return "<img src='data:image/png;base64, " + cellvalue + "' height='45' width='45' />";
        }
      }, {
        header : i18n['contacts']['displayName'],// "單位名稱",
        name : 'diaplayName',
        align : "left",
        width : 15
      }, {
        header : i18n['contacts']['statusMessage'],// "法定代理人",
        name : 'statusMessage',
        align : "left",
        width : 15
      }, {
        header : i18n['contacts']['addTime'],// "單位經理",
        name : 'addTime',
        align : 'left',
        width : 15,
        sortable : false
      }, {
        header : i18n['contacts']['blocked'],// "地址",
        name : 'blocked',
        align : 'left',
        width : 15,
        sortable : false
      }, {
        name : 'mid',
        hidden : true
      } ]
    });
  });
});
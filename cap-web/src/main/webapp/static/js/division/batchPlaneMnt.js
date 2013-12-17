pageInit(function(){
    $(document).ready(function(){
        var mform = $("#mform");
        var grid = $("#gridview").jqGrid({
            height: "380",
            width: "100%",
            rownumbers: true,
            multiselect: false,
            hideMultiselect: false,
            autowidth: true,
            localFirst: true,
			colModel : [ {
				header: i18n['batchPlaneMnt']['planCode'],
				name : "planCode",
				align: "left",
				width: 10
			}, {
				header: i18n['batchPlaneMnt']['planNm'],
				name : "planNm",
				align: "left",
				width: 10
			}, {
				header: i18n['batchPlaneMnt']['planSummary'],
				name : "planSummary",
				align: "left",
				width: 25
			}, {
				header: i18n['batchPlaneMnt']['updateTime'],
				name : "updateTime",
				align: "left",
				width: 10
			}, {
				header: i18n['batchPlaneMnt']['inBatch'],
				name : "inBatch",
				align: "left",
				width: 5
			}, {
				header: i18n['batchPlaneMnt']['enable'],
				name : "enable",
				align: "center",
				sortable : true,
				width: 5
			}]
		}).addGridData([
						["SCOL-00001","前置分案","分案啟動前置作業","2013-01-01 12:30","是","否"],
						["SCOL-00002","依組分案","依據M0 電催 法催 委外等組別分案","2013-01-01 12:30","是","是"],
						["SCOL-00003","組內分案","各小組組內分案","2013-01-01 12:30","是","否"]
					]);

        //查詢
        $("#qry").click(function(){
            grid.jqGrid('setGridParam', {
                postData: {
                    locale: mform.find("#locale").val(),
                    codeType: mform.find("#codeType").val()
                }
            });
            grid.trigger("reloadGrid");
        });
    });
});

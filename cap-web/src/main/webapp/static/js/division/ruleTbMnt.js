pageInit(function(){
    $(document).ready(function(){
        var mform = $("#mform");
        var grid = $("#gridview").jqGrid({
            height: "380",
            width: "100%",
            rownumbers: true,
//            autowidth: true,
//            localFirst: true,
			colModel : [ {
				header: i18n['ruleTbMnt']['ruleTbNm'],
				name : "ruleTbNm",
				align: "left",
				width: 10
			}, {
				header: i18n['ruleTbMnt']['ruleCont'],
				name : "ruleCont",
				align: "left",
				width: 50
			}, {
				header: i18n['ruleTbMnt']['classify'],
				name : "classify",
				align: "left",
				width: 10
			}, {
				header: 'oid',
				name : "oid",
				hidden : true,
				width: 5
			}]
		}).addGridData([['大型分案規則表','M0新件分案,回沖分案,月底分案,月初分案,馬上分案','件數平均','是']
		   ,['特殊案件規則表','M0新件分案,回沖分案,處分分案','件數平均','是']
		   ,['一般案件規則表','M0新件分案,回沖分案,月底分案,月初分案','金額平均','是']]);
        
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

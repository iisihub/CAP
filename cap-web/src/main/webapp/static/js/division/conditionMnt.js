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
				header: i18n['conditionMnt']['condNm'],
				name : "condNm",
				align: "left",
				width: 10
			}, {
				header: i18n['conditionMnt']['condVal'],
				name : "condVal",
				align: "left",
				width: 35
			}, {
				header: i18n['conditionMnt']['enable'],
				name : "enable",
				align: "center",
				sortable : true,
				width: 5
			}]
        }).addGridData([['M0新件分案','產品項目(信貸,信用卡),逾期天數(逾期天數 1 ~ 30,逾期天數 31 ~ 60),催收人員(王小一,王小二,王小三)','是']
		   ,['回沖分案','產品項目(信貸,信用卡),逾期天數(逾期天數61 ~ 90,逾期天數 91 ~180),催收人員(王小三,王小四)','是']
		   ,['月底分案','產品項目(信貸,信用卡),逾期天數(逾期天數181~99999),催收人員(王小五)','是']]);
        
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

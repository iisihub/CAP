pageInit(function(){
    $(document).ready(function(){
    	var _handler = "factorMnthandler";
        var grid = $("#gridview").jqGrid({
    		handler : 'factorMnthandler',
            height: "380",
            width: "100%",
            rownumbers: true,
            multiselect: false,
            hideMultiselect: false,
            autowidth: true,
            localFirst: true,
			colModel : [ {
				header: i18n['factorMnt']['factorCode'],
				name : "facotrNo",
				align: "left",
				width: 5
			}, {
				header: i18n['factorMnt']['factorNm'],
				name : "factorNm",
				align: "left",
				width: 15
			}, {
				header: i18n['factorMnt']['summary'],
				name : "summary",
				align: "left",
				width: 50
			}, {
				header: i18n['factorMnt']['enable'],
				name : "enable",
				align: "center",
				sortable : true,
				width: 5
			},{name:"oid", hidden:true}]
		}).addGridData([['000001','逾期金額','','是']
					   ,['000002','逾期天數','','是']
					   ,['000003','承諾繳款','','是']
					   ,['000004','協議註記','','是']
					   ,['000005','特殊註記','','是']]);

        function openDoc(cellvalue, options, rowObject){
        	CommonAPI.formSubmit({
                url: './division/factorMntPage',
                data: {
                    formAction: "query",
                    mainOid: rowObject.oid,
                    factorNo: rowObject.factorNo,
                    uid: rowObject.uid
                },
                target: "_blank"//rowObject.oid
            });
        };
        
        //查詢
        $("#qry").click(function(){
//            grid.jqGrid('setGridParam', {
//                postData: {
//                }
//            });
//            grid.trigger("reloadGrid");
        });
        //新增
		$("#add").click(function() {
			CommonAPI.formSubmit({
				data : {
					type : 'A'
				},
				url : './division/factorMntPage',
				target : "_blank"
			});
		});
        
        //修改
        $("#modify").click(function(){
        	var selrow = $("#gridview").getGridParam('selrow');
			if (selrow) {
				openDoc('', '', null);
			} else {
				CommonAPI.showErrorMessage("請先選擇要修改的資料");
			}
        });
       //刪除
       $("#delete").click(function(){
    	   
       });
       //insert 測試資料
       $("#insertTestCases").click(function() {
			debugger;
			$.ajax({
				data : {
					ftItmNos : [ 1, 2, 3, 4 ]
				},
				url : "webroot/factorMnthandler/queryByKeys",
				success : function() {
					alter(" test insert action");
				}
	
			});
		});
    });
});

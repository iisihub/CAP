pageInit(function(){
	$(document).ready(function(){
		var mform = $("#mform");
		var grid = $("#gridview").jqGrid({
            height: "380",
            width: "100%",
            // sortname: 'param',
            multiselect: false,
            hideMultiselect: false,
            autowidth: true,
            localFirst: true,
            colModel: [{
                header: "序號",
                name: 'name1',
    			align: "left",
    			width: 10,
            },{
                header: "記錄起日",
                name: 'name2',
				align: "left",
				width: 10,
				sortable: true
            },  {
                header: "記錄迄日",
                name: 'name3',
				align: "left",
				width: 10,                                    
				sortable: true
           },  {
                header: "執行時間",
                name: 'name4',
				align: "left",
                width: 5
            },  {
                header: "執行結果",
                name: 'name5',
				align: "left",
                width: 5
            },  {
                header: "交易代碼",
                name: 'name6',
				align: "left",
                width: 5
            }]
        });
		var qDialog = $("#SEARCH"),dDialog = $("#DETAIL");
        qDialog.dialog({
        	width : 600,
			height : 200,modal: true,
        	buttons:API.createJSON([{
        		key:i18n.def.sure,
        		value:function(){
        			grid.jqGrid('setGridParam', {
                        postData: {
                        }
                    });
                    grid.trigger("reloadGrid");
                    qDialog.dialog('close');
        		}
        	},{
        		key:i18n.def.close,
        		value:function(){
        			qDialog.dialog('close');
        		}
        	}])
        });
        dDialog.dialog({
        	width : 600,
			height : 400,modal: true,
        	buttons:API.createJSON([{
        		key:i18n.def.sure,
        		value:function(){
        			grid.jqGrid('setGridParam', {
                        postData: {
                        }
                    });
                    grid.trigger("reloadGrid");
                    dDialog.dialog('close');
        		}
        	},{
        		key:i18n.def.close,
        		value:function(){
        			dDialog.dialog('close');
        		}
        	}])
        });
		$(".btns").find("#qry").click(function(){//查詢
			qDialog.dialog('open');
		}).end().find("#detail").click(function(){//查詢
			dDialog.dialog('open');
		});
	});
});
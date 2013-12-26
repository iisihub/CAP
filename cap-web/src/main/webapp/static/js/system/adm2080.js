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
                header: "訊息代碼",
                name: 'name1',
    			align: "left",
    			width: 10,
            },  {
                header: "等級",
                name: 'name4',
				align: "left",
                width: 5
            },  {
                header: "狀態說明",
                name: 'name5',
				align: "left",
                width: 20
            },  {
                header: "建議處理方式",
                name: 'name6',
				align: "left",
                width: 20
            }]
        });
		var qDialog = $("#SEARCH"), eDialog = $("#EDIT");
        qDialog.dialog({
        	width: 400,
            height: 150,modal: true,
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
        eDialog.dialog({
        	width: 600,
            height: 400,modal: true,
        	buttons:API.createJSON([{
        		key:i18n.def.sure,
        		value:function(){
        			grid.jqGrid('setGridParam', {
                        postData: {
                        }
                    });
                    grid.trigger("reloadGrid");
                    eDialog.dialog('close');
        		}
        	},{
        		key:i18n.def.close,
        		value:function(){
        			eDialog.dialog('close');
        		}
        	}])
        });
		$(".btns").find("#qry").click(function(){//查詢
			qDialog.dialog('open');
		}).end().find("#add,#modify").click(function(){//查詢
			eDialog.dialog('open');
		});
	});
});
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
                header: "不需記錄的Handler名稱",
                name: 'name1',
    			align: "left",
    			width: 20,
            },{
                header: "不需記錄的類型",
                name: 'name2',
				align: "left",
				width: 10,
				sortable: true
            },  {
                header: "最後修改人",
                name: 'name3',
				align: "left",
				width: 5,                                    
				sortable: true
           },  {
                header: "最後修改時間",
                name: 'name4',
				align: "left",
                width: 5
            }]
        });
		var qDialog = $("#SEARCH");
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
		$(".btns").find("#qry,#add,#modify").click(function(){//查詢
			qDialog.dialog('open');
		});
	});
});
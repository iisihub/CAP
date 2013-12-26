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
                header: "公告起日",
                name: 'name1',
    			align: "center",
    			width: 10,
            },{
                header: "公告迄日",
                name: 'name2',
				align: "left",
				width: 10,
				sortable: true
            },  {
                header: "狀態",
                name: 'name3',
				align: "center",
				width: 5,                                    
				sortable: true
           },  {
                header: "公告主旨",
                name: 'name4',
				align: "left",
                width: 40
            },  {
                header: "公告等級",
                name: 'name5',
				align: "center",
                width: 5
            },  {
                header: "語言別",
                name: 'name6',
				align: "center",
                width: 5
            }]
        });
		var qDialog = $("#SEARCH"), eDialog = $("#edit_dialog1");
        qDialog.dialog({
        	width: 500,
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
		}).end().find("#add,#modify").click(function(){//新增 修改
			eDialog.dialog('open');
		});
	});
});
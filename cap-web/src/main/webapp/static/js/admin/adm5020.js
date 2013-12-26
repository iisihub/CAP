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
                header: "使用者名稱",
                name: 'name1',
    			align: "left",
    			width: 5,
            },{
                header: "單位名稱",
                name: 'name2',
				align: "left",
				width: 5,
				sortable: true
            },  {
                header: "SSO驗證時間",
                name: 'name4',
				align: "left",
                width: 5
            },  {
                header: "登入IP",
                name: 'name5',
				align: "left",
                width: 5
            }]
        });
		var qDialog = $("#SEARCH");
        qDialog.dialog({
        	width : 600,
			height : 150,modal: true,
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
		$(".btns").find("#qry").click(function(){//查詢
			qDialog.dialog('open');
		});
	});
});
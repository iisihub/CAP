pageInit(function(){
	$(document).ready(function(){
		var mform = $("#mform");
		var grid = $("#gridview").jqGrid({
            url: 'webroot/sysparmhandler/query',
            sortname: 'parmId',height: 350,
            colModel: [{
                header: i18n['adm1030']['grid1'],//"業務類別",
                name: 'name1',
    			align: "center",
    			width: 10,
            },{
                header: i18n['adm1030']['grid2'],//"開啟類型",
                name: 'name2',
				align: "center",
				width: 15,
				sortable: true
            },  {
                header: i18n['adm1030']['grid3'],//"編輯人員",
                name: 'name3',
				align: "center",
				width: 5,                                    
				sortable: true
           },  {
                header: i18n['adm1030']['grid4'],//"編輯人員單位",
                name: 'name5',
				align: "center",
                width: 15
            },  {
                header: i18n['adm1030']['grid5'],//"開啟時間",
                name: 'name6',
				align: "center",
                width: 15
            }],
            ondblClickRow: function(){
            }
        });
		var qDialog = $("#SEARCH");
        qDialog.dialog({
        	height: 150,width: 350,modal: true,
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
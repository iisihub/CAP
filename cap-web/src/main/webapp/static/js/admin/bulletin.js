pageInit(function(){
	$(document).ready(function(){
		var grid = $("#gridview").jqGrid({
			url: 'webroot/bulletinhandler/query',
            height: "380", width: "100%",
            multiselect: false, hideMultiselect: false,
            autowidth: true, localFirst: true,
            colModel: [{
            	header: i18n['bulletin']['startDate'],//"公告起日",
                name: 'startDate',
    			align: "center",
    			width: 80,
				sortable: false
            },{
            	header: i18n['bulletin']['endDate'],//"公告迄日",
                name: 'endDate',
				align: "center",
				width: 80,
				sortable: false
            },  {
            	header: i18n['bulletin']['status'],//"狀態",
                name: 'status',
				align: "center",
				width: 40,                                    
				sortable: false
           },  {
        	   header: i18n['bulletin']['bTitle'],//"公告主旨",
                name: 'title',
				align: "left",
                width: 360,                                    
				sortable: false,
                formatter: 'click',
                onclick: doEdit
            },  {
            	header: i18n['bulletin']['level'],//"公告等級",
                name: 'level',
				align: "left",
                width: 120,                                    
				sortable: false
            },  {
            	header: i18n['bulletin']['locale'],//"語言別",
                name: 'locale',
				align: "center",
                width: 60,                                    
				sortable: false
            }, {
                name: 'content',hidden: true
            }, {
                name: 'oid',hidden: true
            }],
            ondblClickRow: function(){
                openEditWindow(true);
            }
        });
		function doEdit(cellvalue, options, rowObject){
	        openEditWindow(true, rowObject);
	    }
		function openEditWindow(isEdit, rowObject){
	        var $form = $('#JForm');
	        $form.reset();
	        
	        var oid = '';
	        if (isEdit) {
	            if (!rowObject) {
	                var id = grid.jqGrid('getGridParam', 'selrow');
	                if (id) {
	                    rowObject = grid.jqGrid('getRowData', id);
	                }
	                else {
	                	API.showMessage(i18n.def['selectd.msg']);
	                    return;
	                }
	            }
	            $form.injectData(rowObject);
	        }
	        eDialog.dialog('open');
	    }
		var qDialog = $("#SEARCH"), eDialog = $("#EDIT");
        qDialog.dialog({
        	width: 600,
            height: 180,modal: true,
            close:function(){
            	qDialog.find("form").reset();
        	},
        	buttons:API.createJSON([{
        		key:i18n.def.sure,
        		value:function(){
        			grid.jqGrid('setGridParam', {
                        postData: qDialog.find("form").serializeData()
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
            title: i18n.def['edit'], // 編輯
            modal: true, width: 600, height: 430,
            valign: "bottom", align: 'center',
            close:function(){
            	eDialog.find("form").reset();
        	},
            buttons:API.createJSON([{
        		key:i18n.def.sure,
        		value:function(){
        			$form = eDialog.find("form");
        			if ($form.validationEngine('validate')) {
                        $.ajax({
                        	url: 'webroot/bulletinhandler/save',
                        	data: $form.serializeData(),
                            success: function(responseData){
                            	API.showMessage(i18n.def['saveSuccess']);
                            	grid.trigger("reloadGrid");
                            }
                        });
                    }
        			eDialog.dialog('close');
        		}
        	},{
        		key:i18n.def.close,
        		value:function(){
        			eDialog.dialog('close');
        		}
        	}])
        });
        qDialog.dialog('open');
		$(".btns").find("#qry").click(function(){//查詢
			qDialog.dialog('open');
		}).end().find("#add").click(function(){//新增
			eDialog.dialog('open');
		}).end().find("#modify").click(function(){//修改
			var ret = grid.getSelRowDatas();
			if (ret) {
				eDialog.dialog('open');
			} else {
                API.showErrorMessage(i18n.def.grid_selector);
            }
		}).end().find("#delete").click(function(){
			var ret = grid.getSelRowDatas();
			if (ret) {
                API.showConfirmMessage(i18n.def.actoin_001, function(data){
                    data &&
                    $.ajax({
                        url: "webroot/bulletinhandler/delete",
                        data: {
                            oid: ret.oid
                        },
                        success: function(){
                            grid.trigger("reloadGrid");
                        }
                    });
                });
            } else {
                API.showErrorMessage(i18n.def.grid_selector);
            }
		});
	});
});
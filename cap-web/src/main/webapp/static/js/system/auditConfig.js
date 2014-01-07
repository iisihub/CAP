pageInit(function(){
	$(document).ready(function(){
		var mform = $("#mform");
		var grid = $("#gridview").jqGrid({
			url: 'webroot/audithandler/query',
			height: "380",
            width: "100%",
            multiselect: false,
            hideMultiselect: false,
            autowidth: true,
            localFirst: true,
            colModel: [{header: i18n['auditConfig']['targetName'],//"不需記錄的Handler名稱",
                name: 'targetName',align: "left",width: 20,
            }, {header: i18n['auditConfig']['disableType'],//"不需記錄的類型",
                name: 'disableType',align: "left",width: 10,sortable: true
            }, {header: i18n['auditConfig']['lastModifyBy'],//"最後修改人",
                name: 'lastModifyBy',align: "left",width: 5,   sortable: true
            }, {header: i18n['auditConfig']['lastModifyTime'],//"最後修改時間",
                name: 'lastModifyTime',align: "left",width: 5
            }, {name: 'oid',hidden: true
            }],
            ondblClickRow: function(){
                openEditWindow(true);
            }
        });
		
		function openSearchWindow(){
			$("#JForm").reset().find('#targetName').removeAttr("disabled");
			var search = $("#SEARCH").dialog({
	        	title: i18n.def['query'],
	        	width: 600,
	            height: 150,modal: true,
	        	buttons:API.createJSON([{
	        		key:i18n.def.sure,
	        		value:function(){
	        			grid.jqGrid('setGridParam', {
	                        postData: {
	                        	targetName: search.find("#targetName").val(),
	                        	disableType: search.find("#disableType").val()
	                        }
	                    });
	                    grid.trigger("reloadGrid");
	                    search.dialog('close');
	        		}
	        	},{
	        		key:i18n.def.close,
	        		value:function(){
	        			search.dialog('close');
	        		}
	        	}])
	        });
			search.dialog('open');
		}

        function openEditWindow(isEdit, rowObject){
            var $form = $('#JForm');
            var title;
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
                oid = rowObject.oid;
                var disableType = $('#JForm option:contains(' + rowObject.disableType + ')').val();
                $form.find('#targetName').val(rowObject.targetName).attr("disabled", true);
                $form.find('#disableType').val(disableType);
                title=i18n.def['edit'];
            }
            else {
            	$form.find('#targetName').val('').removeAttr("disabled");
            	$form.find('#disableType').val('');
            	title=i18n.def['newData'];
            }
            
            var edit = $("#SEARCH").dialog({
                title: title, // 編輯
                modal: true, width: 600, height: 150,
                valign: "bottom", align: 'center',
                buttons:API.createJSON([{
            		key:i18n.def.sure,
            		value:function(){
            			if ($form.validationEngine('validate')) {
                            $.ajax({
                            	url: 'webroot/audithandler/save',
                            	data: {
                                    oid: oid,
                                    targetName: $form.find('#targetName').val(),
                                    disableType: $form.find('#disableType').val()
                                },
                                success: function(responseData){
                                    if (responseData.exist) {
                                    	edit.dialog('close');
                                        API.showMessage(i18n.def['data.exists']);
                                    }
                                    else {
                                    	grid.trigger("reloadGrid");
                                    }
                                }
                            });
                        }
            			edit.dialog('close');
            		}
            	},{
            		key:i18n.def.close,
            		value:function(){
            			edit.dialog('close');
            		}
            	}])
            });
            edit.dialog('open');
        }
		$(".btns").find("#qry").click(function(){//查詢
			openSearchWindow();
		}).end().find("#add").click(function(){//新增
			openEditWindow(false);
		}).end().find("#modify").click(function(){//修改
			openEditWindow(true);
		}).end().find("#delete").click(function(){
	        var id = grid.jqGrid('getGridParam', 'selrow');
	        if (id) {
	            var rowObject = grid.jqGrid('getRowData', id);
	            API.showConfirmMessage(i18n.def['del.confrim'], function(b){
	                if (b) {
	                    $.ajax({
	                    	url: 'webroot/audithandler/delete',
	                        data: {
	                            oid: rowObject.oid
	                        },
	                        success: function(responseData){
	                        	grid.trigger("reloadGrid");
	                        }
	                    });
	                }
	            });
	        }
	        else {
	            API.showMessage(i18n.def['selectd.msg']);
	        }
	    });
		$(".btns").find("#qry").trigger( "click" );
	});
});
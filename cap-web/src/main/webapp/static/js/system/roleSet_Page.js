pageInit(function(){
	$(document).ready(function(){
		var $form = $("#JForm");
		var code = reqJSON.rolCode;
		var isNew = code? false:true;
		
		var gridUsr = $("#gridview_usr").jqGrid({
			url: 'webroot/rolesethandler/queryGridUsr',
			height: "180", width: "100%", pager: false,
			postData: { rolCode: code },
            multiselect: true, hideMultiselect: false, autowidth: true, localFirst: true,
            colModel: [{
                header: i18n['roleSet_Page']['staffId'],//"使用者代號",
                name: 'userId', align: "left", sortable: true
            },  {
                header: i18n['roleSet_Page']['staffNm'],//"姓名
                name: 'userName', align: "left", sortable: true
            },  {
                header: i18n['roleSet_Page']['departNo'],//"部門代號
                name: 'unitNo', align: "left", sortable: true
            },  {
                header: i18n['roleSet_Page']['departNm'],//"部門名稱
                name: 'departnm', align: "left", sortable: true
            }]
        });
		var gridFunc = $("#gridview_func").jqGrid({
			url: 'webroot/rolesethandler/queryGridFunc',
			height: "180", width: "100%", pager: false,
			postData: { rolCode: code },
            multiselect: true, hideMultiselect: false, autowidth: true, localFirst: true,
            colModel: [{
                header: i18n['roleSet_Page']['pgmCode'],//"功能代碼
                name: 'code', align: "left", sortable: true
            },  {
                header: i18n['roleSet_Page']['pgmName'],//"功能名稱
                name: 'name', align: "left", sortable: true
            },  {
                header: i18n['roleSet_Page']['pgmTyp'],//"上層功能代碼
                name: 'parent', align: "left", sortable: true
            }]
        });
		var init = function(){
			$form.find('#roleId').attr('disabled', !isNew);
			$form.find('#sysTyp').attr('disabled', !isNew);
		}
		if(code){
			$.ajax({
		        url:"webroot/rolesethandler/queryForm",
		        data:{
		        	rolCode: code
		        },
		        success:function(json){
		        	$form.injectData(json);
		        	init();
		        	gridUsr.trigger("reloadGrid");
		        	gridFunc.trigger("reloadGrid");
		        }
			});
		}else{
			init();
		}
		
		//角色
		$("#save_btn").click(function(){//新增
	        API.showConfirmMessage(i18n.def.actoin_001, function(data){
	            data && save();
	        });
		});
		//人員
		var gridEditUsr = $("#gridviewUsr").jqGrid({
			url: 'webroot/rolesethandler/queryEditUsr',
			height: "220", width: "550", pager: false,
			postData: { unit : '',rolCode: code },
            multiselect: true, hideMultiselect: false, autowidth: false, localFirst: true,
            pager:false,
            colModel: [{
                header: i18n['roleSet_Page']['staffId'],//"使用者代號",
                name: 'userId', align: "left", sortable: true
            },  {
                header: i18n['roleSet_Page']['staffNm'],//"姓名
                name: 'userName', align: "left", sortable: true
            }]
        });
		var eDialog = $("#editUsr").dialog({
        	height: 440,width: 600,modal: true,
        	open:function(){
        		var form = eDialog.find("#mform");
        		$.ajax({
                    url: "webroot/rolesethandler/getAllBranch",
                    success: function(json){
                    	form.find("#unit").setOptions(json);
                    }
                });
        		form.find("#query").click(function(){//查詢
        			gridEditUsr.jqGrid('setGridParam', {
                        postData: {
                        	rolCode : code,
                        	unit : form.find('#unit').val()
                        }
                    });
        			gridEditUsr.trigger("reloadGrid");
        		});
        	},
        	close:function(){
        		gridEditUsr.clearGridData(true);
        	},
        	buttons:API.createJSON([{
        		key:i18n.def.sure,
        		value:function(){
        			if(gridEditUsr.getSelRowDatas()){
	        			$.ajax({
	    	                url: "webroot/rolesethandler/saveRlSet",
	    	                data: {
	    	                	rolCode: code,
	    	                	usrItem: JSON.stringify(gridEditUsr.getSelRowDatas())
	    	                },
	    	                success: function(rtn){
	    	                	gridUsr.jqGrid('setGridParam', {
	    	                        postData: {
	    	                        	rolCode : code
	    	                        }
	    	                    });
	    	                	gridUsr.trigger("reloadGrid");
	    	                	eDialog.dialog('close');
	    	                	API.showMessage(i18n.def['addSuccess']);
	    	                }
	    	            });
        			}else{
        				API.showConfirmMessage(i18n.def['selectd.msg']);
        			}
        		}
        	},{
        		key:i18n.def.close,
        		value:function(){
        			eDialog.dialog('close');
        		}
        	}])
        });
		
		$("#btns_usr").find("#add").click(function(){//新增
			if(isNew){
				API.showConfirmMessage(i18n.def.saveBeforeAction, function(data){
		            data && save({done:function(){eDialog.dialog('open')}});
		        });
			}else{
				eDialog.dialog('open');
			}
		}).end().find("#delete").click(function(){//刪除
			if(gridUsr.getSelRowDatas()){
				$.ajax({
	                url: "webroot/rolesethandler/deleteRlSet",
	                data: {
	                	rolCode: code,
	                	usrItem: JSON.stringify(gridUsr.getSelRowDatas())
	                },
	                success: function(rtn){
	                	gridUsr.jqGrid('setGridParam', {
	                        postData: {
	                        	rolCode : code
	                        }
	                    });
	                	gridUsr.trigger("reloadGrid");
	                	API.showMessage(i18n.def['deleteSuccess']);
	                }
	            });
			}else{
				API.showConfirmMessage(i18n.def['selectd.msg']);
			}			
		});
		//權限
		var gridEditFunc = $("#gridviewFunc").jqGrid({
			url: 'webroot/rolesethandler/queryEditFunc',
			height: "220", width: "550", pager: false,
			postData: { pgmTyp : '',rolCode: code },
            multiselect: true, hideMultiselect: false, autowidth: false, localFirst: true,
            pager:false,
            colModel: [{
                header: i18n['roleSet_Page']['pgmCode'],//"功能代碼
                name: 'code', align: "left", sortable: true
            },  {
                header: i18n['roleSet_Page']['pgmName'],//"功能名稱
                name: 'name', align: "left", sortable: true
            },  {
                header: i18n['roleSet_Page']['pgmTyp'],//"上層功能代碼
                name: 'parent', align: "left", sortable: true
            }]
        });
		var pDialog = $("#editFunc").dialog({
        	height: 440,width: 600,modal: true,
        	open:function(){
        		var form = pDialog.find("#mform");
        		$.ajax({
                    url: "webroot/rolesethandler/getAllFunc",
                    data : {systyp: $form.find("#sysTyp").val()},
                    success: function(json){
                    	form.find("#pgmTyp").setOptions(json);
                    }
                });
        		form.find("#query").click(function(){//查詢
        			gridEditFunc.jqGrid('setGridParam', {
                        postData: {
                        	rolCode : code,
                        	systyp: $form.find("#sysTyp").val(),
                        	pgmTyp : form.find('#pgmTyp').val()
                        }
                    });
        			gridEditFunc.trigger("reloadGrid");
        		});
        	},
        	close:function(){
        		gridEditFunc.clearGridData(true);
        	},
        	buttons:API.createJSON([{
        		key:i18n.def.sure,
        		value:function(){
        			if(gridEditFunc.getSelRowDatas()){
	        			$.ajax({
	    	                url: "webroot/rolesethandler/saveRlf",
	    	                data: {
	    	                	rolCode: code,
	    	                	funcItem: JSON.stringify(gridEditFunc.getSelRowDatas())
	    	                },
	    	                success: function(rtn){
	    	                	gridFunc.jqGrid('setGridParam', {
	    	                        postData: {
	    	                        	rolCode : code
	    	                        }
	    	                    });
	    	                	gridFunc.trigger("reloadGrid");
	    	                	pDialog.dialog('close');
	    	                	API.showMessage(i18n.def['addSuccess']);
	    	                }
	    	            });
        			}else{
        				API.showConfirmMessage(i18n.def['selectd.msg']);
        			}
        		}
        	},{
        		key:i18n.def.close,
        		value:function(){
        			pDialog.dialog('close');
        		}
        	}])
        });
		
		$("#btns_func").find("#add").click(function(){//新增
			if(isNew){
				API.showConfirmMessage(i18n.def.saveBeforeAction, function(data){
		            data && save({done:function(){pDialog.dialog('open')}});
		        });
			}else{
				pDialog.dialog('open');
			}
		}).end().find("#delete").click(function(){//刪除
			if(gridFunc.getSelRowDatas()){
				$.ajax({
	                url: "webroot/rolesethandler/deleteRlf",
	                data: {
	                	rolCode: code,
	                	funcItem: JSON.stringify(gridFunc.getSelRowDatas())
	                },
	                success: function(rtn){
	                	gridFunc.jqGrid('setGridParam', {
	                        postData: {
	                        	rolCode : code
	                        }
	                    });
	                	gridFunc.trigger("reloadGrid");
	                	API.showMessage(i18n.def['deleteSuccess']);
	                }
	            });
			}else{
				API.showConfirmMessage(i18n.def['selectd.msg']);
			}			
		});
		
		var save = function(action){
			$form.validationEngine('validate') && 
			$.ajax({
                url: "webroot/rolesethandler/save",
                data: $.extend($form.serializeData(),{
                	isNew:isNew
                }),
                success: function(rtn){
                	code = reqJSON.rolCode = $form.find("#roleId").val();
                	isNew = false;
                	init();
                	API.triggerOpener();
                	API.showMessage(i18n.def['saveSuccess'],action && action.done && action.done());
                }
            });
		}
	});
});
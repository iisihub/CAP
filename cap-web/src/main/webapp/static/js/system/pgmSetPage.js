pageInit(function(){
	$(document).ready(function(){
		var $form = $("#JForm");
		var code = reqJSON.pgmCode;
		var isNew = code? false:true;
		var changeCode = function(){
			var systyp = $form.find("#sysCode").find("option[showvalue='" + $form.find('#SYSTYP').val() + "']").attr('value');
			var type = $form.find('#step').val();
			var code = $form.find('#PGMCODE').val();
			$form.find('#PGM').html(systyp+type);
			$form.find('#code').val(systyp+type+code);
		}
		var getParentCode = function(value){
			$.ajax({
				url: 'webroot/pgmsethandler/loadPgm',
				data : {
						SYSTYP : $form.find('#sysTyp').val(),
						TYPE : $form.find('#step').val()-1
				},
				success : function(responseData) {
					var items = {};
					if ($form.find('#step').val() == '1'){
						items['0'] = i18n['pgmSetPage']['step0'];
					}else if (responseData.codeItem.length >0){
						var size = responseData.codeItem.length;
						for (var i=0;i<size;i++){
							var data = responseData.codeItem[i];
							items[data.code] = data.name;
						}
						data = responseData.codeItem[0];
					}else{
						items[''] = i18n['pgmSetPage']['noOption'];
					}
					$form.find('#parent').setOptions(items);
					value && $form.find('select[name=parent]').val(value);
				}//close success function
			});
		}
		var grid = $("#gridview").jqGrid({
			url: 'webroot/pgmsethandler/queryRle',
			height: "380", width: "100%", page: false,
			postData: { sysTyp : '', pgmCode: code },
            multiselect: false, hideMultiselect: false, autowidth: true, localFirst: true,
            colModel: [{
                header: i18n['pgmSetPage']['rolCode'],//"角色代碼",
                name: 'rolCode', align: "center", sortable: false
            },  {
                header: i18n['pgmSetPage']['rolName'],//"角色名稱",
                name: 'rolName', align: "left", sortable: true
            }]
        });
		function openEditWindow(isEdit, rowObject){
	        
		}
		if(code){
			$.ajax({
		        url:"webroot/pgmsethandler/queryForm",
		        data:{
		        	pgmCode: code
		        },
		        success:function(json){
		        	$form.injectData(json);
		        	$form.find('#sysTyp').attr('disabled', true);
					$form.find('#step').attr('disabled', true);
					$form.find('#PGMCODE').hide();
					$form.find('#PGM').html(json.code);
					getParentCode(json.parent);
					grid.jqGrid('setGridParam', {
                        postData: {
                        	sysTyp: json.sysTyp
                        }
                    });
                    grid.trigger("reloadGrid");
		        }
			});
		}else{
			$form.find('#sysTyp').attr('disabled', false);
			$form.find('#step').attr('disabled', false);
			$form.find('#PGMCODE').show();
			changeCode();
			getParentCode();
		}
		
		$form.find("#step,#systyp").change(function(){
			changeCode();
			getParentCode();
		}).end().find("#PGMCODE").blur(function(){
			changeCode();
		});
		
		$("#save_btn").click(function(){//新增
			$form.validationEngine('validate') &&
	        API.showConfirmMessage(i18n.def.actoin_001, function(data){
	            data &&
	            $.ajax({
	                url: "webroot/pgmsethandler/save",
	                data: $.extend($form.serializeData(),{
	                	roleItem: grid.serializeGridData(true),
	                	isNew:isNew
	                }),
	                success: function(rtn){
	                	isNew = false;
	                	API.triggerOpener();
	                	API.showMessage(i18n.def['saveSuccess']);
	                }
	            });
	        });
		});		
		$("#modify").click(function(){//修改
			var eDialog = $("#editRole").dialog({
	        	height: 200,width: 250,modal: true,
	        	open:function(){
	        		var form = eDialog.find("#mform");
	        		$.ajax({
                        url: "webroot/pgmsethandler/queryRole",
                        data : {
    						SYSTYP : $form.find('#sysTyp').val()
                        },
                        success: function(json){
                        	if(json.roles){
                        		for(var index in json.roles){
                        			var role = json.roles[index];
                        			form.append('<input type="checkbox" id="code' + role.ROLCODE + '" name="code' + role.ROLCODE + '" value="' + role.ROLCODE +'||'+ role.ROLNAME + '" />' + role.ROLNAME + '<br/>');
                        			//form.find("#code"+role.ROLCODE).attr('checked', role.SELECTED);
                        		}
                        		var data = grid.serializeGridData();
                        		for(var row in data){
                        			form.find("#code"+data[row].rolCode).attr('checked', true);
                        		}
                        	}
                        }
                    });
	        	},
	        	close:function(){
	        		eDialog.find("#mform").empty();
	        	},
	        	buttons:API.createJSON([{
	        		key:i18n.def.sure,
	        		value:function(){
	        			var mform = eDialog.find("#mform");
	        			var checkItem = new Array();
	        			
	        			grid.clearGridData(true);
	        			mform.find(":checked").each(function(){
	        				checkItem.push($(this).val().split('||'));
	        			});
	        			grid.addGridData(checkItem);
	        			eDialog.dialog('close');
//	        			var checkItem = new Array();
//	        			mform.find(":checked").each(function(){
//	        				return checkItem.push($(this).val());
//	        			});
//	        			$.ajax({
//	                        url: "webroot/pgmsethandler/modifyRle",
//	                        data: {
//	                        	
//	                        	role:checkItem
//	                        },
//	                        success: function(){
//	                            grid.trigger("reloadGrid");
//	                        }
//	                    });
	        		}
	        	},{
	        		key:i18n.def.close,
	        		value:function(){
	        			eDialog.dialog('close');
	        		}
	        	}])
	        });
			eDialog.dialog('open');
		});
	});
});
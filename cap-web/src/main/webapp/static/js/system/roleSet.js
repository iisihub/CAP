pageInit(function(){
	$(document).ready(function(){
		var mform = $("#mform");
		var grid = $("#gridview").jqGrid({
			url: 'webroot/rolesethandler/query',
			height: "380", width: "100%",
            multiselect: false, hideMultiselect: false, autowidth: true, localFirst: false,
            colModel: [{
                header: i18n['roleSet']['rolCode'],//"角色代碼",
                name: 'roleId', align: "left", width: 15, sortable: false
            },  {
                header: i18n['roleSet']['rolName'],//"角色名稱
                name: 'rolName', align: "left", width: 15, sortable: true
            },  {
                header: i18n['roleSet']['usrCount'],//"使用人員數
                name: 'usrCount', align: "center", width: 10, sortable: true
            },  {
                header: i18n['roleSet']['stu'],//"停用
                name: 'stu', align: "center", width: 5, sortable: true, formatter: function(val){
                    return i18n['roleSet']['stu.'+val];
                }
            },  {
                header: i18n['roleSet']['note'],//"停用原因
                name: 'note', align: "center", width: 15, sortable: true
            }],
            ondblClickRow: function(){
                openEditWindow(true);
            }
        });
		function openEditWindow(isEdit, rowObject){
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
	        }
			CommonAPI.formSubmit({
	            url: './system/roleSetPage',
	            data: {
	                rolCode: rowObject?rowObject.roleId:""
	            },
	            target: rowObject?rowObject.roleId:"_blank"//rowObject.oid
	        });
		}
		
		$(".btns").find("#add").click(function(){//新增
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
	                    	url: 'webroot/rolesethandler/delete',
	                        data: {
	                            rolCode: rowObject.roleId
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
	});
});
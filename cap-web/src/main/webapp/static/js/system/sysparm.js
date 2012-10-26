pageInit(function(){
	$(document).ready(function(){
		var mform = $("#mform");
		var grid = $("#gridview").jqGrid({
            url: 'webroot/sysparmhandler/query',
            sortname: 'parmId',height: 200,
            colModel: [{header: i18n['sysparm']['parmId'],//代碼
                name: 'parmId', width: 20,
            }, {header: i18n['sysparm']['parmValue'],//參數值
                name: 'parmValue',width: 30
            }, {header: i18n['sysparm']['parmDesc'],//說明
                name: 'parmDesc',width: 30,
            }, {header: i18n.def.lastModBy,
                name: 'lastModifyBy',width: 10,align: "center"
            }, {header: i18n.def.lastModTm,
                name: 'lastModifyTime',width: 10,align: "center"
            }],
            onSelectRow: function(){
                var ret = grid.getSelRowDatas();
                ret && mform.injectData(ret);
            }
        });
		
		$(".btns").find("#qry").click(function(){//查詢
			grid.jqGrid('setGridParam', {
                postData: {
                    parmId: mform.find("#parmId").val()
                }
            });
            grid.trigger("reloadGrid");
		}).end().find("#add,#modify").click(function(){//新增,修改
			mform.validationEngine('validate') &&
            API.showConfirmMessage(i18n.def.actoin_001, function(data){
                data &&
                $.ajax({
                    url: "webroot/sysparmhandler/modify",
                    data: mform.serializeData(),
                    success: function(){
                        grid.trigger("reloadGrid");
                    }
                });
            });
		}).end().find("#delete").click(function(){
			var ret = grid.getSelRowDatas();
			if (ret) {
                API.showConfirmMessage(i18n.def.actoin_001, function(data){
                    data &&
                    $.ajax({
                        url: "webroot/sysparmhandler/delete",
                        data: {
                            parmId: ret.parmId
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
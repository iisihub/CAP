pageInit(function(){
	$(document).ready(function(){
		var mform = $("#mform");
		var grid = $("#gridview").jqGrid({
			url: 'webroot/auditDatahandler/query',
            height: "380",
            width: "100%",
            multiselect: false,
            hideMultiselect: false,
            autowidth: true,
            localFirst: true,
            colModel: [{
                header: i18n['auditData']['sno'],//"序號",
                name: 'sno',
                align: 'left',
                width: 100,
                sortable: false,
                formatter: 'click',
                onclick: openDetail
            },{
                header: i18n['auditData']['startTime'],//"記錄起日",
                name: 'startTime',
                align: 'left',
                width: 150,
                sortable: false
            },  {
                header: i18n['auditData']['endTime'],//"記錄迄日",
                name: 'endTime',
                align: 'left',
                width: 150,
                sortable: false
           },  {
                header: i18n['auditData']['time'],//"執行時間",
                name: 'cost',
                align: 'right',
                width: 60,
                sortable: false
            },  {
                header: i18n['auditData']['invokeResult'],//"執行結果碼",
                name: 'invokeResult',
                align: 'center',
                width: 70,
                sortable: false
            },  {
                header: i18n['auditData']['txId'],//"交易代碼",
                name: 'txid',
                align: 'left',
                width: 110,
                sortable: false
            },  {
                header: i18n['auditData']['sys'],//"系統代碼",
                name: 'sysId',
                align: 'center',
                width: 80,
                sortable: false
            }],
            ondblClickRow: function(){
                openDetailWindow();
            }
        });
		
		function openDetailWindow(rowObject){
	        var html = '';
	        if (!rowObject) {
	            var id = grid.jqGrid('getGridParam', 'selrow');
	            if (id) {
	                rowObject = grid.jqGrid('getRowData', id);
	            }
	            else {
	            	API.showConfirmMessage(i18n.def['selectd.msg']);
	            }
	        }
	        
	        $.ajax({
	        	url: 'webroot/auditDatahandler/queryAuditData',
	            data: {
	                logSno: rowObject.sno,
	                sysId: rowObject.sysId
	            },
	            success: function(responseData){
	                var outHtml = '';
	                var inHtml = '';
	                var inData = responseData.inData.split('|');
	                var outData = responseData.outData.split('|');
	                
	                for (i = 0; i < inData.length; i++) {
	                    $('#dataIn').find('#data').html(replaceEscChar(inData[i]));
	                    inHtml += $('#dataIn').html();
	                }
	                
	                for (i = 0; i < outData.length; i++) {
	                    $('#dataOut').find('#data').html(replaceEscChar(outData[i]));
	                    outHtml += $('#dataOut').html();
	                }
	                $('#logData').html(inHtml + outHtml);
	                
	                dDialog.dialog('open');
	            }
	        });
	    }
		
		function openDetail(cellvalue, options, rowObject){
	        openDetailWindow(rowObject);
	    }
		
		function replaceEscChar(str){
	        return str.replace(/｛/g, "{").replace(/｝/g, "}").replace(/〔/g, "[").replace(/〕/g, "]").replace(/＜/g, "<").replace(/＞/g, ">").replace(/｜/g, "|");
	    }
		
		var qDialog = $("#SEARCH"),dDialog = $("#DETAIL");
        qDialog.dialog({
        	width : 600,
			height : 220,modal: true,
        	buttons:API.createJSON([{
        		key:i18n.def.sure,
        		value:function(){
        			grid.jqGrid('setGridParam', {
                        postData: qDialog.find("#searchForm").serializeData()
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
        qDialog.dialog('open');
        
        dDialog.dialog({
        	width : 600,
			height : 400,modal: true,
        	buttons:API.createJSON([{
        		key:i18n.def.sure,
        		value:function(){
        			dDialog.dialog('close');
        		}
        	}])
        });
		$(".btns").find("#qry").click(function(){//查詢
			qDialog.dialog('open');
		}).end().find("#detail").click(function(){//查詢
			openDetailWindow();
		});
	});
});
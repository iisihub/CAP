pageInit(function(){
	$(document).ready(function(){
//		debugger;
		var _mainOid = reqJSON.mainOid;
		var _factorNo = reqJSON.factorNo;
		var mform = $("#mform");
		$.ajax({
	        url:"webroot/factorMnthandler/query",
	        data:{
	        	mainOid: _mainOid,
                factorNo: _factorNo,
	        },
	        success:function(json){
	        	mform.injectData(json);
	        	ftDtlGrid.jqGrid('setGridParam', {
	                postData: {
	                	factorNo:mform.find("#factorNo").val()
	                }
	            });
	        	ftDtlGrid.trigger("reloadGrid");
	        }
		});

		var ftDtlGrid = $("#ftDtlGrid").jqGrid({
			url: 'webroot/factorMntGridhandler/queryFactorDtlGridByFactorNo',
			height : 150,
			autowidth: true,
			localFirst : true,
//			needPager : true,
//			multiselect: true,
			postData:{factorNo:$("#factorNo").val()},
			colModel : [ { colHeader : "值域註解", name : "rangeNm", align: "left", width: 20 }
			, { colHeader : "值域一", name : "range1", align: "left", width: 10 }
			, { colHeader : "值域二", name : "range2", align: "left", width: 10 }
			, { colHeader : "順序", name : "rangesor", align: "left", width: 10, hidden:true }
			]
		});
//		.addGridData([
//			['逾期天數  1 ~ 30','1','30','1'],
//			['逾期天數 31 ~ 60','31','60','2'],
//			['逾期天數 61 ~ 90','61','90','3'],
//			['逾期天數 91 ~180','91','180','4'],
//			['逾期天數 181~','181','999999','5']
//		]);
	
		mform.find("#mod_btn").click(function() {
			//open dialog
			var test = $("#dataType").val();
			if(test=="3"){
				$("#edit_dialog").find(".ftType1").hide();
				$("#edit_dialog").find(".ftType2").show();
			}else{
				$("#edit_dialog").find(".ftType1").show();
				$("#edit_dialog").find(".ftType2").hide();
			}
			fDialog.dialog('open');
		}).end().find("#new_btn").click(function() {
			//open dialog
			var test = $("#dataType").val();
			if(test=="3"){
				$("#edit_dialog").find(".ftType1").hide();
				$("#edit_dialog").find(".ftType2").show();
			}else{
				$("#edit_dialog").find(".ftType1").show();
				$("#edit_dialog").find(".ftType2").hide();
			}
			fDialog.dialog('open');
		}).end().find("#del_btn").click(function(){
			ftDtlGrid.removeSelected();
		});
		$("#save_btn").click(function(){
			var xxxData = ftDtlGrid.serializeGridData();
			var ary = new Array(xxxData.length);
			var datas = $.extend({}, mform.serializeData());
//			debugger;
			for(var i = 0; i<ary.length ; i++){
				ary[i] = JSON.stringify(xxxData[i]);
			}
			var gridData = {grid : ary};
			$.extend(datas, gridData);
			/**儲存 連後端儲存*/
			$.ajax({
				url : "webroot/factorMnthandler/saveFactorDtl",
				data : datas,
				success : function(json) {
//					ftDtlGrid.jqGrid('setGridParam', {
//		                postData: {
//		                	factorNo:mform.find("#factorNo").val()
//		                }
//		            });
//					ftDtlGrid.trigger("reloadGrid");
					CommonAPI.showPopMessage("儲存因子資料完成");
				}
			});
		});
		

		var fDialog = $("#edit_dialog");
		fDialog.dialog({
        	height: 250,width: 650,modal: true,
        	close:function(){
        		fDialog.find("#facform").reset();
        	},
        	buttons:API.createJSON([{
        		key:i18n.def.sure,
        		value:function(){
//        			debugger;
        			var facform = fDialog.find("#facform");
        			var ftDtlGridRecords = ftDtlGrid.getGridParam("records");
        			var rowData = {};
        			if(facform.find("#range1").val() && facform.find("#range2").val()){        				
        				rowData = {
    						rangeNm:mform.find("#factorNm").val()+" "
    						+facform.find("#range1").val()+"~"+facform.find("#range2").val()
    						,range1 : facform.find("#range1").val()
    						,range2 : facform.find("#range2").val()
        				};
        			}else if(facform.find("#range1").val()){
        				rowData = {
    						rangeNm:mform.find("#factorNm").val()+" "+facform.find("#range1").val()
    						,range1 : facform.find("#range1").val()
    						,range2 : facform.find("#range2").val()
        				};
        			}else if(facform.find("#ftTypeBlnSel").val()){
        				var selVal = "(否)";
        				if(facform.find("#ftTypeBlnSel").val()=="true"){
        					selVal = "(是)";
        				}
        				rowData = {
        						rangeNm:mform.find("#factorNm").val()+""+selVal
        						,range1 : facform.find("#ftTypeBlnSel").val()
            				};
        			}
        			facform.validationEngine('validate') &&
        			ftDtlGrid.addRowData(parseInt(ftDtlGridRecords)+1, rowData);
        			fDialog.dialog('close');
        		}
        	},{
        		key:i18n.def.close,
        		value:function(){
        			fDialog.dialog('close');
        		}
        	}])
        });
		
	});
});
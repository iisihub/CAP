pageInit(function(){
	$(document).ready(function(){
		var ftRsGrid = $("#ftRsGrid").jqGrid({
            height: "380",
            width: "100%",
            rownumbers: true,
            multiselect: false,
            hideMultiselect: false,
            autowidth: true,
            localFirst: true,
			colModel : [ {
				header : "條件項目",
				name : "name1",
				align : "left",
				width : 10
			}, {
				header : "條件值域",
				name : "name2",
				align : "left",
				width : 40
			}, {
				header : "是否為動作",
				name : "name3",
				align : "left",
				width : 5
			}, {
				header : "排序",
				name : "name4",
				align : "left",
				width : 5
			} ]
		}).addGridData(
				[
						[ '產品項目', '信貸,信用卡', '否' ],
						[ '逾期天數', '逾期天數  1 ~ 30,逾期天數 31 ~ 60',
								'否', '' ],
						[ '催收人員', '王小一,王小二,王小三,王小四,王小五', '否' ],
						[ '分派組別', '電催組', '是' ] ]);
		
		var ftDtlGrid = $("#ftDtlGrid").jqGrid({
			height : 100,
			localFirst : true,
			needPager : false,
//			multiselect : true,
			colModel : [ {
				header : "值域選項",
				name : "name1",
				align : "left",
				width : 20
			} ]
		}).addGridData(
				[ [ '逾期天數  1 ~ 30' ], [ '逾期天數 31 ~ 60' ],
						[ '逾期天數 61 ~ 90' ], [ '逾期天數 91 ~180' ],
						[ '逾期天數 181~' ] ]);
	
		$("#new_btn1").click(function() {
			//open dialog
			$("#edit_dialog1").thickbox({
				modal : false,
				height : 280,
				width : 600,
				buttons : {
					"確定" : function() {
						$.thickbox.close()
					},
					"取消" : function() {
						$.thickbox.close()
					}
				}
			});
		});

		$("#edit_btn1").click(function() {
			//open dialog
			$("#edit_dialog1").thickbox({
				modal : false,
				height : 280,
				width : 600,
				buttons : {
					"確定" : function() {
						$.thickbox.close()
					},
					"取消" : function() {
						$.thickbox.close()
					}
				}
			});
		});

		$("#assign_btn").click(function() {
			//open dialog
			$("#edit_dialog2").thickbox({
				modal : false,
				height : 280,
				width : 600,
				buttons : {
					"確定" : function() {
						$.thickbox.close()
					},
					"取消" : function() {
						$.thickbox.close()
					}
				}
			});
		});

	});
});
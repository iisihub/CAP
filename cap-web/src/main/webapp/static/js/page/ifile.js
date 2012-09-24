$(document).ready(function(){
	$("#upload").click(function(){
    	$.capFileUpload({
	        url: "../handler/samplehandler/upload",
	        fileElementId: "ufile",
	        fileCheck: ["jpg", "jpeg", "png", "gif", "txt"],
	        data: {
	            testStr: "test!!test!!"
	        },
	        success: function(data){
	            showMess(data.mktMatlType, data.mktMatl, $("#showMessage"), data.size);
	        }
	    });
	});
	$("#dwnload").click(function(){
		$.capFileDownload({
			url:"../handler/samplehandler/dwnload",
			data:{
				fileName : "我是log.log"
			}
		});
	});
});
$(document).ready(function(){
	$("#upload").click(function(){
    	$.capFileUpload({
	        url: "webroot/basehandler/upload",
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
});
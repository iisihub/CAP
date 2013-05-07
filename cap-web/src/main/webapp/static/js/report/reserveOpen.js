$(document).ready(function(){
	var mform = $("#mform");
	$("#sendData").click(function(){
		mform.validationEngine('validate') &&
        API.showConfirmMessage("是否确定送出", function(data){
            data &&
            $.ajax({
                url: "webroot/reservehandler/openAcc",
                data: mform.serializeData(),
                success: function(){
                    API.showPopMessage("已收到您的申请！");
                }
            });
        });
	});
});
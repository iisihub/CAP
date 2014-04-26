pageInit(function() {
    $(document).ready(function() {
	window.setCloseConfirm(false);
	$('#submit').click(function() {
	    $.ajax({
		url : "../j_spring_security_check",
		dataType : 'html',
		data : {
		    j_username : $('#j_username').val(),
		    j_password : $('#j_password').val(),
		    captcha : $('#captcha').val(),
		    newPwd : $('#newPwd').val(),
		    confirm : $('#confirm').val()
		},
		success : function() {
		    API.formSubmit({
			url : 'index'
		    });
		},
		error : function(jqXHR, status, errorThrown) {
		    console.log('status: ' + status);
		    console.log('text: ' + jqXHR.responseText);
		    var result = $.parseJSON(errorThrown);
		    console.log('msg: ' + result.msg);
		    console.log('capchaEnabled: ' + result.capchaEnabled);
		    console.log('firstLogin: ' + result.firstLogin);
		    result.firstLogin ? $('#pwdchgArea').show() : $('#pwdchgArea').hide();
		    result.capchaEnabled ? $('#captchaArea').show() : $('#captchaArea').hide();
		    API.showErrorMessage(result.msg);
		},
		complete : function(jqXHR, status) {
		    $("#captcha").trigger("refresh");
		    $('#j_username').val("");
		    $('#j_password').val("");
		    $('#newPwd').val("");
		    $('#confirm').val("");
		}
	    });
	});
    });
});
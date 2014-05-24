pageInit(function() {
  $(document).ready(function() {
    $('#change').click(function() {
      $.ajax({
        url : "webroot/usershandler/changePassword",
        data : $('#mform').serializeData(),
        success : function() {
          API.showMessage('', i18n.pwdchange.changePwdOk, function() {
            $('#mform').reset();
          });
        }
      });
    });
    $('#clear').click(function() {
      $('#mform').reset();
    });
  });
});
